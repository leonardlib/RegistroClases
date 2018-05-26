/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leonardolirabecerra
 */
@Entity
@Table(name = "alumno_clase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlumnoClase.findAll", query = "SELECT a FROM AlumnoClase a")
    , @NamedQuery(name = "AlumnoClase.findById", query = "SELECT a FROM AlumnoClase a WHERE a.id = :id")
    , @NamedQuery(name = "AlumnoClase.findByFechaInscripcion", query = "SELECT a FROM AlumnoClase a WHERE a.fechaInscripcion = :fechaInscripcion")})
public class AlumnoClase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inscripcion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInscripcion;
    @JoinColumn(name = "id_alumno", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Alumno idAlumno;
    @JoinColumn(name = "id_clase", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clase idClase;

    public AlumnoClase() {
    }

    public AlumnoClase(Integer id) {
        this.id = id;
    }

    public AlumnoClase(Integer id, Date fechaInscripcion) {
        this.id = id;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Clase getIdClase() {
        return idClase;
    }

    public void setIdClase(Clase idClase) {
        this.idClase = idClase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumnoClase)) {
            return false;
        }
        AlumnoClase other = (AlumnoClase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.AlumnoClase[ id=" + id + " ]";
    }
    
}
