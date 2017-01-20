package negocio;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import negocio.Doacao;
import negocio.MaterialDoacao;

public class Instituicao {

    private String nome;
    private String endereco;
    private String descricao;
    private String cnpj;
    private String tel;
    private String email;
    private String senha;
    private ArrayList<MaterialDoacao> prioridades = new ArrayList<>();

    public Instituicao(String nome, String endereco, String descricao, String cnpj, String tel,
            String email, String senha/*, List prioridades, List historicoDoacoes*/) {
        this.nome = nome;
        this.endereco = endereco;
        this.descricao = descricao;
        this.cnpj = cnpj;
        this.tel = tel;
        this.email = email;
        this.senha = senha;
        this.prioridades = new ArrayList<>();
    }

    public Instituicao() {

    }

    @Override
    public String toString() {
        return "Instituicao " + nome + "\nEndere�o: " + endereco + "\nDescricao: " + descricao + "\nCnpj: " + cnpj
                + "\nTelefone: " + tel + "\nEmail: " + email + "\n";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public ArrayList<MaterialDoacao> getPrioridades() {
        return prioridades;
    }

    public void setPrioridades(ArrayList<MaterialDoacao> prioridades) {
        this.prioridades = prioridades;
    }

}
