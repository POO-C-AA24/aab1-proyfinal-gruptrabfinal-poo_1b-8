package modell;

public class Pelicula extends Producto {
    private String horario;

    // Getters y setters
    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    @Override
    public String getTipo() {
        return "Película";
    }
}
