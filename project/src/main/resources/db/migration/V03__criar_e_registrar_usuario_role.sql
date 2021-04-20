CREATE TABLE usuarios_roles (
  usuario_id varchar(255) NOT NULL,
  role_id varchar(255) NOT NULL,
  KEY role_key (`role_id`),
  KEY usuario_key (`usuario_id`),
  CONSTRAINT usuario_key FOREIGN KEY (usuario_id) REFERENCES usuario (login),
  CONSTRAINT role_key FOREIGN KEY (role_id) REFERENCES role (nome_role)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuarios_roles(usuario_id, role_id) values('admin', 'ROLE_ADMIN');
INSERT INTO usuarios_roles(usuario_id, role_id) values('teste', 'ROLE_USER');

INSERT INTO usuarios_roles(usuario_id, role_id) values('user1', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user2', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user3', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user4', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user5', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user6', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user7', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user8', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user9', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user10', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user11', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user12', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user13', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user14', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user15', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user16', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user17', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user18', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user19', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user20', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user21', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user22', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user23', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user24', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user25', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user26', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user27', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user28', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user29', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user30', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user31', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user32', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user33', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user34', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user35', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user36', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user37', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user38', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user39', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user40', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user41', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user42', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user43', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user44', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user45', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user46', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user47', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user48', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user49', 'ROLE_USER');
INSERT INTO usuarios_roles(usuario_id, role_id) values('user50', 'ROLE_USER');
