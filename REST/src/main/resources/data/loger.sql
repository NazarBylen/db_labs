USE bylen;

CREATE TABLE IF NOT EXISTS logger
(
    id              INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    settlement      VARCHAR(255) NOT NULL,
    measure         INT NOT NULL,
    action          VARCHAR(100) NOT NULL,
    time_stamp      DATETIME NOT NULL,
    user            VARCHAR(50) NULL
);