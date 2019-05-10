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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

@Entity
@Table(name="categorias")

/**
 *
 * @author Perico
 */


public class Publicacion implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idPublicacion;
    
    @Column(name="Titulo")
    private String tituloPublicacion;
    
    @Column(name="Cuerpo")
    private String cuerpoPublicacion;
    
    @Column(name="ComentarioProfesor")
    private String comentarioProfesorPublicacion;
    
    @Column(name="Valoracion")
    private int valoracionPublicacion;
    
    @Column(name="Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPublicaciones;

    @JoinColumn(name="idPersona")
    @ManyToOne
    private Persona persona;
    
    @JoinColumn(name="idCategoria")
    private Categoria categoria;

    /**
     * @return the idPublicacion
     */
    public int getIdPublicacion() {
        return idPublicacion;
    }

    /**
     * @param idPublicacion the idPublicacion to set
     */
    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    /**
     * @return the tituloPublicacion
     */
    public String getTituloPublicacion() {
        return tituloPublicacion;
    }

    /**
     * @param tituloPublicacion the tituloPublicacion to set
     */
    public void setTituloPublicacion(String tituloPublicacion) {
        this.tituloPublicacion = tituloPublicacion;
    }

    /**
     * @return the cuerpoPublicacion
     */
    public String getCuerpoPublicacion() {
        return cuerpoPublicacion;
    }

    /**
     * @param cuerpoPublicacion the cuerpoPublicacion to set
     */
    public void setCuerpoPublicacion(String cuerpoPublicacion) {
        this.cuerpoPublicacion = cuerpoPublicacion;
    }

    /**
     * @return the comentarioProfesorPublicacion
     */
    public String getComentarioProfesorPublicacion() {
        return comentarioProfesorPublicacion;
    }

    /**
     * @param comentarioProfesorPublicacion the comentarioProfesorPublicacion to set
     */
    public void setComentarioProfesorPublicacion(String comentarioProfesorPublicacion) {
        this.comentarioProfesorPublicacion = comentarioProfesorPublicacion;
    }

    /**
     * @return the valoracionPublicacion
     */
    public int getValoracionPublicacion() {
        return valoracionPublicacion;
    }

    /**
     * @param valoracionPublicacion the valoracionPublicacion to set
     */
    public void setValoracionPublicacion(int valoracionPublicacion) {
        this.valoracionPublicacion = valoracionPublicacion;
    }

    /**
     * @return the fechaPublicaciones
     */
    public Date getFechaPublicaciones() {
        return fechaPublicaciones;
    }

    /**
     * @param fechaPublicaciones the fechaPublicaciones to set
     */
    public void setFechaPublicaciones(Date fechaPublicaciones) {
        this.fechaPublicaciones = fechaPublicaciones;
    }

    /**
     * @return the persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idPublicacion;
        hash = 47 * hash + Objects.hashCode(this.tituloPublicacion);
        hash = 47 * hash + Objects.hashCode(this.cuerpoPublicacion);
        hash = 47 * hash + Objects.hashCode(this.comentarioProfesorPublicacion);
        hash = 47 * hash + this.valoracionPublicacion;
        hash = 47 * hash + Objects.hashCode(this.fechaPublicaciones);
        hash = 47 * hash + Objects.hashCode(this.persona);
        hash = 47 * hash + Objects.hashCode(this.categoria);
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
        final Publicacion other = (Publicacion) obj;
        if (this.idPublicacion != other.idPublicacion) {
            return false;
        }
        if (!Objects.equals(this.tituloPublicacion, other.tituloPublicacion)) {
            return false;
        }
        if (!Objects.equals(this.cuerpoPublicacion, other.cuerpoPublicacion)) {
            return false;
        }
        if (!Objects.equals(this.comentarioProfesorPublicacion, other.comentarioProfesorPublicacion)) {
            return false;
        }
        if (this.valoracionPublicacion != other.valoracionPublicacion) {
            return false;
        }
        if (!Objects.equals(this.fechaPublicaciones, other.fechaPublicaciones)) {
            return false;
        }
        if (!Objects.equals(this.persona, other.persona)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        return true;
    }

    
}
