package br.edu.ifpb.pps.Anuncio;

public interface EstadoAnuncio {
    void enviarParaModeracao(Anuncio anuncio);
    void aprovar(Anuncio anuncio);
    void reprovar(Anuncio anuncio);
    void publicar(Anuncio anuncio);
    void vender(Anuncio anuncio);
    void suspender(Anuncio anuncio);

}