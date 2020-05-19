CREATE TABLE lancamento
(
	id bigint not null AUTO_INCREMENT UNIQUE,
    usuario_id bigint not null,
    descricao varchar(100) not null,
    mes int not null,
    ano int not null,
    valor decimal(10,2) not null,
    tipo ENUM('RECEITA','DESPESA') not null,
  	status ENUM('PENDENTE','CANCELADO','EFETIVADO') not null, 
    data_cadastro date not null,
    
    PRIMARY KEY(id),
    
    CONSTRAINT fk_lancamento_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);