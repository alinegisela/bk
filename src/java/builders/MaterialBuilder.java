/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import negocio.Insumo;
import negocio.MaterialDoacao;
import negocio.PrioridadeEnum;

/**
 *
 * @author Penguin
 */
public class MaterialBuilder {
    private int codigo;
    private PrioridadeEnum prioridade;
    private Insumo insumo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public PrioridadeEnum getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(PrioridadeEnum prioridade) {
        this.prioridade = prioridade;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }
    
    public MaterialDoacao build(){
        return new MaterialDoacao(codigo, prioridade, insumo);
    }
}
