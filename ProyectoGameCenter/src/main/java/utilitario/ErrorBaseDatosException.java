
package utilitario;

public class ErrorBaseDatosException extends RuntimeException{

    /*
    /Herencia de la excepción "RuntimeException" no comprobada.
    */
    public ErrorBaseDatosException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }   
}
