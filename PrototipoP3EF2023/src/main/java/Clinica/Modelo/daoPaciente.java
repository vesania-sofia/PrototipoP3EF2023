/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Hecho por: Karla Sofia Góomez Tobar 9959-21-1896
package Clinica.Modelo;

import Clinica.Controlador.clsPaciente;
import Clinica.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoPaciente {

    private static final String SQL_SELECT = "SELECT pk_idPaciente, nombrePaci, apellidoPaci, FechaNacimiento, Genero, direccionPAci, Telefono, estadoPaci, fk_idReferencia FROM tbl_Paciente";
    private static final String SQL_INSERT = "INSERT INTO tbl_Paciente(pk_idPaciente, nombrePaci, apellidoPaci, FechaNacimiento, Genero, direccionPAci, Telefono, estadoPaci, fk_idReferencia) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_Paciente SET nombrePaci=?,  apellidoPaci=?, FechaNacimiento=?, Genero=?, direccionPAci=?, Telefono=?, estadoPaci=?, fk_idReferencia=?  WHERE pk_idPaciente = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_Paciente WHERE pk_idPaciente=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT pk_idPaciente, nombrePaci, apellidoPaci, FechaNacimiento, Genero, direccionPAci, Telefono, estadoPaci, fk_idReferencia  FROM tbl_Paciente WHERE nombrePaci = ?";
    private static final String SQL_SELECT_ID = "SELECT pk_idPaciente, nombrePaci, apellidoPaci, FechaNacimiento, Genero, direccionPAci, Telefono, estadoPaci, fk_idReferencia  FROM tbl_Paciente WHERE pk_idPaciente = ?";     



   public List<clsPaciente> consultaPaciente() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsPaciente> pacientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("pk_idPaciente");
                String nombre = rs.getString("nombrePaci");
                String apellido = rs.getString("apellidoPaci");
                String fecha = rs.getString("FechaNacimiento");
                int genero =rs.getInt("Genero");
                String direccion = rs.getString("direccionPAci");
                int telefono =rs.getInt("Telefono");
                int estado =rs.getInt("estadoPaci");
                int referencia =rs.getInt("fk_idReferencia");
                
                clsPaciente paciente = new clsPaciente();
                paciente.setPk_idPaciente(id);
                paciente.setNombrePaci(nombre);
                paciente.setApellidoPaci(apellido);
                paciente.setFechaNacimiento(fecha);
                paciente.setGenero(genero);
                paciente.setDireccionPAci(direccion);
                paciente.setTelefono(telefono);
                paciente.setEstadoPaci(estado);
                paciente.setFk_idReferencia(referencia);
                pacientes.add(paciente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return pacientes;
    }


     public int ingresaPaciente (clsPaciente Paciente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, Paciente.getPk_idPaciente());
            stmt.setString(2, Paciente.getNombrePaci());
            stmt.setString(3, Paciente.getApellidoPaci());
            stmt.setString(4, Paciente.getFechaNacimiento());
            stmt.setInt(5, Paciente.getGenero());
            stmt.setString(6, Paciente.getDireccionPAci());
            stmt.setInt(7, Paciente.getTelefono());
            stmt.setInt(8, Paciente.getEstadoPaci());
            stmt.setInt(9, Paciente.getFk_idReferencia());
            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaPaciente (clsPaciente Paciente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, Paciente.getNombrePaci());
            stmt.setString(2, Paciente.getApellidoPaci());
            stmt.setString(3, Paciente.getFechaNacimiento());
            stmt.setInt(4, Paciente.getGenero());
            stmt.setString(5, Paciente.getDireccionPAci());
            stmt.setInt(6, Paciente.getTelefono());
            stmt.setInt(7, Paciente.getEstadoPaci());
            stmt.setInt(8, Paciente.getFk_idReferencia());
            stmt.setInt(9, Paciente.getPk_idPaciente());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarPaciente(clsPaciente Paciente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, Paciente.getPk_idPaciente());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsPaciente consultaPacientePorNombre(clsPaciente Paciente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + Paciente);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, Paciente.Paciente());            
            stmt.setString(1, Paciente.getNombrePaci());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("pk_idPaciente");
                String nombre = rs.getString("nombrePaci");
                String apellido = rs.getString("apellidoPaci");
                String fecha = rs.getString("FechaNacimiento");
                int genero =rs.getInt("Genero");
                String direccion = rs.getString("direccionPAci");
                int telefono =rs.getInt("Telefono");
                int estado =rs.getInt("estadoPaci");
                int referencia =rs.getInt("fk_idReferencia");
                
                // paciente = new clsPaciente();
                Paciente.setPk_idPaciente(id);
                Paciente.setNombrePaci(nombre);
                Paciente.setApellidoPaci(apellido);
                Paciente.setFechaNacimiento(fecha);
                Paciente.setGenero(genero);
                Paciente.setDireccionPAci(direccion);
                Paciente.setTelefono(telefono);
                Paciente.setEstadoPaci(estado);
                Paciente.setFk_idReferencia(referencia);
                System.out.println(" registro consultado: " + Paciente);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return Paciente;
    }
    public clsPaciente consultaPacientePorId(clsPaciente Paciente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + Paciente);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, Paciente.getPk_idPaciente());            
            //stmt.setString(1, Paciente.getTipMondNombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("pk_idPaciente");
                String nombre = rs.getString("nombrePaci");
                String apellido = rs.getString("apellidoPaci");
                String fecha = rs.getString("FechaNacimiento");
                int genero =rs.getInt("Genero");
                String direccion = rs.getString("direccionPAci");
                int telefono =rs.getInt("Telefono");
                int estado =rs.getInt("estadoPaci");
                int referencia =rs.getInt("fk_idReferencia");
                
                // paciente = new clsPaciente();
                Paciente.setPk_idPaciente(id);
                Paciente.setNombrePaci(nombre);
                Paciente.setApellidoPaci(apellido);
                Paciente.setFechaNacimiento(fecha);
                Paciente.setGenero(genero);
                Paciente.setDireccionPAci(direccion);
                Paciente.setTelefono(telefono);
                Paciente.setEstadoPaci(estado);
                Paciente.setFk_idReferencia(referencia);
                System.out.println(" registro consultado: " + Paciente);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return Paciente;
    }    
}
