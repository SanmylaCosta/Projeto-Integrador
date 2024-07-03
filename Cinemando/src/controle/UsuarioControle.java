package controle;

import java.sql.*;
import java.util.ArrayList;
import conexao.ConexaoMySQL;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;
import java.util.Date;

public class UsuarioControle {
    
    public static void main(String[] args){
        UsuarioControle teste = new UsuarioControle();
        Usuario ins = new Usuario();
        ins.setUsuNome("Pulga");
        ins.setUsuLogin("Pulguinha");
        ins.setUsuSenha("pulgas123");
        ins.setUsuDataN("1990-03-30");
        ins.setUsuEmail("lindaPulguinha@gamil.com");
        ins.setUsuTel("34 9999999999");
        String res = teste.InserirUsuario(ins);
        System.out.println("Retorno: " + res);
        /*String aux = "Carpinha"
        String apaga = teste.ApagarUsuario(aux);*/
        //ArrayList<Usuario> usu = teste.consultarUsuario();
        //teste.imprimirUsuario(usu);
    }
    
    public String InserirUsuario(Usuario usuario) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "INSERT INTO usuario (usuNome, usuLogin, usuSenha, usuDataN,UsuEmail,UsuTel ) VALUES (?,?,?,?,?,?)";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, usuario.getUsuNome());
            stm.setString(2, usuario.getUsuLogin());
            stm.setString(3, usuario.getUsuSenha());
            stm.setString(4, usuario.getUsuDataN());
            stm.setString(5, usuario.getUsuEmail());
            stm.setString(6, usuario.getUsuTel());
            
            stm.executeUpdate();
            resultado = "inserido";
        } catch (SQLException ex) {
          System.out.println(ex.getSQLState());
          resultado = "erro";
        } 
        return resultado;
    }
    
    public String ApagarUsuario(Usuario usuario){
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "Delete from Usuario where usuLogin('?')";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, usuario.getUsuLogin());
            
            stm.executeUpdate();
            resultado = "Apagado com sucesso";
        } catch (SQLException ex) {
          System.out.println(ex.getSQLState());
          resultado = "erro";
        } 
        return resultado;
    }
    
  
    
    
}