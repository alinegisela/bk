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
import negocio.StatusEnum;

/**
 *
 * @author Penguin
 */
public class InstituicaoDAO {
    private static InstituicaoDAO myself = null;
    private Connection con;
    
    
    public InstituicaoDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public static InstituicaoDAO getInstance() {
        if (myself == null) {
            myself = new InstituicaoDAO();
        }
        
        return myself;
    }
    
    
    public boolean inserir(String nome, String endereco, String descricao, String cnpj, String tel, String email) {
        try {
            PreparedStatement insereInstituicaoSTM = null;
            String insereInstituicaoSQL = "insert into instituicao (nome, endereco, descricao, cnpj, tel, email)"
                    + "values (?,?,?,?,?,?)";
            
            insereInstituicaoSTM = con.prepareStatement(insereInstituicaoSQL);
            
            insereInstituicaoSTM.setString(1, nome);
            insereInstituicaoSTM.setString(2, endereco);
            insereInstituicaoSTM.setString(3, descricao);
            insereInstituicaoSTM.setString(4, cnpj);
            insereInstituicaoSTM.setString(5,  tel);
            insereInstituicaoSTM.setString(6,  email);
            
            
            if (insereInstituicaoSTM.executeUpdate() == 1) {
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public boolean alterar(String nome, String endereco, String descricao, String cnpj, String tel, String email) {
        
        String sql = "update instituicao set nome=?, endereco=?, descricao=?, cnpj=?, tel=?, email=? where nome=nome";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, endereco);
            stmt.setString(3, descricao);
            stmt.setString(4, cnpj);
            stmt.setString(5,  tel);
            stmt.setString(6,  email);
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
            List<Instituicao> instituicaoList = new ArrayList<Instituicao>();
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
