package com.compi;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum TOKENType {
    PRProgram, TypeInt, TypeFloat, TypeString, TypeBool, ID, SignEqual, String, NUM,
    SignDot, PRBool, ParenRight, ParenLeft, LeftKey, RightKey, PRBegin, PRExp, PRCond,
    PRVar, DoubleDot, PRSegFunct, PRFunct, PREnd, PRLoop, Output, Input, Plus, Minus,
    Mult, Div, Minor, MinorEqual, Major, MajorEqual, Dif, PRReturn, PRElse
}

class TOKEN {
    TOKENType type;
    String value;

    public TOKEN(TOKENType type, String value) {
        this.type = type;
        this.value = value;
    }

}

public class Lexer {
    private String input;
    private List<TOKEN> tokens;

    public Lexer(String input) {
        this.input = input;
        this.tokens = new ArrayList<>();
    }

    public void tokenize() {
        // ER para la palabra reservada de programa
        String PRProgram = "(?<PRProgram>\\bProgram\\b)";
        String TypeInt = "(?<TypeInt>\\bint\\b)";
        String TypeFloat = "(?<TypeFloat>\\bfloat\\b)";
        String TypeString = "(?<TypeString>\\bstring\\b)";
        String TypeBool = "(?<TypeBool>\\bbool\\b)";
        String ID = "(?<ID>[a-zA-Z][a-zA-Z0-9]*[^?])";
        String SignEqual = "(?<SignEqual>=)";
        String StringLiteral = "(?<String>\"[^\"]*\")";
        String NUM = "(?<NUM>\\b\\d+\\b)";
        String SignDot = "(?<SignDot>\\.)";
        String PRBool = "(?<PRBool>\\btrue|false\\b)";
        String ParenRight = "(?<ParenRight>\\))";
        String ParenLeft = "(?<ParenLeft>\\()";
        String LeftKey = "(?<LeftKey>\\{)";
        String RightKey = "(?<RightKey>\\})";
        String PRBegin = "(?<PRBegin>\\bBEGIN\\b)";
        String PRExp = "(?<PRExp>\\bexp\\b)";
        String PRCond = "(?<PRCond>\\bcond\\b)";
        String PRVar = "(?<PRVar>\\bVARIABLE\\b)";
        String DoubleDot = "(?<DoubleDot>:)";
        String PRSegFunct = "(?<PRSegFunct>\\bFUNCTION\\b)";
        String PRFunct = "(?<PRFunct>\\bfunction\\b)";
        String PREnd = "(?<PREnd>\\bEND\\b)";
        String PRLoop = "(?<PRLoop>\\bloop\\b)";
        String Output = "(?<Output>\\bwrite\\b)";
        String Input = "(?<Input>\\boutput\\b)";
        String PRReturn = "(?<PRReturn>\\bRETURN\\b)";
        String Plus = "(?<Plus>\\+)";
        String Minus = "(?<Minus>\\-)";
        String Mult = "(?<Mult>\\*)";
        String Div = "(?<Div>\\/)";
        String Minor = "(?<Minor>\\<)";
        String Major = "(?<Major>\\>)";
        String MinorEqual = "(?<MinorEqual>\\<=)";
        String MajorEqual = "(?<MajorEqual>\\>=)";
        String Dif = "(?<Dif>\\<>)";
        String PRElse = "(?<PRElse>\\belse\\b)";

        String regex = String.join("|", PRProgram, PRVar, TypeInt, TypeFloat, TypeString, TypeBool, StringLiteral,
                PRBool, PRSegFunct, PRFunct, PRReturn, Plus, Minus, Mult, Div, Dif, MinorEqual, Minor, MajorEqual,
                Major, SignEqual, NUM, SignDot, ParenRight, ParenLeft,
                LeftKey, RightKey, PRBegin, PRExp, PRCond, DoubleDot, PREnd, PRLoop, Output, Input, PRElse, ID);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            for (TOKENType type : TOKENType.values()) {
                if (matcher.group(type.name()) != null) {
                    tokens.add(new TOKEN(type, matcher.group(type.name())));
                    break;
                }
            }
        }
    }

    public List<TOKEN> getTokens() {
        return tokens;
    }

}
