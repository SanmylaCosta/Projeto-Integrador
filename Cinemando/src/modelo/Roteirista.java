package modelo;


public class Roteirista {

    private int rotCod;
    private String rotNome;
    private String rotDataN;

    public Roteirista(int rotCod, String rotNome, String rotDataN) {
        this.rotCod = rotCod;
        this.rotNome = rotNome;
        this.rotDataN = rotDataN;
    }

    public int getRotCod() {
        return rotCod;
    }
    public void setRotCod(int rotCod) {
        this.rotCod = rotCod;
    }
    public String getRotNome() {
        return rotNome;
    }
    public void setRotNome(String rotNome) {
        this.rotNome = rotNome;
    }
    public String getRotDataN() {
        return rotDataN;
    }
    public void setRotDataN(String rotDataN) {
        this.rotDataN = rotDataN;
    }
    @Override
    public String toString() {
        return "Roteirista [rotCod=" + rotCod + ", rotNome=" + rotNome + ", rotDataN="
                + rotDataN + "]";
    }

    
}
