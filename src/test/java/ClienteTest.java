/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import cl.yusu.prevencionriesgosempresa.Cliente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author anton
 */
public class ClienteTest {

    @Test
    void testConstructorAndGetters() {
        Cliente cliente = new Cliente("Empresa XYZ Cliente", "01/01/1980", 99999998, 98765432,
                "ApellidoDeDiezCaracteres", "912345678", "Habitat", 1, "Calle Falsa 123", "Santiago", 40);

        assertEquals("Empresa XYZ Cliente", cliente.getNombre());
        assertEquals("01/01/1980", cliente.getFechaNacimiento());
        assertEquals(99999998, cliente.getRun());
        assertEquals(98765432, cliente.getRut());
        assertEquals("NombreDeDiezCaracteres", cliente.getNombre());
        assertEquals("ApellidoDeDiezCaracteres", cliente.getApellidos());
        assertEquals("912345678", cliente.getTelefono());
        assertEquals("Habitat", cliente.getAfp());
        assertEquals(1, cliente.getSistemaSalud());
        assertEquals("Calle Falsa 123", cliente.getDireccion());
        assertEquals("Santiago", cliente.getComuna());
        assertEquals(40, cliente.getEdad());
    }

    @Test
    void testSetRutValido() {
        Cliente cliente = new Cliente("EmpresaDeDiezCaracteres", "01/01/1990", 12345678, 11111111,
                "ApellidoDeDiezCaracteres", "912345678", "AFPdeCINCO", 1, "Dir", "Com", 30);
        cliente.setRut(22222222);
        assertEquals(22222222, cliente.getRut());
    }

    @Test
    void testSetRutInvalidoNegativo() {
        Cliente cliente = new Cliente("EmpresaDeDiezCaracteres", "01/01/1990", 12345678, 11111111,
                "ApellidoDeDiezCaracteres", "912345678", "AFPdeCINCO", 1, "Dir", "Com", 30);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cliente.setRut(-1); // RUT inválido (negativo)
        });
        assertTrue(exception.getMessage().contains("El RUT debe ser un numero positivo menor a 99.999.999."));
    }

    @Test
    void testSetRutInvalidoPositivo() {
        Cliente cliente = new Cliente("EmpresaDeDiezCaracteres", "01/01/1990", 12345678, 11111111,
                "ApellidoDeDiezCaracteres", "912345678", "AFPdeCINCO", 1, "Dir", "Com", 30);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cliente.setRut(99999999); // RUN inválido (positivo, mayor a 99.999.99)
        });
        assertTrue(exception.getMessage().contains("El RUT debe ser un numero positivo menor a 99.999.999."));
    }

}
