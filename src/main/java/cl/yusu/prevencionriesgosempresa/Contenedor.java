/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.yusu.prevencionriesgosempresa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anton
 */
public class Contenedor {

    private List<Asesoria> listaAsesoria;
    private List<Capacitacion> listaCapacitacion;
    private List<Accidente> listaAccidentes;
    private List<VisitaEnTerreno> listaVisitasEnTerreno;
    private List<Revision> listaRevisiones;

    public Contenedor() {
        this.listaAsesoria = new ArrayList<>();
        this.listaCapacitacion = new ArrayList<>();
        this.listaAccidentes = new ArrayList<>();
        this.listaVisitasEnTerreno = new ArrayList<>();
        this.listaRevisiones = new ArrayList<>();
    }

    // --- Metodos de gestión de Asesorias ---
    public void almacenarCliente(Cliente cliente) {
        if (cliente != null) {
            listaAsesoria.add(cliente);
            System.out.println("Cliente " + cliente.getNombres()
                    + " almacenado exitosamente.");
        } else {
            System.out.println("No se puede almacenar un cliente nulo.");
        }
    }

    public void almacenarProfesional(Profesional profesional) {
        if (profesional != null) {
            listaAsesoria.add(profesional);
            System.out.println("Profesional " + profesional.getNombre()
                    + " almacenado exitosamente.");
        } else {
            System.out.println("No se puede almacenar un profesional nulo.");
        }
    }

    public void almacenarAdministrativo(Administrativo administrativo) {
        if (administrativo != null) {
            listaAsesoria.add(administrativo);
            System.out.println("Administrativo " + administrativo.getNombre()
                    + " almacenado exitosamente.");
        } else {
            System.out.println("No se puede almacenar un administrativo nulo.");
        }
    }

    public void eliminarUsuario(int run) {
        boolean eliminado = listaAsesoria.removeIf(usuario -> {
            if (usuario instanceof Usuario) {
                return ((Usuario) usuario).getRun() == run;
            }
            return false;
        });

        if (eliminado) {
            System.out.println("Usuario con RUN " + run
                    + " eliminado exitosamente.");
        } else {
            System.out.println("Usuario con RUN " + run + " no encontrado.");
        }
    }

