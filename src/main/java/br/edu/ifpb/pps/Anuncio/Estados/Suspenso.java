package br.edu.ifpb.pps.Anuncio.Estados;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.EstadoAnuncio;
import br.edu.ifpb.pps.Enums.EstadoAnuncioEnum;

public class Suspenso extends EstadoAnuncio {

    public Suspenso() {
        super.setEstadoAnuncioEnum(EstadoAnuncioEnum.SUSPENSO);
        super.anuncioContext.setEstado(new Rascunho());
    }

    public void aprovar() {}
    public void reprovar() {}
    public void publicar() {}
    public void vender() {}
    public void suspender() {}
}