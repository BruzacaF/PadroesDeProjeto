package br.edu.ifpb.pps.Anuncio.Visitor;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class ExportadorExcel implements AnuncioVisitor {
    private List<Anuncio> anuncios;
    private String nomeArquivo;
    private String caminhoArquivo;
    
    public ExportadorExcel() {
        this.anuncios = new ArrayList<>();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        this.nomeArquivo = "relatorio_anuncios_" + timestamp + ".xlsx";
        this.caminhoArquivo = null;
    }
    
    public ExportadorExcel(String nomeArquivo) {
        this.anuncios = new ArrayList<>();
        this.nomeArquivo = nomeArquivo.endsWith(".xlsx") ? nomeArquivo : nomeArquivo + ".xlsx";
        this.caminhoArquivo = null;
    }
    
    @Override
    public void visitar(Anuncio anuncio) {
        anuncios.add(anuncio);
    }
    
    @Override
    public String obterResultado() {
        try {
            gerarArquivoExcel();
            return "✅ Arquivo Excel gerado com sucesso!\n   Localização: " + caminhoArquivo + "\n   Total de anúncios: " + anuncios.size();
        } catch (IOException e) {
            return "❌ Erro ao gerar arquivo Excel: " + e.getMessage();
        }
    }
    
    private void gerarArquivoExcel() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Anúncios");
        
        // Criar estilos
        CellStyle headerStyle = criarEstiloHeader(workbook);
        CellStyle precoStyle = criarEstiloPreco(workbook);
        CellStyle normalStyle = criarEstiloNormal(workbook);
        
        // Criar cabeçalho
        Row headerRow = sheet.createRow(0);
        String[] colunas = {"#", "Título", "Descrição", "Preço (R$)", "Anunciante", 
                           "Tipo Imóvel", "Área (m²)", "Endereço", "Quartos", "Banheiros", "Vagas"};
        
        for (int i = 0; i < colunas.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(colunas[i]);
            cell.setCellStyle(headerStyle);
        }
        
        // Preencher dados
        int rowNum = 1;
        for (Anuncio anuncio : anuncios) {
            Row row = sheet.createRow(rowNum);
            
            criarCelulaComEstilo(row, 0, rowNum, normalStyle);
            criarCelulaComEstilo(row, 1, anuncio.getTitulo(), normalStyle);
            criarCelulaComEstilo(row, 2, anuncio.getDescricao(), normalStyle);
            criarCelulaComEstilo(row, 3, anuncio.getPreco(), precoStyle);
            criarCelulaComEstilo(row, 4, anuncio.getAnunciante().getNome(), normalStyle);
            criarCelulaComEstilo(row, 5, anuncio.getImovel().getTipo().toString(), normalStyle);
            criarCelulaComEstilo(row, 6, anuncio.getImovel().getArea(), normalStyle);
            criarCelulaComEstilo(row, 7, anuncio.getImovel().getEndereco(), normalStyle);
            criarCelulaComEstilo(row, 8, anuncio.getImovel().getQuartos(), normalStyle);
            criarCelulaComEstilo(row, 9, anuncio.getImovel().getBanheiros(), normalStyle);
            criarCelulaComEstilo(row, 10, anuncio.getImovel().getVagasGaragem(), normalStyle);
            
            rowNum++;
        }
        
        // Ajustar largura das colunas
        for (int i = 0; i < colunas.length; i++) {
            sheet.autoSizeColumn(i);
            // Adicionar um pouco de espaço extra
            sheet.setColumnWidth(i, sheet.getColumnWidth(i) + 512);
        }
        
        // Salvar arquivo
        this.caminhoArquivo = System.getProperty("user.dir") + "/" + nomeArquivo;
        try (FileOutputStream fileOut = new FileOutputStream(caminhoArquivo)) {
            workbook.write(fileOut);
        }
        
        workbook.close();
    }
    
    private CellStyle criarEstiloHeader(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 12);
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);
        style.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        return style;
    }
    
    private CellStyle criarEstiloPreco(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        DataFormat format = workbook.createDataFormat();
        style.setDataFormat(format.getFormat("R$ #,##0.00"));
        style.setAlignment(HorizontalAlignment.RIGHT);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        return style;
    }
    
    private CellStyle criarEstiloNormal(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setWrapText(true);
        return style;
    }
    
    private void criarCelulaComEstilo(Row row, int coluna, String valor, CellStyle style) {
        Cell cell = row.createCell(coluna);
        cell.setCellValue(valor);
        cell.setCellStyle(style);
    }
    
    private void criarCelulaComEstilo(Row row, int coluna, double valor, CellStyle style) {
        Cell cell = row.createCell(coluna);
        cell.setCellValue(valor);
        cell.setCellStyle(style);
    }
    
    private void criarCelulaComEstilo(Row row, int coluna, int valor, CellStyle style) {
        Cell cell = row.createCell(coluna);
        cell.setCellValue(valor);
        cell.setCellStyle(style);
    }
    
    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }
}
