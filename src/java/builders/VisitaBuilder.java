/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;

import dao.DoadorDAO;
import dao.InstituicaoDAO;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import negocio.Doador;
import negocio.Instituicao;
import negocio.StatusEnum;
import negocio.Visita;

/**
 *
 * @author Penguin
 */
@ManagedBean(name = "bVisita")
@RequestScoped
public class VisitaBuilder {
    private int codigo;
    private Doador doador;
    private String cpf;
     private Instituicao instituicao;
     private String cnpj;
    private StatusEnum status;
    private Date data_da_visita;
    private String data;
    private String horario;

    public String getData() {
        return data;
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
    
    

    public void setData(String data) {
        this.data = data;
    }
    
    
    
    public int getCodigo() {
        return codigo;
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public Date getData_da_visita() {
        return data_da_visita;
    }

    public void setData_da_visita(Date data_da_visita) {
        this.data_da_visita = data_da_visita;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    public Visita build() throws ClassNotFoundException{
        int year1, month1, day1;
        
        
        year1 = Integer.parseInt(data.substring(4, 8)) - 1900;
        month1 = Integer.parseInt(data.substring(2,4)) - 1;
        day1 = Integer.parseInt(data.substring(0,2));
        
        return new Visita(codigo,DoadorDAO.getInstance().recuperar(cpf), InstituicaoDAO.getInstance().recuperar(cnpj), status, new Date(year1,month1,day1), horario);
    }
}
