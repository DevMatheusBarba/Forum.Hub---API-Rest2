ALTER TABLE topicos
ADD CONSTRAINT fk_CurTop FOREIGN KEY (id_curso) REFERENCES cursos (id);
ALTER TABLE topicos
ADD CONSTRAINT fk_UserTop FOREIGN KEY (id_autor) REFERENCES usuarios (id);


ALTER TABLE respostas
ADD CONSTRAINT fk_TopResp FOREIGN KEY (idtopico) REFERENCES topicos (id);
ALTER TABLE respostas
ADD CONSTRAINT fk_UserResp FOREIGN KEY (idautor) REFERENCES usuarios (id);




