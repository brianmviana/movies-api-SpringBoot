CREATE TABLE role (
  nome_role varchar(50) NOT NULL,
  PRIMARY KEY (nome_role)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO role(nome_role) values('ROLE_ADMIN');
INSERT INTO role(nome_role) values('ROLE_USER');