/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.MaterialDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import negocio.Doacao;
import negocio.Doador;
import negocio.Instituicao;
import negocio.MaterialDoacao;
import repositorios.DoacaoRepositorio;
import repositorios.MaterialRepositorio;
import repositorios.RepositorioGenerico;

/**
 *
 * @author Penguin
 */
@ManagedBean(name = "cDoacao")
@SessionScoped
public class DoacaoControlador implements Serializable {

    private RepositorioGenerico<Doacao> doacaoRepositorio = null;
    private Doacao doacaoSelecionada;
    private List<MaterialDoacao> materiais = new ArrayList<>();
    
    String aguardando_confirmacao = "Aguardando confirmação";
    String em_andamento = "Em andamento";
    String concluida = "Concluída";

    private Date dataAtual;
    SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy");

    public String getDataAtual() {
        return formato.format(dataAtual);
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }

    public String getAguardando_confirmacao() {
        return aguardando_confirmacao;
    }

    public void setAguardando_confirmacao(String aguardando_confirmacao) {
        this.aguardando_confirmacao = aguardando_confirmacao;
    }

    public String getEm_andamento() {
        return em_andamento;
    }

    public void setEm_andamento(String em_andamento) {
        this.em_andamento = em_andamento;
    }

    public String getConcluida() {
        return concluida;
    }

    public void setConcluida(String concluida) {
        this.concluida = concluida;
    }
    
    

    public List<MaterialDoacao> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<MaterialDoacao> materiais) {
        this.materiais = materiais;
    }

    // private List<Doador> doadores
    public DoacaoControlador() {
        this.doacaoRepositorio = new DoacaoRepositorio();
    }

    public RepositorioGenerico<Doacao> getDoacaoRepositorio() {
        return doacaoRepositorio;
    }

    public void setDoacaoRepositorio(RepositorioGenerico<Doacao> doacaoRepositorio) {
        this.doacaoRepositorio = doacaoRepositorio;
    }

    public Doacao getDoacaoSelecionada() throws ClassNotFoundException {
        // doacaoSelecionada.setDoador(new Doador());
        // doacaoSelecionada.setInstituicao(new Instituicao());
        // doacaoSelecionada.criar();
        return doacaoSelecionada;
    }

    public String setDoacaoSelecionada(Doacao doacaoSelecionada) {
        this.doacaoSelecionada = doacaoSelecionada;

        return "visualizarDoacao.xhtml";
    }
    
    public String setDoacaoEmAberto(Doacao doacao){
        this.setDoacaoSelecionada(doacao);
        return "visualizarDoacoesEmAberto";
    }
    
    public String setDoacaoEmAberto2(Doacao doacao){
        this.setDoacaoSelecionada(doacao);
        return "visualizarDoacoesEmAndamento";
    }
    
    public String setDoacaoEmAberto3(Doacao doacao){
        this.setDoacaoSelecionada(doacao);
        return "visualizarDoacoesConcluidas";
    }

    public String inserir(Doacao d, List materiais) {
        this.doacaoRepositorio.inserir(d, materiais);

        //(ControladorLogin)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("controladorLogin");
      /*  FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("Cadastro concluído com sucesso!"));
*/
        return "ApresentarDoacao.xhtml";
    }

    public void alterar(Doacao d) {
        this.doacaoRepositorio.alterar(d);
        /*
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Sucessoo animal " + d.getCodigo() + " foi alterado com sucesso!!"));
*/
        // return "ApresentaAnimal.xhtml";
    }
    
    public String alterarStatus(String status, int codigo){
        this.doacaoRepositorio.alterarStatus(status, codigo);
        /*
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(""));
        */
        return "doacoesInstituicao";
    }

    public String alterarStatus2(String status, int codigo){
        this.doacaoRepositorio.alterarStatus(status, codigo);
        
        /*
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(""));
        */
       return "historicoInstituicao";
    }
    
    public Doacao recuperar(int codigo) {
        return this.doacaoRepositorio.recuperar(codigo);
    }

    public void deletar(Doacao d) {
        this.doacaoRepositorio.excluir(d);
    }

    public List<Doacao> recuperarTodos() {
        return this.doacaoRepositorio.recuperarTodos();
    }

    public List<Doacao> recuperarTodosDoador(String cpf) {
        return this.doacaoRepositorio.recuperarTodosDoador(cpf);
    }

    public List recuperarTodosDoacao(int codigo) {

        return this.doacaoRepositorio.recuperarTodosDoacao(codigo);

    }

    public List<Doacao> recuperarPorStatus(String status, String cnpj){
//        String status = "Aguardando confirmação";
         return this.doacaoRepositorio.recuperarPorStatus(status, cnpj);
    }
}
