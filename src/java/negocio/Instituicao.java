package negocio;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import negocio.Doacao;
import negocio.MaterialDoacao;

@Entity
@Table
public class Instituicao {

    @Column(length = 50)
    private String nome;
    @Column(length = 50)
    private String endereco;
    @Column(length = 50)
    private String descricao;
    @Id
    @Column(length = 50)
    private String cnpj;
    @Column(length = 50)
    private String tel;
    @Column(length = 50)
    private String email;
    @OneToMany
    @JoinColumn(name = "material_doacao_id")
    private List<MaterialDoacao> prioridades;
    @OneToMany
    @JoinColumn(name = "doacao_id")
    private List<Doacao> historicoDoacoes;

    public Instituicao(String nome, String endereco, String descricao, String cnpj, String tel,
            String email/*, List prioridades, List historicoDoacoes*/) {
        this.nome = nome;
        this.endereco = endereco;
        this.descricao = descricao;
        this.cnpj = cnpj;
        this.tel = tel;
        this.email = email;
        this.prioridades = new ArrayList<>();
        this.historicoDoacoes = new ArrayList<>();
    }

    @Deprecated
    public Instituicao(){
        
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

    public List<Doacao> getHistoricoDoacoes() {
        return historicoDoacoes;
    }

    public void setHistoricoDoacoes(List<Doacao> historicoDoacoes) {
        this.historicoDoacoes = historicoDoacoes;
    }
}
