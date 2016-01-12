CREATE TABLE entrada
(
  dniclient VARCHAR(30) NOT NULL,
  nombreespectadors INT NOT NULL,
  data DATE NOT NULL,
  preu REAL NOT NULL,
  sessio VARCHAR(20) NOT NULL,
  nomlocal VARCHAR(255) NOT NULL,
  identificador SERIAL PRIMARY KEY NOT NULL
);
CREATE TABLE espectacle
(
  titol VARCHAR(255) PRIMARY KEY NOT NULL,
  participants INT DEFAULT 0 NOT NULL
);
CREATE TABLE estrena
(
  nomlocal VARCHAR(255) NOT NULL,
  sessio VARCHAR(20) NOT NULL,
  recarrec INT NOT NULL,
  PRIMARY KEY (nomlocal, sessio)
);
CREATE TABLE local
(
  nom VARCHAR(255) PRIMARY KEY NOT NULL,
  adreça VARCHAR(255) NOT NULL
);
CREATE TABLE representacio
(
  titolespectacle VARCHAR(255) NOT NULL,
  sessio VARCHAR(20) NOT NULL,
  nomlocal VARCHAR(255) NOT NULL,
  preu REAL NOT NULL,
  data DATE NOT NULL,
  nombreseienslliures INT NOT NULL,
  PRIMARY KEY (sessio, nomlocal)
);
CREATE TABLE seient
(
  fila INT NOT NULL,
  columna INT NOT NULL,
  nomlocal VARCHAR(255) NOT NULL,
  PRIMARY KEY (fila, columna, nomlocal)
);
CREATE TABLE seient_en_representacio
(
  sessio VARCHAR(20) NOT NULL,
  nomlocalrep VARCHAR(255) NOT NULL,
  nomlocal VARCHAR(255) NOT NULL,
  fila INT NOT NULL,
  columna INT NOT NULL,
  estat VARCHAR(50) NOT NULL,
  identificadorentrada INT NOT NULL,
  PRIMARY KEY (sessio, nomlocal, fila, columna)
);
CREATE TABLE sessio
(
  sessio VARCHAR(20) PRIMARY KEY NOT NULL
);
ALTER TABLE entrada ADD FOREIGN KEY (sessio, nomlocal) REFERENCES representacio (sessio, nomlocal);
ALTER TABLE estrena ADD FOREIGN KEY (nomlocal, sessio) REFERENCES representacio (sessio, nomlocal);
ALTER TABLE representacio ADD FOREIGN KEY (titolespectacle) REFERENCES espectacle (titol);
ALTER TABLE representacio ADD FOREIGN KEY (nomlocal) REFERENCES local (nom);
ALTER TABLE representacio ADD FOREIGN KEY (sessio) REFERENCES sessio (sessio);
ALTER TABLE seient ADD FOREIGN KEY (nomlocal) REFERENCES local (nom);
ALTER TABLE seient_en_representacio ADD FOREIGN KEY (identificadorentrada) REFERENCES entrada (identificador);
ALTER TABLE seient_en_representacio ADD FOREIGN KEY (sessio, nomlocalrep) REFERENCES representacio (sessio, nomlocal);
ALTER TABLE seient_en_representacio ADD FOREIGN KEY (fila, columna, nomlocal) REFERENCES seient (fila, columna, nomlocal);
