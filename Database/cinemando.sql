CREATE DATABASE cinemando;
USE cinemando;

-- Sanmyla
CREATE TABLE Diretor(
    dirCod INT PRIMARY KEY AUTO_INCREMENT,
    dirNome VARCHAR(50),
    dirDataN DATE
);

-- Jeovana
CREATE TABLE Ator(
    atorCod INT PRIMARY KEY AUTO_INCREMENT,
    atorNome VARCHAR(50),
    atorDataN DATE
);

-- Anne
CREATE TABLE Usuario(
    usuCod INT PRIMARY KEY AUTO_INCREMENT,
    usuNome VARCHAR(50),
    usuLogin VARCHAR(50),
    usuSenha CHAR(20),
    usuDataN DATE,
    usuEmail VARCHAR(50),
    usuTel CHAR(20)
);

-- Yasmin
CREATE TABLE Roteirista(
    rotCod INT PRIMARY KEY AUTO_INCREMENT,
    rotNome VARCHAR(50),
    rotDataN DATE
);

-- Yasmin
CREATE TABLE Filme(
    filmeCod INT PRIMARY KEY AUTO_INCREMENT,
    filmeNome VARCHAR(50),
    filmeClaIndic CHAR(2),
    filmeSinopse TEXT,
    filmeDataL DATE,
    filmeProdu VARCHAR(50),
    filmeTrailer VARCHAR(80)
);

-- Sanmyla
CREATE TABLE Avaliacao(
    avaliCod INT PRIMARY KEY AUTO_INCREMENT,
    avaliNota INT,
    avaliData DATE,
    filmeCod INT,
    usuCod INT,
    FOREIGN KEY(filmeCod) REFERENCES filme(filmeCod),
    FOREIGN KEY(usuCod) REFERENCES usuario(usuCod) ON DELETE CASCADE
);

-- Anne
CREATE TABLE Genero(
    genCod INT PRIMARY KEY AUTO_INCREMENT,
    genNome VARCHAR(50),
    descricao TEXT
);

-- Anne
CREATE TABLE GeneroFilme(
    genFilmeCod INT PRIMARY KEY AUTO_INCREMENT,
    filmeCod INT,
    genCod INT,
    FOREIGN KEY(filmeCod) REFERENCES filme(filmeCod),
    FOREIGN KEY(genCod) REFERENCES genero(genCod)
);

-- Yasmin
CREATE TABLE AtorFilme(
    atorFilmeCod INT PRIMARY KEY AUTO_INCREMENT,
    filmeCod INT,
    atorCod INT,
    FOREIGN KEY(filmeCod) REFERENCES filme(filmeCod),
    FOREIGN KEY(atorCod) REFERENCES ator(atorCod)
);

-- Yasmin
CREATE TABLE RoteiristaFilme(
    rotFilmeCod INT PRIMARY KEY AUTO_INCREMENT,
    rotCod INT,
    filmeCod INT,
    FOREIGN KEY(rotCod) REFERENCES roteirista(rotCod),
    FOREIGN KEY(filmeCod) REFERENCES filme(filmeCod)
);

-- Sanmyla
CREATE TABLE DiretorFilme(
    dirFilmeCod INT PRIMARY KEY AUTO_INCREMENT,
    dirCod INT,
    filmeCod INT,
    FOREIGN KEY(dirCod) REFERENCES diretor(dirCod),
    FOREIGN KEY(filmeCod) REFERENCES filme(filmeCod)
);

-- Inserts para a tabela diretor
INSERT INTO Diretor (dirNome, dirDataN)
VALUES 
    ("Peter Ramsey", "1962-12-23"),
    ("Donald Petrie", "1954-04-02"),
    ("André Pellenz", "1977-07-15"),
    ("Lee Cronin", "1973-06-01"),
    ("Lukas Dhont", "1991-05-14"),
    ("Lana Wachowski", "1965-06-21"),
    ("Scott Derrickson", "1966-07-16"),
    ("Mark Waters", "1964-06-30"),
    ("Juliana Vicente", "1984-09-13"),
    ("Chris Buck", "1958-02-24");

-- Inserts para a tabela ator
INSERT INTO Ator (atorNome, atorDataN)
VALUES 
    ("Shameik Moore", "1995-04-05"),
    ("Emma Roberts", "1991-02-10"),
    ("Paulo Gustavo", "1978-08-30"),
    ("Alyssa Sutherland", "1982-09-23"),
    ("Eden Dambrine", "2009-10-29"),
    ("Keanu Reeves", "1964-09-02"),
    ("Mason Thames", "2007-10-07"),
    ("Freddie Highmore", "1992-02-14"),
    ("Mano Brown", "1970-04-22"),
    ("Idina Menzel", "1971-05-30");

