/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import cl.yusu.prevencionriesgosempresa.Revision;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author anton
 */
public class RevisionTest {

    @Test
    void testConstructorAndGetters() {
        Revision revision = new Revision(301, 201, "Chequeo de EPP", "Revisar uso correcto de cascos", 1);

        assertEquals(301, revision.getIdentificadorRevision());
        assertEquals(201, revision.getIdentificadorVisitaTerreno());
        assertEquals("Chequeo de EPP", revision.getNombreAlusivoRevision());
        assertEquals("Revisar uso correcto de cascos", revision.getDetalleParaRevisar());
        assertEquals(1, revision.getEstado());
    }

    @Test
    void testSetIdentificadorRevisionValido() {
        Revision rev = new Revision();

        boolean resultado = rev.setIdentificadorRevision(400);
        assertTrue(resultado);
        assertEquals(400, rev.getIdentificadorRevision());
    }

    @Test
    void testSetIdentificadorRevisionInvalidoNegativo() {
        Revision rev = new Revision();

        boolean resultado = rev.setIdentificadorRevision(-1); // Inválido
        assertFalse(resultado);
        assertEquals(0, rev.getIdentificadorRevision());
    }

    @Test
    void testSetIdentificadorRevisionNulo() {
        Revision rev = new Revision();

        boolean resultado = rev.setIdentificadorRevision(-1); // Inválido
        assertFalse(resultado);
        assertEquals(0, rev.getIdentificadorRevision());
    }
}