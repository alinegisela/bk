/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Penguin
 */
@Entity
@Table
public class Doacao {

    @Id
    @GeneratedValue
    private int codigo;
    @OneToOne
    @JoinColumn(name = "doador_id")
    private Doador doador;
    @OneToOne
    @JoinColumn(name = "instituicao_id")
    private Instituicao instituicao;
    @Enumerated(EnumType.STRING)
    private Enum status;
    @Temporal(value=TemporalType.DATE)
    private Date dataDoacao;
    @Temporal(value=TemporalType.DATE)
    private Date dataVisita;
    @OneToMany
    @JoinColumn(name = "material_doacao_id")
    private List<MaterialDoacao> doacao;

    public Doacao(int codigo, Doador doador, Instituicao instituicao,/*MaterialDoacao materialDoacao, */ Enum status, Date dataDoacao, Date dataVisita) {
        this.codigo = codigo;
        this.doador = doador;
        this.instituicao = instituicao;
        //this.materialDoacao = materialDoacao;
        this.status = status;
        this.dataDoacao = dataDoacao;
        this.dataVisita = dataVisita;
        this.doacao = new ArrayList<>();
    }
    
    @Deprecated
    public Doacao(){
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public Date getDataDoacao() {
        return dataDoacao;
    }

    public void setDataDoacao(Date dataDoacao) {
        this.dataDoacao = dataDoacao;
    }

    public Date getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(Date dataVisita) {
        this.dataVisita = dataVisita;
    }

    public List<MaterialDoacao> getDoacao() {
        return doacao;
    }

    public void setDoacao(List<MaterialDoacao> doacao) {
        this.doacao = doacao;
    }

    @Override
    public String toString() {
        return "Doacao{" + "código=" + codigo + "doador=" + doador + ", instituicao=" + instituicao + ", status=" + status + ", dataDoacao=" + dataDoacao + ", dataVisita=" + dataVisita + ", doacao=" + doacao + '}';
    }

}
