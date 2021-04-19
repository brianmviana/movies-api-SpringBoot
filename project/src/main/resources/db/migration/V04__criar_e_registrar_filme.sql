CREATE TABLE filme (
  id bigint NOT NULL AUTO_INCREMENT,
  nome varchar(255) NOT NULL,
  ano varchar(255) NOT NULL,
  diretor varchar(255) NOT NULL,
  genero varchar(255) NOT NULL,
  status bit(1) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE atores (
  id bigint NOT NULL AUTO_INCREMENT,
  nome_ator varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE filmes_atores (
  filme_id bigint NOT NULL,
  ator_id bigint NOT NULL,
  KEY filme_key (`filme_id`),
  KEY ator_key (`ator_id`),
  CONSTRAINT filme_key FOREIGN KEY (filme_id) REFERENCES filme (id),
  CONSTRAINT ator_key FOREIGN KEY (ator_id) REFERENCES atores (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO filme(id, nome, ano, diretor, genero, status) values(1, 'Homem de Ferro', '2008', 'Jon Favreau', 'acao', 1);
INSERT INTO filme(id, nome, ano, diretor, genero, status) values(2, 'Homem de Ferro 2', '2010', 'Jon Favreau', 'acao', 1);
INSERT INTO filme(id, nome, ano, diretor, genero, status) values(3, 'Homem de Ferro 3', '2013', 'Shane Black', 'acao', 1);

INSERT INTO atores(id, nome_ator) values (1, 'Robert Downey Jr.');
INSERT INTO atores(id, nome_ator) values (2, 'Gwyneth Paltrow');
INSERT INTO atores(id, nome_ator) values (3, 'Terrence Howard');
INSERT INTO atores(id, nome_ator) values (4, 'Mickey Rourke');
INSERT INTO atores(id, nome_ator) values (5, 'Guy Pearce');

INSERT INTO filmes_atores(filme_id, ator_id) values (1, 1);
INSERT INTO filmes_atores(filme_id, ator_id) values (1, 2);
INSERT INTO filmes_atores(filme_id, ator_id) values (1, 3);
INSERT INTO filmes_atores(filme_id, ator_id) values (2, 1);
INSERT INTO filmes_atores(filme_id, ator_id) values (2, 2);
INSERT INTO filmes_atores(filme_id, ator_id) values (2, 4);
INSERT INTO filmes_atores(filme_id, ator_id) values (3, 1);
INSERT INTO filmes_atores(filme_id, ator_id) values (3, 2);
INSERT INTO filmes_atores(filme_id, ator_id) values (3, 5);