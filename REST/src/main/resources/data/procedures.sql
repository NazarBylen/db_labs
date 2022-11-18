use bylen;

-- Створити пакет, який вставляє 10 стрічок у довільну таблицю БД у форматі < Noname+№> ,
-- наприклад: Noname5, Noname6, Noname7 і т.д.
DROP PROCEDURE IF EXISTS CreateBunchOfCountries;

DELIMITER //
CREATE PROCEDURE CreateBunchOfCountries(OUT amount int)
BEGIN
    DECLARE increment INT;
    SET increment = 1;

    WHILE increment <= 10 DO
        INSERT INTO `countries` (`name`, `river_id`) VALUES (CONCAT('country_', increment), '7');
        SET increment = increment + 1;
END WHILE;
SET amount = 10;
END //
------------------------------------------------------------------------------------------------------------------------

-- Забезпечити параметризовану вставку нових значень у довільну таблицю.
DROP PROCEDURE IF EXISTS CreateNewRiver;

DELIMITER //
CREATE PROCEDURE CreateNewRiver(IN newRiversName VARCHAR(45), OUT id int)
BEGIN
    INSERT INTO rivers(name) VALUES(newRiversName);
    SELECT LAST_INSERT_ID() as id;
END //
DELIMITER ;
------------------------------------------------------------------------------------------------------------------------

-- Забезпечити реалізацію зв’язку М:М між 2ма таблицями,
-- тобто вставити в стикувальну таблицю відповідну стрічку за реально-існуючими значеннями
-- (напр. surname, name) в цих основних таблицях.
DROP PROCEDURE IF EXISTS SetNamesInRiversAndSettlements;

DELIMITER //
CREATE PROCEDURE `SetNamesInRiversAndSettlements` (IN river_settlement_id INT)
BEGIN
	DECLARE current_river_id INT;
	DECLARE current_river_name TEXT;
	DECLARE current_settlement_id INT;
	DECLARE current_settlement_name TEXT;
    SELECT `rivers_id`, `settlements_id` INTO current_river_id, current_settlement_id FROM `rivers_settlements` WHERE `id`=river_settlement_id;
    SELECT `name` INTO current_river_name FROM `rivers` WHERE `id` = current_river_id;
    SELECT `name` INTO current_settlement_name FROM `settlements` WHERE `id` = current_settlement_id;
    UPDATE `rivers_settlements` SET `river_name` = current_river_name, `settlement_name` = current_settlement_name WHERE (`id` = river_settlement_id);
END//
DELIMITER ;
------------------------------------------------------------------------------------------------------------------------

-- Написати користувацьку функцію, яка буде шукати Max, Min, Sum чи Avg для стовпця довільної таблиці у БД.
-- Написати процедуру, яка буде у SELECT викликати цю функцію.
DROP FUNCTION IF EXISTS GetMaxMeasure;

DELIMITER //
CREATE FUNCTION GetMaxMeasure() RETURNS INT DETERMINISTIC
BEGIN
	DECLARE max_water_level INT DEFAULT 0;
    SELECT MAX(water_level) as water_level INTO max_water_level FROM measures;
    RETURN max_water_level;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS GetMaxMeasure;

DELIMITER //
CREATE PROCEDURE GetMaxMeasure(OUT maxMeasure int)
BEGIN
    SELECT GetMaxMeasure();
END //
DELIMITER ;
------------------------------------------------------------------------------------------------------------------------

-- Написати 1 процедуру із курсором для виконання однієї із наступних задач:
-- Використовуючи курсор, забезпечити динамічне створення баз даних з іменами,
-- взятими зі стовпця з довільної таблиці поточної БД, з випадковою кількістю таблиць для кожної БД (від 1 до 9).
-- Структура таблиць довільна. Імена таблиць відповідають імені БД з порядковим номером від 1 до 9.

DROP PROCEDURE IF EXISTS CreateDatabasesUsingCursors;

DELIMITER //
CREATE PROCEDURE CreateDatabasesUsingCursors()
BEGIN
	declare increment int default 1;
    declare random_number int default 1;

	declare done int default 0;
    declare db_name varchar(255);

    declare country_name_cursor cursor
    for SELECT `name` FROM countries;

    declare continue handler
    for not found set done = 1;

    open country_name_cursor;

    while done = 0 do
        select FLOOR( RAND() * (9-1) + 1) as rand_num INTO random_number;
        fetch country_name_cursor into db_name;

        set @create_db = concat('CREATE DATABASE IF NOT EXISTS ', db_name, ';');
        prepare create_db from @create_db;
        execute create_db;
        deallocate prepare create_db;

        while random_number >= increment do
            set @create_table = concat('CREATE TABLE IF NOT EXISTS ', db_name, '.', db_name, increment, ' (`id` INT NOT NULL AUTO_INCREMENT, PRIMARY KEY (`id`));');
            prepare create_table from @create_table;
            execute create_table;
            set increment = increment+1;
            deallocate prepare create_table;
        end while;
        set increment = 1;
    end while;
    close country_name_cursor;
END //
DELIMITER ;
------------------------------------------------------------------------------------------------------------------------