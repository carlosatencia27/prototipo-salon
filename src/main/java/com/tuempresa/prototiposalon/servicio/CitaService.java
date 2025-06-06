package com.tuempresa.prototiposalon.servicio;

import com.tuempresa.prototiposalon.modelo.Cita;
import com.tuempresa.prototiposalon.persistencia.CitaDAO;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Servicio que maneja la lógica de negocio para Citas.
 */
public class CitaService {

    private CitaDAO citaDAO = new CitaDAO();

    /**
     * Reserva una nueva cita si el horario está libre.
     * @param usuarioId ID del usuario que pide la cita.
     * @param servicioId ID del servicio solicitado.
     * @param fechaHora Fecha y hora deseada.
     * @return true si la cita fue reservada; false si hay conflicto.
     */
    public boolean reservarCita(int usuarioId, int servicioId, LocalDateTime fechaHora) {
        // 1. Verificar disponibilidad
        List<Cita> citasMismoHorario = citaDAO.buscarPorFechaHora(fechaHora);
        if (!citasMismoHorario.isEmpty()) {
            return false; // Ya existe una cita en ese mismo horario
        }
        // 2. Crear objeto Cita y persistirlo (estado inicial “PENDIENTE”)
        Cita nueva = new Cita(0, usuarioId, servicioId, fechaHora, "PENDIENTE");
        return citaDAO.insertar(nueva);
    }

    /**
 * Cancela una cita existente (si existe y no está ya cancelada) cambiando su estado.
 * @param citaId ID de la cita a cancelar.
 * @return true si se canceló correctamente; false si no existía o ya estaba cancelada.
 */
public boolean cancelarCita(int citaId) {
    Cita existente = citaDAO.buscarPorId(citaId);
    if (existente == null) {
        return false; // No hay cita con ese ID
    }
    if ("CANCELADA".equals(existente.getEstado())) {
        return false; // Ya está cancelada
    }
    existente.setEstado("CANCELADA");
    return citaDAO.actualizar(existente);
}


    /**
     * Lista todas las citas (independientemente de su estado).
     * @return Lista de todas las citas.
     */
    public List<Cita> listarTodasCitas() {
        return citaDAO.listarTodas();
    }

    /**
     * Busca una cita por su ID.
     * @param citaId ID de la cita a buscar.
     * @return Objeto Cita si existe; null si no.
     */
    public Cita buscarCitaPorId(int citaId) {
        return citaDAO.buscarPorId(citaId);
    }
}
