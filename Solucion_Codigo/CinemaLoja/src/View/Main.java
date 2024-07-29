import controller.CinemaController;
import view.CinemaView;

public class Main {
    public static void main(String[] args) {
        CinemaController controller = new CinemaController();
        CinemaView view = new CinemaView(controller);

        view.mostrarPeliculas();
        view.mostrarSnacks();
        view.mostrarPromocionesSnacks();
        view.crearVenta();
    }
}
