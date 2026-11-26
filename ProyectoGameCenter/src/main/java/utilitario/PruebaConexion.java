
package utilitario;

import javax.swing.JOptionPane;
import modelo.Cliente;
import controlador.*;
public class PruebaConexion {

    public static void main(String[] args) {
        
        try {
            Conexion.conectar();
            System.out.println("Conexion exitosa");
        } catch (ErrorBaseDatosException ex) {
            System.err.println(ex.getMessage());
        }

    }
} 