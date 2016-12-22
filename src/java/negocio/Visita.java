/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Cristiane
 */
@Table
@Entity
public class Visita {
    @Id
    @Column(length=5)
    private int codigo;
    @OneToOne
    @JoinColumn(name = "doador_id")
    private Doador doador;
    @OneToOne
    @JoinColumn(name = "instituicao_id")
    private Instituicao instituicao;
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    @Temporal(value=TemporalType.DATE)
    private Date data_da_visita;
    @Column(length=5)
    private String horario;

    public Visita(int codigo, Doador doador, Instituicao instituicao, StatusEnum status, Date data_da_visita, String horario) {
        this.doador = doador;
        this.codigo = codigo;
        this.instituicao = instituicao;
        this.status = status;
        this.data_da_visita = data_da_visita;
        this.horario = horario;
    }
    
    @Deprecated
    public Visita(){
        
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }

    public int getCodigo() {
        return codigo;
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

    public Enum getStatus() {
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

    @Override
    public String toString() {
        return "Visita{" + "codigo"+codigo + "instituicao=" + instituicao + ", status=" + status + ", data_da_visita=" + data_da_visita + ", horario=" + horario + '}';
    }
    
    
    
}
