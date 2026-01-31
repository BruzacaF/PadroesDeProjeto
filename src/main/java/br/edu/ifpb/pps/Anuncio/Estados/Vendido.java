package br.edu.ifpb.pps.Anuncio.Estados;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.EstadoAnuncio;

public class Vendido implements EstadoAnuncio {
    public void enviarParaModeracao(Anuncio anuncio) {}
    public void aprovar(Anuncio anuncio) {}
    public void reprovar(Anuncio anuncio) {}
    public void publicar(Anuncio anuncio) {}
    public void vender(Anuncio anuncio) {}
    public void suspender(Anuncio anuncio) {}
}