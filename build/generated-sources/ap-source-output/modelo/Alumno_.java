package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.AlumnoClase;
import modelo.Direccion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-26T01:52:00")
@StaticMetamodel(Alumno.class)
public class Alumno_ { 

    public static volatile SingularAttribute<Alumno, String> apellidos;
    public static volatile CollectionAttribute<Alumno, AlumnoClase> alumnoClaseCollection;
    public static volatile SingularAttribute<Alumno, Direccion> idDireccion;
    public static volatile SingularAttribute<Alumno, Integer> numeroControl;
    public static volatile SingularAttribute<Alumno, String> correo;
    public static volatile SingularAttribute<Alumno, Integer> id;
    public static volatile SingularAttribute<Alumno, String> telefono;
    public static volatile SingularAttribute<Alumno, String> nombre;

}