package br.edu.ifpb.pps.Anuncio;

import br.edu.ifpb.pps.Anuncio.Estados.Rascunho;
import br.edu.ifpb.pps.Notificacao.NotificacaoObserver;
import br.edu.ifpb.pps.Usuario.Usuario;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.Imovel;

import java.util.ArrayList;
import java.util.List;

public class Anuncio {
    private String titulo;
    private Imovel imovel;
    private Usuario anunciante;
    private EstadoAnuncio estado;
    private List<NotificacaoObserver> observadores = new ArrayList<>();

    public Anuncio(String titulo, Imovel imovel, Anunciante anunciante) {
        this.titulo = titulo;
        this.imovel = imovel;
        this.anunciante = anunciante;
        this.estado = new Rascunho();
    }

    public void adicionarObservador(NotificacaoObserver obs) {
        observadores.add(obs);
    }

    public void notificar(String mensagem) {
        for (NotificacaoObserver obs : observadores) {
            obs.atualizar(mensagem);
        }
    }

    public void setEstado(EstadoAnuncio estado) {
        this.estado = estado;
        notificar("Estado do anúncio '" + titulo + "' mudou para: " + estado.getClass().getSimpleName());
    }

    public String getTitulo() {
        return titulo;
    }

    public void publicar() { estado.publicar(this); }
    public void moderar() { estado.moderar(this); }
    public void vender() { estado.vender(this); }
    public void suspender() { estado.suspender(this); }

    public EstadoAnuncio getEstado() {
        return estado;
    }


    // TESTE DE BANNER PARA VISUALIZAR
    public void imprimirBanner() {
        System.out.println("========================================");
        System.out.println("🏠 ANÚNCIO: " + titulo.toUpperCase());
        System.out.println("----------------------------------------");
        System.out.println("📌 Tipo de Imóvel: " + imovel.getClass().getSimpleName());
        System.out.println("💰 Preço: R$ " + imovel.preco);
        System.out.println("👤 Anunciante: " + anunciante.getNome());
        System.out.println("📢 Estado: " + estado.getClass().getSimpleName());
        System.out.println("----------------------------------------");
        imovel.exibirDetalhes(); // imprime detalhes específicos do imóvel
        System.out.println("========================================\n");
    }

    public Imovel getImovel() {
        return imovel;
    }
}

