/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import dao.DaoManagerHiber;
import dao.DoacaoDAO;
import java.util.Date;
//import dao.GenericDao;
import java.util.List;
import negocio.Doacao;
import negocio.Doador;
import negocio.Instituicao;
import negocio.StatusEnum;

/**
 *
 * @author Penguin
 */
public class DoacaoRepositorio implements RepositorioGenerico<Doacao>{

    @Override
    public void inserir(Doacao t) {
        //DaoManagerHiber.getInstance().persist(t);
      //  int codigo, Doador doador, Instituicao instituicao, StatusEnum status, Date dataDoacao, Date dataVisita
        DoacaoDAO.getInstance().inserir(t.getCodigo(), t.getDoador(),t.getInstituicao(),t.getStatus(),t.getDataDoacao(),t.getDataVisita());
    }

    @Override
    public void alterar(Doacao t) {
        //DaoManagerHiber.getInstance().update(t);
        //GenericDao.getInstance().atualizar(t);
        DoacaoDAO.getInstance().alterar(t.getCodigo(), t.getDoador(),t.getInstituicao(),t.getStatus(),t.getDataDoacao(),t.getDataVisita());
    }

    @Override
    public Doacao recuperar(int codigo) {
       // return (Doacao)DaoManagerHiber.getInstance().recover("from Doacao where codigo="+codigo).get(0);
      // return (Doacao)GenericDao.getInstance().encontrar(codigo);
      return DoacaoDAO.getInstance().recuperar(codigo);
    }

    @Override
    public void excluir(Doacao t) {
       //DaoManagerHiber.getInstance().delete(t);
       //GenericDao.getInstance().remover(t);
       DoacaoDAO.getInstance().excluir(t);
    }

    @Override
    public List recuperarTodos() {
       //return DaoManagerHiber.getInstance().recover("from Doacao");
       return DoacaoDAO.getInstance().recuperarTodos();
    }

    @Override
    public Doacao recuperar(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
