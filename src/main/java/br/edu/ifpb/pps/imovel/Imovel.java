package br.edu.ifpb.pps.imovel;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;

public abstract class Imovel implements PrototypeImovel {
    public String titulo;
    public double preco;
    protected Anunciante usuario;

    public Imovel(String titulo, double preco, Anunciante usuario) {
        this.titulo = titulo;
        this.preco = preco;
    }

    public Imovel(Imovel clone){
        this.titulo = clone.titulo;
        this.preco = clone.preco;
        this.usuario = clone.usuario;
    }

    public Imovel clonar(){
        return this.criarClone();
    }
    protected abstract Imovel criarClone();
    public abstract void exibirDetalhes();


}
