/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;

import dao.DoadorDAO;
import dao.InstituicaoDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import negocio.Doacao;
import negocio.Doador;
import negocio.Instituicao;
import negocio.MaterialDoacao;
import negocio.StatusEnum;

/**
 *
 * @author Penguin
 */
@ManagedBean(name = "bDoacao")
@RequestScoped
    public class DoacaoBuilder {
    private int codigo = gerarNum();
     private Doador doador;
     private String cpf;
    private Instituicao instituicao;
    private String cnpj;
    //private MaterialDoacao materialDoacao;
    private String status = "Em andamento";
    private Date dataDoacao;
    private String dDoacao;
    private Date dataVisita;
    private String dVisita;
    private List<MaterialDoacao> doacao;

    public String getdDoacao() {
        return dDoacao;
    }
    
     public int gerarNum(){
        return (int)(Math.random()*100);
    }

    public void setdDoacao(String dDoacao) {
        this.dDoacao = dDoacao;
    }

    public String getdVisita() {
        return dVisita;
    }

    public void setdVisita(String dVisita) {
        this.dVisita = dVisita;
    }

    
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
   
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public Doacao build(Doador d, Instituicao i) throws ClassNotFoundException{
        int year1, month1, day1, year, month, day;
        year = Integer.parseInt(dDoacao.substring(4, 8)) - 1900;
        month = Integer.parseInt(dDoacao.substring(2,4)) - 1;
        day = Integer.parseInt(dDoacao.substring(0,2));
        
        year1 = Integer.parseInt(dVisita.substring(4, 8)) - 1900;
        month1 = Integer.parseInt(dVisita.substring(2,4)) - 1;
        day1 = Integer.parseInt(dVisita.substring(0,2));
        
        return new Doacao(codigo,DoadorDAO.getInstance().recuperar(d.getCpf()), InstituicaoDAO.getInstance().recuperar(i.getCnpj()), status, new Date(year, month, day), new Date(year1, month1, day1));
    }
}
