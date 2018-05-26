package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Clase;
import modelo.Direccion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-26T01:52:00")
@StaticMetamodel(Maestro.class)
public class Maestro_ { 

    public static volatile SingularAttribute<Maestro, String> apellidos;
    public static volatile SingularAttribute<Maestro, Direccion> idDireccion;
    public static volatile SingularAttribute<Maestro, String> correo;
    public static volatile CollectionAttribute<Maestro, Clase> claseCollection;
    public static volatile SingularAttribute<Maestro, Integer> id;
    public static volatile SingularAttribute<Maestro, String> telefono;
    public static volatile SingularAttribute<Maestro, String> nombre;

}