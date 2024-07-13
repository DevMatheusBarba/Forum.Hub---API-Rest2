CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE cursos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NOT NULL
);

CREATE TABLE topicos (
    id SERIAL PRIMARY KEY,
    data_criacao TIMESTAMP WITH TIME ZONE NOT NULL,
    mensagem TEXT NOT NULL,
    situacao VARCHAR(255) NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    id_curso BIGINT NOT NULL,
    id_autor BIGINT NOT NULL,
    ativo BOOLEAN NOT NULL
);

CREATE TABLE respostas (
    id SERIAL PRIMARY KEY,
    data_criacao TIMESTAMP WITH TIME ZONE NOT NULL,
    mensagem TEXT NOT NULL,
    idtopico BIGINT NOT NULL,
    idautor BIGINT NOT NULL
);

