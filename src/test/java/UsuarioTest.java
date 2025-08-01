/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import cl.yusu.prevencionriesgosempresa.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author anton
 */
public class UsuarioTest {

    static class UsuarioConcreta extends Usuario {

        public UsuarioConcreta(String nombre, String fechaNacimiento, int run) {
            super(nombre, fechaNacimiento, run);
        }
    }

    @Test
    void testSetNombreValido() {
        UsuarioConcreta usuario = new UsuarioConcreta("NombreDeDiezCaracteres", "01/01/1990", 123);

        boolean resultado = usuario.setNombre("Nuevo Nombre Valido");
        assertTrue(resultado);
        assertEquals("Nuevo Nombre Valido", usuario.getNombre());
    }

    @Test
    void testSetNombreInvalido_LongitudCorta() {
        UsuarioConcreta usuario = new UsuarioConcreta("NombreDeDiezCaracteres", "01/01/1990", 123);

        boolean resultado = usuario.setNombre("Corto");
        assertFalse(resultado);
        assertEquals(false, resultado);
    }

    @Test
    void testSetNombreInvalido_LongitudLarga() {
        UsuarioConcreta usuario = new UsuarioConcreta("NombreDeDiezCaracteres", "01/01/1990", 123);
        boolean resultado = usuario.setNombre("a".repeat(51)); // 51 caracteres
        assertFalse(resultado);
        assertEquals(false, resultado);
    }

}
