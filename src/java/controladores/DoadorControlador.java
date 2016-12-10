/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.List;
import negocio.Doacao;
import negocio.Doador;
import repositorios.DoacaoRepositorio;
import repositorios.DoadorRepositorio;
import repositorios.RepositorioGenerico;

/**
 *
 * @author Penguin
 */
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

    public void setDoadorSelecionado(Doador doadorSelecionad) {
        this.doadorSelecionado = doadorSelecionado;
    }
    
    public void inserir(Doador d){
        this.doadorRepositorio.inserir(d);
    }
    
    public void alterar(Doador d){
        this.doadorRepositorio.alterar(d);
    }
    
    public Doador recuperar(int codigo){
        return this.doadorRepositorio.recuperar(codigo);
    }
    
    public void deletar(Doador d){
        this.doadorRepositorio.excluir(d);
    }
    
    public List<Doador> recuperarTodos(){
        return this.doadorRepositorio.recuperarTodos();
    }
}
