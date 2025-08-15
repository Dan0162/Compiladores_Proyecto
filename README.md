# Proyecto: Parser / Evaluador (Java + ANTLR4)

Este repositorio contiene un pequeño compilador/interpretador escrito en Java usando ANTLR4.
Incluye el lexer, el parser (definido por la gramática ANTLR) y un evaluador que recorre el árbol de sintaxis para ejecutar programas escritos en la gramática del proyecto.

![Diagrama de clases UML](https://github.com/user-attachments/assets/5d781e93-e9e4-49bb-a32b-f6e40931d392)

## ¿Qué puede hacer este proyecto?

- Analizar (lex & parse) programas definidos por `src/main/java/com/compi/Gramatica_ANLTR4/Proj.g4`.
- Evaluar/ejecutar programas: declaraciones de variables, expresiones aritméticas, condicionales, bucles (`while`), definición y llamada de funciones, incremento/decremento y más (ver la gramática para detalles).
- Proporciona una clase `Main` para ejecutar archivos de programa desde línea de comandos.

## Estructura relevante

- `src/main/java/com/compi/` — código fuente Java (incluye `Main.java`, `Lexer.java`, `Evaluador.java`).
- `src/main/java/com/compi/Gramatica_ANLTR4/Proj.g4` — gramática ANTLR4.
- `target/` — artefactos de compilación (por ejemplo `proyecto1-1.0-SNAPSHOT.jar` y `proyecto1-1.0-SNAPSHOT.exe`).
- `Test Cases/` — ejemplos de entrada / programas de prueba (`test1.txt` ... `test7.txt`, y `Test Ultima Fase/` con casos adicionales).

## Requisitos

- Java 8+ (JDK instalado)
- Maven (para compilar y empacar)

## Ejemplos / Qué esperar

- Los archivos en `Test Cases/` contienen programas de ejemplo que ejercitan variables, operadores aritméticos, condicionales, bucles y llamadas a funciones.
- Al ejecutar un archivo, el intérprete procesa el programa y muestra la salida/evaluación en la consola. Revisa `Evaluador.java` para ver el comportamiento exacto y las acciones soportadas (por ejemplo, impresión de valores o manejo de errores).