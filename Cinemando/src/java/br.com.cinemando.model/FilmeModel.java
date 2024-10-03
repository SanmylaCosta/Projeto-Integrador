package br.com.cinemando;

import java.sql.*;
import conexao.ConexaoMySQL;
import br.com.cinemando.daos.*;
import java.util.Scanner;

public class FilmeModel {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        FilmeModel teste = new FilmeModel();
        Filme ins = new Filme();
        
        System.out.println("Para Inserir(1) --- Apagar(2) --- Consultar(3) -- Sair(0)");
        int escolha = s.nextInt();
        s.nextLine();  // Consumir a nova linha deixada pelo nextInt()
        while (escolha != 0) {
            if (escolha == 1) {
                System.out.println("Digite os dados do filme que deseja inserir:");
                System.out.print("Digite o nome do filme: ");
                ins.setFilmeNome(s.nextLine());
                System.out.print("Digite a classificacao indicativa do filme: ");
                ins.setFilmeClaIndic(s.nextLine());
                System.out.print("Digite a sinopse do filme: ");
                ins.setFilmeSinopse(s.nextLine());
                System.out.print("Digite a data de lancamento do filme: ");
                ins.setFilmeDataL(s.nextLine());
                System.out.print("Digite a produtora do filme: ");
                ins.setFilmeProdu(s.nextLine());
                System.out.print("Digite o link do trailer do filme: ");
                ins.setFilmeTrailer(s.nextLine());
                String inserindo = teste.inserirFilme(ins);
                System.out.println("Retorno: " + inserindo);
            } else if (escolha == 2) {
                Filme filmeApagar = new Filme();
                System.out.print("Digite o nome do filme que você deseja apagar: ");
                filmeApagar.setFilmeNome(s.nextLine());
                String apagando = teste.apagarFilme(filmeApagar);
                System.out.println("Retorno: " + apagando);
            } else if (escolha == 3) {
                Filme filmeConsultar = new Filme();
                System.out.print("Digite o nome do filme que você deseja consultar: ");
                filmeConsultar.setFilmeNome(s.nextLine());
                String consulta = teste.consultarFilme(filmeConsultar);
                System.out.println(consulta);
            }
            
            System.out.println("Para Inserir(1) --- Apagar(2) --- Consultar(3) -- Sair(0)");
            escolha = s.nextInt();
            s.nextLine();  // Consumir a nova linha deixada pelo nextInt()
        }
        s.close();
    }
    
    public String inserirFilme(Filme filme) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "INSERT INTO filme (filmeNome, filmeClaIndic, filmeSinopse, filmeDataL, filmeProdu, filmeTrailer) VALUES (?,?,?,?,?,?)";
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, filme.getFilmeNome());
            stm.setString(2, filme.getFilmeClaIndic());
            stm.setString(3, filme.getFilmeSinopse());
            stm.setString(4, filme.getFilmeDataL());
            stm.setString(5, filme.getFilmeProdu());
            stm.setString(6, filme.getFilmeTrailer());
            stm.executeUpdate();
            resultado = "Filme inserido com sucesso";
        } catch (SQLException ex) {
            System.out.println("Erro SQL: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("ErrorCode: " + ex.getErrorCode());
            resultado = "Erro ao inserir filme";
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão: " + ex.getMessage());
            }
        }
        return resultado;
    }
    
    public String apagarFilme(Filme filme) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "DELETE FROM filme WHERE filmeNome = ?";
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, filme.getFilmeNome());
            stm.executeUpdate();
            resultado = "Filme apagado com sucesso";
        } catch (SQLException ex) {
            System.out.println("Erro SQL: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("ErrorCode: " + ex.getErrorCode());
            resultado = "Erro ao apagar filme";
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão: " + ex.getMessage());
            }
        }
        return resultado;
    }
    
    public String consultarFilme(Filme filme) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "SELECT * FROM filme WHERE filmeNome = ?";
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, filme.getFilmeNome());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Filme encontrado:\n");
                sb.append("Nome: ").append(rs.getString("filmeNome")).append("\n");
                sb.append("Classificação indicativa: ").append(rs.getString("filmeClaIndic")).append("\n");
                sb.append("Sinopse: ").append(rs.getString("filmeSinopse")).append("\n");
                sb.append("Data de Lançamento: ").append(rs.getString("filmeDataL")).append("\n");
                sb.append("Produtora: ").append(rs.getString("filmeProdu")).append("\n");
                sb.append("Trailer: ").append(rs.getString("filmeTrailer")).append("\n");
                resultado = sb.toString();
            } else {
                resultado = "Filme não encontrado";
            }
        } catch (SQLException ex) {
            System.out.println("Erro SQL: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("ErrorCode: " + ex.getErrorCode());
            resultado = "Erro ao consultar filme";
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
