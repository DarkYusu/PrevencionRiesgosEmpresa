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

    public void setArea(String area) {
        if (area == null || area.trim().length() < 5 || 
                area.trim().length() > 20) {
            throw new IllegalArgumentException("El area es obligatoria y debe "
                    + "tener entre 5 y 20 caracteres.");
        }
        this.area = area;
    }

    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }

    public void setExperienciaPrevia(String experienciaPrevia) {
        if (experienciaPrevia != null 
                && experienciaPrevia.trim().length() > 100) {
            throw new IllegalArgumentException("La experiencia previa no puede "
                    + "exceder los 100 caracteres.");
        }
        this.experienciaPrevia = experienciaPrevia;
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
