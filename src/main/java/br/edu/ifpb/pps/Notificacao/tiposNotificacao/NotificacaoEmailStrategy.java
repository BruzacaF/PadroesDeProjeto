package br.edu.ifpb.pps.Notificacao.tiposNotificacao;

import br.edu.ifpb.pps.Notificacao.NotificacaoStrategy;

public class NotificacaoEmailStrategy implements NotificacaoStrategy {
    private String email;

    public NotificacaoEmailStrategy(String email) {
        this.email = email;
    }

    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando Email para " + email + ": " + mensagem);
    }
}

