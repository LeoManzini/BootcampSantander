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