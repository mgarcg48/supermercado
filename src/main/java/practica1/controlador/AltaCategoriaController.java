/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.controlador;

import EJB.CategoriaFacadeLocal;
import EJB.MenuFacadeLocal;
import EJB.RolFacadeLocal;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import practica1.modelo.Categoria;
import practica1.modelo.Menu;
import practica1.modelo.Rol;

/**
 *
 * @author Perico
 */

@Named
@ViewScoped

public class AltaCategoriaController implements Serializable{
    
    @EJB
    private CategoriaFacadeLocal categoriaEJB;
    
    @EJB
    private MenuFacadeLocal menuEJB;
    
    @EJB
    private RolFacadeLocal rolEJB;
    
    //@Inject
    private Categoria categoria;
    private Menu menu;
    private Rol rol;

    private String value;
 
    public String getValue() {
        return value;
    }
 
    public void setValue(String value) {
        this.value = value;
    }
    
    public MenuFacadeLocal getMenuEJB() {
        return menuEJB;
    }

    public void setMenuEJB(MenuFacadeLocal menuEJB) {
        this.menuEJB = menuEJB;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
    @PostConstruct
    public void init(){
        setCategoria(new Categoria()); 
        setMenu(new Menu());
        setRol(new Rol());
    }
    
    public void crearCategoria(){
        try{
            categoriaEJB.create(categoria);
        }catch(Exception e){
            System.out.println("Error al crear la categoría");
        }
        
    }
    
    public void crearNombreMenu(){
        try{
            getMenuEJB().create(getMenu());
        }catch(Exception e){
            System.out.println("Error al crear el menu");
        }
        
    }
    
     public void crearRol(){
        try{
            getRolEJB().create(getRol());
        }catch(Exception e){
            System.out.println("Error al crear el Rol");
        }
        
    }

    /**
     * @return the categoriaEJB
     */
    public CategoriaFacadeLocal getCategoriaEJB() {
        return categoriaEJB;
    }

    /**
     * @param categoriaEJB the categoriaEJB to set
     */
    public void setCategoriaEJB(CategoriaFacadeLocal categoriaEJB) {
        this.categoriaEJB = categoriaEJB;
    }

    /**
     * @return the cat
     */
    public Categoria getCat() {
        return getCategoria();
    }

    /**
     * @param cat the cat to set
     */
    public void setCat(Categoria cat) {
        this.setCategoria(cat);
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public RolFacadeLocal getRolEJB() {
        return rolEJB;
    }

    public void setRolEJB(RolFacadeLocal rolEJB) {
        this.rolEJB = rolEJB;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.categoriaEJB);
        hash = 13 * hash + Objects.hashCode(this.menuEJB);
        hash = 13 * hash + Objects.hashCode(this.rolEJB);
        hash = 13 * hash + Objects.hashCode(this.categoria);
        hash = 13 * hash + Objects.hashCode(this.menu);
        hash = 13 * hash + Objects.hashCode(this.rol);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AltaCategoriaController other = (AltaCategoriaController) obj;
        if (!Objects.equals(this.categoriaEJB, other.categoriaEJB)) {
            return false;
        }
        if (!Objects.equals(this.menuEJB, other.menuEJB)) {
            return false;
        }
        if (!Objects.equals(this.rolEJB, other.rolEJB)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.menu, other.menu)) {
            return false;
        }
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        return true;
    }
    
    
}
