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

                boolean resultado = profesional.setTitulo("Medico Cirujano");
                assertTrue(resultado);
                assertEquals("Medico Cirujano", profesional.getTitulo());
        }

        @Test
        void testSetTituloInvalidoCorto() {
                Profesional profesional = new Profesional("NombredeDiezCaracteres", "01/01/1990",
                                12345678, "TitulodeDiezCaracteres", "01/01/2015");

                boolean resultado = profesional.setTitulo("ABCD"); // Menos de 10 caracteres
                assertFalse(resultado);
                assertEquals("TitulodeDiezCaracteres", profesional.getTitulo());
        }

        @Test
        void testSetTituloInvalidoLargo() {
                Profesional profesional = new Profesional("NombredeDiezCaracteres", "01/01/1990",
                                12345678, "TitulodeDiezCaracteres", "01/01/2015");

                boolean resultado = profesional.setTitulo("A".repeat(51)); // 51 caracteres
                assertFalse(resultado);
                assertEquals("TitulodeDiezCaracteres", profesional.getTitulo());
        }

}
