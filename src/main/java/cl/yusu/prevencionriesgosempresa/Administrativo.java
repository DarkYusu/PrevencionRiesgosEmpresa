/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.yusu.prevencionriesgosempresa;

/**
 *
 * @author anton
 */
public class Administrativo extends Usuario {

    private String area;
    private String experienciaPrevia;

    public Administrativo() {
        super();
    }

    public Administrativo(String nombre, String fechaNacimiento, int run,
            String area, String experienciaPrevia) {
        super(nombre, fechaNacimiento, run);
        setArea(area);
        setExperienciaPrevia(experienciaPrevia);
    }

    public String getArea() {
        return area;
    }

    public boolean setArea(String area) {
        if (area == null || area.trim().length() < 5 ||
                area.trim().length() > 20) {
            return false;
        } else {
            this.area = area;
            return true;
        }
    }

    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }

    public boolean setExperienciaPrevia(String experienciaPrevia) {
        if (experienciaPrevia == null || experienciaPrevia.trim().length() > 100) {
            return false;
        } else {
            this.experienciaPrevia = experienciaPrevia;
            return true;
        }
    }

    @Override
    public String toString() {
        return "Administrativo{"
                + "area='" + area + '\''
                + ", experienciaPrevia='" + experienciaPrevia + '\''
                + "} " + super.toString();
    }

    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Area: " + this.area);
        System.out.println("Experiencia Previa: " + this.experienciaPrevia);
    }
}