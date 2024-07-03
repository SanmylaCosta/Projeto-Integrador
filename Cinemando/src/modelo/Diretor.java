package domain;

import java.util.Date;

public class Diretor {


  private Integer cod_diretor;
    private String nome_diretor;
    private Date data_N_D;  

    public Integer getCod_diretor() {
        return cod_diretor;
    }
    public void setCod_diretor(Integer cod_diretor) {
        this.cod_diretor = cod_diretor;
    }
    public String getNome_diretor() {
        return nome_diretor;
    }
    public void setNome_diretor(String nome_diretor) {
        this.nome_diretor = nome_diretor;
    }
    public Date getData_N_D() {
        return data_N_D;
    }
    public void setData_N_D(Date data_N_D) {
        this.data_N_D = data_N_D;
    }
    @Override
    public String toString() {
        return "Diretor [cod_diretor=" + cod_diretor + ", nome_diretor=" + nome_diretor + ", data_N_D=" + data_N_D
                + "]";
    }

    
}
