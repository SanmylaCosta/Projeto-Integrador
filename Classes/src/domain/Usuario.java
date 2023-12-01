package domain;

import java.util.Date;

public class Usuario {

    
    private Integer cod_usuario;
    private String nome_usuario;
    private String login;
    private char senha;
    private Date data_N;
    private String email;
    private char tel_usuario;
    
    

    public Usuario(Integer cod_usuario, String nome_usuario, String login, char senha, Date data_N, String email,
            char tel_usuario) {
        this.cod_usuario = cod_usuario;
        this.nome_usuario = nome_usuario;
        this.login = login;
        this.senha = senha;
        this.data_N = data_N;
        this.email = email;
        this.tel_usuario = tel_usuario;
    }


    public Integer getCod_usuario() {
        return cod_usuario;
    }


    public void setCod_usuario(Integer cod_usuario) {
        this.cod_usuario = cod_usuario;
    }


    public String getNome_usuario() {
        return nome_usuario;
    }


    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }


    public String getLogin() {
        return login;
    }


    public void setLogin(String login) {
        this.login = login;
    }


    public char getSenha() {
        return senha;
    }


    public void setSenha(char senha) {
        this.senha = senha;
    }


    public Date getData_N() {
        return data_N;
    }


    public void setData_N(Date data_N) {
        this.data_N = data_N;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public char getTel_usuario() {
        return tel_usuario;
    }


    public void setTel_usuario(char tel_usuario) {
        this.tel_usuario = tel_usuario;
    }


    @Override
    public String toString() {
        return "Usuario [cod_usuario=" + cod_usuario + ", nome_usuario=" + nome_usuario + ", login=" + login
                + ", senha=" + senha + ", data_N=" + data_N + ", email=" + email + ", tel_usuario=" + tel_usuario + "]";
    }


}
