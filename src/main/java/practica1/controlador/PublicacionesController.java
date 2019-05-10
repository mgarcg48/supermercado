/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.controlador;

import EJB.PublicacionFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import practica1.modelo.Publicacion;

/**
 *
 * @author Perico
 */

@Named
@ViewScoped

public class PublicacionesController implements Serializable{
    
    private List<Publicacion> listaPublicaciones;
    
    @EJB
    private PublicacionFacadeLocal publicacionEJB;
    
    @PostConstruct
    public void init(){
        
        listaPublicaciones = publicacionEJB.findAll();
    }

    public List<Publicacion> getListaPublicaciones() {
        return listaPublicaciones;
    }

    public void setListaPublicaciones(List<Publicacion> listaPublicaciones) {
        this.listaPublicaciones = listaPublicaciones;
    }

    public PublicacionFacadeLocal getPublicacionEJB() {
        return publicacionEJB;
    }

    public void setPublicacionEJB(PublicacionFacadeLocal publicacionEJB) {
        this.publicacionEJB = publicacionEJB;
    }
    
    
}
