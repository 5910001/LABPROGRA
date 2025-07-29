/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miagenda.dao;

import miagenda.model.Contact;
import miagenda.util.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDB {
    

    public static boolean insertarContacto(Contact c) {
        String sql = "INSERT INTO Contactos (nombres, apellidos, telefono, email, direccion, etiquetas) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getNombres());
            stmt.setString(2, c.getApellidos());
            stmt.setString(3, c.getTelefono());
            stmt.setString(4, c.getEmail());
            stmt.setString(5, c.getDireccion());
            stmt.setString(6, c.getEtiquetas());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            guardarLog("insertarContacto", e.getMessage());
            return false;
        }
    }

    public static List<Contact> listarContactos() {
        List<Contact> lista = new ArrayList<>();
        String sql = "SELECT * FROM Contactos";

        try (Connection conn = ConexionDB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Contact c = new Contact(
                    rs.getInt("id"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("telefono"),
                    rs.getString("email"),
                    rs.getString("direccion"),
                    rs.getString("etiquetas")
                );
                lista.add(c);
            }

        } catch (SQLException e) {
            guardarLog("listarContactos", e.getMessage());
        }

        return lista;
    }

    public static boolean eliminarContacto(int id) {
        String sql = "DELETE FROM Contactos WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            guardarLog("eliminarContacto", e.getMessage());
            return false;
        }
    }

    public static boolean actualizarContacto(Contact c) {
        String sql = "UPDATE Contactos SET nombres=?, apellidos=?, telefono=?, email=?, direccion=?, etiquetas=? WHERE id=?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getNombres());
            stmt.setString(2, c.getApellidos());
            stmt.setString(3, c.getTelefono());
            stmt.setString(4, c.getEmail());
            stmt.setString(5, c.getDireccion());
            stmt.setString(6, c.getEtiquetas());
            stmt.setInt(7, c.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            guardarLog("actualizarContacto", e.getMessage());
            return false;
        }
    }

    private static void guardarLog(String metodo, String error) {
        String sql = "INSERT INTO Logs (metodo, error) VALUES (?, ?)";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, metodo);
            stmt.setString(2, error);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error guardando log: " + e.getMessage());
        }
    }
}

