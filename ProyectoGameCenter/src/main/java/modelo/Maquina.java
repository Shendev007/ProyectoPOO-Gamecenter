
package modelo;

public class Maquina {
    
    private String id_maquina;
    private String nombre_maquina;
    private TipoMaquina tipo;
    private String estado_maquina;

    public String getId_maquina() {
        return id_maquina;
    }

    public void setId_maquina(String id_maquina) {
        this.id_maquina = id_maquina;
    }

    public String getNombre_maquina() {
        return nombre_maquina;
    }

    //Se indica la condición para llamar al setNombre_maquina
    public void setNombre_maquina(String nombre_maquina) {
        
        if (nombre_maquina == null || nombre_maquina.isBlank()) {
            throw new IllegalArgumentException("Ingresa el nombre de la máquina.");
        }
        this.nombre_maquina = nombre_maquina.trim();
    }

    public TipoMaquina getTipo() {
        return tipo;
    }

    public void setTipo(TipoMaquina tipo) {
        this.tipo = tipo;
    }

    public String getEstado_maquina() {
        return estado_maquina;
    }

    public void setEstado_maquina(String estado_maquina) {

        if(!estado_maquina.equals("Habilitada")  && !estado_maquina.equals("Mantenimiento") && !estado_maquina.equals("Retirada")){
            throw new IllegalArgumentException("Ingresa un estado de máquina válido.");
        }
        this.estado_maquina = estado_maquina;
    }
}
