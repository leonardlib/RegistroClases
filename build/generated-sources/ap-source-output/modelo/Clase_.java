package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.AlumnoClase;
import modelo.Maestro;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-26T01:52:00")
@StaticMetamodel(Clase.class)
public class Clase_ { 

    public static volatile SingularAttribute<Clase, String> descripcion;
    public static volatile CollectionAttribute<Clase, AlumnoClase> alumnoClaseCollection;
    public static volatile SingularAttribute<Clase, Date> fechaHora;
    public static volatile SingularAttribute<Clase, Maestro> idMaestro;
    public static volatile SingularAttribute<Clase, Integer> id;
    public static volatile SingularAttribute<Clase, String> nombre;

}