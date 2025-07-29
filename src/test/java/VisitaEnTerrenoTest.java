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
        VisitaEnTerreno visita = new VisitaEnTerreno(1, 12345678, "Lunes", "10:30", "Oficina Central", "Revisión de seguridad.");
        
        assertEquals(1, visita.getIdentificadorVisitaTerreno());
        assertEquals(12345678, visita.getRutCliente());
        assertEquals("01/01/2023", visita.getDia());
        assertEquals("10:30", visita.getHora());
        assertEquals("Oficina Central", visita.getLugar());
        assertEquals("Revisión de seguridad.", visita.getComentarios());
    }
    
    @Test
    void testSetDiaValido() {
        VisitaEnTerreno visita = new VisitaEnTerreno(1, 123, "15/05/2024", "10:00", "Lugar Test Visit", "Comentarios");
        visita.setDia("15/05/2024");
        assertEquals("15/05/2024", visita.getDia());
    }
    
    @Test
    void testSetDiaInvalido() {
        VisitaEnTerreno visita = new VisitaEnTerreno(1, 123, "15/05/2024", "10:00", "Lugar Test Visit", "Comentarios");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            visita.setDia("DiaInvalido"); // No es un día de la semana válido
        });
        assertTrue(exception.getMessage().contains("El dia de la visita en terreno es obligatorio y debe tener el formato DD/MM/AAAA."));
    }
    
}
