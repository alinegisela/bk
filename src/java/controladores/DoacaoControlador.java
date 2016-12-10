/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.List;
import negocio.Doacao;
import repositorios.DoacaoRepositorio;
import repositorios.RepositorioGenerico;

/**
 *
 * @author Penguin
 */
public class DoacaoControlador {
    
    private RepositorioGenerico<Doacao> doacaoRepositorio = null;
    private Doacao doacaoSelecionada;
    
    public DoacaoControlador(){
        this.doacaoRepositorio = new DoacaoRepositorio();
    }

    public RepositorioGenerico<Doacao> getDoacaoRepositorio() {
        return doacaoRepositorio;
    }

    public void setDoacaoRepositorio(RepositorioGenerico<Doacao> doacaoRepositorio) {
        this.doacaoRepositorio = doacaoRepositorio;
    }

    public Doacao getDoacaoSelecionada() {
        return doacaoSelecionada;
    }

    public void setDoacaoSelecionada(Doacao doacaoSelecionada) {
        this.doacaoSelecionada = doacaoSelecionada;
    }
    
    public void inserir(Doacao d){
        this.doacaoRepositorio.inserir(d);
    }
    
    public void alterar(Doacao d){
        this.doacaoRepositorio.alterar(d);
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
