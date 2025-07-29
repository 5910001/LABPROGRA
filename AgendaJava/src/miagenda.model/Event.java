/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miagenda.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {
    private int id;
    private int contactoId;
    private LocalDate fecha;
    private LocalTime hora;
    private String descripcion;
    private String ubicacion;

    public Event() {}

    public Event(int id, int contactoId, LocalDate fecha, LocalTime hora, String descripcion, String ubicacion) {
        this.id = id;
        this.contactoId = contactoId;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    // Getters y Setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getContactoId() { return contactoId; }
    public void setContactoId(int contactoId) { this.contactoId = contactoId; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public void setIdContacto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

