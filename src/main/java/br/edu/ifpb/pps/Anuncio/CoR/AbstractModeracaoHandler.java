package br.edu.ifpb.pps.Anuncio.CoR;

import br.edu.ifpb.pps.Anuncio.Anuncio;

public abstract class AbstractModeracaoHandler implements ModeracaoHandler {
    private ModeracaoHandler next;

    // Setter para permitir modificar a corrente em runtime
    public void setNext(ModeracaoHandler next) {
        this.next = next;
    }

    @Override
    public boolean handle(Anuncio anuncio) {
        if (!process(anuncio)) {
            return false; // se falhar, interrompe a corrente
        }
        if (next != null) {
            return next.handle(anuncio); // passa adiante
        }
        return true; // fim da corrente
    }

    // Cada handler concreto implementa sua regra
    protected abstract boolean process(Anuncio anuncio);
}