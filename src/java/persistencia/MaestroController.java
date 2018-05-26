package persistencia;

import modelo.Maestro;
import modelo.Clase;
import java.util.Collection;
import controlador.MaestroFacade;
import persistencia.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "maestroController")
@ViewScoped
public class MaestroController extends AbstractController<Maestro> {

    @Inject
    private DireccionController idDireccionController;
    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isClaseCollectionEmpty;

    public MaestroController() {
        // Inform the Abstract parent controller of the concrete Maestro Entity
        super(Maestro.class);
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
        this.setIsClaseCollectionEmpty();
    }

    /**
     * Sets the "selected" attribute of the Direccion controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdDireccion(ActionEvent event) {
        Maestro selected = this.getSelected();
        if (selected != null && idDireccionController.getSelected() == null) {
            idDireccionController.setSelected(selected.getIdDireccion());
        }
    }

    public boolean getIsClaseCollectionEmpty() {
        return this.isClaseCollectionEmpty;
    }

    private void setIsClaseCollectionEmpty() {
        Maestro selected = this.getSelected();
        if (selected != null) {
            MaestroFacade ejbFacade = (MaestroFacade) this.getFacade();
            this.isClaseCollectionEmpty = ejbFacade.isClaseCollectionEmpty(selected);
        } else {
            this.isClaseCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Clase entities that are
     * retrieved from Maestro and returns the navigation outcome.
     *
     * @return navigation outcome for Clase page
     */
    public String navigateClaseCollection() {
        Maestro selected = this.getSelected();
        if (selected != null) {
            MaestroFacade ejbFacade = (MaestroFacade) this.getFacade();
            Collection<Clase> selectedClaseCollection = ejbFacade.findClaseCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Clase_items", selectedClaseCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/clase/index";
    }

}
