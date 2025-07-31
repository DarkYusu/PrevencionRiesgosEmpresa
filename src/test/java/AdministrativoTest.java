/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import cl.yusu.prevencionriesgosempresa.Administrativo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author anton
 */
public class AdministrativoTest {

        @Test
        void testConstructorAndGetters() {
                Administrativo admin = new Administrativo("NombreDeDiezCaracteres",
                                "01/01/1990", 12345678, "Recursos Humanos", "Exp.");
                assertEquals("NombreDeDiezCaracteres", admin.getNombre());
                assertEquals("01/01/1990", admin.getFechaNacimiento());
                assertEquals(12345678, admin.getRun());
                assertEquals("Recursos Humanos", admin.getArea());
                assertEquals("Exp.", admin.getExperienciaPrevia());
        }

        @Test
        void testSetAreaValida() {
                Administrativo admin = new Administrativo("NombreDeDiezCaracteres",
                                "01/01/1990", 12345678, "Recursos Humanos", "Exp.");
                admin.setArea("Recursos Humanos"); // 16 caracteres, válido
                assertEquals("Recursos Humanos", admin.getArea());
        }

        @Test
        void testSetAreaInvalidaCorta() {
                Administrativo admin = new Administrativo("NombreDeDiezCaracteres",
                                "01/01/1990", 12345678, "Recursos Humanos", "Exp.");
                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        admin.setArea("RRHH"); // Menos de 5 caracteres
                });
                assertTrue(exception.getMessage().contains("El area es obligatoria y debe "
                                + "tener entre 5 y 20 caracteres."));
        }

        @Test
        void testSetAreaInvalidaLarga() {
                Administrativo admin = new Administrativo("NombreDeDiezCaracteres",
                                "01/01/1990", 12345678, "Recursos Humanos", "Exp.");
                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        admin.setArea("A".repeat(21)); // 21 caracteres
                });
                assertTrue(exception.getMessage().contains("El area es obligatoria y debe "
                                + "tener entre 5 y 20 caracteres."));
        }

        @Test
        void testSetExperienciaPreviaValida() {
                Administrativo admin = new Administrativo("NombreDeDiezCaracteres",
                                "01/01/1990", 12345678, "Recursos Humanos", "Exp.");
                admin.setExperienciaPrevia("Manejo de equipos y proyectos");
                assertEquals("Manejo de equipos y proyectos",
                                admin.getExperienciaPrevia());
        }

        @Test
        void testSetExperienciaPreviaInvalidaNula() {
                Administrativo admin = new Administrativo("NombreDeDiezCaracteres",
                                "01/01/1990", 12345678, "Recursos Humanos", "Exp.");
                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        admin.setExperienciaPrevia(null); // Experiencia previa nula
                });
                assertTrue(exception.getMessage().contains("La experiencia previa no puede ser nula."));
        }

        @Test
        void testSetExperienciaPreviaInvalidaLarga() {
                Administrativo admin = new Administrativo("NombreDeDiezCaracteres",
                                "01/01/1990", 12345678, "Recursos Humanos", "Exp.");
                Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        admin.setExperienciaPrevia("A".repeat(101)); // 101 caracteres
                });
                assertTrue(exception.getMessage().contains("La experiencia previa no puede exceder los 100 caracteres."));
        }

}
