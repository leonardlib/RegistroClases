package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Alumno;
import modelo.Maestro;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-26T01:52:00")
@StaticMetamodel(Direccion.class)
public class Direccion_ { 

    public static volatile CollectionAttribute<Direccion, Alumno> alumnoCollection;
    public static volatile SingularAttribute<Direccion, String> estado;
    public static volatile SingularAttribute<Direccion, String> numero;
    public static volatile SingularAttribute<Direccion, String> ciudad;
    public static volatile SingularAttribute<Direccion, String> calle;
    public static volatile SingularAttribute<Direccion, Integer> id;
    public static volatile CollectionAttribute<Direccion, Maestro> maestroCollection;
    public static volatile SingularAttribute<Direccion, String> colonia;

}