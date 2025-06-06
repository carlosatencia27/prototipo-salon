package com.tuempresa.prototiposalon.ui;

import com.tuempresa.prototiposalon.modelo.Cita;
import com.tuempresa.prototiposalon.servicio.CitaService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * Interfaz de consola para interactuar con el CitaService.
 */
public class Main {

    // Para parsear la fechaHora en formato: yyyy-MM-ddTHH:mm
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CitaService citaService = new CitaService();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== Menú de Gestión de Citas ===");
            System.out.println("1. Reservar cita");
            System.out.println("2. Cancelar cita");
            System.out.println("3. Listar todas las citas");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    reservarCita(sc, citaService);
                    break;
                case "2":
                    cancelarCita(sc, citaService);
                    break;
                case "3":
                    listarCitas(citaService);
                    break;
                case "0":
                    salir = true;
                    System.out.println("Saliendo... ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }

        sc.close();
    }

    private static void reservarCita(Scanner sc, CitaService service) {
        try {
            System.out.print("Ingrese ID de usuario: ");
            int usuarioId = Integer.parseInt(sc.nextLine());

            System.out.print("Ingrese ID de servicio: ");
            int servicioId = Integer.parseInt(sc.nextLine());

            System.out.print("Ingrese Fecha y Hora (formato YYYY-MM-DDTHH:MM): ");
            String fechaStr = sc.nextLine();
            LocalDateTime fechaHora = LocalDateTime.parse(fechaStr, dtf);

            boolean exito = service.reservarCita(usuarioId, servicioId, fechaHora);
            if (exito) {
                System.out.println("Cita registrada exitosamente.");
            } else {
                System.out.println("Error: Ya existe una cita en ese horario.");
            }
        } catch (Exception e) {
            System.out.println("Formato inválido o error al reservar: " + e.getMessage());
        }
    }

    private static void cancelarCita(Scanner sc, CitaService service) {
        try {
            System.out.print("Ingrese ID de la cita a cancelar: ");
            int citaId = Integer.parseInt(sc.nextLine());

            boolean exito = service.cancelarCita(citaId);
            if (exito) {
                System.out.println("Cita cancelada correctamente.");
            } else {
                System.out.println("No se encontró cita con ID " + citaId);
            }
        } catch (Exception e) {
            System.out.println("Error al cancelar cita: " + e.getMessage());
        }
    }

    private static void listarCitas(CitaService service) {
        List<Cita> citas = service.listarTodasCitas();
        if (citas.isEmpty()) {
            System.out.println("No hay citas registradas.");
        } else {
            System.out.println("\n--- Lista de Citas Registradas ---");
            for (Cita c : citas) {
                System.out.printf("ID: %d | Usuario ID: %d | Servicio ID: %d | FechaHora: %s | Estado: %s%n",
                        c.getId(),
                        c.getUsuarioId(),
                        c.getServicioId(),
                        c.getFechaHora().format(dtf),
                        c.getEstado());
            }
        }
    }
}
