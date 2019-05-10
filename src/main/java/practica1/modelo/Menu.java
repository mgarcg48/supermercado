/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.modelo;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Perico
 */

@Entity
@Table(name="menus")

public class Menu {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idMenu;
    
    @Column(name="Nombre")
    private String nombreMenu;

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }
    
    @Column(name="Tipo")
    private String passwordUsuario;
        
    @Column(name="Estado")
    private boolean estado;
    
    @Column(name="url")
    private String urlMenu;
    
    @JoinColumn(name="idRol")
    @ManyToOne
    private Rol rol;
    
    @JoinColumn(name="idMenu_Menu")
    @ManyToOne
    private Menu menu;

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public void setUrlMenu(String urlMenu) {
        this.urlMenu = urlMenu;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public String getUrlMenu() {
        return urlMenu;
    }

    public Rol getRol() {
        return rol;
    }

    public Menu getMenu() {
        return menu;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.idMenu;
        hash = 17 * hash + Objects.hashCode(this.nombreMenu);
        hash = 17 * hash + Objects.hashCode(this.passwordUsuario);
        hash = 17 * hash + (this.estado ? 1 : 0);
        hash = 17 * hash + Objects.hashCode(this.urlMenu);
        hash = 17 * hash + Objects.hashCode(this.rol);
        hash = 17 * hash + Objects.hashCode(this.menu);
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
        final Menu other = (Menu) obj;
        if (this.idMenu != other.idMenu) {
            return false;
        }
        if (!Objects.equals(this.nombreMenu, other.nombreMenu)) {
            return false;
        }
        if (!Objects.equals(this.passwordUsuario, other.passwordUsuario)) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.urlMenu, other.urlMenu)) {
            return false;
        }
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        if (!Objects.equals(this.menu, other.menu)) {
            return false;
        }
        return true;
    }
    
    
}
