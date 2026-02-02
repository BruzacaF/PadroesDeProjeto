package br.edu.ifpb.pps.Notificacao.tiposNotificacao;

import br.edu.ifpb.pps.Notificacao.NotificacaoStrategy;

public class NotificacaoWhatsAppStrategy implements NotificacaoStrategy {
    private String numero;

    public NotificacaoWhatsAppStrategy(String numero) {
        this.numero = numero;
    }

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("📱 Enviando WhatsApp para " + numero + ": " + mensagem);
    }
}