-- Inserts para a tabela usuario
INSERT INTO Usuario (usuNome, usuLogin, usuSenha, usuDataN, usuEmail, usuTel)
VALUES 
    ('Luna Sanchez', 'soyluna', 'L2006U', '2006-07-24', 'soyluna@gmail.com', '(11) 98765-4321'),
    ('Railander Hilux', 'luxlander', 'raice28', '2000-03-15', 'railux@yahoo.com', '(21) 12345-6789'),
    ('Reynold Ronaldo', 'reynaldo', 'naldo98', '1898-09-08', 'reynaldo@gmail.com', '(51) 24681-3579'),
    ('Luizote Freitas', 'lutas', '200429', '2004-11-29', 'zote@gmail.com', '(31) 57931-4862'),
    ('Xaulin da Silva', 'xausil', 'xlinhova', '2005-01-23', 'xausil@hotmail.com', '(41) 86429-7531'),
    ('Feyre Archeron', 'feyfey', 'velaris', '1997-12-06', 'feyrearch@gmail.com', '(61) 13579-2468'),
    ('Luz Noceda', 'luzita', 'amitylinda', '2007-03-02', 'noceda@gmail.com', '(48) 64821-3597'),
    ('Jonathan Vieira', 'John', 'familia123', '1990-05-30', 'jovieira@gmail.com', '(84) 91357-2864'),
    ('Flavio do Pneu', 'FlavindoPneu', 'pneulover', '1987-09-22', 'flapneu@hotmail.com', '(71) 79246-8135'),
    ('Violet Baudelaire', 'violet', 'vks3', '2000-02-18', 'baudelaire@yahoo.com', '(81) 41837-5926');

-- Inserts para a tabela roteirista
INSERT INTO Roteirista (rotNome, rotDataN)
VALUES 
    ("Phil Lord", "1975-07-12"),
    ("Vinay Virmani", "1985-01-24"),
    ("Paulo Gustavo", "1978-10-30"),
    ("Lee Cronin", "1973-06-01"),
    ("Lukas Dhont", "1991-05-14"),
    ("Lana Wachowski", "1965-06-21"),
    ("Scott Derrickson", "1966-07-16"),
    ("Juliana Vicente", "1984-09-13"),
    ("Jordan Peele", "1979-02-21"),
    ("Jennifer Lee", "1971-10-22");

