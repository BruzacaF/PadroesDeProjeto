package br.edu.ifpb.pps.Anuncio.Visitor;

import br.edu.ifpb.pps.imovel.Imovel;
import br.edu.ifpb.pps.imovel.tipoImovel.Apartamento;
import br.edu.ifpb.pps.imovel.tipoImovel.Casa;
import br.edu.ifpb.pps.imovel.tipoImovel.Terreno;

public abstract class FiltroHandler {
    private FiltroHandler proximo;

    public FiltroHandler encadear(FiltroHandler proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public boolean aplicar(Imovel imovel) {
        if (!filtrar(imovel)) return false;
        if (proximo != null) return proximo.aplicar(imovel);
        return true;
    }

    protected abstract boolean filtrar(Imovel imovel);
}