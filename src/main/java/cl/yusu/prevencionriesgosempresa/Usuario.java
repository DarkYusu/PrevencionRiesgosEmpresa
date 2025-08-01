/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.yusu.prevencionriesgosempresa;

/**
 *
 * @author anton
 */
public class Usuario implements Asesoria {

    protected String nombre;
    protected String fechaNacimiento;
    protected int run;

    public Usuario() {
    }

    public Usuario(String nombre, String fechaNacimiento, int run) {
        setNombre(nombre);
        setFechaNacimiento(fechaNacimiento);
        setRun(run);
    }

    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nombre) {
        if (nombre == null || nombre.trim().length() < 10
                || nombre.trim().length() > 50) {
            return false;
        } else {
            this.nombre = nombre;
            return true;
        }
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public boolean setFechaNacimiento(String fechaNacimiento) {
        if (!ValidadorFechaHora.isValidarFecha(fechaNacimiento)) {
            return false;
        } else {
            this.fechaNacimiento = fechaNacimiento;
            return true;
        }
    }

    public int getRun() {
        return run;
    }

    public boolean setRun(int run) {
        if (run >= 0 && run < 99999999) {
            this.run = run;
            return true;
        } else {
            return false;
        }
    }

    public String mostrarEdad() {
        if (fechaNacimiento == null || fechaNacimiento.trim().isEmpty()) {
            return "No se puede calcular la edad, fecha de nacimiento no "
                    + "disponible.";
        }
        try {
            String[] partesFecha = fechaNacimiento.split("/");
            int anioNacimiento = Integer.parseInt(partesFecha[2]);
            int anioActual = java.time.Year.now().getValue();
            int edad = anioActual - anioNacimiento;
            return "El usuario tiene " + edad + " años";
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return "No se puede calcular la edad debido a un formato de fecha "
                    + "invalido.";
        }
    }

    @Override
    public String toString() {
        return "Usuario{"
                + "nombre='" + nombre + '\''
                + ", fechaNacimiento='" + fechaNacimiento + '\''
                + ", run=" + run
                + '}';
    }

    @Override
    public void analizarUsuario() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("RUN: " + this.run);
    }
}
