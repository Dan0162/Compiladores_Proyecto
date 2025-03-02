package com.compi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    
    public static boolean LexicalChech(String program){
        if (!S(program)){
            return false; //error
        }
        
        if (!seg_var(parser(program, "ProgramVARIABLE:(.*?)FUNCTION:(.*?)BEGIN(.*?)END", 1))){
            return false; //error
        }

        if (!seg_funct(parser(program, "ProgramVARIABLE:(.*?)FUNCTION:(.*?)BEGIN(.*?)END", 2))){
            return false; //error
        }

        return true;
    }

    private static boolean S(String program){ 
        //<S> → Program <seg_var> <seg_funct> BEGIN <body_program> END

        if (program.matches(".*Program.*BEGIN.*END.*")) {
            return true;
        } else {
            return false; //error
        }
    }

    private static boolean seg_var(String VARIABLE){ 
        //<seg_var> → VARIABLE : <def_var> <more_var>

        while (!VARIABLE.isEmpty()){//<def_var> → 𝜺 & <more_var> → 𝜺
            if(VARIABLE.matches("int\\s+([a-zA-Z][a-zA-Z0-9]*)\\s*=\\s*([0-9]+)\\s*;.*")){ 
                //<def_var> → int ID = Dígitos;
                VARIABLE = parser(VARIABLE, "^(.*?);(.*)$", 2);                
            }
            else if(VARIABLE.matches("float\\s+([a-zA-Z][a-zA-Z0-9]*)\\s*=\\s*([0-9]+.[0-9]+)\\s*;.*")){
                //<def_var> →  float ID = Dígitos.Dígitos;
                VARIABLE = parser(VARIABLE, "^(.*?);(.*)$", 2);

            }
            else if(VARIABLE.matches("string\\s+([a-zA-Z][a-zA-Z0-9]*)\\s*=\\s*\"(.*)\"\\s*;.*")){//duda con el (.*)
                //<def_var> → string ID = “ Cadena “;
                VARIABLE = parser(VARIABLE, "^(.*?);(.*)$", 2);
            }
            else if(VARIABLE.matches("bool\\s+([a-zA-Z][a-zA-Z0-9]*)\\s*=\\s*(true|false)\\s*;.*")){
                //<def_var> → bool ID = PRBool;
                VARIABLE = parser(VARIABLE, "^(.*?);(.*)$", 2);
            }
            else{
                return false;    
            }
        }

        return true;
    }

    private static boolean seg_funct (String FUNCTION){
        
        while (!FUNCTION.isEmpty()){
            if (FUNCTION.matches("function\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s*\\((.*?)\\)\\s*\\{(.*?)RETURN\\s+([a-zA-Z_][a-zA-Z0-9_]*);\\}.*")){
                if(!def_arith(parser(FUNCTION, "function\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s*\\((.*?)\\)\\s*\\{(.*?)RETURN\\s+([a-zA-Z_][a-zA-Z0-9_]*);\\}.*", 3))){
                    return false; //error en aritmética.
                }
                FUNCTION = parser(FUNCTION,"function\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s*\\((.*?)\\)\\s*\\{(.*?)RETURN\\s+([a-zA-Z_][a-zA-Z0-9_]*);\\}(.*)", 5);
            }
        }
        
        return true;
    }

    private static boolean body_program(String BODY){

        return true;
    }

    private static boolean def_arith(String ARITHMETIC){


        return true;
    }
    private static String parser(String text, String regex, int segment){ //Función general para reducir ciertas partes del programa en segmentos

        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return(matcher.group(segment).trim());
        } else {
            System.out.println("No match found!"); //error
            return("");
        }

    }

}
