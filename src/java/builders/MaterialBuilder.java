/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;

import dao.InsumoDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
@ManagedBean(name = "bMaterial")
@RequestScoped
public class MaterialBuilder {
    private int codigo;
    private PrioridadeEnum prioridade;
    private Insumo insumo;
    private int insumocodigo;

    public int getInsumocodigo() {
        return insumocodigo;
    }

    public void setInsumocodigo(int insumocodigo) {
        this.insumocodigo = insumocodigo;
    }

    
    
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
    
    public MaterialDoacao build() throws ClassNotFoundException{
        return new MaterialDoacao(codigo, prioridade, InsumoDAO.getInstance().recuperar(insumocodigo));
    }
}
