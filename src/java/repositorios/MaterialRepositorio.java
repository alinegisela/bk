/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import dao.MaterialDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.MaterialDoacao;
import negocio.PrioridadeEnum;

/**
 *
 * @author Penguin
 */
public class MaterialRepositorio implements RepositorioGenerico<MaterialDoacao> {

    @Override
    public void inserir(MaterialDoacao t, String cnpj) {
        try {
            MaterialDAO.getInstance().inserir(t.getCodigo(), t.getPrioridadeString(), t.getInsumo(), cnpj);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MaterialRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void alterar(MaterialDoacao t) {
        try {
            MaterialDAO.getInstance().alterar(t.getCodigo(), t.getPrioridade(), t.getInsumo());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MaterialRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public MaterialDoacao recuperar(int codigo) {
        try {
            return MaterialDAO.getInstance().recuperar(codigo);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MaterialRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public MaterialDoacao recuperar(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void deletarTodos(String cnpj) {
        try {
            MaterialDAO.getInstance().deletarTodos(cnpj);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MaterialRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(MaterialDoacao t) {
        try {
            MaterialDAO.getInstance().excluir(t);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MaterialRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<MaterialDoacao> recuperarTodos() {
        try {
            return MaterialDAO.getInstance().recuperarTodos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MaterialRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public List recuperarTodosDoacao(int codigo){
        try{
            return MaterialDAO.getInstance().recuperarTodosDoacao(codigo);
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MaterialRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void inserir(MaterialDoacao t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MaterialDoacao> recuperarMateriais(String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(MaterialDoacao t, List<MaterialDoacao> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MaterialDoacao> recuperarTodosDoador(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MaterialDoacao> recuperarPorStatus(String status, String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterarStatus(String status, int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterarSenha(MaterialDoacao t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checar(MaterialDoacao t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
