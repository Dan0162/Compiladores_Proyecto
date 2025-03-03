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
        //<seg_funct> → FUNCTION : <def_funct>
        
        while (!FUNCTION.isEmpty()){//<def_funct> → 𝜺 
            if (FUNCTION.matches("function\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s*\\((.*?)\\)\\s*\\{(.*?)RETURN\\s+([a-zA-Z_][a-zA-Z0-9_]*);\\}.*")){
                //<def_funct> → function Letras ( ID ) {  <body_funct>
                if(!def_arith(parser(FUNCTION, "function\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s*\\((.*?)\\)\\s*\\{(.*?)RETURN\\s+([a-zA-Z_][a-zA-Z0-9_]*);\\}.*", 3))){
                    return false; //error en aritmética.
                }
                FUNCTION = parser(FUNCTION,"function\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s*\\((.*?)\\)\\s*\\{(.*?)RETURN\\s+([a-zA-Z_][a-zA-Z0-9_]*);\\}(.*)", 5);
            }
        }
        
        return true;
    }

    private static boolean body_program(String BODY){
        //<body_program> →  <def_cond><def_while><def_wr><call_funct>


        return true;
    }

    private static boolean def_cond(String COND){
        //<def_cond> → cond if (EXP) { <body_cond>

        return true;
    }

    private static boolean def_while(String WHILE){
        //<def_while> →  loop while( ID > Digito ) { <body_while>

        return true;
    }

    private static boolean def_wr(String WR){
    //<def_wr> → output write ( <cont> ); <body_program>  
    //<def_wr> → input ID = read ( <cont> ); <body_program>
    //<def_wr> → 𝜺

    if (WR.matches("output\\s+write\\s*\\((.*?)\\);.*")) {
        String cont = parser(WR, "output\\s+write\\s*\\((.*?)\\);", 1);
        if (!cont(cont)) {
            return false; // error en contenido
        }
        return body_program(parser(WR, "output\\s+write\\s*\\((.*?)\\);(.*)", 2));
    } else if (WR.matches("input\\s+([a-zA-Z][a-zA-Z0-9]*)\\s*=\\s*read\\s*\\((.*?)\\);.*")) {
        String cont = parser(WR, "input\\s+([a-zA-Z][a-zA-Z0-9]*)\\s*=\\s*read\\s*\\((.*?)\\);", 2);
        if (!cont(cont)) {
            return false; // error en contenido
        }
        return body_program(parser(WR, "input\\s+([a-zA-Z][a-zA-Z0-9]*)\\s*=\\s*read\\s*\\((.*?)\\);(.*)", 3));
    } else {
        return WR.isEmpty() || body_program(WR);
    }


private static boolean cont(String CONT) {
    //<cont> → Cadena  
    //<cont> → Dígitos 
    //<cont> → Dígitos . Dígitos 
    //<cont> → 𝜺

    if (CONT.matches("\".*\"")) {
        return true; // Cadena
    } else if (CONT.matches("\\d+")) {
        return true; // Dígitos
    } else if (CONT.matches("\\d+\\.\\d+")) {
        return true; // Dígitos.Dígitos
    } else {
        return CONT.isEmpty(); // 𝜺
    
        //<def_wr>→ output write ( <cont> ) <body_program>  

        return true;
    }

    private static boolean call_funct(String FUNCT){
        //<call_funct> → ID =  Letras ( ID ) <body_program>;

        return true;
    }

    private static boolean def_arith(String ARITHMETIC){
    return body_seg_E(ARITHMETIC);
}

private static boolean body_seg_E(String E) {
    if (E == null || E.isEmpty()) return false;

    String bodyT = parser(E, "(.*?)\\+.*|", 1);
    String rest = parser(E, ".*?\\+(.*)", 2);
    if (bodyT != null && body_seg_T(bodyT) && body_seg_E_prime(rest)) return true;

    bodyT = parser(E, "(.*?)\\-.*|", 1);
    rest = parser(E, ".*?\\-(.*)", 2);
    return bodyT != null && body_seg_T(bodyT) && body_seg_E_prime(rest);
}

private static boolean body_seg_E_prime(String E_prime) {
    if (E_prime == null || E_prime.isEmpty()) return true;

    String bodyT = parser(E_prime, "(.*?)\\+.*|", 1);
    String rest = parser(E_prime, ".*?\\+(.*)", 2);
    if (bodyT != null && body_seg_T(bodyT) && body_seg_E_prime(rest)) return true;

    bodyT = parser(E_prime, "(.*?)\\-.*|", 1);
    rest = parser(E_prime, ".*?\\-(.*)", 2);
    return bodyT != null && body_seg_T(bodyT) && body_seg_E_prime(rest);
}

private static boolean body_seg_T(String T) {
    if (T == null || T.isEmpty()) return false;

    String item = parser(T, "(.*?)\\*.*|", 1);
    String rest = parser(T, ".*?\\*(.*)", 2);
    if (item != null && item_arith(item) && body_seg_T_prime(rest)) return true;

    item = parser(T, "(.*?)\\/.*|", 1);
    rest = parser(T, ".*?\\/(.*)", 2);
    return item != null && item_arith(item) && body_seg_T_prime(rest);
}

private static boolean body_seg_T_prime(String T_prime) {
    if (T_prime == null || T_prime.isEmpty()) return true;

    String item = parser(T_prime, "(.*?)\\*.*|", 1);
    String rest = parser(T_prime, ".*?\\*(.*)", 2);
    if (item != null && item_arith(item) && body_seg_T_prime(rest)) return true;

    item = parser(T_prime, "(.*?)\\/.*|", 1);
    rest = parser(T_prime, ".*?\\/(.*)", 2);
    return item != null && item_arith(item) && body_seg_T_prime(rest);
}

private static boolean item_arith(String item) {
    if (item.matches("\\d+")) { // Dígitos
        return true;
    } else if (item.matches("[a-zA-Z][a-zA-Z0-9]*")) { // ID
        return true;
    } else if (item.matches("\\(.*\\)")) { // ( <body_seg_E> )
        return body_seg_E(parser(item, "\\((.*)\\)", 1));
    } else {
        return false;
    }
}

private static boolean more_arith(String E) {
    // <more_arith> → <body_seg_E>
    // <more_arith> → 𝜺
    return E.isEmpty() || body_seg_E(E);
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
