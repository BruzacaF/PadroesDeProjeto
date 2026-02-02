# MyHome - Plataforma de Classificados de Imóveis

## 📚 Informações do Projeto

**Curso:** Sistemas para Internet  
**Disciplina:** Padrões de Projeto de Software  
**Período:** 5º  
**Professor:** Alex Sandro da Cunha Rêgo  
**Instituição:** Instituto Federal da Paraíba (IFPB)

### 👥 Equipe
- Julielison Lima
- Filipe Bruzaca

---

## 📖 Descrição do Projeto

O **MyHome** é uma plataforma digital de classificados imobiliários que conecta proprietários, corretores, imobiliárias e potenciais compradores/locatários. O sistema permite que anunciantes publiquem anúncios detalhados de imóveis para venda ou aluguel, e que usuários possam pesquisar, filtrar e visualizar esses anúncios.

O projeto foi desenvolvido utilizando diversos padrões de projeto (Design Patterns) para garantir:
- Flexibilidade para expansão de novos tipos de imóveis e serviços
- Gerenciamento de diferentes formatos de pagamento e planos
- Mecanismo robusto de notificação através de múltiplos canais
- Processamento eficiente de buscas com múltiplos filtros

---

## 🏗️ Arquitetura e Estrutura do Projeto

### Organização de Pacotes

```
br.edu.ifpb.pps/
├── Anuncio/                      # Módulo de anúncios
│   ├── Anuncio.java              # Classe principal de anúncio
│   ├── EstadoAnuncio.java        # Interface do padrão State
│   ├── Moderador.java            # Classe que realiza moderação
│   ├── CoR/                      # Chain of Responsibility
│   │   ├── AbstractModeracaoHandler.java
│   │   ├── FiltroPrecoValidoHandler.java
│   │   ├── FiltroTermosProibidosHandler.java
│   │   └── ModeracaoHandler.java
│   ├── Decorator/                # Filtros de busca
│   │   ├── Filtro.java
│   │   ├── FiltroBase.java
│   │   ├── FiltroDecorator.java
│   │   └── Filtros/
│   ├── Estados/                  # Padrão State
│   │   ├── Rascunho.java
│   │   ├── Moderacao.java
│   │   ├── Ativo.java
│   │   ├── Vendido.java
│   │   └── Suspenso.java
│   └── Visitor/                  # Padrão Visitor
│       ├── AnuncioVisitor.java
│       ├── ExportadorJSON.java
│       ├── ExportadorExcel.java
│       └── RelatorioEstatistico.java
├── config/                       # Configurações
│   └── ConfiguracaoSistema.java  # Singleton
├── Enums/                        # Enumerações
│   ├── EstadoAnuncioEnum.java
│   ├── ImovelTipo.java
│   ├── TipoAnuncio.java
│   └── UsuarioTipo.java
├── Factory/                      # Factory Pattern
│   └── UsuarioFactory.java
├── imovel/                       # Módulo de imóveis
│   ├── Imovel.java
│   ├── DadosImovel.java
│   ├── PrototypeImovel.java
│   ├── CatalogoPrototiposImovel.java
│   ├── CatalogoGlobalPrototipos.java  # Singleton
│   ├── builder/                  # Builder Pattern
│   │   ├── ImovelBuilder.java
│   │   ├── ImovelDirector.java
│   │   └── tiposBuilder/
│   ├── templateMethod/           # Template Method
│   │   ├── PrototipoTemplateImovel.java
│   │   └── templates/
│   └── tipoImovel/
├── Logger/                       # Sistema de logs
│   └── LoggerAnuncio.java        # Singleton
├── Notificacao/                  # Sistema de notificações
│   ├── NotificacaoObserver.java  # Observer Pattern
│   ├── NotificacaoStrategy.java  # Strategy Pattern
│   └── tiposNotificacao/
│       ├── NotificacaoEmailStrategy.java
│       ├── NotificacaoWhatsAppStrategy.java
│       └── TipoNotificacao.java
├── repository/                   # Repositórios
│   ├── AnuncioRepository.java    # Singleton
│   ├── UsuarioRepository.java    # Singleton
│   └── repositoryConfig/
├── Suporte/
│   └── MotorBusca.java
└── Usuario/                      # Módulo de usuários
    ├── Usuario.java
    └── tiposUsuario/
```

