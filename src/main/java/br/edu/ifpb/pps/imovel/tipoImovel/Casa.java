package br.edu.ifpb.pps.imovel.tipoImovel;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.Imovel;

public class Casa extends Imovel {

    private boolean quintal;

    public Casa(String titulo, double preco, Anunciante usuario, boolean quintal) {
        super(titulo, preco, usuario);
        this.quintal = quintal;
    }

    public Casa(Casa clone) {
        super(clone);
        this.quintal = clone.quintal;
    }

    @Override
    protected Imovel criarClone() {
        return new Casa(this);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Casa: " + titulo + " | Preço: " + preco);
    }

    public boolean getQuintal() {
        return quintal;
    }
}
