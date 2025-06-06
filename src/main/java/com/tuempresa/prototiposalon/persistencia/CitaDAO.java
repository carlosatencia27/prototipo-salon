package com.tuempresa.prototiposalon.persistencia;

import com.tuempresa.prototiposalon.modelo.Cita;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO (Data Access Object) para la entidad Cita.
 * Aquí simulamos la persistencia con una lista en memoria.
 */
public class CitaDAO {

    // Lista estática que simula la “tabla” de citas en memoria
    private static final List<Cita> storage = new ArrayList<>();
    private static int contadorId = 1;

    /**
     * Inserta una nueva Cita en el “almacenamiento”.
     * @param cita Objeto Cita sin id (id=0).
     * @return true si la inserción fue exitosa.
     */
    public boolean insertar(Cita cita) {
        cita.setId(contadorId++);
        storage.add(cita);
        return true;
    }

    /**
     * Busca citas cuya fechaHora coincida exactamente con la dada.
     * @param fechaHora Fecha y hora a buscar.
     * @return Lista de citas encontradas (puede estar vacía).
     */
    public List<Cita> buscarPorFechaHora(LocalDateTime fechaHora) {
        List<Cita> resultado = new ArrayList<>();
        for (Cita c : storage) {
            if (c.getFechaHora().equals(fechaHora)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    /**
     * Busca una cita por su id.
     * @param id Identificador de la cita.
     * @return Cita si existe, o null si no.
     */
    public Cita buscarPorId(int id) {
        for (Cita c : storage) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    /**
     * Actualiza una cita existente (cambia estado, fecha, etc.).
     * @param cita Objeto Cita con id ya asignado.
     * @return true si encontró y actualizó la cita; false si no existía.
     */
    public boolean actualizar(Cita cita) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getId() == cita.getId()) {
                storage.set(i, cita);
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina una cita por su id.
     * @param id Identificador de la cita.
     * @return true si se eliminó, false si no existía.
     */
    public boolean eliminar(int id) {
        return storage.removeIf(c -> c.getId() == id);
    }

    /**
     * Lista todas las citas actualmente en el “almacenamiento”.
     * @return Lista de todas las citas.
     */
    public List<Cita> listarTodas() {
        return new ArrayList<>(storage);
    }
}
