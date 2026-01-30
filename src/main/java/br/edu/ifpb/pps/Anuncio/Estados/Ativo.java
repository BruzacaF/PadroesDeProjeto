package br.edu.ifpb.pps.Anuncio.Estados;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.EstadoAnuncio;

public class Ativo implements EstadoAnuncio {
    @Override
    public void publicar(Anuncio anuncio) { System.out.println("Já está ativo."); }
    public void moderar(Anuncio anuncio) { System.out.println("Não pode moderar ativo."); }
    public void vender(Anuncio anuncio) {
        anuncio.setEstado(new Vendido());
        System.out.println("Anúncio marcado como vendido.");
    }
    public void suspender(Anuncio anuncio) {
        anuncio.setEstado(new Suspenso());
        System.out.println("Anúncio suspenso.");
    }
}
