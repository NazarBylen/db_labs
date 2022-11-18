USE bylen;

-- Написати 3 довільні тригери для таблиць поточної БД:

-- Створити таблицю-журнал, в якій вести логи зі штампом часу при модифікації даних для таблиці
DELIMITER //
CREATE TRIGGER AfterInsertSettlementMeasure
    AFTER INSERT
    ON measures
    FOR EACH ROW
BEGIN
    DECLARE settlement_with_gps VARCHAR(255);
    DECLARE water_level_measure INT;
    SELECT CONCAT(name, ' (', gps_latitude, ':', gps_longtitude, ')') INTO settlement_with_gps FROM settlements WHERE id = new.settlements_id;
    SELECT water_level INTO water_level_measure FROM measures WHERE id = new.id;
    INSERT INTO logger (settlement, measure, action, time_stamp, user)
    VALUES (settlement_with_gps, water_level_measure, 'INSERTED', NOW(), USER());
END //
DELIMITER ;

--Створити таблицю-журнал, в якій вести логи зі штампом часу при видаленні даних для певної таблиці
DELIMITER //
CREATE TRIGGER BeforeDeleteSettlementMeasure
    BEFORE DELETE
    ON measures
    FOR EACH ROW
BEGIN
    DECLARE settlement_with_gps VARCHAR(255);
    DECLARE water_level_measure INT;
    SELECT CONCAT(name, ' (', gps_latitude, ':', gps_longtitude, ')') INTO settlement_with_gps FROM settlements WHERE id = old.settlements_id;
    SELECT water_level INTO water_level_measure FROM measures WHERE id = old.id;
    INSERT INTO logger (settlement, measure, action, time_stamp, user)
    VALUES (settlement_with_gps, water_level_measure, 'DELETED', NOW(), USER());
END //
DELIMITER ;

-- Значення певного стовпця не може бути меншим 1
DELIMITER //
CREATE TRIGGER ValidateMeasureWaterLevel
    BEFORE INSERT
    ON measures
    FOR EACH ROW
IF new.water_level < 1 THEN
	SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = 'Water level can not be less then 1';
END IF //;
DELIMITER ;