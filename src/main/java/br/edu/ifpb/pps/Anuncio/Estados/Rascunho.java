package br.edu.ifpb.pps.Anuncio.Estados;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.EstadoAnuncio;
import br.edu.ifpb.pps.Anuncio.Moderador;
import br.edu.ifpb.pps.Enums.EstadoAnuncioEnum;

public class Rascunho implements EstadoAnuncio {

    @Override
    public void enviarParaModeracao(Anuncio anuncio) {
        // Muda para estado de Moderação e inicia o processo
        anuncio.setEstado(new Moderacao(), EstadoAnuncioEnum.EM_MODERACAO);
        
        // Inicia a moderação automática
        Moderador moderador = Moderador.getInstancia();
        boolean aprovado = moderador.moderar(anuncio);

        if (aprovado) {
            anuncio.aprovar();
        } else {
            anuncio.reprovar();
        }
    }

    public void aprovar(Anuncio anuncio) {}
    public void reprovar(Anuncio anuncio) {}
    public void publicar(Anuncio anuncio) {}
    public void vender(Anuncio anuncio) {}
    public void suspender(Anuncio anuncio) {}
}