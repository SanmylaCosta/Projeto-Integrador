use cinemando;
Create database cinemando;
use cinemando;

 -- Sanmyla
create table diretor(
    cod_diretor int primary key,
    nome_diretor varchar(50),
    data_N_D date
  );
  select * from diretor;

-- Jeovana
    create table ator(
    cod_ator int primary key,
    nome_ator varchar(50), 
    data_N_A date
  );

-- Anne 
  create table usuario(
    cod_usuario int primary key,
    nome_usuario varchar(50),
    login varchar(50),
    senha char(20),
    data_N date,
    email varchar(30),
    tel_usuario char(20)
    );
    
-- Yasmin
    create table roteirista(
    cod_roteirista int primary key,
    nome_roteirista varchar(50),
    data_N_R date
  );

-- Yasmin
  create table filme(
    cod_filme int primary key,
    nome_filme varchar(50),
    classific_indicativa char(2),
    sinopse text,
    data_lancamento date,
    produtora varchar(50),
    link_trailer varchar(80),
    cod_diretor int,
    foreign key(cod_diretor) references diretor (cod_diretor)
  );

-- Jeovana
  create table assistiu_filme(
    cod_assistiu int primary key,
    data_assistiu date,
    horario_A time, 
    cod_filme int,
    cod_usuario int,
    foreign key (cod_filme) references filme (cod_filme),
    foreign key (cod_usuario) references usuario(cod_usuario)
  );

-- Sanmyla 
  create table avaliacao(
    cod_avaliacao int primary key,
    nota int,
    data_avaliacao date,
    cod_filme int,
    cod_usuario int,
    foreign key(cod_filme) references filme (cod_filme),
    foreign key(cod_usuario) references usuario (cod_usuario)
  );

-- Yasmin
  create table plano(
    cod_plano int primary key,
    nome_plano varchar(50)
  );

-- Sanmyla
  create table assinatura(
    cod_assinatura int primary key,
    duracao varchar(50),
    forma_pgto varchar(50),
    data_assinatura date,
    cod_usuario int,
    cod_plano int,
    foreign key(cod_usuario) references usuario(cod_usuario),
    foreign key(cod_plano) references plano(cod_plano)
  );

-- Anne 
  create table genero(
    cod_genero int primary key,
    nome_genero varchar(50),
    descricao text
  );

-- Anne
  create table genero_filme(
    cod_generofilme int primary key,
    cod_filme int,
    cod_genero int,
    foreign key(cod_filme) references filme(cod_filme),
	foreign key(cod_genero) references genero(cod_genero)
    );

-- Yasmin
  create table ator_filme(
    cod_atorfilme int primary key, 
    cod_filme int, 
    cod_ator int,
    foreign key(cod_filme ) references filme(cod_filme ),
    foreign key(cod_ator) references ator(cod_ator)
  );

-- Yasmin
  create table roteirista_filme(
    cod_roteiristafilme int primary key,
    cod_roteirista int,
    cod_filme int,
    foreign key (cod_roteirista) references roteirista(cod_roteirista),
    foreign key (cod_filme) references filme(cod_filme)
  );

select * from diretor;
-- Jeovana
 insert into diretor (cod_diretor, nome_diretor, data_N_D)
  values (1, "Peter Ramsey", "1962-12-23"),
 (2, "Donald Petrie", "1954-04-02" ),
 (3, "André Pellenz","1977-07-15" ),
 (4, "Lee Cronin", "1973-06-01"),
 (5, "Lukas Dhont", "1991-05-14"),
 (6, "Lana Wachowski", "1965-06-21"),
 (7, "Scott Derrickson", "1966-07-16"),
 (8, "Mark Waters", "1964-06-30"),
 (9, "Juliana Vicente", "1984-09-13"),
 (10, "Chris Buck", "1958-02-24");


select * from ator;
-- Anne
 insert into ator (cod_ator, nome_ator, data_N_A)
  values (1, "Shameik Moore", "1995-04-05"),
   (2, "Emma Roberts", "1991-02-10"),
   (3, "Paulo Gustavo","1978-08-30" ),
   (4, "Alyssa Sutherland", "1982-09-23"),
   (5, "Eden Dambrine", "2009-10-29"),
   (6, "Keanu Reeves", "1964-09-02"),
   (7, "Mason Thames", "2007-10-07"),
   (8, "Freddie Highmore", "1992-02-14"),
   (9, "Mano Brown", "1970-04-22"),
   (10, "Idina Menzel", "1971-05-30");


