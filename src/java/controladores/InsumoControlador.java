/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.List;
import negocio.Instituicao;
import negocio.Insumo;
import repositorios.InstituicaoRepositorio;
import repositorios.InsumoRepositorio;
import repositorios.RepositorioGenerico;

/**
 *
 * @author Penguin
 */
public class InsumoControlador {
    private RepositorioGenerico<Insumo> insumoRepositorio = null;
    private Insumo insumoSelecionado;
    
    public InsumoControlador(){
        this.insumoRepositorio = new InsumoRepositorio();
    }

    public RepositorioGenerico<Insumo> getInsumoRepositorio() {
        return insumoRepositorio;
    }

    public void setInsumoRepositorio(RepositorioGenerico<Insumo> insumoRepositorio) {
        this.insumoRepositorio = insumoRepositorio;
    }

    public Insumo getInsumoSelecionado() {
        return insumoSelecionado;
    }

    public void setInsumoSelecionado(Insumo insumoSelecionado) {
        this.insumoSelecionado = insumoSelecionado;
    }
    
    public void inserir(Insumo d){
        this.insumoRepositorio.inserir(d);
    }
    
    public void alterar(Insumo d){
        this.insumoRepositorio.alterar(d);
    }
    
    public Insumo recuperar(int codigo){
        return this.insumoRepositorio.recuperar(codigo);
    }
    
    public void deletar(Insumo d){
        this.insumoRepositorio.excluir(d);
    }
    
    public List<Insumo> recuperarTodos(){
        return this.insumoRepositorio.recuperarTodos();
    }
}
