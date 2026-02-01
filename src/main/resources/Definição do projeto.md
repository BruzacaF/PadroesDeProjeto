**Curso:** Sistemas para Internet  
**Disciplina:** Padrões de Projeto de Software   
**Período:** 5º  
**Professor:** Alex Sandro da Cunha Rêgo

**Plataforma de Classificados de Imóveis**  
*(Problema multi-pattern – Em Desenvolvimento)*

**I – Introdução ao Problema:** 

O **MyHome** é uma plataforma digital de classificados imobiliários que conecta proprietários, corretores, imobiliárias e potenciais compradores/locatários. Este sistema deve permitir que Proprietários ou Corretores de Imóveis (Anunciantes) publiquem anúncios detalhados de imóveis para venda ou aluguel, e que usuários comuns (Compradores/Inquilinos) possam pesquisar, filtrar e visualizar esses anúncios.

O **MyHome** deve ser capaz de lidar com **diferentes tipos de imóvei**s (casas, apartamentos, terrenos, imóveis comerciais), múltiplos tipos de anúncios (venda, aluguel, temporada), e diversos perfis de usuários com permissões distintas, de tal maneira que seja flexível para futuras expansões. 

Neste projeto, o **MyHome** será planejado e implementado para contemplar os requisitos funcionais e não funcionais que a plataforma deve atender.  Na definição de sua arquitetura, para atender à demanda de mercado, o sistema deve permitir que:

1) Seja fácil expandir para novos tipos de imóveis e serviços;  
2) Gerenciar diferentes formatos de pagamento e planos de assinatura;  
3) Prover um mecanismo de notificação de usuários através de múltiplos canais (email, SMS, push, WhatsApp, etc.);  
4) Processar buscas com múltiplos filtros.

**II – Requisitos Funcionais e Não Funcionais**

**a)  Gestão de Imóveis (Anúncios)**

**RF01 \- Criação de Anúncios**

* O sistema deve permitir o **cadastro de anúncios** de diferentes tipos de imóveis (Casa, Apartamento, Terreno, Sala Comercial, Galpão, ou outro que aparecer). O processo de criação de um anúncio deve ser guiado, garantindo que as informações obrigatórias para cada tipo de imóvel sejam coletadas de forma correta. Alguns atributos de anúncios são obrigatórios a saber: título,  tipo do imóvel e preço.  
* Cada tipo de imóvel possui características específicas. Por exemplo, o apartamento tem andar, pode ter elevador; uma casa tem quintal. E assim por diante.  
* O sistema **deve ser flexível** para adicionar novos tipos de imóveis sem modificar código existente


  

  **RF02 \- Instâncias de anúncios padrão para certos tipos de imóveis** 

* Certos tipos de anúncios de imóveis, quando criados, devem iniciar com uma configuração padrão. Por exemplo, um anúncio de  Apartamento pode ser criado com o tipo já definido, como uma unidade habitacional em condomínio, com 2 quartos, com área de 60 m2. Da mesma forma, para anúncios de casas, pode ser definida uma configuração padrão. E outras configurações poderão surgir no futuro  
    
    
  **RF03 \- Publicação e Moderação** 

* O anunciante tem o poder de submeter um anúncio. Porém, todos os anúncios submetidos devem passar por uma etapa de moderação antes de se tornarem públicos. As regras de moderação são dinâmicas e devem ser aprovadas para que o anúncio seja publicado.


  A moderação pode ser manual ou automatizada (dependendo de regras). Por exemplo, o título e a descrição não podem conter termos proibidos (e.g. palavras de baixo calão, termos pejorativos palavras inadequadas). Outro exemplo de validação é verificar se o preço é condizente, a fim de evitar anúncios com preços igual a zero, um real, ou um valor sem sentido.

  Outro exemplo é verificar se o anúncio tem ao menos uma foto ou uma quantidade mínima de texto na descrição. 

  **RF04 \- Fases  do ciclo de vida de um anúncio** 

