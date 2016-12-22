/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import dao.DaoManagerHiber;
import dao.GenericDao;
import java.util.List;
import negocio.Doacao;

/**
 *
 * @author Penguin
 */
public class DoacaoRepositorio implements RepositorioGenerico<Doacao>{

    @Override
    public void inserir(Doacao t) {
        //DaoManagerHiber.getInstance().persist(t);
        GenericDao.getInstance().salvar(t);
    }

    @Override
    public void alterar(Doacao t) {
        //DaoManagerHiber.getInstance().update(t);
        GenericDao.getInstance().atualizar(t);
    }

    @Override
    public Doacao recuperar(int codigo) {
       // return (Doacao)DaoManagerHiber.getInstance().recover("from Doacao where codigo="+codigo).get(0);
       return (Doacao)GenericDao.getInstance().encontrar(codigo);
    }

    @Override
    public void excluir(/*Doacao*/int t) {
       //DaoManagerHiber.getInstance().delete(t);
       GenericDao.getInstance().remover(t);
    }

    @Override
    public List recuperarTodos() {
       return DaoManagerHiber.getInstance().recover("from Doacao");
    }

    @Override
    public void excluir(Doacao t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
