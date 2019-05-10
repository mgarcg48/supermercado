/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.controlador;

import EJB.PersonaFacadeLocal;
import EJB.RolFacadeLocal;
import EJB.UsuarioFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import practica1.modelo.Persona;
import practica1.modelo.Rol;
import practica1.modelo.Usuario;

/**
 *
 * @author Perico
 */

@Named
@ViewScoped

public class AltaUsuarioController implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    @EJB
    private PersonaFacadeLocal personaEJB;
    @EJB
    private RolFacadeLocal rolEJB;
    
    @Inject
    private Usuario usuario;
    
    @Inject
    private Persona persona;
    
    @Inject
    private Rol rol;
    
    private List<String> listaDeTipos;
    private String tipoSeleccionado;
    private List<Rol> listaDeRoles;
   
    @PostConstruct
    public void init(){
        // Con inyect sobra usuario=new Usuario();
        //persona=new Persona();
        //rol=new Rol();
        listaDeRoles = rolEJB.findAll();
        listaDeTipos = new <String>ArrayList();
        
        for(Rol r:listaDeRoles){
            listaDeTipos.add(r.getDescripcionRol());
        }
    }

     public void registrarUsuario(){
        try{
            
            for(Rol r:listaDeRoles){
                if(r.getDescripcionRol().equals(tipoSeleccionado)){
                    rol=r;
                }
            }
            usuario.setRol(rol);
            usuario.setPersona(persona);
            if(!usuarioEJB.existeUsuario(usuario.getUserUsuario())){
                usuarioEJB.create(usuario);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Usuario registrado correctamente"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Nick de usuario ya en "));
            }
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Error al dar de alta usuario"));
        }
        
    }
     
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<String> getListaDeTipos() {
        return listaDeTipos;
    }

    public void setListaDeTipos(List<String> listaDeTipos) {
        this.listaDeTipos = listaDeTipos;
    }

    public String getTipoSeleccionado() {
        return tipoSeleccionado;
    }

    public void setTipoSeleccionado(String tipoSeleccionado) {
        this.tipoSeleccionado = tipoSeleccionado;
    }

    public List<Rol> getListaDeRoles() {
        return listaDeRoles;
    }

    public void setListaDeRoles(List<Rol> listaDeRoles) {
        this.listaDeRoles = listaDeRoles;
    }

    public UsuarioFacadeLocal getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuarioFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }

    public PersonaFacadeLocal getPersonaEJB() {
        return personaEJB;
    }

    public void setPersonaEJB(PersonaFacadeLocal personaEJB) {
        this.personaEJB = personaEJB;
    }

    public RolFacadeLocal getRolEJB() {
        return rolEJB;
    }

    public void setRolEJB(RolFacadeLocal rolEJB) {
        this.rolEJB = rolEJB;
    }
    
    
    
}
