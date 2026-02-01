package br.edu.ifpb.pps.Anuncio;

import br.edu.ifpb.pps.Enums.EstadoAnuncioEnum;

public abstract class EstadoAnuncio {
    public Anuncio anuncioContext;
    public EstadoAnuncioEnum estadoAnuncioEnum;

    protected void setAnuncioContext(Anuncio anuncio){
        this.anuncioContext = anuncio;
    }

    protected void setEstadoAnuncioEnum(EstadoAnuncioEnum estadoAnuncioEnum){
        this.estadoAnuncioEnum = estadoAnuncioEnum;
    }

    public EstadoAnuncioEnum getEstadoAnuncioEnum() {
        return estadoAnuncioEnum;
    }

    protected abstract void aprovar();
    protected abstract void reprovar();
    protected abstract void publicar();
    protected abstract void vender();
    protected abstract void suspender();
}