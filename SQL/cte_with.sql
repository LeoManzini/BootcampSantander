SELECT numero, nome FROM banco;
SELECT banco_numero, numero, nome FROM agencia;

-- Statement help you to relation tables creating a new and temporary table, using a select or another consult inside of it
WITH tbl_temp_banco AS (
	SELECT numero, nome FROM banco
)
SELECT numero, nome
FROM tbl_temp_banco;

WITH params AS (
	SELECT 213 AS banco_numero
), tbl_temp_banco AS (
	SELECT numero, nome 
	FROM banco
	JOIN params ON params.banco_numero = banco.numero
)
SELECT numero, nome
FROM tbl_temp_banco;

-- Same thing but with sub selects (select inside another select)
SELECT banco.numero, banco.nome
FROM banco 
JOIN (
	SELECT 213 AS banco_numero
) temp_param ON temp_param.banco_numero = banco.numero;

WITH clientes_e_transacoes AS (
	SELECT cliente.nome AS cliente_nome, 
	tipo_transacao.nome AS tipo_transacao_nome, 
	cliente_transacoes.valor AS tipo_transacao_valor
	FROM cliente_transacoes
	JOIN cliente ON cliente.numero = cliente_transacoes.cliente_numero
	JOIN tipo_transacao ON tipo_transacao.id = cliente_transacoes.tipo_transacao_id
)
SELECT cliente_nome, tipo_transacao_nome, tipo_transacao_valor
FROM clientes_e_transacoes;

WITH clientes_e_transacoes AS (
	SELECT cliente.nome AS cliente_nome, 
	tipo_transacao.nome AS tipo_transacao_nome, 
	cliente_transacoes.valor AS tipo_transacao_valor
	FROM cliente_transacoes
	JOIN cliente ON cliente.numero = cliente_transacoes.cliente_numero
	JOIN tipo_transacao ON tipo_transacao.id = cliente_transacoes.tipo_transacao_id
	JOIN banco ON banco.numero = cliente_transacoes.banco_numero AND banco.nome ILIKE '%Itaú%'
)
SELECT cliente_nome, tipo_transacao_nome, tipo_transacao_valor
FROM clientes_e_transacoes;