package br.edu.ifpb.pps.Anuncio.Estados;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.EstadoAnuncio;
import br.edu.ifpb.pps.Anuncio.Moderador;
import br.edu.ifpb.pps.Enums.EstadoAnuncioEnum;

public class Moderacao implements EstadoAnuncio {
    @Override
    public void aprovar(Anuncio anuncio) {
        anuncio.setEstado(new Ativo(), EstadoAnuncioEnum.ATIVO);
    }

    @Override
    public void reprovar(Anuncio anuncio) {
        anuncio.setEstado(new Suspenso(), EstadoAnuncioEnum.SUSPENSO);
    }

    @Override
    public void enviarParaModeracao(Anuncio anuncio) {
        Moderador moderador = Moderador.getInstancia();
        boolean aprovado = moderador.moderarManual(anuncio);

        if (aprovado) {
            aprovar(anuncio);
        } else {
            reprovar(anuncio);
        }
    }

    public void publicar(Anuncio anuncio) {}
    public void vender(Anuncio anuncio) {}
    public void suspender(Anuncio anuncio) {}
}