package modelo;


public class Roteirista {

    private Integer rotCod;
    private String rotNome;
    private String rotDataN;

    public Roteirista(Integer rotCod, String rotNome, String rotDataN) {
        this.rotCod = rotCod;
        this.rotNome = rotNome;
        this.rotDataN = rotDataN;
    }

    public Integer getRotCod() {
        return rotCod;
    }
    public void setRotCod(Integer rotCod) {
        this.rotCod = rotCod;
    }
    public String getRotNome() {
        return rotNome;
    }
    public void setNome_roteirista(String rotNome) {
        this.rotNome = rotNome;
    }
    public String getrotDataN() {
        return rotDataN;
    }
    public void setrotDataN(String rotDataN) {
        this.rotDataN = rotDataN;
    }
    @Override
    public String toString() {
        return "Roteirista [rotCod=" + rotCod + ", rotNome=" + rotNome + ", rotDataN="
                + rotDataN + "]";
    }

    
}