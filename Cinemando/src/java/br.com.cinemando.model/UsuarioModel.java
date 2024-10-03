package br.com.cinemando.model;


import br.com.cinemando.daos.Usuario;
import java.sql.*;
import java.util.ArrayList;
import conexao.ConexaoMySQL;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.cinemando.daos.*;

import java.util.Scanner;

public class UsuarioModel {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        UsuarioModel teste = new UsuarioModel();
        ArrayList<Usuario> usu = teste.ConsultarUsuarios();
        teste.consultarUsuarios(usu);
        /*Usuario ins = new Usuario();

        System.out.println("Para Inserir(1) --- Apagar(2) --- Consultar(3) --- Consultar Todos(4) -- Alterar Senha(5) -- Sair(0)");
        int escolha = s.nextInt();
        while (escolha != 0) {
            if (escolha == 1) {
                System.out.println("Digite os dados do usuario ");
                System.out.print("Digite o nome: ");
                ins.setUsuNome(s.next());
                System.out.print("Digite o Login: ");
                ins.setUsuLogin(s.next());
                System.out.print("Digite o Senha: ");
                ins.setUsuSenha(s.next());
                System.out.print("Digite a Data de Nascimento: ");
                ins.setUsuDataN(s.next());
                System.out.print("Digite o Email: ");
                ins.setUsuEmail(s.next());
                System.out.print("Digite o Telefone (XXYYYYYYYYY): ");
                ins.setUsuTel(s.next());
                String inserindo = teste.InserirUsuario(ins);
                System.out.println("Retorno: " + inserindo);
            } else if (escolha == 2) {
                Usuario usuApagar = new Usuario();
                System.out.print("Digite o login que voce deseja apagar: ");
                usuApagar.setUsuLogin(s.next());
                String apagando = teste.ApagarUsuario(usuApagar);
                System.out.println("Retorno: " + apagando);
            } else if (escolha == 3) {
                Usuario usuConsultar = new Usuario();
                System.out.print("Digite o login que voce deseja consultar: ");
                usuConsultar.setUsuLogin(s.next());
                String consulta = teste.ConsultarUsuario(usuConsultar);
                System.out.println(consulta);
            } else if (escolha == 4) {
                String consultaTodos = teste.ConsultarUsuarios();
                System.out.println(consultaTodos);
            } else if (escolha == 5) {
                Usuario usuAlterar = new Usuario();
                System.out.print("Digite seu login:");
                usuAlterar.setUsuLogin(s.next());
                System.out.print("Digite a nova senha: ");
                usuAlterar.setUsuSenha(s.next());
                String alterar = teste.AlterarUsuario(usuAlterar);
                System.out.println(alterar);
            }
            System.out.println("Para Inserir(1) --- Apagar(2) --- Consultar(3) --- Consultar Todos(4) -- Alterar Senha(5) -- Sair(0)");
            escolha = s.nextInt();
        }*/
    }

    public String InserirUsuario(Usuario user) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "INSERT INTO usuario (usuNome, usuLogin, usuSenha, usuDataN, UsuEmail, UsuTel) VALUES (?,?,?,?,?,?)";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, user.getUsuNome());
            stm.setString(2, user.getUsuLogin());
            stm.setString(3, user.getUsuSenha());
            stm.setString(4, user.getUsuDataN());
            stm.setString(5, user.getUsuEmail());
            stm.setString(6, user.getUsuTel());

            stm.executeUpdate();
            resultado = "inserido";
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            resultado = "erro";
        }
        return resultado;
    }

    public String ApagarUsuario(Usuario user) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "DELETE FROM Usuario WHERE usuLogin LIKE ?";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, user.getUsuLogin());
            stm.executeUpdate();
            resultado = "Apagado com sucesso";
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            resultado = "erro";
        }
        return resultado;
    }

    public Usuario ConsultarUsuario(Usuario user) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        Usuario resultado = new Usuario();
        try {
            String consulta = "SELECT * FROM Usuario WHERE usuLogin LIKE ?";
            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, user.getUsuLogin());

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                StringBuilder sb = new StringBuilder();
                resultado.setUsuNome(rs.getString("usuNome"));
                resultado.setUsuLogin(rs.getString("usuLogin"));
                resultado.setUsuDataN(rs.getString("usuDataN"));
                resultado.setUsuSenha(rs.getString("usuSenha"));
                resultado.setUsuEmail(rs.getString("usuEmail"));
                resultado.setUsuTel(rs.getString("usuTel"));

                
            } else {
                System.out.println("Usuario nao encontrado");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar conexão: " + ex.getMessage());
            }
        }

        return resultado;
    }

    public  ArrayList<Usuario> ConsultarUsuarios() {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        ArrayList<Usuario> geral = new ArrayList<>();// lista que vai retornar todos os usuaros presentes no banco
        try {
            String consulta = "select * from usuario order by usuNome";
            Statement stm = conn.createStatement();
            ResultSet consultas = stm.executeQuery(consulta);
            
            while(consultas.next()) {
                Usuario usu = new Usuario();
                usu.setUsuCod(consultas.getInt("usuCod"));
                usu.setUsuLogin(consultas.getString("usuLogin"));
                usu.setUsuNome(consultas.getString("usuNome"));
                usu.setUsuSenha(consultas.getString("usuSenha"));
                usu.setUsuDataN(consultas.getString("usuDataN"));
                usu.setUsuTel(consultas.getString("usuTel"));
                usu.setUsuEmail(consultas.getString("usuEmail"));
                geral.add(usu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return geral;
    }

    public String AlterarUsuario(Usuario user) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "UPDATE Usuario SET usuSenha = ? WHERE usuLogin LIKE ?";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, user.getUsuSenha());
            stm.setString(2, user.getUsuLogin());
            stm.executeUpdate();
            resultado = "Senha alterada com sucesso";
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            resultado = "erro";
        }
        return resultado;
    }

    private void consultarUsuarios(ArrayList<Usuario> usu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
