
package utilitario;

import java.sql.*;

public class Conexion {
    
    
    //Reemplazar url, usuario y clave por el que corresponda.
    public static Connection conectar(){
        try {
            String url = "jdbc:mysql://localhost:3306/gamecenter";
            String usuario = "root";
            String clave = "4546";
            Connection cn = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexion establecida correctamente");
            return cn;
        } catch (SQLException ex) {
            System.err.println("Error en SQL al intentar conectar con la base de datos.");
            System.err.println("Mensaje del error: "+ex.getMessage());
            ex.printStackTrace();
            return null;
        } catch (Exception ex) {
            System.err.println("Error al conectar: "+ ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }  
}
