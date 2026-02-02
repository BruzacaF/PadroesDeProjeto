package br.edu.ifpb.pps.Anuncio.Estados;

import br.edu.ifpb.pps.Anuncio.EstadoAnuncio;
import br.edu.ifpb.pps.Enums.EstadoAnuncioEnum;

public class Vendido extends EstadoAnuncio {

    public Vendido() {
        super.setEstadoAnuncioEnum(EstadoAnuncioEnum.VENDIDO);
    }

    public void aprovar() {}
    public void reprovar() {}
    public void publicar() {}
    public void vender() {}
    public void suspender() {}
}