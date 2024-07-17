package modelo;

public class Filme {

  private Integer filmeCod;
  private String filmeNome;
  private String filmeClaIndic;
  private String filmeSinopse;
  private String filmeDataL;
  private String filmeProdu;
  private String filmeTrailer;
 

  public Filme() {
  }

  public Integer getFilmeCod() {
    return filmeCod;
  }

  public void setFilmeCod(Integer filmeCod) {
    this.filmeCod = filmeCod;
  }

  public String getFilmeNome() {
    return filmeNome;
  }

  public void setFilmeNome(String filmeNome) {
    this.filmeNome = filmeNome;
  }

  public String getFilmeClaIndic() {
    return filmeClaIndic;
  }

  public void setFilmeClaIndic(String filmeClaIndic) {
    this.filmeClaIndic = filmeClaIndic;
  }

  public String getFilmeSinopse() {
    return filmeSinopse;
  }

  public void setFilmeSinopse(String filmeSinopse) {
    this.filmeSinopse = filmeSinopse;
  }

  public String getFilmeDataL() {
    return filmeDataL;
  }

  public void setFilmeDataL(String filmeDataL) {
    this.filmeDataL = filmeDataL;
  }

  public String getFilmeProdu() {
    return filmeProdu;
  }

  public void setFilmeProdu(String filmeProdu) {
    this.filmeProdu = filmeProdu;
  }

  public String getFilmeTrailer() {
    return filmeTrailer;
  }

  public void setFilmeTrailer(String filmeTrailer) {
    this.filmeTrailer = filmeTrailer;
  }


  public Filme(Integer filmeCod, String filmeNome, String filmeClaIndic, String filmeSinopse, String filmeDataL,
      String filmeProdu, String filmeTrailer) {
    this.filmeCod = filmeCod;
    this.filmeNome = filmeNome;
    this.filmeClaIndic = filmeClaIndic;
    this.filmeSinopse = filmeSinopse;
    this.filmeDataL = filmeDataL;
    this.filmeProdu = filmeProdu;
    this.filmeTrailer = filmeTrailer;

  }
  

}
