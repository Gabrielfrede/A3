# Sistema de Controle de Estoque

## Sobre o Projeto

Este projeto foi desenvolvido para a disciplina de *Programação de Soluções Computacionais*.

O sistema tem como objetivo realizar o controle de estoque de uma empresa, permitindo o cadastro de produtos, categorias, movimentações de entrada e saída e a geração de relatórios gerenciais.

---

## Integrantes

* Gabriel Frederico Kuhl
* Guilherme Vasconcellos Bardalho
* Josue Cravo Bairrao
* Lucas Adão Longo
* Pedro Felipe Soares Pacheco Vieira

---

## Professores

* Luciano Figueiredo Coelho
* Jorge Werner

---

## Tecnologias Utilizadas

* Java
* Java Swing
* JDBC
* MySQL
* Maven
* GitHub

---

## Funcionalidades

### Produtos

* Cadastro de produtos
* Alteração de produtos
* Exclusão de produtos
* Consulta de produtos

### Categorias

* Cadastro de categorias
* Gerenciamento de categorias

### Movimentação de Estoque

* Entrada de produtos
* Saída de produtos
* Atualização automática do estoque

### Relatórios

* Lista de preços
* Balanço físico e financeiro
* Produtos abaixo da quantidade mínima
* Quantidade de produtos por categoria
* Produto com maior entrada e saída
* Reajuste percentual de preços

---

## Estrutura do Projeto

text
src/
├── model
├── dao
├── service
├── view
├── util
└── main

database/
└── script.sql

 


---

## Banco de Dados

O sistema utiliza MySQL.

Execute o script localizado em:

text
database/script_banco.sql


para criar todas as tabelas necessárias.

---

## Como Executar

1. Clonar o repositório.
2. Criar o banco de dados MySQL utilizando o script SQL.
3. Configurar usuário e senha na classe ConexaoBanco.
4. Abrir o projeto no NetBeans.
5. Executar o projeto.

---

## Repositório

https://github.com/Gabrielfrede/A3

---

## Licença

Projeto desenvolvido exclusivamente para fins acadêmicos.