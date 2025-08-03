/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.yusu.prevencionriesgosempresa;

/**
 *
 * @author anton
 */

public class Cliente extends Usuario {

    private int rut;
    private String apellidos;
    private String telefono;
    private String afp;
    private int sistemaSalud; // 1 (Fonasa) o 2 (Isapre)
    private String direccion;
    private String comuna;
    private int edad;

    public Cliente(String nombre, String fechaNacimiento, int run, int rut, String apellidos,
            String telefono, String afp, int sistemaSalud, String direccion,
            String comuna, int edad) {
        super(nombre, fechaNacimiento, run);
        setRut(rut);
        setApellidos(apellidos);
        setTelefono(telefono);
        setAfp(afp);
        setSistemaSalud(sistemaSalud);
        setDireccion(direccion);
        setComuna(comuna);
        setEdad(edad);
    }

    public int getRut() {
        return rut;
    }

    public boolean setRut(int rut) {
        if (rut > 0 && rut <= 99999999) {
            this.rut = rut;
            return true;
        } else {
            return false;
        }
    }

    public String getApellidos() {
        return apellidos;
    }

    public boolean setApellidos(String apellidos) {
        if (apellidos != null && apellidos.trim().length() >= 5 && apellidos.trim().length() <= 30) {
            this.apellidos = apellidos.trim();
            return true;
        } else {
            return false;
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean setTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            return false;
        } else {
            this.telefono = telefono.trim();
            return true;
        }
    }

    public String getAfp() {
        return afp;
    }

    public boolean setAfp(String afp) {
        if (afp == null || afp.trim().length() < 4 || afp.trim().length() > 30) {
            return false;
        } else {
            this.afp = afp.trim();
            return true;
        }
    }

    public int getSistemaSalud() {
        return sistemaSalud;
    }

    public boolean setSistemaSalud(int sistemaSalud) {
        if (sistemaSalud == 1 || sistemaSalud == 2) {
            this.sistemaSalud = sistemaSalud;
            return true;
        } else {
            return false;
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public boolean setDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty() || direccion.trim().length() > 70) {
            return false;
        } else {
            this.direccion = direccion.trim();
            return true;
        }
    }

    public String getComuna() {
        return comuna;
    }

    public boolean setComuna(String comuna) {
        if (comuna == null || comuna.trim().isEmpty() || comuna.trim().length() > 50) {
            return false;
        } else {
            this.comuna = comuna.trim();
            return true;
        }
    }

    public int getEdad() {
        return edad;
    }

    public boolean setEdad(int edad) {
        if (edad < 0 || edad >= 150) {
            return false;
        } else {
            this.edad = edad;
            return true;
        }
    }

    @Override
    public String toString() {
        return "Cliente{"
                + "rut=" + rut
                + ", apellidos='" + apellidos
                + super.toString();
    }

    public String obtenerNombre() {
        return this.nombre + " " + this.apellidos;
    }

    public String obtenerSistemaSalud() {
        if (this.sistemaSalud == 1) {
            return "Fonasa";
        } else if (this.sistemaSalud == 2) {
            return "Isapre";
        } else {
            return "Desconocido";
        }
    }

    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Direccion: " + this.direccion);
        System.out.println("Comuna: " + this.comuna);
    }
}
