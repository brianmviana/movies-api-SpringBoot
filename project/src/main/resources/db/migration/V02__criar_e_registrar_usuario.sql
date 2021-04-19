CREATE TABLE usuario (
  login varchar(50) NOT NULL,
  nome varchar(50) NOT NULL,
  senha varchar(255) DEFAULT NULL,
  status bit(1) NOT NULL,
  PRIMARY KEY (login)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (login, nome, senha, status) VALUES ('admin', 'Administrador', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('teste', 'Usuario de Teste', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);

INSERT INTO usuario (login, nome, senha, status) VALUES ('user1', 'Usuario 1', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user2', 'Usuario 2', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user3', 'Usuario 3', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user4', 'Usuario 4', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user5', 'Usuario 5', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user6', 'Usuario 6', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user7', 'Usuario 7', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user8', 'Usuario 8', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user9', 'Usuario 9', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user10', 'Usuario 10', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user11', 'Usuario 11', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user12', 'Usuario 12', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user13', 'Usuario 13', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user14', 'Usuario 14', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user15', 'Usuario 15', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user16', 'Usuario 16', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user17', 'Usuario 17', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user18', 'Usuario 18', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user19', 'Usuario 19', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user20', 'Usuario 20', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user21', 'Usuario 21', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user22', 'Usuario 22', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user23', 'Usuario 23', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user24', 'Usuario 24', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user25', 'Usuario 25', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user26', 'Usuario 26', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user27', 'Usuario 27', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user28', 'Usuario 28', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user29', 'Usuario 29', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user30', 'Usuario 30', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user31', 'Usuario 31', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user32', 'Usuario 32', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user33', 'Usuario 33', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user34', 'Usuario 34', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user35', 'Usuario 35', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user36', 'Usuario 36', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user37', 'Usuario 37', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user38', 'Usuario 38', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user39', 'Usuario 39', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user40', 'Usuario 40', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user41', 'Usuario 41', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user42', 'Usuario 42', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user43', 'Usuario 43', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user44', 'Usuario 44', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user45', 'Usuario 45', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user46', 'Usuario 46', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user47', 'Usuario 47', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user48', 'Usuario 48', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user49', 'Usuario 49', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);
INSERT INTO usuario (login, nome, senha, status) VALUES ('user50', 'Usuario 50', '$2a$10$CHtW9UO.FOEFhVlcJaHLV.cBK0Js.Gu0lnDlsSWpa8P4uKredIHZ2', 1);