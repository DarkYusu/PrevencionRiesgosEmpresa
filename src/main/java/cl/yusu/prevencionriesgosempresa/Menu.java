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
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Gestionar Usuarios");
            System.out.println("2. Gestionar Capacitaciones");
            System.out.println("3. Gestionar Eventos (Accidentes, Visitas,"
                    + " Revisiones)");
            System.out.println("9. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1 ->
                    mostrarMenuGestionUsuarios();
                case 2 ->
                    mostrarMenuGestionCapacitaciones();
                case 3 ->
                    mostrarMenuGestionEventos();
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

    // --- Métodos para Gestión de Usuarios ---
    private void mostrarMenuGestionUsuarios() {
        int opcion;
        do {
            System.out.println("\n--- Menu Gestion de Usuarios ---");
            System.out.println("1. Almacenar Cliente");
            System.out.println("2. Almacenar Profesional");
            System.out.println("3. Almacenar Administrativo");
            System.out.println("4. Eliminar Usuario");
            System.out.println("5. Listar Usuarios");
            System.out.println("6. Listar Usuarios por Tipo");
            System.out.println("7. Volver al Menu Principal");
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
                    eliminarUsuario();
                case 5 ->
                    listarUsuarios();
                case 6 ->
                    listarUsuariosPorTipo();
                case 7 ->
                    System.out.println("Volviendo al Menu Principal...");
                default ->
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 7);
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
            scanner.nextLine(); // Consumir el resto de la línea
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
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
            System.out.println("Error: tipo de dato incorrecto. Asegúrese de "
                    + "ingresar números para RUN.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
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
            System.out.println("Error: tipo de dato incorrecto. Asegúrese de "
                    + "ingresar números para RUN.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
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
    private void mostrarMenuGestionCapacitaciones() {
        int opcion;
        do {
            System.out.println("\n--- Menu Gestion de Capacitaciones ---");
            System.out.println("1. Almacenar Capacitacion");
            System.out.println("2. Listar Capacitaciones");
            System.out.println("3. Volver al Menu Principal");
            System.out.print("Ingrese una opcion: ");
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1 ->
                    almacenarCapacitacion();
                case 2 ->
                    listarCapacitaciones();
                case 3 ->
                    System.out.println("Volviendo al Menu Principal...");
                default ->
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 3);
    }

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
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    private void listarCapacitaciones() {
        contenedor.listarCapacitaciones();
    }

    // --- Métodos para Gestión de Eventos (Accidentes, Visitas, Revisiones) ---
    private void mostrarMenuGestionEventos() {
        int opcion;
        do {
            System.out.println("\n--- Menu Gestion de Eventos ---");
            System.out.println("1. Almacenar Accidente");
            System.out.println("2. Almacenar Visita en Terreno");
            System.out.println("3. Almacenar Revision");
            System.out.println("4. Listar Accidentes");
            System.out.println("5. Listar Visitas en Terreno");
            System.out.println("6. Listar Revisiones");
            System.out.println("7. Volver al Menu Principal");
            System.out.print("Ingrese una opcion: ");
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1 ->
                    almacenarAccidente();
                case 2 ->
                    almacenarVisitaEnTerreno();
                case 3 ->
                    almacenarRevision();
                case 4 ->
                    contenedor.listarAccidentes();
                case 5 ->
                    contenedor.listarVisitasEnTerreno();
                case 6 ->
                    contenedor.listarRevisiones();
                case 7 ->
                    System.out.println("Volviendo al Menu Principal...");
                default ->
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 7);
    }

    private void almacenarAccidente() {
        try {
            System.out.print("Identificador Accidente (positivo): ");
            int idAccidente = scanner.nextInt();
            scanner.nextLine();
            System.out.print("RUT Cliente asociado (sin puntos ni guion): ");
            int rutCliente = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Día del accidente (DD/MM/AAAA): ");
            String dia = scanner.nextLine();
            System.out.print("Hora del accidente (HH:MM): ");
            String hora = scanner.nextLine();
            System.out.print("Lugar del accidente (10-50 caracteres): ");
            String lugar = scanner.nextLine();
            System.out.print("Origen del accidente (max 100 caracteres): ");
            String origen = scanner.nextLine();
            System.out.print("Consecuencias del accidente "
                    + "(max 100 caracteres): ");
            String consecuencias = scanner.nextLine();

            Accidente accidente = new Accidente(idAccidente, rutCliente, dia,
                    hora, lugar, origen, consecuencias);
            contenedor.almacenarAccidente(accidente);

        } catch (InputMismatchException e) {
            System.out.println("Error: tipo de dato incorrecto. Asegurese de "
                    + "ingresar numeros para identificadores y RUT.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validacion: " + e.getMessage());
        }
    }

    private void almacenarVisitaEnTerreno() {
        try {
            System.out.print("Identificador Visita en Terreno (positivo): ");
            int idVisita = scanner.nextInt();
            scanner.nextLine();
            System.out.print("RUT Cliente asociado (sin puntos ni guion): ");
            int rutCliente = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Día de la visita (DD/MM/AAAA): ");
            String dia = scanner.nextLine();
            System.out.print("Hora de la visita (HH:MM): ");
            String hora = scanner.nextLine();
            System.out.print("Lugar de la visita (10-50 caracteres): ");
            String lugar = scanner.nextLine();
            System.out.print("Comentarios de la visita (max 100 caracteres): ");
            String comentarios = scanner.nextLine();

            VisitaEnTerreno visita = new VisitaEnTerreno(idVisita, rutCliente,
                    dia, hora, lugar, comentarios);
            contenedor.almacenarVisitaEnTerreno(visita);

        } catch (InputMismatchException e) {
            System.out.println("Error: tipo de dato incorrecto. Asegurese de "
                    + "ingresar numeros para identificadores y RUT.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validacion: " + e.getMessage());
        }
    }

    private void almacenarRevision() {
        try {
            System.out.print("Identificador Revision (positivo): ");
            int idRevision = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Identificador Visita en Terreno asociada: ");
            int idVisitaTerreno = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nombre alusivo de la revisión (10-50 caracteres): ");
            String nombreAlusivo = scanner.nextLine();
            System.out.print("Detalle para revisar (max 100 caracteres): ");
            String detalle = scanner.nextLine();
            System.out.print("Estado de la revisión (1:Sin problemas, 2:Con "
                    + "observaciones, 3:No aprueba): ");
            int estado = scanner.nextInt();
            scanner.nextLine();

            Revision revision = new Revision(idRevision, idVisitaTerreno,
                    nombreAlusivo, detalle, estado);
            contenedor.almacenarRevision(revision);

        } catch (InputMismatchException e) {
            System.out.println("Error: tipo de dato incorrecto. Asegurese de "
                    + "ingresar numeros para identificadores y estado.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validacion: " + e.getMessage());
        }
    }
}
