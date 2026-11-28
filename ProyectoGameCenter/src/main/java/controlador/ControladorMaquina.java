
package controlador;

import modelo.TipoMaquina;
import modelo.Maquina;
import utilitario.*;
import java.util.*;
import java.sql.*;

public class ControladorMaquina {
    
    public List<TipoMaquina> listarTipoMaquina(){
        List<TipoMaquina> lista = new ArrayList<>();
        String sql = "SELECT id_tipo, nombre_tipo, tarifa_hora "
                   + "FROM TipoMaquina ORDER BY nombre_tipo";
        //try with resource, cierra automáticamente la sesión al salir del bloque para que no se acumulen.
        try (Connection cn = Conexion.conectar()){
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                TipoMaquina tipo = new TipoMaquina();
                tipo.setId_tipo(rs.getString(1));
                tipo.setNombre_tipo(rs.getString(2));
                tipo.setTarifa_hora(rs.getDouble(3));
                lista.add(tipo);
            }
        } catch (SQLException ex) {
            throw new ErrorBaseDatosException("Error al listar los tipos de máquina", ex);
        }
        return lista;
    }
    
    public void registrarMaquina(Maquina m){
        String sql = "INSERT INTO Maquina (id_tipo, nombre_maquina, estado_maquina) "
                   + "VALUES (?,?,?)";
        //try with resource, cierra automáticamente la sesión al salir del bloque para que no se acumulen.
        try(Connection cn = Conexion.conectar()){
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1,m.getTipo().getId_tipo());
            st.setString(2,m.getNombre_maquina());
            st.setString(3,m.getEstado_maquina());
            st.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorBaseDatosException("Error al registrar la máquina", ex);
        }
    }
    
    public List<Maquina> listarMaquina(){
        List<Maquina> lista = new ArrayList<>();
        String sql = "SELECT m.id_maquina, m.nombre_maquina, m.estado_maquina, "
                   + "t.id_tipo, t.nombre_tipo, t.tarifa_hora "
                   + "FROM Maquina m "
                   + "JOIN TipoMaquina t ON m.id_tipo = t.id_tipo "
                   + "ORDER BY m.id_maquina";
        try (Connection cn = Conexion.conectar()){
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                TipoMaquina tipo = new TipoMaquina();
                tipo.setId_tipo(rs.getString(4));
                tipo.setNombre_tipo(rs.getString(5));
                tipo.setTarifa_hora(rs.getDouble(6));
                
                Maquina m = new Maquina();
                m.setId_maquina(rs.getString(1));
                m.setNombre_maquina(rs.getString(2));
                m.setEstado_maquina(rs.getString(3));
                m.setTipo(tipo);
                lista.add(m);
            }
        } catch (SQLException ex) {
            throw new ErrorBaseDatosException("Error al listar las máquinas", ex);
        }
        return lista;
    }
    
    public void modificarMaquina(Maquina m){
        String sql = "UPDATE Maquina SET nombre_maquina = ?, estado_maquina = ? "
                   + "WHERE id_maquina = ? "
                   + "AND NOT EXISTS ("
                   + "    SELECT 1 FROM Alquiler "
                   + "    WHERE Alquiler.id_maquina = Maquina.id_maquina "
                   + "    AND Alquiler.estado_alquiler = 'Activo')";
        
        try (Connection cn = Conexion.conectar()){
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, m.getNombre_maquina());
            st.setString(2, m.getEstado_maquina());
            st.setString(3, m.getId_maquina());
            
            //valida filas afectadas
            int fila = st.executeUpdate();
            if(fila==0){
                throw new IllegalStateException("No se guardaron los cambios. Verifica que la máquina seleccionada, " 
                        + "si tiene un alquiler activo debe conservar su estado actual.");
            }
        } catch (SQLException ex) {
            throw new ErrorBaseDatosException("Error al modificar la máquina", ex);
        }
    }
    
    public void actualizarTarifa(TipoMaquina t){
        String sql = "UPDATE TipoMaquina SET tarifa_hora = ? "
                   + "WHERE id_tipo = ?";
        try (Connection cn = Conexion.conectar()){
            PreparedStatement st = cn.prepareStatement(sql);
            st.setDouble(1, t.getTarifa_hora());
            st.setString(2, t.getId_tipo());
            st.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorBaseDatosException("Error al actualizar la tarifa por hora", ex);
        }
    }
}
