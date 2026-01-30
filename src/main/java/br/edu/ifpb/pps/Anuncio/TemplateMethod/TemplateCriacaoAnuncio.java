package br.edu.ifpb.pps.Anuncio.TemplateMethod;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Enums.TipoAnuncio;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.Imovel;

public abstract class TemplateCriacaoAnuncio {
    public final Anuncio criarAnuncio(Anunciante anunciante) {
        validarAnunciante(anunciante);
        coletarDadosObrigatorios();
        Imovel imovel = coletarImovel(anunciante);   // imóvel vem do catálogo global ou pessoal
        TipoAnuncio tipoAnuncio = coletarTipoAnuncio(); // venda, aluguel, temporada
        Anuncio anuncio = construirAnuncio(anunciante, imovel, tipoAnuncio);
        posCriacao(anuncio);
        return anuncio;
    }

    protected void validarAnunciante(Anunciante anunciante) {
        if (anunciante == null) throw new IllegalArgumentException("Anunciante inválido");
    }

    protected abstract void coletarDadosObrigatorios();
    protected abstract Imovel coletarImovel(Anunciante anunciante);
    protected abstract TipoAnuncio coletarTipoAnuncio();
    protected abstract Anuncio construirAnuncio(Anunciante anunciante, Imovel imovel, TipoAnuncio tipoAnuncio);

    protected void posCriacao(Anuncio anuncio) {
        anuncio.notificar("Anúncio criado com sucesso!");
    }

}