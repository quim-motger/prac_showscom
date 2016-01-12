CREATE TABLE entrada
(
  dniclient VARCHAR(30),
  nombreespectadors INT,
  data DATE ,
  preu REAL ,
  sessio VARCHAR(20) ,
  nomlocal VARCHAR(255),
  identificador SERIAL PRIMARY KEY
);
CREATE TABLE espectacle
(
  titol VARCHAR(255) PRIMARY KEY ,
  participants INT DEFAULT 0 
);
CREATE TABLE estrena
(
  nomlocal VARCHAR(255),
  sessio VARCHAR(20),
  recarrec INT ,
  PRIMARY KEY (nomlocal, sessio)
);
CREATE TABLE local
(
  nom VARCHAR(255) PRIMARY KEY ,
  adreça VARCHAR(255) 
);
CREATE TABLE representacio
(
  titolespectacle VARCHAR(255) ,
  sessio VARCHAR(20) ,
  nomlocal VARCHAR(255) ,
  preu REAL ,
  data DATE ,
  nombreseienslliures INT ,
  PRIMARY KEY (sessio, nomlocal)
);
CREATE TABLE seient
(
  fila INT ,
  columna INT ,
  nomlocal VARCHAR(255) ,
  PRIMARY KEY (fila, columna, nomlocal)
);
CREATE TABLE seient_en_representacio
(
  sessio VARCHAR(20) ,
  nomlocalrep VARCHAR(255) ,
  nomlocal VARCHAR(255) ,
  fila INT ,
  columna INT ,
  estat VARCHAR(50) ,
  identificadorentrada INT ,
  PRIMARY KEY (sessio, nomlocal, fila, columna)
);
CREATE TABLE sessio
(
  sessio VARCHAR(20) PRIMARY KEY 
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
