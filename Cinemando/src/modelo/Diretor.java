package modelo;

public class Diretor {

    private Integer dirCod;
    private String dirNome;
    private String dirDataN;

    public Diretor(Integer dirCod, String dirNome, String dirDataN) {
        this.dirCod = dirCod;
        this.dirNome = dirNome;
        this.dirDataN = dirDataN;
    }

    public Diretor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    public Integer getDirCod() {
        return dirCod;
    }
    public void setDirCod(Integer dirCod) {
        this.dirCod = dirCod;
    }
    public String getDirNome() {
        return dirNome;
    }
    public void setDirNome(String dirNome) {
        this.dirNome = dirNome;
    }
    public String getDirDataN() {
        return dirDataN;
    }
    public void setDirDataN(String dirDataN) {
        this.dirDataN = dirDataN;
    
}
    }
