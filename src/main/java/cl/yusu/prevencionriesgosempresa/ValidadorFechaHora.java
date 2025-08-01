/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.yusu.prevencionriesgosempresa;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author anton
 */
public class ValidadorFechaHora {

    private static final List<String> DIAS_SEMANA_VALIDOS = Arrays.asList(
            "lunes", "martes", "miercoles", "jueves", "viernes", "sabado",
            "domingo");

    public static boolean isValidarDiaSemana(String dia) {
        if (dia == null || dia.trim().isEmpty()) {
            return false;
        }
        return DIAS_SEMANA_VALIDOS.contains(dia.toLowerCase());
    }

    public static boolean isValidarFecha(String fecha) {
        if (fecha == null || fecha.trim().isEmpty()) {
            return false;
        }
        // Verificar formato correcto (dd/MM/yyyy)
        if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            return false;
        }
        String[] partes = fecha.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int anio = Integer.parseInt(partes[2]);
        // Validar rango de año
        if (anio < 1900) {
            return false;
        }
        // Validar rango de mes
        if (mes < 1 || mes > 12) {
            return false;
        }
        int[] diasPorMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (esAnioBisiesto(anio)) {
            diasPorMes[1] = 29; // Febrero tiene 29 días en años bisiestos
        }

        if (dia < 1 || dia > diasPorMes[mes - 1]) {
            return false;
        }

        return true;
    }

    private static boolean esAnioBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }

    public static boolean isValidarHora(String hora) {
        if (hora == null || hora.trim().isEmpty()) {
            return false;
        }

        // Verificar formato correcto (HH:mm)
        if (!hora.matches("\\d{2}:\\d{2}")) {
            return false;
        }

        String[] partes = hora.split(":");
        int horas = Integer.parseInt(partes[0]);
        int minutos = Integer.parseInt(partes[1]);

        // Validar rango de horas (0-23)
        if (horas < 0 || horas > 23) {
            return false;
        }

        // Validar rango de minutos (0-59)
        if (minutos < 0 || minutos > 59) {
            return false;
        }

        return true;
    }
}
