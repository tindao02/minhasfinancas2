CREATE TABLE usuario
(
    id bigint not null AUTO_INCREMENT UNIQUE,
    nome varchar(150) not null,
    email varchar(100) not null UNIQUE,
    senha varchar(20) not null,
    data datetime not null,
   
    PRIMARY KEY(id)
);