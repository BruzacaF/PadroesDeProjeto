package br.edu.ifpb.pps.Anuncio.Decorator.Filtros;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.Decorator.Filtro;
import br.edu.ifpb.pps.Anuncio.Decorator.FiltroDecorator;

public class FiltroPreco extends FiltroDecorator {
    private double min, max;
    public FiltroPreco(Filtro filtro, double min, double max) {
        super(filtro);
        this.min = min; this.max = max;
    }

    @Override
    protected boolean aplicarFiltro(Anuncio anuncio) {
        return anuncio.getPreco() >= min && anuncio.getPreco() <= max;
    }
}
