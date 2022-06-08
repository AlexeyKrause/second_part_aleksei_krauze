DROP DATABASE IF EXISTS buscompany;

USE `buscompany`;

drop table users;
select * from users;
update users set role = "ROLE_ADMIN"
	where id = 1;

CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT,
	firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
	patronymic VARCHAR(50),
	login VARCHAR(50),
	password VARCHAR(255),
	role varchar(20),
	isActiv boolean default true,
	PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE admins (
    id INT NOT NULL AUTO_INCREMENT,
    position VARCHAR(50) NOT NULL,
    userId INT NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (userId) REFERENCES users (id) ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

insert into users (firstName, lastname, login, password, role) values ("Alex", "Peres", "admin", "$2a$12$xedkG5qwTgCjVj7qdOcph.DrbYuXJ3XF6S51gueRSbw8i/JCTDogy", "ROLE_ADMIN");
insert into users (firstName, lastname, login, password, role) values ("Fill", "Kollins", "client", "$2a$12$xedkG5qwTgCjVj7qdOcph.DrbYuXJ3XF6S51gueRSbw8i/JCTDogy", "ROLE_CLIENT");
