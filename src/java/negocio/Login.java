package negocio;


import controladores.DoadorControlador;
import controladores.InstituicaoControlador;
import dao.UsuarioDAO;
import filtro.SessionUtils;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Penguin
 */
@ManagedBean
@SessionScoped
public class Login implements Serializable{

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Usuario usuario = new Usuario();
    private Doador doador = new Doador();
    private Instituicao instituicao = new Instituicao();
    private DoadorControlador doadorControlador = new DoadorControlador();
    private InstituicaoControlador instituicaoControlador = new InstituicaoControlador();

    public String enviaDoador() throws ClassNotFoundException, SQLException {

        doador = usuarioDAO.logarDoador(usuario.getEmail(), usuario.getSenha());

        if (doador == null) {
            doador = new Doador();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha !",
                            "Erro no Login!"));
            return null;
        } else {
        
            HttpSession session = SessionUtils.getSession();
	session.setAttribute("username", this.doador.getEmail());
        doadorControlador.setDoadorSelecionado(doador);
            return "/perfilDoador.xhtml";
        }
    }

    public String enviaInstituicao() throws ClassNotFoundException, SQLException {

        instituicao = usuarioDAO.logarInstituicao(usuario.getEmail(), usuario.getSenha());

        if (instituicao == null) {
            instituicao = new Instituicao();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email ou senha incorretos!",
                            "Erro no Login!"));
            return null;
        } else {
            HttpSession session = SessionUtils.getSession();
	session.setAttribute("username", this.instituicao.getEmail());
        instituicaoControlador.setInstituicaoSelecionada(instituicao);
            return "/perfilInstituicao.xhtml";
        }
    }
    
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "home.xhtml";
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    
    
}
