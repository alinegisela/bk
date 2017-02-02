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
import negocio.Doacao;
import negocio.Doador;
import negocio.Instituicao;
import negocio.Insumo;
import negocio.StatusEnum;
import negocio.TipoEnum;

/**
 *
 * @author Penguin
 */
public class InsumoDAO {

    private static InsumoDAO myself = null;
    private Connection con;

    public InsumoDAO() throws ClassNotFoundException {
        this.con = new ConnectionFactory().getConnection();
    }

    public static InsumoDAO getInstance() throws ClassNotFoundException {
        if (myself == null) {
            myself = new InsumoDAO();
        }

        return myself;
    }

    public boolean inserir(int codigo, String nome, String tipo, String descricao) {
        try {
            PreparedStatement insereInsumoSTM = null;
            String insereInsumoSQL = "insert into insumo (codigo, nome, tipo, descricao)"
                    + "values (?,?,?,?, ?)";

            insereInsumoSTM = con.prepareStatement(insereInsumoSQL);

            insereInsumoSTM.setInt(1, codigo);
            insereInsumoSTM.setString(2, nome);
            insereInsumoSTM.setString(3, tipo);
            insereInsumoSTM.setString(4, descricao);

            if (insereInsumoSTM.executeUpdate() == 1) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean alterar(int codigo, String nome, String tipo, String descricao) {

        String sql = "update insumo set codigo=?, nome=?, tipo=?, descricao=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.setString(2, nome);
            stmt.setString(3, tipo);
            stmt.setString(4, descricao);

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

    public void excluir(Insumo insumo) {
        try {
            PreparedStatement stmt = con.prepareStatement("delete "
                    + "from insumo where codigo=?");
            stmt.setInt(1, insumo.getCodigo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List recuperarTodos() {
        try {
            List<Insumo> insumoList = new ArrayList<Insumo>();
            PreparedStatement stmt = this.con.
                    prepareStatement("select * from insumo");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Insumo insumo = new Insumo();
                insumo.setCodigo(rs.getInt("codigo"));
                insumo.setNome(rs.getString("nome"));
                insumo.setTipo(rs.getString("tipo"));
                insumo.setDescricao(rs.getString("descricao"));


                /*
                // montando a data através do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);
                 */
                // adicionando o objeto à lista
                insumoList.add(insumo);
            }
            rs.close();
            stmt.close();
            return insumoList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Insumo recuperar(int codigo) {
        try {
            List<Insumo> insumoList = new ArrayList<>();
            PreparedStatement stmt = this.con.
                    prepareStatement("select * from insumo where codigo=?");
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Insumo insumo = new Insumo();
                insumo.setCodigo(rs.getInt("codigo"));
                insumo.setNome(rs.getString("nome"));
                insumo.setTipo(rs.getString("tipo"));
                insumo.setDescricao(rs.getString("descricao"));
                insumoList.add(insumo);
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
            return insumoList.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
