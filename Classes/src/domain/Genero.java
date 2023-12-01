package domain;

public class Genero {

    private Integer cod_genero;
    private String nome_genero;
    private String descricao;

    
    public Genero(Integer cod_genero, String nome_genero, String descricao) {
        this.cod_genero = cod_genero;
        this.nome_genero = nome_genero;
        this.descricao = descricao;
    }


    public Integer getCod_genero() {
        return cod_genero;
    }


    public void setCod_genero(Integer cod_genero) {
        this.cod_genero = cod_genero;
    }


    public String getNome_genero() {
        return nome_genero;
    }


    public void setNome_genero(String nome_genero) {
        this.nome_genero = nome_genero;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public String toString() {
        return "Genero [cod_genero=" + cod_genero + ", nome_genero=" + nome_genero + ", descricao=" + descricao + "]";
    }


    
}
