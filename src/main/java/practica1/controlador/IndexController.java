/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.controlador;

import EJB.UsuarioFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import practica1.modelo.Usuario;

/**
 *
 * @author Perico
 */
@Named
@ViewScoped


public class IndexController implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;

    public UsuarioFacadeLocal getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuarioFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Inject
    private Usuario usuario;
    
    public String comprobarUsuario(){
        String direccion="";
        
        try{
            usuario = usuarioEJB.obtenerUsuario(usuario);
            
            if(usuario==null){
                direccion="publico/error.xhtml?faces-redirect=true";
            }else{
                direccion="privado/principal.xhtml?faces-redirect=true";
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
            }
            
        }catch(Exception e){
            System.out.println("Error al comprobar el usuario en la data base");
        }
        
        return direccion;
    }
}
