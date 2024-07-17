package modelo;

public class GeneroFilme {
    private int genFilmeCod;
    private Filme filme;
    private Genero genero;
    @Override
    public String toString() {
        return "GeneroFilme [genFilmeCod=" + genFilmeCod + ", filme=" + filme + ", genero=" + genero + "]";
    }
    public GeneroFilme(int genFilmeCod, Filme filme, Genero genero) {
        this.genFilmeCod = genFilmeCod;
        this.filme = filme;
        this.genero = genero;
    }
    public int getGenFilmeCod() {
        return genFilmeCod;
    }
    public void setGenFilmeCod(int genFilmeCod) {
        this.genFilmeCod = genFilmeCod;
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

    
}
