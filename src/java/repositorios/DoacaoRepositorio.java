/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import dao.DaoManagerHiber;
import java.util.List;
import negocio.Doacao;

/**
 *
 * @author Penguin
 */
public class DoacaoRepositorio implements RepositorioGenerico<Doacao>{

    @Override
    public void inserir(Doacao t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Doacao t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Doacao recuperar(int codigo) {
        return (Doacao)DaoManagerHiber.getInstance().recover("from Doacao where codigo="+codigo).get(0);
    }

    @Override
    public void excluir(Doacao t) {
       DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List recuperarTodos() {
       return DaoManagerHiber.getInstance().recover("from Doacao");
    }
    
}
