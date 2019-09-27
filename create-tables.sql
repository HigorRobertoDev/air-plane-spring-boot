CREATE TABLE airplane (
	id INT(11) AUTO_INCREMENT PRIMARY KEY,
	name_airplane VARCHAR(255),
	width_airplane FLOAT(9,2),
	heigth_airplane FLOAT(9,2),
	passenger_capacity INT(4),
	id_airport INT(11)
);