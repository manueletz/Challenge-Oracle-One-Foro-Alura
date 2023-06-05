CREATE TABLE TOPICOS (
id BIGINT NOT NULL AUTO_INCREMENT,
titulo VARCHAR(250) NOT NULL,
mensaje VARCHAR(500) NOT NULL,
fecha_creacion DATE NOT NULL,
status VARCHAR(50),
id_usuario BIGINT,
id_curso BIGINT,
PRIMARY KEY (id),
FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
FOREIGN KEY (id_curso) REFERENCES cursos(id)
);