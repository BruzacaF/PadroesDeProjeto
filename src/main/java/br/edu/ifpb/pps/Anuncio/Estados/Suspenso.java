package br.edu.ifpb.pps.Anuncio.Estados;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.EstadoAnuncio;
import br.edu.ifpb.pps.Enums.EstadoAnuncioEnum;

public class Suspenso implements EstadoAnuncio {
    @Override
    public void enviarParaModeracao(Anuncio anuncio) {
        anuncio.setEstado(new Rascunho(), EstadoAnuncioEnum.RASCUNHO);
    }

    public void aprovar(Anuncio anuncio) {}
    public void reprovar(Anuncio anuncio) {}
    public void publicar(Anuncio anuncio) {}
    public void vender(Anuncio anuncio) {}
    public void suspender(Anuncio anuncio) {}
}