select * from usuario;
-- Yasmin
insert into usuario (cod_usuario, nome_usuario, login, senha, data_N, email, tel_usuario)
  values (1, 'Luna Sanchez', 'soyluna', 'L2006U', '2006-07-24', 'soyluna@gmail.com', '(11) 98765-4321'),
  (2, 'Railander Hilux', 'luxlander', 'raice28', '2000-03-15', 'railux@yahoo.com', '(21) 12345-6789'),
  (3, 'Reynold Ronaldo', 'reynaldo', 'naldo98', '1898-09-08', 'reynaldo@gmail.com', '(51) 24681-3579'),
  (4, 'Luizote Freitas', 'lutas', '200429', '2004-11-29', 'zote@gmail.com', '(31) 57931-4862'),
  (5, 'Xaulin da Silva', 'xausil', 'xlinhova', '2005-01-23', 'xausil@hotmail.com', '(41) 86429-7531'),
  (6, 'Feyre Archeron', 'feyfey', 'velaris', '1997-12-06', 'feyrearch@gmail.com', '(61) 13579-2468'),
  (7, 'Luz Noceda', 'luzita', 'amitylinda', '2007-03-02', 'noceda@gmail.com', '(48) 64821-3597'),
  (8, 'Jonathan Vieira', 'John', 'familia123', '1990-05-30', 'jovieira@gmail.com', '(84) 91357-2864'),
  (9, 'Flavio do Pneu', 'FlavindoPneu', 'pneulover', '1987-09-22', 'flapneu@hotmail.com', '(71) 79246-8135'),
  (10, 'Violet Baudelaire', 'violet', 'vks3', '2000-02-18', 'baudelaire@yahoo.com', '(81) 41837-5926');


select * from roteirista;
-- Sanmyla
insert into roteirista (cod_roteirista, nome_roteirista, data_N_R)
  values(1, "Phil Lord",'1975-07-12'),
   (2, "Vinay Virmani", '1985-01-24'),
   (3, "Paulo Gustavo", '1978-10-30' ),
   (4, "Lee Cronin", '1973-06-01'),
   (5, "Lukas Dhont", '1991-05-14'),
   (6, "Lana Wachowski", '1965-06-21'),
   (7, "Scott Derrickson", '1966-07-16'),
   (8, "Karey Kirkpatrick", '1964-12-14'),
   (9, "Juliana Vicente", '1984-09-13' ),
   (10, "Jennifer Lee", '1971-10-22');


