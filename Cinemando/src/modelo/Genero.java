package modelo;

public class Genero {

    private Integer genCod;
    private String genNome;
    private String descricao;

    public Genero(Integer genCod, String genNome, String descricao) {
        this.genCod = genCod;
        this.genNome = genNome;
        this.descricao = descricao;
    }

    public Integer getGenCod() {
        return genCod;
    }
    public void setRotCod(Integer genCod) {
        this.genCod = genCod;
    }
    public String getGenNome() {
        return genNome;
    }
    public void setGenNome(String genNome) {
        this.genNome = genNome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString() {
        return "Genero [genCod=" + genCod + ", genNome=" + genNome + ", descricao=" + descricao + "]";

    }
}
