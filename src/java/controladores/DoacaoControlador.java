/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import negocio.Doacao;
import negocio.Doador;
import negocio.Instituicao;
import repositorios.DoacaoRepositorio;
import repositorios.RepositorioGenerico;

/**
 *
 * @author Penguin
 */
@ManagedBean(name="cDoacao")
@SessionScoped
public class DoacaoControlador implements Serializable{
    
    private RepositorioGenerico<Doacao> doacaoRepositorio = null;
    private Doacao doacaoSelecionada;
   // private List<Doador> doadores
    
    public DoacaoControlador(){
        this.doacaoRepositorio = new DoacaoRepositorio();
    }

    public RepositorioGenerico<Doacao> getDoacaoRepositorio() {
        return doacaoRepositorio;
    }

    public void setDoacaoRepositorio(RepositorioGenerico<Doacao> doacaoRepositorio) {
        this.doacaoRepositorio = doacaoRepositorio;
    }

    public Doacao getDoacaoSelecionada() throws ClassNotFoundException {
       // doacaoSelecionada.setDoador(new Doador());
       // doacaoSelecionada.setInstituicao(new Instituicao());
       // doacaoSelecionada.criar();
        return doacaoSelecionada;
    }

    public void setDoacaoSelecionada(Doacao doacaoSelecionada) {
        this.doacaoSelecionada = doacaoSelecionada;
    }
    
    public void inserir(Doacao d){
        this.doacaoRepositorio.inserir(d);
        
        //(ControladorLogin)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("controladorLogin");
        
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("Cadastro concluído com sucesso!"));
        
        //return "ApresentaAnimal.xhtml";
    }
    
    public void alterar(Doacao d){
        this.doacaoRepositorio.alterar(d);
        FacesContext.getCurrentInstance().addMessage(null, 
                 new FacesMessage("Sucessoo animal " + d.getCodigo() + " foi alterado com sucesso!!"));
         
       
        
       // return "ApresentaAnimal.xhtml";
    }
    
    public Doacao recuperar(int codigo){
        return this.doacaoRepositorio.recuperar(codigo);
    }
    
    public void deletar(Doacao d){
        this.doacaoRepositorio.excluir(d);
    }
    
    public List<Doacao> recuperarTodos(){
        return this.doacaoRepositorio.recuperarTodos();
    }
}
