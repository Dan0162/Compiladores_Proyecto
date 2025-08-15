package com.compi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.compi.Gramatica_ANLTR4.ProjLexer;
import com.compi.Gramatica_ANLTR4.ProjParser;

import org.antlr.v4.runtime.CharStreams;

public class Main {
    public static void main(String[] args) throws Exception {
        // Flujo principal: acepta argumento CLI (ruta) o pide por consola. Incluye manejo de errores para
        // fallos de lectura, parseo o evaluación y mensajes claros al usuario.
        String path = null;
        try {
            // Si se pasa un argumento, lo usamos como ruta (útil para scripts y tests automatizados)
            if (args != null && args.length > 0 && args[0] != null && !args[0].isEmpty()) {
                path = args[0];
            } else {
                path = promptForPath();
            }

            validateTxtExtension(path);

            String source = readFileContent(path);
            if (source == null) {
                System.err.println("No se pudo leer el archivo de entrada. Compruebe la ruta y permisos.");
                return;
            }

            // Mostrar tokens (si falla, continuamos mostrando un mensaje amigable)
            try {
                printTokens(source);
            } catch (Exception e) {
                System.err.println("Advertencia: fallo al tokenizar/mostrar tokens: " + e.getMessage());
            }

            // Parsear y evaluar con protección frente a excepciones en ANTLR o en el visitor
            ParseTree tree = null;
            try {
                tree = parseSource(source);
            } catch (RuntimeException re) {
                System.err.println("Error durante el parseo: " + re.getMessage());
                return;
            }

            Evaluador visitor = new Evaluador();
            String resultado = null;
            try {
                resultado = visitor.visit(tree); // puede devolver null si no hay resultado imprimible
            } catch (Exception e) {
                System.err.println("Error durante la evaluación del programa: " + e.getMessage());
            }

            if (resultado != null) {
                System.out.println("Resultado de la evaluación: " + resultado);
            } else {
                System.out.println("Evaluación completada (sin resultado retornado explícito). Vea salida previa para mensajes.");
            }

            // Intentar exportar el programa generado por el visitor (si existe)
            try {
                String exportName = visitor.getExportName();
                String exportProg = visitor.getExportProg();
                if (exportName != null && exportProg != null && !exportName.trim().isEmpty() && !exportProg.trim().isEmpty()) {
                    boolean ok = createFile(exportName + ".java", exportProg);
                    if (!ok) {
                        System.err.println("No se pudo crear el archivo exportado.");
                    }
                } else {
                    System.out.println("No hay archivo para exportar.");
                }
            } catch (Exception e) {
                System.err.println("Error al intentar exportar el programa: " + e.getMessage());
            }

        } catch (IllegalArgumentException iae) {
            System.err.println("Argumento inválido: " + iae.getMessage());
        } catch (Exception e) {
            // Capturamos excepciones inesperadas para no mostrar stack traces crudos al usuario final
            System.err.println("Se produjo un error inesperado: " + e.getMessage());
            // Opcional: para debugging, puede descomentar la siguiente línea
            // e.printStackTrace();
        }
    }

    public static String getFile(String path) {
        // Mantener compatibilidad con código previo; delega en readFileContent
        return readFileContent(path);
    }

    /**
     * Lee el contenido del archivo indicado con codificación UTF-8.
     * Devuelve null en caso de error.
     */
    public static String readFileContent(String path) {
        Path p = Paths.get(path);
        if (!Files.exists(p)) {
            System.err.println("El archivo no existe: " + path);
            return null;
        }

        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
            return sb.toString();
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
            return null;
        }
    }

    /**
     * Pide al usuario la ruta del archivo de entrada por consola.
     */
    public static String promptForPath() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        System.out.println(
                "Por favor ingresar la ruta del archivo .txt que contiene su lenguaje. Solamente se aceptan archivos .txt\n");
        return reader.readLine();
    }

    /**
     * Verifica que la ruta termine en .txt y lanza excepción si no.
     */
    public static void validateTxtExtension(String path) throws Exception {
        if (path == null || !path.toLowerCase().endsWith(".txt")) {
            throw new Exception("El archivo ingresado no es un archivo .txt");
        }
    }

    /**
     * Utiliza el lexer local para tokenizar e imprimir tokens al usuario.
     */
    public static void printTokens(String source) {
        Lexer lexer = new Lexer(source);
        lexer.tokenize();
        for (TOKEN token : lexer.getTokens()) {
            System.out.println("Token: " + token.type + " -> " + token.value);
        }
        System.out.println("--------------------------------------------------");
    }

    /**
     * Crea el árbol de análisis (ParseTree) usando ANTLR y devuelve la raíz.
     */
    public static ParseTree parseSource(String source) {
        ProjLexer lexer = new ProjLexer(CharStreams.fromString(source));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ProjParser parser = new ProjParser(tokens);
        return parser.prog();
    }

    public static boolean createFile(String export_name, String export_prog) {
        try (Scanner scanner = new Scanner(System.in)) {

            // Pedir directorio de salida al usuario
            System.out.print("Ingrese el directorio para guardar su archivo: ");
            String directoryPath = scanner.nextLine();
            // Crear el directorio si no existe
            Path directory = Paths.get(directoryPath);
            if (!Files.exists(directory)) {
                try {
                    Files.createDirectories(directory);
                    System.out.println("Directorio creado: " + directoryPath);
                } catch (IOException e) {
                    System.err.println("Error al crear el directorio: " + e.getMessage());
                    return false;
                }
            }

            // Construir la ruta completa del archivo de salida
            String filePath = directoryPath + File.separator + export_name;
            File file = new File(filePath);

            // Comprobar si el archivo ya existe y preguntar para sobrescribir
            if (file.exists()) {
                System.out.print("El archivo ya existe. ¿Desea sobrescribirlo? (y/n): ");
                String response = scanner.nextLine().trim().toLowerCase();
                if (!response.equals("y")) {
                    System.out.println("Creación de archivo cancelada.");
                    return false;
                }
            }
    
            // Escribir contenido en el archivo
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(export_prog);
                System.out.println("Archivo creado exitosamente en: " + filePath);
                return true;
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
                return false;
            }
        }
}

}