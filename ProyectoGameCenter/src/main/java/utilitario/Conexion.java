
package utilitario;

import java.sql.*;

public class Conexion {
    
   /*
    Reemplazar url, usuario y clave por el que corresponda.
   */
    public static Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/gamecenter";
        String usuario = "root";
        String clave = "4546";
        try {
            Connection cn = DriverManager.getConnection(url, usuario, clave);
            return cn;
        } catch (SQLException ex) {
            throw new ErrorBaseDatosException("Error #"+ex.getErrorCode()+" al conectar con la base de datos",ex);
        }
    }
}