select * from filme; 
-- Jeovana
insert into filme ( cod_filme, nome_filme, classific_indicativa, sinopse, data_lancamento, produtora, link_trailer, cod_diretor)
    values (1, "Homem-Aranha no Aranhaverso", "L", " Após ser atingido por uma teia radioativa, Miles Morales, um jovem negro do Brooklyn, se torna o Homem-Aranha, inspirado no legado do já falecido Peter Parker. Entretanto, ao visitar o túmulo de seu ídolo em uma noite chuvosa, ele é surpreendido com a presença do próprio Peter, vestindo o traje do herói por baixo de um sobretudo. A surpresa fica ainda maior quando Miles descobre que ele veio de uma dimensão paralela, assim como outras versões do Homem-Aranha.", "2019-01-10","Sony Pictures Entertainment", "https://www.youtube.com/watch?v=SS6ABPkfmBE", 1),
   (2, "Amor em Little Italy", "12", "Nikki é uma talentosa chef que trabalha em Londres. Ao voltar à pizzaria da família em Little Italy, Canadá, ela inicia um romance com seu amigo de infância. Mas há um problema: Léo é o filho do inimigo de sua família", "2018-08-24","Voltage Pictures", "https://www.youtube.com/watch?v=jLhU0MaSTcI", 2),
   (3, "Minha Mãe é Uma Peça", "12", " Dona Hermínia é uma senhora de meia-idade, divorciada do marido, que a trocou por uma mulher mais jovem. Hiperativa, ela não larga o pé de seus filhos Marcelina e Juliano. Um dia, após descobrir que eles a consideram chata, ela resolve sair de casa sem avisar ninguém, deixando todos preocupados. Dona Hermínia decide visitar a querida tia Zélia para desabafar suas tristezas atuais e recordar os bons tempos do passado.", "2012-06-21","Paramount Pictures", "https://www.youtube.com/watch?v=HrST-4WLlbA", 3),
   (4, " A Morte do Demônio: A Ascensão", "18", "Uma mulher se encontra em uma luta por sua vida quando um livro antigo dá à luz demônios sedentos por sangue. Eles se tornam cada vez mais agressivos em um prédio em Los Angeles.", "2023-04-20","Ghost House Pictures", "https://www.youtube.com/watch?v=5n9v35xgRpw", 4),
   (5, " Close", "12", "Léo e Remi são dois melhores amigos de 13 anos cujo vínculo aparentemente inquebrável é repentinamente e tragicamente rompido.", "2023-03-02","Diaphana Films", "https://www.youtube.com/watch?v=dlNWImeXzsQ", 5),
   (6, "Matrix", "14", "O jovem programador Thomas Anderson é atormentado por estranhos pesadelos em que está sempre conectado por cabos a um imenso sistema de computadores do futuro. À medida que o sonho se repete, ele começa a desconfiar da realidade. Thomas conhece os misteriosos Morpheus e Trinity e descobre que é vítima de um sistema inteligente e artificial chamado Matrix, que manipula a mente das pessoas e cria a ilusão de um mundo real enquanto usa os cérebros e corpos dos indivíduos para produzir energia", "1999-05-21","Village Roadshow", "https://youtu.be/2KnZac176Hs", 6),
   (7, "O Telefone Preto", "16", "Finney Shaw, de 13 anos, é sequestrado por um sádico assassino mascarado e mantido em um porão à prova de som. Até que um telefone desconectado na parede começa a tocar, e ele logo descobre que pode ouvir as vozes das vítimas anteriores do maníaco.", "2022-07-21","Blumhouse Productions", "https://www.youtube.com/watch?v=dCAbPQnFAU4", 7),
   (8, " As crônicas de Spiderwick", "L", "Dos três filhos de Grace, Jared sempre foi considerado o causador de problemas. Assim, quando coisas estranhas acontecem depois que a família se muda para uma propriedade arruinada, a irmã Mallory, o irmão gêmeo Simon e a mãe pensam que Jared é o responsável por tudo. Na verdade, eles descobrem que criaturas mágicas que vagueiam pelas terras querem o livro mágico que Jared encontrou, um guia sobre criaturas fantásticas, escrito por Arthur Spiderwick.", "2008-03-21","Paramount Pictures", "https://www.youtube.com/watch?v=M7oLRnZ9GxY", 8),
   (9,"Racionais - Das ruas de são paulo pro mundo", "14", "Com seus protestos em forma de música, o lendário grupo de rap Racionais MC 's transformou a poesia de rua em um movimento poderoso no Brasil e no mundo. Acompanhe sua trajetória de glória e luta.", "2022-11-16","Netflix Brazil", "https://www.youtube.com/watch?v=yygycbPNjAI", 9),
   (10, "Frozen", "L", "Quando seu reino fica preso em um inverno perpétuo, a destemida Anna (Kristen Bell) une forças com o montanhista Kristoff (Jonathan Groff) e sua rena ajudante para encontrar a irmã de Anna, a Rainha da Neve Elsa (Idina Menzel), e quebrar seu feitiço de gelo. Embora sua jornada épica os leve a encontros com trolls místicos, um boneco de neve cômico (Josh Gad), condições difíceis e magia a cada passo, Anna e Kristoff corajosamente avançam em uma corrida para salvar seu reino das garras do inverno.", "2014-01-03","Walt Disney Pictures", "https://www.youtube.com/watch?v=96VwQEhELyY", 10);  


-- Anne
insert into assistiu_filme (cod_assistiu, data_assistiu, horario_A, cod_filme, cod_usuario) 
  values (1, "2022-03-20", "22:15:33", 1, 1),
   (2, "2022-07-25", "18:23:42", 2, 2),
   (3, "2023-03-17", "10:58:36", 3, 3),
   (4, "2023-05-30", "21:12:08", 4, 4),
   (5, "2023-05-02", "15:47:55", 5, 5),
   (6, "2022-09-14", "08:32:19", 6, 6),
   (7, "2022-10-25", "14:30:45", 7, 7),
   (8, "2019-12-10", "09:15:20", 8, 8),
   (9, "2023-06-17", "18:45:55", 9, 9),
   (10, "2017-03-05", "12:20:10", 10, 10);


-- Yasmin
insert into avaliacao (cod_avaliacao, nota, data_avaliacao, cod_filme, cod_usuario)
  values (1, 5, '2022-03-20', 1, 1),
   (2, 1, '2022-07-26', 2, 2),
   (3, 3, '2023-03-17', 3, 3),
   (4, 3, '2023-05-30', 4, 4),
   (5, 1, '2023-05-03', 5, 5),
   (6, 4, '2022-09-15', 6, 6),
   (7, 2, '2022-10-25', 7, 7),
   (8, 3, '2019-12-12', 8, 8),
   (9, 4, '2023-06-19', 9, 9),
   (10, 5, '2017-03-10', 10, 10);
  
  
