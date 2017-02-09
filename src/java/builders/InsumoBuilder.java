/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import negocio.Insumo;

/**
 *
 * @author Penguin
 */
@ManagedBean(name = "bInsumo")
@RequestScoped
public class InsumoBuilder {
     private int codigo;
     private String nome;
     private String tipo;
     private String descricao;
     private boolean prioridade;

    public boolean isPrioridade() {
        return prioridade;
    }

    public void setPrioridade(boolean prioridade) {
        this.prioridade = prioridade;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Insumo build(){
        return new Insumo(codigo, nome, tipo, descricao);
    }
}
