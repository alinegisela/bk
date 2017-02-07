/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import builders.InsumoBuilder;
import builders.MaterialBuilder;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import negocio.Doador;
import negocio.Instituicao;
import negocio.Insumo;
import negocio.Login;
import negocio.MaterialDoacao;
import repositorios.DoadorRepositorio;
import repositorios.InstituicaoRepositorio;
import repositorios.RepositorioGenerico;

/**
 *
 * @author Penguin
 */
@ManagedBean(name = "cInstituicao")
@SessionScoped
public class InstituicaoControlador implements Serializable{

    private RepositorioGenerico<Instituicao> instituicaoRepositorio = null;
    private Instituicao instituicaoSelecionada;
    private  List<Insumo> insumoTodos;

    public InstituicaoControlador() {
        this.instituicaoRepositorio = new InstituicaoRepositorio();
    }

    public List<Insumo> getMateriaisRec() {
        return insumoTodos;
    }

    public void setMateriaisRec(List<Insumo> materiaisRec) {
        this.insumoTodos = materiaisRec;
    }
    
    

    public void inserirMaterial(MaterialDoacao m) {
        //  this.getInstituicaoSelecionada().getPrioridades().add(m);
        new MaterialControlador().inserir(m, this.instituicaoSelecionada.getCnpj());

    }
    
     public String checar(Instituicao d){
        boolean checar = this.instituicaoRepositorio.checar(d);
        
        if(checar){
           return inserir(d);
        }else{
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cnpj ou email inseridos já estão cadastrados"));
        }
        return "CadastroInstituicao";
    }

    public String addLista() throws ClassNotFoundException {
        /* for(MaterialDoacao m : getInstituicaoSelecionada().getPrioridades()){
            inserirMaterial(m);
        }*/
        MaterialControlador mc = new MaterialControlador();
        MaterialBuilder mb = new MaterialBuilder();
        for (Insumo i : getInstituicaoSelecionada().getPrioridadesInsumo()) {
            mb.setPrioridade(true);
            mc.inserir(mb.build(i.getCodigo(), true), getInstituicaoSelecionada().getCnpj());
            System.out.println("inserido");
        }
         FacesContext.getCurrentInstance().
                
                addMessage(null, new FacesMessage("Cadastro concluído com sucesso!"));
        return "cadastroConcluido.xhtml";
    }

    public String addLista2() throws ClassNotFoundException {
        /* for(MaterialDoacao m : getInstituicaoSelecionada().getPrioridades()){
            inserirMaterial(m);
        }*/
        
        MaterialControlador mc = new MaterialControlador();
        MaterialBuilder mb = new MaterialBuilder();
        
        //deletar materiais existentes em table 'material' e 'instituicao_material'
        mc.deletarTodos(getInstituicaoSelecionada().getCnpj());
        
        System.out.println("antes do for");
        for (Insumo i : this.getInstituicaoSelecionada().getPrioridadesInsumo()) {
            mb.setPrioridade(true);
            mc.inserir(mb.build(i.getCodigo(), true), getInstituicaoSelecionada().getCnpj());
            System.out.println("inserido");
        }
        return "perfilInstituicao.xhtml";
    }
    
    public String alterarMateriais(Instituicao insLogada) throws ClassNotFoundException {
        this.setInstituicaoSelecionada(insLogada);
       insumoTodos = new InsumoControlador().recuperarTodos();
       
       
       // List<MaterialDoacao> materiaisInst = new Login().getInstituicao().getPrioridades();
        List<MaterialDoacao> materiaisInst = recuperarMateriais(new Login().getInstituicao().getCnpj());
       
        for (int i = 0; i < materiaisInst.size(); i++) {
            for (Insumo ins : insumoTodos) {
                System.out.println();
                if(ins.getCodigo() == materiaisInst.get(i).getInsumo().getCodigo()){
                    int codigo = ins.getCodigo();
                    String nome = ins.getNome();
                    String tipo = ins.getTipo();
                    String descricao = ins.getDescricao();
                    
                    Insumo insumo = new Insumo(codigo, nome, tipo, descricao);
                    insumo.setPrioridadeString("Sim");
                    insumoTodos.add(insumo);
                    insumoTodos.remove(ins);
                     ins.setTipo( "dg");
                }
            }
        }
        
        setMateriaisRec(insumoTodos);

        return "AlterarInstituicao";

    }
    
    public String alterarSenha(Instituicao d){
       boolean confirmacao =  this.instituicaoRepositorio.alterarSenha(d);
       
       if(confirmacao){
           
        FacesContext.getCurrentInstance().addMessage(null, 
                 new FacesMessage("Sua senha foi alterada"));
       
       return "perfilInstituicao.xhtml";
       }else{
           FacesContext.getCurrentInstance().addMessage(null, 
                 new FacesMessage("Senha incorreta!"));
           return "alterarSenhaInstituicao.xhtml";
       }
    }

    public RepositorioGenerico<Instituicao> getInstituicaoRepositorio() {
        return instituicaoRepositorio;
    }

    public void setInstituicaoRepositorio(RepositorioGenerico<Instituicao> instituicaoRepositorio) {
        this.instituicaoRepositorio = instituicaoRepositorio;
    }

    public Instituicao getInstituicaoSelecionada() {
        return instituicaoSelecionada;
    }

    public String setInstituicaoSelecionada(Instituicao instituicaoSelecionada) {
        this.instituicaoSelecionada = instituicaoSelecionada;
        return "visualizarInstituicao.xhtml";
    }

    public List<MaterialDoacao> recuperarMateriais(String cnpj) {
        return this.instituicaoRepositorio.recuperarMateriais(cnpj);
    }

    public String inserir(Instituicao d) {
        this.instituicaoRepositorio.inserir(d);
        this.instituicaoSelecionada = d;

        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("Cadastro concluído com sucesso!"));

        this.setInstituicaoSelecionada(d);
        return "CadastroMaterial.xhtml";
    }

    public String alterar(Instituicao d) throws ClassNotFoundException {
        if(this.getInstituicaoSelecionada().getPrioridadesInsumo().isEmpty()){
            FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("Escolha pelo menos um material de prioridade"));
            return "AlterarInstituicao";
        }
        this.instituicaoRepositorio.alterar(d);
        addLista2();
        /*
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Sucesso o animal " + d.getNome() + " foi alterado com sucesso!!"));
*/
        return "perfilInstituicao.xhtml";
    }

    public Instituicao recuperar(String codigo) {
        return this.instituicaoRepositorio.recuperar(codigo);
    }

    public void deletar(Instituicao d) {
        this.instituicaoRepositorio.excluir(d);
    }

    public List<Instituicao> recuperarTodos() {
        return this.instituicaoRepositorio.recuperarTodos();
    }
}
