SELECT numero, nome, ativo
FROM banco;

CREATE OR REPLACE VIEW v_bancos AS (
	SELECT numero, nome, ativo
	FROM banco 
);

SELECT numero, nome, ativo FROM v_bancos;

CREATE OR REPLACE VIEW v_bancos_2 (banco_numero, banco_nome, banco_ativo) AS (
	SELECT numero, nome, ativo
	FROM banco 
);

SELECT banco_numero, banco_nome, banco_ativo FROM v_bancos_2;

INSERT INTO v_bancos_2 (banco_numero, banco_nome, banco_ativo)
VALUES (51, 'Clear Corretora', TRUE);

SELECT banco_numero, banco_nome, banco_ativo FROM v_bancos_2 WHERE banco_numero = 51;
SELECT numero, nome, ativo FROM banco WHERE numero = 51;

UPDATE v_bancos_2 SET banco_ativo = FALSE WHERE banco_numero = 51;

DELETE FROM v_bancos_2 WHERE banco_numero = 51;

CREATE OR REPLACE TEMPORARY VIEW v_agencia AS (
	SELECT nome FROM agencia
);

SELECT nome FROM v_agencia;

CREATE OR REPLACE VIEW v_bancos_ativos AS (
	SELECT numero, nome, ativo
	FROM banco
	WHERE ativo is TRUE
) WITH LOCAL CHECK OPTION;

INSERT INTO v_bancos_ativos (numero, nome, ativo) VALUES (51, 'Clear', FALSE);

CREATE OR REPLACE VIEW v_bancos_com_a AS (
	SELECT numero, nome, ativo 
	FROM v_bancos_ativos
	WHERE nome ILIKE 'A%'
) WITH LOCAL CHECK OPTION;

SELECT numero, nome, ativo FROM v_bancos_com_a;

INSERT INTO v_bancos_com_a (numero, nome, ativo) VALUES (333, 'Alfa', TRUE);
INSERT INTO v_bancos_com_a (numero, nome, ativo) VALUES (331, 'Alfa Omega', TRUE);

CREATE OR REPLACE VIEW v_bancos_ativos AS (
	SELECT numero, nome, ativo
	FROM banco
	WHERE ativo is TRUE
);

CREATE OR REPLACE VIEW v_bancos_com_a AS (
	SELECT numero, nome, ativo 
	FROM v_bancos_ativos
	WHERE nome ILIKE 'A%'
) WITH CASCADED CHECK OPTION;

INSERT INTO v_bancos_com_a (numero, nome, ativo) VALUES (333, 'Alfa', TRUE);
INSERT INTO v_bancos_com_a (numero, nome, ativo) VALUES (331, 'Alfa Omega', TRUE);
INSERT INTO v_bancos_com_a (numero, nome, ativo) VALUES (331, 'Alfa Beta', FALSE);

CREATE TABLE IF NOT EXISTS funcionarios (
	id SERIAL,
	nome VARCHAR(50),
	gerente INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY (gerente) REFERENCES funcionarios(id)
);

INSERT INTO funcionarios (nome, gerente) VALUES ('Ancelmo', null);
INSERT INTO funcionarios (nome, gerente) VALUES ('Beatriz', 1);
INSERT INTO funcionarios (nome, gerente) VALUES ('Magno', 1);
INSERT INTO funcionarios (nome, gerente) VALUES ('Cremilda', 2);
INSERT INTO funcionarios (nome, gerente) VALUES ('Wagner', 4);

SELECT id, nome, gerente FROM funcionarios WHERE gerente IS null
UNION ALL
SELECT id, nome, gerente FROM funcionarios WHERE gerente = 999;

CREATE OR REPLACE RECURSIVE VIEW v_funcionarios (id, gerente, funcionario ) AS (
	SELECT id, gerente, nome
	FROM funcionarios
	WHERE gerente IS null
	UNION ALL 
	SELECT funcionarios.id, funcionarios.gerente, funcionarios.nome
	FROM funcionarios
	JOIN v_funcionarios ON v_funcionarios.id = funcionarios.gerente
);

SELECT id, gerente, funcionario FROM v_funcionarios;