/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import negocio.Doacao;
import negocio.Doador;
import negocio.Instituicao;
import negocio.MaterialDoacao;
import negocio.StatusEnum;

/**
 *
 * @author Penguin
 */
public class DoacaoBuilder {
    private int codigo;
     private Doador doador;
    private Instituicao instituicao;
    //private MaterialDoacao materialDoacao;
    private StatusEnum status;
    private Date dataDoacao;
    private Date dataVisita;
    private List<MaterialDoacao> doacao;
    
   
    /*
    public MaterialDoacao getMaterialDoacao() {
        return materialDoacao;
    }

    public void setMaterialDoacao(MaterialDoacao materialDoacao) {
        this.materialDoacao = materialDoacao;
    }
    */
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

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
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

    public Doacao build(){
        return new Doacao(codigo,doador, instituicao, status, dataDoacao, dataVisita);
    }
}
