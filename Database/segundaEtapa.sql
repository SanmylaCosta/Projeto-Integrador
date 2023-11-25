--  5 consultas (Between, Like, IN, =, <, >, >=, <=, !=)
-- 1- Listar o título do filme, gênero e data de avaliação dos filmes que foram avaliados com 5 estrelas. -- Anne
SELECT f.nome_filme, g.nome_genero, a.data_avaliacao
FROM filme f, avaliacao a, genero_filme gf, genero g
WHERE f.cod_filme = a.cod_filme AND f.cod_filme = gf.cod_filme AND gf.cod_genero = g.cod_genero AND a.nota = 5;

-- 2- Liste o nome dos filmes, data  e o diretor dos filmes lançados entre 2019 a 2023.  -- Anne
SELECT f.nome_filme, f.data_lancamento, d.nome_diretor
FROM filme f,  diretor d
WHERE d.cod_diretor= f.cod_diretor and f.data_lancamento 
BETWEEN '2019-01-01' AND '2023-12-31';

-- 3- Liste os nomes de usuários, email, e o login dos mesmos que comece com o nome “Lu”.  -- Anne
SELECT u.nome_usuario, u.email, u.login
FROM usuario u
WHERE nome_usuario LIKE 'Lu%';

-- 4- Listar o nome e data de nascimento dos usuários que fizeram a assinatura no ano de 2023. -- Jeovana
SELECT u.nome_usuario, u.data_N
FROM usuario u, assinatura a
WHERE u.cod_usuario = a.cod_usuario and a.data_assinatura 
BETWEEN '2023-01-01' and '2023-12-31';

-- 5- Selecionar o nome e data de lançamento dos filmes em que a classificação indicativa é livre.-- Jeovana
SELECT f.nome_filme, f.data_lancamento
FROM filme f
WHERE f.classific_indicativa = "L";


-- Definir 5 Consultas com junção de Tabelas
-- 1- Liste o nome e a data de nascimento dos atores que fizeram filmes do gênero fantasia. -- Sanmyla
SELECT f.nome_filme, a.nome_ator, a.data_N_A
FROM ator_filme af, filme f, ator a, genero_filme gf, genero g
WHERE af.cod_filme = f.cod_filme AND af.cod_ator = a.cod_ator AND f.cod_filme = gf.cod_filme AND gf.cod_genero = g.cod_genero AND g.nome_genero = 'Fantasia';

-- 2- Listar os filmes que possuem o diretor "Jordan Peele". - Yasmin
Select f.nome_filme
from filme f, diretor d 
where d.cod_diretor = f.cod_diretor and d.nome_diretor = "Jordan Peele";

-- 3- Liste os nomes dos usuários (e o nome do filme) que deram notas maiores que 3, nos filmes lançados de 2010 até o dia atual - Sanmyla
Select u.nome_usuario, f.nome_filme
from usuario u, filme f, avaliacao a
where u.cod_usuario = a.cod_usuario and f.cod_filme = a.cod_filme and a.nota >= 3 and f.data_lancamento BETWEEN '2010-01-01' AND current_date();

-- 4- Liste o nome e o tipo do plano, que teve suas assinaturas feitas no primeiro semestre de 2023 - Sanmyla 
Select u.nome_usuario, p.nome_plano
from usuario u, plano p, assinatura a
where u.cod_usuario = a.cod_usuario and p.cod_plano = a.cod_plano and a.data_assinatura between '2023-01-01' and '2023-06-01';

-- 5- Liste o nome dos usuários que assistiram filmes entre 12h e 18h - Yasmin
Select u.nome_usuario
from usuario u
inner join assistiu_filme af on u.cod_usuario = af.cod_usuario
where af.horario_A >= '12:00:00' and af.horario_A <= '18:00:00';


-- Definir 5 Consultas com funções agregadas e agrupamento de dados.
-- 1- Liste a menor nota de todas as avaliações. –  Jeovana
Select f.nome_filme, f.classific_indicativa, min(a.nota)
From filme f, avaliacao a
where f.cod_filme = a.cod_filme
group by 1,2 ;

-- 2- Liste a data mais recente até a mais antiga dos filmes lançados – Jeovana
select f.nome_filme, f.classific_indicativa, MAX(f.data_lancamento) data_lancamento
from filme f
group by 1, 2
order by data_lancamento desc;


-- 3- Listar a quantidade de usuários com “%gmail” no login e a quantidade dos que não tem  – Anne
Select  login, count(cod_usuario) Qtd_Uusario
from usuario u
where email like '%gmail.com%'
group by 1;

-- 4- Listar a quantidade de usuários com plano "Teste Grátis" - Anne
Select p.nome_plano, count(a.cod_usuario)
From usuario u, assinatura a, plano p
Where u.cod_usuario = a.cod_usuario and p.cod_plano = a.cod_plano
group by 1;

 -- 5 Liste nome do filme e a quantidade de usuarios que assistiram o filme depois das 18 horas - Sanmyla
Select f.nome_filme,count(af.cod_assistiu)
from assistiu_filme af, filme f
where f.cod_filme = af.cod_filme and af.horario_A > '18:00:00'
group by f.cod_filme;