# Desafio Backend Java Júnior
## Sistema de Gerenciamento de Tarefas

Uma pequena empresa precisa de um sistema simples para gerenciar tarefas internas.

O objetivo deste desafio é desenvolver uma aplicação utilizando **Java puro (sem frameworks)** que permita cadastrar e gerenciar tarefas.  
O foco do projeto é praticar **lógica de programação, orientação a objetos e organização de código**, habilidades fundamentais para desenvolvimento backend.

---

# Requisitos do Sistema

O sistema deve permitir as seguintes operações:

## 1. Criar uma tarefa

Cada tarefa deve possuir os seguintes atributos:

- `id` (gerado automaticamente)
- `titulo`
- `descricao`
- `status`
- `dataCriacao`

### Status possíveis

- `PENDENTE`
- `EM_ANDAMENTO`
- `CONCLUIDA`

---

## 2. Listar todas as tarefas

O sistema deve exibir todas as tarefas cadastradas.

### Exemplo de saída


ID: 1
Titulo: Estudar Java
Status: PENDENTE
Data: 15/03/2026


---

## 3. Atualizar status da tarefa

O usuário deve conseguir alterar o status de uma tarefa informando o **ID**.

### Exemplo


Digite o ID da tarefa: 1
Novo status: CONCLUIDA


---

## 4. Remover uma tarefa

O usuário deve conseguir remover uma tarefa utilizando o **ID**.

---

# Regras Técnicas

O projeto deve conter pelo menos as seguintes estruturas:

## Classe `Tarefa`

Responsável por representar o modelo da tarefa.

---

## Enum `StatusTarefa`

Define os possíveis status de uma tarefa.

---

## Classe `GerenciadorTarefas`

Responsável pela lógica do sistema:

- armazenar tarefas
- criar tarefas
- listar tarefas
- atualizar tarefas
- remover tarefas

---

## Classe `Main`

Responsável pela interação com o usuário através de um **menu no terminal**.

---

# Menu Esperado

Exemplo de funcionamento do sistema:


1 - Criar tarefa
2 - Listar tarefas
3 - Atualizar status
4 - Remover tarefa
5 - Sair


---

# Requisitos Técnicos

A implementação deve utilizar:

- `List`
- `ArrayList`
- `LocalDate`
- `Scanner`
- `Enum`
- `Orientação a Objetos`

---

# Objetivo do Desafio

Este projeto tem como objetivo praticar conceitos importantes do desenvolvimento backend:

- Modelagem de classes
- Organização de código
- Estruturas de dados
- Manipulação de listas
- Uso de enums
- Separação de responsabilidades
- Lógica de programação

Essas habilidades são fundamentais para evoluir posteriormente para frameworks como **Spring Boot** e desenvolvimento de **APIs REST**.

---