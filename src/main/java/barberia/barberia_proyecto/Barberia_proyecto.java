package barberia.barberia_proyecto;

import barberia.barberia_proyecto.clases.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author IFSul
 */
public class Barberia_proyecto {

    public static void main(String[] args) {
        // Crear algunos productos
        Producto producto1 = new Producto(1,"Shampo 350ml", "Shampo Sedal", new BigDecimal("50.00"));
        Producto producto2 = new Producto(2,"Acondicionador 350ml", "Acondicionador Sedal", new BigDecimal("30.00"));

        // Crear algunos servicios
        Servicio servicio1 = new Servicio(1, "Corte de barba", new BigDecimal("25.00"), "Corte de barba personalizado");
        Servicio servicio2 = new Servicio(2, "Tinte de cabello", new BigDecimal("40.00"), "Tinte profesional");

        // Crear un cliente
        Cliente cliente = new Cliente(1, "Juan Pérez", "71702981126", "555-1234", "juanperez@gmail.com", "Uruguayo");

        // Crear un profesional (barbero)
        Profesional profesional = new Profesional(1, "Carlos López", "71702981126", "555-5678", "carlos@email.com", "Uruguayo");

        // Crear una venta
        Venta venta = new Venta(LocalDateTime.now(), BigDecimal.ZERO,  "Venta de servicios y productos",1 , cliente, profesional);

        // Agregar productos a la venta
        venta.agregarProducto(producto1);
        venta.agregarProducto(producto2);
 
        // Agregar servicios a la venta
        venta.agregarServicio(servicio1);
        venta.agregarServicio(servicio2);

        // Mostrar detalles de la venta
        venta.mostrarVenta();

        // Generar reporte de venta
        venta.relatorioVenta();
    }
}
