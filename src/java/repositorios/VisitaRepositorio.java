/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import dao.DaoManagerHiber;
import dao.VisitaDAO;
import java.util.List;
import negocio.Instituicao;
import negocio.StatusEnum;
import negocio.Visita;

/**
 *
 * @author Penguin
 */
public class VisitaRepositorio implements RepositorioGenerico<Visita>{

    @Override
    public void inserir(Visita t) {
      // DaoManagerHiber.getInstance().persist(t);
      VisitaDAO.getInstance().inserir(t.getCodigo(), t.getDoador(), t.getInstituicao(), t.getStatus(), t.getData_da_visita(), t.getHorario());
    }

    @Override
    public void alterar(Visita t) {
      // DaoManagerHiber.getInstance().update(t);
      VisitaDAO.getInstance().alterar(t.getCodigo(), t.getDoador(), t.getInstituicao(), t.getStatus(), t.getData_da_visita(), t.getHorario());
   }

    @Override
    public Visita recuperar(int codigo) {
      //return (Visita)DaoManagerHiber.getInstance().recover("from Visita where codigo="+codigo).get(0);
      return VisitaDAO.getInstance().recuperar(codigo);
    }

    @Override
    public void excluir(Visita t) {
       //DaoManagerHiber.getInstance().delete(t);
       VisitaDAO.getInstance().excluir(t);
    }

    @Override
    public List<Visita> recuperarTodos() {
       //return DaoManagerHiber.getInstance().recover("from Visita");
       return VisitaDAO.getInstance().recuperarTodos();
    }

    @Override
    public void excluir(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Visita recuperar(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