* Cada anúncio deve ter um ciclo de vida (ex: Rascunho, Pendente de Moderação, Ativo, Vendido/Alugado, Suspenso). Sempre que um anúncio mudar de estado, o anunciante deve ser notificado automaticamente (Veja mecanismos de notificação). Além do anunciante ser notificado, um mecanismo de Log também deve reter a informação sobre a mudança do status.


  O fluxo de estados do anúncio segue esta lógica:

  (i) Rascunho: Estado inicial. Fica no estado até que seja enviado para moderação.

  (ii) Moderação: o anúncio está em revisão e vai passar por checagem automática

  (iii) Ativo: anúncio aprovado e visível. Ele pode ser vendido ou suspenso

  (iv) Vendido: estado final (arquivado)

  (v) Suspenso: reprovado na moderação ou retirado pelo usuário. Volta para rascunho


  
**b)  Mecanismos de notificação do usuário**

**RF05 \- Notificação do usuário**

* O sistema deve notificar usuários sobre eventos que podem surgir ao longo do ciclo de vida do sistema (futuro), por exemplo: publicação de um anúncio de seu interesse (não implementado nesta etapa).  
* A solução deve ser flexível para alterar o canal de notificação  
* Notificações podem ser enviadas via: Email, SMS, Telegram e/ou WhatsApp  
* O usuário define a preferência do canal que deseja ser notificado  
* Uma das opções citadas deve ser implementada na prática, e não com a exibição de mensagem na tela

**c)  Pesquisa e Visualização**

**RF06 \- Busca Avançada**

* Usuários podem buscar imóveis aplicando múltiplos critérios de filtragem tais como: faixa de preço, localização, área, número de quartos;  
* Filtros podem ser combinados dinamicamente.  
* O sistema deve suportar filtros específicos por tipo de imóvel  
* O sistema deve permitir que novos filtros sejam adicionados dinamicamente no futuro sem modificar o código de busca principal

**d)  Estrutura e Extensibilidade**

**RF07 \- Configuração Centralizada**

* O sistema deve carregar configurações como taxas de comissão padrão, limites de upload de fotos, os termos impróprios no texto dos anúncios ou URLs de serviços externos a partir de uma fonte única e acessível globalmente. As informações de configuração devem ser carregadas de um arquivo .properties (ou equivalente)


**4\)  Novo Requisito**

**RF08 \- Adicionar um novo padrão**

* Adicione um novo requisito, coerente, e funcional, no escopo do projeto, que possa ser resolvido com um padrão de projeto adicional (não usado para atender os requisitos anteriores)  
  


  
**III – Requisitos de Execução**

Em linhas gerais, os projetos de sistema devem atender às seguintes exigências:

* **E1** \- Povoar os dados automaticamente a partir de arquivos CSV. Isso evita digitações iniciais para poder testar o sistema  
* **E2** \- Não defina chamadas de system.out.println() dentro de métodos. Fazer com que o fluxo de mensagens seja exibida da forma mais correta possível (facilitar o reuso)

**IV – Entrega**

O projeto deve ser desenvolvido empregando os padrões de projeto adequados para cumprimento dos requisitos do sistema. Ao submeter o projeto, certifique-se de fornecer os seguintes itens obrigatórios:

1) Diagrama de classes da solução, indicando onde os padrões se encaixam;  
2) Fornecer um README.MD bem documentado com todas as informações do projeto (Disciplina, período, professor, equipe, classes, padrões utilizados e onde, descrição da solução e como colocar o projeto em funcionamento, especificação de como cada requisito foi resolvido)   
3) Fornecer a pasta com todos os arquivos da aplicação, de preferência um link do github.

Imponham fidelidade quanto ao entendimento do domínio do problema em questão. Busque informações na web ou outras fontes fidedignas que julgar necessárias.

Soluções originais, mesmo que usando o mesmo padrão de projeto usado por outras equipes, **terão maior pontuação**.

**🚨 IMPORTANTE**

* README.MD é um dos itens de avaliação;  
* Soluções que não rodarem no computador do professor também terão redução da nota. Certificar que as instruções para colocar o projeto em execução estão claras e são suficientes.  
* Soluções enviesadas observadas em todos os projetos terão menor peso (o padrão pode ser correto, mas se for igual a implementação de outras equipes, haverá redução)  
* Submissões enviadas após o prazo terão redução de 1,0 ponto na nota final. E após o prazo máximo, não serão apresentadas.

