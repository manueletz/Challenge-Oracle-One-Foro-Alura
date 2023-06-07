INSERT INTO CURSOS (NOMBRE, CATEGORIA) VALUES ('SQL','BASE DE DATOS');
INSERT INTO CURSOS (NOMBRE, CATEGORIA) VALUES ('JAVA','PROGRAMACION');
INSERT INTO CURSOS (NOMBRE, CATEGORIA) VALUES ('PYTHON','PROGRAMACION');
INSERT INTO CURSOS (NOMBRE, CATEGORIA) VALUES ('SPRING BOOT','FRAMEWORK');
INSERT INTO CURSOS (NOMBRE, CATEGORIA) VALUES ('HTML','WEB');

INSERT INTO USUARIOS (NOMBRE, EMAIL, CONTRASENA) VALUES ('MANUEL.ESTEVEZ', 'manue.estevez@aluara.com', '1234');
INSERT INTO USUARIOS (NOMBRE, EMAIL, CONTRASENA) VALUES ('ILKAY.GUNDOGAN', 'ilkay.gundogan@aluara.com', '1234');
INSERT INTO USUARIOS (NOMBRE, EMAIL, CONTRASENA) VALUES ('KEVIN.DEBRUYNE', 'kevin.debruyne@aluara.com', '1234');
INSERT INTO USUARIOS (NOMBRE, EMAIL, CONTRASENA) VALUES ('MANUEL.AKANYI', 'manuel.akanyi@aluara.com', '1234');
INSERT INTO USUARIOS (NOMBRE, EMAIL, CONTRASENA) VALUES ('EDERNSON.MORAES', 'edernon.moraes@aluara.com', '1234');

INSERT INTO TOPICOS (TITULO, MENSAJE, FECHA_CREACION, STATUS, ID_USUARIO, ID_CURSO) VALUES ("PROBLEMAS CON SQL", "NO PUEDO CREAR UN LLAVE FORANEA", '2023-06-06', 'NO_RESPONDIDO', 1, 1);
INSERT INTO TOPICOS (TITULO, MENSAJE, FECHA_CREACION, STATUS, ID_USUARIO, ID_CURSO) VALUES ("PROBLEMAS CON JAVA", "NO PUEDO CREAR USAR ENUM", '2023-06-06', 'NO_RESPONDIDO', 2, 2);
INSERT INTO TOPICOS (TITULO, MENSAJE, FECHA_CREACION, STATUS, ID_USUARIO, ID_CURSO) VALUES ("PROBLEMAS CON PYTHON", "NO PUEDO CREAR UNA LISTA", '2023-06-06', 'NO_RESPONDIDO', 3, 3);
INSERT INTO TOPICOS (TITULO, MENSAJE, FECHA_CREACION, STATUS, ID_USUARIO, ID_CURSO) VALUES ("PROBLEMAS CON SPRING BOOT", "NO PUEDO CREAR USAR JPA", '2023-06-06', 'NO_RESPONDIDO', 4, 4);
INSERT INTO TOPICOS (TITULO, MENSAJE, FECHA_CREACION, STATUS, ID_USUARIO, ID_CURSO) VALUES ("PROBLEMAS CON HTML", "NO PUEDO CREAR UN DIV", '2023-06-06', 'NO_RESPONDIDO', 5, 5);