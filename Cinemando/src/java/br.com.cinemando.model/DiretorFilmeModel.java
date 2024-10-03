package br.com.cinemando;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import br.com.cinemando.daos.*;
public class DiretorFilmeModel {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        DiretorFilmeModel controle = new DiretorFilmeModel();

        System.out.println("Inserir(1) -- Consultar Diretor de Filme(2) -- Consultar Todos Filmes e Diretores(3) -- Sair(0)");
        int escolha = s.nextInt();
        s.nextLine();  // Consumir o restante da linha

        while (escolha != 0) {
            if (escolha == 1) {
                System.out.print("Digite o nome do filme: ");
                String filmeNome = s.nextLine();
                System.out.print("Digite o nome do diretor: ");
                String dirNome = s.nextLine();

                String insercao = controle.inserirDiretorFilme(filmeNome, dirNome);
                System.out.println(insercao);
            } else if (escolha == 2) {
                System.out.print("Digite o nome do filme que você deseja consultar: ");
                String filmeNome = s.nextLine();

                String consulta = controle.consultarDiretorFilme(filmeNome);
                System.out.println(consulta);
            } else if (escolha == 3) {
                String consultaTodos = controle.consultarTodosFilmesEDiretores();
                System.out.println(consultaTodos);
            }

            System.out.println("Inserir(1) -- Consultar Diretor de Filme(2) -- Consultar Todos Filmes e Diretores(3) -- Sair(0)");
            escolha = s.nextInt();
            s.nextLine();  
        }
        s.close();
    }

    public String inserirDiretorFilme(String filmeNome, String dirNome) {
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

            
            String consultaDiretor = "SELECT dirCod FROM diretor WHERE dirNome = ?";
            PreparedStatement stmDiretor = conn.prepareStatement(consultaDiretor);
            stmDiretor.setString(1, dirNome);
            ResultSet rsDiretor = stmDiretor.executeQuery();

            if (!rsDiretor.next()) {
                return "Diretor não encontrado.";
            }

            int dirCod = rsDiretor.getInt("dirCod");

            // Inserir a relação entre filme e diretor
            String inserirRelacao = "INSERT INTO diretorfilme (filmeCod, dirCod) VALUES (?, ?)";
            PreparedStatement stmInserirRelacao = conn.prepareStatement(inserirRelacao);
            stmInserirRelacao.setInt(1, filmeCod);
            stmInserirRelacao.setInt(2, dirCod);
            int rowsAffected = stmInserirRelacao.executeUpdate();

            if (rowsAffected > 0) {
                resultado = "Relação entre filme e diretor inserida com sucesso!";
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

    public String consultarDiretorFilme(String filmeNome) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "SELECT d.dirNome " +
                              "FROM diretorfilme df " +
                              "JOIN filme f ON df.filmeCod = f.filmeCod " +
                              "JOIN diretor d ON df.dirCod = d.dirCod " +
                              "WHERE f.filmeNome = ?";
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, filmeNome);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Diretor(a) do filme '").append(filmeNome).append("':\n");
                do {
                    sb.append(rs.getString("dirNome")).append("\n");
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

    public String consultarTodosFilmesEDiretores() {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "SELECT f.filmeNome, GROUP_CONCAT(d.dirNome SEPARATOR ', ') AS diretores " +
                              "FROM filme f " +
                              "LEFT JOIN diretorfilme df ON f.filmeCod = df.filmeCod " +
                              "LEFT JOIN diretor d ON df.dirCod = d.dirCod " +
                              "GROUP BY f.filmeNome";
            PreparedStatement stm = conn.prepareStatement(consulta);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Filmes e seus Diretores:\n");
                do {
                    String filmeNome = rs.getString("filmeNome");
                    String diretores = rs.getString("diretores");
                    sb.append("Filme: ").append(filmeNome).append(" | Diretor(a): ").append(diretores != null ? diretores : "Nenhum").append("\n");
                } while (rs.next());

                resultado = sb.toString();
            } else {
                resultado = "Nenhum filme encontrado";
            }

        } catch (SQLException ex) {
            resultado = "Erro ao consultar filmes e diretores: " + ex.getMessage();
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
