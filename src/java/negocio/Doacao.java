/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dao.DoadorDAO;
import dao.InstituicaoDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Penguin
 */
public class Doacao {

    private int codigo;//automatico
    
    private Doador doador;//do sistema
    private Instituicao instituicao;

    private String status;//do sistema

    private Date dataDoacao;//do sistema 
    private Date dataVisita;

    private int day ;
    
    private List<MaterialDoacao> doacao;

    private String cpf;
    private String cnpj;

    public Doacao(int codigo, Doador doador, Instituicao instituicao, String status, Date dataDoacao, Date dataVisita, int day) {
        this.codigo = codigo;
        this.doador = doador;
        this.instituicao = instituicao;
        //this.materialDoacao = materialDoacao;
        this.status = status;
        this.dataDoacao = dataDoacao;
        this.dataVisita = dataVisita;
        this.day = day;
        this.doacao = new ArrayList<>();
    }

    @Deprecated
    public Doacao() {
    }

    public int getDay() {
        return this.dataVisita.getDate();
    }

    public void setDay(int day) {
        this.day = day;
    }

    
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getStatusenum() {
        return status;
    }

    public void setStatusenum(String status) {
        this.status = status;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador d) throws ClassNotFoundException {

        this.doador = d;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao i) throws ClassNotFoundException {
        this.instituicao = i;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataDoacaoString() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(dataDoacao);
    }

    public void setDataDoacao(Date dataDoacao) {
        this.dataDoacao = dataDoacao;
     
    }
    
    public int getDay(Date date){
        return date.getDay();
    }

    public Date getDataDoacao(){
        return dataDoacao;
    }
    
    public String getDataVisitaString() {
       SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(dataVisita);
    }
    
    public Date getDataVisita(){
        return dataVisita;
    }

    public void setDataVisita(Date dataVisita) {
        this.dataVisita = dataVisita;
    }

    public List<MaterialDoacao> getDoacao() {
        return doacao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {

        this.cpf = cpf;
    }

    public void setDoacao(List<MaterialDoacao> doacao) {
        this.doacao = doacao;
    }

    public void criar() throws ClassNotFoundException {
        this.setDoador(DoadorDAO.getInstance().recuperar(cpf));
        this.setInstituicao(InstituicaoDAO.getInstance().recuperar(cnpj));

    }

    @Override
    public String toString() {
        return "Doacao{" + "código=" + codigo + "doador=" + doador + ", instituicao=" + instituicao + ", status=" + status + ", dataDoacao=" + dataDoacao + ", dataVisita=" + dataVisita + ", doacao=" + doacao + '}';
    }

}
