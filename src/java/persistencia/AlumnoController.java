package persistencia;

import modelo.Alumno;
import modelo.AlumnoClase;
import java.util.Collection;
import controlador.AlumnoFacade;
import persistencia.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "alumnoController")
@ViewScoped
public class AlumnoController extends AbstractController<Alumno> {

    @Inject
    private DireccionController idDireccionController;
    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isAlumnoClaseCollectionEmpty;

    public AlumnoController() {
        // Inform the Abstract parent controller of the concrete Alumno Entity
        super(Alumno.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idDireccionController.setSelected(null);
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
        Alumno selected = this.getSelected();
        if (selected != null) {
            AlumnoFacade ejbFacade = (AlumnoFacade) this.getFacade();
            this.isAlumnoClaseCollectionEmpty = ejbFacade.isAlumnoClaseCollectionEmpty(selected);
        } else {
            this.isAlumnoClaseCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of AlumnoClase entities that
     * are retrieved from Alumno and returns the navigation outcome.
     *
     * @return navigation outcome for AlumnoClase page
     */
    public String navigateAlumnoClaseCollection() {
        Alumno selected = this.getSelected();
        if (selected != null) {
            AlumnoFacade ejbFacade = (AlumnoFacade) this.getFacade();
            Collection<AlumnoClase> selectedAlumnoClaseCollection = ejbFacade.findAlumnoClaseCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AlumnoClase_items", selectedAlumnoClaseCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/alumnoClase/index";
    }

    /**
     * Sets the "selected" attribute of the Direccion controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdDireccion(ActionEvent event) {
        Alumno selected = this.getSelected();
        if (selected != null && idDireccionController.getSelected() == null) {
            idDireccionController.setSelected(selected.getIdDireccion());
        }
    }

}
