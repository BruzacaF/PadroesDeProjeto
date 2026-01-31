package br.edu.ifpb.pps.imovel.tipoImovel;
import br.edu.ifpb.pps.Enums.ImovelTipo;
import br.edu.ifpb.pps.Usuario.Usuario;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.Imovel;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;

import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;

public class Apartamento extends Imovel {
    private int andar;
    private boolean elevador;
    private double taxaCondominio;

    public Apartamento(Apartamento outro) {
        super(outro);
        this.andar = outro.andar;
        this.elevador = outro.elevador;
        this.taxaCondominio = outro.taxaCondominio;
    }

    public Apartamento() {

    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Andar: " + andar);
        System.out.println("Elevador: " + elevador);
        System.out.println("Taxa de condomínio: R$ " + taxaCondominio);
    }

    @Override
    protected Imovel criarClone() {
        return new Apartamento(this);
    }

    public Integer getAndar() {
        return andar;
    }
    public void setAndar(Integer andar) {
        this.andar = andar;
    }
    public boolean isElevador() {
        return elevador;
    }
    public void setElevador(boolean elevador) {
        this.elevador = elevador;
    }
    public Double getTaxaCondominio() {
        return taxaCondominio;
    }
    public void setTaxaCondominio(Double taxaCondominio) {
        this.taxaCondominio = taxaCondominio;
    }

}