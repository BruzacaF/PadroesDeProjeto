package br.edu.ifpb.pps.Anuncio.CoR;

import br.edu.ifpb.pps.Anuncio.Anuncio;

public class FiltroPrecoValidoHandler extends AbstractModeracaoHandler {
    @Override
    protected boolean process(Anuncio anuncio) {
        Double preco = anuncio.getPreco();
        if (preco <= 1000.0) {
            System.out.println("❌ Reprovado: preço inválido.");
            return false;
        }
        return true;
    }
}