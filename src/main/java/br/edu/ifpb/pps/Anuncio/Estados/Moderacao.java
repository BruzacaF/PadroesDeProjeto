package br.edu.ifpb.pps.Anuncio.Estados;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.EstadoAnuncio;
import br.edu.ifpb.pps.Anuncio.Moderador;
import br.edu.ifpb.pps.Enums.EstadoAnuncioEnum;

public class Moderacao extends EstadoAnuncio {

    public Moderacao(Anuncio anuncio) {
        super.setEstadoAnuncioEnum(EstadoAnuncioEnum.EM_MODERACAO);
        super.setAnuncioContext(anuncio);
        checagemAutomatica();
    }

    @Override
    public void aprovar() {
        super.anuncioContext.setEstado(new Ativo());
    }

    @Override
    public void reprovar() {
        super.anuncioContext.setEstado(new Suspenso());
    }

    void checagemAutomatica(){
        Moderador moderador = Moderador.getInstancia();
        boolean aprovado = moderador.moderarManual(super.anuncioContext);
        if (aprovado) {
            aprovar();
        } else {
            reprovar();
        }
    }

    public void publicar() {}
    public void vender() {}
    public void suspender() {}
}