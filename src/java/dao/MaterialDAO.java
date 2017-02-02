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

    
    
    public boolean inserir(int codigo, String prioridade, Insumo insumo, String cnpj) {
        try {
            PreparedStatement insereMaterialSTM = null;
            PreparedStatement insereMaterialDoacaoSTM = null;
            String insereMaterialSQL = "insert into material(codigo, prioridade, id_insumo)"
                    + "values (?,?,?)";

            insereMaterialSTM = con.prepareStatement(insereMaterialSQL);

            insereMaterialSTM.setInt(1, codigo);
            insereMaterialSTM.setString(2, prioridade);
            insereMaterialSTM.setInt(3, insumo.getCodigo());

            String insereMaterialDoacaoSQL = "insert into instituicao_material(id_instituicao, id_material)"
                    + "values (?,?)";
            
            insereMaterialDoacaoSTM = con.prepareStatement(insereMaterialDoacaoSQL);
            insereMaterialDoacaoSTM.setString(1, cnpj);
            insereMaterialDoacaoSTM.setInt(2, codigo);
            
            if (insereMaterialSTM.executeUpdate() == 1 && insereMaterialDoacaoSTM.executeUpdate() == 1) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean alterar(int codigo, boolean prioridade, Insumo insumo) {

        String sql = "update material set codigo=?, prioridade=?, id_insumo=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.setBoolean(2, prioridade);
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
                material.setPrioridade(rs.getBoolean("prioridade"));
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

     public List recuperarTodosDoacao(int codigo) throws ClassNotFoundException, SQLException {
        try {
            List<MaterialDoacao> materialList = new ArrayList<MaterialDoacao>();
            List<Integer> id_materialList = new ArrayList<>();
            
            PreparedStatement stmt = this.con.
                    prepareStatement("select id_material from doacao_material where id_doacao=?");
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();

            
           while(rs.next()){
               id_materialList.add(rs.getInt("id_material"));
           }
                // criando o objeto Contato
                MaterialDoacao material;
            for(int i=0;i<id_materialList.size();i++){
                 material = recuperar(id_materialList.get(i));
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
                material.setPrioridade(rs.getBoolean("prioridade"));
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
