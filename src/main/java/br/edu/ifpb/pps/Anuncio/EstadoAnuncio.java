package br.edu.ifpb.pps.Anuncio;

public interface EstadoAnuncio {
    void publicar(Anuncio anuncio);
    void moderar(Anuncio anuncio);
    void vender(Anuncio anuncio);
    void suspender(Anuncio anuncio);
}