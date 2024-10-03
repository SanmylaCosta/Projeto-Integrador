package br.com.cinemando;

import java.sql.*;
import java.util.ArrayList;
import conexao.ConexaoMySQL;
import java.util.Scanner;
import br.com.cinemando.daos.*; 

public class RoteiristaFilmeModel {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        RoteiristaFilmeModel teste = new RoteiristaFilmeModel();

        System.out.println("Para Inserir(1) --- Consultar (2) --- Sair(0)");
        int escolha = s.nextInt();

        while (escolha != 0) {
            if (escolha == 1) {
                Roteirista ins = new Roteirista();
                Filme filme = new Filme();
                System.out.println("Digite o nome do Roteirista que voce deseja inserir: ");
                ins.setRotNome(s.next());
                System.out.print("Digite o nome do filme: ");
                filme.setFilmeNome(s.next());
                String inserindo = teste.InserirRoteirista(ins, filme);
                System.out.println("Retorno: " + inserindo);
            } 
            else if (escolha == 2) {
                Filme filme = new Filme();
                System.out.print("Digite o filme que voce deseja ver o(s) roteirista(s): ");
                filme.setFilmeNome(s.next());
                String consulta = teste.ConsultarRoteiristasFilme(filme);
                System.out.println(consulta);
            }

            System.out.println("Para Inserir(1) --- Consultar (2) --- Sair(0)");
            escolha = s.nextInt();
            s.nextLine();
        }

    }

    public String InserirRoteirista(Roteirista rot, Filme filme) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "INSERT INTO roteiristafilme (rotCod, filmeCod) "
                    + "SELECT r.rotCod, f.filmeCod "
                    + "FROM roteirista r, filme f "
                    + "WHERE r.rotNome = ? AND f.filmeNome = ?";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, rot.getRotNome());
            stm.setString(2, filme.getFilmeNome());

            int rowsAffected = stm.executeUpdate();
            if (rowsAffected > 0) {
                resultado = "Inserido com sucesso";
            } else {
                resultado = "Nenhum dado inserido";
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir roteirista: " + ex.getMessage());
            resultado = "Erro ao inserir roteirista: " + ex.getMessage();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão: " + ex.getMessage());
            }
        }
        return resultado;
    }

    public String ConsultarRoteiristasFilme(Filme filme) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "SELECT r.rotNome "
                    + "FROM roteirista r "
                    + "JOIN roteiristafilme rf ON r.rotCod = rf.rotCod "
                    + "JOIN filme f ON f.filmeCod = rf.filmeCod "
                    + "WHERE f.filmeNome = ?";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, filme.getFilmeNome());

            ResultSet rs = stm.executeQuery(); // Executa a consulta e recupera os resultados.

            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                // Recupera o nome do roteirista
                String rotNome = rs.getString("rotNome");
                sb.append("Roteirista: ").append(rotNome).append("\n");
            }

            if (sb.length() == 0) {
                resultado = "Nenhum roteirista encontrado para o filme '" + filme.getFilmeNome() + "'.";
            } else {
                resultado = sb.toString();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            resultado = "Erro ao consultar roteiristas: " + ex.getMessage();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão: " + ex.getMessage());
            }
        }
        return resultado;
    }

}
