/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.yusu.prevencionriesgosempresa;

/**
 *
 * @author anton
 */
public class Capacitacion {

    private int identificador;
    private int rutCliente;
    private String dia;
    private String hora;
    private String lugar;
    private int duracion;
    private int cantidadAsistentes;

    public Capacitacion() {
    }

    public Capacitacion(int identificador, int rutCliente, String dia,
            String hora, String lugar,
            int duracion, int cantidadAsistentes) {
        setIdentificador(identificador);
        setRutCliente(rutCliente);
        setDia(dia);
        setHora(hora);
        setLugar(lugar);
        setDuracion(duracion);
        setCantidadAsistentes(cantidadAsistentes);
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        if (identificador <= 0) {
            throw new IllegalArgumentException("El identificador de la "
                    + "capacitacion es obligatorio y debe ser un "
                    + "numero positivo.");
        }
        this.identificador = identificador;
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(int rutCliente) {
        if (rutCliente <= 0) {
            throw new IllegalArgumentException("El RUT del cliente es "
                    + "obligatorio.");
        }
        this.rutCliente = rutCliente;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        if (!ValidadorFechaHora.isValidarDiaSemana(dia)) {
            throw new IllegalArgumentException("El día debe ser un valor "
                    + "valido entre 'lunes' y 'domingo'.");
        }
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        if (!ValidadorFechaHora.isValidarHora(hora)) {
            throw new IllegalArgumentException("La hora es obligatoria y debe "
                    + "tener el formato HH:MM.");
        }
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        if (lugar == null || lugar.trim().length() < 10 ||
                lugar.trim().length() > 50) {
            throw new IllegalArgumentException("El lugar es obligatorio y "
                    + "debe tener entre 10 y 50 caracteres.");
        }
        this.lugar = lugar;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion <= 0 || duracion > 70) {
            throw new IllegalArgumentException(
                    "La duración de la capacitación debe ser un número entre 1 y 70 minutos.");
        }
        this.duracion = duracion;
    }

    public int getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    public void setCantidadAsistentes(int cantidadAsistentes) {
        if (cantidadAsistentes <= 0 || cantidadAsistentes >= 1000) {
            throw new IllegalArgumentException("La cantidad de asistentes "
                    + "es obligatoria y debe ser un número entero mayor que"
                    + " 0 y menor que 1000.");
        }
        this.cantidadAsistentes = cantidadAsistentes;
    }

    @Override
    public String toString() {
        return "Capacitacion{" +
                "identificador=" + identificador +
                ", rutCliente=" + rutCliente +
                ", dia='" + dia + '\'' +
                ", hora='" + hora + '\'' +
                ", lugar='" + lugar + '\'' +
                ", duracion='" + duracion + '\'' +
                ", cantidadAsistentes=" + cantidadAsistentes +
                '}';
    }

    public String mostrarDetalle() {
        return "La capacitacion sera en " + this.lugar + " a las " + this.hora +
                " del dia " + this.dia + ", y durara " + this.duracion;
    }
}