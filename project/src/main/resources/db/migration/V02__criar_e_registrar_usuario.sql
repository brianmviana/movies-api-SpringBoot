CREATE TABLE usuario (
  login varchar(50) NOT NULL,
  nome varchar(50) NOT NULL,
  senha varchar(255) DEFAULT NULL,
  status bit(1) NOT NULL,
  PRIMARY KEY (login)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (login, nome, senha, status) VALUES ('admin', 'Administrador', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('teste', 'Usuario de Teste', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);