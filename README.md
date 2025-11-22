¡Absolutamente\! Aquí tienes el archivo **README.md** completo, formateado con Markdown listo para copiar y pegar directamente en tu repositorio de GitHub.

-----

# 🚀 TaskForge Ltda. | Proyecto de Gestión de Tareas (Taller 03 POO)

## 📋 Resumen del Proyecto

**TaskForge Ltda.** es una herramienta de gestión de proyectos desarrollada para el equipo de software, en el contexto del año 2035. Este sistema permite a los usuarios **organizar proyectos**, **clasificar y priorizar tareas**, **asignar responsables** y **generar reportes** detallados.

El desarrollo se enfoca en la aplicación de principios de **Programación Orientada a Objetos (POO)** avanzada, incluyendo herencia, polimorfismo, interfaces y la implementación de patrones de diseño.

-----

## 👥 Integrantes y Colaboradores

| Integrante | RUT | Carrera | GitHub |
| :--- | :--- | :--- | :--- |
| **Benjamín Rojas** | 22.086.016-7 | ICCI | [@benjaminrojas](https://www.google.com/search?q=https://github.com/benjaminrojas) |
| **Ignacio Cataldo** | 21.944.808-2 | ICCI | [@ignaciocataldo](https://www.google.com/search?q=https://github.com/ignaciocataldo) |

### Referentes Académicos

| Rol | Nombre |
| :--- | :--- |
| **Docentes** | Alejandro Paolini Godoy, Cristhian Rabi Reyes |
| **Ayudantes** | Daniel Durán García, Nicolás Rojas Bustos |

-----

## ✨ Requisitos Funcionales Implementados

### 🔑 Roles de Usuario

El sistema cuenta con dos roles principales:

  * **Administrador:** Puede crear proyectos, gestionar tareas, asignar responsables y generar reportes completos.
  * **Colaborador:** Puede consultar proyectos, ver tareas asignadas y actualizar su estado.

### 🧩 Patrones de Diseño Aplicados

Este proyecto implementa los siguientes patrones de diseño de la *Gang of Four* (GoF):

  * **Singleton:** Para garantizar una única instancia de la clase de gestión del sistema (`SistemaImp`).
  * **Factory Method:** Para la creación de objetos de dominio, como los diferentes tipos de tareas.
  * **Strategy:** Implementado para permitir la **selección dinámica de la estrategia de priorización de tareas** (por fecha de creación, por tipo/impacto, o por complejidad).
  * **Visitor:** Utilizado para realizar operaciones sobre la estructura de tareas/proyectos, específicamente para la **generación de reportes**.

-----

## 🚀 Instrucciones de Uso y Ejecución

### 1\. Clonar el Repositorio

Utiliza el siguiente comando en tu terminal:

```bash
git clone https://github.com/ignaciocataldo/BenjaminRojas_IgnacioCataldo_Taller3POO
cd BenjaminRojas_IgnacioCataldo_Taller3POO
```

### 2\. Abrir y Compilar

Abre la carpeta del proyecto en tu IDE de preferencia (Eclipse o IntelliJ IDEA). Asegúrate de que las dependencias del proyecto (`JRE System Library` - Java SE-21) estén correctamente configuradas.

### 3\. Ejecutar el Sistema

Ejecuta la clase principal (`AppMain.java`). El sistema se iniciará mostrando el menú de bienvenida y solicitando las credenciales de autenticación para comenzar a operar como Administrador o Colaborador.

-----

## 🛠️ Estructura de Paquetes

El código fuente está organizado lógicamente en los siguientes paquetes:

  * **`Taller3`:** Contiene las clases de dominio fundamentales (e.g., `Proyecto`, `Tarea`, `Usuario`).
  * **`Estrategia`:** Alojamiento de la interfaz `Strategy` y sus implementaciones concretas para la priorización.
  * **`Factory`:** Contiene la lógica para la creación de instancias complejas.
  * **`Visitador`:** Contiene la interfaz `Visitor` y la lógica para operaciones de recorrido (como la generación de reportes).
