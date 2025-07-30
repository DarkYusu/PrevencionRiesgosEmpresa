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
        capacitacion.setDia("miercoles");
        assertEquals("miercoles", capacitacion.getDia());
    }

    @Test
    void testSetDiaInvalido() {
        Capacitacion capacitacion = new Capacitacion(1, 123, "Lunes", "10:00", 
                "Lugar Test Capacitacion", 10, 10);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            capacitacion.setDia("DiaDePrueba");
        });
        assertTrue(exception.getMessage().contains("El día debe ser un valor "
                + "valido entre 'lunes' y 'domingo'."));
    }

    @Test
    void testSetIdentificadorInvalido() {
        Capacitacion capacitacion = new Capacitacion(1, 123, "Lunes", "10:00", 
                "Lugar Test Capacitacion", 10, 10);
        Exception exception = assertThrows(IllegalArgumentException.class, () 
                -> {
            capacitacion.setIdentificador(0); // Debe ser mayor a 0
        });
        assertTrue(exception.getMessage().contains("El identificador de la "
                + "capacitacion es obligatorio y debe ser un numero positivo."));
    }

}
