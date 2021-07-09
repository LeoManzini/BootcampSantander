CREATE TABLE IF NOT EXISTS teste (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

SELECT * FROM teste;

DROP TABLE IF EXISTS teste;

SELECT * FROM teste;

CREATE TABLE IF NOT EXISTS teste (
	cpf VARCHAR(11) NOT NULL, 
	nome VARCHAR(50) NOT NULL,
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (cpf)
);

INSERT INTO teste (cpf, nome, created_at)
	VALUES('12345678910', 'José Colméia', '2019-07-01 12:00:00');
	
INSERT INTO teste (cpf, nome, created_at)
	VALUES('12345678910', 'José Colméia', '2019-07-01 12:00:00') ON CONFLICT (cpf) DO NOTHING;
	
UPDATE teste SET nome = 'Pedro Alvares' WHERE cpf = '12345678910';

SELECT * FROM teste;