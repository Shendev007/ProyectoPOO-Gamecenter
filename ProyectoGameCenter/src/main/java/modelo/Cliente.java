
package modelo;

public class Cliente {
    
    private String id_cliente;
    private String dni;
    private String nombre;
    private String telefono;
    private String nametag;

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDni() {
        return dni;
    }

    //Se indica la condición para llamar al setDni
    public void setDni(String dni) {
        
        if(!dni.matches("[0-9]{8}")){
            throw new IllegalArgumentException("El DNI es obligatorio y debe contener exactamente 8 dígitos");
        }
        
        this.dni = dni;
        
    }

    public String getNombre() {
        return nombre;
    }
    
    //Se indica la condición para llamar al setNombre
    public void setNombre(String nombre) {
        if(nombre.isBlank()){
            throw new IllegalArgumentException("Debe ingresar el nombre del cliente");
        }
        
        if(!nombre.matches("\\p{L}+( +\\p{L}+)*")){
            throw new IllegalArgumentException("El nombre solo puede contener letras y espacios");
        }
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    //Se indica la condición para llamar al setTelefono
    public void setTelefono(String telefono) {
        
        if(telefono == null || telefono.isBlank()){
            this.telefono = null;
            return;
        }
        
        if(!telefono.matches("9[0-9]{8}")){
            throw new IllegalArgumentException("El telefono debe comenzar con 9 y tener exactamente 9 dígitos");
        }
        
        this.telefono = telefono;
        
    }

    public String getNametag() {
        return nametag;
    }
    
    //Se indica la condición para llamar al setNametag
    public void setNametag(String nametag) {
        if(nametag == null || nametag.isBlank()){
            this.nametag = null;
            return;
        }
        this.nametag = nametag.trim();
    }
}