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
    private String nombres;
    private String apellidos;
    private String telefono;
    private String afp;
    private int sistemaSalud; // 1 (Fonasa) o 2 (Isapre)
    private String direccion;
    private String comuna;
    private int edad;

    public Cliente() {
        super();
    }

    public Cliente(String nombre, String fechaNacimiento, int run, int rut,
            String nombres, String apellidos,
            String telefono, String afp, int sistemaSalud, String direccion,
            String comuna, int edad) {
        super(nombre, fechaNacimiento, run);
        setRut(rut);
        setNombres(nombres);
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

    public void setRut(int rut) {
        if (rut < 0 || rut >= 99999999) {
            throw new IllegalArgumentException("El RUT debe ser un numero positivo menor a 99.999.999.");
        }
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        if (nombres == null || nombres.trim().length() < 5
                || nombres.trim().length() > 30) {
            throw new IllegalArgumentException("Los nombres son obligatorios y"
                    + " deben tener entre 5 y 30 caracteres.");
        }
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        if (apellidos == null || apellidos.trim().length() < 5
                || apellidos.trim().length() > 30) {
            throw new IllegalArgumentException("Los apellidos son obligatorios "
                    + "y deben tener entre 5 y 30 caracteres.");
        }
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new IllegalArgumentException("El teléfono es obligatorio.");
        }
        this.telefono = telefono;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        if (afp == null || afp.trim().length() < 4
                || afp.trim().length() > 30) {
            throw new IllegalArgumentException("La AFP debe tener entre 4 y 30 "
                    + "caracteres.");
        }
        this.afp = afp;
    }

    public int getSistemaSalud() {
        return sistemaSalud;
    }

    public void setSistemaSalud(int sistemaSalud) {
        if (sistemaSalud != 1 && sistemaSalud != 2) {
            throw new IllegalArgumentException("El sistema de salud debe ser 1 "
                    + "(Fonasa) o 2 (Isapre).");
        }
        this.sistemaSalud = sistemaSalud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion != null && direccion.trim().length() > 70) {
            throw new IllegalArgumentException("La dirección no puede exceder "
                    + "los 70 caracteres.");
        }
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        if (comuna != null && comuna.trim().length() > 50) {
            throw new IllegalArgumentException("La comuna no puede exceder los "
                    + "50 caracteres.");
        }
        this.comuna = comuna;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 0 || edad >= 150) {
            throw new IllegalArgumentException("La edad es obligatoria y debe "
                    + "ser mayor o igual a cero y menor a 150.");
        }
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Cliente{"
                + "rut=" + rut
                + ", nombres='" + nombres + '\''
                + ", apellidos='" + apellidos + '\''
                + ", telefono='" + telefono + '\''
                + ", afp='" + afp + '\''
                + ", sistemaSalud=" + sistemaSalud
                + ", direccion='" + direccion + '\''
                + ", comuna='" + comuna + '\''
                + ", edad=" + edad
                + "} " + super.toString();
    }

    public String obtenerNombre() {
        return this.nombres + " " + this.apellidos;
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
