/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.yusu.prevencionriesgosempresa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public static boolean isValidarFecha(String fecha) {
        if (fecha == null || fecha.trim().isEmpty()) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isValidarHora(String hora) {
        if (hora == null || hora.trim().isEmpty()) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setLenient(false);
        try {
            sdf.parse(hora);
            String[] partes = hora.split(":");
            int horas = Integer.parseInt(partes[0]);
            int minutos = Integer.parseInt(partes[1]);
            return horas >= 0 && horas <= 23 && minutos >= 0 && minutos <= 59;
        } catch (ParseException | NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidarDiaSemana(String dia) {
        if (dia == null || dia.trim().isEmpty()) {
            return false;
        }
        return DIAS_SEMANA_VALIDOS.contains(dia.toLowerCase());
    }
}
