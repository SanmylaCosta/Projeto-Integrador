package domain;

import java.util.Date;

public class Ator {

    private Integer cod_ator;
    private String nome_ator;
    private Date data_N_A;
    public Integer getCod_ator() {
        return cod_ator;
    }
    public void setCod_ator(Integer cod_ator) {
        this.cod_ator = cod_ator;
    }
    public String getNome_ator() {
        return nome_ator;
    }
    public void setNome_ator(String nome_ator) {
        this.nome_ator = nome_ator;
    }
    public Date getData_N_A() {
        return data_N_A;
    }
    public void setData_N_A(Date data_N_A) {
        this.data_N_A = data_N_A;
    }
    @Override
    public String toString() {
        return "Ator [cod_ator=" + cod_ator + ", nome_ator=" + nome_ator + ", data_N_A=" + data_N_A + "]";
    }

    
}
