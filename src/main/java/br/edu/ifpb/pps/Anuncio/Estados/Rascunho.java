package br.edu.ifpb.pps.Anuncio.Estados;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.EstadoAnuncio;
import br.edu.ifpb.pps.Anuncio.Moderador;
import br.edu.ifpb.pps.Enums.EstadoAnuncioEnum;

public class Rascunho extends EstadoAnuncio {

    public Rascunho() {
        this.setEstadoAnuncioEnum(EstadoAnuncioEnum.RASCUNHO);
    }

    @Override
    public void publicar() {
        Moderacao estadoAnuncio = new Moderacao();
        super.anuncioContext.setEstado(estadoAnuncio);
        estadoAnuncio.checagemAutomatica();
    }

    public void aprovar() {}
    public void reprovar() {}
    public void vender() {}
    public void suspender() {}
}