---

## 🎯 Padrões de Projeto Utilizados

### 1. **Singleton** (Criacional)
**Onde:** `ConfiguracaoSistema`, `LoggerAnuncio`, `CatalogoGlobalPrototipos`, `AnuncioRepository`, `UsuarioRepository`

**Propósito:** Garantir que existe apenas uma instância de classes críticas do sistema.

**Implementação:**
- **ConfiguracaoSistema**: Carrega configurações do arquivo `config.properties` uma única vez e disponibiliza globalmente
- **LoggerAnuncio**: Centraliza o registro de logs em um único arquivo
- **CatalogoGlobalPrototipos**: Mantém um catálogo único de protótipos de imóveis
- **Repositórios**: Garantem gerenciamento centralizado de anúncios e usuários

**Requisito atendido:** RF07 - Configuração Centralizada

---

### 2. **Builder** (Criacional)
**Onde:** `imovel/builder/`
- `ImovelBuilder.java` (interface)
- `ImovelDirector.java` (diretor)
- `tiposBuilder/` (builders concretos)

**Propósito:** Construir objetos complexos (imóveis) passo a passo, com diferentes configurações.

**Implementação:**
- Cada tipo de imóvel (Casa, Apartamento, Terreno, etc.) tem seu próprio Builder
- O Director coordena a construção
- Permite criar imóveis com características específicas de forma organizada

**Requisito atendido:** RF01 - Criação de Anúncios (construção flexível de diferentes tipos de imóveis)

---

### 3. **Prototype** (Criacional)
**Onde:** `imovel/PrototypeImovel.java`, `CatalogoPrototiposImovel.java`, `CatalogoGlobalPrototipos.java`

**Propósito:** Criar novos objetos clonando protótipos existentes, evitando construção completa do zero.

**Implementação:**
- Protótipos globais pré-configurados (apartamento padrão, casa padrão)
- Permite clonar e personalizar protótipos com alterações específicas
- Otimiza criação de anúncios similares

**Requisito atendido:** RF02 - Instâncias de anúncios padrão para certos tipos de imóveis

---

### 4. **Template Method** (Comportamental)
**Onde:** `imovel/templateMethod/`
- `PrototipoTemplateImovel.java` (template)
- `templates/CriarPrototipoDoZero.java`
- `templates/ClonarPrototipoGlobal.java`

**Propósito:** Define o esqueleto de um algoritmo, permitindo que subclasses sobrescrevam passos específicos.

**Implementação:**
- Define o fluxo de criação/clonagem de imóveis
- Cada template implementa etapas específicas (criar do zero ou clonar)
- Mantém a estrutura geral do processo intacta

**Requisito atendido:** RF01 e RF02 - Flexibilidade na criação de imóveis

---

### 5. **Factory Method** (Criacional)
**Onde:** `Factory/UsuarioFactory.java`

**Propósito:** Criar diferentes tipos de usuários sem especificar suas classes concretas.

**Implementação:**
- Cria usuários baseado no tipo (Anunciante, Comprador, etc.)
- Encapsula a lógica de criação
- Facilita adição de novos tipos de usuário

**Requisito atendido:** Gestão de diferentes perfis de usuários

---

### 6. **State** (Comportamental)
**Onde:** `Anuncio/Estados/`
- `EstadoAnuncio.java` (interface)
- `Rascunho.java`, `Moderacao.java`, `Ativo.java`, `Vendido.java`, `Suspenso.java`

**Propósito:** Permitir que um anúncio altere seu comportamento quando seu estado interno muda.

**Implementação:**
- Ciclo de vida: Rascunho → Moderação → Ativo → Vendido/Suspenso
- Cada estado define transições permitidas
- Notificações automáticas e logs em cada mudança de estado

**Requisito atendido:** RF04 - Fases do ciclo de vida de um anúncio

---

