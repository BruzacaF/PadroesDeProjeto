package br.edu.ifpb.pps.Notificacao.tiposNotificacao;

import br.edu.ifpb.pps.Notificacao.NotificacaoObserver;

public class NotificacaoWhatsApp implements NotificacaoObserver {
    private String numero;
    public NotificacaoWhatsApp(String numero) { this.numero = numero; }

    @Override
    public void atualizar(String mensagem) {
        System.out.println("Enviando WhatsApp para " + numero + ": " + mensagem);
    }
}
