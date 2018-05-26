package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Alumno;
import modelo.Clase;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-26T01:52:00")
@StaticMetamodel(AlumnoClase.class)
public class AlumnoClase_ { 

    public static volatile SingularAttribute<AlumnoClase, Alumno> idAlumno;
    public static volatile SingularAttribute<AlumnoClase, Clase> idClase;
    public static volatile SingularAttribute<AlumnoClase, Integer> id;
    public static volatile SingularAttribute<AlumnoClase, Date> fechaInscripcion;

}