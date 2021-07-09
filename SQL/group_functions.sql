-- Tables created at class
SELECT numero, nome FROM banco;

SELECT banco_numero, numero, nome FROM agencia;

SELECT numero, nome, email FROM cliente;

SELECT banco_numero, agencia_numero, cliente_numero FROM cliente_transacoes;

SELECT * FROM conta_corrente;

-- Show all the specified table columns
SELECT * FROM information_schema.columns WHERE table_name = 'banco';

SELECT column_name, data_type FROM information_schema.columns WHERE table_name = 'banco';

-- AVG returns the column average
SELECT AVG(valor) FROM cliente_transacoes;

-- COUNT returns the count of a table column
SELECT COUNT(numero) FROM cliente;

-- COUNT and other column need to be grouped, cause of this we use GROUP BY sentence
SELECT COUNT(numero), email FROM cliente WHERE email ILIKE '%@gmail.com' GROUP BY email;

-- MAX select the higher value from a column
SELECT MAX(numero) FROM cliente;

-- MIN select the lower value from a column
SELECT MIN(numero) FROM cliente;

SELECT MAX(valor) FROM cliente_transacoes;
SELECT MIN(valor) FROM cliente_transacoes;

-- When you use a group function and want to show another column, you have to group the other column too
-- for this you can use GROUP BY
SELECT MAX(valor), tipo_transacao_id FROM cliente_transacoes GROUP BY tipo_transacao_id;
SELECT MIN(valor), tipo_transacao_id FROM cliente_transacoes GROUP BY tipo_transacao_id;

-- With GTOUP BY you can use HAVING clause, that filter your select based on a condition
SELECT COUNT(id), tipo_transacao_id FROM cliente_transacoes GROUP BY tipo_transacao_id HAVING COUNT(id) > 150;

-- SUM sum all the values from a column
SELECT SUM(valor) FROM cliente_transacoes;
SELECT SUM(valor), tipo_transacao_id FROM cliente_transacoes GROUP BY tipo_transacao_id;

-- Order by orders your request by a field DESC or ASC
SELECT SUM(valor), tipo_transacao_id FROM cliente_transacoes GROUP BY tipo_transacao_id ORDER BY tipo_transacao_id;