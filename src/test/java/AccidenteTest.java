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
        accidente.setIdentificadorAccidente(-1);
        assertEquals(1, accidente.getIdentificadorAccidente());
    }

    @Test
    void testLugarValido() {
        Accidente accidente = new Accidente(1, 123, "01/01/2023", "10:00", "Lugar Test Accidente", "Origen",
                "Consecuencias");
        accidente.setLugar("Nuevo Lugar de Accidente");
        assertEquals("Nuevo Lugar de Accidente", accidente.getLugar());
    }

    @Test
    void testLugarInvalido() {
        Accidente accidente = new Accidente(1, 123, "01/01/2023", "10:00", "Lugar Test Accidente", "Origen",
                "Consecuencias");
        accidente.setLugar("Corto"); // Lugar demasiado corto
        assertEquals("Lugar Test Accidente", accidente.getLugar()); // Verifica que no se cambió
    }

}
