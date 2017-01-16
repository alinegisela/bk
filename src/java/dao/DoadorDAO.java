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
import negocio.Doador;
import negocio.Instituicao;
import negocio.StatusEnum;

/**
 *
 * @author Penguin
 */
public class DoadorDAO{
    
    private static DoadorDAO myself = null;
    private Connection con;
    
    public DoadorDAO() throws ClassNotFoundException {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public static DoadorDAO getInstance() throws ClassNotFoundException {
        if (myself == null) {
            myself = new DoadorDAO();
        }
        
        return myself;
    }

    //Funcionannndooooooooooo
    
    public boolean inserir(String nome, String cpf, String endereco, String telefone, String email, String senha) {
        try {
            PreparedStatement insereDoadorSTM = null;
            String insereDoadorSQL = "insert into doador (nome, cpf, endereco, telefone, email, senha)"
                    + "values (?,?,?,?,?,?)";
            
            insereDoadorSTM = con.prepareStatement(insereDoadorSQL);
            
            insereDoadorSTM.setString(1, nome);
            insereDoadorSTM.setString(2, cpf);
            insereDoadorSTM.setString(3, endereco);
            insereDoadorSTM.setString(4, telefone);
            insereDoadorSTM.setString(5, email);
            insereDoadorSTM.setString(6, senha);
            
            if (insereDoadorSTM.executeUpdate() == 1) {
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public boolean alterar(String nome, String endereco, String telefone, String email, String cpf) {
        
        String sql = "update doador set nome=?, endereco=?, telefone=?,email=? where cpf=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, endereco);
            /*stmt.setDate(4, new Date(contato.getDataNascimento()
                 .getTimeInMillis()));*/
            stmt.setString(3, telefone);
            stmt.setString(4, email);
            stmt.setString(5, cpf);
            
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
    
    
    public void excluir(Doador doador) {
        try {
            PreparedStatement stmt = con.prepareStatement("delete "
                    + "from doador where cpf=?");
            stmt.setString(1, doador.getCpf());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public List recuperarTodos() {
        try {
            List<Doador> doadorList = new ArrayList<Doador>();
            PreparedStatement stmt = this.con.
                    prepareStatement("select * from doador");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Contato
                Doador doador = new Doador();
                doador.setNome(rs.getString("nome"));
                doador.setCpf(rs.getString("cpf"));
                doador.setEndereco(rs.getString("endereco"));
                doador.setTelefone(rs.getString("telefone"));
                doador.setEmail(rs.getString("email"));

                /*
                // montando a data através do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);
                 */
                // adicionando o objeto à lista
                doadorList.add(doador);
            }
            rs.close();
            stmt.close();
            return doadorList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public Doador recuperar(String cpf) {
        try {
            List<Doador> doadorList = new ArrayList<Doador>();
            PreparedStatement stmt = this.con.
                    prepareStatement("select * from doador where cpf=?");
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Contato
                Doador doador = new Doador();
                doador.setNome(rs.getString("nome"));
                doador.setCpf(rs.getString("cpf"));
                doador.setEndereco(rs.getString("endereco"));
                doador.setTelefone(rs.getString("telefone"));
                doador.setEmail(rs.getString("email"));
                doadorList.add(doador);
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
            return doadorList.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
    public boolean inserir(int codigo, Doador doador, Instituicao instituicao, StatusEnum status, Date dataDoacao, Date dataVisita) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
