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
@Entity
@Table
public class MaterialDoacao {
    @Column(length = 5)
    @Id
    private int codigo;
    @Enumerated(EnumType.STRING)
    private PrioridadeEnum prioridade;
    @OneToOne
    @JoinColumn(name = "insumo_id")
    private Insumo insumo;
    
    public MaterialDoacao(PrioridadeEnum prioridade, Insumo insumo){
        this.prioridade = prioridade;
        this.insumo = insumo;
    }

    @Deprecated
    public MaterialDoacao(){
        
    }
    
    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    
    public PrioridadeEnum getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(PrioridadeEnum prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "MaterialDoacao{" + "prioridade=" + prioridade + ", insumo=" + insumo + '}';
    }
    
    
    
}
