/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;

import java.util.Date;
import negocio.Doador;
import negocio.Instituicao;
import negocio.StatusEnum;
import negocio.Visita;

/**
 *
 * @author Penguin
 */
public class VisitaBuilder {
    private int codigo;
    private Doador doador;
     private Instituicao instituicao;
    private StatusEnum status;
    private Date data_da_visita;
    private String horario;
    
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
    
    public Visita build(){
        return new Visita(codigo,doador, instituicao, status, data_da_visita, horario);
    }
}
