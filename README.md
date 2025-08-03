README - Sistema de Gestión para Asesorías en Prevención de Riesgos

Este proyecto fue realizado como parte de la evaluación final del modulo 2. 
Se desarrolló una aplicación que simula un sistema de información para una empresa que ofrece asesorías en prevención de riesgos laborales.

## Contexto

En los últimos años han aumentado los accidentes laborales en sectores como la construcción, minería e industria. Muchas empresas no cumplen adecuadamente las normativas de seguridad 
por el alto costo que implica contratar asesorías externas. Esto las expone a multas, pérdidas económicas y baja productividad.

Un grupo de profesionales fundó una empresa que presta servicios de prevención de riesgos. Para mejorar la calidad del servicio y facilitar la gestión, necesitan una solución tecnológica 
que les permita organizar la información de clientes, planificar actividades, controlar visitas en terreno y generar reportes útiles para la toma de decisiones.

Actualmente no cuentan con un sistema de información, lo que provoca desorganización, problemas de coordinación y dificultades para hacer seguimiento a las actividades. 
La información se maneja en carpetas, lo cual complica el acceso y análisis de los datos.

## Solución

La aplicación desarrollada en Java permite:

- Registrar diferentes tipos de usuarios: Clientes, Profesionales y Administrativos.
- Agregar y listar capacitaciones asociadas a clientes.
- Registrar accidentes laborales.
- Planificar y guardar visitas en terreno.
- Asociar revisiones a cada visita.
- Mostrar listas de usuarios filtradas por tipo.
- Eliminar usuarios según su RUN.
- Validar fechas, horas y otros campos para mantener consistencia de los datos.

## Detalles técnicos

- Se utilizó Programación Orientada a Objetos, implementando clases como Usuario, Cliente, Profesional, Administrativo, Capacitacion, Accidente, VisitaEnTerreno y Revision.
- La clase Usuario implementa la interfaz Asesoria, y es extendida por los distintos tipos de usuarios (Cliente, Profesional y Administrativo).
- La clase Contenedor administra listas de usuarios, agregar o eliminar los distintos tipos de usuarios, capacitaciones, visitas, accidentes y revisiones.
- El programa ofrece un menú interactivo por consola que permite ejecutar las distintas funciones.
- Se incluyó validación de entradas para evitar errores de formato en datos importantes como fechas y horas.

## Desarrolladores
- Antonio Badilla Espinoza
- Nicole Diaz Caamaño
- Ricardo Ruiz Palacios
- Sebastian Landeros Vergara
