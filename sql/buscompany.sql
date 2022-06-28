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
    isActive boolean DEFAULT true,
    userId INT NOT NULL,
    javaSessionId VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (userId) REFERENCES users(id) ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

--insert into users (firstName, lastname, login, password, role) values ("Alex", "Peres", "admin", "test", "ADMIN");

--insert into users (firstName, lastname, login, password, role) values ("Fill", "Kollins", "client", "test", "CLIENT");


