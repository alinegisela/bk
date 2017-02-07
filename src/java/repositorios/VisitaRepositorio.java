/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import dao.DaoManagerHiber;
import dao.VisitaDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Instituicao;
import negocio.MaterialDoacao;
import negocio.StatusEnum;
import negocio.Visita;

/**
 *
 * @author Penguin
 */
public class VisitaRepositorio implements RepositorioGenerico<Visita>{

    @Override
    public void inserir(Visita t) {
        try {
            // DaoManagerHiber.getInstance().persist(t);
            VisitaDAO.getInstance().inserir(t.getCodigo(), t.getDoador(), t.getInstituicao(), t.getStatus(), t.getData_da_visita(), t.getHorario());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VisitaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void alterar(Visita t) {
        try {
            // DaoManagerHiber.getInstance().update(t);
            VisitaDAO.getInstance().alterar(t.getCodigo(), t.getDoador(), t.getInstituicao(), t.getStatus(), t.getData_da_visita(), t.getHorario());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VisitaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
   }

    @Override
    public Visita recuperar(int codigo) {
        try {
            //return (Visita)DaoManagerHiber.getInstance().recover("from Visita where codigo="+codigo).get(0);
            return VisitaDAO.getInstance().recuperar(codigo);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VisitaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void excluir(Visita t) {
        try {
            //DaoManagerHiber.getInstance().delete(t);
            VisitaDAO.getInstance().excluir(t);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VisitaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Visita> recuperarTodos() {
        try {
            //return DaoManagerHiber.getInstance().recover("from Visita");
            return VisitaDAO.getInstance().recuperarTodos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VisitaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void excluir(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Visita recuperar(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public List<MaterialDoacao> recuperarMateriais(String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Visita t, String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Visita t, List<MaterialDoacao> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Visita> recuperarTodosDoador(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Visita> recuperarTodosDoacao(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Visita> recuperarPorStatus(String status, String cnpj) {
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

    @Override
    public boolean alterarSenha(Visita t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checar(Visita t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