-- Inserts para a tabela filme
INSERT INTO Filme (filmeNome, filmeClaIndic, filmeSinopse, filmeDataL, filmeProdu, filmeTrailer)
VALUES 
    ("Homem-Aranha no Aranhaverso", "L", "Após ser atingido por uma teia radioativa, Miles Morales, um jovem negro do Brooklyn, se torna o Homem-Aranha, inspirado no legado do já falecido Peter Parker. Entretanto, ao visitar o túmulo de seu ídolo em uma noite chuvosa, ele é surpreendido com a presença do próprio Peter, vestindo o traje do herói por baixo de um sobretudo. A surpresa fica ainda maior quando Miles descobre que ele veio de uma dimensão paralela, assim como outras versões do Homem-Aranha.", "2019-01-10", "Sony Pictures Entertainment", "https://www.youtube.com/watch?v=SS6ABPkfmBE"),
    ("Amor em Little Italy", "12", "Nikki é uma talentosa chef que trabalha em Londres. Ao voltar à pizzaria da família em Little Italy, Canadá, ela inicia um romance com seu amigo de infância. Mas há um problema: Léo é o filho do inimigo de sua família", "2018-08-24", "Voltage Pictures", "https://www.youtube.com/watch?v=jLhU0MaSTcI"),
    ("Minha Mãe é Uma Peça", "12", "Dona Hermínia é uma senhora de meia-idade, divorciada do marido, que a trocou por uma mulher mais jovem. Hiperativa, ela não larga o pé de seus filhos Marcelina e Juliano. Um dia, após descobrir que eles a consideram chata, ela resolve sair de casa sem avisar ninguém, deixando todos preocupados. Dona Hermínia decide visitar a querida tia Zélia para desabafar suas tristezas atuais e recordar os bons tempos do passado.", "2012-06-21", "Paramount Pictures", "https://www.youtube.com/watch?v=HrST-4WLlbA"),
    ("A Morte do Demônio: A Ascensão", "18", "Uma mulher se encontra em uma luta por sua vida quando um livro antigo dá à luz demônios sedentos por sangue. Eles se tornam cada vez mais agressivos em um prédio em Los Angeles.", "2023-04-20", "Ghost House Pictures", "https://www.youtube.com/watch?v=5n9v35xgRpw"),
    ("Close", "12", "Léo e Rémi, de 13 anos, são amigos inseparáveis. Eles sempre estiveram juntos. No entanto, um distanciamento os separa. Léo decide se aproximar de Sophie, mãe de Rémi, em busca de respostas.", "2022-11-03", "Diaphana Films", "https://www.youtube.com/watch?v=A16TYi-u3ew"),
    ("Matrix", "14", "Em um futuro próximo, Thomas Anderson (Keanu Reeves), um jovem programador de computador que mora em um cubículo escuro, é atormentado por estranhos pesadelos nos quais está conectado por cabos a um imenso sistema de computadores do futuro. Em todos os pesadelos, sempre acorda no momento crucial, quando os cabos estão prestes a dominá-lo. À medida que o sonho se repete, Anderson começa a ter dúvidas sobre a realidade. Por meio de suas pesquisas, ele conhece Morpheus (Laurence Fishburne), líder de um grupo considerado terrorista pela polícia.", "1999-05-21", "Warner Bros", "https://www.youtube.com/watch?v=IhPni19cF1A"),
    ("O Telefone Preto", "16", "Em uma cidade no Colorado, nos Estados Unidos, um sequestrador mascarado tem raptado e assassinado meninos. Um dos alvos de sua mira, no entanto, tem uma chance de escapar ao receber a ajuda das vítimas anteriores do assassino por meio de um telefone preto misterioso.", "2022-06-24", "Universal Pictures", "https://www.youtube.com/watch?v=eovI2Gfuh_8"),
    ("August Rush: O Som do Coração", "L", "August Rush é a história de um menino órfão que usa seu prodigioso talento musical como pista para encontrar seus pais biológicos. August Rush é um drama inspirador que combina um conto de fadas moderno com a magia da música.", "2007-11-21", "Warner Bros", "https://www.youtube.com/watch?v=ZHf_RL9Gexw"),
    ("A Vida É Bela", "12", "Durante a Segunda Guerra Mundial, na Itália, um homem judeu usa seu incrível senso de humor para proteger seu filho dos horrores do campo de concentração. É um conto emocionante sobre o poder do amor e da esperança.", "1997-12-20", "Melampo Cinematografica", "https://www.youtube.com/watch?v=64ZoO7oiN0s"),
    ("Frozen II", "L", "Em Frozen II, Elsa e Anna embarcam em uma jornada perigosa mas notável. Elsa, motivada por uma voz misteriosa, procura descobrir a verdade sobre seus poderes mágicos e salvar seu reino.", "2019-11-22", "Walt Disney Animation Studios", "https://www.youtube.com/watch?v=eSLe4HuKuK0");

-- Inserts para a tabela genero
INSERT INTO Genero (genNome, descricao)
VALUES 
    ("Ação", "Filmes com muita adrenalina e emoção."),
    ("Romance", "Histórias de amor e relacionamentos."),
    ("Comédia", "Filmes engraçados e divertidos."),
    ("Terror", "Filmes que assustam e causam medo."),
    ("Drama", "Histórias emocionantes e impactantes."),
    ("Ficção Científica", "Histórias sobre tecnologia e o futuro."),
    ("Suspense", "Filmes que deixam o espectador em tensão."),
    ("Musical", "Filmes com muita música e dança."),
    ("Histórico", "Filmes baseados em eventos históricos."),
    ("Animação", "Filmes animados e para todas as idades.");

-- Inserts para a tabela generoFilme
INSERT INTO GeneroFilme (filmeCod, genCod)
VALUES 
    (1, 1), (1, 5), (1, 10),
    (2, 2), (2, 3), (2, 5),
    (3, 2), (3, 3), (3, 5),
    (4, 4), (4, 5), (4, 7),
    (5, 5), (5, 7), (5, 10),
    (6, 1), (6, 6), (6, 5),
    (7, 7), (7, 5), (7, 4),
    (8, 2), (8, 3), (8, 7),
    (9, 5), (9, 3), (9, 10),
    (10, 1), (10, 6), (10, 10);

-- Inserts para a tabela atorFilme
INSERT INTO AtorFilme (filmeCod, atorCod)
VALUES 
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (6, 6),
    (7, 7),
    (8, 8),
    (9, 9),
    (10, 10);

-- Inserts para a tabela roteiristaFilme
INSERT INTO RoteiristaFilme (rotCod, filmeCod)
VALUES 
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (6, 6),
    (7, 7),
    (8, 8),
    (9, 9),
    (10, 10);

-- Inserts para a tabela diretorFilme
INSERT INTO DiretorFilme (dirCod, filmeCod)
VALUES 
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (6, 6),
    (7, 7),
    (8, 8),
    (9, 9),
    (10, 10);
