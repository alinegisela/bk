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
import negocio.MaterialDoacao;

/**
 *
 * @author Penguin
 */
public class InstituicaoDAO {

    private static InstituicaoDAO myself = null;
    private Connection con;

    public InstituicaoDAO() throws ClassNotFoundException {
        this.con = new ConnectionFactory().getConnection();
    }

    public static InstituicaoDAO getInstance() throws ClassNotFoundException {
        if (myself == null) {
            myself = new InstituicaoDAO();
        }

        return myself;
    }

    public boolean checar(String cnpj, String email) throws SQLException{
        
        try {
            PreparedStatement stmt = this.con.
                    prepareStatement("select * from instituicao where cnpj=?");
            stmt.setString(1, cnpj);
            ResultSet rs = stmt.executeQuery();
            
            /*
            while(rs.next()){
                System.out.println("sdfas " + rs.getString("nome"));
            }
            */

            PreparedStatement stmt2 = this.con.
                    prepareStatement("select * from instituicao where email=?");
            stmt2.setString(1, email);
            ResultSet rs2 = stmt2.executeQuery();
            
            if(rs.next() || rs2.next()){
                return false;
            }else{
                return true;
            }
            
            
         } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<MaterialDoacao> recuperarMateriais(String cnpj) throws ClassNotFoundException {
        try {
            List<Integer> id_materialList = new ArrayList<>();
            List<MaterialDoacao> materialList = new ArrayList<>();

            PreparedStatement stmt = this.con.
                    prepareStatement("select * from instituicao_material where id_instituicao=?");
            stmt.setString(1, cnpj);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                id_materialList.add(rs.getInt("id_material"));
                String id_inst = rs.getString("id_instituicao");
            }

            List<ResultSet> rsList = new ArrayList<>();
            for (int i = 0; i < id_materialList.size(); i++) {
                PreparedStatement stmt2 = this.con.
                        prepareStatement("select * from material where codigo=?");
                stmt2.setInt(1, id_materialList.get(i));

                ResultSet rs2 = stmt2.executeQuery();
                rsList.add(rs2);
            }

            for (int i = 0; i < rsList.size(); i++) {
                while (rsList.get(i).next()) {
                    // criando o objeto Contato
                    MaterialDoacao material = new MaterialDoacao();
                    material.setCodigo(rsList.get(i).getInt("codigo"));
                    material.setPrioridadeString(rsList.get(i).getString("prioridade"));
                    material.setInsumo(InsumoDAO.getInstance().recuperar(rsList.get(i).getInt("id_insumo")));
                    materialList.add(material);
                }
            }

           rs.close();
            stmt.close();
            //stmt2.close();
            return materialList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean inserir(String nome, String endereco, String descricao, String cnpj, String tel, String email, String senha) {
        try {
            PreparedStatement insereInstituicaoSTM = null;
            String insereInstituicaoSQL = "insert into instituicao (nome, endereco, descricao, cnpj, tel, email, senha)"
                    + "values (?,?,?,?,?,?,?)";

            insereInstituicaoSTM = con.prepareStatement(insereInstituicaoSQL);

            insereInstituicaoSTM.setString(1, nome);
            insereInstituicaoSTM.setString(2, endereco);
            insereInstituicaoSTM.setString(3, descricao);
            insereInstituicaoSTM.setString(4, cnpj);
            insereInstituicaoSTM.setString(5, tel);
            insereInstituicaoSTM.setString(6, email);
            insereInstituicaoSTM.setString(7, senha);

            if (insereInstituicaoSTM.executeUpdate() == 1) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean alterar(String nome, String endereco, String descricao, String tel, String email, String cnpj) {

        String sql = "update instituicao set nome=?, endereco=?, descricao=?, tel=?, email=? where cnpj = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, endereco);
            stmt.setString(3, descricao);
            stmt.setString(4, tel);
            stmt.setString(5, email);
            stmt.setString(6, cnpj);
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
    
    public boolean alterarSenha(String senhaConfirmacao, String novaSenha, String cnpj) throws SQLException {

        try {
            PreparedStatement stmt = this.con.
                    prepareStatement("select senha from instituicao where cnpj=?");
      
            stmt.setString(1, cnpj);
            System.out.println("setString");
            
            
            ResultSet rs = stmt.executeQuery();
            System.out.println("executou rs");

            String senha="";
            while(rs.next()){
                senha = rs.getString("senha");
            }

            if (senha.equals(senhaConfirmacao)) {
                String sql = "update instituicao set senha=? where cnpj=?";
                PreparedStatement stmt2 = con.prepareStatement(sql);
                stmt2.setString(1, novaSenha);
                stmt2.setString(2, cnpj);
                stmt2.execute();

                if (stmt2.executeUpdate() == 1) {
                    return true;
                }
                stmt2.close();
            }else{
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public void excluir(Instituicao instituicao) {
        try {
            PreparedStatement stmt = con.prepareStatement("delete "
                    + "from instituicao where cnpj=?");
            stmt.setString(1, instituicao.getCnpj());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List recuperarTodos() {
        try {
            List<Instituicao> instituicaoList = new ArrayList<>();
            PreparedStatement stmt = this.con.
                    prepareStatement("select * from instituicao");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Instituicao instituicao = new Instituicao();
                instituicao.setNome(rs.getString("nome"));
                instituicao.setEndereco(rs.getString("endereco"));
                instituicao.setDescricao(rs.getString("descricao"));
                instituicao.setCnpj(rs.getString("cnpj"));
                instituicao.setTel(rs.getString("tel"));
                instituicao.setEmail(rs.getString("email"));
                instituicao.setSenha(rs.getString("senha"));

                // adicionando o objeto à lista
                instituicaoList.add(instituicao);
            }
            rs.close();
            stmt.close();
            return instituicaoList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Instituicao recuperar(String cnpj) {
        try {
            List<Instituicao> instituicaoList = new ArrayList<Instituicao>();
            PreparedStatement stmt = this.con.
                    prepareStatement("select * from instituicao where cnpj=?");
            stmt.setString(1, cnpj);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Instituicao instituicao = new Instituicao();
                instituicao.setNome(rs.getString("nome"));
                instituicao.setEndereco(rs.getString("endereco"));
                instituicao.setDescricao(rs.getString("descricao"));
                instituicao.setCnpj(rs.getString("cnpj"));
                instituicao.setTel(rs.getString("tel"));
                instituicao.setEmail(rs.getString("email"));
                instituicaoList.add(instituicao);
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
            return instituicaoList.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
