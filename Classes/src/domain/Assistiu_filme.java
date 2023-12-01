package domain;

import java.util.Date;

public class Assistiu_filme {

    private Integer cod_assistiu;
    private Date data_assistiu;
    private Integer horario_A; 
    private Filme filme; 
    private Usuario usuario;
    
    public Assistiu_filme(Integer cod_assistiu, Date data_assistiu, Integer horario_A, Filme filme, Usuario usuario) {
        this.cod_assistiu = cod_assistiu;
        this.data_assistiu = data_assistiu;
        this.horario_A = horario_A;
        this.filme = filme;
        this.usuario = usuario;
    }

    public Integer getCod_assistiu() {
        return cod_assistiu;
    }

    public void setCod_assistiu(Integer cod_assistiu) {
        this.cod_assistiu = cod_assistiu;
    }

    public Date getData_assistiu() {
        return data_assistiu;
    }

    public void setData_assistiu(Date data_assistiu) {
        this.data_assistiu = data_assistiu;
    }

    public Integer getHorario_A() {
        return horario_A;
    }

    public void setHorario_A(Integer horario_A) {
        this.horario_A = horario_A;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Assistiu_filme [cod_assistiu=" + cod_assistiu + ", data_assistiu=" + data_assistiu + ", horario_A="
                + horario_A + ", filme=" + filme + ", usuario=" + usuario + "]";
    }

    
}
