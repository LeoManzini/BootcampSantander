CREATE TABLE IF NOT EXISTS students (
	student_id BIGSERIAL PRIMARY KEY,
	student_name VARCHAR(120) NOT NULL,
	student_email VARCHAR(250) NOT NULL,
	active BOOLEAN NOT NULL DEFAULT TRUE,
	creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO 
students(student_name, student_email)
VALUES('Giovanna de Oliveira', 'gigi@queen.com');

INSERT INTO 
students(student_name, student_email)
VALUES('Leonardo Henrique Manzini', 'henrique@sudito.com');

INSERT INTO 
students(student_name, student_email)
VALUES('ERRADO', 'henrique@sudito.com');

CREATE TABLE IF NOT EXISTS students (
	student_id BIGSERIAL PRIMARY KEY,
	student_name VARCHAR(120) NOT NULL,
	student_age NUMERIC(2, 0) NOT NULL,
	student_state NUMERIC(5, 0) NOT NULL
);

INSERT INTO 
students(student_name, student_age, student_state)
VALUES('Giovanna de Oliveira', 22, 1);

INSERT INTO 
students(student_name, student_age, student_state)
VALUES('Leonardo Henrique Manzini', 21, 1);

INSERT INTO 
students(student_name, student_age, student_state)
VALUES('Joao Pedro Manzini', 19, 1);

INSERT INTO 
students(student_name, student_age, student_state)
VALUES('Tulio de Oliveira', 18, 1);

CREATE TABLE IF NOT EXISTS states (
	state_id BIGSERIAL PRIMARY KEY,
	state_name VARCHAR(120) NOT NULL
);

INSERT INTO 
states(state_name)
VALUES('Sao Paulo');

INSERT INTO 
states(state_name)
VALUES('Minas Gerais');

INSERT INTO 
states(state_name)
VALUES('Rio de Janeiro');

INSERT INTO 
states(state_name)
VALUES('Brasilia');