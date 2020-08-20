
CREATE TABLE nota_fiscal (
  id BIGINT NOT NULL AUTO_INCREMENT,
  empresa_tomadora_id BIGINT,
  empresa_prestadora_id BIGINT,
  numero VARCHAR(20) NOT NULL,
  data_criacao DATE NOT NULL,
  valor FLOAT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (empresa_tomadora_id) references empresa (id),
  FOREIGN KEY (empresa_prestadora_id) references empresa (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

