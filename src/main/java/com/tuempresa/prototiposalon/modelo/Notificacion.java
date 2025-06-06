package com.tuempresa.prototiposalon.modelo;

import java.time.LocalDateTime;

/**
 * Representa una notificación enviada (correo o WhatsApp).
 */
public class Notificacion {
    private int id;
    private String tipo;       // "CORREO" o "WHATSAPP"
    private LocalDateTime fechaEnvio;
    private String mensaje;

    public Notificacion(int id, String tipo, LocalDateTime fechaEnvio, String mensaje) {
        this.id = id;
        this.tipo = tipo;
        this.fechaEnvio = fechaEnvio;
        this.mensaje = mensaje;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Envía la notificación según el tipo configurado.
     */
    public void enviar() {
        // Lógica para enviar correo o WhatsApp (simulada)
    }
}
