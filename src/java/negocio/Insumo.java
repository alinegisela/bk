package negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Insumo {

    @Column(length = 50)
    @Id
    private int codigo;
    @Column(length = 50)
    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoEnum tipo;
    @Column(length = 50)
    private String descricao;

    @Override
    public String toString() {
        return "Insumo - \nCódigo: " + codigo + "\nNome: " + nome + "\nTipo: " + tipo + "\nDescrição: " + descricao + "\n";
    }

    public Insumo(int codigo, String nome, TipoEnum tipo, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    @Deprecated
    public Insumo() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoEnum tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
