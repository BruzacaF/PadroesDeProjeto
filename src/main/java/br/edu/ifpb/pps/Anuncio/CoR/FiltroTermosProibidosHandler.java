package br.edu.ifpb.pps.Anuncio.CoR;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.config.ConfiguracaoSistema;

public class FiltroTermosProibidosHandler extends AbstractModeracaoHandler {
    @Override
    protected boolean process(Anuncio anuncio) {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstancia();
        String termosConfig = config.getPropriedade("termos.TermosProibidos");

        if (termosConfig == null || termosConfig.isEmpty()) {
            return true; // sem termos configurados, não reprova
        }

        // Normaliza texto do anúncio
        String titulo = anuncio.getTitulo().toLowerCase().replaceAll("[^a-z0-9áéíóúãõç ]", " ");
        String descricao = anuncio.getDescricao().toLowerCase().replaceAll("[^a-z0-9áéíóúãõç ]", " ");

        // Verifica cada termo proibido
        for (String termo : termosConfig.split(",")) {
            String termoLimpo = termo.trim().toLowerCase();
            if (!termoLimpo.isEmpty()) {
                // Usa regex para garantir correspondência de palavra inteira
                String regex = "\\b" + termoLimpo + "\\b";
                if (titulo.matches(".*" + regex + ".*") || descricao.matches(".*" + regex + ".*")) {
                    System.out.println("❌ Reprovado: contém termo proibido (" + termoLimpo + ")");
                    return false;
                }
            }
        }
        return true;
    }
}