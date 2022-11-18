CREATE TABLE `countries` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NULL,
    `river_id` INT NOT NULL,
    PRIMARY KEY (`id`)
 );

INSERT INTO `countries` VALUES (50,'Ukraine',1),(51,'Romania',2),(52,'Hungary',3),(53,'Moldova',4);

------------------------------------------------------------------------------------------------------------------------
-- Додати до БД 1 додаткову довільну таблицю і зв’язати з іншою існуючою таблицею зв’язком  1:M.
-- Однак для забезпечення цілісності значень використати тригери замість фізичного зовнішнього ключа.

DROP TRIGGER IF EXISTS CheckIfRiverExistsBeforeCreate;
DROP TRIGGER IF EXISTS CheckIfRiverExistsBeforeUpdate;
DROP TRIGGER IF EXISTS DeleteAllRecordsInCountriesTableAfterRiverWasDeleted;

DELIMITER //
CREATE TRIGGER CheckIfRiverExistsBeforeCreate
    BEFORE INSERT
    ON countries
    FOR EACH ROW
BEGIN
    DECLARE river_id INT;
    DECLARE message TEXT;
    SELECT id INTO river_id FROM rivers WHERE id = new.river_id;
    SET message = concat("Cannot add a record: the river id `", new.river_id, "` is not found");
    IF river_id IS NULL THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = message;
END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER CheckIfRiverExistsBeforeUpdate
    BEFORE UPDATE
    ON countries
    FOR EACH ROW
BEGIN
    DECLARE river_id INT;
    DECLARE message TEXT;
    SELECT id INTO river_id FROM rivers WHERE id = new.river_id;
    SET message = concat("Cannot update a record: the river id `", new.river_id, "` is not found");
    IF river_id IS NULL THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = message;
END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER DeleteAllRecordsInCountriesTableAfterRiverWasDeleted
    BEFORE DELETE
    ON rivers
    FOR EACH ROW
BEGIN
    DELETE FROM `countries` WHERE (`river_id` = old.id);
END //
DELIMITER ;