package br.edu.ifpb.pps.Anuncio.TemplateMethod.templates;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.TemplateMethod.TemplateCriacaoAnuncio;
import br.edu.ifpb.pps.Enums.TipoAnuncio;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.CatalogoPrototiposImovel;
import br.edu.ifpb.pps.imovel.Imovel;

public class TemplateCustomizado extends TemplateCriacaoAnuncio {
    private final String chaveImovel;
    private final TipoAnuncio tipoAnuncio;

    public TemplateCustomizado(String chaveImovel, TipoAnuncio tipoAnuncio) {
        this.chaveImovel = chaveImovel;
        this.tipoAnuncio = tipoAnuncio;
    }

    @Override
    protected void coletarDadosObrigatorios() {
        System.out.println("Coletando dados obrigatórios do anunciante...");
    }

    @Override
    protected Imovel coletarImovel(Anunciante anunciante) {
        CatalogoPrototiposImovel catalogo = anunciante.getCatalogo();
        catalogo.listarBonito(); // oferta protótipos pessoais
        return catalogo.obter(chaveImovel);
    }

    @Override
    protected TipoAnuncio coletarTipoAnuncio() {
        return tipoAnuncio;
    }

    @Override
    protected Anuncio construirAnuncio(Anunciante anunciante, Imovel imovel, TipoAnuncio tipoAnuncio) {
        return new Anuncio(imovel.titulo + " - " + tipoAnuncio, imovel, anunciante);
    }

}