create table person (
	
id SERIAL NOT NULL PRIMARY KEY,
	nombre VARCHAR(50),
	apellido VARCHAR(50),
	fechadeNacimiento VARCHAR(50)
);

/*create*/
INSERT INTO person (nombre, apellido, fechadeNacimiento) VALUES ('Luis', 'Aleja', 'Enero');

/*read*/
SELECT * FROM person;

/*update*/
UPDATE person SET nombre= 'Antonio', apellido='Rios', fechadeNacimiento='Noviembre' WHERE person.id=1;

/*delete*/
DELETE FROM person WHERE person.id= 2;


