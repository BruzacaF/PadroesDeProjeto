package br.edu.ifpb.pps.Anuncio.Estados;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.EstadoAnuncio;

public class Vendido implements EstadoAnuncio {
    @Override
    public void publicar(Anuncio anuncio) { System.out.println("Não pode publicar, já vendido."); }
    public void moderar(Anuncio anuncio) { System.out.println("Não pode moderar, já vendido."); }
    public void vender(Anuncio anuncio) { System.out.println("Já está vendido."); }
    public void suspender(Anuncio anuncio) { System.out.println("Não pode suspender, já vendido."); }
}
