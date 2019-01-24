SET NAMES `utf8`;

CREATE DATABASE IF NOT EXISTS `restful-demo`
DEFAULT CHARACTER SET `utf8`
DEFAULT COLLATE `utf8_general_ci`;

-- GRANT ALL PRIVILEGES ON `restful-demo`.* TO 'restful-demo'@'127.0.0.1' IDENTIFIED BY 'restful-demo';

CREATE TABLE IF NOT EXISTS `restful-demo`.`token`(
    `userId` INT NOT NULL,
    `token` VARCHAR(32) CHARACTER SET `ascii` COLLATE `ascii_general_ci` NOT NULL, 
    PRIMARY KEY(`userId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET `utf8`
DEFAULT COLLATE `utf8_general_ci`;
