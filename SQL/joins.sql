SELECT numero, nome FROM banco;
SELECT banco_numero, numero, nome FROM agencia;
SELECT numero, nome FROM cliente;
SELECT banco_numero, agencia_numero, numero, digito, cliente_numero FROM conta_corrente;
SELECT id, nome FROM tipo_transacao;
SELECT banco_numero, agencia_numero, conta_corrente_numero, conta_corrente_digito, cliente_numero, valor FROM cliente_transacoes;

SELECT COUNT(1) FROM banco;
SELECT COUNT(1) FROM agencia;

-- Join or inner join returns the fields that both of the tables have
SELECT banco.numero, banco.nome, agencia.numero, agencia.nome
FROM banco
JOIN agencia ON agencia.banco_numero = banco.numero;

SELECT COUNT (DISTINCT banco.numero)
FROM banco
JOIN agencia ON agencia.banco_numero = banco.numero;

-- Returns all the registers from the left table (first) and all the lines that have a relationship
SELECT banco.numero, banco.nome, agencia.numero, agencia.nome
FROM banco
LEFT JOIN agencia ON agencia.banco_numero = banco.numero;

-- Returns all the registers from the right table (second) and all the lines that have a relationship
SELECT agencia.numero, agencia.nome, banco.numero, banco.nome
FROM agencia
LEFT JOIN banco ON banco.numero = agencia.banco_numero;

-- Return all the relationship and all the tables lines but without the relationship (null value inside)
SELECT banco.numero, banco.nome, agencia.numero, agencia.nome
FROM banco
FULL JOIN agencia ON agencia.banco_numero = banco.numero;

CREATE TABLE IF NOT EXISTS teste_a (
	id SERIAL PRIMARY KEY,
	valor VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS teste_b (
	id SERIAL PRIMARY KEY,
	valor VARCHAR(10)
);

INSERT INTO teste_a (valor) VALUES ('Teste01');
INSERT INTO teste_a (valor) VALUES ('Teste02');
INSERT INTO teste_a (valor) VALUES ('Teste03');
INSERT INTO teste_a (valor) VALUES ('Teste04');

INSERT INTO teste_b (valor) VALUES ('Teste_a');
INSERT INTO teste_b (valor) VALUES ('Teste_b');
INSERT INTO teste_b (valor) VALUES ('Teste_c');
INSERT INTO teste_b (valor) VALUES ('Teste_d');

SELECT * FROM teste_a;
SELECT * FROM teste_b;

-- Returns a table with crossed value between two tables
SELECT tbla.valor, tblb.valor
FROM teste_a tbla
CROSS JOIN teste_b tblb;

DROP TABLE IF EXISTS teste_a;
DROP TABLE IF EXISTS teste_b;

-- Full join or just join, join all the tables at the relationship and you can use more than one field as test if are equals
SELECT banco.nome, agencia.nome, conta_corrente.numero, conta_corrente.digito, cliente.nome
FROM banco
JOIN agencia ON agencia.banco_numero = banco.numero
				--	ON conta_corrente.banco_numero = banco.numero -- You can use the bank number or the bank relationship with agency
JOIN conta_corrente ON conta_corrente.banco_numero = agencia.banco_numero
					AND conta_corrente.agencia_numero = agencia.numero
JOIN cliente ON cliente.numero = conta_corrente.cliente_numero;