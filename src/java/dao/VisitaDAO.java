/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import negocio.Doacao;
import negocio.Doador;
import negocio.Instituicao;
import negocio.StatusEnum;
import negocio.Visita;

/**
 *
 * @author Penguin
 */
public class VisitaDAO {
     private static VisitaDAO myself = null;
    private Connection con;
    
    public VisitaDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public static VisitaDAO getInstance() {
        if (myself == null) {
            myself = new VisitaDAO();
        }
        
        return myself;
    }

    //Funcionannndooooooooooo
    
    public boolean inserir(int codigo, Doador doador, Instituicao instituicao, StatusEnum status, Date data_da_visita, String horario) {
        try {
            PreparedStatement insereVisitaSTM = null;
            String insereVisitaSQL = "insert into visita (codigo, id_doador, id_instituicao, statusenum, data_da_visita, horario)"
                    + "values (?,?,?,?,?,?)";
            
            insereVisitaSTM = con.prepareStatement(insereVisitaSQL);
            
            insereVisitaSTM.setInt(1, codigo);
            insereVisitaSTM.setString(2, doador.getCpf());
            insereVisitaSTM.setString(3, instituicao.getCnpj());
            insereVisitaSTM.setString(4, status.toString(status.getValor()));
            insereVisitaSTM.setDate(5,  new java.sql.Date(data_da_visita.getTime()));
            insereVisitaSTM.setString(6,  horario);
            
            
            if (insereVisitaSTM.executeUpdate() == 1) {
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public boolean alterar(int codigo, Doador doador, Instituicao instituicao, StatusEnum status, Date data_da_visita, String horario) {
        
        String sql = "update visita set codigo=?, id_doador=?, id_instituicao=?, statusenum=?,data_da_visita=?, horario=? where codigo=codigo";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.setString(2, doador.getCpf());
            stmt.setString(3, instituicao.getCnpj());
            stmt.setString(4, status.toString(status.getValor()));
            stmt.setDate(5,  new java.sql.Date(data_da_visita.getTime()));
            stmt.setString(6,  horario);
            stmt.execute();
            
            if (stmt.executeUpdate() == 1) {
                return true;
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    
    
    public void excluir(Visita visita) {
        try {
            PreparedStatement stmt = con.prepareStatement("delete "
                    + "from visita where codigo=?");
            stmt.setInt(1, visita.getCodigo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public List recuperarTodos() {
        try {
            List<Visita> visitaList = new ArrayList<Visita>();
            PreparedStatement stmt = this.con.
                    prepareStatement("select * from visita");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Contato
                Visita visita = new Visita();
                visita.setCodigo(rs.getInt("codigo"));
                visita.setDoador(DoadorDAO.getInstance().recuperar(rs.getString("id_doador")));
                visita.setInstituicao(InstituicaoDAO.getInstance().recuperar(rs.getString("id_instituicao")));            
                visita.setStatus(StatusEnum.EM_ANDAMENTO.toEnum(rs.getString("statusenum")));
                visita.setData_da_visita(rs.getDate("data_da_visita"));
                visita.setHorario(rs.getString("horario"));
               
                visitaList.add(visita);
            }
            rs.close();
            stmt.close();
            return visitaList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Visita recuperar(int codigo) {
        try {
            List<Visita> visitaList = new ArrayList<Visita>();
            PreparedStatement stmt = this.con.
                    prepareStatement("select * from visita where codigo=?");
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Contato
                Visita visita = new Visita();
                visita.setCodigo(rs.getInt("codigo"));
                visita.setDoador(DoadorDAO.getInstance().recuperar(rs.getString("id_doador")));
                visita.setInstituicao(InstituicaoDAO.getInstance().recuperar(rs.getString("id_instituicao")));            
                visita.setStatus(StatusEnum.EM_ANDAMENTO.toEnum(rs.getString("statusenum")));
                visita.setData_da_visita(rs.getDate("data_da_visita"));
                visita.setHorario(rs.getString("horario"));
               
                visitaList.add(visita);
            }
            /*
                // montando a data através do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);
             */
            // adicionando o objeto à lista
            rs.close();
            stmt.close();
            return visitaList.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
