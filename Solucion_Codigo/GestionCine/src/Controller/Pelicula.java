package Controller;


// Clase que representa una película.

public class Pelicula {

    private String titulo;
    private String genero;
    private String horario;
    private boolean es3D;

    public Pelicula(String titulo, String genero, String horario, boolean es3D) {
        this.titulo = titulo;
        this.genero = genero;
        this.horario = horario;
        this.es3D = es3D;
    }

    @Override
    public String toString() {
        return "Pelicula: " + titulo + " - Genero: " + genero + " - Horario: " 
                + horario + " - Tipo: " + (es3D ? "3D" : "2D");
        // Devuelve una cadena con la información de la películ
    }

    public String toFileString() {
        return titulo + ":" + genero + ":" + horario + ":" + 
                (es3D ? "3D" : "2D");
        // Devuelve una cadena para guardar la película en un archivo
    }
    //Precio de la película (10.0 si es en 3D, 8.0 si es en 2D)
    public double getPrecio() {
        return es3D ? 10.0 : 8.0;
        // Devuelve el precio según el tipo de película (3D o 2D)
    }
    
    // Getters and setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public boolean isEs3D() {
        return es3D;
    }

    public void setEs3D(boolean es3D) {
        this.es3D = es3D;
    }
}
