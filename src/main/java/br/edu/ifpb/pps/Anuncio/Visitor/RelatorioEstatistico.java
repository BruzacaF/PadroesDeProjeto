package br.edu.ifpb.pps.Anuncio.Visitor;

import br.edu.ifpb.pps.Anuncio.Anuncio;

import java.util.HashMap;
import java.util.Map;


public class RelatorioEstatistico implements AnuncioVisitor {
    private int totalAnuncios;
    private double somaPrecos;
    private double precoMinimo;
    private double precoMaximo;
    private double somaAreas;
    private Map<String, Integer> imoveisPorTipo;
    private Map<String, Integer> quartosPorQuantidade;
    
    public RelatorioEstatistico() {
        this.totalAnuncios = 0;
        this.somaPrecos = 0.0;
        this.precoMinimo = Double.MAX_VALUE;
        this.precoMaximo = Double.MIN_VALUE;
        this.somaAreas = 0.0;
        this.imoveisPorTipo = new HashMap<>();
        this.quartosPorQuantidade = new HashMap<>();
    }
    
    @Override
    public void visitar(Anuncio anuncio) {
        totalAnuncios++;
        
        // Estatísticas de preço
        double preco = anuncio.getPreco();
        somaPrecos += preco;
        if (preco < precoMinimo) precoMinimo = preco;
        if (preco > precoMaximo) precoMaximo = preco;
        
        // Estatísticas de área
        somaAreas += anuncio.getImovel().getArea();
        
        // Contagem por tipo de imóvel
        String tipo = anuncio.getImovel().getTipo().toString();
        imoveisPorTipo.put(tipo, imoveisPorTipo.getOrDefault(tipo, 0) + 1);
        
        // Contagem por quantidade de quartos
        int quartos = anuncio.getImovel().getQuartos();
        String chaveQuartos = quartos + " quarto" + (quartos != 1 ? "s" : "");
        quartosPorQuantidade.put(chaveQuartos, quartosPorQuantidade.getOrDefault(chaveQuartos, 0) + 1);
    }
    
    @Override
    public String obterResultado() {
        if (totalAnuncios == 0) {
            return "Nenhum anúncio para gerar estatísticas.";
        }
        
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("\n╔════════════════════════════════════════════╗\n");
        relatorio.append("║     RELATÓRIO ESTATÍSTICO DE ANÚNCIOS      ║\n");
        relatorio.append("╚════════════════════════════════════════════╝\n\n");
        
        // Estatísticas gerais
        relatorio.append("📊 ESTATÍSTICAS GERAIS:\n");
        relatorio.append("   Total de anúncios: ").append(totalAnuncios).append("\n");
        relatorio.append("   Preço médio: R$ ").append(String.format("%.2f", somaPrecos / totalAnuncios)).append("\n");
        relatorio.append("   Preço mínimo: R$ ").append(String.format("%.2f", precoMinimo)).append("\n");
        relatorio.append("   Preço máximo: R$ ").append(String.format("%.2f", precoMaximo)).append("\n");
        relatorio.append("   Área média: ").append(String.format("%.2f", somaAreas / totalAnuncios)).append(" m²\n");
        relatorio.append("\n");
        
        // Distribuição por tipo
        relatorio.append("🏠 DISTRIBUIÇÃO POR TIPO DE IMÓVEL:\n");
        for (Map.Entry<String, Integer> entry : imoveisPorTipo.entrySet()) {
            double percentual = (entry.getValue() * 100.0) / totalAnuncios;
            relatorio.append("   ").append(entry.getKey()).append(": ")
                     .append(entry.getValue()).append(" (")
                     .append(String.format("%.1f%%", percentual)).append(")\n");
        }
        relatorio.append("\n");
        
        // Distribuição por quartos
        relatorio.append("🛏️  DISTRIBUIÇÃO POR QUARTOS:\n");
        for (Map.Entry<String, Integer> entry : quartosPorQuantidade.entrySet()) {
            double percentual = (entry.getValue() * 100.0) / totalAnuncios;
            relatorio.append("   ").append(entry.getKey()).append(": ")
                     .append(entry.getValue()).append(" (")
                     .append(String.format("%.1f%%", percentual)).append(")\n");
        }
        
        relatorio.append("\n════════════════════════════════════════════\n");
        
        return relatorio.toString();
    }
}
