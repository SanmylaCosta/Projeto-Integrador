package br.com.cinemando.daos;



import br.com.cinemando.*;

public class DiretorFilme {
    private int dirFilmeCod;
    private Diretor diretor;
    private Filme filme;
    @Override
    public String toString() {
        return "DiretorFilme [dirFilmeCod=" + dirFilmeCod + ", diretor=" + diretor + ", filme=" + filme + "]";
    }
    
    public DiretorFilme(int dirFilmeCod, Diretor diretor, Filme filme) {
        this.dirFilmeCod = dirFilmeCod;
        this.diretor = diretor;
        this.filme = filme;
    }

    public int getDirFilmeCod() {
        return dirFilmeCod;
    }
    public void setDirFilmeCod(int dirFilmeCod) {
        this.dirFilmeCod = dirFilmeCod;
    }
    public Diretor getDiretor() {
        return diretor;
    }
    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }
    public Filme getFilme() {
        return filme;
    }
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    
}
