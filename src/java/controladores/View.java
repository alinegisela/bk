/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import negocio.Login;

/**
 *
 * @author Penguin
 */
@ManagedBean (name="View")
@SessionScoped
public class View  implements Serializable{

    private String urlAnterior;

    public String getUrlAnterior() {
        Login l = new Login();
        if(l.getDoador().getNome() != null && !(l.getDoador().getNome().equals(""))){
            return "perfilDoador";
        }else if (l.getInstituicao().getNome() != null  && !(l.getInstituicao().getNome().equals(""))){
            return "perfilInstituicao";
        }

        return "home";
    }

    public void setUrlAnterior() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().
                getExternalContext().getRequest();
        //urlAnterior = request.getRequestURL().toString();
        urlAnterior = request.getRequestURI();

    }

}