-- Sanmyla
insert into plano (cod_plano, nome_plano)
  values(1, "Anual"),
  (2, "Trimestral"),
  (3, "Mensal"),
  (4, "Simples"),
  (5, "Familia"),
  (6, "Teste Gratis");

 -- Jeovana
insert into assinatura (cod_assinatura, data_assinatura, duracao, forma_pgto, cod_usuario, cod_plano) 
  values (1,  "2023-01-20", 365, "cartão de debito", 6, 1),
  (2, "2021-09-25", 90, "cartão de debito", 10, 2),
  (3, "2023-05-28", 30, "cartão de credita.o", 7, 3),
  (4, "2022-07-01", 30, "cartão de credito", 4, 4),
  (5, "2020-03-02", 90, "cartão de debito", 8, 5),
  (6, "2021-10-14", 14, "cartão de credito", 9, 6),
  (7, "2021-10-14", 30, "cartão de credito", 3, 4),
  (8, "2021-10-14", 90, "cartão de credito", 1, 2),
  (9, "2021-10-14", 14, "cartão de credito", 5, 6),
  (10, "2021-10-14", 365, "cartão de credito", 2, 1);


-- Anne
insert into genero (cod_genero, nome_genero, descricao) 
   values (1, "Ação/aventura", "Filmes que combinam cenas emocionantes de ação com momentos de aventura, envolvendo desafios físicos e perigos enfrentados pelos protagonistas."),
   (2, "Romance", "Filmes que exploram relacionamentos amorosos e histórias de amor, destacando emoções, paixões e conexões românticas entre os personagens."),
   (3, "Comédia", "Filmes que têm como objetivo principal provocar risos e entretenimento, com situações engraçadas, diálogos humorísticos e personagens divertidos, proporcionando humor ao público."),
   (4, "Terror", "Filmes que visam criar medo, suspense e tensão, com elementos assustadores, como criaturas sobrenaturais, assassinos ou eventos perturbadores, buscando provocar sustos e emoções de terror."),
   (5, "Drama", "Filmes que exploram temas sérios e emocionais, abordando conflitos interpessoais, dilemas morais e questões psicológicas, focando nas emoções e nas jornadas emocionais dos personagens."),
   (6, "Ficção científica", "Filmes que apresentam conceitos científicos e tecnológicos avançados, geralmente ambientados no futuro ou em mundos alternativos, explorando ideias como viagens espaciais, futuros distópicos e avanços científicos."),
   (7, "Suspense", "Filmes que buscam criar tensão e suspense, mantendo o público em expectativa e antecipação em relação ao desenrolar da trama, geralmente com mistérios, reviravoltas e elementos surpreendentes."),
   (8, "Fantasia", "Filmes que apresentam elementos imaginativos e mágicos, muitas vezes situados em mundos fantásticos e com criaturas sobrenaturais, envolvendo aventuras heroicas, magia e mitologia."),
   (9, "Documentário", "Filmes que documentam fatos e eventos do mundo real, fornecendo informações objetivas sobre uma variedade de assuntos, como história, natureza, sociedade e cultura."),
   (10, "Infantil", "Filmes especialmente voltados para crianças, apresentando histórias, personagens e temas adequados para o público infantil, com o objetivo de entreter, educar e inspirar crianças de diferentes idades.");


-- Yasmin
insert into genero_filme (cod_generofilme, cod_filme, cod_genero)
  values(1, 1, 1),
  (2, 2, 2),
  (3, 3, 3),
  (4, 4, 4),
  (5, 5, 5),
  (6, 6, 6),
  (7, 7, 7),
  (8, 8, 8),
  (9, 9, 9),
  (10, 10, 10);


-- Sanmyla
insert into ator_filme (cod_atorfilme, cod_filme, cod_ator)
  values(1, 1,  1),
  (2, 2, 2),
  (3, 3, 3),
  (4, 4, 4),
  (5,5,5),
  (6,6,6),
  (7,7,7),
  (8,8,8),
  (9,9,9),
  (10,10,10);


-- Jeovana
insert into roteirista_filme (cod_roteiristafilme, cod_roteirista, cod_filme)
  values (1, 1, 1),
   (2, 2, 2),
   (3, 3, 3),
   (4, 4, 4),
   (5, 5, 5),
   (6, 6, 6),
   (7, 7, 7),
   (8, 8, 8),
   (9, 9, 9),
   (10, 10, 10);