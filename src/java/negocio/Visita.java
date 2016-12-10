/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Date;

/**
 *
 * @author Cristiane
 */
public class Visita {
    private int codigo;
    private Instituicao instituicao;
    private Enum status;
    private Date data_da_visita;
    private String horario;

    public Visita(int codigo,Instituicao instituicao, Enum status, Date data_da_visita, String horario) {
        this.codigo = codigo;
        this.instituicao = instituicao;
        this.status = status;
        this.data_da_visita = data_da_visita;
        this.horario = horario;
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

    public void setStatus(Enum status) {
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
