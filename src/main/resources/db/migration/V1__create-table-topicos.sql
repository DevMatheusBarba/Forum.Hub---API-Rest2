CREATE TABLE topicos (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    mensagem VARCHAR(255) NOT NULL,
    dataCriacao TIMESTAMP NOT NULL,
    status VARCHAR(100) NOT NULL,
    idAutor INTEGER NOT NULL,
    idCurso INTEGER,
    idRespostas INTEGER
);
