### Projeto Blog TDS Tecnologia


## Para executar o projeto localmente siga o passos abaixo:

1 - Baixe e instale o software Heroku CLI: https://devcenter.heroku.com/articles/heroku-cli#download-and-install

2 - Gere o jar do projeto com o comando 
```
mvn package
```

3 - Na raiz do projeto altere o arquivo Procfile deixando somente a linha
abaixo descomentada

```
web: java -jar target/endorsed/webapp-runner.jar --port 8080 target/*.war
```

4 - Acesse a raiz do projeto através do CMD e exute o comando

```
heroku local
```

5 - Caso o banco de dados não for criado automaticamente, crie o schema blog
e execute os sql abaixo para criar as tabelas.

6 - 

## Banco de PostgreSQL

```#sql
CREATE TABLE blog.tb01_post (
	id int8 NULL,
	titulo varchar(500) NULL,
	resumo varchar(500) NULL,
	texto text NULL,
	data_criacao timestamp NULL,
	data_publicacao timestamp NULL,
	autor int8 NULL
);

CREATE TABLE blog.tb02_usuario (
	id serial NOT NULL,
	nome varchar(100) NULL,
	senha varchar(1000) NULL,
	ativo bool NULL,
	data_criacao timestamp NULL,
	data_ativacao timestamp NULL,
	token_ativacao varchar(1000) NULL,
	data_criacao_token timestamp NULL,
	email varchar(500) NULL,
	CONSTRAINT tb02_usuario_pk PRIMARY KEY (id)
);

CREATE SEQUENCE blog.seq_tb01_post
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1;
```

