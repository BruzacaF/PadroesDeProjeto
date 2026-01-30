package br.edu.ifpb.pps;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.TemplateMethod.TemplateCriacaoAnuncio;
import br.edu.ifpb.pps.Anuncio.TemplateMethod.templates.TemplateCustomizado;
import br.edu.ifpb.pps.Anuncio.TemplateMethod.templates.TemplatePadrao;
import br.edu.ifpb.pps.Anuncio.Visitor.FiltroHandler;
import br.edu.ifpb.pps.Anuncio.Visitor.Filtros.FiltroPrecoHandler;
import br.edu.ifpb.pps.Anuncio.Visitor.Filtros.FiltroQuintalHandler;
import br.edu.ifpb.pps.Enums.ImovelTipo;
import br.edu.ifpb.pps.Enums.TipoAnuncio;
import br.edu.ifpb.pps.Factory.ImovelFactoryConcreta;
import br.edu.ifpb.pps.Suporte.MotorBusca;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.CatalogoGlobalPrototipos;
import br.edu.ifpb.pps.imovel.Imovel;
import br.edu.ifpb.pps.imovel.builder.tiposBuilder.ApartamentoBuilder;
import br.edu.ifpb.pps.imovel.builder.tiposBuilder.CasaBuilder;
import br.edu.ifpb.pps.imovel.builder.tiposBuilder.TerrenoBuilder;
import br.edu.ifpb.pps.imovel.templateMethod.templates.ConstrutorPrototipoClone;
import br.edu.ifpb.pps.imovel.templateMethod.templates.ConstrutorPrototipoNovo;
import br.edu.ifpb.pps.repository.AnuncioRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Anunciante usuario = new Anunciante("Filipe");
        AnuncioRepository repo = AnuncioRepository.getInstancia();

        // Casas
        repo.salvar(new Anuncio("Casa Quintal 3Q", new CasaBuilder().titulo("Casa Quintal 3Q").preco(300000).usuario(usuario).quintal(true).build(), usuario));
        repo.salvar(new Anuncio("Casa Sem Quintal 2Q", new CasaBuilder().titulo("Casa Sem Quintal 2Q").preco(250000).usuario(usuario).quintal(false).build(), usuario));

        // Apartamentos
        repo.salvar(new Anuncio("Ap 2Q Andar 2", new ApartamentoBuilder().titulo("Ap 2Q Andar 2").preco(200000).usuario(usuario).andar(2).elevador(true).build(), usuario));
        repo.salvar(new Anuncio("Ap 3Q Andar 5", new ApartamentoBuilder().titulo("Ap 3Q Andar 5").preco(350000).usuario(usuario).andar(5).elevador(true).build(), usuario));
        repo.salvar(new Anuncio("Ap 1Q Andar 1", new ApartamentoBuilder().titulo("Ap 1Q Andar 1").preco(150000).usuario(usuario).andar(1).elevador(false).build(), usuario));

        // Terrenos
        repo.salvar(new Anuncio("Terreno 500m2", new TerrenoBuilder().titulo("Terreno 500m2").preco(180000).usuario(usuario).area(500).build(), usuario));
        repo.salvar(new Anuncio("Terreno 1000m2", new TerrenoBuilder().titulo("Terreno 1000m2").preco(400000).usuario(usuario).area(1000).build(), usuario));

        // Extra
        repo.salvar(new Anuncio("Casa Luxo 4Q", new CasaBuilder().titulo("Casa Luxo 4Q").preco(800000).usuario(usuario).quintal(true).build(), usuario));


        MotorBusca buscador = new MotorBusca();
        FiltroHandler preco = new FiltroPrecoHandler(150000, 350000);
        FiltroHandler quintal = new FiltroQuintalHandler();
        preco.encadear(quintal); // cadeia: preço -> quintal

        List<Anuncio> resultado = buscador.buscar(repo.listarTodos(), preco);

        System.out.println("Resultados da busca avançada:");
        resultado.forEach(Anuncio::imprimirBanner);
    }



    }

