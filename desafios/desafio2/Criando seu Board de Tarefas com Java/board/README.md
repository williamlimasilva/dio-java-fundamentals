# Sistema de Gerenciamento de Board

## Visão Geral

Este projeto é um Sistema de Gerenciamento de Board desenvolvido em Java. Ele permite que os usuários criem, gerenciem e excluam boards e cartões. O sistema utiliza vários padrões de design e princípios de engenharia de software para garantir um código robusto e de fácil manutenção.

## Funcionalidades

- Criar, selecionar e excluir boards
- Adicionar colunas aos boards
- Criar, mover, bloquear, desbloquear e cancelar cartões
- Visualizar detalhes do board, colunas e cartões

## Padrões de Design

- **Singleton**: Usado em `ConnectionConfig` para gerenciar conexões com o banco de dados.
- **Factory Method**: Usado para criar diferentes tipos de colunas de board.
- **Data Transfer Object (DTO)**: Usado para transferir dados entre camadas, por exemplo, `BoardColumnInfoDTO`.
- **Repository**: Usado para abstrair a camada de acesso a dados, por exemplo, `BoardService`, `CardService`.
- **Command**: Usado para encapsular solicitações como objetos, por exemplo, métodos em `BoardMenu` e `MainMenu`.

## Modelos de Engenharia de Software

- **Arquitetura em Camadas**: O projeto é dividido em camadas como UI, Serviço e Persistência.
- **MVC (Model-View-Controller)**: O projeto segue o padrão MVC onde `BoardEntity`, `CardEntity` são modelos, `MainMenu`, `BoardMenu` são controladores, e a saída do console atua como a visão.

## Estrutura de Diretórios

```
Criando seu Board de Tarefas com Java/board
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── br
│   │   │   │   ├── com
│   │   │   │   │   ├── dio
│   │   │   │   │   │   ├── dto
│   │   │   │   │   │   ├── persistence
│   │   │   │   │   │   │   ├── config
│   │   │   │   │   │   │   ├── entity
│   │   │   │   │   │   │   ├── repository
│   │   │   │   │   │   ├── service
│   │   │   │   │   │   ├── ui
│   │   │   │   │   │   │   ├── MainMenu.java
│   │   │   │   │   │   │   ├── BoardMenu.java
│   │   │   │   │   │   ├── util
│   │   │   ├── resources
│   │   ├── test
│   │   │   ├── java
│   │   │   ├── resources
│   ├── target
│   │   ├── classes
│   │   ├── test-classes
│   ├── pom.xml
│
├── README.md
```

## Começando

### Pré-requisitos

- Java 11 ou superior
- Banco de dados MySQL

### Configuração

1. Clone o repositório:
   ```sh
   git clone <repository-url>
   ```
2. Navegue até o diretório do projeto:
   ```sh
   cd board
   ```
3. Configure a conexão com o banco de dados em `ConnectionConfig.java`:
   ```java
   //Criando seu Board de Tarefas com Java/board/src/main/java/br/com/dio/persistence/config/ConnectionConfig.java
   var url = "jdbc:mysql://localhost/board";
   var user = "board";
   var password = "board";
   ```
4. Construa o projeto usando Maven:
   ```sh
   mvn clean install
   ```
5. Execute a aplicação:
   ```sh
   java -jar target/board-1.0-SNAPSHOT.jar
   ```

## Uso

Siga as instruções na tela para criar, gerenciar e excluir boards e cartões.

## Contribuindo

Contribuições são bem-vindas! Por favor, faça um fork do repositório e envie um pull request.

## Licença

Este projeto está licenciado sob a Licença MIT.
