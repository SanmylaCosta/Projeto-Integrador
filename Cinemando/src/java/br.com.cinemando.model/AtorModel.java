package br.com.cinemando;

import java.sql.*;
import java.util.ArrayList;
import conexao.ConexaoMySQL;
import br.com.cinemando.daos.*;
import java.util.Scanner;

public class AtorModel {
    
    public static void main(String[] args){
        
        Scanner s = new Scanner(System.in);
        AtorModel teste = new AtorModel();
        Ator ins = new Ator();
        
        System.out.println("Para Inserir(1) --- Apagar(2) --- Consultar(3) -- Sair(0)");
        int escolha = s.nextInt();
        
        while(escolha != 0){
            if(escolha == 1){
                System.out.println("Digite os dados do Ator ");
                System.out.print("Digite o nome: ");
                ins.setAtorNome(s.next());
                System.out.print("Digite a data de nascimento: ");
                ins.setAtorDataN(s.next());
                String inserindo = teste.InserirAtor(ins);
                System.out.println("Retorno: " + inserindo);
            }
            else if(escolha == 2){
                Ator atorApagar = new Ator();
                System.out.print("Digite o ator que voce deseja apagar: ");
                atorApagar.setAtorNome(s.next());
                String apagando = teste.ApagarAtor(atorApagar);
                System.out.println("Retorno: " + apagando);
            }

            else if(escolha == 3){
                Ator atorConsultar = new Ator();
                System.out.print("Digite o nome do ator que voce deseja consultar: ");
                atorConsultar.setAtorNome(s.nextLine());
                String consulta = teste.ConsultarAtor(atorConsultar);
                System.out.println(consulta);
            }
            
            System.out.println("Para Inserir(1) --- Apagar(2) --- Consultar(3) -- Sair(0)");
            escolha = s.nextInt();
            s.nextLine();
        }
        
    }
    
    public String InserirAtor(Ator ator) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "INSERT INTO ator (atorNome, atorDataN) VALUES (?,?)";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, ator.getAtorNome());
            stm.setString(2, ator.getAtorDataN());
            
            stm.executeUpdate();
            resultado = "inserido";
        } catch (SQLException ex) {
          System.out.println(ex.getSQLState());
          resultado = "erro";
        } 
        return resultado;
    }
    
    public String ApagarAtor(Ator ator){
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "DELETE FROM Ator WHERE atorNome LIKE ?";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, ator.getAtorNome());
            stm.executeUpdate();
            resultado = "Apagado com sucesso";
        } catch (SQLException ex) {
          System.out.println(ex.getSQLState());
          resultado = "erro";
        } 
        return resultado;
    }
    
    public String ConsultarAtor(Ator ator){
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "SELECT * FROM Ator WHERE atorNome LIKE ?";
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, ator.getAtorNome());

            ResultSet rs = stm.executeQuery();//executa a consulta preparada e recupera os resultados.

            if (rs.next()) {
                // Se encontrar resultados, monta uma string com os dados consultados
                StringBuilder sb = new StringBuilder();//recuperação de dados
                sb.append("Ator encontrado:\n");
                sb.append("Nome: ").append(rs.getString("atorNome")).append("\n");
                sb.append("Data de Nascimento: ").append(rs.getString("atorDataN")).append("\n");
               
                resultado = sb.toString();
            } else {
                resultado = "Ator não encontrado";
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
