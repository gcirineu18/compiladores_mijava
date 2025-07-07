# Team 08 - Entregas

### Entrega 1 - Analisador Léxico e Sintático:
Totalmente concluída ✅

### Entrega 2 - AST, Tabela de Símbolos e Verificação de Tipos:
Totalmente concluída ✅

### Entrega 3 - Registros de Ativação e Tradução para o Código Intermediário:
Totalmente concluída ✅

### Entrega 4 - Seleção de Instruções:
Totalmente concluída ✅

### Entrega 5 - Análise de Longevidade e Alocação de Registradores:
A fazer... ⏳

## Dependências
* Antlr4: https://www.antlr.org/
  * Ferramenta para gerar analisadores léxicos e sintáticos a partir de gramáticas definidas.
* Maven: https://maven.apache.org/
  * Gerenciador de dependências e construção de projetos Java.
* Spring Boot: https://spring.io/projects/spring-boot
  * Framework para desenvolvimento de aplicações Java, facilitando a configuração e inicialização de projetos.

## Como Executar
1. Clone o projeto e navegue para a pasta do projeto:
```bash
git clone https://gitlab.com/ufc-dc/compiler-construction-course-minijava-project-2025/team-08.git
cd team-08
```
2. Escolha qual arquivo você gostaria de testar na pasta: "src\main\resources\entrega1_tests"

3. Altere a linha 32 do arquivo [MijavaApplication.java](src\main\java\com\example\mijava\MijavaApplication.java) com o nome do arquivo escolhido

4. Execute o compilador colando no terminal o seguinte comando:
```bash
mvn spring-boot: run
```