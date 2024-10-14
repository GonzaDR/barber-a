package barberia.barberia_proyecto.clases;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Venta {
    private ArrayList<Producto> productos;
    private ArrayList<Servicio> servicios; // Agregado para almacenar los servicios
    private BigDecimal total_venta;
    private int id_venta;
    private String desc_venta;
    private int cant_venta;
    private BigDecimal comision_prod; // Comisión total por productos
    private BigDecimal comision_serv; // Comisión total por servicios
    private LocalDateTime fecha;
    private Cliente cliente;
    private Profesional profesional;

    public Venta() {
        productos = new ArrayList<>();
        servicios = new ArrayList<>(); // Inicialización de servicios
        total_venta = BigDecimal.ZERO;
        comision_prod = BigDecimal.ZERO;
        comision_serv = BigDecimal.ZERO;
        fecha = LocalDateTime.now(); // Establecer fecha por defecto
    }

    public Venta(BigDecimal total_venta, LocalDateTime fecha, int id_venta, String desc_venta, int cant_venta, Cliente cliente, Profesional profesional) {
        if (cliente == null || profesional == null || cant_venta <= 0) {
            throw new IllegalArgumentException("Venta debe tener un cliente, un profesional y al menos un producto o servicio.");
        }
        this.total_venta = (total_venta == null) ? BigDecimal.ZERO : total_venta;
        this.id_venta = 0;
        this.desc_venta = desc_venta;
        this.cant_venta = cant_venta;
        this.fecha = (fecha == null) ? LocalDateTime.now() : fecha;
        this.cliente = cliente;
        this.profesional = profesional;
        this.productos = new ArrayList<>();
        this.servicios = new ArrayList<>();
        this.comision_prod = BigDecimal.ZERO;
        this.comision_serv = BigDecimal.ZERO;
    }

    // Constructor sin id (opcional)
    public Venta(LocalDateTime fecha, BigDecimal total_venta, String desc_venta, int cant_venta, Cliente cliente, Profesional profesional) {
        this(total_venta, fecha, 0, desc_venta, cant_venta, cliente, profesional); // Llamar al constructor principal con un ID por defecto
    }

    public void agregarProducto(Producto producto) {
        if (producto.getPrecio().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio del producto debe ser mayor a cero.");
        }
        productos.add(producto);
        total_venta = total_venta.add(producto.getPrecio());
        cant_venta++;
        comision_prod = comision_prod.add(calcularComisionProducto(producto)); // Calcular comisión para el producto
        System.out.println("Producto agregado: " + producto.getNombre_prod());
    }

    public void agregarServicio(Servicio servicio) {
        if (servicio.getPrecio_servicio().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio del servicio debe ser mayor a cero.");
        }
        servicios.add(servicio);
        total_venta = total_venta.add(servicio.getPrecio_servicio());
        cant_venta++;
        comision_serv = comision_serv.add(calcularComisionServicio(servicio)); // Calcular comisión para el servicio
        System.out.println("Servicio agregado: " + servicio.getNombre_servicio());
    }

    private BigDecimal calcularComisionProducto(Producto producto) {
        ComisionProd comision = new ComisionProd();
        return comision.calcular(producto); // Calcula la comisión por producto y devuelve
    }

    private BigDecimal calcularComisionServicio(Servicio servicio) {
        ComisionServ comision = new ComisionServ();
        return comision.calcular(servicio); // Calcula la comisión por servicio y devuelve
    }

    public void relatorioVenta() {
        System.out.println("Productos en la venta: ");
        for (Producto producto : productos) {
            System.out.println(producto.getNombre_prod() + " - $" + producto.getPrecio());
        }
        System.out.println("Servicios en la venta: ");
        for (Servicio servicio : servicios) {
            System.out.println(servicio.getNombre_servicio() + " - $" + servicio.getPrecio_servicio());
        }
        System.out.println("Total: $" + total_venta);
        System.out.println("Comisión total por productos: $" + comision_prod);
        System.out.println("Comisión total por servicios: $" + comision_serv);
    }

    public BigDecimal getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(BigDecimal total_venta) {
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

    public BigDecimal getComision_prod() {
        return comision_prod;
    }

    public void setComision_prod(BigDecimal comision_prod) {
        if (comision_prod.compareTo(BigDecimal.ZERO) >= 0) {
            this.comision_prod = comision_prod;
        } else {
            throw new IllegalArgumentException("La comisión no puede ser negativa.");
        }
    }

    public BigDecimal getComision_serv() {
        return comision_serv;
    }

    public void setComision_serv(BigDecimal comision_serv) {
        if (comision_serv.compareTo(BigDecimal.ZERO) >= 0) {
            this.comision_serv = comision_serv;
        } else {
            throw new IllegalArgumentException("La comisión no puede ser negativa.");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
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
        System.out.println("Cantidad: " + cant_venta);
        System.out.println("Comisión por productos: " + comision_prod);
        System.out.println("Comisión por servicios: " + comision_serv);
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Profesional: " + profesional.getNombre());
        System.out.println();
    }
}
