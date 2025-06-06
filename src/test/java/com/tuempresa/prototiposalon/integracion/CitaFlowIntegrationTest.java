package com.tuempresa.prototiposalon.integracion;

import com.tuempresa.prototiposalon.modelo.Cita;
import com.tuempresa.prototiposalon.servicio.CitaService;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas de integración para el flujo completo de Cita:
 * – Reservar
 * – Verificar almacenamiento
 * – Cancelar
 * – Verificar estado
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CitaFlowIntegrationTest {

    private static CitaService citaService;
    private static int citaIdCreada;
    // Usamos siempre la misma fecha para no generar conflictos posteriores
    private static final LocalDateTime fechaFija = LocalDateTime.of(2025, 6, 7, 15, 30);
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    @BeforeAll
    public static void setUp() {
        citaService = new CitaService();
    }

    @Test
    @Order(1)
    @DisplayName("1. Reservar cita sin conflicto")
    public void testReservarCitaSinConflicto() {
        boolean exito = citaService.reservarCita(100, 200, fechaFija);
        assertTrue(exito, "La cita debería reservarse cuando no hay conflicto.");
        // Recuperamos la cita recién creada (la única en el sistema)
        List<Cita> todas = citaService.listarTodasCitas();
        assertFalse(todas.isEmpty(), "Debería haber al menos una cita.");
        Cita c = todas.get(0);
        citaIdCreada = c.getId();
        assertEquals(100, c.getUsuarioId());
        assertEquals(200, c.getServicioId());
        assertEquals(fechaFija, c.getFechaHora());
        assertEquals("PENDIENTE", c.getEstado());
    }

    @Test
    @Order(2)
    @DisplayName("2. Intentar reservar cita en mismo horario (debe fallar)")
    public void testReservarCitaConConflicto() {
        boolean exito2 = citaService.reservarCita(101, 201, fechaFija);
        assertFalse(exito2, "No debería reservarse otra cita en el mismo horario.");
    }

    @Test
    @Order(3)
    @DisplayName("3. Verificar que existe solo una cita en fecha fija")
    public void testCantidadCitasDespuesIntentoConflicto() {
        List<Cita> todas = citaService.listarTodasCitas();
        long count = todas.stream()
                .filter(c -> c.getFechaHora().equals(fechaFija))
                .count();
        assertEquals(1, count, "Debe existir exactamente una cita en la fecha fija.");
    }

    @Test
    @Order(4)
    @DisplayName("4. Cancelar la cita reservada")
    public void testCancelarCitaExistente() {
        boolean exitoCancel = citaService.cancelarCita(citaIdCreada);
        assertTrue(exitoCancel, "La cita existente debe cancelarse correctamente.");
        Cita c = citaService.buscarCitaPorId(citaIdCreada);
        assertNotNull(c, "La cita aún debe existir en la base (aunque esté cancelada).");
        assertEquals("CANCELADA", c.getEstado(), "La cita debe haber cambiado su estado a CANCELADA.");
    }

    @Test
    @Order(5)
    @DisplayName("5. Intentar cancelar cita ya cancelada nuevamente (debe fallar o mantener estado)")
    public void testCancelarCitaYaCancelada() {
        boolean exitoCancel2 = citaService.cancelarCita(citaIdCreada);
        assertFalse(exitoCancel2, "No debería poder cancelarse nuevamente una cita ya cancelada.");
    }
}
