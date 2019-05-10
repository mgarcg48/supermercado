/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.modelo;

import java.io.Serializable;
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
@Table(name="personas")

public class Persona implements Serializable{
       @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idPersona;
    
    @Column(name="Nombre")
    private String nombrePersona;
    
    @Column(name="Apellido1")
    private String apellido1Persona;
    
    @Column(name="Apellido2")
    private String apellido2Persona;
    
    @Column(name="Sexo")
    private String sexoPersona;
    
    @Column(name="FechaNacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimientoPersona;

    /**
     * @return the idPersona
     */
    public int getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * @return the nombrePersona
     */
    public String getNombrePersona() {
        return nombrePersona;
    }

    /**
     * @param nombrePersona the nombrePersona to set
     */
    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    /**
     * @return the apellido1Persona
     */
    public String getApellido1Persona() {
        return apellido1Persona;
    }

    /**
     * @param apellido1Persona the apellido1Persona to set
     */
    public void setApellido1Persona(String apellido1Persona) {
        this.apellido1Persona = apellido1Persona;
    }

    /**
     * @return the apellido2Persona
     */
    public String getApellido2Persona() {
        return apellido2Persona;
    }

    /**
     * @param apellido2Persona the apellido2Persona to set
     */
    public void setApellido2Persona(String apellido2Persona) {
        this.apellido2Persona = apellido2Persona;
    }

    /**
     * @return the sexoPersona
     */
    public String getSexoPersona() {
        return sexoPersona;
    }

    /**
     * @param sexoPersona the sexoPersona to set
     */
    public void setSexoPersona(String sexoPersona) {
        this.sexoPersona = sexoPersona;
    }

    /**
     * @return the fechaNacimientoPersona
     */
    public Date getFechaNacimientoPersona() {
        return fechaNacimientoPersona;
    }

    /**
     * @param fechaNacimientoPersona the fechaNacimientoPersona to set
     */
    public void setFechaNacimientoPersona(Date fechaNacimientoPersona) {
        this.fechaNacimientoPersona = fechaNacimientoPersona;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idPersona;
        hash = 89 * hash + Objects.hashCode(this.nombrePersona);
        hash = 89 * hash + Objects.hashCode(this.apellido1Persona);
        hash = 89 * hash + Objects.hashCode(this.apellido2Persona);
        hash = 89 * hash + Objects.hashCode(this.sexoPersona);
        hash = 89 * hash + Objects.hashCode(this.fechaNacimientoPersona);
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
        final Persona other = (Persona) obj;
        if (this.idPersona != other.idPersona) {
            return false;
        }
        if (!Objects.equals(this.nombrePersona, other.nombrePersona)) {
            return false;
        }
        if (!Objects.equals(this.apellido1Persona, other.apellido1Persona)) {
            return false;
        }
        if (!Objects.equals(this.apellido2Persona, other.apellido2Persona)) {
            return false;
        }
        if (!Objects.equals(this.sexoPersona, other.sexoPersona)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimientoPersona, other.fechaNacimientoPersona)) {
            return false;
        }
        return true;
    }

    
}
