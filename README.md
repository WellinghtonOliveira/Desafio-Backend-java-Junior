# Sistema de Gerenciamento de Tarefas — Desafio Backend Java Júnior

Este projeto foi desenvolvido com o objetivo de **praticar desenvolvimento backend em Java**, começando com uma implementação em **Java puro** e evoluindo para uma **API REST utilizando Spring Boot e PostgreSQL**.

A ideia foi primeiro entender completamente a **lógica do sistema e os fundamentos da linguagem**, e depois aplicar ferramentas utilizadas no mercado para estruturar uma aplicação backend mais próxima de um ambiente real.

## Estrutura do Repositório

O projeto foi separado em duas branches para demonstrar a evolução do desenvolvimento.

**main**  
Contém a primeira versão do projeto desenvolvida em **Java puro**, executada no terminal. Nessa etapa toda a lógica foi implementada sem frameworks, focando nos fundamentos da linguagem e em orientação a objetos.

**junior-java-SpringBoot**  
Contém a segunda versão do projeto reestruturada utilizando **Spring Boot**, transformando o sistema em uma **API REST com persistência em banco de dados PostgreSQL**.

## Versão 1 — Implementação em Java Puro

Na primeira etapa foi desenvolvido um sistema simples de gerenciamento de tarefas que roda no terminal e permite ao usuário interagir através de um menu.

Funcionalidades implementadas:

- Criar tarefa  
- Listar tarefas  
- Atualizar status da tarefa  
- Remover tarefa  

Cada tarefa possui:

- id  
- título  
- descrição  
- status (PENDENTE, EM_ANDAMENTO ou CONCLUIDA)  
- data de criação  

As tarefas são armazenadas em memória utilizando **List e ArrayList**.

Principais recursos do Java utilizados:

- Orientação a Objetos  
- Enum  
- Encapsulamento  
- List e ArrayList  
- Scanner para entrada de dados  
- LocalDate para manipulação de datas  

## Versão 2 — API REST com Spring Boot

Após finalizar a lógica em Java puro, o sistema foi refeito utilizando **Spring Boot**, criando uma **API REST completa com persistência em banco de dados**.

Tecnologias utilizadas:

- Java  
- Spring Boot  
- Spring Data JPA  
- Hibernate  
- PostgreSQL  
- Maven  

## Arquitetura da Aplicação

A aplicação segue o padrão de **arquitetura em camadas**:
``
Controller
↓
Service
↓
Repository
↓
Database (PostgreSQL)
``

Essa estrutura separa responsabilidades e facilita manutenção e escalabilidade.

## Estrutura de Pacotes

O projeto foi dividido em camadas:

- **controller** → endpoints da API  
- **service** → lógica de negócio  
- **repository** → acesso ao banco de dados  
- **model** → entidades da aplicação  
- **dto** → objetos de transferência de dados  

## Endpoints da API

Base da API:

/tarefas
Criar tarefa


Exemplo de body:

``json
{
  "titulo": "Estudar Spring",
  "descricao": "Aprender API REST"
}
``

Listar tarefas:
GET /tarefas

Buscar tarefa por id:
GET /tarefas/{id}

Atualizar status:
PUT /tarefas/{id}

Exemplo de body:
``
{
  "status": "CONCLUIDA"
}
``
Remover tarefa:
DELETE /tarefas/{id}
