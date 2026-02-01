package br.edu.ifpb.pps.Notificacao;

import br.edu.ifpb.pps.Notificacao.tiposNotificacao.TipoNotificacao;

import java.util.HashMap;
import java.util.Map;

public abstract class NotificacaoObserver {

    private Map<TipoNotificacao, NotificacaoStrategy> notificadorStrategies = new HashMap<>();

    public void notificar(String mensagem) {
        for (NotificacaoStrategy strategy : notificadorStrategies.values()) {
            strategy.enviarMensagem(mensagem);
        }
    }

    public void adicionarStrategy(TipoNotificacao tipo, NotificacaoStrategy strategy) {
        notificadorStrategies.put(tipo, strategy);
    }

    public void removerStrategy(TipoNotificacao tipo) {
        notificadorStrategies.remove(tipo);
    }
}
