package br.edu.ifpb.pps.imovel.tipoImovel;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.Imovel;

public class Apartamento extends Imovel {
    private int andar;
    private boolean elevador;

    public Apartamento(String titulo, double preco, Anunciante usuario, Integer andar, Boolean elevador) {
        super(titulo, preco, usuario);
        this.andar = (andar != null ? andar : 0); // default se não informado
        this.elevador = (elevador != null ? elevador : false); // default se não informado
    }


    public Apartamento(Apartamento outro) {
        super(outro);
        this.andar = outro.andar;
        this.elevador = outro.elevador;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Apartamento: " + titulo + ", preço: " + preco +
                ", andar: " + andar + ", elevador: " + elevador);
    }

    @Override
    public Imovel criarClone() {
        return new Apartamento(this);
    }



}
