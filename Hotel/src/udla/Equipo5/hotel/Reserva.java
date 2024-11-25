package udla.Equipo5.hotel;
import java.util.Date;

class Reserva {
    private String cliente;
    private Date fechaInicio;
    private Date fechaFin;
    private Habitacion habitacion;

    public Reserva(String cliente, Date fechaInicio, Date fechaFin, Habitacion habitacion) {
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.habitacion = habitacion;
        this.habitacion.setDisponible(false);
    }

    public String getCliente() {
        return cliente;
    }

    public double calcularCosto() {
        long FechaEyS = fechaFin.getTime() - fechaInicio.getTime();
        long dias = FechaEyS / (1000 * 60 * 60 * 24);
        return dias * habitacion.getPrecioPorNoche();
    }
}
