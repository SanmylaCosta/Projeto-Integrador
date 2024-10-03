package br.com.cinemando;

import java.sql.*;
import java.util.Scanner;
import conexao.ConexaoMySQL;
import br.com.cinemando.daos.*;

public class GeneroModel {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        GeneroModel teste = new GeneroModel();

        System.out.println("Para Inserir(1) --- Apagar(2) --- Consultar(3) -- Sair(0)");
        int escolha = s.nextInt();
        while (escolha != 0) {
            if (escolha == 1) {
                System.out.println("Digite os dados do Genero ");
                System.out.print("Digite o nome: ");
                String nome = s.next();
                System.out.print("Digite a descricao: ");
                String descricao = s.next();
                Genero ins = new Genero(null, nome, descricao); // Passando os argumentos necessários
                String inserindo = teste.InserirGenero(ins);
                System.out.println("Retorno: " + inserindo);
            } else if (escolha == 2) {
                System.out.print("Digite o genero que voce deseja apagar: ");
                String nome = s.next();
                Genero generoApagar = new Genero(null, nome, null); // Passando os argumentos necessários
                String apagando = teste.ApagarGenero(generoApagar);
                System.out.println("Retorno: " + apagando);
            } else if (escolha == 3) {
                System.out.print("Digite o nome do genero que voce deseja consultar: ");
                String nome = s.next();
                Genero generoConsultar = new Genero(null, nome, null); // Passando os argumentos necessários
                String consulta = teste.ConsultarGenero(generoConsultar);
                System.out.println(consulta);
            }

            System.out.println("Para Inserir(1) --- Apagar(2) --- Consultar(3) -- Sair(0)");
            escolha = s.nextInt();
        }

        s.close();
    }

    public String InserirGenero(Genero genero) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "INSERT INTO genero (genNome, descricao) VALUES (?,?)";
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, genero.getGenNome());
            stm.setString(2, genero.getDescricao());
            stm.executeUpdate();
            resultado = "Inserido com sucesso";
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            resultado = "erro: " + ex.getMessage();
        } finally {
            try {
                conn.close(); // Fecha a conexão com o banco de dados
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão: " + ex.getMessage());
            }
        }
        return resultado;
    }

    public String ApagarGenero(Genero genero) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "DELETE FROM genero WHERE genNome LIKE ?";
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, genero.getGenNome());
            stm.executeUpdate();
            resultado = "Apagado com sucesso";
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            resultado = "erro: " + ex.getMessage();
        } finally {
            try {
                conn.close(); // Fecha a conexão com o banco de dados
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão: " + ex.getMessage());
            }
        }
        return resultado;
    }

    public String ConsultarGenero(Genero genero) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "SELECT * FROM genero WHERE genNome LIKE ?";
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, genero.getGenNome());

            ResultSet rs = stm.executeQuery(); // executa a consulta preparada e recupera os resultados.

            if (rs.next()) {
                // Se encontrar resultados, monta uma string com os dados consultados
                StringBuilder sb = new StringBuilder(); // recuperação de dados
                sb.append("Genero encontrado:\n");
                sb.append("Nome: ").append(rs.getString("genNome")).append("\n");
                sb.append("Descricao: ").append(rs.getString("descricao")).append("\n");

                resultado = sb.toString();
            } else {
                resultado = "Genero não encontrado";
            }
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            resultado = "erro: " + ex.getMessage();
        } finally {
            try {
                conn.close(); // Fecha a conexão com o banco de dados
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão: " + ex.getMessage());
            }
        }
        return resultado;
    }
}
