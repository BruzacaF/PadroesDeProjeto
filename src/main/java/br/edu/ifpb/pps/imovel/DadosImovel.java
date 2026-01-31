package br.edu.ifpb.pps.imovel;

public class DadosImovel {
    private String titulo;
    private Double  area;
    private String endereco;
    private Integer quartos;
    private Integer banheiros;
    private Integer vagasGaragem;
    private String descricao;
    private Boolean piscina;
    private Boolean quintal;
    private Integer andar;
    private Boolean elevador;
    private Double taxaCondominio;

   public String getTitulo() {
       return titulo;
   }
   public void setTitulo(String titulo) {
       this.titulo = titulo;
   }

   public Double getArea() {
       return area;
   }

   public void setArea(Double area) {
       this.area = area;
   }

   public String getEndereco() {
       return endereco;
   }

   public void setEndereco(String endereco) {
       this.endereco = endereco;
   }

   public Integer getQuartos() {
       return quartos;
   }
   public void setQuartos(Integer quartos) {
       this.quartos = quartos;
   }
   public Integer getBanheiros() {
       return banheiros;
   }
   public void setBanheiros(Integer banheiros) {
       this.banheiros = banheiros;
   }
   public Integer getVagasGaragem() {
       return vagasGaragem;
   }
   public void setVagasGaragem(Integer vagasGaragem) {
       this.vagasGaragem = vagasGaragem;
   }
   public String getDescricao() {
       return descricao;
   }
   public void setDescricao(String descricao) {
       this.descricao = descricao;
   }

   public Boolean getPiscina() {
       return piscina;
   }
   public void setPiscina(Boolean piscina) {
       this.piscina = piscina;
   }
   public Boolean getQuintal() {
       return quintal;
   }
   public void setQuintal(Boolean quintal) {
       this.quintal = quintal;
   }
   public Integer getAndar() {
       return andar;
   }
   public void setAndar(Integer andar) {
       this.andar = andar;
   }
   public Boolean getElevador() {
       return elevador;
   }
   public void setElevador(Boolean elevador) {
       this.elevador = elevador;
   }
   public Double getTaxaCondominio() {
       return taxaCondominio;
   }
   public void setTaxaCondominio(Double taxaCondominio) {
       this.taxaCondominio = taxaCondominio;
   }


}