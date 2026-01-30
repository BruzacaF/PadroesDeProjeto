package br.edu.ifpb.pps.Anuncio.Visitor.Filtros;
import br.edu.ifpb.pps.Anuncio.Visitor.FiltroHandler;
import br.edu.ifpb.pps.imovel.Imovel;
import br.edu.ifpb.pps.imovel.tipoImovel.Casa;


public class FiltroQuintalHandler extends FiltroHandler {
    @Override
    protected boolean filtrar(Imovel imovel) {
        if (imovel instanceof Casa casa) return casa.getQuintal();
        return false; // ignora outros tipos
    }
}