/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Alumno;
import modelo.Alumno_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.AlumnoClase;
import modelo.Direccion;

/**
 *
 * @author leonardolirabecerra
 */
@Stateless
public class AlumnoFacade extends AbstractFacade<Alumno> {

    @PersistenceContext(unitName = "RegistroClases2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlumnoFacade() {
        super(Alumno.class);
    }

    public boolean isAlumnoClaseCollectionEmpty(Alumno entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Alumno> alumno = cq.from(Alumno.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(alumno, entity), cb.isNotEmpty(alumno.get(Alumno_.alumnoClaseCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<AlumnoClase> findAlumnoClaseCollection(Alumno entity) {
        Alumno mergedEntity = this.getMergedEntity(entity);
        Collection<AlumnoClase> alumnoClaseCollection = mergedEntity.getAlumnoClaseCollection();
        alumnoClaseCollection.size();
        return alumnoClaseCollection;
    }

    public boolean isIdDireccionEmpty(Alumno entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Alumno> alumno = cq.from(Alumno.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(alumno, entity), cb.isNotNull(alumno.get(Alumno_.idDireccion)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Direccion findIdDireccion(Alumno entity) {
        return this.getMergedEntity(entity).getIdDireccion();
    }
    
}
