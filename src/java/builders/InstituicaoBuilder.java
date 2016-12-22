/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;

import java.util.List;
import negocio.Doacao;
import negocio.Instituicao;
import negocio.MaterialDoacao;

/**
 *
 * @author Penguin
 */
public class InstituicaoBuilder {

    private String nome;
    private String endereco;
    private String descricao;
    private String cnpj;
    private String tel;
    private String email;
    private List<MaterialDoacao> prioridades;
    //private List<Doacao> historicoDoacoes;

    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<MaterialDoacao> getPrioridades() {
		return prioridades;
	}

	public void setPrioridades(List<MaterialDoacao> prioridades) {
		this.prioridades = prioridades;
	}

        /*
	public List<Doacao> getHistoricoDoacoes() {
		return historicoDoacoes;
	}

	public void setHistoricoDoacoes(List<Doacao> historicoDoacoes) {
		this.historicoDoacoes = historicoDoacoes;
	}
        */
        public Instituicao build(){
            return new Instituicao(nome, endereco, descricao, cnpj, tel, email);
        }
}
