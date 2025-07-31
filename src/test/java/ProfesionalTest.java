/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import cl.yusu.prevencionriesgosempresa.Profesional;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author anton
 */
public class ProfesionalTest {

        @Test
        void testSetTituloValido() {
                Profesional profesional = new Profesional("NombreDeDiezCaracteres",
                                "01/01/1990", 12345678, "TituloDeDiezCaracteres", "01/01/2015");
                profesional.setTitulo("Medico Cirujano");
                assertEquals("Medico Cirujano", profesional.getTitulo());
        }

        @Test
        void testSetTituloInvalidoCorto() {
                Profesional profesional = new Profesional("NombredeDiezCaracteres", "01/01/1990",
                                12345678, "TitulodeDiezCaracteres", "01/01/2015");
                Exception exception = assertThrows(IllegalArgumentException.class,
                                () -> {
                                        profesional.setTitulo("ABCD"); // Menos de 5 caracteres
                                });
                assertTrue(exception.getMessage().contains("El titulo es obligatorio "
                                + "y debe tener entre 10 y 50 caracteres."));
        }

        @Test
        void testSetTituloInvalidoLargo() {
                Profesional profesional = new Profesional("NombredeDiezCaracteres", "01/01/1990",
                                12345678, "TitulodeDiezCaracteres", "01/01/2015");
                Exception exception = assertThrows(IllegalArgumentException.class,
                                () -> {
                                        profesional.setTitulo("A".repeat(51)); // 51 caracteres
                                });
                assertTrue(exception.getMessage().contains("El titulo es obligatorio "
                                + "y debe tener entre 10 y 50 caracteres."));
        }

}
