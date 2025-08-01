/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.yusu.prevencionriesgosempresa;

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
        if (nombre.length() < 10 || nombre.length() > 50) {
            System.out.println("Error: el nombre debe tener entre 10 y 50 caracteres.");
        }
        do {
            System.out.print("Fecha Nacimiento (DD/MM/AAAA): ");
            fechaNacimiento = scanner.nextLine();
            if (!ValidadorFechaHora.isValidarFecha(fechaNacimiento)) {
                System.out.println("Error: debe ingresar una fecha valida con formato DD/MM/AAAA.");
            }
        } while (!ValidadorFechaHora.isValidarFecha(fechaNacimiento));

        do {
            System.out.print("RUN (sin puntos ni guion, < 99999999): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un numero valido.");
                scanner.next();
            }
            run = scanner.nextInt();
            scanner.nextLine();
            if (run <= 0 || run >= 99999999) {
                System.out.println("Error: el RUN debe ser mayor a 0 y menor a 99.999.999.");
            }
        } while (run <= 0 || run >= 99999999);

        do {
            System.out.print("RUT Cliente (sin puntos ni guion): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un numero valido.");
                scanner.next();
            }
            rut = scanner.nextInt();
            scanner.nextLine();
            if (rut <= 0) {
                System.out.println("Error: el RUT debe ser mayor a 0.");
            }
        } while (rut <= 0);

        do {
            System.out.print("Apellidos Cliente (5-30 caracteres): ");
            apellidos = scanner.nextLine();
            if (apellidos.length() < 5 || apellidos.length() > 30) {
                System.out.println("Error: los apellidos deben tener entre 5 y 30 caracteres.");
            }
        } while (apellidos.length() < 5 || apellidos.length() > 30);

        do {
            System.out.print("Telefono Cliente (max 15 caracteres): ");
            telefono = scanner.nextLine();
            if (telefono.length() == 0 || telefono.length() > 15) {
                System.out.println("Error: el telefono no puede estar vacio ni superar los 15 caracteres.");
            }
        } while (telefono.length() == 0 || telefono.length() > 15);

        do {
            System.out.print("AFP Cliente (4-100 caracteres): ");
            afp = scanner.nextLine();
            if (afp.length() < 4 || afp.length() > 100) {
                System.out.println("Error: la AFP debe tener entre 4 y 100 caracteres.");
            }
        } while (afp.length() < 4 || afp.length() > 100);

        do {
            System.out.print("Sistema de Salud (1:Fonasa, 2:Isapre): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar 1 o 2.");
                scanner.next();
            }
            sistemaSalud = scanner.nextInt();
            scanner.nextLine();
            if (sistemaSalud != 1 && sistemaSalud != 2) {
                System.out.println("Error: el sistema de salud debe ser 1 (Fonasa) o 2 (Isapre).");
            }
        } while (sistemaSalud != 1 && sistemaSalud != 2);

        do {
            System.out.print("Direccion Cliente (max 100 caracteres): ");
            direccion = scanner.nextLine();
            if (direccion.length() == 0 || direccion.length() > 100) {
                System.out.println("Error: la direccion no puede estar vacia ni superar los 100 caracteres.");
            }
        } while (direccion.length() == 0 || direccion.length() > 100);

        do {
            System.out.print("Comuna Cliente (max 50 caracteres): ");
            comuna = scanner.nextLine();
            if (comuna.length() == 0 || comuna.length() > 50) {
                System.out.println("Error: la comuna no puede estar vacia ni superar los 50 caracteres.");
            }
        } while (comuna.length() == 0 || comuna.length() > 50);

        do {
            System.out.print("Edad Cliente (>=0 y <150): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar una edad valida.");
                scanner.next();
            }
            edad = scanner.nextInt();
            scanner.nextLine();
            if (edad < 0 || edad >= 150) {
                System.out.println("Error: la edad debe ser mayor o igual a 0 y menor a 150.");
            }
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
            if (!profesional.setNombre(nombre)) {
                System.out.println("Error: el nombre debe tener entre 10 y 50 caracteres.");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Fecha Nacimiento (DD/MM/AAAA): ");
            String fechaNacimiento = scanner.nextLine();
            if (!profesional.setFechaNacimiento(fechaNacimiento)) {
                System.out.println("Error: debe ingresar una fecha valida con formato DD/MM/AAAA.");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("RUN (sin puntos ni guion, < 99.999.999): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un numero valido.");
                scanner.next();
            }
            int run = scanner.nextInt();
            scanner.nextLine();
            if (!profesional.setRun(run)) {
                System.out.println("Error: el RUN debe ser mayor a 0 y menor a 99.999.999.");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Titulo (10-50 caracteres): ");
            String titulo = scanner.nextLine();
            if (!profesional.setTitulo(titulo)) {
                System.out.println("Error: el título debe tener entre 10 y 50 caracteres.");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Fecha de Ingreso (DD/MM/AAAA): ");
            String fechaIngreso = scanner.nextLine();
            if (!profesional.setFechaIngreso(fechaIngreso)) {
                System.out.println("Error: debe ingresar una fecha valida con formato DD/MM/AAAA.");
            } else {
                break;
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
            if (nombre.length() < 10 || nombre.length() > 50) {
                System.out.println("Error: el nombre debe tener entre 10 y 50 caracteres.");
            }
        } while (nombre.length() < 10 || nombre.length() > 50);

        do {
            System.out.print("Fecha Nacimiento (DD/MM/AAAA): ");
            fechaNacimiento = scanner.nextLine();
            if (!ValidadorFechaHora.isValidarFecha(fechaNacimiento)) {
                System.out.println("Error: debe ingresar una fecha valida con formato DD/MM/AAAA.");
            }
        } while (!ValidadorFechaHora.isValidarFecha(fechaNacimiento));

        do {
            System.out.print("RUN (sin puntos ni guion, < 99999999): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un numero valido.");
                scanner.next();
            }
            run = scanner.nextInt();
            scanner.nextLine();
            if (run <= 0 || run >= 99999999) {
                System.out.println("Error: el RUN debe ser mayor a 0 y menor a 99.999.999.");
            }
        } while (run <= 0 || run >= 99999999);

        do {
            System.out.print("Area (5-20 caracteres): ");
            area = scanner.nextLine();
            if (area.length() < 5 || area.length() > 20) {
                System.out.println("Error: el area debe tener entre 5 y 20 caracteres.");
            }
        } while (area.length() < 5 || area.length() > 20);

        do {
            System.out.print("Experiencia Previa (max 100 caracteres): ");
            experienciaPrevia = scanner.nextLine();
            if (experienciaPrevia.length() == 0 || experienciaPrevia.length() > 100) {
                System.out.println("Error: la experiencia previa no puede estar vacia ni superar los 100 caracteres.");
            }
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
            System.out.println("Error: debe ingresar un numero valido para el RUN.");
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
        int id, rutCliente, duracion, asistentes;
        String dia, hora, lugar;

        do {
            System.out.print("Identificador Capacitacion (positivo): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un número positivo.");
                scanner.next();
            }
            id = scanner.nextInt();
            scanner.nextLine();
            if (id <= 0) {
                System.out.println("Error: el identificador debe ser mayor a 0.");
            }
        } while (id <= 0);

        do {
            System.out.print("RUT Cliente (sin puntos ni guion): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un número positivo.");
                scanner.next();
            }
            rutCliente = scanner.nextInt();
            scanner.nextLine();
            if (rutCliente <= 0) {
                System.out.println("Error: el RUT debe ser mayor a 0.");
            }
        } while (rutCliente <= 0);

        do {
            System.out.print("Dia (Lunes a Domingo): ");
            dia = scanner.nextLine().toLowerCase();
            if (!dia.equals("lunes") && !dia.equals("martes") && !dia.equals("miercoles") &&
                    !dia.equals("jueves") && !dia.equals("viernes") && !dia.equals("sabado") &&
                    !dia.equals("domingo")) {
                System.out.println("Error: el día debe ser un valor válido entre 'lunes' y 'domingo'.");
            }
        } while (!dia.equals("lunes") && !dia.equals("martes") && !dia.equals("miercoles") &&
                !dia.equals("jueves") && !dia.equals("viernes") && !dia.equals("sabado") &&
                !dia.equals("domingo"));

        System.out.print("Hora (HH:MM): ");
        hora = scanner.nextLine();

        do {
            System.out.print("Lugar (10-50 caracteres): ");
            lugar = scanner.nextLine();
            if (lugar.length() < 10 || lugar.length() > 50) {
                System.out.println("Error: el lugar debe tener entre 10 y 50 caracteres.");
            }
        } while (lugar.length() < 10 || lugar.length() > 50);

        do {
            System.out.print("Duracion (max 70): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar una duración válida (1-70).");
                scanner.next();
            }
            duracion = scanner.nextInt();
            scanner.nextLine();
            if (duracion <= 0 || duracion > 70) {
                System.out.println("Error: la duración debe ser mayor a 0 y menor o igual a 70.");
            }
        } while (duracion <= 0 || duracion > 70);

        do {
            System.out.print("Cantidad de asistentes (1-999): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar una cantidad válida (1-999).");
                scanner.next();
            }
            asistentes = scanner.nextInt();
            scanner.nextLine();
            if (asistentes < 1 || asistentes > 999) {
                System.out.println("Error: la cantidad de asistentes debe ser entre 1 y 999.");
            }
        } while (asistentes < 1 || asistentes > 999);

        Capacitacion capacitacion = new Capacitacion(id, rutCliente, dia, hora, lugar, duracion, asistentes);
        contenedor.almacenarCapacitacion(capacitacion);
    }

    private void listarCapacitaciones() {
        contenedor.listarCapacitaciones();
    }

}
