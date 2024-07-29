package view;

import controller.CinemaController;
import modell.Pelicula;
import modell.Snack;
import modell.PromocionSnack;
import modell.SnackVenta;
import modell.RegistroVenta;
import modell.Boleto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CinemaView {
    private CinemaController controller;
    private Scanner scanner;

    public CinemaView(CinemaController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarPeliculas() {
        List<Pelicula> peliculas = controller.obtenerPeliculas();
        System.out.println("Peliculas:");
        for (Pelicula pelicula : peliculas) {
            System.out.println("ID: " + pelicula.getId() +
                               ", Nombre: " + pelicula.getNombre() +
                               ", Precio: " + pelicula.getPrecio() +
                               ", Horario: " + pelicula.getHorario());
        }
    }

    public void mostrarSnacks() {
        List<Snack> snacks = controller.obtenerSnacks();
        System.out.println("Snacks:");
        for (Snack snack : snacks) {
            System.out.println("ID: " + snack.getId() +
                               ", Nombre: " + snack.getNombre() +
                               ", Precio: " + snack.getPrecio());
        }
    }

    public void mostrarPromocionesSnacks() {
        List<PromocionSnack> promociones = controller.obtenerPromocionesSnacks();
        System.out.println("Promociones de Snacks:");
        for (PromocionSnack promocion : promociones) {
            System.out.println("ID: " + promocion.getId() +
                               ", Snack: " + promocion.getSnack().getNombre() +
                               ", Descuento: " + promocion.getDescuento());
        }
    }

    public void crearVenta() {
        System.out.println("Ingrese ID de la pelicula:");
        int peliculaId = scanner.nextInt();
        Pelicula pelicula = controller.obtenerPeliculas().stream()
            .filter(p -> p.getId() == peliculaId)
            .findFirst()
            .orElse(null);

        if (pelicula == null) {
            System.out.println("Pelicula no encontrada.");
            return;
        }

        System.out.println("Ingrese horario de la película:");
        String horario = scanner.next();

        System.out.println("Ingrese cantidad de boletos:");
        int cantidad = scanner.nextInt();

        System.out.println("Seleccione snacks (ID y cantidad, separarlos con un"
                + " espacio). Para terminar, ingrese 0:");
        List<SnackVenta> snacksVendidos = new ArrayList<>();
        while (true) {
            int snackId = scanner.nextInt();
            if (snackId == 0) break;
            int snackCantidad = scanner.nextInt();
            Snack snack = controller.obtenerSnacks().stream()
                .filter(s -> s.getId() == snackId)
                .findFirst()
                .orElse(null);

            if (snack == null) {
                System.out.println("Snack no encontrado.");
                continue;
            }

            snacksVendidos.add(new SnackVenta(snack, snackCantidad));
        }

        RegistroVenta venta = controller.crearRegistroVenta(1, pelicula, horario,
                cantidad, snacksVendidos);
        System.out.println("Venta creada con exito. Detalles:");
        System.out.println("Pelicula: " + venta.getBoleto().getPelicula().getNombre() +
                           ", Horario: " + venta.getBoleto().getPelicula().getHorario() +
                           ", Cantidad de boletos: " + venta.getBoleto().getPrecio() +
                           ", Precio total: " + venta.getPrecioTotal());
        for (SnackVenta snackVenta : venta.getSnacksVendidos()) {
            System.out.println("Snack: " + snackVenta.getSnack().getNombre() +
                               ", Cantidad: " + snackVenta.getCantidad());
        }
    }
}
