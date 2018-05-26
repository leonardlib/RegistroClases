/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.AlumnoClase;
import modelo.AlumnoClase_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Alumno;
import modelo.Clase;

/**
 *
 * @author leonardolirabecerra
 */
@Stateless
public class AlumnoClaseFacade extends AbstractFacade<AlumnoClase> {

    @PersistenceContext(unitName = "RegistroClases2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlumnoClaseFacade() {
        super(AlumnoClase.class);
    }

    public boolean isIdAlumnoEmpty(AlumnoClase entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<AlumnoClase> alumnoClase = cq.from(AlumnoClase.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(alumnoClase, entity), cb.isNotNull(alumnoClase.get(AlumnoClase_.idAlumno)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Alumno findIdAlumno(AlumnoClase entity) {
        return this.getMergedEntity(entity).getIdAlumno();
    }

    public boolean isIdClaseEmpty(AlumnoClase entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<AlumnoClase> alumnoClase = cq.from(AlumnoClase.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(alumnoClase, entity), cb.isNotNull(alumnoClase.get(AlumnoClase_.idClase)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Clase findIdClase(AlumnoClase entity) {
        return this.getMergedEntity(entity).getIdClase();
    }
    
}
