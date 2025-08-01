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
        if (scanner.hasNextInt()) {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return opcion;
        } else {
            System.out.println("Entrada invalida. Por favor, ingrese un numero.");
            scanner.nextLine();
            return -1;
        }
    }

    private void almacenarCliente() {
        String nombre, fechaNacimiento, apellidos, telefono, afp, direccion, comuna;
        int run, rut, sistemaSalud, edad;

        do {
            System.out.print("Nombre (10-50 caracteres): ");
            nombre = scanner.nextLine();

        } while (nombre.length() < 10 || nombre.length() > 50);

        do {
            System.out.print("Fecha Nacimiento (DD/MM/AAAA): ");
            fechaNacimiento = scanner.nextLine();
        } while (!ValidadorFechaHora.isValidarFecha(fechaNacimiento));

        do {
            System.out.print("RUN (sin puntos ni guion, < 99999999): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Debe ingresar un número válido.");
                scanner.next();
            }
            run = scanner.nextInt();
            scanner.nextLine();
        } while (run <= 0 || run >= 99999999);

        do {
            System.out.print("RUT Cliente (sin puntos ni guion): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Debe ingresar un número válido.");
                scanner.next();
            }
            rut = scanner.nextInt();
            scanner.nextLine();
        } while (rut <= 0);

        do {
            System.out.print("Apellidos Cliente (5-30 caracteres): ");
            apellidos = scanner.nextLine();
        } while (apellidos.length() < 5 || apellidos.length() > 30);

        do {
            System.out.print("Telefono Cliente (max 15 caracteres): ");
            telefono = scanner.nextLine();
        } while (telefono.length() == 0 || telefono.length() > 15);

        do {
            System.out.print("AFP Cliente (4-100 caracteres): ");
            afp = scanner.nextLine();
        } while (afp.length() < 4 || afp.length() > 100);

        do {
            System.out.print("Sistema de Salud (1:Fonasa, 2:Isapre): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Debe ingresar 1 o 2.");
                scanner.next();
            }
            sistemaSalud = scanner.nextInt();
            scanner.nextLine();
        } while (sistemaSalud != 1 && sistemaSalud != 2);

        do {
            System.out.print("Direccion Cliente (max 100 caracteres): ");
            direccion = scanner.nextLine();
        } while (direccion.length() == 0 || direccion.length() > 100);

        do {
            System.out.print("Comuna Cliente (max 50 caracteres): ");
            comuna = scanner.nextLine();
        } while (comuna.length() == 0 || comuna.length() > 50);

        do {
            System.out.print("Edad Cliente (>=0 y <150): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Debe ingresar una edad válida.");
                scanner.next();
            }
            edad = scanner.nextInt();
            scanner.nextLine();
        } while (edad < 0 || edad >= 150);

        Cliente cliente = new Cliente(nombre, fechaNacimiento, run, rut, apellidos, telefono, afp, sistemaSalud,
                direccion, comuna, edad);

        contenedor.almacenarCliente(cliente);
    }

    private void almacenarProfesional() {
        Profesional profesional = new Profesional();

        while (true) {
            System.out.print("Nombre (10-50 caracteres): ");
            String nombre = scanner.nextLine();
            if (profesional.setNombre(nombre)) {
                break;
            } else {
                System.out.println("Entrada invalida");
            }
        }

        while (true) {
            System.out.print("Fecha Nacimiento (DD/MM/AAAA): ");
            String fechaNacimiento = scanner.nextLine();
            if (profesional.setFechaNacimiento(fechaNacimiento)) {
                break;
            } else {
                System.out.println("Entrada invalida");
            }
        }

        while (true) {
            System.out.print("RUN (sin puntos ni guion, < 99.999.999): ");
            int run = scanner.nextInt();
            scanner.nextLine();
            if (profesional.setRun(run)) {
                break;
            } else {
                System.out.println("Entrada invalida");
            }
        }

        while (true) {
            System.out.print("Titulo (10-50 caracteres): ");
            String titulo = scanner.nextLine();
            if (profesional.setTitulo(titulo)) {
                break;
            } else {
                System.out.println("Entrada invalida");
            }
        }

        while (true) {
            System.out.print("Fecha de Ingreso (DD/MM/AAAA): ");
            String fechaIngreso = scanner.nextLine();
            if (profesional.setFechaIngreso(fechaIngreso)) {
                break;
            } else {
                System.out.println("Entrada invalida");
            }
        }
        contenedor.almacenarProfesional(profesional);
    }

    private void almacenarAdministrativo() {
        String nombre, fechaNacimiento, area, experienciaPrevia;
        int run;

        do {
            System.out.print("Nombre (10-50 caracteres): ");
            nombre = scanner.nextLine();
        } while (nombre.length() < 10 || nombre.length() > 50);

        do {
            System.out.print("Fecha Nacimiento (DD/MM/AAAA): ");
            fechaNacimiento = scanner.nextLine();
        } while (!ValidadorFechaHora.isValidarFecha(fechaNacimiento));

        do {
            System.out.print("RUN (sin puntos ni guion, < 99999999): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Debe ingresar un número válido.");
                scanner.next();
            }
            run = scanner.nextInt();
            scanner.nextLine();
        } while (run <= 0 || run >= 99999999);

        do {
            System.out.print("Area (5-20 caracteres): ");
            area = scanner.nextLine();
        } while (area.length() < 5 || area.length() > 20);

        do {
            System.out.print("Experiencia Previa (max 100 caracteres): ");
            experienciaPrevia = scanner.nextLine();
        } while (experienciaPrevia.length() == 0 || experienciaPrevia.length() > 100);

        Administrativo administrativo = new Administrativo(nombre,
                fechaNacimiento, run, area, experienciaPrevia);
        contenedor.almacenarAdministrativo(administrativo);
    }

    private void eliminarUsuario() {
        System.out.print("RUN del usuario a eliminar: ");
        String input = scanner.nextLine();

        if (input.matches("\\d+")) {
            int run = Integer.parseInt(input);
            contenedor.eliminarUsuario(run);
        } else {
            System.out.println("Error: debe ingresar un número válido para el RUN.");
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
