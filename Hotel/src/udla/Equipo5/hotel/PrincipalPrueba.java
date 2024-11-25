package udla.Equipo5.hotel;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PrincipalPrueba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Hotel hotel = new Hotel("Hotel Quito", "Av. Gonzales Suarez");


        Habitacion hab1 = new Habitacion(101, "Individual", 50.0, true);
        Habitacion hab2 = new Habitacion(102, "Doble", 80.0, true);
        Habitacion hab3 = new Habitacion(103, "Suite", 150.0, false);


        hotel.agregarHabitacion(hab1);
        hotel.agregarHabitacion(hab2);
        hotel.agregarHabitacion(hab3);


        int opcion = 1;
        while (opcion == 1) {
            System.out.println(hotel.getNombre());
            System.out.println(hotel.getDireccion());
            System.out.println("Habitaciones disponibles antes de reservas:");
            List<Habitacion> disponibles = hotel.getHabitacionesDisponibles();


            for (int i = 0; i < disponibles.size(); i++) {
                Habitacion habitacion = disponibles.get(i);
                System.out.println("Habitación " + habitacion.getNumero() + " - " + habitacion.getTipo() + " - Precio: $" + habitacion.getPrecioPorNoche());
            }


            System.out.println("\nIngrese los datos de la reserva:");

            System.out.print("Nombre del cliente: ");
            String cliente = scanner.nextLine();

            System.out.print("Número de habitación que desea reservar: ");
            int numeroHabitacion = scanner.nextInt();


            Habitacion habitacionSeleccionada = null;
            List<Habitacion> habitacionesDisponibles = hotel.getHabitacionesDisponibles();
            for (int i = 0; i < habitacionesDisponibles.size(); i++) {
                Habitacion habitacion = habitacionesDisponibles.get(i);
                if (habitacion.getNumero() == numeroHabitacion) {
                    habitacionSeleccionada = habitacion;
                    break;
                }
            }

            if (habitacionSeleccionada != null) {
                // Si la habitación está disponible, proceder con la reserva
                System.out.print("Cantidad de días que desea reservar: ");
                int dias = scanner.nextInt();

                // Calcular fechas de inicio y fin
                Date fechaInicio = new Date(); // Fecha actual
                Date fechaFin = new Date(fechaInicio.getTime() + (long) dias * 24 * 60 * 60 * 1000);

                // Crear la reserva
                Reserva reserva = new Reserva(cliente, fechaInicio, fechaFin, habitacionSeleccionada);

                System.out.println("\nReserva creada exitosamente:");
                System.out.println("Cliente: " + reserva.getCliente());
                System.out.println("Habitación: " + habitacionSeleccionada.getNumero() + " - " + habitacionSeleccionada.getTipo());
                System.out.println("Costo total: $" + reserva.calcularCosto());
            } else {
                System.out.println("\nLo sentimos, la habitación seleccionada no está disponible.");
            }

            System.out.println("\nHabitaciones disponibles después de reservas:");
            disponibles = hotel.getHabitacionesDisponibles();

            for (int i = 0; i < disponibles.size(); i++) {
                Habitacion habitacion = disponibles.get(i);
                System.out.println("Habitación " + habitacion.getNumero() + " - " + habitacion.getTipo() + " - Precio: $" + habitacion.getPrecioPorNoche());
            }

            // Preguntar si se desea hacer otra reserva
            System.out.print("\n¿Desea hacer otra reserva? (1 para continuar, 0 para salir): ");
            scanner.nextLine();  // Limpiar el buffer
            opcion = scanner.nextInt(); // Leer opción de continuar o salir

        } // El ciclo termina si la opción no es 1

        // Cerrar el scanner
        scanner.close();
    }
}
