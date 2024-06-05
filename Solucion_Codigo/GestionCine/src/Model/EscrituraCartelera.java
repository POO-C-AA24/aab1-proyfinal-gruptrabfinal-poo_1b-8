package Model;

import Controller.Pelicula;
import Controller.Combo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


 //Clase responsable de guardar la cartelera de películas y
//los combos de comida en un archivo.
 
public class EscrituraCartelera {

    private ArrayList<Pelicula> cartelera;  // Lista de películas en cartelera.
    private ArrayList<Combo> combos;        // Lista de combos de comida.

    
      //Constructor que inicializa las listas de cartelera y combos.
    
    public EscrituraCartelera(ArrayList<Pelicula> cartelera, 
            ArrayList<Combo> combos) {
        // Inicialización de la lista de películas en cartelera
        this.cartelera = cartelera;
        // Inicialización de la lista de combos de comida
        this.combos = combos;
    }

    
      //Método para guardar la cartelera y los combos en un archivo.
     
     
    public void guardarCartelera(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter
        (new FileWriter(nombreArchivo))) {
                // Escribir la sección de cartelera
            writer.write("Cartelera:\n");
            for (Pelicula pelicula : cartelera) {
                 // Escribir información de cada película
                writer.write(pelicula.toFileString());
                writer.newLine();// Nueva línea para la siguiente película
            }
             // Escribir la sección de combos
            writer.write("\nCombos:\n");
            for (Combo combo : combos) {
                // Escribir información de cada combo
                writer.write(combo.toFileString());
                writer.newLine();// Nueva línea para el siguiente combo
            }
            System.out.println("La cartelera y los combos se han guardado"
                    + " en el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar la cartelera y"
                    + " los combos en el archivo: " + e.getMessage());
        }
    }
}
