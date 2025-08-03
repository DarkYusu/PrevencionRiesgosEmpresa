/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.yusu.prevencionriesgosempresa;

/**
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

    public boolean setIdentificador(int identificador) {
        if (identificador > 0) {
            this.identificador = identificador;
            return true;
        } else {
            return false;
        }
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public boolean setRutCliente(int rutCliente) {
        if (rutCliente > 0) {
            this.rutCliente = rutCliente;
            return true;
        }
        return false; // RUT inválido
    }

    public String getDia() {
        return dia;
    }

    public boolean setDia(String dia) {
        if (ValidadorFechaHora.isValidarDiaSemana(dia)) {
            this.dia = dia;
            return true;
        }
        return false; // Día inválido
    }

    public String getHora() {
        return hora;
    }

    public boolean setHora(String hora) {
        if (ValidadorFechaHora.isValidarHora(hora)) {
            this.hora = hora;
            return true;
        }
        return false; // Hora inválida
    }

    public String getLugar() {
        return lugar;
    }

    public boolean setLugar(String lugar) {
        if (lugar != null && lugar.trim().length() >= 10 && lugar.trim().length() <= 50) {
            this.lugar = lugar;
            return true;
        }
        return false; // Lugar inválido
    }

    public int getDuracion() {
        return duracion;
    }

    public boolean setDuracion(int duracion) {
        if (duracion > 0 && duracion <= 70) {
            this.duracion = duracion;
            return true;
        }
        return false; // Duración inválida
    }

    public int getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    public boolean setCantidadAsistentes(int cantidadAsistentes) {
        if (cantidadAsistentes > 0 && cantidadAsistentes < 1000) {
            this.cantidadAsistentes = cantidadAsistentes;
            return true;
        }
        return false; // Cantidad de asistentes inválida
    }

    @Override
    public String toString() {
        return "Capacitacion{"
                + "identificador=" + identificador
                + ", rutCliente=" + rutCliente
                + ", dia='" + dia + '\''
                + ", hora='" + hora + '\''
                + ", lugar='" + lugar + '\''
                + ", duracion='" + duracion + '\''
                + ", cantidadAsistentes=" + cantidadAsistentes
                + '}';
    }

    public String mostrarDetalle() {
        return "La capacitacion sera en " + this.lugar + " a las " + this.hora
                + " del dia " + this.dia + ", y durara " + this.duracion;
    }
}
