/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package cl.yusu.prevencionriesgosempresa;

/**
 *
 * @author anton
 */
public class Main {

    public static void main(String[] args) {
        Contenedor contenedor = Contenedor.crearContenedorConDatosDePrueba();
        Menu menu = new Menu(contenedor);
        menu.mostrar();
    }
}
