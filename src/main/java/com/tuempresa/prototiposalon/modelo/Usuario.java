package com.tuempresa.prototiposalon.modelo;

/**
 * Representa un usuario (cliente o administrador) de la plataforma.
 */
public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String rol; // "CLIENTE" o "ADMIN"

    public Usuario(int id, String nombre, String email, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Método simulado para registrarse (persistir en la capa de persistencia).
     * @return true si el registro fue exitoso.
     */
    public boolean registrarse() {
        // Lógica de registro (a implementar en capa de persistencia)
        return true;
    }

    /**
     * Método simulado para iniciar sesión dado un password.
     * @param password contraseña proporcionada.
     * @return true si credenciales válidas.
     */
    public boolean iniciarSesion(String password) {
        // Validar credenciales contra persistencia
        return true;
    }
}
