package persistencia;

import modelo.AlumnoClase;
import controlador.AlumnoClaseFacade;
import persistencia.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "alumnoClaseController")
@ViewScoped
public class AlumnoClaseController extends AbstractController<AlumnoClase> {

    @Inject
    private AlumnoController idAlumnoController;
    @Inject
    private ClaseController idClaseController;
    @Inject
    private MobilePageController mobilePageController;

    public AlumnoClaseController() {
        // Inform the Abstract parent controller of the concrete AlumnoClase Entity
        super(AlumnoClase.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idAlumnoController.setSelected(null);
        idClaseController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Alumno controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdAlumno(ActionEvent event) {
        AlumnoClase selected = this.getSelected();
        if (selected != null && idAlumnoController.getSelected() == null) {
            idAlumnoController.setSelected(selected.getIdAlumno());
        }
    }

    /**
     * Sets the "selected" attribute of the Clase controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdClase(ActionEvent event) {
        AlumnoClase selected = this.getSelected();
        if (selected != null && idClaseController.getSelected() == null) {
            idClaseController.setSelected(selected.getIdClase());
        }
    }

}
