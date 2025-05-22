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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        System.out.println(
                "Por favor ingresar la ruta del archivo .txt que contiene su lenguaje. Solamente se aceptan archivos .txt\n");

        String path = null;
        try {
            path = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!path.endsWith(".txt")) {
            throw new Exception("El archivo ingresado no es un archivo .txt");
        }

        String file = getFile(path);

        if (file != null) {
            Lexer lexer = new Lexer(file);
            lexer.tokenize();
            for (TOKEN token : lexer.getTokens()) {
                System.out.println("Token: " + token.type + " -> " + token.value);
            }

            System.out.println("--------------------------------------------------");

            ProjLexer lexer2 = new ProjLexer(CharStreams.fromString(file));
            CommonTokenStream tokens = new CommonTokenStream(lexer2);
            ProjParser parser = new ProjParser(tokens);

            ParseTree tree = parser.prog();

            // Usar el visitor
            Evaluador visitor = new Evaluador();
            String resultado = visitor.visit(tree);

            createFile(visitor.getExportName() + ".java", visitor.getExportProg());

        }

    }

    public static String getFile(String path) {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            reader.close();
            return stringBuilder.toString();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public static boolean createFile(String export_name, String export_prog) {
    Scanner scanner = new Scanner(System.in);
    
    // Ask for directory
    System.out.print("Ingrese el directorio para guardar su archivo: ");
    String directoryPath = scanner.nextLine();
    
    // Create directory if it doesn't exist
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
    
    // Create full path for the file
    String filePath = directoryPath + File.separator + export_name;
    File file = new File(filePath);
    
    // Check if file already exists
    if (file.exists()) {
        System.out.print("El archivo ya existe. ¿Desea sobrescribirlo? (y/n): ");
        String response = scanner.nextLine().trim().toLowerCase();
        if (!response.equals("y")) {
            System.out.println("Creación de archivo cancelada.");
            return false;
        }
    }
    
    // Write content to file
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