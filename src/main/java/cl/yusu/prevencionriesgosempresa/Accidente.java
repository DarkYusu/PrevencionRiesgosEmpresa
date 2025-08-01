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

    public boolean setIdentificadorAccidente(int identificadorAccidente) {
        if (identificadorAccidente <= 0) {
            return false;
        } else {
            this.identificadorAccidente = identificadorAccidente;
            return true;
        }
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public boolean setRutCliente(int rutCliente) {
        if (rutCliente <= 0) {
            return false;
        } else {
            this.rutCliente = rutCliente;
            return false;
        }
    }

    public String getDia() {
        return dia;
    }

    public boolean setDia(String dia) {
        if (!ValidadorFechaHora.isValidarFecha(dia)) {
            return false;
        } else {
            this.dia = dia;
            return true;
        }
    }

    public String getHora() {
        return hora;
    }

    public boolean setHora(String hora) {
        if (!ValidadorFechaHora.isValidarHora(hora)) {
            return false;
        } else {
            this.hora = hora;
            return true;
        }
    }

    public String getLugar() {
        return lugar;
    }

    public boolean setLugar(String lugar) {
        if (lugar == null || lugar.trim().length() < 10
                || lugar.trim().length() > 50) {
            return false;
        } else {
            this.lugar = lugar;
            return true;
        }
    }

    public String getOrigen() {
        return origen;
    }

    public boolean setOrigen(String origen) {
        if (origen != null && origen.trim().length() > 100) {
            return false;
        } else {
            this.origen = origen;
            return true;
        }
    }

    public String getConsecuencias() {
        return consecuencias;
    }

    public boolean setConsecuencias(String consecuencias) {
        if (consecuencias != null && consecuencias.trim().length() > 100) {
            return false;
        } else {
            this.consecuencias = consecuencias;
            return true;
        }
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