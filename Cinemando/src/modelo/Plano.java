package domain;

public class Plano {
    private Integer cod_plano;
    private String nome_plano;


    
    public Plano(Integer cod_plano, String nome_plano) {
        this.cod_plano = cod_plano;
        this.nome_plano = nome_plano;
    }
    
    public Integer getCod_plano() {
        return cod_plano;
    }

    public void setCod_plano(Integer cod_plano) {
        this.cod_plano = cod_plano;
    }
    public String getNome_plano() {
        return nome_plano;
    }
    public void setNome_plano(String nome_plano) {
        this.nome_plano = nome_plano;
    }

    @Override
    public String toString() {
        return "Plano [cod_plano=" + cod_plano + ", nome_plano=" + nome_plano + "]";
    }

    
}
