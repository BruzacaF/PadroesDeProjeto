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
    private List<NotificacaoObserver> observers = new ArrayList<>();

    public Anuncio(String titulo, String descricao, Imovel imovel, Anunciante anunciante, Double preco) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.imagens = new ArrayList<>();
        this.imovel = imovel;
        this.anunciante = anunciante;
        this.estado = new Rascunho();
        this.estado.setAnuncioContext(this);
    }

    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public Imovel getImovel() { return imovel; }
    public Double getPreco() { return preco; }
    public Anunciante getAnunciante() { return anunciante; }

    public void adicionarObserver(NotificacaoObserver observer) {
        observers.add(observer);
    }

    public void removerObserver(NotificacaoObserver observer){
        observers.remove(observer);
    }

    public void setEstado(EstadoAnuncio novoEstado) {
        this.estado = novoEstado;
        this.estado.setAnuncioContext(this);
        notificarTodos("Estado do anúncio '" + titulo + "' alterado para: " + estado.getEstadoAnuncioEnum());
        LoggerAnuncio.registrar("Anúncio '" + titulo + "' mudou para estado: " + estado.getEstadoAnuncioEnum());
    }

    private void notificarTodos(String mensagem) {
        for (NotificacaoObserver obs : observers) {
            obs.notificar(mensagem);
        }
    }

    // Delegação para o estado atual
    public void aprovar() { estado.aprovar(); }
    public void reprovar() { estado.reprovar(); }
    public void publicar() { estado.publicar(); }
    public void vender() { estado.vender(); }
    public void suspender() { estado.suspender(); }

    public void adicionarFoto(String image) {
        this.imagens.add(image);
    }


    public void exibirDetalhes() {
        System.out.println("=== Detalhes do Anúncio ===");
        System.out.println("Título: " + titulo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Preço: " + preco);
        System.out.println("Estado atual: " + estado.getEstadoAnuncioEnum());
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