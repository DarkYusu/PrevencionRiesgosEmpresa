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

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().length() < 10
                || nombre.trim().length() > 50) {
            throw new IllegalArgumentException("El nombre es obligatorio y debe tener entre 10 y 50 caracteres.");
        }
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        if (!ValidadorFechaHora.isValidarFecha(fechaNacimiento)) {
            throw new IllegalArgumentException("La fecha de nacimiento"
                    + "es obligatoria y debe tener el formato DD/MM/AAAA.");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        if (run < 0 || run >= 99999999) {
            throw new IllegalArgumentException("El RUN debe ser un numero"
                    + " positivo menor a 99.999.999.");
        }
        this.run = run;
    }

    @Override
    public String toString() {
        return "Usuario{"
                + "nombre='" + nombre + '\''
                + ", fechaNacimiento='" + fechaNacimiento + '\''
                + ", run=" + run
                + '}';
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
    public void analizarUsuario() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("RUN: " + this.run);
    }
}
