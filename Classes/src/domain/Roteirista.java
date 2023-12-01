package domain;

import java.util.Date;

public class Roteirista {

    private Integer  cod_roteirista;
    private String nome_roteirista;
    private Date data_N_R;

    public Roteirista(Integer cod_roteirista, String nome_roteirista, Date data_N_R) {
        this.cod_roteirista = cod_roteirista;
        this.nome_roteirista = nome_roteirista;
        this.data_N_R = data_N_R;
    }

    public Integer getCod_roteirista() {
        return cod_roteirista;
    }
    public void setCod_roteirista(Integer cod_roteirista) {
        this.cod_roteirista = cod_roteirista;
    }
    public String getNome_roteirista() {
        return nome_roteirista;
    }
    public void setNome_roteirista(String nome_roteirista) {
        this.nome_roteirista = nome_roteirista;
    }
    public Date getData_N_R() {
        return data_N_R;
    }
    public void setData_N_R(Date data_N_R) {
        this.data_N_R = data_N_R;
    }
    @Override
    public String toString() {
        return "Roteirista [cod_roteirista=" + cod_roteirista + ", nome_roteirista=" + nome_roteirista + ", data_N_R="
                + data_N_R + "]";
    }

    
}