/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.controlador;

import EJB.MenuFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import practica1.modelo.Menu;
import practica1.modelo.Usuario;

/**
 *
 * @author Perico
 */

@Named
@SessionScoped

public class PlantillaController implements Serializable{
    
    private MenuModel modelo;
    
    @EJB
    private MenuFacadeLocal menuEJB;
    
    @PostConstruct
    public void init(){
        cargarMenu();
    }
    
    public void comprobarPrivilegios(){
        Usuario user = new Usuario();
        
        
        user = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        if(user==null){ 
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/publico/error.xhtml?faces-redirect=true");

            }catch (IOException ex) {
                System.out.println("Error al redireccionar");
            }
        }
    }
    
    public void cargarMenu(){
        
        String contexto = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
        
        modelo = new DefaultMenuModel();
        
        List<Menu> listaMenus;
        Usuario usuario = new Usuario();
        
        usuario=(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
        listaMenus = menuEJB.obtenerMenusUsuario(usuario);
        //listaMenus = menuEJB.findAll();

        for(Menu m:listaMenus){
            if(m.getPasswordUsuario().equals("S")){//getPasswordUsuario es igual a getTipo()
                DefaultSubMenu firstSubMenu = new DefaultSubMenu(m.getNombreMenu());
                for(Menu sub:listaMenus){
                    if(sub.getMenu() != null){
                        if(m.getIdMenu() == sub.getMenu().getIdMenu() && (sub.getPasswordUsuario().equals("I"))){
                            DefaultMenuItem item = new DefaultMenuItem(sub.getNombreMenu());
                            item.setUrl(contexto + sub.getUrlMenu());
                            firstSubMenu.addElement(item);
                        }
                    }
                }
                modelo.addElement(firstSubMenu);
            }else{
                if(m.getMenu()==null){
                    DefaultMenuItem item = new DefaultMenuItem(m.getNombreMenu());  
                    item.setUrl(contexto + m.getUrlMenu());
                    modelo.addElement(item);
                }
            }
            
        }
        
    }

    public MenuModel getModelo() {
        return modelo;
    }

    public void setModelo(MenuModel modelo) {
        this.modelo = modelo;
    }

    public MenuFacadeLocal getMenuEJB() {
        return menuEJB;
    }

    public void setMenuEJB(MenuFacadeLocal menuEJB) {
        this.menuEJB = menuEJB;
    }
    
    public void cerrarSesion(){
        String contexto = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        try{

            FacesContext.getCurrentInstance().getExternalContext().redirect(contexto + "/index.softwareII");
        }catch(Exception e){
            System.out.println("Error al cerrar la sesión" + e.getMessage());
        }
    }
    
}
