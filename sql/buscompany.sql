--DROP DATABASE IF EXISTS buscompany;
--CREATE DATABASE buscompany;

USE `buscompany`;

--drop table users;
--select * from users;
--update users set role = "ROLE_ADMIN"
--	where id = 1;

CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT,
	firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
	patronymic VARCHAR(50),
	login VARCHAR(50),
	password VARCHAR(255),
	userRole enum("ADMIN", "CLIENT"),
	key login (login),
	PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE admins (
    id INT NOT NULL AUTO_INCREMENT,
    position VARCHAR(50) NOT NULL,
    userId INT NOT NULL,
	PRIMARY KEY (id),
	UNIQUE KEY admins (id, userId),
    FOREIGN KEY (userId) REFERENCES users (id) ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE clients (
	id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(50),
    telefonNumber INT,
    userId INT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY clients (id, userId),
    FOREIGN KEY (userId) REFERENCES users (id) ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE sessions (
	id INT NOT NULL AUTO_INCREMENT,
    isActive boolean DEFAULT false,
    userId INT NOT NULL DEFAULT true,
    javaSessionId VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (userId) REFERENCES users(id) ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE buses (
    id INT NOT NULL AUTO_INCREMENT,
    busName VARCHAR(50) NOT NULL,
    placeCount INT NOT NULL,
    UNIQUE KEY buses (busName),
    PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE dateTrip (
	id INT NOT NULL AUTO_INCREMENT,
    `date` VARCHAR(50) NOT NULL,
    tripId INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (tripId) REFERENCES trips(id) ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE trips (
	id INT NOT NULL AUTO_INCREMENT,
    busId INT NOT NULL,
    fromStation VARCHAR(100) NOT NULL,
    toStation VARCHAR(100) NOT NULL,
    `start` VARCHAR(50) NOT NULL,
    duration VARCHAR(50) NOT NULL,
    price DOUBLE NOT NULL,
    fromDate DATE,
    toDate DATE,
    period VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (busId) REFERENCES buses(id) ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;


--insert into users (firstName, lastname, login, password, role) values ("Alex", "Peres", "admin", "test", "ADMIN");

--insert into users (firstName, lastname, login, password, role) values ("Fill", "Kollins", "client", "test", "CLIENT");


