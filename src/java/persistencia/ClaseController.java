package persistencia;

import modelo.Clase;
import modelo.AlumnoClase;
import java.util.Collection;
import controlador.ClaseFacade;
import persistencia.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "claseController")
@ViewScoped
public class ClaseController extends AbstractController<Clase> {

    @Inject
    private MaestroController idMaestroController;
    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isAlumnoClaseCollectionEmpty;

    public ClaseController() {
        // Inform the Abstract parent controller of the concrete Clase Entity
        super(Clase.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idMaestroController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsAlumnoClaseCollectionEmpty();
    }

    public boolean getIsAlumnoClaseCollectionEmpty() {
        return this.isAlumnoClaseCollectionEmpty;
    }

    private void setIsAlumnoClaseCollectionEmpty() {
        Clase selected = this.getSelected();
        if (selected != null) {
            ClaseFacade ejbFacade = (ClaseFacade) this.getFacade();
            this.isAlumnoClaseCollectionEmpty = ejbFacade.isAlumnoClaseCollectionEmpty(selected);
        } else {
            this.isAlumnoClaseCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of AlumnoClase entities that
     * are retrieved from Clase and returns the navigation outcome.
     *
     * @return navigation outcome for AlumnoClase page
     */
    public String navigateAlumnoClaseCollection() {
        Clase selected = this.getSelected();
        if (selected != null) {
            ClaseFacade ejbFacade = (ClaseFacade) this.getFacade();
            Collection<AlumnoClase> selectedAlumnoClaseCollection = ejbFacade.findAlumnoClaseCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AlumnoClase_items", selectedAlumnoClaseCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/alumnoClase/index";
    }

    /**
     * Sets the "selected" attribute of the Maestro controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMaestro(ActionEvent event) {
        Clase selected = this.getSelected();
        if (selected != null && idMaestroController.getSelected() == null) {
            idMaestroController.setSelected(selected.getIdMaestro());
        }
    }

}
