# Padrão Visitor - Exportação de Relatórios

## RF08 - Geração de Relatórios em Múltiplos Formatos

### Descrição do Requisito
O sistema deve permitir a geração de relatórios de anúncios em diferentes formatos (JSON, PDF, estatísticas) sem modificar a classe `Anuncio`. Novos formatos de exportação podem ser adicionados dinamicamente sem alterar o código existente.

### Padrão de Projeto Utilizado: **Visitor** (Comportamental)

## Estrutura da Implementação

### 1. Interface Visitor
**Arquivo:** `AnuncioVisitor.java`

```java
public interface AnuncioVisitor {
    void visitar(Anuncio anuncio);
    String obterResultado();
}
```

### 2. Elemento Visitável
**Arquivo:** `Anuncio.java`

```java
public void accept(AnuncioVisitor visitor) {
    visitor.visitar(this);
}
```

### 3. Visitantes Concretos

#### ExportadorJSON
- **Propósito:** Exporta anúncios para formato JSON
- **Saída:** String formatada em JSON válido
- **Uso:** Integração com APIs, arquivos de configuração

#### ExportadorExcel
- **Propósito:** Gera arquivo Excel real (.xlsx) com Apache POI
- **Saída:** Arquivo Excel formatado com estilos e bordas
- **Recursos:**
  - Cabeçalho com fundo azul escuro e texto branco
  - Formatação automática de preços em reais
  - Bordas em todas as células
  - Ajuste automático de largura das colunas
  - Nome de arquivo com timestamp
- **Uso:** Relatórios empresariais, análise de dados, importação em outras ferramentas

#### RelatorioEstatistico
- **Propósito:** Calcula métricas e estatísticas dos anúncios
- **Métricas calculadas:**
  - Preço médio, mínimo e máximo
  - Área média dos imóveis
  - Distribuição por tipo de imóvel
  - Distribuição por quantidade de quartos
- **Uso:** Análise de mercado, tomada de decisão

## Vantagens da Implementação

### ✅ Extensibilidade
- Novos formatos de exportação podem ser adicionados criando novas classes visitor
- Não é necessário modificar a classe `Anuncio` ou outras classes existentes

### ✅ Separação de Responsabilidades
- Lógica de exportação separada da lógica de negócio
- Cada visitor tem uma responsabilidade específica e bem definida

### ✅ Facilita Manutenção
- Mudanças em um formato de exportação não afetam outros formatos
- Código organizado e fácil de entender

### ✅ Reutilização
- Os mesmos visitors podem processar diferentes coleções de anúncios
- Visitors podem ser combinados e reutilizados em diferentes contextos

## Exemplo de Uso

```java
// Obter anúncios do repositório
List<Anuncio> anuncios = AnuncioRepository.getInstancia().listarTodos();

// Exportar para JSON
AnuncioVisitor exportadorJSON = new ExportadorJSON();
for (Anuncio anuncio : anuncios) {
    anuncio.accept(exportadorJSON);
}
System.out.println(exportadorJSON.obterResultado());

// Exportar para Excel (gera arquivo .xlsx)
AnuncioVisitor exportadorExcel = new ExportadorExcel();
for (Anuncio anuncio : anuncios) {
    anuncio.accept(exportadorExcel);
}
System.out.println(exportadorExcel.obterResultado());
// Arquivo gerado: relatorio_anuncios_YYYYMMDD_HHMMSS.xlsx

// Gerar estatísticas
AnuncioVisitor relatorioEstatistico = new RelatorioEstatistico();
for (Anuncio anuncio : anuncios) {
    anuncio.accept(relatorioEstatistico);
}
System.out.println(relatorioEstatistico.obterResultado());
```

## Expansão Futura

Novos visitors podem ser facilmente adicionados para:
- **ExportadorXML**: Exportação para formato XML
- **ExportadorPDF**: Geração de documentos PDF com iText ou PDFBox
- **CalculadorComissao**: Cálculo de comissões por anúncio
- **ValidadorDados**: Validação de consistência dos dados
- **GeradorHTML**: Geração de páginas web estáticas
- **CompactadorAnuncio**: Versão resumida para listagens

## Diagrama de Classes

```
         <<interface>>
       AnuncioVisitor
    +visitar(Anuncio)
    +obterResultado()
              △
              │
    ┌─────────┼─────────┐
    │         │         │
ExportadorJSON  ExportadorExcel  RelatorioEstatistico


        Anuncio
    +accept(visitor)
```

## Dependências

### Apache POI
Biblioteca utilizada para geração de arquivos Excel:
```xml
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.2.5</version>
</dependency>
```

## Estrutura do Arquivo Excel Gerado

- **Cabeçalho:** Fundo azul escuro, texto branco, centralizado
- **Colunas:** #, Título, Descrição, Preço (R$), Anunciante, Tipo Imóvel, Área (m²), Endereço, Quartos, Banheiros, Vagas
- **Formatação de Preço:** Formato brasileiro (R$ #.##0,00)
- **Bordas:** Todas as células têm bordas
- **Largura:** Ajuste automático com espaço extra
- **Nome do arquivo:** `relatorio_anuncios_YYYYMMDD_HHMMSS.xlsx`

## Conclusão

O padrão Visitor foi implementado com sucesso para atender ao **RF08**, proporcionando uma solução elegante e extensível para exportação de anúncios em múltiplos formatos. A implementação demonstra os princípios SOLID, especialmente o **Open/Closed Principle** (aberto para extensão, fechado para modificação).
