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
import java.util.List;
import negocio.Insumo;
import negocio.MaterialDoacao;
import negocio.PrioridadeEnum;
import negocio.StatusEnum;
import negocio.TipoEnum;

/**
 *
 * @author Penguin
 */
public class MaterialDAO {
    private static MaterialDAO myself = null;
    private Connection con;

    public MaterialDAO() throws ClassNotFoundException {
        this.con = new ConnectionFactory().getConnection();
    }

    public static MaterialDAO getInstance() throws ClassNotFoundException {
        if (myself == null) {
            myself = new MaterialDAO();
        }

        return myself;
    }

    public boolean inserir(int codigo, PrioridadeEnum prioridade, Insumo insumo) {
        try {
            PreparedStatement insereMaterialSTM = null;
            String insereMaterialSQL = "insert into material(codigo, prioridade, id_insumo)"
                    + "values (?,?,?)";

            insereMaterialSTM = con.prepareStatement(insereMaterialSQL);

            insereMaterialSTM.setInt(1, codigo);
            insereMaterialSTM.setString(2, prioridade.toString(prioridade.getValor()));
            insereMaterialSTM.setInt(3, insumo.getCodigo());

            if (insereMaterialSTM.executeUpdate() == 1) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean alterar(int codigo, PrioridadeEnum prioridade, Insumo insumo) {

        String sql = "update material set codigo=?, prioridade=?, id_insumo=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.setString(2, prioridade.toString(prioridade.getValor()));
            stmt.setInt(3, insumo.getCodigo());
            

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

    public void excluir(MaterialDoacao material) {
        try {
            PreparedStatement stmt = con.prepareStatement("delete "
                    + "from material where codigo=?");
            stmt.setInt(1, material.getCodigo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List recuperarTodos() throws ClassNotFoundException {
        try {
            List<MaterialDoacao> materialList = new ArrayList<MaterialDoacao>();
            PreparedStatement stmt = this.con.
                    prepareStatement("select * from material");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                MaterialDoacao material = new MaterialDoacao();
                material.setCodigo(rs.getInt("codigo"));
                material.setPrioridade(PrioridadeEnum.ALTA.toEnum(rs.getString("prioridade")));
                material.setInsumo(InsumoDAO.getInstance().recuperar(rs.getInt("id_insumo")));
              

                materialList.add(material);
            }
            rs.close();
            stmt.close();
            return materialList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MaterialDoacao recuperar(int codigo) throws ClassNotFoundException {
        try {
            List<MaterialDoacao> materialList = new ArrayList<MaterialDoacao>();
            PreparedStatement stmt = this.con.
                    prepareStatement("select * from material where codigo=?");
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                MaterialDoacao material = new MaterialDoacao();
                material.setCodigo(rs.getInt("codigo"));
                material.setPrioridade(PrioridadeEnum.ALTA.toEnum(rs.getString("prioridade")));
                material.setInsumo(InsumoDAO.getInstance().recuperar(rs.getInt("id_insumo")));
                materialList.add(material);
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
            return materialList.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
