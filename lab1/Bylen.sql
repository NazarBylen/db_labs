-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-09-07 16:52:54.214

-- tables
-- Table: measures
CREATE TABLE measures (
    id int NOT NULL AUTO_INCREMENT,
    water_level int NULL,
    date date NOT NULL,
    settlements_id int NOT NULL,
    CONSTRAINT measures_pk PRIMARY KEY (id)
);

-- Table: rivers
CREATE TABLE rivers (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(45) NOT NULL,
    CONSTRAINT rivers_pk PRIMARY KEY (id)
);

-- Table: rivers_settlements
CREATE TABLE rivers_settlements (
    id int NOT NULL AUTO_INCREMENT,
    rivers_id int NOT NULL,
    settlements_id int NOT NULL,
    CONSTRAINT rivers_settlements_pk PRIMARY KEY (id)
);

-- Table: settlements
CREATE TABLE settlements (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(45) NOT NULL,
    gps_latitude decimal(6,5) NOT NULL,
    gps_longtitude decimal(6,5) NOT NULL,
    CONSTRAINT settlements_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: measures_settlements (table: measures)
ALTER TABLE measures ADD CONSTRAINT measures_settlements FOREIGN KEY measures_settlements (settlements_id)
    REFERENCES settlements (id);

-- Reference: rivers_settlements_rivers (table: rivers_settlements)
ALTER TABLE rivers_settlements ADD CONSTRAINT rivers_settlements_rivers FOREIGN KEY rivers_settlements_rivers (rivers_id)
    REFERENCES rivers (id);

-- Reference: rivers_settlements_settlements (table: rivers_settlements)
ALTER TABLE rivers_settlements ADD CONSTRAINT rivers_settlements_settlements FOREIGN KEY rivers_settlements_settlements (settlements_id)
    REFERENCES settlements (id);

-- End of file.

