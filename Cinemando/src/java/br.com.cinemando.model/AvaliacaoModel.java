package br.com.cinemando;

import java.sql.*;
import java.util.ArrayList;
import conexao.ConexaoMySQL;


import br.com.cinemando.daos.*;

import java.util.Scanner;

public class AvaliacaoModel {
    public static void main(String[] args){
        
        Scanner s = new Scanner(System.in);
        AvaliacaoModel teste = new AvaliacaoModel();
        
        
        /*System.out.println("Para Inserir(1) --- Apagar(2) --- Consultar(3) -- Sair(0)");
        int escolha = s.nextInt();*/
        /*while(escolha != 0){s
            if(escolha == 1){
                Avaliacao ins = new Avaliacao();
                Usuario login = new Usuario();
                Filme filme = new Filme();
                System.out.println("Digite seu login: ");
                login.setUsuLogin(s.next());
                System.out.println("Digite o nome filme que voce deseja avaliar: ");
                filme.setFilmeNome(s.next());
                System.out.print("Digite a nota: ");
                ins.setAvaliNota(s.nextInt());
                String inserindo = teste.InserirAvaliacao(login,filme,ins);
                System.out.println("Retorno: " + inserindo);
            }
            else if(escolha == 2){
                Avaliacao avaliacaoApagar = new Avaliacao();
                Usuario login = new Usuario();
                Filme filme = new Filme();
                System.out.print("Digite seu login:");
                login.setUsuLogin(s.next());
                System.out.print("Digite o nome do Filme, que contem a Avaliacao que voce deseja apagar: ");
                filme.setFilmeNome(s.next());
                
                String apagando = teste.ApagarAvaliacao(login,filme);
                
                System.out.println("Retorno: " + apagando);
            }

            else if(escolha == 3){
                Filme filme = new Filme();
                System.out.print("Digite o nome do filme que voce deseja ver a media de avaliacoes: ");
                filme.setFilmeNome(s.next());
                String consulta = teste.ConsultarAvaliacao(filme);
                System.out.println(consulta);
            }
            
            System.out.println("Para Inserir(1) --- Apagar(2) --- Consultar(3) -- Sair(0)");
            escolha = s.nextInt();
        }*/
        
    }
    
   public String InserirAvaliacao(Usuario login, Filme filme, Avaliacao avali) {
    ConexaoMySQL conexao = new ConexaoMySQL();
    Connection conn = conexao.conectar();
    String resultado = "";
    try {
        // Consulta para obter o código do usuário e do filme
        String consulta = "INSERT INTO avaliacao (avaliNota, usuCod, filmeCod) "
                        + "SELECT ?, u.usuCod, f.filmeCod "
                        + "FROM usuario u, filme f "
                        + "WHERE u.usuLogin = ? AND f.filmeNome = ?";
        
        PreparedStatement stm = conn.prepareStatement(consulta);
        stm.setInt(1, avali.getAvaliNota());
        stm.setString(2, login.getUsuLogin());
        stm.setString(3, filme.getFilmeNome());
        
        int rowsAffected = stm.executeUpdate();
        if (rowsAffected > 0) {
            resultado = "Inserido com sucesso";
        } else {
            resultado = "Nenhum dado inserido";
        }
    } catch (SQLException ex) {
        System.out.println(ex.getSQLState());
        resultado = "Erro ao inserir avaliação";
    } finally {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar conexão: " + ex.getMessage());
        }
    }
    return resultado;
}

    
    public String ApagarAvaliacao(Usuario login, Filme filme){
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "DELETE FROM avaliacao WHERE usuCod = ("
                            + "SELECT u.usuCod FROM usuario u WHERE u.usuLogin = ?"
                            + ") AND filmeCod = ("
                            + "SELECT f.filmeCod FROM filme f WHERE f.filmeNome = ?"
                            + ")";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, login.getUsuLogin());
            stm.setString(2, filme.getFilmeNome());
            stm.executeUpdate();
            resultado = "Apagado com sucesso";
        } catch (SQLException ex) {
          System.out.println(ex.getSQLState());
          resultado = "erro";
        } 
        return resultado;
    }
    
    public String ConsultarAvaliacao(Filme filme){
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";

        try {
            // Consulta SQL para calcular a média das notas do filme
            String consulta = "SELECT AVG(avaliNota) AS mediaNotas FROM avaliacao a "
                            + "JOIN filme f ON a.filmeCod = f.filmeCod "
                            + "WHERE f.filmeNome = ?";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, filme.getFilmeNome());

            ResultSet rs = stm.executeQuery(); // Executa a consulta e recupera os resultados.

            if (rs.next()) {
                // Recupera a média das notas do filme
                double mediaNotas = rs.getDouble("mediaNotas");

                if (rs.wasNull()) {
                    resultado = "Nenhuma avaliação encontrada para o filme.";
                } else {
                    resultado = "Média das notas do filme '" + filme.getFilmeNome() + "': " + mediaNotas;
                }
            } else {
                resultado = "Filme não encontrado";
            }

        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            resultado = "Erro ao consultar média das notas: " + ex.getMessage();
        } finally {
            try {
                if (conn != null) conn.close(); // Fecha a conexão com o banco de dados
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão: " + ex.getMessage());
            }
        }
        return resultado;
    }
      
}

    

