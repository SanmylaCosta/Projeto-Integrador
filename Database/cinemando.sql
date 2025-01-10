CREATE DATABASE cinemando;
USE cinemando;

CREATE TABLE Diretor(
    dirCod INT PRIMARY KEY AUTO_INCREMENT,
    dirNome VARCHAR(50),
    dirDataN DATE
);

CREATE TABLE Ator(
    atorCod INT PRIMARY KEY AUTO_INCREMENT,
    atorNome VARCHAR(50),
    atorDataN DATE
);

CREATE TABLE Usuario(
    usuCod INT PRIMARY KEY AUTO_INCREMENT,
    usuNome VARCHAR(50),
    usuLogin VARCHAR(50),
    usuSenha CHAR(20),
    usuDataN DATE,
    usuEmail VARCHAR(50),
    usuTel CHAR(20)
);

CREATE TABLE Roteirista(
    rotCod INT PRIMARY KEY AUTO_INCREMENT,
    rotNome VARCHAR(50),
    rotDataN DATE
);

CREATE TABLE Filme(
    filmeCod INT PRIMARY KEY AUTO_INCREMENT,
    filmeNome VARCHAR(50),
    filmeGenero VARCHAR(50),
    filmeClaIndic CHAR(2),
    filmeSinopse TEXT,
    filmeDataL DATE,
    filmeProdu VARCHAR(50),
    filmeTrailer VARCHAR(80)
);

CREATE TABLE Avaliacao(
    avaliCod INT PRIMARY KEY AUTO_INCREMENT,
    avaliNota INT,
    filmeCod INT,
    usuCod INT,
    FOREIGN KEY(filmeCod) REFERENCES Filme(filmeCod),
    FOREIGN KEY(usuCod) REFERENCES Usuario(usuCod) ON DELETE CASCADE
);

CREATE TABLE AtorFilme(
    atorFilmeCod INT PRIMARY KEY AUTO_INCREMENT,
    filmeCod INT,
    atorCod INT,
    FOREIGN KEY(filmeCod) REFERENCES Filme(filmeCod),
    FOREIGN KEY(atorCod) REFERENCES Ator(atorCod)
);

CREATE TABLE RoteiristaFilme(
    rotFilmeCod INT PRIMARY KEY AUTO_INCREMENT,
    rotCod INT,
    filmeCod INT,
    FOREIGN KEY(rotCod) REFERENCES Roteirista(rotCod),
    FOREIGN KEY(filmeCod) REFERENCES Filme(filmeCod)
);

CREATE TABLE DiretorFilme(
    dirFilmeCod INT PRIMARY KEY AUTO_INCREMENT,
    dirCod INT,
    filmeCod INT,
    FOREIGN KEY(dirCod) REFERENCES Diretor(dirCod),
    FOREIGN KEY(filmeCod) REFERENCES Filme(filmeCod)
);

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

INSERT INTO Roteirista (rotNome, rotDataN)
VALUES 
    ("Phil Lord", "1975-07-12"),
    ("Vinay Virmani", "1985-01-24"),
    ("Paulo Gustavo", "1978-10-30"),
    ("Lee Cronin", "1973-06-01"),
    ("Lukas Dhont", "1991-05-14"),
    ("Lana Wachowski", "1965-06-21"),
    ("Scott Derrickson", "1966-07-16"),
    ("Karey Kirkpatrick", "1964-12-14"),
    ("Juliana Vicente", "1984-09-13"),
    ("Jennifer Lee", "1971-10-22");

