/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import negocio.Doacao;
import negocio.Doador;
import negocio.Instituicao;
import negocio.StatusEnum;

/**
 *
 * @author Penguin
 */
public interface DaoGenerico<T> {

    public boolean inserir(String nome, String cpf, String endereco, String telefone, String email);

    public void excluir(Doacao doacao);

    public boolean alterar(int codigo, Doador doador, Instituicao instituicao, StatusEnum status, Date dataDoacao, Date dataVisita);

    public boolean inserir(int codigo, Doador doador, Instituicao instituicao,/*MaterialDoacao materialDoacao, */ StatusEnum status, Date dataDoacao, Date dataVisita);

    public boolean alterar(String nome, String cpf, String endereco, String telefone, String email);

    public void excluir(Doador doador);

    public List recuperarTodos();

    public T recuperar(String cpf);
}
