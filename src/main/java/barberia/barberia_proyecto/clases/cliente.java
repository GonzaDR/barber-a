
package barberia.barberia_proyecto.clases;
/**
 *
 * @author IFSul
 */
public class cliente extends persona{
    
    public cliente(int id, String nombre, String cpf, String telefono, String email, String nacionalidad) {
        super(id, nombre, cpf, telefono, email, nacionalidad);
    }
    public void reservarCita(){
        System.out.println(getNombre()+" ha reservado una cita.");
    }
}
