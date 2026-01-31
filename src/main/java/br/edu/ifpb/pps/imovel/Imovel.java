package br.edu.ifpb.pps.imovel;
import br.edu.ifpb.pps.Enums.ImovelTipo;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;

import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;

public abstract class Imovel implements PrototypeImovel {
    protected String titulo;
    public double preco;
    protected ImovelTipo tipo;   // agora usando Enum
    protected Anunciante usuario;

    // Atributos comuns
    protected double area;
    protected String endereco;
    protected int quartos;
    protected int banheiros;
    protected int vagasGaragem;
    protected String descricao;

    public Imovel() {}

    public Imovel(Imovel clone) {
        this.titulo = clone.titulo;
        this.tipo = clone.tipo;
        this.usuario = clone.usuario;
        this.area = clone.area;
        this.endereco = clone.endereco;
        this.quartos = clone.quartos;
        this.banheiros = clone.banheiros;
        this.vagasGaragem = clone.vagasGaragem;
        this.descricao = clone.descricao;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public ImovelTipo getTipo() {
        return tipo;
    }
    public void setTipo(ImovelTipo tipo) {
        this.tipo = tipo;
    }
    public Anunciante getUsuario() {
        return usuario;
    }
    public void setUsuario(Anunciante usuario) {
        this.usuario = usuario;

    }
    public double getArea() {
        return area;
    }
    public void setArea(double area) {
        this.area = area;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public int getQuartos() {
        return quartos;
    }
    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }
    public int getBanheiros() {
        return banheiros;
    }
    public void setBanheiros(int banheiros) {
        this.banheiros = banheiros;
    }
    public int getVagasGaragem() {
        return vagasGaragem;
    }
    public void setVagasGaragem(int vagasGaragem) {
        this.vagasGaragem = vagasGaragem;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public Imovel clonar() {
        return this.criarClone();
    }

    protected abstract Imovel criarClone();

    public void exibirDetalhes() {
        System.out.println("Título: " + titulo);
        System.out.println("Tipo: " + tipo);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Área: " + area + " m²");
        System.out.println("Endereço: " + endereco);
        System.out.println("Quartos: " + quartos);
        System.out.println("Banheiros: " + banheiros);
        System.out.println("Vagas de garagem: " + vagasGaragem);
        System.out.println("Descrição: " + descricao);
    }
}