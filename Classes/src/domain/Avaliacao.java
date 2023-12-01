package domain;

import java.util.Date;

public class Avaliacao {

    private Integer cod_avaliacao;
    private Integer nota;
    private Date data_avaliacao; 
    private Filme filme; 
    private Usuario usuario;
    
    public Avaliacao(Integer cod_avaliacao, Integer nota, Date data_avaliacao, Filme filme, Usuario usuario) {
        this.cod_avaliacao = cod_avaliacao;
        this.nota = nota;
        this.data_avaliacao = data_avaliacao;
        this.filme = filme;
        this.usuario = usuario;
    }

    public Integer getCod_avaliacao() {
        return cod_avaliacao;
    }

    public void setCod_avaliacao(Integer cod_avaliacao) {
        this.cod_avaliacao = cod_avaliacao;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Date getData_avaliacao() {
        return data_avaliacao;
    }

    public void setData_avaliacao(Date data_avaliacao) {
        this.data_avaliacao = data_avaliacao;
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
        return "Avaliacao [cod_avaliacao=" + cod_avaliacao + ", nota=" + nota + ", data_avaliacao=" + data_avaliacao
                + ", filme=" + filme + ", usuario=" + usuario + "]";
    } 

 
}
