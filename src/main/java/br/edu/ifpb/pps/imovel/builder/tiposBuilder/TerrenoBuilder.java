package br.edu.ifpb.pps.imovel.builder.tiposBuilder;

import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.builder.ImovelBuilder;
import br.edu.ifpb.pps.imovel.tipoImovel.Terreno;

public class TerrenoBuilder implements ImovelBuilder {
    private String titulo;
    private double preco;
    private Anunciante usuario;
    private double area; // atributo específico do Terreno

    public TerrenoBuilder titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public TerrenoBuilder preco(double preco) {
        this.preco = preco;
        return this;
    }

    public TerrenoBuilder usuario(Anunciante usuario) {
        this.usuario = usuario;
        return this;
    }

    public TerrenoBuilder area(double area) {
        this.area = area;
        return this;
    }

    @Override
    public Terreno build() {
        return new Terreno(titulo, preco, usuario, area);
    }
}