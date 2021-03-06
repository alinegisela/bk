/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import dao.DaoManagerHiber;
import dao.DoadorDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Doador;
import negocio.MaterialDoacao;

/**
 *
 * @author Penguin
 */
public class DoadorRepositorio implements RepositorioGenerico<Doador>{

    @Override
    public boolean checar(Doador t){
         try {
            //  DaoManagerHiber.getInstance().persist(t);
           return DoadorDAO.getInstance().checar(t.getCpf(), t.getEmail());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DoadorRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
    }
    
    @Override
    public void inserir(Doador t) {
        try {
            //  DaoManagerHiber.getInstance().persist(t);
            DoadorDAO.getInstance().inserir(t.getNome(), t.getCpf(), t.getEndereco(), t.getTelefone(), t.getEmail(), t.getSenha());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoadorRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void alterar(Doador t) {
        try {
            //DaoManagerHiber.getInstance().update(t);
            DoadorDAO.getInstance().alterar(t.getNome(), t.getEndereco(), t.getTelefone(), t.getEmail(), t.getCpf());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoadorRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     @Override
    public boolean alterarSenha(Doador t) {
        try {
            //DaoManagerHiber.getInstance().update(t);
            return DoadorDAO.getInstance().alterarSenha(t.getSenhaConfirmacao(),t.getNovaSenha(), t.getCpf());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DoadorRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Doador recuperar(String cpf) {
        try {
            //return (Doador)DaoManagerHiber.getInstance().recover("from Doador where cpf="+codigo).get(0);
            return DoadorDAO.getInstance().recuperar(cpf);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoadorRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void excluir(Doador t) {
        try {
            // DaoManagerHiber.getInstance().delete(t);
            DoadorDAO.getInstance().excluir(t);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoadorRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Doador> recuperarTodos() {
        try {
            //return DaoManagerHiber.getInstance().recover("from Doador");
            return DoadorDAO.getInstance().recuperarTodos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoadorRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void excluir(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Doador recuperar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public List<MaterialDoacao> recuperarMateriais(String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Doador t, String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Doador t, List<MaterialDoacao> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Doador> recuperarTodosDoador(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Doador> recuperarTodosDoacao(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Doador> recuperarPorStatus(String status, String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterarStatus(String status, int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletarTodos(String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
