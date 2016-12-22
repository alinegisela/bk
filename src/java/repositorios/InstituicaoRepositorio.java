/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import dao.DaoManagerHiber;
import dao.InstituicaoDAO;
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
         //DaoManagerHiber.getInstance().persist(t);
         InstituicaoDAO.getInstance().inserir(t.getNome(), t.getEndereco(), t.getDescricao(), t.getCnpj(), t.getTel(), t.getEmail());
    }

    @Override
    public void alterar(Instituicao t) {
     InstituicaoDAO.getInstance().alterar(t.getNome(), t.getEndereco(), t.getDescricao(), t.getCnpj(), t.getTel(), t.getEmail());
    }

    @Override
    public Instituicao recuperar(String cnpj) {
      // return (Instituicao)DaoManagerHiber.getInstance().recover("from Instituicao where cnpj="+codigo).get(0);
      return InstituicaoDAO.getInstance().recuperar(cnpj);
    }

    @Override
    public void excluir(Instituicao t) {
         //DaoManagerHiber.getInstance().delete(t);
         InstituicaoDAO.getInstance().excluir(t);
    }

    @Override
    public List<Instituicao> recuperarTodos() {
        //return DaoManagerHiber.getInstance().recover("from Instituicao");
        return InstituicaoDAO.getInstance().recuperarTodos();
    }

    @Override
    public void excluir(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Instituicao recuperar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
