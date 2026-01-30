package br.edu.ifpb.pps.imovel.builder.tiposBuilder;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.builder.ImovelBuilder;
import br.edu.ifpb.pps.imovel.tipoImovel.Apartamento;

public class ApartamentoBuilder implements ImovelBuilder {
    private String titulo;
    private double preco;
    private Anunciante usuario;
    private Integer andar;       // atributo opcional
    private Boolean elevador;    // atributo opcional

    public ApartamentoBuilder titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public ApartamentoBuilder preco(double preco) {
        this.preco = preco;
        return this;
    }

    public ApartamentoBuilder usuario(Anunciante usuario) {
        this.usuario = usuario;
        return this;
    }

    public ApartamentoBuilder andar(Integer andar) {
        this.andar = andar;
        return this;
    }

    public ApartamentoBuilder elevador(Boolean elevador) {
        this.elevador = elevador;
        return this;
    }
    @Override
    public Apartamento build() {
        return new Apartamento(titulo, preco, usuario, andar, elevador);
    }
}