DROP DATABASE IF EXISTS buscompany;

CREATE DATABASE `buscompany`;
USE `buscompany`;

CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    	firstName VARCHAR(50) NOT NULL,
        lastName VARCHAR(50) NOT NULL,
        patronymic VARCHAR(50),
        login VARCHAR(50),
        password VARCHAR(20)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

