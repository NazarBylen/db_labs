CREATE DATABASE  IF NOT EXISTS `bylen`;
USE `bylen`;

--
-- Table structure for table `rivers`
--

DROP TABLE IF EXISTS `rivers_settlements`;
DROP TABLE IF EXISTS `measures`;
DROP TABLE IF EXISTS `rivers`;
DROP TABLE IF EXISTS `settlements`;

CREATE TABLE `rivers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE = INNODB;

CREATE INDEX rivers_name_idx
ON rivers(name);

--
-- Dumping data for table `rivers`
--

INSERT INTO `rivers` (id, name) VALUES 
(1,'Дон'),
(2,'Дніпро'),
(3,'Десна'),
(4,'Дністер'),
(5,'Південний Буг'),
(6,'Західний Буг'),
(7,'Ворскла'),
(8,'Тиса'),
(9,'Дунай'),
(10,'Припʼять'),
(11,'Прут'),
(12,'Вісла'),
(13,'Вепш');

--
-- Table structure for table `settlements`
--

CREATE TABLE `settlements` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `gps_latitude` decimal(6,5) NOT NULL,
  `gps_longtitude` decimal(6,5) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE = INNODB;

CREATE INDEX settlements_name_idx
ON settlements(name);

--
-- Dumping data for table `settlements`
--

INSERT INTO `settlements` (id, name, gps_latitude, gps_longtitude) VALUES 
(1,'Львів',4.53434,3.44432),
(2,'Київ',4.45335,5.35553),
(3,'Харків',2.43535,3.46425),
(4,'Одеса',3.53535,2.54544),
(5,'Полтава',7.45353,7.57546),
(6,'Миколаїв',2.35353,3.52234),
(7,'Луцьк',5.35422,7.56453),
(8,'Ужгород',5.35434,7.46453),
(9,'Івано-Франківськ',6.45343,5.34345),
(10,'Чернігів',9.56353,2.54643),
(11,'Черкаси',2.35353,1.42235),
(12,'Рівне',1.32321,1.34227),
(13,'Тернопіль',8.45342,6.35346),
(14,'Вінниця',4.35352,4.46452);

--
-- Table structure for table `measures`
--

CREATE TABLE `measures` (
  `id` int NOT NULL AUTO_INCREMENT,
  `water_level` int DEFAULT NULL,
  `date` date NOT NULL,
  `settlements_id` int NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE = INNODB;

CREATE INDEX measureswater_level_idx
ON measures(water_level);

ALTER TABLE `measures`
ADD CONSTRAINT `measures_settlements` FOREIGN KEY (`settlements_id`) REFERENCES `settlements` (`id`);

--
-- Dumping data for table `measures`
--

INSERT INTO `measures` (id, water_level, date, settlements_id) VALUES 
(1,3,'2020-03-04',1),
(2,5,'2020-04-03',4),
(3,3,'2020-05-06',3),
(4,6,'2019-03-04',2),
(5,8,'2019-01-02',5),
(6,4,'2018-08-08',7),
(7,6,'2020-09-09',3),
(8,21,'2008-04-03',4),
(9,6,'1998-02-03',8),
(10,23,'1876-02-03',6),
(11,8,'1878-03-04',9);


--
-- Table structure for table `rivers_settlements`
--

CREATE TABLE `rivers_settlements` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rivers_id` int NOT NULL,
  `settlements_id` int NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE = INNODB;

ALTER TABLE `rivers_settlements`
ADD CONSTRAINT `rivers_settlements_rivers` FOREIGN KEY (`rivers_id`) REFERENCES `rivers` (`id`),
ADD CONSTRAINT `rivers_settlements_settlements` FOREIGN KEY (`settlements_id`) REFERENCES `settlements` (`id`);

--
-- Dumping data for table `rivers_settlements`
--

INSERT INTO `rivers_settlements` (id, rivers_id, settlements_id) VALUES 
(1,3,2),
(2,1,1),
(3,3,3),
(4,2,2),
(5,2,4),
(6,6,4),
(7,8,8),
(8,6,5),
(9,8,4),
(10,3,6),
(11,4,10);
