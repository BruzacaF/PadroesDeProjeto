package br.edu.ifpb.pps.Anuncio.Estados;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.EstadoAnuncio;

public class Suspenso implements EstadoAnuncio {
    @Override
    public void publicar(Anuncio anuncio) {
        anuncio.setEstado(new Rascunho());
        System.out.println("Anúncio voltou para rascunho.");
    }
    public void moderar(Anuncio anuncio) { System.out.println("Não pode moderar suspenso."); }
    public void vender(Anuncio anuncio) { System.out.println("Não pode vender suspenso."); }
    public void suspender(Anuncio anuncio) { System.out.println("Já está suspenso."); }
}
