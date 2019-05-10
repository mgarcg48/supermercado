/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
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
@Table(name="usuarios")

public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idUsuario;
    
    @Column(name="User")
    private String userUsuario;
    
    @Column(name="Password")
    private String passwordUsuario;
        
    @Column(name="UltimaConexion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaConexionUsuario;
    
    @Column(name="Estado")
    private Boolean estadoUsuario=true;
    
    //Si no pongo nullable empieza en 0
    @JoinColumn(name="idPersona", nullable=false)
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Persona persona;
    
    //@Transient  si quiero crear un atributo que no se corresponda con la base de datos. Se suele utilizar para logs
    
    @JoinColumn(name="idRol")
    @ManyToOne
    private Rol rol;

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getUserUsuario() {
        return userUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public Date getUltimaConexionUsuario() {
        return ultimaConexionUsuario;
    }

    public Boolean getEstadoUsuario() {
        return estadoUsuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public Rol getRol() {
        return rol;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setUserUsuario(String userUsuario) {
        this.userUsuario = userUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public void setUltimaConexionUsuario(Date ultimaConexionUsuario) {
        this.ultimaConexionUsuario = ultimaConexionUsuario;
    }

    public void setEstadoUsuario(Boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.idUsuario;
        hash = 53 * hash + Objects.hashCode(this.passwordUsuario);
        hash = 53 * hash + Objects.hashCode(this.ultimaConexionUsuario);
        hash = 53 * hash + Objects.hashCode(this.estadoUsuario);
        hash = 53 * hash + Objects.hashCode(this.persona);
        hash = 53 * hash + Objects.hashCode(this.rol);
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
        final Usuario other = (Usuario) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.userUsuario != other.userUsuario) {
            return false;
        }
        if (!Objects.equals(this.passwordUsuario, other.passwordUsuario)) {
            return false;
        }
        if (!Objects.equals(this.ultimaConexionUsuario, other.ultimaConexionUsuario)) {
            return false;
        }
        if (!Objects.equals(this.estadoUsuario, other.estadoUsuario)) {
            return false;
        }
        if (!Objects.equals(this.persona, other.persona)) {
            return false;
        }
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
}
