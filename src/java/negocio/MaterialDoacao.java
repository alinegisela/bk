/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Penguin
 */

public class MaterialDoacao {
    private int codigo;
    private boolean prioridade = false;
    private String prioridadeString;
    private Insumo insumo;
    
    public MaterialDoacao(int codigo, String prioridade, Insumo insumo){
        this.codigo = codigo;
        this.prioridadeString = prioridade;
        this.insumo = insumo;
    }

    public String getPrioridadeString() {
        if(prioridade){
            setPrioridadeString("não");
        }else{
            setPrioridadeString("sim");
        }
        return prioridadeString;
    }

    public void setPrioridadeString(String prioridadeString) {
        this.prioridadeString = prioridadeString;
    }

    
    
    @Deprecated
    public MaterialDoacao(){
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    
    public boolean getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(boolean prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "MaterialDoacao{" + "prioridade=" + prioridade + ", insumo=" + insumo + '}';
    }
    
    
    
}
