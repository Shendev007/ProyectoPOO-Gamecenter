
package modelo;

public class TipoMaquina {
    
    private String id_tipo;
    private String nombre_tipo;
    private double tarifa_hora;

    public String getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(String id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    public double getTarifa_hora() {
        return tarifa_hora;
    }

    //Se indica la condición para llamar al setTarifa_hora
    public void setTarifa_hora(double tarifa_hora) {
        
        if(tarifa_hora<= 0){
            throw new IllegalArgumentException("La tarifa por hora debe ser mayor que cero");
        }
        this.tarifa_hora = tarifa_hora;
    }
}
