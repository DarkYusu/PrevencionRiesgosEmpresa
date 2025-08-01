/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import cl.yusu.prevencionriesgosempresa.Capacitacion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author anton
 */
public class CapacitacionTest {

    @Test
    void testConstructorAndGetters() {
        Capacitacion capacitacion = new Capacitacion(1, 12345678, "Lunes",
                "10:00", "Sala A de diez caracteres", 60, 15);

        assertEquals(1, capacitacion.getIdentificador());
        assertEquals(12345678, capacitacion.getRutCliente());
        assertEquals("Lunes", capacitacion.getDia());
        assertEquals("10:00", capacitacion.getHora());
        assertEquals("Sala A de diez caracteres", capacitacion.getLugar());
        assertEquals(60, capacitacion.getDuracion());
        assertEquals(15, capacitacion.getCantidadAsistentes());
    }

    @Test
    void testSetDiaValido() {
        Capacitacion capacitacion = new Capacitacion(1, 123, "Lunes", "10:00",
                "Lugar Test Capacitacion", 10, 10);

        boolean resultado = capacitacion.setDia("miercoles");
        assertTrue(resultado);
    }

    @Test
    void testSetDiaInvalido() {
        Capacitacion capacitacion = new Capacitacion(1, 123, "Lunes", "10:00",
                "Lugar Test Capacitacion", 10, 10);

        boolean resultado = capacitacion.setDia("DiaDePrueba");
        assertFalse(resultado);
        assertEquals("Lunes", capacitacion.getDia());
    }

    @Test
    void testSetIdentificadorInvalido() {
        Capacitacion capacitacion = new Capacitacion(1, 123, "Lunes", "10:00",
                "Lugar Test Capacitacion", 10, 10);

        boolean resultado = capacitacion.setDia("DiaDePrueba");
        assertFalse(resultado);
    }

    @Test
    void testSetIdentificadorInvalidoNegativo() {
        Capacitacion capacitacion = new Capacitacion(1, 123, "Lunes", "10:00",
                "Lugar Test Capacitacion", 10, 10);

        boolean resultado = capacitacion.setIdentificador(-1); // Debe ser mayor a 0
        assertFalse(resultado);
        assertEquals(1, capacitacion.getIdentificador());
    }

}
