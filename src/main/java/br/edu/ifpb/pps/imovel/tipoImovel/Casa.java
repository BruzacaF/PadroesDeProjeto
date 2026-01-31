package br.edu.ifpb.pps.imovel.tipoImovel;
import br.edu.ifpb.pps.Enums.ImovelTipo;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.Imovel;

import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;

import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;

public class Casa extends Imovel {
    private boolean quintal;
    private boolean piscina;

    public Casa() {
        super();
    }

    public Casa(Casa outro) {
        super(outro);
        this.quintal = outro.quintal;
        this.piscina = outro.piscina;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Quintal: " + quintal);
        System.out.println("Piscina: " + piscina);
    }

    @Override
    protected Imovel criarClone() {
        return new Casa(this);
    }

    public Boolean getQuintal() {
        return quintal;
    }

    public void setQuintal(Boolean quintal) {
        this.quintal = quintal;
    }
    public Boolean getPiscina() {
        return piscina;
    }
    public void setPiscina(Boolean piscina) {
        this.piscina = piscina;
    }
}