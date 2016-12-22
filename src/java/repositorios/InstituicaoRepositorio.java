/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import dao.DaoManagerHiber;
import java.util.List;
import negocio.Doador;
import negocio.Instituicao;

/**
 *
 * @author Penguin
 */
public class InstituicaoRepositorio implements RepositorioGenerico<Instituicao> {

    @Override
    public void inserir(Instituicao t) {
         DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Instituicao t) {
      DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Instituicao recuperar(int codigo) {
       return (Instituicao)DaoManagerHiber.getInstance().recover("from Instituicao where cnpj="+codigo).get(0);
    }

    @Override
    public void excluir(Instituicao t) {
         DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Instituicao> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from Instituicao");
    }

    @Override
    public void excluir(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
