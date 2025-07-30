/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.yusu.prevencionriesgosempresa;

/**
 *
 * @author anton
 */
public class Accidente {

    private int identificadorAccidente;
    private int rutCliente;
    private String dia;
    private String hora;
    private String lugar;
    private String origen;
    private String consecuencias;

    public Accidente() {
    }

    public Accidente(int identificadorAccidente, int rutCliente,
            String dia, String hora, String lugar,
            String origen, String consecuencias) {
        setIdentificadorAccidente(identificadorAccidente);
        setRutCliente(rutCliente);
        setDia(dia);
        setHora(hora);
        setLugar(lugar);
        setOrigen(origen);
        setConsecuencias(consecuencias);
    }

    public int getIdentificadorAccidente() {
        return identificadorAccidente;
    }

    public void setIdentificadorAccidente(int identificadorAccidente) {
        if (identificadorAccidente <= 0) {
            throw new IllegalArgumentException("El identificador del accidente "
                    + "es obligatorio y debe ser un numero positivo.");
        }
        this.identificadorAccidente = identificadorAccidente;
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
        if (!ValidadorFechaHora.isValidarFecha(dia)) {
            throw new IllegalArgumentException("El dia del accidente es "
                    + "obligatorio y debe tener el formato DD/MM/AAAA.");
        }
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        if (!ValidadorFechaHora.isValidarHora(hora)) {
            throw new IllegalArgumentException("La hora del accidente es "
                    + "obligatoria y debe tener el formato HH:MM.");
        }
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        if (lugar == null || lugar.trim().length() < 10
                || lugar.trim().length() > 50) {
            throw new IllegalArgumentException("El lugar del accidente es "
                    + "obligatorio y debe tener entre 10 y 50 caracteres.");
        }
        this.lugar = lugar;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        if (origen != null && origen.trim().length() > 100) {
            throw new IllegalArgumentException("El origen no puede exceder los "
                    + "100 caracteres.");
        }
        this.origen = origen;
    }

    public String getConsecuencias() {
        return consecuencias;
    }

    public void setConsecuencias(String consecuencias) {
        if (consecuencias != null && consecuencias.trim().length() > 100) {
            throw new IllegalArgumentException("Las consecuencias no pueden "
                    + "exceder los 100 caracteres.");
        }
        this.consecuencias = consecuencias;
    }

    @Override
    public String toString() {
        return "Accidente{" +
                "identificadorAccidente=" + identificadorAccidente +
                ", rutCliente=" + rutCliente +
                ", dia='" + dia + '\'' +
                ", hora='" + hora + '\'' +
                ", lugar='" + lugar + '\'' +
                ", origen='" + origen + '\'' +
                ", consecuencias='" + consecuencias + '\'' +
                '}';
    }
}
