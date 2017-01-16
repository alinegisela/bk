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
import negocio.Doador;
import negocio.Instituicao;
import repositorios.DoadorRepositorio;
import repositorios.InstituicaoRepositorio;
import repositorios.RepositorioGenerico;

/**
 *
 * @author Penguin
 */
@ManagedBean(name="cInstituicao")
@SessionScoped
public class InstituicaoControlador {
    private RepositorioGenerico<Instituicao> instituicaoRepositorio = null;
    private Instituicao instituicaoSelecionada;
    
    public InstituicaoControlador(){
        this.instituicaoRepositorio = new InstituicaoRepositorio();
    }

    public RepositorioGenerico<Instituicao> getInstituicaoRepositorio() {
        return instituicaoRepositorio;
    }

    public void setInstituicaoRepositorio(RepositorioGenerico<Instituicao> instituicaoRepositorio) {
        this.instituicaoRepositorio = instituicaoRepositorio;
    }

    public Instituicao getinstituicaoSelecionada() {
        return instituicaoSelecionada;
    }

    public String setInstituicaoSelecionada(Instituicao instituicaoSelecionada) {
        this.instituicaoSelecionada = instituicaoSelecionada;
        return "visualizarInstituicao.xhtml";
    }
    
    public String inserir(Instituicao d){
        this.instituicaoRepositorio.inserir(d);
        
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("Cadastro concluído com sucesso!"));
        
       return "cadastroConcluido.xhtml";
    }
    
    public void alterar(Instituicao d){
        this.instituicaoRepositorio.alterar(d);
        
        FacesContext.getCurrentInstance().addMessage(null, 
                 new FacesMessage("Sucesso o animal " + d.getNome() + " foi alterado com sucesso!!"));
         
       
        
       // return "ApresentaAnimal.xhtml";
    }
    
    public Instituicao recuperar(String codigo){
        return this.instituicaoRepositorio.recuperar(codigo);
    }
    
    public void deletar(Instituicao d){
        this.instituicaoRepositorio.excluir(d);
    }
    
    public List<Instituicao> recuperarTodos(){
        return this.instituicaoRepositorio.recuperarTodos();
    }
}
