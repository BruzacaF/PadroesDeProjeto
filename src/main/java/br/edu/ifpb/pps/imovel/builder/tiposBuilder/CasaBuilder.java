package br.edu.ifpb.pps.imovel.builder.tiposBuilder;

import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.builder.ImovelBuilder;
import br.edu.ifpb.pps.imovel.tipoImovel.Casa;

public class CasaBuilder implements ImovelBuilder {
    private String titulo;
    private double preco;
    private Anunciante usuario;
    private boolean quintal;

    public CasaBuilder titulo(String titulo) { this.titulo = titulo; return this; }
    public CasaBuilder preco(double preco) { this.preco = preco; return this; }
    public CasaBuilder usuario(Anunciante usuario) { this.usuario = usuario; return this; }
    public CasaBuilder quintal(Boolean quintal) { this.quintal = quintal; return this; }

    @Override
    public Casa build() {
        return new Casa(titulo, preco, usuario, quintal);
    }
}