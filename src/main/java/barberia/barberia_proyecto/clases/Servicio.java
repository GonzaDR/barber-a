package barberia.barberia_proyecto.clases;

/**
 *
 * @author IFSul
 */
public class Servicio {
    private int id_servicio;
    private String nombre_servicio;
    private double precio_servicio;
    private String descr_servicio;

    public Servicio(int id_servicio, String nombre_servicio, double precio_servicio, String descr_servicio) {
        this.id_servicio = id_servicio;
        this.nombre_servicio = nombre_servicio;
        this.precio_servicio = precio_servicio;
        this.descr_servicio = descr_servicio;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public double getPrecio_servicio() {
        return precio_servicio;
    }

    public void setPrecio_servicio(double precio_servicio) {
    	if(precio_servicio > 0) {
    		this.precio_servicio = precio_servicio;
    	}
    	throw new IllegalArgumentException("El precio del servicio debe ser mayor a cero.");
    }

    public String getDescr_servicio() {
        return descr_servicio;
    }

    public void setDescr_servicio(String descr_servicio) {
        this.descr_servicio = descr_servicio;
    }
    
    
}
