package modelo;
import modelo.Usuario;
import modelo.Filme;
public class Avaliacao {

    private Integer avaliCod;
    private Integer avaliNota;
    private String avaliData;
    private Usuario usuario; 
    private Filme filme;
      
    public Avaliacao() {
    }
    
    public Integer getAvaliCod() {
        return avaliCod;
    }
    public void setAvaliCod(Integer avaliCod) {
        this.avaliCod = avaliCod;
    }
    public Integer getAvaliNota() {
        return avaliNota;
    }
    public void setAvaliNota(Integer avaliNota) {
        this.avaliNota = avaliNota;
    }
    public String getAvaliData() {
        return avaliData;
    }
    public void setAvaliData(String avaliData) {
        this.avaliData = avaliData;
    }
     public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Filme getfilme() {
        return filme;
    }
    public void setfilme(Filme filme) {
        this.filme = filme;
    }
    
    public Avaliacao(Integer avaliCod, Integer avaliNota, String avaliData, Usuario usuario, Filme filme) {
        this.avaliCod = avaliCod;
        this.avaliNota = avaliNota;
        this.avaliData = avaliData;
        this.usuario = usuario;
        this.filme = filme;
    }

   
    
    
}
