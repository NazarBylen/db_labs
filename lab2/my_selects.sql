SELECT settlements.*
FROM settlements
INNER JOIN rivers_settlements ON settlements.id = rivers_settlements.settlements_id
WHERE rivers_settlements.rivers_id = 2;

-- Усі міста де тече річка Дніпро

SELECT * FROM settlements
WHERE gps_latitude > 5 and gps_longtitude > 5;

-- Усі міста, координати яких більші за число 5

SELECT rivers.*
FROM rivers
INNER JOIN rivers_settlements ON rivers.id = rivers_settlements.rivers_id
WHERE rivers_settlements.settlements_id IN(2,5,10);

-- Усі річки, що протікають у центральних містах України

SELECT * FROM measures
WHERE measures.date <= '2018-08-06'
ORDER BY measures.water_level;

-- Усі заміри води до 2018-08-06

SELECT settlements.gps_latitude, settlements.gps_longtitude, rivers_settlements.rivers_id
FROM settlements
LEFT JOIN rivers_settlements ON settlements.id = rivers_settlements.settlements_id;

-- Усі координати та річки, які по них протікають, якщо такі є

SELECT rivers.*
FROM rivers
WHERE id IN(6,8,9)
ORDER BY name;

-- Усі річки, що протікають на заході України

SELECT rivers.*, settlements_id AS settlement
FROM rivers
LEFT JOIN rivers_settlements ON rivers.id = rivers_settlements.rivers_id
WHERE rivers_settlements.settlements_id < 5
ORDER BY id;

-- Усі річки, що протікають в найбільших містах України

SELECT id, water_level FROM measures
WHERE water_level IN(21,22,23,24)
ORDER BY id;

-- Усі рівні води у морях

SELECT settlements.name, AVG(measures.water_level) AS avarage_water_level
FROM settlements
INNER JOIN measures ON settlements.id = measures.settlements_id
GROUP BY settlements.name;

-- Середній рівень води у кожному місті

SELECT id, water_level FROM measures
WHERE settlements_id IN(1,7,8,9,12,13,14)
ORDER BY id;

-- Рівень води у містах західної України