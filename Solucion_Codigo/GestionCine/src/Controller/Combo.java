package Controller;


 // Clase que representa un combo de comida.
 
public class Combo {

    private String nombre;
    private String descripcion;
    private double precio;

    public Combo(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Combo: " + nombre + " - Descripcion: " + descripcion +
                " - Precio: $" + precio;
        // Devuelve una cadena con la información del combo
    }

    public String toFileString() {
        return nombre + ":" + descripcion + ":" + precio;
        // Devuelve una cadena para guardar el combo en un archivo
    }
    
    // Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;// Devuelve el precio del combo
    }

    public void setPrecio(double precio) {
        this.precio = precio;// Establece el precio del combo
    }
}
