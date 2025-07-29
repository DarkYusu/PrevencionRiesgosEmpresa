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
    void testConstructorAndGetters() {
        UsuarioConcreta usuario = new UsuarioConcreta("Juan Perez", "01/01/1990", 12345678);
        assertEquals("Juan Perez", usuario.getNombre());
        assertEquals("01/01/1990", usuario.getFechaNacimiento());
        assertEquals(12345678, usuario.getRun());
    }

    @Test
    void testSetNombreValido() {
        UsuarioConcreta usuario = new UsuarioConcreta("NombreDeDiezCaracteres", "01/01/1990", 123);
        usuario.setNombre("Nuevo Nombre Valido");
        assertEquals("Nuevo Nombre Valido", usuario.getNombre());
    }

    @Test
    void testSetNombreInvalido_LongitudCorta() {
        UsuarioConcreta usuario = new UsuarioConcreta("NombreDeDiezCaracteres", "01/01/1990", 123);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            usuario.setNombre("Corto");
        });
        assertTrue(exception.getMessage().contains("El nombre es obligatorio y debe tener entre 10 y 50 caracteres."));
    }
    
    
}
