package br.edu.ifpb.pps.Anuncio.Decorator;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.imovel.Imovel;

public interface Filtro {
    boolean aplicar(Anuncio anuncio);
}