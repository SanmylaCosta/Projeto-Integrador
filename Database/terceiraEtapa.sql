use cinemando;
-- Anne: tabela filme

-- Procedimento 1: 
delimiter $
create procedure insere_filme (varCodF int,
    varNomeF varchar(50),
    varClassificF char(2),
    varSinopse text,
    varLancamento date,
    varProdutora varchar(50),
    varTrailer varchar(80),
    varDiretor int)
begin 
  if(varNomeF is null)then
select "O nome do filme é de preenchimento obrigatório" as msg;
else if ( varLancamento is null)then
select "A data de lançamento do filme é de preenchimento obrigatório" as msg;
else
insert into filme values
(varCodF, varNomeF, varClassificF, varSinopse, varLancamento, varProdutora, varTrailer, varDiretor);
end if;
end if;
end $
delimiter ;

   call insere_filme(13, null, "L", "teste", "2023-03-02","Diaphana Films", "https", 5);
   call insere_filme(14, "filme teste", "L", "teste", null,"Diaphana Films", "https", 5);

-- Procedimento 2: 
delimiter $

create procedure listar_filmes_ator(varNomeA varchar(50))
begin
    declare ator_id int;
    select cod_ator into ator_id
    from ator
    where nome_ator = varNomeA;

        select f.nome_filme, count(af.cod_filme) vezes_assistido
        from filme f, assistiu_filme af
    where f.cod_filme = af.cod_filme
        and f.cod_filme in(
        select cod_filme
        from ator_filme 
        where cod_ator = ator_id
        )
    group by f.nome_filme;

end $
delimiter ;

call listar_filmes_ator("Mano Brown");

-- Procedimento 3: 
delimiter $
create procedure listar_filme_periodo(inicio date, fim date)
begin
    select f.nome_filme, COUNT(afi.cod_filme) vezes_assistido
    from filme f, assistiu_filme afi
    where f.cod_filme = afi.cod_filme and afi.data_assistiu between inicio and fim
    group by 1;
end $
delimiter ;

call listar_filme_periodo("2017-03-05","2019-12-10");

-----------------------------------------------------------------------------

-- Jeovana: tabela avaliação

-- Procedimento 1 - Jeovana
DELIMITER $$
create procedure Filmes2223 (in inicio date, in fim date)
begin
select nome_filme, data_lancamento
from filme
where data_lancamento between inicio and fim;
end$$
DELIMITER ;         

Call Filmes2223("2022-01-01", "2023-12-01");

-- Procedimento 2 - Jeovana
DELIMITER $
create procedure Relatorios12 (in tipo_relatorio varchar (50))
begin
if tipo_relatorio = 'lista_ntmedia' then
select f.nome_filme, round(avg(a.nota),1) as nt_media
from filme f
left join avaliacao a 
on f.cod_filme = a.cod_filme
group by f.nome_filme;

else if tipo_relatorio = 'lista_mrnota' then
  select f.nome_filme, a.nota as maior_nota
  from filme f
  left join avaliacao a 
  on f.cod_filme = a.cod_filme 
  and a.nota = (select max(a.nota) from avaliacao a);
else 
  select 'Tipo de relatório inválido';
end if;
end if;
end $
DELIMITER ;  

Call Relatorios12 ('lista_ntmedia');
Call Relatorios12 ('lista_mrnota');

-- Procedimento 3 - Jeovana
DELIMITER $$
create procedure InsercaoAvaliacao (in cod_avaliacao int, in cod_usuario int, in cod_filme int, in nota int)
begin
  if cod_avaliacao is null or cod_usuario is null or cod_filme is null or nota is null then
    select 'Dados inválidos' as "Mensagem";  
else 
  insert into avaliacao (cod_avaliacao, cod_usuario, cod_filme, nota)
values(cod_avaliacao, cod_usuario, cod_filme, notaaa);
end if;
end$$
DELIMITER ;

Call InsercaoAvaliacao  (11, 3, null, 5);
select*from avaliacao;

