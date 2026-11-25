
package controlador;

import modelo.Cliente;
import utilitario.Conexion;
import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class ControladorCliente {
    
    public Cliente buscarPorDni(String dni) throws SQLException {
        Cliente c=null;
        //try con recurso, cierra automáticamente la conexión al salir del bloque.
        try(Connection cn = Conexion.conectar()) {
            String sql = "SELECT id_cliente, dni, nombre_cliente, telefono, nametag "
                       + "FROM Cliente WHERE dni=?";            
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, dni);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                c = new Cliente();
                c.setId_cliente(rs.getString(1));
                c.setDni(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setTelefono(rs.getString(4));
                c.setNametag(rs.getString(5));
            }
        } 
        return c;
    }
   
}
