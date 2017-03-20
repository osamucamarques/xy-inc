CREATE TABLE interest_point (
	id BIGINT NOT NULL AUTO_INCREMENT,
	name varchar(100) NOT NULL,
	x int NOT NULL,
	y int NOT NULL,
	PRIMARY KEY (id)
);

INSERT INTO interest_point(name,x,y) VALUES ('Lanchonete', 27, 12);