CREATE TABLE voto (
  id bigint NOT NULL AUTO_INCREMENT,
  nota int NOT NULL,
  filme_id bigint NOT NULL,
  usuario_id varchar(255) NOT NULL,
  PRIMARY KEY (id),
  KEY FK_FILME_VOTO_KEY (filme_id),
  KEY FK_USUARIO_VOTO_KEY (usuario_id),
  CONSTRAINT FK_FILME_VOTO_KEY FOREIGN KEY (filme_id) REFERENCES filme (id),
  CONSTRAINT FK_USUARIO_VOTO_KEY FOREIGN KEY (usuario_id) REFERENCES usuario (login)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;