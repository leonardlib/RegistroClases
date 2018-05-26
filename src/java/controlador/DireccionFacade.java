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
import modelo.Direccion;
import modelo.Direccion_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Alumno;
import modelo.Maestro;

/**
 *
 * @author leonardolirabecerra
 */
@Stateless
public class DireccionFacade extends AbstractFacade<Direccion> {

    @PersistenceContext(unitName = "RegistroClases2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DireccionFacade() {
        super(Direccion.class);
    }

    public boolean isAlumnoCollectionEmpty(Direccion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Direccion> direccion = cq.from(Direccion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(direccion, entity), cb.isNotEmpty(direccion.get(Direccion_.alumnoCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Alumno> findAlumnoCollection(Direccion entity) {
        Direccion mergedEntity = this.getMergedEntity(entity);
        Collection<Alumno> alumnoCollection = mergedEntity.getAlumnoCollection();
        alumnoCollection.size();
        return alumnoCollection;
    }

    public boolean isMaestroCollectionEmpty(Direccion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Direccion> direccion = cq.from(Direccion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(direccion, entity), cb.isNotEmpty(direccion.get(Direccion_.maestroCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Maestro> findMaestroCollection(Direccion entity) {
        Direccion mergedEntity = this.getMergedEntity(entity);
        Collection<Maestro> maestroCollection = mergedEntity.getMaestroCollection();
        maestroCollection.size();
        return maestroCollection;
    }
    
}
