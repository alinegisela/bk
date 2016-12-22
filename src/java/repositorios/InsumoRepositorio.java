/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import dao.InsumoDAO;
import java.util.List;
import negocio.Instituicao;
import negocio.Insumo;
import negocio.StatusEnum;
import negocio.TipoEnum;

/**
 *
 * @author Penguin
 */
public class InsumoRepositorio implements RepositorioGenerico<Insumo> {

    @Override
    public void inserir(Insumo t) {
        InsumoDAO.getInstance().inserir(t.getCodigo(), t.getNome(), t.getTipo(), t.getDescricao());
    }

    @Override
    public void alterar(Insumo t) {
        InsumoDAO.getInstance().alterar(t.getCodigo(), t.getNome(), t.getTipo(), t.getDescricao());
    }

    @Override
    public Insumo recuperar(int codigo) {
       return InsumoDAO.getInstance().recuperar(codigo);
    }

    @Override
    public Insumo recuperar(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Insumo insumo) {
        InsumoDAO.getInstance().excluir(insumo);
    }

   

    @Override
    public List<Insumo> recuperarTodos() {
       return InsumoDAO.getInstance().recuperarTodos();
    }

    @Override
    public void excluir(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
