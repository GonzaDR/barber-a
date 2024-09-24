package barberia.barberia_proyecto.clases;

import java.util.ArrayList;

/**
 *
 * @author IFSul
 */
public class agenda {
    private ArrayList<String> citas;
    
    public agenda(){
    citas = new ArrayList<>();
    }
    public void agregarCita(String cita){
    citas.add(cita);
        System.out.println("Cita agregada: " + cita);
    }
    
    public void mostrarCitas(){
        System.out.println("Citas en la agenda: ");
        for(String cita : citas){
            System.out.println(cita);
        }
    }
    
}