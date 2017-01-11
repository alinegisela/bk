/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import negocio.Instituicao;
import negocio.Visita;
import repositorios.InstituicaoRepositorio;
import repositorios.RepositorioGenerico;
import repositorios.VisitaRepositorio;

/**
 *
 * @author Penguin
 */
@ManagedBean(name="cVisita")
@SessionScoped
public class VisitaControlador {
    private RepositorioGenerico<Visita> visitaRepositorio = null;
    private Visita visitaSelecionada;
    
    public VisitaControlador(){
        this.visitaRepositorio = new VisitaRepositorio();
    }

    public RepositorioGenerico<Visita> getVisitaRepositorio() {
        return visitaRepositorio;
    }

    public void setVisitaRepositorio(RepositorioGenerico<Visita> visitaRepositorio) {
        this.visitaRepositorio = visitaRepositorio;
    }

    public Visita getvisitaSelecionada() {
        return visitaSelecionada;
    }

    public void setVisitaSelecionada(Visita visitaSelecionad) {
        this.visitaSelecionada = visitaSelecionada;
    }
    
    public void inserir(Visita d){
        this.visitaRepositorio.inserir(d);
        
         FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("Cadastro concluído com sucesso!"));
        
        //return "ApresentaAnimal.xhtml";
    }
    
    public void alterar(Visita d){
        this.visitaRepositorio.alterar(d);
        
        FacesContext.getCurrentInstance().addMessage(null, 
                 new FacesMessage("Sucessoo animal " + d.getCodigo() + " foi alterado com sucesso!!"));
         
       
        
       // return "ApresentaAnimal.xhtml";
    }
    
    public Visita recuperar(int codigo){
        return this.visitaRepositorio.recuperar(codigo);
    }
    
    public void deletar(Visita d){
        this.visitaRepositorio.excluir(d);
    }
    
    public List<Visita> recuperarTodos(){
        return this.visitaRepositorio.recuperarTodos();
    }
}