### 7. **Chain of Responsibility (CoR)** (Comportamental)
**Onde:** `Anuncio/CoR/`
- `ModeracaoHandler.java` (interface)
- `AbstractModeracaoHandler.java` (handler abstrato)
- `FiltroPrecoValidoHandler.java`
- `FiltroTermosProibidosHandler.java`

**Propósito:** Processar requisições através de uma cadeia de handlers, onde cada um pode processar ou passar adiante.

**Implementação:**
- Validações em sequência: termos proibidos → preço válido → outros filtros
- Cada handler pode aprovar, reprovar ou passar para o próximo
- Fácil adicionar novas regras de moderação

**Requisito atendido:** RF03 - Publicação e Moderação (regras dinâmicas)

---

### 8. **Observer** (Comportamental)
**Onde:** `Notificacao/NotificacaoObserver.java`

**Propósito:** Definir dependência um-para-muitos, onde mudanças em um objeto notificam automaticamente seus observadores.

**Implementação:**
- Anúncios notificam observers quando mudam de estado
- Múltiplos observers podem ser registrados
- Cada observer pode ter múltiplas strategies de notificação

**Requisito atendido:** RF05 - Notificação do usuário (notificação automática)

---

### 9. **Strategy** (Comportamental)
**Onde:** `Notificacao/`
- `NotificacaoStrategy.java` (interface)
- `tiposNotificacao/NotificacaoEmailStrategy.java`
- `tiposNotificacao/NotificacaoWhatsAppStrategy.java`
- `TipoNotificacao.java` (enum)

**Propósito:** Definir família de algoritmos intercambiáveis (canais de notificação).

**Implementação:**
- Strategy para Email (implementado com JavaMail)
- Strategy para WhatsApp (estrutura preparada)
- Fácil adicionar SMS, Telegram, Push Notification
- Usuário escolhe seu canal preferido

**Requisito atendido:** RF05 - Notificação do usuário (múltiplos canais)

---

### 10. **Decorator** (Estrutural)
**Onde:** `Anuncio/Decorator/`
- `Filtro.java` (interface)
- `FiltroBase.java` (componente base)
- `FiltroDecorator.java` (decorator abstrato)
- `Filtros/` (decorators concretos)

**Propósito:** Adicionar responsabilidades dinamicamente a objetos (filtros de busca).

**Implementação:**
- FiltroBase retorna todos os anúncios
- Decorators adicionam filtros: preço, localização, área, quartos, tipo de imóvel
- Filtros podem ser combinados dinamicamente
- Novos filtros adicionados sem modificar código existente

**Requisito atendido:** RF06 - Busca Avançada (filtros dinâmicos e combinados)

---

### 11. **Visitor** (Comportamental)
**Onde:** `Anuncio/Visitor/`
- `AnuncioVisitor.java` (interface)
- `ExportadorJSON.java`
- `ExportadorExcel.java` (com Apache POI)
- `RelatorioEstatistico.java`

**Propósito:** Adicionar novas operações a objetos sem modificar suas classes.

**Implementação:**
- Exportação para JSON (formato texto)
- Exportação para Excel (arquivo .xlsx real com formatação)
- Relatórios estatísticos (métricas e análises)
- Novos formatos podem ser adicionados facilmente

**Requisito atendido:** RF08 - Novo requisito (geração de relatórios em múltiplos formatos)

**Detalhes:** Consulte o arquivo [VISITOR_PATTERN.md](VISITOR_PATTERN.md) para documentação completa.

---

## 📋 Resolução dos Requisitos Funcionais

### RF01 - Criação de Anúncios
**Solução:** Padrões **Builder** + **Factory**
- Builder para construção flexível de diferentes tipos de imóveis
- Factory para criação de usuários
- Cada tipo de imóvel tem características específicas (atributos próprios)
- Extensível para novos tipos sem modificar código existente

### RF02 - Instâncias de anúncios padrão
**Solução:** Padrões **Prototype** + **Singleton**
- CatalogoGlobalPrototipos (Singleton) mantém protótipos pré-configurados
- Protótipos podem ser clonados e personalizados
- Otimiza criação de anúncios similares

