/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import dao.InsumoDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Instituicao;
import negocio.Insumo;
import negocio.MaterialDoacao;
import negocio.StatusEnum;
import negocio.TipoEnum;

/**
 *
 * @author Penguin
 */
public class InsumoRepositorio implements RepositorioGenerico<Insumo> {

    @Override
    public void inserir(Insumo t) {
        try {
            InsumoDAO.getInstance().inserir(t.getCodigo(), t.getNome(), t.getTipo(), t.getDescricao());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsumoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void alterar(Insumo t) {
        try {
            InsumoDAO.getInstance().alterar(t.getCodigo(), t.getNome(), t.getTipo(), t.getDescricao());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsumoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Insumo recuperar(int codigo) {
        try {
            return InsumoDAO.getInstance().recuperar(codigo);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsumoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Insumo recuperar(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Insumo insumo) {
        try {
            InsumoDAO.getInstance().excluir(insumo);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsumoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    @Override
    public List<Insumo> recuperarTodos() {
        try {
            return InsumoDAO.getInstance().recuperarTodos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsumoRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
    public void inserir(Insumo t, String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
