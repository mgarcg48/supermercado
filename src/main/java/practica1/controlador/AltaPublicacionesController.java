/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.controlador;

import EJB.CategoriaFacadeLocal;
import EJB.PersonaFacadeLocal;
import EJB.PublicacionFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import practica1.modelo.Categoria;
import practica1.modelo.Persona;
import practica1.modelo.Publicacion;

/**
 *
 * @author Perico
 */
public class AltaPublicacionesController {
    
    @EJB
    private PublicacionFacadeLocal publicacionEJB;
    
    @EJB
    private PersonaFacadeLocal personaEJB;
    
    @EJB
    private CategoriaFacadeLocal categoriaEJB;
    
    @Inject
    private Publicacion publicacion;
    
    @Inject
    private Persona persona;
        
    @Inject
    private Categoria categoria;
    
    @PostConstruct
    public void init(){
        
    }
    
    public void registrarPublicacion(){
        try{
            publicacion.setPersona(persona);
            publicacion.setCategoria(categoria);
            publicacionEJB.create(publicacion);
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Error al insertar la publicación"));

        }
    }
}
