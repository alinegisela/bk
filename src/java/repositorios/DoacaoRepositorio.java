/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import dao.DaoManagerHiber;
import dao.DoacaoDAO;
import java.sql.SQLException;
import java.util.Date;
//import dao.GenericDao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Doacao;
import negocio.Doador;
import negocio.Instituicao;
import negocio.MaterialDoacao;
import negocio.StatusEnum;

/**
 *
 * @author Penguin
 */
public class DoacaoRepositorio implements RepositorioGenerico<Doacao>{

    @Override
    public void inserir(Doacao t, List<MaterialDoacao> m) {
        try {
            //DaoManagerHiber.getInstance().persist(t);
            //  int codigo, Doador doador, Instituicao instituicao, StatusEnum status, Date dataDoacao, Date dataVisita
            DoacaoDAO.getInstance().inserir(t.getCodigo(), t.getDoador(),t.getInstituicao(),t.getStatus(),t.getDataDoacao(),t.getDataVisita());
            for(MaterialDoacao mat : m){
                DoacaoDAO.getInstance().inserirMateriais(t.getCodigo(), mat.getCodigo());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoacaoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DoacaoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void alterar(Doacao t) {
        try {
            //DaoManagerHiber.getInstance().update(t);
            //GenericDao.getInstance().atualizar(t);
            DoacaoDAO.getInstance().alterar(t.getCodigo(), t.getDoador(),t.getInstituicao(),t.getStatus(),t.getDataDoacao(),t.getDataVisita());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoacaoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void alterarStatus(String status, int codigo) {
         try {
            DoacaoDAO.getInstance().alterarStatus(status, codigo);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoacaoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Doacao recuperar(int codigo) {
        try {
            // return (Doacao)DaoManagerHiber.getInstance().recover("from Doacao where codigo="+codigo).get(0);
            // return (Doacao)GenericDao.getInstance().encontrar(codigo);
            return DoacaoDAO.getInstance().recuperar(codigo);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoacaoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void excluir(Doacao t) {
        try {
            //DaoManagerHiber.getInstance().delete(t);
            //GenericDao.getInstance().remover(t);
            DoacaoDAO.getInstance().excluir(t);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoacaoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List recuperarTodos() {
        try {
            //return DaoManagerHiber.getInstance().recover("from Doacao");
            return DoacaoDAO.getInstance().recuperarTodos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoacaoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List recuperarTodosDoador(String cpf) {
        try {
            //return DaoManagerHiber.getInstance().recover("from Doacao");
            return DoacaoDAO.getInstance().recuperarTodosDoador(cpf);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoacaoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public List<Doacao> recuperarPorStatus(String status){
          try {
            //return DaoManagerHiber.getInstance().recover("from Doacao");
            return DoacaoDAO.getInstance().recuperarPorStatus(status);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoacaoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     }
    
    @Override
    public Doacao recuperar(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public List<MaterialDoacao> recuperarMateriais(String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Doacao t, String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Doacao t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Doacao> recuperarTodosDoacao(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
