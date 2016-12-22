/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import dao.MaterialDAO;
import java.util.List;
import negocio.MaterialDoacao;
import negocio.PrioridadeEnum;

/**
 *
 * @author Penguin
 */
public class MaterialRepositorio implements RepositorioGenerico<MaterialDoacao> {

    @Override
    public void inserir(MaterialDoacao t) {
        MaterialDAO.getInstance().inserir(t.getCodigo(), t.getPrioridade(), t.getInsumo());
    }

    @Override
    public void alterar(MaterialDoacao t) {
        MaterialDAO.getInstance().alterar(t.getCodigo(), t.getPrioridade(), t.getInsumo());
    }

    @Override
    public MaterialDoacao recuperar(int codigo) {
        return MaterialDAO.getInstance().recuperar(codigo);
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
    public void excluir(MaterialDoacao t) {
        MaterialDAO.getInstance().excluir(t);
    }

    @Override
    public List<MaterialDoacao> recuperarTodos() {
        return MaterialDAO.getInstance().recuperarTodos();
    }

}
