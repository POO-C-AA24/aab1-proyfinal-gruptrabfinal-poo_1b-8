package controller;

import modell.Pelicula;
import modell.Snack;
import modell.PromocionSnack;
import modell.Boleto;
import modell.RegistroVenta;
import modell.SnackVenta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CinemaController {
    private List<Pelicula> peliculas;
    private List<Snack> snacks;
    private List<PromocionSnack> promocionesSnacks;

    public CinemaController() {
        peliculas = new ArrayList<>();
        snacks = new ArrayList<>();
        promocionesSnacks = new ArrayList<>();
        
  
        inicializarDatos();
    }

    private void inicializarDatos() {
        // Crear y agregar películas
        Pelicula pelicula1 = new Pelicula();
        pelicula1.setId(1);
        pelicula1.setNombre("Deadpool");
        pelicula1.setPrecio(10.0);
        pelicula1.setHorario("18:00");
        peliculas.add(pelicula1);

        Pelicula pelicula2 = new Pelicula();
        pelicula2.setId(2);
        pelicula2.setNombre("Intensamente 2");
        pelicula2.setPrecio(12.0);
        pelicula2.setHorario("20:00");
        peliculas.add(pelicula2);

        
        Snack snack1 = new Snack();
        snack1.setId(1);
        snack1.setNombre("Palomitas");
        snack1.setPrecio(5.0);
        snacks.add(snack1);

        Snack snack2 = new Snack();
        snack2.setId(2);
        snack2.setNombre("Refresco");
        snack2.setPrecio(3.0);
        snacks.add(snack2);

        
        PromocionSnack promocion1 = new PromocionSnack();
        promocion1.setId(1);
        promocion1.setSnack(snack1);
        promocion1.setDescuento(0.2); 
        promocionesSnacks.add(promocion1);
    }

    public List<Pelicula> obtenerPeliculas() {
        return peliculas;
    }

    public List<Snack> obtenerSnacks() {
        return snacks;
    }

    public List<PromocionSnack> obtenerPromocionesSnacks() {
        return promocionesSnacks;
    }

    public RegistroVenta crearRegistroVenta(int ventaId, Pelicula pelicula,
            String horario, int cantidad, List<SnackVenta> snacksVendidos) {
        double precioTotal = pelicula.getPrecio() * cantidad;
        double descuentoTotal = 0;

        for (SnackVenta snackVenta : snacksVendidos) {
            Snack snack = snackVenta.getSnack();
            int snackId = snack.getId();
            List<PromocionSnack> promociones = obtenerPromocionesSnacks();
            for (PromocionSnack promocion : promociones) {
                if (promocion.getSnack().getId() == snackId) {
                    descuentoTotal += snack.getPrecio() * snackVenta.getCantidad()
                            * promocion.getDescuento();
                }
            }
        }

        precioTotal -= descuentoTotal;
        Boleto boleto = new Boleto(pelicula);
        return new RegistroVenta(ventaId, boleto, snacksVendidos, precioTotal);
    }
}