### RF03 - Publicação e Moderação
**Solução:** Padrão **Chain of Responsibility**
- Cadeia de handlers de validação
- Validações: termos proibidos, preço válido, etc.
- Regras dinâmicas e extensíveis
- Lê termos proibidos do arquivo config.properties

### RF04 - Ciclo de vida de anúncios
**Solução:** Padrões **State** + **Observer** + **Singleton** (Logger)
- State: gerencia transições entre estados
- Observer: notifica mudanças de estado
- Logger: registra todas as transições em arquivo de log
- Fluxo: Rascunho → Moderação → Ativo → Vendido/Suspenso

### RF05 - Notificação do usuário
**Solução:** Padrões **Observer** + **Strategy**
- Observer: padrão de notificação
- Strategy: múltiplos canais (Email, WhatsApp)
- Email implementado funcionalmente com JavaMail
- Configurações SMTP em config.properties
- Usuário define canal preferido

### RF06 - Busca Avançada
**Solução:** Padrão **Decorator**
- FiltroBase retorna todos os anúncios
- Decorators adicionam filtros específicos
- Filtros combinados dinamicamente
- Extensível para novos critérios

### RF07 - Configuração Centralizada
**Solução:** Padrão **Singleton**
- ConfiguracaoSistema carrega config.properties
- Acesso global às configurações
- Taxas, limites, termos proibidos, URLs de serviços

### RF08 - Novo Requisito (Geração de Relatórios)
**Solução:** Padrão **Visitor**
- Exportação JSON: formato texto estruturado
- Exportação Excel: arquivo .xlsx com Apache POI
- Relatórios Estatísticos: métricas e análises
- Extensível para novos formatos (PDF, CSV, etc.)

---

## 🚀 Como Executar o Projeto

### Pré-requisitos

