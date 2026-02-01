package br.edu.ifpb.pps;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.Decorator.Filtro;
import br.edu.ifpb.pps.Anuncio.Decorator.FiltroBase;
import br.edu.ifpb.pps.Anuncio.Decorator.Filtros.FiltroPreco;
import br.edu.ifpb.pps.Anuncio.Visitor.AnuncioVisitor;
import br.edu.ifpb.pps.Anuncio.Visitor.ExportadorJSON;
import br.edu.ifpb.pps.Anuncio.Visitor.ExportadorPDF;
import br.edu.ifpb.pps.Anuncio.Visitor.RelatorioEstatistico;
import br.edu.ifpb.pps.Enums.ImovelTipo;
import br.edu.ifpb.pps.Notificacao.NotificacaoObserver;
import br.edu.ifpb.pps.Notificacao.tiposNotificacao.NotificacaoEmailStrategy;
import br.edu.ifpb.pps.Notificacao.tiposNotificacao.NotificacaoWhatsAppStrategy;
import br.edu.ifpb.pps.Notificacao.tiposNotificacao.TipoNotificacao;
import br.edu.ifpb.pps.Suporte.MotorBusca;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.DadosImovel;
import br.edu.ifpb.pps.imovel.Imovel;
import br.edu.ifpb.pps.imovel.templateMethod.PrototipoTemplateImovel;
import br.edu.ifpb.pps.imovel.templateMethod.templates.ClonarPrototipoGlobal;
import br.edu.ifpb.pps.imovel.templateMethod.templates.CriarPrototipoDoZero;
import br.edu.ifpb.pps.repository.AnuncioRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // ===== 1) Criar um anunciante =====
        Anunciante usuario = new Anunciante("Filipe");

        // ===== 2) Criar protótipo do zero (BUILDER) =====
        DadosImovel dadosAp = new DadosImovel();
        dadosAp.setTitulo("Imovel1 Modelo");
        dadosAp.setArea(70.0);
        dadosAp.setEndereco("Rua A, 123");
        dadosAp.setQuartos(2);
        dadosAp.setBanheiros(1);
        dadosAp.setVagasGaragem(1);
        dadosAp.setDescricao("Protótipo criado com Builder");
        dadosAp.setAndar(5);
        dadosAp.setElevador(true);
        dadosAp.setTaxaCondominio(300.0);

        PrototipoTemplateImovel fluxoBuilder = new CriarPrototipoDoZero(ImovelTipo.APARTAMENTO);

        Imovel prototipoAp = fluxoBuilder.executarFluxo(usuario, "Imovel1", dadosAp);



        // ===== 4) Clonar protótipo global (PROTOTYPE) =====
        DadosImovel dadosExtras = new DadosImovel();
        dadosExtras.setTitulo("Casa Personalizado");
        dadosExtras.setEndereco("Rua B, 456"); // altera o endereço

        PrototipoTemplateImovel fluxoClone = new ClonarPrototipoGlobal("casa_padrao");

        Imovel apClonado = fluxoClone.executarFluxo(usuario, "Casa clonada", dadosExtras);



        Anuncio anuncioOriginal = new Anuncio("Anuncio Original", "Anuncio criado com o imovel Original", prototipoAp, usuario, 2000.0);
        Anuncio anuncioClone = new Anuncio("Anuncio Clone", "Anuncio criado com o imovel Clone", apClonado, usuario, 100.0);

        // Inicio - 5) Observer + Strategy
        
        // Criar observers
        NotificacaoObserver observerEmail = new NotificacaoObserver() {};
        NotificacaoObserver observerMultiplo = new NotificacaoObserver() {};
        
        // Adicionar strategies ao primeiro observer (apenas email)
        observerEmail.adicionarStrategy(
            TipoNotificacao.EMAIL,
            new NotificacaoEmailStrategy("lima.julielison@academico.ifpb.edu.br")
        );
        
        // Adicionar strategies ao segundo observer (email + whatsapp)
        observerMultiplo.adicionarStrategy(
            TipoNotificacao.EMAIL, 
            new NotificacaoEmailStrategy("moderador@email.com")
        );
        observerMultiplo.adicionarStrategy(
            TipoNotificacao.WHATSAPP, 
            new NotificacaoWhatsAppStrategy("+55 83 99999-9999")
        );
        
        // Registrar observers no anúncio
        anuncioOriginal.adicionarObserver(observerEmail);
        anuncioOriginal.adicionarObserver(observerMultiplo);
        
        System.out.println("\n=== Testando notificações com 2 observers ===");
        anuncioOriginal.publicar();
        
        // Remover strategy de WhatsApp do segundo observer
        System.out.println("\n=== Removendo WhatsApp do observer múltiplo ===");
        observerMultiplo.removerStrategy(TipoNotificacao.WHATSAPP);
        
        anuncioOriginal.aprovar();
        
        System.out.println("\n=== Adicionando WhatsApp novamente ===");
        observerMultiplo.adicionarStrategy(
            TipoNotificacao.WHATSAPP, 
            new NotificacaoWhatsAppStrategy("+55 83 88888-8888")
        );
        
        anuncioOriginal.publicar();

        // Fim - 5)


        AnuncioRepository repo = AnuncioRepository.getInstancia();
        repo.salvar(anuncioOriginal);
        repo.salvar(anuncioClone);
        List<Anuncio> anuncios2 = repo.listarTodos();
        for  (Anuncio anuncio : anuncios2) {
            System.out.println(anuncio.getTitulo());
        }
        Filtro filtro = new FiltroPreco(new FiltroBase(), 1000.0,150000.0);
        List<Anuncio> anuncios = MotorBusca.getInstancia().buscar(repo.listarTodos() , filtro);
        for (Anuncio anuncio : anuncios) {
            System.out.println(anuncio.getTitulo());
        }

        // ===== 8) Demonstração do Visitor Pattern =====
        System.out.println("\n\n=== DEMONSTRAÇÃO DO PADRÃO VISITOR ===\n");
        
        // Criar mais alguns anúncios para os relatórios
        DadosImovel dadosCasa2 = new DadosImovel();
        dadosCasa2.setTitulo("Casa de Praia");
        dadosCasa2.setArea(150.0);
        dadosCasa2.setEndereco("Praia do Litoral, 789");
        dadosCasa2.setQuartos(3);
        dadosCasa2.setBanheiros(2);
        dadosCasa2.setVagasGaragem(2);
        dadosCasa2.setDescricao("Casa de praia com vista para o mar");
        
        PrototipoTemplateImovel fluxoCasa2 = new ClonarPrototipoGlobal("casa_padrao");
        Imovel casa2 = fluxoCasa2.executarFluxo(usuario, "Casa2", dadosCasa2);
        Anuncio anuncioCasa2 = new Anuncio("Casa de Praia", "Linda casa com vista para o mar", casa2, usuario, 580000.0);
        repo.salvar(anuncioCasa2);
        
        // Obter todos os anúncios
        List<Anuncio> todosAnuncios = repo.listarTodos();
        
        // Visitor 1: Exportar para JSON
        System.out.println("📄 EXPORTANDO PARA JSON:");
        System.out.println("─────────────────────────────────────");
        AnuncioVisitor exportadorJSON = new ExportadorJSON();
        for (Anuncio anuncio : todosAnuncios) {
            anuncio.accept(exportadorJSON);
        }
        System.out.println(exportadorJSON.obterResultado());
        
        // Visitor 2: Exportar para PDF
        System.out.println("\n\n📄 EXPORTANDO PARA PDF:");
        System.out.println("─────────────────────────────────────");
        AnuncioVisitor exportadorPDF = new ExportadorPDF();
        for (Anuncio anuncio : todosAnuncios) {
            anuncio.accept(exportadorPDF);
        }
        System.out.println(exportadorPDF.obterResultado());
        
        // Visitor 3: Gerar Relatório Estatístico
        System.out.println("\n");
        AnuncioVisitor relatorioEstatistico = new RelatorioEstatistico();
        for (Anuncio anuncio : todosAnuncios) {
            anuncio.accept(relatorioEstatistico);
        }
        System.out.println(relatorioEstatistico.obterResultado());


    }
}
