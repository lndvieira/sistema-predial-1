CREATE SCHEMA predial;

USE predial;

-- EMPRESAS
CREATE TABLE empresa (
	id_empresa INT PRIMARY KEY,
	rsocial VARCHAR(30) NOT NULL,
    cnpj CHAR(14)UNIQUE NOT NULL,
    conjunto INT NOT NULL,
    horaF VARCHAR(20) NOT NULL,
    horaA VARCHAR(20) NOT NULL,
    temp VARCHAR(5) NOT NULL
);

INSERT INTO empresa (rsocial, cnpj, conjunto, horaF, horaA, temp)  VALUES 
("Google", "11111111", "1", "10:00-19:00", "13:00-19:00", "20°"),
("Microsoft", "22222222", "2", "10:00-19:00", "13:00-19:00", "20°"),
("Apple", "3333333333", "3", "10:00-19:00", "13:00-19:00", "20°"),
("Samsumg", "44444444444", "4", "10:00-19:00", "13:00-19:00", "20°");

SELECT * FROM empresa;