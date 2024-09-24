package barberia.barberia_proyecto;

import barberia.barberia_proyecto.clases.*;
import java.time.LocalDateTime;

/**
 *
 * @author IFSul
 */
public class Barberia_proyecto {

    public static void main(String[] args) {
        // Crear instancias de Cliente, Profesional y Productos
        cliente cliente1 = new cliente(1, "Juan Pérez", "71702981126", "555-1234", "juan.perez@example.com", "Uruguayo");
        profesional profesional1 = new profesional(2, "Carlos Martínez", "71702981126", "555-5678", "carlos.martinez@example.com", "Uruguayo");

        // Crear productos
        Producto producto1 = new Producto("Shampoo", "Shampoo para cabello normal", 15.00);
        Producto producto2 = new Producto("Afeitadora", "Afeitadora eléctrica", 80.00);
        
        System.out.println("");
        
        // Crear una venta
        Venta venta1 = new Venta(LocalDateTime.now(), 0.0, "Venta de productos de barbería", 2, 0.0, cliente1, profesional1);

        // Agregar productos a la venta
        venta1.agregarProducto(producto1);
        venta1.agregarProducto(producto2);

        System.out.println("");
        
        // Mostrar el reporte de la venta
        venta1.relatorioVenta();
        
        System.out.println("");
        
        venta1.mostrarVenta();

        // Mostrar datos del cliente y profesional
        System.out.println(cliente1);
        
        System.out.println("");
        
        System.out.println(profesional1);

        System.out.println("");
        
        // Ejemplo de administración de productos por el administrador
        administrador admin = new administrador(3, "Ana Gómez", "71702981126", "555-9999", "ana.gomez@example.com", "Uruguayo");
        admin.agregarProducto("Crema para barba", "Crema hidratante para la barba", 25.00);
        
        System.out.println("");
        
        admin.mostrarProductos();
    }
}
