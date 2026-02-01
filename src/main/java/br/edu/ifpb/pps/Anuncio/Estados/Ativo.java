package br.edu.ifpb.pps.Anuncio.Estados;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.EstadoAnuncio;
import br.edu.ifpb.pps.Enums.EstadoAnuncioEnum;
import br.edu.ifpb.pps.repository.AnuncioRepository;

public class Ativo implements EstadoAnuncio {
    @Override
    public void vender(Anuncio anuncio) {
        // Imóvel vendido: estado final
        anuncio.setEstado(new Vendido(), EstadoAnuncioEnum.VENDIDO);
    }

    @Override
    public void suspender(Anuncio anuncio) {
        // Suspender anúncio ativo (retirado pelo usuário)
        anuncio.setEstado(new Suspenso(), EstadoAnuncioEnum.SUSPENSO);
    }

    public void enviarParaModeracao(Anuncio anuncio) {}
    public void aprovar(Anuncio anuncio) {}
    public void reprovar(Anuncio anuncio) {}
    public void publicar(Anuncio anuncio) {}
}