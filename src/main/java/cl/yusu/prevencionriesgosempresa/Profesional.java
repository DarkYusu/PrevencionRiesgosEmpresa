/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.yusu.prevencionriesgosempresa;

/**
 *
 * @author anton
 */
public class Profesional extends Usuario {

    private String titulo;
    private String fechaIngreso;

    public Profesional() {
        super();
    }

    public Profesional(String nombre, String fechaNacimiento, int run,
            String titulo, String fechaIngreso) {
        super(nombre, fechaNacimiento, run);
        setTitulo(titulo);
        setFechaIngreso(fechaIngreso);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().length() < 10 || 
                titulo.trim().length() > 50) {
            throw new IllegalArgumentException("El titulo es obligatorio "
                    + "y debe tener entre 10 y 50 caracteres.");
        }
        this.titulo = titulo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        if (!ValidadorFechaHora.isValidarFecha(fechaIngreso)) {
            throw new IllegalArgumentException("La fecha de ingreso es "
                    + "obligatoria y debe tener el formato DD/MM/AAAA.");
        }
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return "Profesional{"
                + "titulo='" + titulo + '\''
                + ", fechaIngreso='" + fechaIngreso + '\''
                + "} " + super.toString();
    }

    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Fecha de Ingreso: " + this.fechaIngreso);
    }
}
