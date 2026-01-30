package br.edu.ifpb.pps.Notificacao.tiposNotificacao;

import br.edu.ifpb.pps.Notificacao.NotificacaoObserver;

public class NotificacaoEmail implements NotificacaoObserver {
    private String email;
    public NotificacaoEmail(String email) { this.email = email; }

    @Override
    public void atualizar(String mensagem) {
        System.out.println("Enviando Email para " + email + ": " + mensagem);
    }
}

