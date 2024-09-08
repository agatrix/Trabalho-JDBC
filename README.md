# Projeto Java de POO com Banco de Dados

## Descrição

Este projeto é uma aplicação Java utilizando Programação Orientada a Objetos (POO) para gerenciar usuários em um banco de dados MySQL. A aplicação se conecta ao banco de dados `UserDatabase`, que contém a tabela `user` para armazenar informações de usuários.

## Índice

- [Descrição](#descrição)
- [Estrutura do Banco de Dados](#estrutura-do-banco-de-dados)
- [Dependências](#dependências)
- [Configuração do Fuso Horário](#configuração-do-fuso-horário)

## Estrutura do Banco de Dados

### Tabela `user`

A tabela `user` é criada com a seguinte estrutura:

```sql
CREATE TABLE user (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(150) NOT NULL,
  email VARCHAR(255) NOT NULL,
  senha VARCHAR(64) NOT NULL,
  ultimoAcesso DATETIME NOT NULL,
  ativo TINYINT(1) DEFAULT 1,
  PRIMARY KEY (id)
);
```
## Dependências
Adicione a dependência do MySQL Connector/J ao seu projeto. Adicione o seguinte ao seu arquivo de configuração se estiver utilizando `Maven`:

```xml
<dependency>
  <groupId>com.mysql</groupId>
  <artifactId>mysql-connector-j</artifactId>
  <version>8.3.0</version>
</dependency>
```

## Configuração do Fuso Horário
Para evitar problemas com o fuso horário e garantir que os horários armazenados no banco de dados estejam corretos, ajuste o fuso horário global do MySQL para -03:00. Execute o seguinte comando SQL no MySQL:
```sql
SET GLOBAL time_zone = '-03:00';
```
## Arquivo `script.sql`

A pedido do professor, foi adicionado o arquivo `script.sql` ao projeto. 
[script.sql](src/main/resources)

## Créditos

Este trabalho foi desenvolvido por **[Gustavo Leão](https://github.com/agatrix/)** e **[HeullerRamos](https://github.com/HeullerRamos)**.