-----------------------------------------------------------------------------
-- Sanmyla: tabela usuario
-- Procedimento 1:
DELIMITER $
create procedure listarNotaMedia(var_dataIni date , var_dataFinal date)
BEGIN
  Select f.nome_filme, if(avg(a.nota) is null, "Sem avaliacao", cast((a.nota)  as char))as media
    from filme f left join avaliacao a on a.cod_filme = f.cod_filme
    and a.data_avaliacao between var_dataIni and var_dataFinal
    group by f.nome_filme ;
END $
DELIMITER ;
 -- drop procedure listarNotaMedia;
call listarNotaMedia ('2021-03-10', '2023-07-30');

-- Procedimento 2:
DELIMITER $
create procedure lancamento()
BEGIN
Select f.nome_filme,f.data_lancamento, "Ja foi lancado" as 'lacamento'
from filme f 
where data_lancamento < current_date()
UNION ALL
Select f.nome_filme,f.data_lancamento, "Lancamento proximo"
from filme f 
where timestampdiff(day,current_date(), data_lancamento) >= 0 and 
timestampdiff(day,current_date(), data_lancamento) <= 7
UNION ALL
Select F.nome_filme,f.data_lancamento, "Nao estreiado"
from filme f
where timestampdiff(day,current_date(), data_lancamento) > 7;

END $
DELIMITER ;
drop procedure lancamento;
CALL lancamento();

-- Procedimento 3:
DELIMITER $
create procedure insercaoUsuario( cod_usuario int, nomeUsuario varchar(50), loginn varchar(50), senhaa char(20), dataN date, emaill varchar(30), tel char(20) )
BEGIN

if(nomeUsuario is null or loginn is null or senhaa is null or dataN is null or emaill is null) then
  Select ("Voce deixou de preencher algum campo, por favor corrija") as mensagem;
else 
  insert into usuario(cod_usuario,nome_usuario, login, senha, data_N, email, tel_usuario) values(
    cod_usuario,nomeUsuario, loginn, senhaa, dataN, emaill, tel );
end if ;
END $
DELIMITER ;
drop procedure insercaoUsuario;
call insercaoUsuario(11, 'Joana', 'Juaninha', 'joaninhaVermelinha02', '2002-07-01', 'vermelinha002@gmail.com', '997897515');
call insercaoUsuario(12,'Mae Joana', null , 'casaDamaeJoana', '1990-07-01', null, '997897515');
select nome_usuario, login from usuario;

-----------------------------------------------------------------------------

-- Yasmin: tabela assinatura
-- Procedimento 1:
DELIMITER $
create procedure assinatura_disponivel (varNomePlano varchar(50))
begin
select
-- asterisco pra pegar todos os dados da tabela
a.*, timestampdiff (day, current_date(), duracao)
from
assinatura a
inner join plano p on p.cod_plano = a.cod_plano
where p.nome_plano = var_nome_plano;
end $
DELIMITER ;

call assinatura_disponivel ("trimestral");

-- Procedimento 2:

delimiter $

create procedure media_avaliacoes(varNomeDiretor varchar(50))
begin
     select
        f.nome_filme, (select round(AVG(a.nota),1)
        from avaliacao a
        where a.cod_filme = f.cod_filme) media_avaliacoes
    from filme f
    where f.cod_diretor = (select cod_diretor
    from diretor
    where nome_diretor = varNomeDiretor);
end $

delimiter ;

call media_avaliacoes('Peter Ramsey');

-- Procedimento 3:
delimiter $
create procedure inserir_assinatura(
in var_duracao varchar(50),
in var_formapgto varchar(50),
in var_dataassinatura date,
in var_codusuario int,
in var_cod_plano int)
begin 
  if(var_formapgto is null)then
select "A forma de pagamento é de preenchimento obrigatório" as msg;
else if (var_dataassinatura is null)then
select "A data de assinatura é de preenchimento obrigatório" as msg;
else
insert into assinatura values (var_duracao, var_formapgto, var_dataassinatura, var_codusuario, var_cod_plano);
end if;
end if;
end $
delimiter ;
drop procedure inserir_assinatura;
 call inserir_assinatura('3 meses', 'cartão de crédito', null, 1, 2);
  call inserir_assinatura('3 meses', null, '2000-09-30', 1, 2);

-----------------------------------------------------------------------------

