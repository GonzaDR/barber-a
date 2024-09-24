package barberia.barberia_proyecto.clases;

/**
 *
 * @author IFSul
 */
public class profesional extends persona{
    
    public profesional(int id, String nombre, String cpf, String telefono, String email, String nacionalidad) {
        super(id, nombre, cpf, telefono, email,nacionalidad);
    }
    public void realizarServicio(){
        System.out.println(getNombre()+" esta realizando un servicio...");
    }
    
    

    
    
}
