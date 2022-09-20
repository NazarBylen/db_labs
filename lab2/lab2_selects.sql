-- 1. БД «Комп. фірма». Вивести моделі ПК зі швидкістю процесора в
-- межах від 500 до 750 МГц. Вивести: model, speed, price. Вихідні дані
-- впорядкувати за спаданням за стовпцем hd.

SELECT model, speed, price FROM Labor_SQL.PC
WHERE speed >=500 and speed <=750
ORDER BY hd DESC;

-- 2. БД «Аеропорт». Вивести прізвища пасажирів (друге слово в стовпці
-- name), що починаються на літеру 'С'.

SELECT SUBSTRING(name, (SELECT LOCATE(' ', name)+1), 10) FROM Labor_SQL.Passenger
WHERE name REGEXP '^[^ ]+[ ]+c+[^ ]+$';

-- 3. БД «Кораблі». Для кораблів, що вціліли в битвах, вивести назви та
-- дати битв, у яких вони брали участь.

SELECT name, date
FROM Labor_SQL.Battles
INNER JOIN Outcomes ON Battles.name = Outcomes.battle
WHERE Outcomes.result = "OK";

-- 4. БД «Комп. фірма». Знайдіть виробників, що випускають одночасно
-- ПК та ноутбуки (використати ключове слово ALL). Вивести maker.

SELECT DISTINCT maker
FROM Labor_SQL.Product
WHERE type = 'PC' AND NOT Product.maker <> ALL(SELECT maker FROM Product WHERE type = 'Laptop');

-- 5. БД «Комп. фірма». Знайдіть виробників принтерів, що випускають
-- ПК із найвищою швидкістю процесора. Виведіть: maker.

SELECT maker FROM pc 
INNER JOIN product ON product.model = pc.model
WHERE maker IN (SELECT maker FROM product WHERE type = 'Printer')
ORDER BY pc.speed DESC
LIMIT 1;

-- 6. БД «Кораблі». З таблиці Battles виведіть дати в такому форматі:
-- день.число_місяця.рік, наприклад, 12.06.2001 (без формату часу).

SELECT DATE_FORMAT(date, '%d.%m.%Y') FROM Labor_SQL.Battles;

-- 7. БД «Комп. фірма». Знайдіть середній розмір жорсткого диску ПК
-- (одне значення на всіх) тих виробників, які також випускають і прин-
-- тери. Вивести: середній розмір жорсткого диску.

SELECT AVG(hd) FROM pc
INNER JOIN product ON product.model = pc.model
WHERE maker IN (SELECT maker FROM product WHERE type = 'Printer');

-- 8. БД «Комп. фірма». Для кожного значення швидкості ПК, що пере-
-- вищує 600 МГц, визначіть середню ціну ПК із такою ж швидкістю.
-- Вивести: speed, середня ціна. (Підказка: використовувати підзапити в
-- якості обчислювальних стовпців)

SELECT pc.speed, TRUNCATE(speed_avg_price.avg_price, 2) AS avg_price
FROM pc,
(SELECT speed, AVG(price) AS avg_price FROM pc GROUP BY speed) as speed_avg_price
WHERE pc.speed > 600 AND speed_avg_price.speed = pc.speed

-- 9. БД «Кораблі». Визначити назви всіх кораблів із таблиці Ships, які
-- задовольняють, у крайньому випадку, комбінації будь-яких чотирьох
-- критеріїв із наступного списку: numGuns=8, bore=15,
-- displacement=32000, type='bb', country='USA', launched=1915,
-- class='Kongo'. Вивести: name, numGuns, bore, displacement, type,
-- country, launched, class. (Підказка: використати для перевірки умов
-- оператор CASE)

SELECT ships.name, classes.numGuns, classes.bore, classes.displacement, classes.type, classes.country, ships.launched, classes.class
FROM ships
INNER JOIN classes ON classes.class = ships.class
WHERE ( 
  (CASE WHEN classes.numGuns=8 THEN 1 ELSE 0 END) +
  (CASE WHEN classes.bore=15 THEN 1 ELSE 0 END) +
  (CASE WHEN classes.displacement=32000 THEN 1 ELSE 0 END) +
  (CASE WHEN classes.type='bb' THEN 1 ELSE 0 END) +
  (CASE WHEN classes.country='USA' THEN 1 ELSE 0 END) +
    (CASE WHEN classes.class='Kon' THEN 1 ELSE 0 END) +
  (CASE WHEN ships.launched='1915' THEN 1 ELSE 0 END) 
) >= 4

-- 10. БД «Комп. фірма». Для кожної моделі продукції з усієї БД виведіть
-- її середню ціну. Вивести: type, model, середня ціна. (Підказка: вико-
-- ристовувати оператор UNION)

SELECT product.type, product.model,
       TRUNCATE(AVG(union_products.price),2) AS avg_price
FROM   product,
       (
           SELECT pc.model, pc.price FROM pc
          UNION
         SELECT laptop.model, laptop.price FROM laptop
          UNION
         SELECT printer.model, printer.price FROM printer
       ) AS union_products
       WHERE product.model = union_products.model
       GROUP BY product.model;
