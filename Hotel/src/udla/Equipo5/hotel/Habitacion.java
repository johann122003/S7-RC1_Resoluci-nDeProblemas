package udla.Equipo5.hotel;

class Habitacion {
    private int numero;
    private String tipo;
    private double precioPorNoche;
    private boolean disponible;

    public Habitacion(int numero, String tipo, double precioPorNoche, boolean disponible) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.disponible = disponible;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }
}