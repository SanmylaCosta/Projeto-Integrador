package br.com.cinemando;

import java.sql.*;
import java.util.Scanner;
import conexao.ConexaoMySQL;
import br.com.cinemando.daos.*;

public class DiretorModel {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        DiretorModel teste = new DiretorModel();

        System.out.println("Para Inserir(1) --- Apagar(2) --- Consultar(3) -- Sair(0)");
        int escolha = s.nextInt();
        while (escolha != 0) {
            if (escolha == 1) {
                System.out.println("Digite os dados do Diretor ");
                System.out.print("Digite o nome: ");
                String nome = s.next();
                System.out.print("Digite a data de nascimento: ");
                String dataN = s.next();
                Diretor ins = new Diretor(null, nome, dataN); // Passando os argumentos necessários
                String inserindo = teste.InserirDiretor(ins);
                System.out.println("Retorno: " + inserindo);
            } else if (escolha == 2) {
                System.out.print("Digite o diretor que voce deseja apagar: ");
                String nome = s.next();
                Diretor diretorApagar = new Diretor(null, nome, null); // Passando os argumentos necessários
                String apagando = teste.ApagarDiretor(diretorApagar);
                System.out.println("Retorno: " + apagando);
            } else if (escolha == 3) {
                System.out.print("Digite o nome do diretor que voce deseja consultar: ");
                String nome = s.next();
                Diretor diretorConsultar = new Diretor(null, nome, null); // Passando os argumentos necessários
                String consulta = teste.ConsultarDiretor(diretorConsultar);
                System.out.println(consulta);
            }

            System.out.println("Para Inserir(1) --- Apagar(2) --- Consultar(3) -- Sair(0)");
            escolha = s.nextInt();
        }
        
        s.close();
    }

    public String InserirDiretor(Diretor diretor) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "INSERT INTO Diretor (dirNome, dirDataN) VALUES (?,?)";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, diretor.getDirNome());
            stm.setString(2, diretor.getDirDataN());
            
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
    
    public String ApagarDiretor(Diretor diretor) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "DELETE FROM Diretor WHERE dirNome LIKE ?";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, diretor.getDirNome());
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
    
    public String ConsultarDiretor(Diretor diretor) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "SELECT * FROM Diretor WHERE dirNome LIKE ?";
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, diretor.getDirNome());

            ResultSet rs = stm.executeQuery(); // Executa a consulta preparada e recupera os resultados.

            if (rs.next()) {
                // Se encontrar resultados, monta uma string com os dados consultados
                StringBuilder sb = new StringBuilder(); // Recuperação de dados
                sb.append("Diretor encontrado:\n");
                sb.append("Nome: ").append(rs.getString("dirNome")).append("\n");
                sb.append("Data de Nascimento: ").append(rs.getString("dirDataN")).append("\n");
                
                resultado = sb.toString();
            } else {
                resultado = "Diretor não encontrado";
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
