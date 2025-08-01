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

    public boolean setIdentificadorRevision(int identificadorRevision) {
        if (identificadorRevision <= 0) {
            return false;
        } else {
            this.identificadorRevision = identificadorRevision;
            return true;
        }
    }

    public int getIdentificadorVisitaTerreno() {
        return identificadorVisitaTerreno;
    }

    public boolean setIdentificadorVisitaTerreno(int identificadorVisitaTerreno) {
        if (identificadorVisitaTerreno <= 0) {
            return false;
        } else {
            this.identificadorVisitaTerreno = identificadorVisitaTerreno;
            return true;
        }
    }

    public String getNombreAlusivoRevision() {
        return nombreAlusivoRevision;
    }

    public boolean setNombreAlusivoRevision(String nombreAlusivoRevision) {
        if (nombreAlusivoRevision == null ||
                nombreAlusivoRevision.trim().length() < 10 ||
                nombreAlusivoRevision.trim().length() > 50) {
            return false;
        } else {
            this.nombreAlusivoRevision = nombreAlusivoRevision;
            return true;
        }
    }

    public String getDetalleParaRevisar() {
        return detalleParaRevisar;
    }

    public boolean setDetalleParaRevisar(String detalleParaRevisar) {
        if (detalleParaRevisar != null &&
                detalleParaRevisar.trim().length() > 100) {
            return false;
        } else {
            this.detalleParaRevisar = detalleParaRevisar;
            return true;
        }

    }

    public int getEstado() {
        return estado;
    }

    public boolean setEstado(int estado) {
        if (!ESTADOS_PERMITIDOS.contains(estado)) {
            return false;
        } else {
            this.estado = estado;
            return true;
        }
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