package br.edu.ifpb.pps.imovel.tipoImovel;

import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.Imovel;

public class Terreno extends Imovel {
    private double area;

    public Terreno(String titulo, double preco, Anunciante usuario, double area) {
        super(titulo, preco, usuario);
        this.area = area;
    }

    public Terreno(Terreno outro) {
        super(outro);
        this.area = outro.area;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Terreno: " + titulo + ", preço: " + preco + ", área: " + area + " m²");
    }

    @Override
    protected Imovel criarClone() {
        return new Terreno(this);
    }
}