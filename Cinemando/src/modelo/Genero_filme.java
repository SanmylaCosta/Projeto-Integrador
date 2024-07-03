package domain;

public class Genero_filme {
    private int cod_generoFilme; 
    private Filme filme; 
    private Genero genero;

    public Genero_filme(int cod_generoFilme, Filme filme, Genero genero) {
        this.cod_generoFilme = cod_generoFilme;
        this.filme = filme;
        this.genero = genero;
    }

    public int getCod_generoFilme() {
        return cod_generoFilme;
    }

    public void setCod_generoFilme(int cod_generoFilme) {
        this.cod_generoFilme = cod_generoFilme;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Genero_filme [cod_generoFilme=" + cod_generoFilme + ", filme=" + filme + ", genero=" + genero + "]";
    } 

    
    
}
