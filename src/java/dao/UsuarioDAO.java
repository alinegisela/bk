package dao;

import Conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import negocio.Doador;
import negocio.Instituicao;
import negocio.Usuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Penguin
 */
public class UsuarioDAO {

    private static UsuarioDAO myself = null;
    private Connection con;

    public UsuarioDAO() {
        try {
            this.con = new ConnectionFactory().getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static UsuarioDAO getInstance() throws ClassNotFoundException {
        if (myself == null) {
            myself = new UsuarioDAO();
        }

        return myself;
    }

    public Object logar(String email, String senha) throws ClassNotFoundException, SQLException {
        if (logarDoador(email, senha) != null) {
            return logarDoador(email, senha);
        }
        return null;
    }

    public Doador logarDoador(String email, String senha) throws SQLException {
        try {
            List<Doador> doadorList = new ArrayList<>();
            PreparedStatement stmt = this.con.
                    prepareStatement("select * from doador where email=? and senha=?");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Doador user = new Doador();
                user.setNome(rs.getString("nome"));
                user.setCpf(rs.getString("cpf"));
                user.setEndereco(rs.getString("endereco"));
                user.setTelefone(rs.getString("telefone"));
                user.setEmail(rs.getString("email"));
                user.setSenha(rs.getString("senha"));

                doadorList.add(user);
            }

            rs.close();
            stmt.close();
            if (doadorList.isEmpty()) {
                throw new NoResultException();
            } else {
                return doadorList.get(0);
            }

        } catch (NoResultException e) {
            return null;
        }
    }
    
    public Instituicao logarInstituicao(String email, String senha) throws SQLException {
        try {
            List<Instituicao> instituicaoList = new ArrayList<>();
            PreparedStatement stmt = this.con.
                    prepareStatement("select * from instituicao where email=? and senha=?");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Instituicao user = new Instituicao();
                user.setNome(rs.getString("nome"));
                user.setEndereco(rs.getString("endereco"));
                user.setDescricao(rs.getString("descricao"));
                user.setCnpj(rs.getString("cnpj"));
                user.setTel(rs.getString("tel"));
                user.setEmail(rs.getString("email"));
                user.setSenha(rs.getString("senha"));

                instituicaoList.add(user);
            }

            rs.close();
            stmt.close();
            if (instituicaoList.isEmpty()) {
                throw new NoResultException();
            } else {
                return instituicaoList.get(0);
            }

        } catch (NoResultException e) {
            return null;
        }
    }
}
