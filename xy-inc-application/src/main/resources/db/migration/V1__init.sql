CREATE TABLE interest_points (
	id BIGINT NOT NULL AUTO_INCREMENT,
	name varchar(100) NOT NULL,
	x int NOT NULL,
	y int NOT NULL,
	PRIMARY KEY (id)
);

INSERT INTO interest_points(name,x,y) VALUES ('Lanchonete', 27, 12);