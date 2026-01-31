package br.edu.ifpb.pps.imovel;
import br.edu.ifpb.pps.Enums.ImovelTipo;
import br.edu.ifpb.pps.imovel.builder.ImovelBuilder;
import br.edu.ifpb.pps.imovel.builder.ImovelDirector;
import br.edu.ifpb.pps.imovel.builder.tiposBuilder.ApartamentoBuilder;
import br.edu.ifpb.pps.imovel.builder.tiposBuilder.CasaBuilder;

import java.util.HashMap;
import java.util.Map;

public class CatalogoGlobalPrototipos {

    private static CatalogoGlobalPrototipos instancia;
    private final Map<String, Imovel> prototiposBase = new HashMap<>();

    private CatalogoGlobalPrototipos() {

        // === APARTAMENTO PADRÃO ===
        DadosImovel dadosApartamento = new DadosImovel();
        dadosApartamento.setTitulo("Apartamento Padrão");
        dadosApartamento.setArea(60.0);
        dadosApartamento.setEndereco("Endereço padrão AP");
        dadosApartamento.setQuartos(2);
        dadosApartamento.setBanheiros(1);
        dadosApartamento.setVagasGaragem(1);
        dadosApartamento.setDescricao("Protótipo de apartamento");

        // específicos de apartamento
        dadosApartamento.setAndar(3);
        dadosApartamento.setElevador(true);
        dadosApartamento.setTaxaCondominio(350.0);

        ImovelBuilder apBuilder = new ApartamentoBuilder();
        ImovelDirector apDirector = new ImovelDirector(apBuilder);

        Imovel apartamentoPadrao = apDirector.construirImovel(
                dadosApartamento,
                null, // usuário null porque é protótipo
                ImovelTipo.APARTAMENTO
        );

        registrar("apartamento_padrao", apartamentoPadrao);

        // === CASA PADRÃO ===
        DadosImovel dadosCasa = new DadosImovel();
        dadosCasa.setTitulo("Casa Padrão");
        dadosCasa.setArea(120.0);
        dadosCasa.setEndereco("Endereço padrão Casa");
        dadosCasa.setQuartos(3);
        dadosCasa.setBanheiros(2);
        dadosCasa.setVagasGaragem(2);
        dadosCasa.setDescricao("Protótipo de casa");

        // específicos de casa
        dadosCasa.setPiscina(false);
        dadosCasa.setQuintal(true);

        ImovelBuilder casaBuilder = new CasaBuilder();
        ImovelDirector casaDirector = new ImovelDirector(casaBuilder);

        Imovel casaPadrao = casaDirector.construirImovel(
                dadosCasa,
                null,
                ImovelTipo.CASA
        );

        registrar("casa_padrao", casaPadrao);
    }

    public static CatalogoGlobalPrototipos getInstancia() {
        if (instancia == null) {
            instancia = new CatalogoGlobalPrototipos();
        }
        return instancia;
    }

    public void registrar(String nome, Imovel imovel) {
        prototiposBase.put(nome.toLowerCase(), imovel);
    }

    public Imovel obterClone(String nome) {
        Imovel base = prototiposBase.get(nome.toLowerCase());
        if (base == null) {
            throw new IllegalArgumentException("Protótipo global não encontrado: " + nome);
        }
        return base.clonar();
    }

    public void listarBonito() {
        prototiposBase.forEach((chave, imovel) -> {
            System.out.println("Protótipo global: " + chave +
                    " | Tipo: " + imovel.getTipo() +
                    " | Título: " + imovel.getTitulo());
        });
    }
}
