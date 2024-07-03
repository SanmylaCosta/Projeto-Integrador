package conexao;

import java.sql.*;

public class ConexaoMySQL {
    public ConexaoMySQL () {} // construtor de classe
    
    public Connection conectar() {
        Connection con = null;
        try {
            System.out.println("Conectando ao banco...");
            Class.forName("com.mysql.cj.jdbc.Driver"); // driver
            String ip = "127.0.0.1"; // IP do servidor de banco
            String us = "root"; // usuário do banco
            String bd = "cinemando"; // nome do banco de dados
            String pw = ""; // senha do usuário
            con =  DriverManager.getConnection("jdbc:mysql://" + ip + 
                 "/" + bd,us,pw); // instrução para conectar com o BD
               System.out.println("Conectado.");
            System.out.println("Conexao: " + con);  
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return con;
    }
    
    public static void main(String[] args) {
        ConexaoMySQL teste = new ConexaoMySQL();
        teste.conectar();
    }

}
