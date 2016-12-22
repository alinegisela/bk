/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import dao.DaoManagerHiber;
import dao.DoadorDAO;
import java.util.List;
import negocio.Doador;

/**
 *
 * @author Penguin
 */
public class DoadorRepositorio implements RepositorioGenerico<Doador>{

    @Override
    public void inserir(Doador t) {
      //  DaoManagerHiber.getInstance().persist(t);
        DoadorDAO.getInstance().inserir(t.getNome(), t.getCpf(), t.getEndereco(), t.getTelefone(), t.getEmail());
    }

    @Override
    public void alterar(Doador t) {
       //DaoManagerHiber.getInstance().update(t);
       DoadorDAO.getInstance().alterar(t.getNome(), t.getCpf(), t.getEndereco(), t.getTelefone(), t.getEmail());
    }

    @Override
    public Doador recuperar(String cpf) {
       //return (Doador)DaoManagerHiber.getInstance().recover("from Doador where cpf="+codigo).get(0);
       return DoadorDAO.getInstance().recuperar(cpf);
    }

    @Override
    public void excluir(Doador t) {
      // DaoManagerHiber.getInstance().delete(t);
      DoadorDAO.getInstance().excluir(t);
    }

    @Override
    public List<Doador> recuperarTodos() {
      //return DaoManagerHiber.getInstance().recover("from Doador");
      return DoadorDAO.getInstance().recuperarTodos();
    }

    @Override
    public void excluir(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Doador recuperar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
