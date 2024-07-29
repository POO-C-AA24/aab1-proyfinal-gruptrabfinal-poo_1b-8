package modell;

public class Boleto extends Producto {
    private Pelicula pelicula;

    public Boleto(Pelicula pelicula) {
        this.pelicula = pelicula;
        this.setId(pelicula.getId());
        this.setNombre(pelicula.getNombre());
        this.setPrecio(pelicula.getPrecio());
    }

    public Pelicula getPelicula() { return pelicula; }
    public void setPelicula(Pelicula pelicula) { this.pelicula = pelicula; }

    @Override
    public String getTipo() {
        return "Boleto";
    }
}
