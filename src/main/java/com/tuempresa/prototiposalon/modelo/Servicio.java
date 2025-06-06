package com.tuempresa.prototiposalon.modelo;

/**
 * Representa un servicio que ofrece el salón.
 */
public class Servicio {
    private int id;
    private String nombre;
    private int duracion; // en minutos
    private double precio;

    public Servicio(int id, String nombre, int duracion, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
