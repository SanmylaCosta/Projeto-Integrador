<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario</title>

    <script type="text/javascript" src="js/validacao-form.js"></script>
    
    <style>

        body{
            background-image: linear-gradient(to bottom right, blue, blueviolet);
        }

        div{
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-image: linear-gradient(to bottom right, blue, blueviolet);
            
        }
        #submit{
            color: rgb(5, 5, 5);
            width: 100px;
        }
        #form{
            background-color: rgba(0, 0, 0, 0.5);
            padding: 20px;
            color: rgb(255, 254, 254);
            font-family: 'Times New Roman', Times, serif;
            border-radius: 4%;
        }
        input{
            width: 300px;
            height: 30px;
        }
        .span-required{
            display: none;
            font-size: 14px;
            color: red;
            margin: 3px 0 0 1x;
        }
       
    </style>

</head>
<body>
    <div id="dform">
        <img src="css/images/logo2.png" id="logo">
        <form id="form" action="#">
            <h1> Entrar </h1>
            <input type="text" placeholder="Digite seu email" class="required" id="email" oninput="emailValidate()">
            <span class="span-required">Digite um email válido</span>
            <br><br>
            <input type="text" placeholder="Senha" class="required">
            <span class="span-required">Sua senha deve conter no minimo 8 caracteres</span>
            <p><input id="submit" type="submit" value="enviar"></p>
            Novo por aqui? <a class target="self" href="paginaInscricao.html">Assine agora</a>
        </form>
        
    </div>
    
</body>
</html>