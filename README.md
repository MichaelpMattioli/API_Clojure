# API em Clojure - Acessando produtos de uma loja

## Desenvolvedores
- Nome: Michael Pedroza Mattioli Leite      RA: 18.00688-4
- Nome: Gabriel Cardoso                     RA: 18.00477-6
- Nome: João Guilherme Martins dos Santos   RA: 18.00135-0

## Resumo
O projeto consiste em criar uma API com uma linguagem puramente funcional, 
## Prerequisitos

Voce precisará instalar [Leiningen][] 2.0.0 ou versão maior.

[leiningen]: https://github.com/technomancy/leiningen

### Tecnologias

- MySQL como banco de dados.
- Clojure.

## Para rodar o servidor web

Para rodar o servidor web será necessário digitar o código abaixo:

    lein run

### Informações lógicas do projeto
Serão consideradas essas as entidades principais.

**Pessoas:**
<br>
- id: int
- nome: string
- descricao: string
</br>
## Projeto

O projeto consistem em criar uma API que possa acessar o banco de dados MySQL e extrair informações dele. É possivel verificar na pasta do "API_CLOJURE" dentro de "src\projeto\main.clj" utilizamos a biblioteca "clojure.java.jdbc" para acessar o servidor do banco de dados e conseguir acessar o banco de dados "produtos". A partir de então utilizamos o pedestal para realizar administrar as requisições e construir os endpoints para realizar a consulta na API.

Podemos notar que com a linguagem Clojure é possivel construir a API de um jeito muita mais objetivo, evitando assim caminhos inesperados, o que torna muito util para as APIs, já que ou você realiza a consulta no endpoint correto ou não irá realizar a requisição adequadamente, retornando assim como no código "Not Found".

## MYSQL

Foi necessário criar um banco de dados inicialmente e uma tabela, alem de inserir alguns dados para consulta.

CREATE DATABASE produtos;

use produtos;

CREATE TABLE items (
    id INT NOT NULL AUTO_INCREMENTAL,
    nome VARCHAR(20),
    descricao VARCHAR(55),
    PRIMARY KEY(id)
);

INSERT INTO persons (nome, descricao)
VALUES ('teste', 'teste1')

## Consulta na API 

Pode ser vista no acesso local pela web com as seguintes URLs: 
<br>
- http://localhost:9981/alunos

&nbsp;&nbsp;&nbsp;Mostra os integrantes que desenvolveram a API

- http://localhost:9981/allItems

&nbsp;&nbsp;&nbsp;Mostra os items que estão no banco de dados
</br>