package com.compi;

import com.compi.Gramatica_ANLTR4.ProjBaseVisitor;
import com.compi.Gramatica_ANLTR4.ProjParser.*;

public class Evaluador extends ProjBaseVisitor<String> {

    private String exportProg = "";
    private String exportName = "";
    private int indentLevel = 0;
    
    private String indent() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indentLevel; i++) {
            sb.append("    ");
        }
        return sb.toString();
    }

    public String getExportProg() {
        return exportProg;
    }
    
    public String getExportName() {
        return exportName;
    }

    @Override
    public String visitProg(ProgContext ctx) {
        System.out.println("Visit: Prog");
        return visitChildren(ctx);
    }

    @Override
    public String visitHeader(HeaderContext ctx) {
        System.out.println("Visit: Header");
        exportName = ctx.ID().getText();
        exportProg = "public class " + exportName + " {\n";
        return visitChildren(ctx);
    }

    @Override
    public String visitSegvar(SegvarContext ctx) {
        System.out.println("Visit: Segvar");
        return visitChildren(ctx);
    }

    @Override
    public String visitDefvar(DefvarContext ctx) {
        System.out.println("Visit: Def_var");
        
        if (ctx.ID() != null) {
            if ("int".equals(ctx.getChild(0).getText())) {
                exportProg += indent() + "public static int " + ctx.ID().getText() + " = " + ctx.Digitos(0).getText() + ";\n";
            } else if ("float".equals(ctx.getChild(0).getText())) {
                exportProg += indent() + "public static float " + ctx.ID().getText() + " = " + 
                              ctx.Digitos(0).getText() + "." + ctx.Digitos(1).getText() + "f;\n";
            } else if ("string".equals(ctx.getChild(0).getText())) {
                exportProg += indent() + "public static String " + ctx.ID().getText() + " = " + ctx.Cadena().getText() + ";\n";
            } else if ("bool".equals(ctx.getChild(0).getText())) {
                exportProg += indent() + "public static boolean " + ctx.ID().getText() + " = " + 
                              (ctx.getText().contains("true") ? "true" : "false") + ";\n";
            }
        }
        return null;
    }

    @Override
    public String visitSegfunct(SegfunctContext ctx) {
        System.out.println("Visit: Segfunct");
        return visitChildren(ctx);
    }

    @Override
    public String visitDeffunct(DeffunctContext ctx) {
        System.out.println("Visit: Deffunct");
        if (ctx.ID().size() >= 2) {
            String functionName = ctx.ID(0).getText();
            String paramName = ctx.ID(1).getText();
            
            exportProg += indent() + "public static int " + functionName + "(" + "int " + paramName + ") {\n";
            indentLevel++;
            visit(ctx.bodyfunct());
            indentLevel--;
            exportProg += indent() + "}\n\n";
            
            if (ctx.deffunct() != null) {
                visit(ctx.deffunct());
            }
        }
        return null;
    }

    @Override
    public String visitBodyfunct(BodyfunctContext ctx) {
        System.out.println("Visit: Bodyfunct");
        
        if (ctx.defarith() != null) {
            StringBuilder expressionBuilder = new StringBuilder();
            processDefarith(ctx.defarith(), expressionBuilder);
            
            if (!expressionBuilder.toString().isEmpty()) {
                if (ctx.defarith().bodysegE() != null) {
                    String paramName = ctx.ID().getText();
                    exportProg += indent() + paramName + " = " + expressionBuilder.toString() + ";\n";
                }
            }
        }
        
        if (ctx.ID() != null) {
            exportProg += indent() + "return " + ctx.ID().getText() + ";\n";
        }
        
        return null;
    }
    
    private void processDefarith(DefarithContext ctx, StringBuilder builder) {
        if (ctx.bodysegE() != null) {
            processExpression(ctx.bodysegE(), builder);
        }
    }

    @Override
    public String visitDefarith(DefarithContext ctx) {
        System.out.println("Visit: Defarith");
        return visitChildren(ctx);
    }

    @Override
    public String visitBodysegE(BodysegEContext ctx) {
        StringBuilder expressionBuilder = new StringBuilder();
        processExpression(ctx, expressionBuilder);
        
        return expressionBuilder.toString();
    }

    private void processExpression(BodysegEContext ctx, StringBuilder builder) {
        processBodysegT(ctx.bodysegT(), builder);
        
        if (ctx.bodysegE2() != null) {
            processBodysegE2(ctx.bodysegE2(), builder);
        }
    }

    private void processBodysegE2(BodysegE2Context ctx, StringBuilder builder) {
        if (ctx.getChildCount() > 0) {
            builder.append(" ").append(ctx.getChild(0).getText()).append(" ");
            
            processBodysegT(ctx.bodysegT(), builder);
            
            if (ctx.bodysegE2() != null) {
                processBodysegE2(ctx.bodysegE2(), builder);
            }
        }
    }

    private void processBodysegT(BodysegTContext ctx, StringBuilder builder) {
        processItemArith(ctx.itemarith(), builder);
        
        if (ctx.bodysegT2() != null) {
            processBodysegT2(ctx.bodysegT2(), builder);
        }
    }

    private void processBodysegT2(BodysegT2Context ctx, StringBuilder builder) {
        if (ctx.getChildCount() > 0) {
            builder.append(" ").append(ctx.getChild(0).getText()).append(" ");
            
            processItemArith(ctx.itemarith(), builder);
            
            if (ctx.bodysegT2() != null) {
                processBodysegT2(ctx.bodysegT2(), builder);
            }
        }
    }

    private void processItemArith(ItemarithContext ctx, StringBuilder builder) {
        if (ctx.ID() != null) {
            builder.append(ctx.ID().getText());
        } else if (ctx.Digitos() != null) {
            builder.append(ctx.Digitos().getText());
        } else if (ctx.bodysegE() != null) {
            builder.append("(");
            StringBuilder nestedBuilder = new StringBuilder();
            processExpression(ctx.bodysegE(), nestedBuilder);
            builder.append(nestedBuilder);
            builder.append(")");
        }
    }

    @Override
    public String visitBody_program(Body_programContext ctx) {
        System.out.println("Visit: Body_program");
        
        exportProg += "\n" + indent() + "public static void main(String[] args) {\n";
        indentLevel++;
        
        return visitChildren(ctx);
    }

    @Override
    public String visitDef_cond(Def_condContext ctx) {
        System.out.println("Visit: Def_cond");
        
        exportProg += indent() + "if (";
        visit(ctx.def_exp());
        exportProg += ") {\n";
        
        indentLevel++;
        visit(ctx.def_w());
        indentLevel--;
        exportProg += indent() + "}";
        
        if (ctx.else_cond() != null) {
            exportProg += " ";
            visit(ctx.else_cond());
        } else {
            exportProg += "\n";
        }
        
        return null;
    }

    @Override
    public String visitDef_exp(Def_expContext ctx) {
        System.out.println("Visit: Def_exp");
        
        String id = ctx.ID().getText();
        
        if (ctx.COMP() != null) {
            exportProg += id + " " + ctx.COMP().getText() + " " + ctx.Digitos().getText();
        } else if (ctx.EQUAL() != null) {
            if (ctx.Digitos() != null) {
                exportProg += id + " " + convertEqualOperator(ctx.EQUAL().getText()) + " " + ctx.Digitos().getText();
            } else {
                exportProg += id + " " + convertEqualOperator(ctx.EQUAL().getText()) + " " + 
                             (ctx.getText().contains("true") ? "true" : "false");
            }
        }
        
        return null;
    }
    
    private String convertEqualOperator(String op) {
        if ("==".equals(op)) return "==";
        if ("!=".equals(op)) return "!=";
        return op; 
    }

    @Override
    public String visitElse_cond(Else_condContext ctx) {
        System.out.println("Visit: Else_cond");
        
        exportProg += "else {\n";
        
        indentLevel++;
        visit(ctx.def_w());
        indentLevel--;
        
        exportProg += indent() + "}\n";
        
        return null;
    }

    @Override
    public String visitDef_while(Def_whileContext ctx) {
        System.out.println("Visit: Def_while");
        
        String id = ctx.ID(0).getText();
        String comp = ctx.COMP().getText();
        String value = ctx.Digitos().getText();
        
        exportProg += indent() + "while (" + id + " " + comp + " " + value + ") {\n";
        
        indentLevel++;
        visit(ctx.def_w());
        
        String updateId = ctx.ID(1).getText();
        String op = ctx.getChild(8).getText();
        if ("+".equals(op)) {
            exportProg += indent() + updateId + "++;\n";
        } else if ("-".equals(op)) {
            exportProg += indent() + updateId + "--;\n";
        }
        
        indentLevel--;
        exportProg += indent() + "}\n";
        
        return null;
    }

    @Override
    public String visitDef_w(Def_wContext ctx) {
        System.out.println("Visit: Def_w");
        
        if (ctx.getText().contains("output")) {
            String content;
            if (ctx.Cadena() != null) {
                content = ctx.Cadena().getText();
            } else if (ctx.ID() != null) {
                content = ctx.ID().getText();
            } else {
                content = "\"\""; 
            }
            exportProg += indent() + "System.out.println(" + content + ");\n";
        } else if (ctx.getText().contains("input")) {
            String varName = ctx.ID().getText();
            
            if (!exportProg.contains("Scanner scanner")) {
                exportProg += indent() + "java.util.Scanner scanner = new java.util.Scanner(System.in);\n";
            }
            
            String varType = determineVariableType(varName);
            String scannerMethod = getScannerMethodForType(varType);
            
            exportProg += indent() + varName + " = scanner." + scannerMethod + ";\n";
        }
        
        return null;
    }
    

    private String determineVariableType(String varName) {
        // Check for types in the generated code
        if (exportProg.contains("int " + varName + " =")) {
            return "int";
        } else if (exportProg.contains("float " + varName + " =")) {
            return "float";
        } else if (exportProg.contains("String " + varName + " =")) {
            return "String";
        } else if (exportProg.contains("boolean " + varName + " =")) {
            return "boolean";
        }
        
        // Default to int if type can't be determined
        return "int";
    }
    

    private String getScannerMethodForType(String type) {
        switch (type) {
            case "int":
                return "nextInt()";
            case "float":
                return "nextFloat()";
            case "String":
                return "nextLine()";
            case "boolean":
                return "nextBoolean()";
            default:
                return "nextInt()"; 
        }
    }

    @Override
    public String visitCall_funct(Call_functContext ctx) {
        System.out.println("Visit: Call_funct");
        
        if (ctx.ID().size() >= 3) {
            String resultVar = ctx.ID(0).getText();
            String functionName = ctx.ID(1).getText();
            String paramVar = ctx.ID(2).getText();
            
            exportProg += indent() + resultVar + " = " + functionName + "(" + paramVar + ");\n";
        }
        
        return null;
    }

    @Override
    public String visitBody_end(Body_endContext ctx) {
        System.out.println("Visit: Body_end");
        
        indentLevel--;
        exportProg += indent() + "}\n";
        
       exportProg += "}\n";
        
        return null;
    }
}
