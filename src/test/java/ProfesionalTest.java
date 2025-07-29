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
    void testSetTituloInvalido_Corto() {
        Profesional profesional = new Profesional("Nombre", "01/01/1990", 
                12345678, "Titulo", "01/01/2015");
        Exception exception = assertThrows(IllegalArgumentException.class, 
                () -> {
            profesional.setTitulo("ABC"); // Menos de 5 caracteres
        });
        assertTrue(exception.getMessage().contains("El titulo debe tener entre "
                + "5 y 50 caracteres."));
    }

    @Test
    void testSetFechaIngresoValida() {
        Profesional profesional = new Profesional("NombreDeDiezCaracteres", 
                "01/01/1990", 12345678, "TituloDeDiezCaracteres", "01/01/2015");
        profesional.setFechaIngreso("20/11/2020");
        assertEquals("20/11/2020", profesional.getFechaIngreso());
    }

    @Test
    void testSetFechaIngresoInvalida() {
        Profesional profesional = new Profesional("NombreDeDiezCaracteres", "01/01/1990", 
                12345678, "TituloDeDiezCaracteres", "01/01/2015");
        Exception exception = assertThrows(IllegalArgumentException.class, 
                () -> {
            profesional.setFechaIngreso("30/02/2023"); // Fecha inválida (febrero no tiene 30 días en 2023)
        });
        assertTrue(exception.getMessage().contains("La fecha de ingreso es "
                    + "obligatoria y debe tener el formato DD/MM/AAAA."));
    }

}
