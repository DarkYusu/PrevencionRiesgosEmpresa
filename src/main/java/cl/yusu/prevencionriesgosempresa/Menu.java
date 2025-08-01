/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.yusu.prevencionriesgosempresa;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author anton
 */
public class Menu {

    private Contenedor contenedor;
    private Scanner scanner;

    public Menu(Contenedor contenedor) {
        this.contenedor = contenedor;
        scanner = new Scanner(System.in);
    }

    public void mostrar() {
        int opcion;
        do {
            System.out.println("----MENU PRINCIPAL----");
            System.out.println("[1] Almacenar cliente");
            System.out.println("[2] Almacenar profesional");
            System.out.println("[3] Almacenar administrativo");
            System.out.println("[4] Almacenar capacitacion");
            System.out.println("[5] Eliminar usuario");
            System.out.println("[6] Listar todos los usuarios");
            System.out.println("[7] Listar usuarios por tipo"); // cliente, admin o profesional
            System.out.println("[8] Listar capacitacion");
            System.out.println("[9] Salir del programa");
            System.out.print("Ingrese una opcion: ");
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1 ->
                    almacenarCliente();
                case 2 ->
                    almacenarProfesional();
                case 3 ->
                    almacenarAdministrativo();
                case 4 ->
                    almacenarCapacitacion();
                case 5 ->
                    eliminarUsuario();
                case 6 ->
                    listarUsuarios();
                case 7 ->
                    listarUsuariosPorTipo();
                case 8 ->
                    listarCapacitaciones();
                case 9 ->
                    System.out.println("Saliendo del sistema...");
                default ->
                    System.out.println("Opcion invalida. Ingrese un "
                            + "numero valido.");
            }
        } while (opcion != 9);
    }

    private int obtenerOpcion() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada invalida. Por favor, ingrese un numero.");
            scanner.nextLine();
            return -1;
        } finally {
            scanner.nextLine();
        }
    }

    private void almacenarCliente() {
        try {
            System.out.print("Nombre (10-50 caracteres): ");
            String nombre = scanner.nextLine();
            System.out.print("Fecha Nacimiento (DD/MM/AAAA): ");
            String fechaNacimiento = scanner.nextLine();
            System.out.print("RUN (sin puntos ni guion, < 99.999.999): ");
            int run = scanner.nextInt();
            scanner.nextLine();

            System.out.print("RUT Cliente (sin puntos ni guion): ");
            int rut = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nombres Cliente (5-30 caracteres): ");
            String nombres = scanner.nextLine();
            System.out.print("Apellidos Cliente (5-30 caracteres): ");
            String apellidos = scanner.nextLine();
            System.out.print("Telefono Cliente (max 15 caracteres): ");
            String telefono = scanner.nextLine();
            System.out.print("AFP Cliente (4-100 caracteres): ");
            String afp = scanner.nextLine();
            System.out.print("Sistema de Salud (1:Fonasa, 2:Isapre): ");
            int sistemaSalud = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Direccion Cliente (max 100 caracteres): ");
            String direccion = scanner.nextLine();
            System.out.print("Comuna Cliente (max 50 caracteres): ");
            String comuna = scanner.nextLine();
            System.out.print("Edad Cliente (>=0 y <150): ");
            int edad = scanner.nextInt();
            scanner.nextLine();

            Cliente cliente = new Cliente(nombre, fechaNacimiento, run, rut,
                    nombres, apellidos, telefono, afp, sistemaSalud, direccion,
                    comuna, edad);
            contenedor.almacenarCliente(cliente);

        } catch (InputMismatchException e) {
            System.out.println("Error: tipo de dato incorrecto. Asegurese de "
                    + "ingresar numeros para RUN, RUT, sistema de salud y "
                    + "edad.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validacion: " + e.getMessage());
        }
    }

    private void almacenarProfesional() {
        try {
            System.out.print("Nombre (10-50 caracteres): ");
            String nombre = scanner.nextLine();
            System.out.print("Fecha Nacimiento (DD/MM/AAAA): ");
            String fechaNacimiento = scanner.nextLine();
            System.out.print("RUN (sin puntos ni guion, < 99.999.999): ");
            int run = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Titulo (10-50 caracteres): ");
            String titulo = scanner.nextLine();
            System.out.print("Fecha de Ingreso (DD/MM/AAAA): ");
            String fechaIngreso = scanner.nextLine();

            Profesional profesional = new Profesional(nombre, fechaNacimiento,
                    run,
                    titulo, fechaIngreso);
            contenedor.almacenarProfesional(profesional);

        } catch (InputMismatchException e) {
            System.out.println("Error: tipo de dato incorrecto. Asegurese de "
                    + "ingresar numeros para RUN.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validacion: " + e.getMessage());
        }
    }

    private void almacenarAdministrativo() {
        try {
            System.out.print("Nombre (10-50 caracteres): ");
            String nombre = scanner.nextLine();
            System.out.print("Fecha Nacimiento (DD/MM/AAAA): ");
            String fechaNacimiento = scanner.nextLine();
            System.out.print("RUN (sin puntos ni guion, < 99.999.999): ");
            int run = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Area (5-20 caracteres): ");
            String area = scanner.nextLine();
            System.out.print("Experiencia Previa (max 100 caracteres): ");
            String experienciaPrevia = scanner.nextLine();

            Administrativo administrativo = new Administrativo(nombre,
                    fechaNacimiento, run,
                    area, experienciaPrevia);
            contenedor.almacenarAdministrativo(administrativo);

        } catch (InputMismatchException e) {
            System.out.println("Error: tipo de dato incorrecto. Asegurese de "
                    + "ingresar numeros para RUN.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validacion: " + e.getMessage());
        }
    }

    private void eliminarUsuario() {
        try {
            System.out.print("RUN del usuario a eliminar: ");
            int run = scanner.nextInt();
            scanner.nextLine();
            contenedor.eliminarUsuario(run);
        } catch (InputMismatchException e) {
            System.out.println("Error: debe ingresar un numero para el RUN.");
            scanner.nextLine();
        }
    }

    private void listarUsuarios() {
        contenedor.listarUsuarios();
    }

    private void listarUsuariosPorTipo() {
        System.out.print("Tipo de usuario (Cliente, Profesional, "
                + "Administrativo): ");
        String tipo = scanner.nextLine();
        contenedor.listarUsuariosPorTipo(tipo);
    }

    // --- Métodos para Gestión de Capacitaciones ---
    private void almacenarCapacitacion() {
        try {
            System.out.print("Identificador Capacitacion (positivo): ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            System.out.print("RUT Cliente (sin puntos ni guion): ");
            int rutCliente = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Dia (Lunes a Domingo): ");
            String dia = scanner.nextLine();
            System.out.print("Hora (HH:MM): ");
            String hora = scanner.nextLine();
            System.out.print("Lugar (10-50 caracteres): ");
            String lugar = scanner.nextLine();
            System.out.print("Duracion (max 70 caracteres): ");
            int duracion = scanner.nextInt();
            System.out.print("Cantidad de asistentes (1-999): ");
            int asistentes = scanner.nextInt();
            scanner.nextLine();

            Capacitacion capacitacion = new Capacitacion(id, rutCliente,
                    dia, hora, lugar, duracion, asistentes);
            contenedor.almacenarCapacitacion(capacitacion);

        } catch (InputMismatchException e) {
            System.out.println("Error: tipo de dato incorrecto. Asegúrese de "
                    + "ingresar números para identificador, RUT y asistentes.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validacion: " + e.getMessage());
        }
    }

    private void listarCapacitaciones() {
        contenedor.listarCapacitaciones();
    }

}