    public void listarUsuarios() {
        if (listaAsesoria.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        System.out.println("\n--- Listado de Todos los Usuarios ---");
        for (Asesoria asesoria : listaAsesoria) {
            if (asesoria instanceof Cliente) {
                System.out.println("Cliente: " + asesoria.toString());
            } else if (asesoria instanceof Profesional) {
                System.out.println("Profesional: " + asesoria.toString());
            } else if (asesoria instanceof Administrativo) {
                System.out.println("Administrativo: " + asesoria.toString());
            }
            asesoria.analizarUsuario();
            System.out.println("---");
        }
        System.out.println("----------------------------------------");
    }

    public void listarUsuariosPorTipo(String tipoUsuario) {
        boolean encontrados = false;
        System.out.println("\n--- Listado de Usuarios Tipo: "
                + tipoUsuario + " ---");
        for (Asesoria asesoria : listaAsesoria) {
            if (tipoUsuario.equalsIgnoreCase("Cliente")
                    && asesoria instanceof Cliente) {
                System.out.println("Cliente: " + asesoria.toString());
                asesoria.analizarUsuario();
                encontrados = true;
                System.out.println("---");
            } else if (tipoUsuario.equalsIgnoreCase("Profesional")
                    && asesoria instanceof Profesional) {
                System.out.println("Profesional: " + asesoria.toString());
                asesoria.analizarUsuario();
                encontrados = true;
                System.out.println("---");
            } else if (tipoUsuario.equalsIgnoreCase("Administrativo")
                    && asesoria instanceof Administrativo) {
                System.out.println("Administrativo: " + asesoria.toString());
                asesoria.analizarUsuario();
                encontrados = true;
                System.out.println("---");
            }
        }
        if (!encontrados) {
            System.out.println("No se encontraron usuarios del tipo '"
                    + tipoUsuario + "'.");
        }
        System.out.println("----------------------------------------");
    }

    // --- Metodos de gestión de Capacitaciones ---
    public void almacenarCapacitacion(Capacitacion capacitacion) {
        if (capacitacion != null) {
            listaCapacitacion.add(capacitacion);
            System.out.println("Capacitacion almacenada exitosamente.");
        } else {
            System.out.println("No se puede almacenar una capacitación nula.");
        }
    }

    public void listarCapacitaciones() {
        if (listaCapacitacion.isEmpty()) {
            System.out.println("No hay capacitaciones registradas.");
            return;
        }
        System.out.println("\n--- Listado de Capacitaciones ---");
        for (Capacitacion cap : listaCapacitacion) {
            System.out.println(cap.mostrarDetalle());

            Cliente clienteAsociado = null;
            for (Asesoria asesoria : listaAsesoria) {
                if (asesoria instanceof Cliente) {
                    Cliente cliente = (Cliente) asesoria;
                    if (cliente.getRut() == cap.getRutCliente()) {
                        clienteAsociado = cliente;
                    }
                }
            }

            if (clienteAsociado != null) {
                System.out.println("  Asociada al Cliente: "
                        + clienteAsociado.obtenerNombre() + " (RUT: "
                        + clienteAsociado.getRut() + ")");
            } else {
                System.out.println("  Cliente asociado no encontrado (RUT: "
                        + cap.getRutCliente() + ")");
            }
            System.out.println("---");
        }
        System.out.println("----------------------------------------");
    }

    // --- Metodos de gestion para Accidente, VisitaEnTerreno, Revision ---
    public void almacenarAccidente(Accidente accidente) {
        if (accidente != null) {
            listaAccidentes.add(accidente);
            System.out.println("Accidente almacenado exitosamente.");
        } else {
            System.out.println("No se puede almacenar un accidente nulo.");
        }
    }

    public void almacenarVisitaEnTerreno(VisitaEnTerreno visita) {
        if (visita != null) {
            listaVisitasEnTerreno.add(visita);
            System.out.println("Visita en terreno almacenada exitosamente.");
        } else {
            System.out.println("No se puede almacenar una visita en terreno "
                    + "nula.");
        }
    }

    public void almacenarRevision(Revision revision) {
        if (revision != null) {
            listaRevisiones.add(revision);
            System.out.println("Revision almacenada exitosamente.");
        } else {
            System.out.println("No se puede almacenar una revisión nula.");
        }
    }



    public static Contenedor crearContenedorConDatosDePrueba() {
        Contenedor contenedor = new Contenedor();

        System.out.println("Cargando datos de prueba...");

        // Clientes
        Cliente cliente1 = new Cliente("Empresa Ejemplo Spa", "10/03/1975",
                12345678, 98765432, "Juanito", "Perez", "911112222", "Habitat",
                1, "Calle Falsa 123", "Santiago", 48);
        Cliente cliente2 = new Cliente("Constructora XYZ Ltda", "25/11/1980",
                23456789, 87654321, "Mariana", "Gonzalez", "933334444",
                "Capital", 2, "Avenida Siempre Viva 456", "Providencia", 43);
        contenedor.almacenarCliente(cliente1);
        contenedor.almacenarCliente(cliente2);

        // Profesionales
        Profesional profesional1 = new Profesional("Dr. Ana Rodriguez",
                "05/09/1982", 34567890, "Ingeniero en Prevencion de Riesgos",
                "15/07/2005");
        Profesional profesional2 = new Profesional("Lic. Pedro Martinez",
                "11/11/1978", 56789012, "Especialista en Seguridad Industrial",
                "20/03/2008");
        contenedor.almacenarProfesional(profesional1);
        contenedor.almacenarProfesional(profesional2);

        // Administrativos
        Administrativo administrativo1 = new Administrativo("Carlos Fuentes",
                "12/04/1995", 45678901, "Contabilidad", "Experiencia en "
                        + "auditoria financiera.");
        Administrativo administrativo2 = new Administrativo("Laura Diaz",
                "20/07/1993", 67890123, "Recursos Humanos", "Manejo de nóminas"
                        + " y beneficios.");
        contenedor.almacenarAdministrativo(administrativo1);
        contenedor.almacenarAdministrativo(administrativo2);

        // Capacitaciones
        Capacitacion cap1 = new Capacitacion(1, 98765432, "Lunes", "09:00",
                "Sala Capacitacion 1", 70, 15);
        Capacitacion cap2 = new Capacitacion(2, 87654321, "Miercoles", "15:00",
                "Auditorio Central", 70, 40);
        contenedor.almacenarCapacitacion(cap1);
        contenedor.almacenarCapacitacion(cap2);

        // Accidentes
        Accidente acc1 = new Accidente(1, 98765432, "10/07/2025", "11:00",
                "Planta de Produccion", "Falla de maquinaria", "Lesion leve en mano");
        Accidente acc2 = new Accidente(2, 87654321, "15/07/2025", "08:45",
                "Area de Montaje", "Caida de herramienta", "Corte superficial");
        contenedor.almacenarAccidente(acc1);
        contenedor.almacenarAccidente(acc2);

        // Visitas en Terreno
        VisitaEnTerreno vis1 = new VisitaEnTerreno(1, 98765432, "01/08/2025",
                "10:00", "Bodega Principal", "Revision de almacenaje de materiales");
        VisitaEnTerreno vis2 = new VisitaEnTerreno(2, 87654321, "05/08/2025",
                "14:00", "Area de Construccion", "Seguimiento de obras en curso");
        contenedor.almacenarVisitaEnTerreno(vis1);
        contenedor.almacenarVisitaEnTerreno(vis2);

        // Revisiones (asociadas a visitas en terreno)
        Revision rev1 = new Revision(1, 1, "Revision Bodega A",
                "Verificar senaletica de seguridad", 1);
        Revision rev2 = new Revision(2, 2, "Revision Obra B",
                "Chequear uso de EPP en altura", 2);
        contenedor.almacenarRevision(rev1);
        contenedor.almacenarRevision(rev2);

        System.out.println("Datos de prueba cargados.");

        return contenedor;
    }
}
