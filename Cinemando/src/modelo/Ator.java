package modelo;

public class Ator {
    
    private Integer  atorCod;
    private String atorNome;
    private String atorDataN;

    public Ator() {
    }
    
    public Integer getAtorCod() {
        return  atorCod;
    }
    
    public void setAtorCod(Integer atorCod) {
        this.atorCod = atorCod;
    }
    
    public String getAtorNome() {
        return atorNome;
    }
    
    public void setAtorNome(String atorNome) {
        this.atorNome = atorNome;
    }
    
    public String getAtorDataN() {
        return atorDataN;
    }
    
    public void setAtorDataN(String atorDataN) {
        this.atorDataN = atorDataN;
    }
   
    public Ator(Integer atorCod, String atorNome,String atorDataN) {
        this.atorCod = atorCod;
        this.atorNome = atorNome;
        this.atorDataN = atorDataN;
        
    }

   
    
    
}
