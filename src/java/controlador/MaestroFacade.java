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
import modelo.Maestro;
import modelo.Maestro_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Direccion;
import modelo.Clase;

/**
 *
 * @author leonardolirabecerra
 */
@Stateless
public class MaestroFacade extends AbstractFacade<Maestro> {

    @PersistenceContext(unitName = "RegistroClases2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaestroFacade() {
        super(Maestro.class);
    }

    public boolean isIdDireccionEmpty(Maestro entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Maestro> maestro = cq.from(Maestro.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(maestro, entity), cb.isNotNull(maestro.get(Maestro_.idDireccion)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Direccion findIdDireccion(Maestro entity) {
        return this.getMergedEntity(entity).getIdDireccion();
    }

    public boolean isClaseCollectionEmpty(Maestro entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Maestro> maestro = cq.from(Maestro.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(maestro, entity), cb.isNotEmpty(maestro.get(Maestro_.claseCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Clase> findClaseCollection(Maestro entity) {
        Maestro mergedEntity = this.getMergedEntity(entity);
        Collection<Clase> claseCollection = mergedEntity.getClaseCollection();
        claseCollection.size();
        return claseCollection;
    }
    
}
