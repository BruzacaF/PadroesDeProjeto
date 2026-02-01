package br.edu.ifpb.pps.Anuncio.Visitor;

import br.edu.ifpb.pps.Anuncio.Anuncio;

public class ExportadorJSON implements AnuncioVisitor {
    private StringBuilder resultado;
    
    public ExportadorJSON() {
        this.resultado = new StringBuilder();
        this.resultado.append("[\n");
    }
    
    @Override
    public void visitar(Anuncio anuncio) {
        if (resultado.length() > 2) {
            resultado.append(",\n");
        }
        
        resultado.append("  {\n");
        resultado.append("    \"titulo\": \"").append(escaparJSON(anuncio.getTitulo())).append("\",\n");
        resultado.append("    \"descricao\": \"").append(escaparJSON(anuncio.getDescricao())).append("\",\n");
        resultado.append("    \"preco\": ").append(anuncio.getPreco()).append(",\n");
        resultado.append("    \"anunciante\": \"").append(escaparJSON(anuncio.getAnunciante().getNome())).append("\",\n");
        resultado.append("    \"imovel\": {\n");
        resultado.append("      \"tipo\": \"").append(anuncio.getImovel().getTipo()).append("\",\n");
        resultado.append("      \"area\": ").append(anuncio.getImovel().getArea()).append(",\n");
        resultado.append("      \"endereco\": \"").append(escaparJSON(anuncio.getImovel().getEndereco())).append("\",\n");
        resultado.append("      \"quartos\": ").append(anuncio.getImovel().getQuartos()).append("\n");
        resultado.append("    }\n");
        resultado.append("  }");
    }
    
    @Override
    public String obterResultado() {
        StringBuilder finalizado = new StringBuilder(resultado);
        finalizado.append("\n]");
        return finalizado.toString();
    }
    
    private String escaparJSON(String texto) {
        if (texto == null) return "";
        return texto.replace("\"", "\\\"")
                    .replace("\n", "\\n")
                    .replace("\r", "\\r")
                    .replace("\t", "\\t");
    }
}
