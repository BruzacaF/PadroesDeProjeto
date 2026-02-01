package br.edu.ifpb.pps.Notificacao.tiposNotificacao;

import br.edu.ifpb.pps.Notificacao.NotificacaoStrategy;

public class NotificacaoTelegramStrategy implements NotificacaoStrategy {
    private String chatId;

    public NotificacaoTelegramStrategy(String chatId) {
        this.chatId = chatId;
    }

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Enviando Telegram para chat " + chatId + ": " + mensagem);
    }
}
