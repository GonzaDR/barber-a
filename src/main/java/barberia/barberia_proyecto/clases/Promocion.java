package barberia.barberia_proyecto.clases;

/**
 *
 * @author IFSul
 */
public class Promocion {
    private int id_desc;
    private String descripcion;
    private double descuento;

    public Promocion(int id_desc, String descripcion, double descuento) {
        this.id_desc = id_desc;
        this.descripcion = descripcion;
        this.descuento = descuento;
    }

    public int getId_desc() {
        return id_desc;
    }

    public void setId_desc(int id_desc) {
        this.id_desc = id_desc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    
    
}
