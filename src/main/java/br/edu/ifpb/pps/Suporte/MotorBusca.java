package br.edu.ifpb.pps.Suporte;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.Decorator.Filtro;
import br.edu.ifpb.pps.imovel.CatalogoGlobalPrototipos;

import java.util.List;

public  class MotorBusca {

    private static MotorBusca motorBusca;

    public List<Anuncio> buscar(List<Anuncio> anuncios, Filtro filtro) {
        return anuncios.stream()
                .filter(filtro::aplicar)
                .toList();
    }

    public static MotorBusca getInstancia() {
        if (motorBusca == null) {
            motorBusca = new MotorBusca();
        }
        return motorBusca;
    }
}