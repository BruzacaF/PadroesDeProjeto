package br.edu.ifpb.pps.Anuncio.Visitor;

import br.edu.ifpb.pps.Anuncio.Anuncio;


public interface AnuncioVisitor {
    void visitar(Anuncio anuncio);
    String obterResultado();
}
