package br.edu.ifpb.pps.Anuncio.Decorator;
import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.imovel.Imovel;

public class FiltroBase implements Filtro {
    @Override
    public boolean aplicar(Anuncio anuncio) {
        return true; // todos passam
    }
}