package barberia.barberia_proyecto.clases;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Venta {
    private ArrayList<Producto> productos;
    private double total_venta;
    private int id_venta;
    private String desc_venta;
    private int cant_venta;
    private double comision_venta;
    private LocalDateTime fecha;
    private cliente cliente;
    private profesional profesional;
    
    public Venta(){
    productos = new ArrayList<>();
    total_venta = 0;
    }

    public Venta(double total_venta, LocalDateTime fecha, int id_venta, String desc_venta, int cant_venta, double comision_venta, cliente cliente, profesional profesional) {
    	if(cliente == null || profesional == null || cant_venta <=  0) {
    		throw new IllegalArgumentException("Venta debe tener un cliente, un profesional y productos");
    	}
        this.total_venta = total_venta;
        this.id_venta = id_venta;
        this.desc_venta = desc_venta;
        this.cant_venta = cant_venta;
        this.comision_venta = comision_venta;
        this.fecha = (fecha == null) ? LocalDateTime.now() : fecha;
        this.cliente = cliente;
        this.profesional = profesional;
        this.productos = new ArrayList<>();
        calcularComision();
    
    
    if(fecha == null) {
    	this.fecha = LocalDateTime.now();
    } else {
    	this.fecha = fecha;
    	}
    }
    //Constructor sin id (opcional)
    public Venta(LocalDateTime fecha, double total_venta, String desc_venta, int cant_venta, double comision_venta, cliente cliente, profesional profesional) {
    	this(total_venta, fecha, 0, desc_venta, cant_venta, comision_venta, cliente, profesional); // Llamar al constructor principal con un ID por defecto
    }
 
    
    public void agregarProducto(Producto producto){
    	if(producto.getPrecio() <=0) {
    		throw new IllegalArgumentException("El precio del producto debe ser mayor cero.");
    	}
    	productos.add(producto);
    	total_venta += producto.getPrecio();
    	cant_venta++;
    	calcularComision();
        System.out.println("Producto agregado: " + producto.getNombre_prod());
    }
    private void calcularComision() {
    	this.comision_venta = total_venta * 0.10;// comision 10%
    }
   
    
    public void relatorioVenta(){
        System.out.println("Productos en la venta: ");
        for (Producto producto : productos) {
            System.out.println(producto.getNombre_prod()+ " - $"+ producto.getPrecio());
            
        }
        System.out.println("Total: $" + total_venta);
        System.out.println("Comision 10%: $" + comision_venta);
    }
    

    public double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(double total_venta) {
    		this.total_venta = total_venta;
        
    }
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getDesc_venta() {
        return desc_venta;
    }

    public void setDesc_venta(String desc_venta) {
        this.desc_venta = desc_venta;
    }

    public int getCant_venta() {
        return cant_venta;
    }

    public void setCant_venta(int cant_venta) {
    		this.cant_venta = cant_venta;
    }

    public double getComision_venta() {
        return comision_venta;
    }

    public void setComision_venta(double comision_venta) {
    	if(comision_venta >= 0) {
    		this.comision_venta = comision_venta;
    	}else {
    		throw new IllegalArgumentException("La comisión no puede ser negativa.");
    	}
    }
    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }
    public profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(profesional profesional) {
        this.profesional = profesional;
    }
    
    // Método para mostrar los detalles de la venta
    public void mostrarVenta() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = fecha.format(formatter);
        
        System.out.println("ID Venta: " + id_venta);
        System.out.println("Fecha: " + formattedDate);
        System.out.println("Monto: " + total_venta);
        System.out.println("Descripción: " + desc_venta);
        System.out.println("Cantidad: "+ cant_venta);
        System.out.println("Comision 10%: "+ comision_venta);
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Profesional: " + profesional.getNombre());
        System.out.println();
    }
    
    
}
