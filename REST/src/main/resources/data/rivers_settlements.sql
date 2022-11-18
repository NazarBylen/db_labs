ALTER TABLE `bylen`.`rivers_settlements`
    ADD COLUMN `river_name` VARCHAR(100) NULL AFTER `settlements_id`,
    ADD COLUMN `settlement_name` VARCHAR(100) NULL AFTER `river_name`;

