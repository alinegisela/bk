/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Penguin
 */
public class MaterialDoacao {
    private PrioridadeEnum prioridade;
    private Insumo insumo;
    
    public MaterialDoacao(PrioridadeEnum prioridade, Insumo insumo){
        this.prioridade = prioridade;
        this.insumo = insumo;
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
