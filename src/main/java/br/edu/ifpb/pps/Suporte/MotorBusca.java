package br.edu.ifpb.pps.Suporte;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.Visitor.FiltroHandler;

import java.util.List;

public class MotorBusca {
    public List<Anuncio> buscar(List<Anuncio> anuncios, FiltroHandler cadeia) {
        return anuncios.stream()
                .filter(anuncio -> cadeia.aplicar(anuncio.getImovel()))
                .toList();
    }
}