
CREATE TABLE empresa (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  nome_fantasia VARCHAR(100),
  razao_social VARCHAR(50) NOT NULL,
  cnpj VARCHAR(50) NOT NULL,
  ativo BOOLEAN,
  PRIMARY KEY (id),
  UNIQUE KEY UK_cnpj (cnpj)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

