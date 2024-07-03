package domain;



public class Ator_filme {

    private Integer cod_atorFilme;
    private Filme filme;
    private Ator ator;
    
    public Ator_filme(Integer cod_atorFilme, Filme filme, Ator ator) {
        this.cod_atorFilme = cod_atorFilme;
        this.filme = filme;
        this.ator = ator;
    }

    public Integer getCod_atorFilme() {
        return cod_atorFilme;
    }

    public void setCod_atorFilme(Integer cod_atorFilme) {
        this.cod_atorFilme = cod_atorFilme;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    @Override
    public String toString() {
        return "Ator_filme [cod_atorFilme=" + cod_atorFilme + ", filme=" + filme + ", ator=" + ator + "]";
    }

    

}
