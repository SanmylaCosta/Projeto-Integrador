package br.com.cinemando;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import br.com.cinemando.daos.*;

public class GeneroFilmeModel {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        GeneroFilmeModel controle = new GeneroFilmeModel();

        System.out.println("Inserir(1) -- Consultar Gêneros de Filme(2) -- Consultar Todos Filmes e Gêneros(3) -- Sair(0)");
        int escolha = s.nextInt();
        s.nextLine();  // Consumir o restante da linha

        while (escolha != 0) {
            if (escolha == 1) {
                System.out.print("Digite o nome do filme: ");
                String filmeNome = s.nextLine();
                System.out.print("Digite o nome do gênero: ");
                String genNome = s.nextLine();

                String insercao = controle.inserirGeneroFilme(filmeNome, genNome);
                System.out.println(insercao);
            } else if (escolha == 2) {
                System.out.print("Digite o nome do filme que você deseja consultar: ");
                String filmeNome = s.nextLine();

                String consulta = controle.consultarGeneroFilme(filmeNome);
                System.out.println(consulta);
            } else if (escolha == 3) {
                String consultaTodos = controle.consultarTodosFilmesEGeneros();
                System.out.println(consultaTodos);
            }

            System.out.println("Inserir(1) -- Consultar Gêneros de Filme(2) -- Consultar Todos Filmes e Gêneros(3) -- Sair(0)");
            escolha = s.nextInt();
            s.nextLine();  
        }
        s.close();
    }

    public String inserirGeneroFilme(String filmeNome, String genNome) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";

        try {
            String consultaFilme = "SELECT filmeCod FROM filme WHERE filmeNome = ?";
            PreparedStatement stmFilme = conn.prepareStatement(consultaFilme);
            stmFilme.setString(1, filmeNome);
            ResultSet rsFilme = stmFilme.executeQuery();

            if (!rsFilme.next()) {
                return "Filme não encontrado.";
            }

            int filmeCod = rsFilme.getInt("filmeCod");

            String consultaGenero = "SELECT genCod FROM genero WHERE genNome = ?";
            PreparedStatement stmGenero = conn.prepareStatement(consultaGenero);
            stmGenero.setString(1, genNome);
            ResultSet rsGenero = stmGenero.executeQuery();

            if (!rsGenero.next()) {
                return "Gênero não encontrado.";
            }

            int genCod = rsGenero.getInt("genCod");

            String inserirRelacao = "INSERT INTO generoFilme (filmeCod, genCod) VALUES (?, ?)";
            PreparedStatement stmInserirRelacao = conn.prepareStatement(inserirRelacao);
            stmInserirRelacao.setInt(1, filmeCod);
            stmInserirRelacao.setInt(2, genCod);
            int rowsAffected = stmInserirRelacao.executeUpdate();

            if (rowsAffected > 0) {
                resultado = "Relação entre filme e gênero inserida com sucesso!";
            } else {
                resultado = "Erro ao inserir a relação.";
            }

        } catch (SQLException ex) {
            resultado = "Erro ao inserir a relação: " + ex.getMessage();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                resultado = "Erro ao fechar conexão: " + ex.getMessage();
            }
        }

        return resultado;
    }

    public String consultarGeneroFilme(String filmeNome) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "SELECT g.genNome " +
                              "FROM generoFilme gf " +
                              "JOIN filme f ON gf.filmeCod = f.filmeCod " +
                              "JOIN genero g ON gf.genCod = g.genCod " +
                              "WHERE f.filmeNome = ?";
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, filmeNome);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Gênero(s) do filme '").append(filmeNome).append("':\n");
                do {
                    sb.append(rs.getString("genNome")).append("\n");
                } while (rs.next());

                resultado = sb.toString();
            } else {
                resultado = "Filme não encontrado";
            }

        } catch (SQLException ex) {
            resultado = "Erro ao consultar a relação: " + ex.getMessage();
        } finally {
            try {
                conn.close(); 
            } catch (SQLException ex) {
                resultado = "Erro ao fechar conexão: " + ex.getMessage();
            }
        }
        return resultado;
    }

    public String consultarTodosFilmesEGeneros() {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "SELECT f.filmeNome, GROUP_CONCAT(g.genNome SEPARATOR ', ') AS generos " +
                              "FROM filme f " +
                              "LEFT JOIN generoFilme gf ON f.filmeCod = gf.filmeCod " +
                              "LEFT JOIN genero g ON gf.genCod = g.genCod " +
                              "GROUP BY f.filmeNome";
            PreparedStatement stm = conn.prepareStatement(consulta);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Filmes e seus Gêneros:\n");
                do {
                    String filmeNome = rs.getString("filmeNome");
                    String generos = rs.getString("generos");
                    sb.append("Filme: ").append(filmeNome).append(" | Gênero(s): ").append(generos != null ? generos : "Nenhum").append("\n");
                } while (rs.next());

                resultado = sb.toString();
            } else {
                resultado = "Nenhum filme encontrado";
            }

        } catch (SQLException ex) {
            resultado = "Erro ao consultar filmes e gêneros: " + ex.getMessage();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                resultado = "Erro ao fechar conexão: " + ex.getMessage();
            }
        }
        return resultado;
    }
}


