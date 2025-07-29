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

    public void setIdentificadorVisitaTerreno(int identificadorVisitaTerreno) {
        if (identificadorVisitaTerreno <= 0) {
            throw new IllegalArgumentException("El identificador de la visita "
                    + "en terreno es obligatorio y debe ser un numero"
                    + " positivo.");
        }
        this.identificadorVisitaTerreno = identificadorVisitaTerreno;
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
            throw new IllegalArgumentException("El dia de la visita en terreno "
                    + "es obligatorio y debe tener el formato DD/MM/AAAA.");
        }
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        if (!ValidadorFechaHora.isValidarHora(hora)) {
            throw new IllegalArgumentException("La hora de la visita en "
                    + "terreno es obligatoria y debe tener el formato HH:MM.");
        }
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        if (lugar == null || lugar.trim().length() < 10 || 
                lugar.trim().length() > 50) {
            throw new IllegalArgumentException("El lugar de la visita en "
                    + "terreno es obligatorio y debe tener entre 10 y 50"
                    + " caracteres.");
        }
        this.lugar = lugar;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        if (comentarios != null && comentarios.trim().length() > 100) {
            throw new IllegalArgumentException("Los comentarios no pueden "
                    + "exceder los 100 caracteres.");
        }
        this.comentarios = comentarios;
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
