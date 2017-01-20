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
    private int codigo = gerarNum();
    private boolean prioridade;
    private Insumo insumo;
    private int insumocodigo;
    private String prioridadeString;
    
    public int gerarNum(){
        return (int)(Math.random()*100);
    }

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

    public boolean getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(boolean prioridade) {
        this.prioridade = prioridade;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
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
    
    public MaterialDoacao build(int insumocodigo) throws ClassNotFoundException{
        System.out.println("Builder");
        return new MaterialDoacao(this.getCodigo(), this.getPrioridadeString(), InsumoDAO.getInstance().recuperar(insumocodigo));
    }
}
