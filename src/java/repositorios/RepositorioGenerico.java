/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import java.util.List;
import negocio.MaterialDoacao;

/**
 *
 * @author Penguin
 */
public interface RepositorioGenerico <T>{
     public void inserir(T t);
     public void inserir(T t, String cnpj);
     public boolean checar(T t);
    /**
     *
     * @param i
     * @param m
     * @return
     */
    public void inserir(T t, List<MaterialDoacao> m);
    public void alterar(T t);
    public void alterarStatus(String status, int codigo) ;
    public boolean alterarSenha(T t);
    public T recuperar(int codigo);
     public T recuperar(String cpf);
     public List<MaterialDoacao> recuperarMateriais(String cnpj);
     public List<T> recuperarTodosDoador(String cpf);
    public void excluir(int codigo);
    public void excluir(T t);
    public void deletarTodos(String cnpj);
    public List<T> recuperarTodos();
    public List<T> recuperarTodosDoacao(int codigo);
    public List<T> recuperarPorStatus(String status, String cnpj);
}
