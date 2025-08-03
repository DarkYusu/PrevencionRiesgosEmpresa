/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import cl.yusu.prevencionriesgosempresa.ValidadorFechaHora;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author anton
 */
class ValidadorFechaHoraTest {

    @Test
    void testFechaValida() {
        // Pruebas para fechas válidas
        assertTrue(ValidadorFechaHora.isValidarFecha("31/12/2023"));
        assertTrue(ValidadorFechaHora.isValidarFecha("01/01/1900"));
        assertTrue(ValidadorFechaHora.isValidarFecha("29/02/2024")); // Año bisiesto

        // Pruebas para fechas inválidas
        assertFalse(ValidadorFechaHora.isValidarFecha("32/12/2023")); // Día inválido
        assertFalse(ValidadorFechaHora.isValidarFecha("31/13/2023")); // Mes inválido
        assertFalse(ValidadorFechaHora.isValidarFecha("31-12-2023")); // Formato incorrecto
        assertFalse(ValidadorFechaHora.isValidarFecha("29/02/2023")); // Año no bisiesto
        assertFalse(ValidadorFechaHora.isValidarFecha(null)); // Fecha nula
        assertFalse(ValidadorFechaHora.isValidarFecha("")); // Fecha vacía
    }

    @Test
    void testHoraValida() {
        // Pruebas para horas válidas
        assertTrue(ValidadorFechaHora.isValidarHora("00:00"));
        assertTrue(ValidadorFechaHora.isValidarHora("23:59"));
        assertTrue(ValidadorFechaHora.isValidarHora("10:30"));

        // Pruebas para horas inválidas
        assertFalse(ValidadorFechaHora.isValidarHora("24:00")); // Hora inválida
        assertFalse(ValidadorFechaHora.isValidarHora("10:60")); // Minuto inválido
        assertFalse(ValidadorFechaHora.isValidarHora("10-30")); // Formato incorrecto
        assertFalse(ValidadorFechaHora.isValidarHora(null)); // Hora nula
        assertFalse(ValidadorFechaHora.isValidarHora("")); // Hora vacía
        assertFalse(ValidadorFechaHora.isValidarHora("abc")); // Formato no numérico
    }

    @Test
    void testDiaSemanaValido() {
        // Pruebas para días de la semana válidos
        assertTrue(ValidadorFechaHora.isValidarDiaSemana("lunes"));
        assertTrue(ValidadorFechaHora.isValidarDiaSemana("MARTES")); // Ignora mayúsculas/minúsculas
        assertTrue(ValidadorFechaHora.isValidarDiaSemana("miErColes"));
        assertTrue(ValidadorFechaHora.isValidarDiaSemana("domingo"));

        // Pruebas para días de la semana inválidos
        assertFalse(ValidadorFechaHora.isValidarDiaSemana("luness")); // Mal escrito
        assertFalse(ValidadorFechaHora.isValidarDiaSemana("findesemana")); // No es un día válido
        assertFalse(ValidadorFechaHora.isValidarDiaSemana(null)); // Día nulo
        assertFalse(ValidadorFechaHora.isValidarDiaSemana("")); // Día vacío
    }
}