package br.edu.ifpb.pps.Anuncio.Estados;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.EstadoAnuncio;

public class Moderação implements EstadoAnuncio {
    @Override
    public void publicar(Anuncio anuncio) {
        anuncio.setEstado(new Ativo());
        System.out.println("Anúncio aprovado e publicado.");
    }
    public void moderar(Anuncio anuncio) { System.out.println("Já está em moderação."); }
    public void vender(Anuncio anuncio) { System.out.println("Não pode vender em moderação."); }
    public void suspender(Anuncio anuncio) {
        anuncio.setEstado(new Suspenso());
        System.out.println("Anúncio suspenso durante moderação.");
    }
}
