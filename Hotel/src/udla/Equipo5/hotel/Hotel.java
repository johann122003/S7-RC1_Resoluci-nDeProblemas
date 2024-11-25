package udla.Equipo5.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nombre;
    private String direccion;
    private List<Habitacion> habitaciones;

    public Hotel(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.habitaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void agregarHabitacion(Habitacion habitacion) {
        this.habitaciones.add(habitacion);
    }

    public List<Habitacion> getHabitacionesDisponibles() {
        List<Habitacion> disponibles = new ArrayList<>();

        for (int i = 0; i < habitaciones.size(); i++) {
            Habitacion habitacion = habitaciones.get(i);
            if (habitacion.isDisponible()) {
                disponibles.add(habitacion);
            }
        }
        return disponibles;
    }
}