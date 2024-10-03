package br.com.cinemando.daos;



import br.com.cinemando.*;


public class RoteiristaFilme {
    private int rotFilmeCod;
    private Roteirista roteirista; 
    private Filme filme;

    @Override
    public String toString() {
        return "Roteirista_filme [rotFilmeCod=" + rotFilmeCod + ", roteirista=" + roteirista
                + ", filme=" + filme + "]";
    } 

    public RoteiristaFilme(int rotFilmeCod, Roteirista roteirista, Filme filme) {
        this.rotFilmeCod = rotFilmeCod;
        this.roteirista = roteirista;
        this.filme = filme;
    }
    public int getrotFilmeCod() {
        return rotFilmeCod;
    }
    public void setrotFilmeCod(int rotFilmeCod) {
        this.rotFilmeCod = rotFilmeCod;
    }
    public Roteirista getRoteirista() {
        return roteirista;
    }
    public void setRoteirista(Roteirista roteirista) {
        this.roteirista = roteirista;
    }
    public Filme getFilme() {
        return filme;
    }
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    
}
