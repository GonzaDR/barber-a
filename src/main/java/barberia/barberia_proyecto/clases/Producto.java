package barberia.barberia_proyecto.clases;

/**
 *
 * @author IFSul
 */
public class Producto {
    private int id_prod;
    private double precio;
    private String descripcion;
    private String nombre_prod;

    public Producto(String descripcion, String nombre_prod, double precio) {
        this.precio = precio;
        this.descripcion = descripcion;
        this.nombre_prod = nombre_prod;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        } else {
            throw new IllegalArgumentException("El precio debe ser mayor a cero.");
        }

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    public void mostrarProducto() {
        System.out.println("Nombre: " + nombre_prod);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Precio: $" + precio);
        System.out.println();
    }

}
