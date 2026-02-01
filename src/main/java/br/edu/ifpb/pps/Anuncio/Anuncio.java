package br.edu.ifpb.pps.Anuncio;

import br.edu.ifpb.pps.Anuncio.Estados.Rascunho;
import br.edu.ifpb.pps.Enums.EstadoAnuncioEnum;

import br.edu.ifpb.pps.Logger.LoggerAnuncio;
import br.edu.ifpb.pps.Notificacao.NotificacaoObserver;

import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.Imovel;

import java.util.ArrayList;
import java.util.List;


public class Anuncio {
    private String titulo;
    private String descricao;
    private Double preco;
    private List<String> imagens;
    private Imovel imovel;
    private Anunciante anunciante;
    private EstadoAnuncio estado;
    private EstadoAnuncioEnum estadoEnum;
    private List<NotificacaoObserver> observers = new ArrayList<>();

    public Anuncio(String titulo, String descricao, Imovel imovel, Anunciante anunciante, Double preco) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.imagens = new ArrayList<>();
        this.imovel = imovel;
        this.anunciante = anunciante;
        this.estado = new Rascunho(); // estado inicial
        this.estadoEnum = EstadoAnuncioEnum.RASCUNHO;
    }

    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public Imovel getImovel() { return imovel; }
    public Double getPreco() { return preco; }
    public Anunciante getAnunciante() { return anunciante; }
    public EstadoAnuncioEnum getEstadoEnum() { return estadoEnum; }

    public void adicionarObserver(NotificacaoObserver observer) {
        observers.add(observer);
    }

    public void setEstado(EstadoAnuncio novoEstado, EstadoAnuncioEnum novoEnum) {
        this.estado = novoEstado;
        this.estadoEnum = novoEnum;
        notificarTodos("Estado do anúncio '" + titulo + "' alterado para: " + novoEnum);
        LoggerAnuncio.registrar("Anúncio '" + titulo + "' mudou para estado: " + novoEnum);
    }

    private void notificarTodos(String mensagem) {
        for (NotificacaoObserver obs : observers) {
            obs.notificar(mensagem);
        }
    }

    // Delegação para o estado atual
    public void enviarParaModeracao() { estado.enviarParaModeracao(this); }
    public void aprovar() { estado.aprovar(this); }
    public void reprovar() { estado.reprovar(this); }
    public void publicar() { estado.publicar(this); }
    public void vender() { estado.vender(this); }
    public void suspender() { estado.suspender(this); }

    public void adicionarFoto(String image) {
        this.imagens.add(image);
    }


    public void exibirDetalhes() {
        System.out.println("=== Detalhes do Anúncio ===");
        System.out.println("Título: " + titulo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Preço: " + preco);
        System.out.println("Estado atual: " + estadoEnum);
        System.out.println("Anunciante: " + anunciante.getNome()); // supondo que Anunciante tenha getNome()

        System.out.println("\n--- Imóvel ---");
        imovel.exibirDetalhes(); // delega para o imóvel

        System.out.println("\n--- Fotos ---");
        if (imagens.isEmpty()) {
            System.out.println("Nenhuma foto adicionada.");
        } else {
            for (String img : imagens) {
                System.out.println("Foto: " + img);
            }
        }

        System.out.println("============================");
    }
}