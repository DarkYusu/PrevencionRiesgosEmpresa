/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import cl.yusu.prevencionriesgosempresa.VisitaEnTerreno;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author anton
 */
public class VisitaEnTerrenoTest {

    @Test
    void testConstructorAndGetters() {
        VisitaEnTerreno visita = new VisitaEnTerreno(1, 12345678, "01/01/2023", "10:30", "Oficina Central",
                "Revisión de seguridad.");

        assertEquals(1, visita.getIdentificadorVisitaTerreno());
        assertEquals(12345678, visita.getRutCliente());
        assertEquals("01/01/2023", visita.getDia());
        assertEquals("10:30", visita.getHora());
        assertEquals("Oficina Central", visita.getLugar());
        assertEquals("Revisión de seguridad.", visita.getComentarios());
    }

    @Test
    void testSetComentariosValido() {
        VisitaEnTerreno visita = new VisitaEnTerreno();
        String comentario = "Este es un comentario válido.";
        
        boolean result = visita.setComentarios(comentario);
        assertTrue(result);
        assertEquals(comentario, visita.getComentarios());
    }

    @Test
    void testSetComentariosNulo() {
        VisitaEnTerreno visita = new VisitaEnTerreno();
        
        boolean result = visita.setComentarios(null);
        assertTrue(result); // Se permite nulo según la lógica
        assertNull(visita.getComentarios());
    }

    @Test
    void testSetComentariosExcedeLimiteMaximo() {
        VisitaEnTerreno visita = new VisitaEnTerreno();
        
        String comentarioLargo = "a".repeat(101); // 101 caracteres
        boolean result = visita.setComentarios(comentarioLargo);
        assertFalse(result);
    }
}