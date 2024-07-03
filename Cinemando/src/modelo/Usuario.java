package modelo;

import java.util.Date;

public class Usuario {

    
    private Integer usuCod;
    private String usuNome;
    private String usuLogin;
    private String usuSenha;
    private String usuDataN;
    private String usuEmail;
    private String usuTel;

    public Usuario() {
    }
    
    public Integer getUsuCod() {
        return usuCod;
    }
    public void setUsuCod(Integer usuCod) {
        this.usuCod = usuCod;
    }
    public String getUsuNome() {
        return usuNome;
    }
    public void setUsuNome(String usuNome) {
        this.usuNome = usuNome;
    }
    public String getUsuLogin() {
        return usuLogin;
    }
    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }
    public String getUsuSenha() {
        return usuSenha;
    }
    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }
    public String getUsuDataN() {
        return usuDataN;
    }
    public void setUsuDataN(String usuDataN) {
        this.usuDataN = usuDataN;
    }
    public String getUsuEmail() {
        return usuEmail;
    }
    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }
    public String getUsuTel() {
        return usuTel;
    }
    public void setUsuTel(String usuTel) {
        this.usuTel = usuTel;
    }
    public Usuario(Integer usuCod, String usuNome, String usuLogin, String usuSenha, String usuDataN, String usuEmail,
            String usuTel) {
        this.usuCod = usuCod;
        this.usuNome = usuNome;
        this.usuLogin = usuLogin;
        this.usuSenha = usuSenha;
        this.usuDataN = usuDataN;
        this.usuEmail = usuEmail;
        this.usuTel = usuTel;
    }

   
    
    
}