INSERT INTO Filme (filmeNome, filmeGenero, filmeClaIndic, filmeSinopse, filmeDataL, filmeProdu, filmeTrailer)
VALUES 
    ("Homem-Aranha no Aranhaverso", "Ação", "L", "Após ser atingido por uma teia radioativa, Miles Morales, um jovem negro do Brooklyn, se torna o Homem-Aranha, inspirado no legado do já falecido Peter Parker. Entretanto, ao visitar o túmulo de seu ídolo em uma noite chuvosa, ele é surpreendido com a presença do próprio Peter, vestindo o traje do herói por baixo de um sobretudo. A surpresa fica ainda maior quando Miles descobre que ele veio de uma dimensão paralela, assim como outras versões do Homem-Aranha.", "2019-01-10", "Sony Pictures Entertainment", "https://www.youtube.com/watch?v=SS6ABPkfmBE"),
    ("Amor em Little Italy", "Romance", "12", "Nikki é uma talentosa chef que trabalha em Londres. Ao voltar à pizzaria da família em Little Italy, Canadá, ela inicia um romance com seu amigo de infância. Mas há um problema: Léo é o filho do inimigo de sua família", "2018-08-24", "Voltage Pictures", "https://www.youtube.com/watch?v=jLhU0MaSTcI"),
    ("Minha Mãe é Uma Peça", "Comédia", "12", "Dona Hermínia é uma senhora de meia-idade, divorciada do marido, que a trocou por uma mulher mais jovem. Hiperativa, ela não larga o pé de seus filhos Marcelina e Juliano. Um dia, após descobrir que eles a consideram chata, ela resolve sair de casa sem avisar ninguém, deixando todos preocupados. Dona Hermínia decide visitar a querida tia Zélia para desabafar suas tristezas atuais e recordar os bons tempos do passado.", "2012-06-21", "Paramount Pictures", "https://www.youtube.com/watch?v=HrST-4WLlbA"),
    ("A Morte do Demônio: A Ascensão", "Terror", "18", "Uma mulher se encontra em uma luta por sua vida quando um livro antigo dá à luz demônios sedentos por sangue. Eles se tornam cada vez mais agressivos em um prédio em Los Angeles.", "2023-04-20", "Ghost House Pictures", "https://www.youtube.com/watch?v=5n9v35xgRpw"),
    ("Close", "Drama", "12", "Léo e Rémi, de 13 anos, são amigos inseparáveis. Eles sempre estiveram juntos. No entanto, um distanciamento os separa. Léo decide se aproximar de Sophie, mãe de Rémi, em busca de respostas.", "2022-11-03", "Diaphana Films", "https://www.youtube.com/watch?v=A16TYi-u3ew"),
    ("Matrix", "Ficção científica", "14", "Em um futuro próximo, Thomas Anderson (Keanu Reeves), um jovem programador de computador que mora em um cubículo escuro, é atormentado por estranhos pesadelos nos quais está conectado por cabos a um imenso sistema de computadores do futuro. Em todos os pesadelos, sempre acorda no momento crucial, quando os cabos estão prestes a dominá-lo. À medida que o sonho se repete, Anderson começa a ter dúvidas sobre a realidade. Por meio de suas pesquisas, ele conhece Morpheus (Laurence Fishburne), líder de um grupo considerado terrorista pela polícia.", "1999-05-21", "Warner Bros", "https://www.youtube.com/watch?v=IhPni19cF1A"),
    ("O Telefone Preto", "Suspense", "16", "Em uma cidade no Colorado, nos Estados Unidos, um sequestrador mascarado tem raptado e assassinado meninos. Um dos alvos de sua mira, no entanto, tem uma chance de escapar ao receber a ajuda das vítimas anteriores do assassino por meio de um telefone preto misterioso.", "2022-06-24", "Universal Pictures", "https://www.youtube.com/watch?v=eovI2Gfuh_8"),
    ("As crônicas de Spiderwick", "Fantasia", "L", "Dos três filhos de Grace, Jared sempre foi considerado o causador de problemas. Assim, quando coisas estranhas acontecem depois que a família se muda para uma propriedade arruinada, a irmã Mallory, o irmão gêmeo Simon e a mãe pensam que Jared é o responsável por tudo. Na verdade, eles descobrem que criaturas mágicas que vagueiam pelas terras querem o livro mágico que Jared encontrou, um guia sobre criaturas fantásticas, escrito por Arthur Spiderwick.", "2008-03-21", "Paramount Pictures", "https://www.youtube.com/watch?v=M7oLRnZ9GxY"),
    ("Racionais - Das ruas de São Paulo pro mundo", "Documentário", "14"," Com seus protestos em forma de música, o lendário grupo de rap Racionais MC 's transformou a poesia de rua em um movimento poderoso no Brasil e no mundo. Acompanhe sua trajetória de glória e luta", "2022-11-16", "Netflix Brazil", "https://www.youtube.com/watch?v=yygycbPNjAI"),
    ("Frozen II", "Infantil", "L", "Em Frozen II, Elsa e Anna embarcam em uma jornada perigosa mas notável. Elsa, motivada por uma voz misteriosa, procura descobrir a verdade sobre seus poderes mágicos e salvar seu reino.", "2019-11-22", "Walt Disney Animation Studios", "https://www.youtube.com/watch?v=eSLe4HuKuK0");

INSERT INTO Avaliacao (avaliNota, filmeCod, usuCod)
VALUES 
    (5, 1, 1),
    (1, 2, 2),
    (3, 3, 3),
    (3, 4, 4),
    (1, 5, 5),
    (4, 6, 6),
    (2, 7, 7),
    (3, 8, 8),
    (4, 9, 9),
    (5, 10, 10);

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

