package br.edu.ifpb.pps.Anuncio.Visitor;

import br.edu.ifpb.pps.Anuncio.Anuncio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ExportadorPDF implements AnuncioVisitor {
    private StringBuilder conteudo;
    private int contador;
    
    public ExportadorPDF() {
        this.conteudo = new StringBuilder();
        this.contador = 0;
        inicializarDocumento();
    }
    
    private void inicializarDocumento() {
        conteudo.append("===============================================\n");
        conteudo.append("        RELATÓRIO DE ANÚNCIOS - PDF           \n");
        conteudo.append("===============================================\n");
        conteudo.append("Data: ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))).append("\n");
        conteudo.append("===============================================\n\n");
    }
    
    @Override
    public void visitar(Anuncio anuncio) {
        contador++;
        conteudo.append("-------------------------------------------\n");
        conteudo.append("ANÚNCIO #").append(contador).append("\n");
        conteudo.append("-------------------------------------------\n");
        conteudo.append("Título: ").append(anuncio.getTitulo()).append("\n");
        conteudo.append("Descrição: ").append(anuncio.getDescricao()).append("\n");
        conteudo.append("Preço: R$ ").append(String.format("%.2f", anuncio.getPreco())).append("\n");
        conteudo.append("Anunciante: ").append(anuncio.getAnunciante().getNome()).append("\n");
        conteudo.append("\n");
        conteudo.append("DADOS DO IMÓVEL:\n");
        conteudo.append("  Tipo: ").append(anuncio.getImovel().getTipo()).append("\n");
        conteudo.append("  Área: ").append(anuncio.getImovel().getArea()).append(" m²\n");
        conteudo.append("  Endereço: ").append(anuncio.getImovel().getEndereco()).append("\n");
        conteudo.append("  Quartos: ").append(anuncio.getImovel().getQuartos()).append("\n");
        conteudo.append("  Banheiros: ").append(anuncio.getImovel().getBanheiros()).append("\n");
        conteudo.append("  Vagas: ").append(anuncio.getImovel().getVagasGaragem()).append("\n");
        conteudo.append("\n");
    }
    
    @Override
    public String obterResultado() {
        StringBuilder finalizado = new StringBuilder(conteudo);
        finalizado.append("\n===============================================\n");
        finalizado.append("Total de anúncios: ").append(contador).append("\n");
        finalizado.append("===============================================\n");
        return finalizado.toString();
    }
}
