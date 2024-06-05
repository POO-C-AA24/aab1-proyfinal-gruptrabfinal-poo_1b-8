package Controller;

import Model.EscrituraCartelera;
import java.util.ArrayList;


//Clase que representa un cine y su cartelera de películas y combos de comida.
 
public class Cine {

    private ArrayList<Pelicula> cartelera;  // Lista de películas en cartelera.
    private ArrayList<Combo> combos;        // Lista de combos de comida.

    public Cine() {
        cartelera = new ArrayList<>();// Inicialización de la lista de películas.
        combos = new ArrayList<>();  // Inicialización de la lista de combos.
    }

    public void agregarPelicula(String titulo, String genero, String horario, boolean es3D) {
        Pelicula pelicula = new Pelicula(titulo, genero, horario, es3D);
        cartelera.add(pelicula);// Agregar la película a la lista de películas.
    }

    public void agregarCombo(String nombre, String descripcion, double precio) {
        Combo combo = new Combo(nombre, descripcion, precio);
        combos.add(combo);// Agregar el combo a la lista de combos.
    }
   //Muestra la cartelera de películas en la consola.
    public void mostrarCartelera() {
        if (cartelera.isEmpty()) {
            System.out.println("No hay peliculas en cartelera.");
        } else {
            System.out.println("Cartelera del cine:");
            for (Pelicula pelicula : cartelera) {
                System.out.println(pelicula);
            }
        }
    }
    //Muestra los combos de comida disponibles en la consola.
    public void mostrarCombos() {
        if (combos.isEmpty()) {
            System.out.println("No hay combos disponibles.");
        } else {
            System.out.println("Combos de comida:");
            for (Combo combo : combos) {
                System.out.println(combo);
            }
        }
    }
    //Guarda la cartelera de películas y los combos de comida en un archivo.

    public void guardarCartelera(String nombreArchivo) {
        EscrituraCartelera escrituraCartelera = new EscrituraCartelera(cartelera, combos);
        escrituraCartelera.guardarCartelera(nombreArchivo);
        // Invoca el método para guardar la cartelera en el archivo.
    }
}
