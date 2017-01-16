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
import negocio.Doacao;
import negocio.Doador;
import repositorios.DoacaoRepositorio;
import repositorios.DoadorRepositorio;
import repositorios.RepositorioGenerico;

/**
 *
 * @author Penguin
 */
@ManagedBean(name="cDoador")
@SessionScoped
public class DoadorControlador {
     private RepositorioGenerico<Doador> doadorRepositorio = null;
    private Doador doadorSelecionado;
    
    public DoadorControlador(){
        this.doadorRepositorio = new DoadorRepositorio();
    }

    public RepositorioGenerico<Doador> getDoadorRepositorio() {
        return doadorRepositorio;
    }

    public void setDoadorRepositorio(RepositorioGenerico<Doador> doadorRepositorio) {
        this.doadorRepositorio = doadorRepositorio;
    }

    public Doador getDoadorSelecionado() {
        return doadorSelecionado;
    }

    public void setDoadorSelecionado(Doador doadorSelecionado) {
        this.doadorSelecionado = doadorSelecionado;
    }
    
    public String inserir(Doador d){
        this.doadorRepositorio.inserir(d);
        
        FacesContext.getCurrentInstance().
                
                addMessage(null, new FacesMessage("Cadastro concluído com sucesso!"));
        
        return "cadastroConcluido.xhtml";
    }
    
    public String redirecionar(){
        return "CadastroDoador.xhtml";
    }
    
    public String alterar(Doador d){
        this.doadorRepositorio.alterar(d);
        
       
        FacesContext.getCurrentInstance().addMessage(null, 
                 new FacesMessage("Alteração concluída com sucesso"));
         
       
        
       return "perfilDoador.xhtml";
    }
    
    public Doador recuperar(String codigo){
        return this.doadorRepositorio.recuperar(codigo);
    }
    
    public void deletar(Doador d){
        this.doadorRepositorio.excluir(d);
    }
    
    public List<Doador> recuperarTodos(){
        return this.doadorRepositorio.recuperarTodos();
    }
}
