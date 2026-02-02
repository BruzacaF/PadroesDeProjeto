package br.edu.ifpb.pps.Anuncio.Estados;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.EstadoAnuncio;
import br.edu.ifpb.pps.Enums.EstadoAnuncioEnum;
import br.edu.ifpb.pps.repository.AnuncioRepository;

public class Ativo extends EstadoAnuncio {

    public Ativo() {
        super.setEstadoAnuncioEnum(EstadoAnuncioEnum.ATIVO);
    }

    @Override
    public void vender() {
        super.anuncioContext.setEstado(new Vendido());
    }

    @Override
    public void suspender() {
        super.anuncioContext.setEstado(new Suspenso());
    }

    public void aprovar() {}
    public void reprovar() {}
    public void publicar() {}
}