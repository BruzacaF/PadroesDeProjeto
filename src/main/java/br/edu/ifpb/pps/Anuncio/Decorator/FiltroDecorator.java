package br.edu.ifpb.pps.Anuncio.Decorator;
import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.imovel.Imovel;

public abstract class FiltroDecorator implements Filtro {
    protected Filtro filtro;

    public FiltroDecorator(Filtro filtro) {
        this.filtro = filtro;
    }

    @Override
    public boolean aplicar(Anuncio anuncio) {
        return filtro.aplicar(anuncio) && aplicarFiltro(anuncio);
    }

    protected abstract boolean aplicarFiltro(Anuncio anuncio);
}