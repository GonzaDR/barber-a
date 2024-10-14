package barberia.barberia_proyecto.clases;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author IFSul
 */
public class Administrador extends Persona{
    
    private ArrayList<Producto> productos;
   
    
    
    public Administrador(int id, String nombre, String cpf, String telefono, String email,String nacionalidad) {
        super(id, nombre, cpf, telefono, email, nacionalidad);
        this.productos = new ArrayList<>();
    }
    public void mostrarDatos(){
        System.out.println("Administrador: "+ getNombre()+ ", CPF: "+ getCpf());
    }
    public void gestionarBarberia() {
        System.out.println(getNombre() + " está gestionando la barbería");
    }
    public void agregarProducto(int id, String descripcion, String nombre_prod, BigDecimal precio){
    	if (precio.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("El precio del producto debe ser mayor a cero.");
            return;
        }
        Producto nuevoProducto = new Producto(id, descripcion, nombre_prod, precio);
        productos.add(nuevoProducto);
        System.out.println("Producto agregaro: " +nombre_prod);
    }
    public void mostrarProductos(){
        System.out.println("Productos disponibles:");
        for(Producto producto : productos){
            producto.mostrarProducto();
        }
    }
}
  