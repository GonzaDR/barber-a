package barberia.barberia_proyecto.clases;

/**
 *
 * @author IFSul
 */
public abstract class persona {

    private int id;
    private String nombre;
    private String cpf;
    private String telefono;
    private String email;
    private String nacionalidad;

    public persona(int id, String nombre, String cpf, String telefono, String email, String nacionalidad) {
    	if(!validarCPF(cpf)) {
    		throw new IllegalArgumentException("CPF invalido.");
    	}
    	if(nombre==null || nombre.isEmpty() || cpf == null || cpf.isEmpty()) {
    		throw new IllegalArgumentException("Nombre y CPF son obligatorios.");
    	}
        this.id = id;
        this.nombre = nombre;
        this.cpf = cpf;
        this.telefono = telefono;
        this.email = email;
        this.nacionalidad = nacionalidad;
    }
    
    private boolean validarCPF(String cpf) {
    	return ValidarCPF.isCPF(cpf);
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
    	//Revalidar el CPF al cambiarlo
    	if(!validarCPF(cpf)) {
    		throw new IllegalArgumentException("CPF invalido.");
    	}
        this.cpf = cpf;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente" + "\nId:" + id + "\nNombre:" + nombre + "\nCpf=" + cpf + "\nTelefono=" + telefono + "\nEmail=" + email + "\nNacionalidad=" + nacionalidad ;
    }

    

    

}
