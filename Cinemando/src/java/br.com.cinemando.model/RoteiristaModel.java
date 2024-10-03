package br.com.cinemando;

import java.sql.*;
import java.util.ArrayList;
import conexao.ConexaoMySQL;

import br.com.cinemando.daos.*;
import java.util.Scanner;

public class RoteiristaModel {
    
    public static void main(String[] args){
        
        Scanner s = new Scanner(System.in);
        RoteiristaModel teste = new RoteiristaModel();
        Roteirista ins = new Roteirisa();
        
        System.out.println("Para Inserir(1)--- Consultar(2) -- Sair(0)");
        int escolha = s.nextInt();
        
        while(escolha != 0){
            if(escolha == 1){
                System.out.println("Digite os dados do Roteirista ");
                System.out.print("Digite o nome: ");
                ins.setRotNome(s.next());
                System.out.print("Digite a data de nascimento: ");
                ins.setRotDataN(s.next());
                String inserindo = teste.InserirRoteirista(ins);
                System.out.println("Retorno: " + inserindo);
            }

            else if(escolha == 2){
                Roteirista roteiristaConsultar = new Roteirista();
                System.out.print("Digite o nome do roteirista que voce deseja consultar: ");
                roteiristaConsultar.setRotNome(s.nextLine());
                String consulta = teste.ConsultarRoteirista(roteiristaConsultar);
                System.out.println(consulta);
            }
            
            System.out.println("Para Inserir(1)--- Consultar(2) -- Sair(0)");
            escolha = s.nextInt();
            s.nextLine();
        }
        
    }
    
    public String InserirRoteirista(Roteirista roteirista) {
    ConexaoMySQL conexao = new ConexaoMySQL();
    Connection conn = conexao.conectar();
    String resultado = "";
    try {
        // Comando SQL para inserção
        String consulta = "INSERT INTO roteirista (rotNome, rotDataN) VALUES (?,?)";

        PreparedStatement stm = conn.prepareStatement(consulta);
        stm.setString(1, roteirista.getRotNome());
        stm.setString(2, roteirista.getRotDataN());

        int rowsAffected = stm.executeUpdate();
        if (rowsAffected > 0) {
            resultado = "Roteirista inserido com sucesso!";
        } else {
            resultado = "Falha na inserção do roteirista.";
        }
    } catch (SQLException ex) {
        // Imprime mensagem de erro completa
        System.out.println("Erro ao inserir roteirista: " + ex.getMessage());
        resultado = "Erro: " + ex.getMessage();
    } finally {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close(); // Fecha a conexão
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar conexão: " + ex.getMessage());
        }
    }
    return resultado;
}

    
    public String ConsultarRoteirista(Roteirista roteirista){
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "SELECT * FROM Roteirista WHERE rotNome LIKE ?";
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, roteirista.getRotNome());

            ResultSet rs = stm.executeQuery();//executa a consulta preparada e recupera os resultados.

            if (rs.next()) {
                // Se encontrar resultados, monta uma string com os dados consultados
                StringBuilder sb = new StringBuilder();//recuperação de dados
                sb.append("Roteirista encontrado:\n");
                sb.append("Nome: ").append(rs.getString("rotNome")).append("\n");
                sb.append("Data de Nascimento: ").append(rs.getString("rotDataN")).append("\n");
               
                resultado = sb.toString();
            } else {
                resultado = "Roteirista não encontrado";
            }

        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            resultado = "erro";
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