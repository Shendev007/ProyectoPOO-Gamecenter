
package controlador;

import modelo.Cliente;
import utilitario.*;
import java.util.*;
import java.sql.*;

public class ControladorCliente {
    
    public List<Cliente> listarClientes(){
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT id_cliente, dni, nombre_cliente, telefono, nametag "
                   + "FROM Cliente";
        //try with resource, cierra automáticamente la sesión al salir del bloque para que no se acumulen.
        try (Connection cn = Conexion.conectar()){
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente();
                c.setId_cliente(rs.getString(1));
                c.setDni(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setTelefono(rs.getString(4));
                c.setNametag(rs.getString(5));
                lista.add(c);
            }
        } catch (SQLException ex) {
            throw new ErrorBaseDatosException("Error al listar los clientes", ex);
        }
        return lista;
    }
    
    public Cliente buscarPorDni(String dni){
        Cliente c = null;
        String sql = "SELECT id_cliente, dni, nombre_cliente, telefono, nametag "
                   + "FROM Cliente WHERE dni = ?";
        //try with resource, cierra automáticamente la sesión al salir del bloque para que no se acumulen.
        try(Connection cn = Conexion.conectar()) {      
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
        } catch (SQLException ex){
            throw new ErrorBaseDatosException("Error al buscar el cliente por DNI", ex);
        }
        return c;
    }
    
    public void registrarCliente (Cliente c){
        String sql = "INSERT INTO Cliente(dni, nombre_cliente, telefono, nametag) "
                   + "VALUES (?,?,?,?)";
        //try with resource, cierra automáticamente la sesión al salir del bloque para que no se acumulen.
        try(Connection cn = Conexion.conectar()){
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1,c.getDni());
            st.setString(2,c.getNombre());
            st.setString(3,c.getTelefono());
            st.setString(4,c.getNametag());
            st.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorBaseDatosException("Error al registrar un cliente", ex);
        }
    }
    
    public void modificarCliente (Cliente c){
        String sql = "UPDATE Cliente "
                   + "SET dni = ?, nombre_cliente = ?, telefono = ?, nametag = ? "
                   + "WHERE id_cliente = ?";
        try(Connection cn = Conexion.conectar()){
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, c.getDni());
            st.setString(2, c.getNombre());
            st.setString(3, c.getTelefono());
            st.setString(4, c.getNametag());
            st.setString(5, c.getId_cliente());
            st.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorBaseDatosException("Error al modificar el cliente", ex);
        }
        
    }
}
