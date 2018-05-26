package persistencia;

import modelo.Direccion;
import modelo.Alumno;
import modelo.Maestro;
import java.util.Collection;
import controlador.DireccionFacade;
import persistencia.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "direccionController")
@ViewScoped
public class DireccionController extends AbstractController<Direccion> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isAlumnoCollectionEmpty;
    private boolean isMaestroCollectionEmpty;

    public DireccionController() {
        // Inform the Abstract parent controller of the concrete Direccion Entity
        super(Direccion.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsAlumnoCollectionEmpty();
        this.setIsMaestroCollectionEmpty();
    }

    public boolean getIsAlumnoCollectionEmpty() {
        return this.isAlumnoCollectionEmpty;
    }

    private void setIsAlumnoCollectionEmpty() {
        Direccion selected = this.getSelected();
        if (selected != null) {
            DireccionFacade ejbFacade = (DireccionFacade) this.getFacade();
            this.isAlumnoCollectionEmpty = ejbFacade.isAlumnoCollectionEmpty(selected);
        } else {
            this.isAlumnoCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Alumno entities that are
     * retrieved from Direccion and returns the navigation outcome.
     *
     * @return navigation outcome for Alumno page
     */
    public String navigateAlumnoCollection() {
        Direccion selected = this.getSelected();
        if (selected != null) {
            DireccionFacade ejbFacade = (DireccionFacade) this.getFacade();
            Collection<Alumno> selectedAlumnoCollection = ejbFacade.findAlumnoCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Alumno_items", selectedAlumnoCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/alumno/index";
    }

    public boolean getIsMaestroCollectionEmpty() {
        return this.isMaestroCollectionEmpty;
    }

    private void setIsMaestroCollectionEmpty() {
        Direccion selected = this.getSelected();
        if (selected != null) {
            DireccionFacade ejbFacade = (DireccionFacade) this.getFacade();
            this.isMaestroCollectionEmpty = ejbFacade.isMaestroCollectionEmpty(selected);
        } else {
            this.isMaestroCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Maestro entities that are
     * retrieved from Direccion and returns the navigation outcome.
     *
     * @return navigation outcome for Maestro page
     */
    public String navigateMaestroCollection() {
        Direccion selected = this.getSelected();
        if (selected != null) {
            DireccionFacade ejbFacade = (DireccionFacade) this.getFacade();
            Collection<Maestro> selectedMaestroCollection = ejbFacade.findMaestroCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Maestro_items", selectedMaestroCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/maestro/index";
    }

}
