package br.edu.ifpb.pps.Notificacao.tiposNotificacao;

import br.edu.ifpb.pps.Notificacao.NotificacaoObserverStrategy;

public class NotificacaoWhatsAppObserverStrategy extends NotificacaoObserverStrategy {
    private String numero;

    public NotificacaoWhatsAppObserverStrategy(String numero) {
        this.numero = numero;
    }

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando WhatsApp para " + numero + ": " + mensagem);
    }
}
