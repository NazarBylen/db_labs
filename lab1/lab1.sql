-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-09-02 17:45:46.098

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

-- Table: settlements
CREATE TABLE settlements (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(45) NOT NULL,
    gps_latitude decimal(6,5) NOT NULL,
    gps_longtitude decimal(6,5) NOT NULL,
    rivers_id int NOT NULL,
    CONSTRAINT settlements_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: measures_settlements (table: measures)
ALTER TABLE measures ADD CONSTRAINT measures_settlements FOREIGN KEY measures_settlements (settlements_id)
    REFERENCES settlements (id);

-- Reference: settlements_rivers (table: settlements)
ALTER TABLE settlements ADD CONSTRAINT settlements_rivers FOREIGN KEY settlements_rivers (rivers_id)
    REFERENCES rivers (id);

-- End of file.

