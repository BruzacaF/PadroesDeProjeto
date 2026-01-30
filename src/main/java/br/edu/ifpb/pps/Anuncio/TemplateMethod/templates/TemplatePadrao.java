package br.edu.ifpb.pps.Anuncio.TemplateMethod.templates;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.TemplateMethod.TemplateCriacaoAnuncio;
import br.edu.ifpb.pps.Enums.TipoAnuncio;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.CatalogoGlobalPrototipos;
import br.edu.ifpb.pps.imovel.Imovel;

public class TemplatePadrao extends TemplateCriacaoAnuncio {
    @Override
    protected void coletarDadosObrigatorios() {
        System.out.println("Usando dados padrão pré-configurados...");
    }

    @Override
    protected Imovel coletarImovel(Anunciante anunciante) {
        CatalogoGlobalPrototipos global = CatalogoGlobalPrototipos.getInstancia();
        global.listarBonito(); // oferta protótipos globais
        return global.obterClone("apartamento_padrao"); // exemplo
    }

    @Override
    protected TipoAnuncio coletarTipoAnuncio() {
        return TipoAnuncio.VENDA; // padrão inicial
    }

    @Override
    protected Anuncio construirAnuncio(Anunciante anunciante, Imovel imovel, TipoAnuncio tipoAnuncio) {
        return new Anuncio(imovel.titulo + " - " + tipoAnuncio, imovel, anunciante);
    }

}