1. **Java Development Kit (JDK) 23 ou superior**
   - Verifique: `java -version`
   - Download: [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) ou [OpenJDK](https://openjdk.org/)

2. **Apache Maven 3.6+**
   - Verifique: `mvn -version`
   - Download: [Maven](https://maven.apache.org/download.cgi)

3. **IDE (Recomendado)**
   - IntelliJ IDEA, Eclipse ou VS Code com extensões Java

### Configuração

1. **Clone o repositório:**
   ```bash
   git clone [URL_DO_REPOSITORIO]
   cd PadroesDeProjeto
   ```

2. **Configure o arquivo `.env` (para notificações por email):**
- **Obs. para o professor:** Julielison enviou as credencias via Gchat para facilitar.
   
   Crie um arquivo `.env` na raiz do projeto:
   ```properties
   EMAIL_REMETENTE=seu_email@gmail.com
   EMAIL_SENHA=sua_senha_de_aplicativo
   ```
   
   **(ignore caso já tenha a senha app) Importante para Gmail:**
   - Ative a verificação em 2 etapas
   - Gere uma "Senha de App" em: https://myaccount.google.com/apppasswords
   - Use a senha de app (não sua senha normal)

3. **Verifique o arquivo de configuração:**
   
   O arquivo `src/main/resources/config.properties` contém:
   ```properties
   taxa.comissao=0.05
   limite.upload.fotos=10
   termos.TermosProibidos=palavrão1,palavrão2,palavrão3
   url.servico.notificacao=https://api.notificacao.com
   email.smtp.host=smtp.gmail.com
   email.smtp.port=587
   ```

### Compilação e Execução

#### Opção 1: Usando Maven (Linha de comando)

```bash
# Limpar e compilar
mvn clean compile

# Executar
mvn exec:java -Dexec.mainClass="br.edu.ifpb.pps.Main"

# Ou gerar JAR e executar
mvn clean package
java -jar target/MyHome-1.0-SNAPSHOT.jar
```

#### Opção 2: Usando IDE

**IntelliJ IDEA:**
1. Abra o projeto (File → Open → selecione a pasta do projeto)
2. Aguarde o Maven baixar as dependências
3. Localize a classe `Main.java`
4. Clique com botão direito → Run 'Main.main()'

**Eclipse:**
1. Import → Existing Maven Projects
2. Selecione a pasta do projeto
3. Aguarde configuração automática
4. Run As → Java Application (selecione Main)

**VS Code:**
1. Abra a pasta do projeto
2. Instale extensões: "Java Extension Pack" e "Maven for Java"
3. F5 ou Run → Run Without Debugging

---

## 📦 Dependências do Projeto

O projeto utiliza as seguintes bibliotecas (gerenciadas pelo Maven):

```xml
<!-- Envio de emails -->
<dependency>
    <groupId>com.sun.mail</groupId>
    <artifactId>javax.mail</artifactId>
    <version>1.6.2</version>
</dependency>

<!-- Carregamento de variáveis de ambiente (.env) -->
<dependency>
    <groupId>io.github.cdimascio</groupId>
    <artifactId>dotenv-java</artifactId>
    <version>3.0.0</version>
</dependency>

<!-- Geração de arquivos Excel -->
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.2.5</version>
</dependency>

<!-- Sistema de logs -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.21.1</version>
</dependency>
```

---

## 📊 Diagrama de Classes

[Incluir aqui o diagrama de classes do projeto, destacando onde cada padrão foi aplicado]

*Nota: O diagrama deve mostrar:*
- Relacionamentos entre classes principais
- Marcações indicando cada padrão de projeto
- Hierarquias e interfaces
- Multiplicidades

---

## 🧪 Funcionalidades Demonstradas

O arquivo `Main.java` demonstra:

1. ✅ **Criação de usuário** (Factory)
2. ✅ **Criação de imóvel do zero** (Builder + Template Method)
3. ✅ **Clonagem de protótipo global** (Prototype + Singleton)
4. ✅ **Criação de anúncios**
5. ✅ **Notificações com múltiplos observers** (Observer + Strategy)
6. ✅ **Mudanças de estado** (State + Observer + Logger)
7. ✅ **Moderação de anúncios** (Chain of Responsibility)
8. ✅ **Busca com filtros dinâmicos** (Decorator)
9. ✅ **Exportação de relatórios** (Visitor)
   - JSON
   - Excel (.xlsx)
   - Estatísticas

---

## 📁 Arquivos Gerados

Durante a execução, o sistema gera:

- **`logs/anuncios.log`**: Registro de todas as mudanças de estado dos anúncios
- **`relatorio_anuncios_[timestamp].xlsx`**: Relatório Excel dos anúncios

---

## 🔧 Configurações Avançadas

### Personalizar termos proibidos
Edite `src/main/resources/config.properties`:
```properties
termos.TermosProibidos=termo1,termo2,termo3
```

### Alterar limite de fotos
```properties
limite.upload.fotos=15
```

### Configurar servidor SMTP diferente
```properties
email.smtp.host=smtp.seu-servidor.com
email.smtp.port=465
```

---

## 🎓 Aprendizados e Decisões de Design

### Por que tantos padrões?
O projeto foi desenvolvido como exercício acadêmico para demonstrar domínio de múltiplos padrões de projeto em um contexto coeso e realista.

### Originalidade
- Implementação real de envio de emails (não apenas print)
- Geração real de arquivos Excel com formatação
- Sistema de logs persistente
- Integração harmoniosa de 11 padrões diferentes

### Extensibilidade
O sistema foi projetado para facilitar:
- Novos tipos de imóveis (criar novo Builder)
- Novos canais de notificação (criar nova Strategy)
- Novas regras de moderação (adicionar Handler)
- Novos formatos de exportação (criar novo Visitor)
- Novos filtros de busca (criar novo Decorator)

---

## 🐛 Troubleshooting

### Erro ao enviar email
- Verifique se o arquivo `.env` está configurado
- Confirme que está usando senha de aplicativo (Gmail)
- Verifique conexão com internet

### Arquivo de log não criado
- Verifique permissões de escrita na pasta `logs/`
- O diretório é criado automaticamente

### Erro ao gerar Excel
- Verifique se a dependência Apache POI foi baixada
- Execute `mvn clean install`

### Dependências não baixadas
```bash
mvn clean install -U
```

---

## 📝 Licença

Este projeto foi desenvolvido para fins acadêmicos no IFPB.

---