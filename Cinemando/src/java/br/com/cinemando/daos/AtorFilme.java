package br.com.cinemando.daos;



public class AtorFilme {

    private Integer atorFilmeCod;
    private Filme filme;
    private Ator ator;
    
    @Override
    public String toString() {
        return "Ator_filme [atorFilmeCod=" + atorFilmeCod + ", filme=" + filme + ", ator=" + ator + "]";
    }


    public AtorFilme(Integer atorFilmeCod, Filme filme, Ator ator) {
        this.atorFilmeCod = atorFilmeCod;
        this.filme = filme;
        this.ator = ator;
    }

    public Integer getatorFilmeCod() {
        return atorFilmeCod;
    }

    public void setatorFilmeCod(Integer atorFilmeCod) {
        this.atorFilmeCod = atorFilmeCod;
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

   

    

}