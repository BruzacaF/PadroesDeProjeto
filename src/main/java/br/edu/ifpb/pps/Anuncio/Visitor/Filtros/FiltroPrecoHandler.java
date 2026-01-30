package br.edu.ifpb.pps.Anuncio.Visitor.Filtros;

import br.edu.ifpb.pps.Anuncio.Visitor.FiltroHandler;
import br.edu.ifpb.pps.imovel.Imovel;
import br.edu.ifpb.pps.imovel.tipoImovel.Apartamento;
import br.edu.ifpb.pps.imovel.tipoImovel.Casa;
import br.edu.ifpb.pps.imovel.tipoImovel.Terreno;

public class FiltroPrecoHandler extends FiltroHandler {
    private double min, max;
    public FiltroPrecoHandler(double min, double max) { this.min = min; this.max = max; }

    @Override
    protected boolean filtrar(Imovel imovel) {
        return imovel.preco >= min && imovel.preco <= max;
    }
}

