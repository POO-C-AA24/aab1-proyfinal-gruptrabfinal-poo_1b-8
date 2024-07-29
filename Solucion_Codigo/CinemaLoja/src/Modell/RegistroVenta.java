package modell;

import java.util.List;

public class RegistroVenta {
    private int id;
    private Boleto boleto;
    private List<SnackVenta> snacksVendidos;
    private double precioTotal;

    // Constructor
    public RegistroVenta(int id, Boleto boleto, List<SnackVenta> snacksVendidos, double precioTotal) {
        this.id = id;
        this.boleto = boleto;
        this.snacksVendidos = snacksVendidos;
        this.precioTotal = precioTotal;
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Boleto getBoleto() { return boleto; }
    public void setBoleto(Boleto boleto) { this.boleto = boleto; }
    public List<SnackVenta> getSnacksVendidos() { return snacksVendidos; }
    public void setSnacksVendidos(List<SnackVenta> snacksVendidos) { this.snacksVendidos = snacksVendidos; }
    public double getPrecioTotal() { return precioTotal; }
    public void setPrecioTotal(double precioTotal) { this.precioTotal = precioTotal; }
}
