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
    private boolean prioridade = false;
    private Insumo insumo;
    private int insumocodigo;
    private String prioridadeString;
    
    public int gerarNum(){
        return (int)(Math.random()*1000);
    }

    public int getInsumocodigo() {
        return insumocodigo;
    }

    public void setInsumocodigo(int insumocodigo) {
        this.insumocodigo = insumocodigo;
    }

    
    
    public int getCodigo() {
        return gerarNum();
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
    
    public String getPrioridadeString(boolean prioridade) {
        if(prioridade == true){
            setPrioridadeString("sim");
        }else{
            setPrioridadeString("não");
        }
        return prioridadeString;
    }
    
    public void setPrioridadeString(String prioridadeString) {
        this.prioridadeString = prioridadeString;
    }
    
    public MaterialDoacao build(int insumocodigo, boolean prioridade) throws ClassNotFoundException{
        System.out.println("Builder - prioridade ");
        System.out.println(prioridade?"SSSIMM":"NÃOOO");
        return new MaterialDoacao(this.getCodigo(), this.getPrioridadeString(prioridade), InsumoDAO.getInstance().recuperar(insumocodigo));
    }
}
