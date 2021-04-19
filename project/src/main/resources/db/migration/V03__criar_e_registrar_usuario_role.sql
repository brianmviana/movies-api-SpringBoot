CREATE TABLE usuarios_roles (
  usuario_id varchar(255) NOT NULL,
  role_id varchar(255) NOT NULL,
  KEY role_key (`role_id`),
  KEY usuario_key (`usuario_id`),
  CONSTRAINT usuario_key FOREIGN KEY (usuario_id) REFERENCES usuario (login),
  CONSTRAINT role_key FOREIGN KEY (role_id) REFERENCES role (nome_role)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuarios_roles(usuario_id, role_id) values('admin', 'ROLE_ADMIN');
INSERT INTO usuarios_roles(usuario_id, role_id) values('admin', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('teste', 'ROLE_USER');