/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.yusu.prevencionriesgosempresa;

/**
 *
 * @author anton
 */
public class VisitaEnTerreno {

    private int identificadorVisitaTerreno;
    private int rutCliente;
    private String dia;
    private String hora;
    private String lugar;
    private String comentarios;

    public VisitaEnTerreno() {
    }

    public VisitaEnTerreno(int identificadorVisitaTerreno, int rutCliente,
            String dia, String hora,
            String lugar, String comentarios) {
        setIdentificadorVisitaTerreno(identificadorVisitaTerreno);
        setRutCliente(rutCliente);
        setDia(dia);
        setHora(hora);
        setLugar(lugar);
        setComentarios(comentarios);
    }

    public int getIdentificadorVisitaTerreno() {
        return identificadorVisitaTerreno;
    }

    public boolean setIdentificadorVisitaTerreno(int identificadorVisitaTerreno) {
        if (identificadorVisitaTerreno <= 0) {
            return false;
        }
        this.identificadorVisitaTerreno = identificadorVisitaTerreno;
        return true;
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public boolean setRutCliente(int rutCliente) {
        if (rutCliente <= 0) {
            return false;
        }
        this.rutCliente = rutCliente;
        return true;
    }

    public String getDia() {
        return dia;
    }

    public boolean setDia(String dia) {
        if (!ValidadorFechaHora.isValidarFecha(dia)) {
            return false;
        }
        this.dia = dia;
        return true;
    }

    public String getHora() {
        return hora;
    }

    public boolean setHora(String hora) {
        if (!ValidadorFechaHora.isValidarHora(hora)) {
            return false;
        }
        this.hora = hora;
        return true;
    }

    public String getLugar() {
        return lugar;
    }

    public boolean setLugar(String lugar) {
        if (lugar == null || lugar.trim().length() < 10 || lugar.trim().length() > 50) {
            return false;
        }
        this.lugar = lugar;
        return true;
    }

    public String getComentarios() {
        return comentarios;
    }

    public boolean setComentarios(String comentarios) {
        if (comentarios != null && comentarios.trim().length() > 100) {
            return false;
        }
        this.comentarios = comentarios;
        return true;
    }

    @Override
    public String toString() {
        return "VisitaEnTerreno{" +
                "identificadorVisitaTerreno=" + identificadorVisitaTerreno +
                ", rutCliente=" + rutCliente +
                ", dia='" + dia + '\'' +
                ", hora='" + hora + '\'' +
                ", lugar='" + lugar + '\'' +
                ", comentarios='" + comentarios + '\'' +
                '}';
    }
}