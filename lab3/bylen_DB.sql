CREATE DATABASE  IF NOT EXISTS bylen;
USE bylen;

--
-- Table structure for table rivers
--

DROP TABLE IF EXISTS rivers_settlements;
DROP TABLE IF EXISTS measures;
DROP TABLE IF EXISTS rivers;
DROP TABLE IF EXISTS settlements;

CREATE TABLE rivers (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE INDEX rivers_name_idx
ON rivers(name);

--
-- Dumping data for table rivers
--

INSERT INTO rivers (name) VALUES 
('Дон'),
('Дніпро'),
('Десна'),
('Дністер'),
('Південний Буг'),
('Західний Буг'),
('Ворскла'),
('Тиса'),
('Дунай'),
('Припʼять'),
('Прут'),
('Вісла'),
('Вепш');

--
-- Table structure for table settlements
--

CREATE TABLE settlements (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  gps_latitude decimal(6,5) NOT NULL,
  gps_longtitude decimal(6,5) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE INDEX settlements_name_idx
ON settlements(name);

--
-- Dumping data for table settlements
--

INSERT INTO settlements (name, gps_latitude, gps_longtitude) VALUES 
('Львів',4.53434,3.44432),
('Київ',4.45335,5.35553),
('Харків',2.43535,3.46425),
('Одеса',3.53535,2.54544),
('Полтава',7.45353,7.57546),
('Миколаїв',2.35353,3.52234),
('Луцьк',5.35422,7.56453),
('Ужгород',5.35434,7.46453),
('Івано-Франківськ',6.45343,5.34345),
('Чернігів',9.56353,2.54643),
('Черкаси',2.35353,1.42235),
('Рівне',1.32321,1.34227),
('Тернопіль',8.45342,6.35346),
('Вінниця',4.35352,4.46452);

--
-- Table structure for table measures
--

CREATE TABLE measures (
  id int NOT NULL AUTO_INCREMENT,
  water_level int DEFAULT NULL,
  date date NOT NULL,
  settlements_id int NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE INDEX measureswater_level_idx
ON measures(water_level);

ALTER TABLE measures
ADD CONSTRAINT measures_settlements FOREIGN KEY (`settlements_id`) REFERENCES settlements (`id`);

--
-- Dumping data for table measures
--

INSERT INTO measures (water_level, date, settlements_id) VALUES 
(3,'2020-03-04',1),
(5,'2020-04-03',4),
(3,'2020-05-06',3),
(6,'2019-03-04',2),
(8,'2019-01-02',5),
(4,'2018-08-08',7),
(6,'2020-09-09',3),
(21,'2008-04-03',4),
(6,'1998-02-03',8),
(23,'1876-02-03',6),
(8,'1878-03-04',9);


--
-- Table structure for table rivers_settlements
--

CREATE TABLE rivers_settlements (
  id int NOT NULL AUTO_INCREMENT,
  rivers_id int NOT NULL,
  settlements_id int NOT NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE rivers_settlements
ADD CONSTRAINT rivers_settlements_rivers FOREIGN KEY (`rivers_id`) REFERENCES rivers (`id`),
ADD CONSTRAINT rivers_settlements_settlements FOREIGN KEY (`settlements_id`) REFERENCES settlements (`id`);

--
-- Dumping data for table rivers_settlements
--

INSERT INTO rivers_settlements (rivers_id, settlements_id) VALUES 
(3,2),
(1,1),
(3,3),
(2,2),
(2,4),
(6,4),
(8,8),
(6,5),
(8,4),
(3,6),
(4,10);