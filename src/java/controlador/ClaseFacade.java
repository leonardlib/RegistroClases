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
import modelo.Clase;
import modelo.Clase_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.AlumnoClase;
import modelo.Maestro;

/**
 *
 * @author leonardolirabecerra
 */
@Stateless
public class ClaseFacade extends AbstractFacade<Clase> {

    @PersistenceContext(unitName = "RegistroClases2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClaseFacade() {
        super(Clase.class);
    }

    public boolean isAlumnoClaseCollectionEmpty(Clase entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Clase> clase = cq.from(Clase.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(clase, entity), cb.isNotEmpty(clase.get(Clase_.alumnoClaseCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<AlumnoClase> findAlumnoClaseCollection(Clase entity) {
        Clase mergedEntity = this.getMergedEntity(entity);
        Collection<AlumnoClase> alumnoClaseCollection = mergedEntity.getAlumnoClaseCollection();
        alumnoClaseCollection.size();
        return alumnoClaseCollection;
    }

    public boolean isIdMaestroEmpty(Clase entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Clase> clase = cq.from(Clase.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(clase, entity), cb.isNotNull(clase.get(Clase_.idMaestro)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Maestro findIdMaestro(Clase entity) {
        return this.getMergedEntity(entity).getIdMaestro();
    }
    
}
