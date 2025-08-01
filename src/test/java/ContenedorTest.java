/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import cl.yusu.prevencionriesgosempresa.Asesoria;
import cl.yusu.prevencionriesgosempresa.Cliente;
import cl.yusu.prevencionriesgosempresa.Contenedor;
import cl.yusu.prevencionriesgosempresa.Profesional;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import java.lang.reflect.Field;

/**
 *
 * @author anton
 */
public class ContenedorTest {

    private Contenedor contenedor;

    @BeforeEach
    void setUp() {
        contenedor = new Contenedor();
    }

    @SuppressWarnings("unchecked")
    private List<Asesoria> getListaAsesoria() throws NoSuchFieldException, IllegalAccessException {
        Field field = Contenedor.class.getDeclaredField("listaAsesoria");
        field.setAccessible(true);
        return (List<Asesoria>) field.get(contenedor);
    }

    @Test
    void testAlmacenarCliente() throws NoSuchFieldException, IllegalAccessException {
        Cliente cliente = new Cliente("Cliente Test 1", "01/01/1990", 11111111, 12345678,  "ApellidoC1", "912345678", "AFP Prueba", 1, "Dir Prueba 1", "Comuna Prueba 1", 30);

        int initialSize = getListaAsesoria().size();
        contenedor.almacenarCliente(cliente);

        assertEquals(initialSize + 1, getListaAsesoria().size(), "La lista de asesorías debe aumentar en 1 después de almacenar un cliente.");
        assertTrue(getListaAsesoria().contains(cliente), "El cliente almacenado debe estar en la lista.");

    }
    
    @Test
    void testListarUsuariosConDatos() throws NoSuchFieldException, IllegalAccessException {
        contenedor.almacenarCliente(new Cliente("Cliente Test List", "01/01/1990", 11111111, 12345678,  "ApellidoC1", "912345678", "AFP Prueba", 1, "Dir Prueba 1", "Comuna Prueba 1", 30));
        contenedor.almacenarProfesional(new Profesional("Profesional Test List", "02/02/1985", 22222222, "Ingenierodiez", "01/01/2010"));
        
        // El test solo verifica que el método se ejecuta sin excepciones
        assertDoesNotThrow(() -> contenedor.listarUsuarios(), "Listar usuarios con datos no debe lanzar excepción.");
    }

}