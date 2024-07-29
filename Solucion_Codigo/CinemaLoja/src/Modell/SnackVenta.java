package modell;

public class SnackVenta {
    private Snack snack;
    private int cantidad;

    // Constructor
    public SnackVenta(Snack snack, int cantidad) {
        this.snack = snack;
        this.cantidad = cantidad;
    }

    // Getters y setters
    public Snack getSnack() { return snack; }
    public void setSnack(Snack snack) { this.snack = snack; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
