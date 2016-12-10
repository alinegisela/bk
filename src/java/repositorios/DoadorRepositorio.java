/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import dao.DaoManagerHiber;
import java.util.List;
import negocio.Doador;

/**
 *
 * @author Penguin
 */
public class DoadorRepositorio implements RepositorioGenerico<Doador>{

    @Override
    public void inserir(Doador t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Doador t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Doador recuperar(int codigo) {
        return (Doador)DaoManagerHiber.getInstance().recover("from Doador where cpf="+codigo).get(0);
    }

    @Override
    public void excluir(Doador t) {
       DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Doador> recuperarTodos() {
      return DaoManagerHiber.getInstance().recover("from Doador");
    }
    
}
