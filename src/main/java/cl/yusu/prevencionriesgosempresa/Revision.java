/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.yusu.prevencionriesgosempresa;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author anton
 */
public class Revision {

    private int identificadorRevision;
    private int identificadorVisitaTerreno;
    private String nombreAlusivoRevision;
    private String detalleParaRevisar;
    private int estado;

    private static final List<Integer> ESTADOS_PERMITIDOS = Arrays.asList(1, 2, 3);

    public Revision() {
    }

    public Revision(int identificadorRevision, int identificadorVisitaTerreno,
            String nombreAlusivoRevision,
            String detalleParaRevisar, int estado) {
        setIdentificadorRevision(identificadorRevision);
        setIdentificadorVisitaTerreno(identificadorVisitaTerreno);
        setNombreAlusivoRevision(nombreAlusivoRevision);
        setDetalleParaRevisar(detalleParaRevisar);
        setEstado(estado);
    }

    public int getIdentificadorRevision() {
        return identificadorRevision;
    }

    public void setIdentificadorRevision(int identificadorRevision) {
        if (identificadorRevision <= 0) {
            throw new IllegalArgumentException("El identificador de la "
                    + "revision es obligatorio y debe ser un número positivo.");
        }
        this.identificadorRevision = identificadorRevision;
    }

    public int getIdentificadorVisitaTerreno() {
        return identificadorVisitaTerreno;
    }

    public void setIdentificadorVisitaTerreno(int identificadorVisitaTerreno) {
        if (identificadorVisitaTerreno <= 0) {
            throw new IllegalArgumentException("El identificador de la visita "
                    + "en terreno es obligatorio.");
        }
        this.identificadorVisitaTerreno = identificadorVisitaTerreno;
    }

    public String getNombreAlusivoRevision() {
        return nombreAlusivoRevision;
    }

    public void setNombreAlusivoRevision(String nombreAlusivoRevision) {
        if (nombreAlusivoRevision == null ||
                nombreAlusivoRevision.trim().length() < 10 ||
                nombreAlusivoRevision.trim().length() > 50) {
            throw new IllegalArgumentException("El nombre alusivo a "
                    + "la revision es obligatorio y debe tener entre "
                    + "10 y 50 caracteres.");
        }
        this.nombreAlusivoRevision = nombreAlusivoRevision;
    }

    public String getDetalleParaRevisar() {
        return detalleParaRevisar;
    }

    public void setDetalleParaRevisar(String detalleParaRevisar) {
        if (detalleParaRevisar != null &&
                detalleParaRevisar.trim().length() > 100) {
            throw new IllegalArgumentException("El detalle para revisar no"
                    + " puede exceder los 100 caracteres.");
        }
        this.detalleParaRevisar = detalleParaRevisar;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        if (!ESTADOS_PERMITIDOS.contains(estado)) {
            throw new IllegalArgumentException("El estado debe ser 1 "
                    + "(sin problemas), 2 (con observaciones) o 3 "
                    + "(no aprueba).");
        }
        this.estado = estado;
    }

    @Override
    public String toString() {
        String estadoStr;
        switch (estado) {
            case 1:
                estadoStr = "Sin problemas";
                break;
            case 2:
                estadoStr = "Con observaciones";
                break;
            case 3:
                estadoStr = "No aprueba";
                break;
            default:
                estadoStr = "Desconocido";
        }
        return "Revision{" +
                "identificadorRevision=" + identificadorRevision +
                ", identificadorVisitaTerreno=" + identificadorVisitaTerreno +
                ", nombreAlusivoRevision='" + nombreAlusivoRevision + '\'' +
                ", detalleParaRevisar='" + detalleParaRevisar + '\'' +
                ", estado=" + estadoStr +
                '}';
    }
}