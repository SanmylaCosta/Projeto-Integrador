package domain;

import java.util.Date;

public class Filme {
    private Integer codFilme;
    private String nomeFilme;
    private String classificacaoIndicativa;
    private String sinopse;
    private Date dataLancamento;
    private String produtora;
    private String linkTrailer;
    private Diretor diretor;


    public Filme(Integer codFilme, String nomeFilme, String classificacaoIndicativa, String sinopse, 
                 Date dataLancamento, String produtora, String linkTrailer, Diretor
             diretor) {
        this.codFilme = codFilme;
        this.nomeFilme = nomeFilme;
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.sinopse = sinopse;
        this.dataLancamento = dataLancamento;
        this.produtora = produtora;
        this.linkTrailer = linkTrailer;
        this.diretor = diretor;
    }


    public Integer getCodFilme() {
        return codFilme;
    }

    public void setCodFilme(Integer codFilme) {
        this.codFilme = codFilme;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(String classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public String getLinkTrailer() {
        return linkTrailer;
    }

    public void setLinkTrailer(String linkTrailer) {
        this.linkTrailer = linkTrailer;
    }

    public Diretor getDiretor() {
        return diretor;
    }

        public void setDiretor(Diretor diretor) {
            this.diretor = diretor;
        }
    
}
