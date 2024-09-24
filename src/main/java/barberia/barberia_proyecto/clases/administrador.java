package barberia.barberia_proyecto.clases;

import java.util.ArrayList;

/**
 *
 * @author IFSul
 */
public class administrador extends persona{
    
    private ArrayList<Producto> productos;
   
    
    
    public administrador(int id, String nombre, String cpf, String telefono, String email,String nacionalidad) {
        super(id, nombre, cpf, telefono, email, nacionalidad);
        this.productos = new ArrayList<>();
    }
   
   //@Override
   // public void mostrarDatos(){
    //    System.out.println("Administrador: "+ getNombre());
   // }
    public void gestionarBarberia() {
        System.out.println(getNombre() + " está gestionando la barbería");
    }
    public void agregarProducto(String nombre_prod, String descripcion, double precio){
    	if (precio <= 0) {
            System.out.println("El precio del producto debe ser mayor a cero.");
            return;
        }
        Producto nuevoProducto = new Producto(nombre_prod, descripcion, precio);
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
  