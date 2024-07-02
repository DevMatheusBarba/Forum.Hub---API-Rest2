ALTER TABLE topicos
ADD CONSTRAINT fk_idAutor FOREIGN KEY (idAutor) REFERENCES usuarios(id);

ALTER TABLE topicos
ADD CONSTRAINT fk_idCurso FOREIGN KEY (idCurso) REFERENCES cursos(id);

ALTER TABLE topicos
ADD CONSTRAINT fk_idRespostas FOREIGN KEY (idRespostas) REFERENCES respostas(id);
