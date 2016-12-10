/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.List;
import negocio.Doador;
import negocio.Instituicao;
import repositorios.DoadorRepositorio;
import repositorios.InstituicaoRepositorio;
import repositorios.RepositorioGenerico;

/**
 *
 * @author Penguin
 */
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

    public void setInstituicaoSelecionada(Instituicao instituicaoSelecionad) {
        this.instituicaoSelecionada = instituicaoSelecionada;
    }
    
    public void inserir(Instituicao d){
        this.instituicaoRepositorio.inserir(d);
    }
    
    public void alterar(Instituicao d){
        this.instituicaoRepositorio.alterar(d);
    }
    
    public Instituicao recuperar(int codigo){
        return this.instituicaoRepositorio.recuperar(codigo);
    }
    
    public void deletar(Instituicao d){
        this.instituicaoRepositorio.excluir(d);
    }
    
    public List<Instituicao> recuperarTodos(){
        return this.instituicaoRepositorio.recuperarTodos();
    }
}
