package ar.Membresias;

public class Membresia {
    private String nombre;
    private int precio;
    private String detalles;

    public Membresia(String nombre, int precio, String detalles) {
        this.nombre = nombre;
        this.precio = precio;
        this.detalles = "Beneficios: \n"+detalles;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public String getDetalles() {
        return detalles;
    }
}
