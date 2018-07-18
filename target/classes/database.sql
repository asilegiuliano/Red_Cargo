DROP DATABASE IF EXISTS `spedizione`;
CREATE DATABASE `spedizione`;

USE `spedizione`;

CREATE TABLE `articolo` (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    codice VARCHAR(250),
    descrizione VARCHAR(250),
    peso DECIMAL(10,4)
) Engine=InnoDB;

CREATE TABLE `ordine` (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    numero INTEGER NOT NULL,
    `data` DATE
) Engine=InnoDB;

CREATE TABLE `tariffa_corriere` (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome_corriere VARCHAR(250) NOT NULL,
    nome_tariffa VARCHAR(250) NOT NULL,
    peso_massimo DECIMAL(10,4) NOT NULL,
    costo DECIMAL(10,4) NOT NULL
) Engine=InnoDB;

CREATE TABLE `voce` (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_articolo INTEGER NOT NULL,
    id_ordine INTEGER NOT NULL,
    quantita INTEGER NOT NULL,
    CONSTRAINT FOREIGN KEY (id_articolo) REFERENCES articolo(id),
    CONSTRAINT FOREIGN KEY (id_ordine) REFERENCES ordine(id),
    CONSTRAINT UNIQUE (id_articolo, id_ordine)
) Engine=InnoDB;

INSERT INTO `articolo` (id, codice, descrizione, peso) VALUES 
    (1, 'PNDRV8', 'Pen drive USB 8G no brand', 0.15),
    (2, 'DCP-J715E', 'Stampante Brother DCP J715 W', 5.3),
    (3, 'LNVCX1', 'Notebook Lenovo Carbon X1', 1.9),
    (4, 'ALCPPC3', 'Smartphone Alcatel POP C3', 0.53),
    (5, 'BSHT1R', 'Ampli Combo valvolare BlackStar HT 1-R', 6);

INSERT INTO `ordine` (id, numero, `data`) VALUES 
    (1, 34, NOW()),
    (2, 3, NOW()),
    (3, 4, NOW()),
    (4, 73, NOW()),
    (5, 23, NOW()),
    (6, 72, NOW()),
    (7, 73, NOW()),
    (8, 7, NOW()),
    (9, 31, NOW());

INSERT INTO `tariffa_corriere` (id, nome_corriere, nome_tariffa, peso_massimo, costo) VALUES
    (1, 'SDA', 'Economy', 1, 5.90),
    (2, 'SDA', 'Veloce', 5, 7.90),
    (3, 'SDA', 'Bigbox', 30, 12.90),
    (4, 'DHL', 'Veloce', 1.5, 6.50),
    (5, 'DHL', 'Assicurata', 7.5, 9.90),
    (6, 'DHL', 'XXL', 40, 13.90),
    (7, 'UPS', 'Economy', 0.7, 5.20);

INSERT INTO `voce` (id_ordine, id_articolo, quantita) VALUES
    (1, 3, 2),
    (2, 2, 1),
    (2, 3, 1),
    (3, 3, 1),
    (3, 4, 1),
    (4, 1, 2),
    (4, 4, 1),
    (5, 4, 2),
    (5, 1, 1),
    (6, 1, 3),
    (7, 2, 7),
    (8, 5, 1),
    (8, 3, 1),
    (9, 5, 6);


    
