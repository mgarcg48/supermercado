/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Perico
 */

@Entity
@Table(name="roles")

public class Rol implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idRol;
    
    //insertable no funcionara con los datos primitivos(boolean) de java
    @Column(name="TipoUsuario")
    private char tipoUsuarioRol;
    //QUITAR EL ROL AL FINAL
    
    @Column(name="Descripcion")
    private String descripcionRol;

    public int getIdRol() {
        return idRol;
    }

    public char getTipoUsuarioRol() {
        return tipoUsuarioRol;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public void setTipoUsuarioRol(char tipoUsuarioRol) {
        this.tipoUsuarioRol = tipoUsuarioRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idRol;
        hash = 59 * hash + this.tipoUsuarioRol;
        hash = 59 * hash + Objects.hashCode(this.descripcionRol);
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
        final Rol other = (Rol) obj;
        if (this.idRol != other.idRol) {
            return false;
        }
        if (this.tipoUsuarioRol != other.tipoUsuarioRol) {
            return false;
        }
        if (!Objects.equals(this.descripcionRol, other.descripcionRol)) {
            return false;
        }
        return true;
    }
    
    
}
