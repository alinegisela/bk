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
import negocio.MaterialDoacao;
import repositorios.InstituicaoRepositorio;
import repositorios.MaterialRepositorio;
import repositorios.RepositorioGenerico;

/**
 *
 * @author Penguin
 */
@ManagedBean(name="cMaterial")
@SessionScoped
public class MaterialControlador {
    private RepositorioGenerico<MaterialDoacao> materialRepositorio = null;
    private MaterialDoacao materialSelecionado;
    
    public MaterialControlador(){
        this.materialRepositorio = new MaterialRepositorio();
    }

    public RepositorioGenerico<MaterialDoacao> getMaterialRepositorio() {
        return materialRepositorio;
    }

    public void setMaterialRepositorio(RepositorioGenerico<MaterialDoacao> materialRepositorio) {
        this.materialRepositorio = materialRepositorio;
    }

    public MaterialDoacao getMaterialSelecionado() {
        return materialSelecionado;
    }

    public void setMaterialSelecionado(MaterialDoacao materialSelecionado) {
        this.materialSelecionado = materialSelecionado;
    }
    
    public void inserir(MaterialDoacao d, String cnpj){
        this.materialRepositorio.inserir(d, cnpj);
        
        
         FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("Material add com sucesso!"));
        
       //return "cadastroConcluido.xhtml";
        
    }
    
    public void alterar(MaterialDoacao d){
        this.materialRepositorio.alterar(d);
        
        FacesContext.getCurrentInstance().addMessage(null, 
                 new FacesMessage("Sucessoo animal " + d.getCodigo() + " foi alterado com sucesso!!"));
         
       
        
       // return "ApresentaAnimal.xhtml";
    }
    
    public MaterialDoacao recuperar(int codigo){
        return this.materialRepositorio.recuperar(codigo);
    }
    
    public void deletar(MaterialDoacao d){
        this.materialRepositorio.excluir(d);
    }
    
    public List<MaterialDoacao> recuperarTodos(){
        return this.materialRepositorio.recuperarTodos();
    }
    
    public List<MaterialDoacao> recuperarTodosDoacao(int codigo){
        return this.materialRepositorio.recuperarTodosDoacao(codigo);
    }
    
    public List<MaterialDoacao> recuperarTodosInstituicao(int cnpj){
        return this.materialRepositorio.recuperarTodosDoacao(cnpj);
    }
}
