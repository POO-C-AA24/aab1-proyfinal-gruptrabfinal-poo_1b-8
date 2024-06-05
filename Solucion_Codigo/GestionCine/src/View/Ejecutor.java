package View;

import Controller.Cine;


 //Clase principal que ejecuta el sistema de cine.
 
public class Ejecutor {

    public static void main(String[] args) {
        Cine cine = new Cine();
        
        // Agregar películas a la cartelera
        cine.agregarPelicula("Interstellar", "Ciencia Ficcion",
                "12:00 PM", true);
        cine.agregarPelicula("El Padrino", "Drama", "3:00 PM", false);
        cine.agregarPelicula("Parasitos", "Suspenso", "6:00 PM", true);
        
        // Agregar combos de comida
        cine.agregarCombo("Combo 1", "Palomitas grandes + Refresco grande",
                7.50);
        cine.agregarCombo("Combo 2", "Palomitas medianas + Refresco mediano +"
                + " Hotdog", 9.00);
        cine.agregarCombo("Combo 3", "Nachos + Refresco grande", 6.50);
        
        // Guardar la cartelera y los combos en un archivo
        cine.guardarCartelera("cartelera.txt");
        
        // Mostrar la cartelera y los combos en consola
        cine.mostrarCartelera();
        cine.mostrarCombos();
    }
}
