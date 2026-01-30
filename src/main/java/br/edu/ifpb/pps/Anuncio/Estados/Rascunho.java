package br.edu.ifpb.pps.Anuncio.Estados;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.EstadoAnuncio;

public class Rascunho implements EstadoAnuncio {
    @Override
    public void publicar(Anuncio anuncio) {
        anuncio.setEstado(new Moderação());
        System.out.println("Anúncio enviado para moderação.");
    }
    public void moderar(Anuncio anuncio) { System.out.println("Não pode moderar um rascunho."); }
    public void vender(Anuncio anuncio) { System.out.println("Não pode vender um rascunho."); }
    public void suspender(Anuncio anuncio) { System.out.println("Não pode suspender um rascunho."); }
}
