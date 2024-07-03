package domain;

import java.util.Date;

public class Assinatura {
    private Integer cod_assinatura;
    private Integer duracao;
    private String forma_pgto; 
    private Date data_assinatura; 
    private Usuario usuario;
    private Plano plano;
    
    public Assinatura(Integer cod_assinatura, Integer duracao, String forma_pgto, Date data_assinatura, Usuario usuario,
            Plano plano) {
        this.cod_assinatura = cod_assinatura;
        this.duracao = duracao;
        this.forma_pgto = forma_pgto;
        this.data_assinatura = data_assinatura;
        this.usuario = usuario;
        this.plano = plano;
    }

    public Integer getCod_assinatura() {
        return cod_assinatura;
    }
    public void setCod_assinatura(Integer cod_assinatura) {
        this.cod_assinatura = cod_assinatura;
    }
    public Integer getDuracao() {
        return duracao;
    }
    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }
    public String getForma_pgto() {
        return forma_pgto;
    }
    public void setForma_pgto(String forma_pgto) {
        this.forma_pgto = forma_pgto;
    }
    public Date getData_assinatura() {
        return data_assinatura;
    }
    public void setData_assinatura(Date data_assinatura) {
        this.data_assinatura = data_assinatura;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Plano getPlano() {
        return plano;
    }
    public void setPlano(Plano plano) {
        this.plano = plano;
    }
    @Override
    public String toString() {
        return "Assinatura [cod_assinatura=" + cod_assinatura + ", duracao=" + duracao + ", forma_pgto=" + forma_pgto
                + ", data_assinatura=" + data_assinatura + ", usuario=" + usuario + ", plano=" + plano + "]";
    }

    
}
