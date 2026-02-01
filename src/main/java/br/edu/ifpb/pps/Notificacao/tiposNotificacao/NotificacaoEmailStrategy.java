package br.edu.ifpb.pps.Notificacao.tiposNotificacao;

import br.edu.ifpb.pps.Notificacao.NotificacaoObserverStrategy;

public class NotificacaoEmailObserverStrategy extends NotificacaoObserverStrategy {
    private String email;

    public NotificacaoEmailObserverStrategy(String email) {
        this.email = email;
    }

    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando Email para " + email + ": " + mensagem);
    }
}

