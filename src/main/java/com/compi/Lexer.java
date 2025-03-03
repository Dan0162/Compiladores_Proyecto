package com.compi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    
    public static boolean LexicalChech(String program){
        if (!S(program)){
            return false; //error
        }        
        else if (!seg_var(parser(program, "ProgramVARIABLE:(.*?)FUNCTION:(.*?)BEGIN(.*?)END", 1))){
            return false; //error
        }
        else if (!seg_funct(parser(program, "ProgramVARIABLE:(.*?)FUNCTION:(.*?)BEGIN(.*?)END", 2))){
            return false; //error
        }
        else if (!body_program(parser(program, "ProgramVARIABLE:(.*?)FUNCTION:(.*?)BEGIN(.*?)END", 3))){
            return false; //error
        }
        return true;
    }

    private static boolean S(String program){ 
        return program.matches(".*Program.*BEGIN.*END.*");
    }

    private static boolean seg_var(String VARIABLE){ 
        while (!VARIABLE.isEmpty()){
            if(VARIABLE.matches("int\\s+([a-zA-Z][a-zA-Z0-9]*)\\s*=\\s*([0-9]+)\\s*;.*")){ 
                VARIABLE = parser(VARIABLE, "^(.*?);(.*)$", 2);                
            }
            else if(VARIABLE.matches("float\\s+([a-zA-Z][a-zA-Z0-9]*)\\s*=\\s*([0-9]+\\.[0-9]+)\\s*;.*")){
                VARIABLE = parser(VARIABLE, "^(.*?);(.*)$", 2);
            }
            else if(VARIABLE.matches("string\\s+([a-zA-Z][a-zA-Z0-9]*)\\s*=\\s*\"(.*)\"\\s*;.*")){
                VARIABLE = parser(VARIABLE, "^(.*?);(.*)$", 2);
            }
            else if(VARIABLE.matches("bool\\s+([a-zA-Z][a-zA-Z0-9]*)\\s*=\\s*(true|false)\\s*;.*")){
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
            if (FUNCTION.matches("function\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s*\\((.*?)\\)\\s*\\{(.*?)RETURN\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s*;\\}.*")){
                if(!def_arith(parser(FUNCTION, "function\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s*\\((.*?)\\)\\s*\\{(.*?)RETURN\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s*;\\}.*", 3))){
                    return false;
                }
                FUNCTION = parser(FUNCTION, "function\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s*\\((.*?)\\)\\s*\\{(.*?)RETURN\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s*;\\}(.*)", 5);
            }
        }
        return true;
    }

    private static boolean body_program(String BODY){
        return true;
    }

    private static boolean def_wr(String WR){
        if (WR.matches("output\\s+write\\s*\\((.*?)\\);.*")) {
            String cont = parser(WR, "output\\s+write\\s*\\((.*?)\\);", 1);
            if (!cont(cont)) {
                return false;
            }
            return body_program(parser(WR, "output\\s+write\\s*\\((.*?)\\);(.*)", 2));
        } else if (WR.matches("input\\s+([a-zA-Z][a-zA-Z0-9]*)\\s*=\\s*read\\s*\\((.*?)\\);.*")) {
            String cont = parser(WR, "input\\s+([a-zA-Z][a-zA-Z0-9]*)\\s*=\\s*read\\s*\\((.*?)\\);", 2);
            if (!cont(cont)) {
                return false;
            }
            return body_program(parser(WR, "input\\s+([a-zA-Z][a-zA-Z0-9]*)\\s*=\\s*read\\s*\\((.*?)\\);(.*)", 3));
        } else {
            return WR.isEmpty() || body_program(WR);
        }
    }

    private static boolean cont(String CONT) {
        return CONT.matches("\".*\"") || CONT.matches("\\d+") || CONT.matches("\\d+\\.\\d+") || CONT.isEmpty();
    }

    private static boolean def_arith(String ARITHMETIC){
        return body_seg_E(ARITHMETIC);
    }
    
    private static boolean body_seg_E(String E) {
        return !E.isEmpty();
    }
    
    private static String parser(String text, String regex, int segment){
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(segment).trim();
        } else {
            System.out.println("No match found!");
            return "";
        }
    }
}
