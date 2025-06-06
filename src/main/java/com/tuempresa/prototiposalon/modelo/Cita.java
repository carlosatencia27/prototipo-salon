package com.tuempresa.prototiposalon.modelo;

import java.time.LocalDateTime;

/**
 * Representa una cita en el calendario del salón.
 */
public class Cita {
    private int id;
    private int usuarioId;
    private int servicioId;
    private LocalDateTime fechaHora;
    private String estado; // "PENDIENTE", "CONFIRMADA", "CANCELADA"

    public Cita(int id, int usuarioId, int servicioId, LocalDateTime fechaHora, String estado) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.servicioId = servicioId;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getServicioId() {
        return servicioId;
    }

    public void setServicioId(int servicioId) {
        this.servicioId = servicioId;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método simulado para crear la cita (persistir en capa de persistencia).
     * @return true si se creó exitosamente.
     */
    public boolean crear() {
        // Lógica de inserción en la base de datos/simulación
        return true;
    }

    /**
     * Método simulado para cancelar la cita.
     * @return true si se actualizó estado a "CANCELADA".
     */
    public boolean cancelar() {
        // Lógica de actualización de estado en persistencia
        return true;
    }
}
