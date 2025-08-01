/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import cl.yusu.prevencionriesgosempresa.Accidente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author anton
 */
public class AccidenteTest {

    @Test
    void testConstructorAndGetters() {
        Accidente accidente = new Accidente(101, 87654321, "01/01/2023", "11:00", "Área de Producción",
                "Falla de maquinaria", "Lesión leve en mano.");

        assertEquals(101, accidente.getIdentificadorAccidente());
        assertEquals(87654321, accidente.getRutCliente());
        assertEquals("01/01/2023", accidente.getDia());
        assertEquals("11:00", accidente.getHora());
        assertEquals("Área de Producción", accidente.getLugar());
        assertEquals("Falla de maquinaria", accidente.getOrigen());
        assertEquals("Lesión leve en mano.", accidente.getConsecuencias());
    }

    @Test
    void testSetIdentificadorAccidenteValido() {
        Accidente accidente = new Accidente(1, 123, "01/01/2023", "10:00", "Lugar Test Accidente", "Origen",
                "Consecuencias");

        accidente.setIdentificadorAccidente(200);
        assertEquals(200, accidente.getIdentificadorAccidente());
    }

    @Test
    void testSetIdentificadorAccidenteInvalido() {
        Accidente accidente = new Accidente(1, 123, "01/01/2023", "10:00", "Lugar Test Accidente", "Origen",
                "Consecuencias");

        boolean result = accidente.setIdentificadorAccidente(-5);
        assertFalse(result);
        assertEquals(1, accidente.getIdentificadorAccidente()); // Valor no debe cambiar
    }

    @Test
    void testSetLugarValido() {
        Accidente accidente = new Accidente(1, 123, "01/01/2023", "10:00", "Lugar Test Accidente", "Origen",
                "Consecuencias");

        boolean result = accidente.setLugar("Lugar valido con más de 10 caracteres");
        assertTrue(result);
        assertEquals("Lugar valido con más de 10 caracteres", accidente.getLugar());
    }

    @Test
    void testSetLugarInvalido() {
        Accidente accidente = new Accidente(1, 123, "01/01/2023", "10:00", "Lugar Test Accidente", "Origen",
                "Consecuencias");

        boolean result = accidente.setLugar("Corto");
        assertFalse(result);
        assertEquals("Lugar Test Accidente", accidente.getLugar()); // Valor no debe cambiar
    }
}