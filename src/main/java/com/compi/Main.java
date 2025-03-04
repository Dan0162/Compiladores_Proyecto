package com.compi;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

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
}