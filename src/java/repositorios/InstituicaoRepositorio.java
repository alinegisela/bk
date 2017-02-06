/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import dao.DaoManagerHiber;
import dao.InstituicaoDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Doador;
import negocio.Instituicao;
import negocio.MaterialDoacao;

/**
 *
 * @author Penguin
 */
public class InstituicaoRepositorio implements RepositorioGenerico<Instituicao> {

    @Override
    public void inserir(Instituicao t) {
        try {
            //DaoManagerHiber.getInstance().persist(t);
            InstituicaoDAO.getInstance().inserir(t.getNome(), t.getEndereco(), t.getDescricao(), t.getCnpj(), t.getTel(), t.getEmail(), t.getSenha());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InstituicaoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<MaterialDoacao> recuperarMateriais(String cnpj){
        try{
            return InstituicaoDAO.getInstance().recuperarMateriais(cnpj);
        }catch(ClassNotFoundException ex) {
            Logger.getLogger(InstituicaoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void alterar(Instituicao t) {
        try {
            InstituicaoDAO.getInstance().alterar(t.getNome(), t.getEndereco(), t.getDescricao(), t.getTel(), t.getEmail(), t.getCnpj());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InstituicaoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Instituicao recuperar(String cnpj) {
        try {
            // return (Instituicao)DaoManagerHiber.getInstance().recover("from Instituicao where cnpj="+codigo).get(0);
            return InstituicaoDAO.getInstance().recuperar(cnpj);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InstituicaoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void excluir(Instituicao t) {
        try {
            //DaoManagerHiber.getInstance().delete(t);
            InstituicaoDAO.getInstance().excluir(t);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InstituicaoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Instituicao> recuperarTodos() {
        try {
            //return DaoManagerHiber.getInstance().recover("from Instituicao");
            return InstituicaoDAO.getInstance().recuperarTodos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InstituicaoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void excluir(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Instituicao recuperar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    @Override
    public void inserir(Instituicao t, String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Instituicao t, List<MaterialDoacao> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Instituicao> recuperarTodosDoador(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Instituicao> recuperarTodosDoacao(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Instituicao> recuperarPorStatus(String status) {
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
