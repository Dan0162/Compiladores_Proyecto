package com.compi;

import com.compi.Gramatica_ANLTR4.ProjBaseVisitor;
import com.compi.Gramatica_ANLTR4.ProjParser;
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
        // Process variable declarations
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
        
        String functionName = ctx.ID(0).getText();  // Function name
        String paramName = ctx.ID(1).getText();     // Parameter name
        
        exportProg += indent() + "public static int " + functionName + "(" + "int " + paramName + ") {\n";
        indentLevel++;
        visit(ctx.bodyfunct());
        indentLevel--;
        exportProg += indent() + "}\n\n";
        
        return null;
    }

@Override
public String visitBodyfunct(BodyfunctContext ctx) {
    System.out.println("Visit: Bodyfunct");
    
    // Process all arithmetic expressions in the function body
    for (DefarithContext defarithCtx : ctx.defarith()) {
        StringBuilder expressionBuilder = new StringBuilder();
        processDefarith(defarithCtx, expressionBuilder);
        
        if (!expressionBuilder.toString().isEmpty()) {

            DeffunctContext parentCtx = (DeffunctContext) ctx.getParent();
            if (parentCtx != null && parentCtx.ID().size() >= 2) {
                String paramName = parentCtx.ID(1).getText(); // Parameter name
                exportProg += indent() + paramName + " = " + expressionBuilder.toString() + ";\n";
            }
        }
    }
    
    // Process return statement
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
        // This is only used when we need to handle a free-standing expression outside of a function
        StringBuilder expressionBuilder = new StringBuilder();
        processExpression(ctx, expressionBuilder);
        
        return expressionBuilder.toString();
    }

    private void processExpression(BodysegEContext ctx, StringBuilder builder) {
        // Process term
        processBodysegT(ctx.bodysegT(), builder);
        
        // Process the rest of expression if any
        if (ctx.bodysegE2() != null) {
            processBodysegE2(ctx.bodysegE2(), builder);
        }
    }

    private void processBodysegE2(BodysegE2Context ctx, StringBuilder builder) {
        if (ctx.getChildCount() > 0) {
            // Add operator
            builder.append(" ").append(ctx.getChild(0).getText()).append(" ");
            
            // Process term
            processBodysegT(ctx.bodysegT(), builder);
            
            // Process the rest recursively
            if (ctx.bodysegE2() != null) {
                processBodysegE2(ctx.bodysegE2(), builder);
            }
        }
    }

    private void processBodysegT(BodysegTContext ctx, StringBuilder builder) {
        // Process item
        processItemArith(ctx.itemarith(), builder);
        
        // Process the rest of term if any
        if (ctx.bodysegT2() != null) {
            processBodysegT2(ctx.bodysegT2(), builder);
        }
    }

    private void processBodysegT2(BodysegT2Context ctx, StringBuilder builder) {
        if (ctx.getChildCount() > 0) {
            // Add operator
            builder.append(" ").append(ctx.getChild(0).getText()).append(" ");
            
            // Process item
            processItemArith(ctx.itemarith(), builder);
            
            // Process the rest recursively
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
        
        // Add main method
        exportProg += "\n" + indent() + "public static void main(String[] args) {\n";
        indentLevel++;
        
        // Visit all statements in the body
        return visitChildren(ctx);
    }

    @Override
    public String visitDef_cond(Def_condContext ctx) {
        System.out.println("Visit: Def_cond");
        
        // Process if condition
        exportProg += indent() + "if (";
        visit(ctx.def_exp());
        exportProg += ") {\n";
        
        // Process if body
        indentLevel++;
        visit(ctx.def_w());
        indentLevel--;
        exportProg += indent() + "}";
        
        // Process else if exists
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
            // Comparison operator
            exportProg += id + " " + ctx.COMP().getText() + " " + ctx.Digitos().getText();
        } else if (ctx.EQUAL() != null) {
            // Equality operator
            if (ctx.Digitos() != null) {
                exportProg += id + " " + convertEqualOperator(ctx.EQUAL().getText()) + " " + ctx.Digitos().getText();
            } else {
                // Boolean comparison
                exportProg += id + " " + convertEqualOperator(ctx.EQUAL().getText()) + " " + 
                             (ctx.getText().contains("true") ? "true" : "false");
            }
        }
        
        return null;
    }
    
    private String convertEqualOperator(String op) {
        if ("==".equals(op)) return "==";
        if ("!=".equals(op)) return "!=";
        return op; // Default fallback
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


// Replace your existing visitDef_while method with this:
@Override
public String visitDef_while(Def_whileContext ctx) {
    System.out.println("Visit: Def_while");
    
    // Build the condition from def_exp
    exportProg += indent() + "while (";
    visit(ctx.def_exp());
    exportProg += ") {\n";
    
    indentLevel++;
    
    // Process all def_w statements inside the loop
    for (Def_wContext wCtx : ctx.def_w()) {
        visit(wCtx);
    }
    
    // Process the increment/decrement statement - THIS IS THE KEY FIX
    if (ctx.increment_decrement() != null) {
        visit(ctx.increment_decrement());
    }
    
    indentLevel--;
    exportProg += indent() + "}\n";
    
    return null;
}

// Add this new method to handle increment_decrement (this is new, add it to your class):
@Override
public String visitIncrement_decrement(Increment_decrementContext ctx) {
    System.out.println("Visit: Increment_decrement");
    
    String varName = ctx.ID().getText();
    String operator = ctx.getChild(1).getText(); // Gets '+' or '-'
    
    if (operator.equals("+")) {
        exportProg += indent() + varName + "++;\n";
    } else if (operator.equals("-")) {
        exportProg += indent() + varName + "--;\n";
    }
    
    return null;
}



    @Override
    public String visitDef_w(Def_wContext ctx) {
        System.out.println("Visit: Def_w");
        
        if (ctx.getText().contains("output")) {
            // Handle output/write statement
            String content;
            if (ctx.Cadena() != null) {
                content = ctx.Cadena().getText();
            } else if (ctx.ID() != null) {
                content = ctx.ID().getText();
            } else {
                content = "\"\""; // Empty string as fallback
            }
            exportProg += indent() + "System.out.println(" + content + ");\n";
        } else if (ctx.getText().contains("input")) {
            // Handle input/read statement with proper Java Scanner implementation
            String varName = ctx.ID().getText();
            
            // First, check if there's a Scanner instance already defined
            if (!exportProg.contains("Scanner scanner")) {
                exportProg += indent() + "java.util.Scanner scanner = new java.util.Scanner(System.in);\n";
            }
            
            // Determine the variable type to use the appropriate Scanner method
            String varType = determineVariableType(varName);
            String scannerMethod = getScannerMethodForType(varType);
            
            exportProg += indent() + varName + " = scanner." + scannerMethod + ";\n";
        }
        
        return null;
    }
    
    /**
     * Determine the type of a variable by looking for its declaration in the existing code
     */
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
    
    /**
     * Get the appropriate Scanner method for the given variable type
     */
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
                return "nextInt()"; // Default to int
        }
    }

    @Override
    public String visitCall_funct(Call_functContext ctx) {
        System.out.println("Visit: Call_funct");
        
        if (ctx.ID().size() >= 3) {
            String resultVar = ctx.ID(0).getText();
            String functionName = ctx.ID(1).getText();
            String paramVar = ctx.ID(2).getText();
            
            // Use the variable without redeclaring it to avoid shadowing class variables
            exportProg += indent() + resultVar + " = " + functionName + "(" + paramVar + ");\n";
        }
        
        return null;
    }

    @Override
    public String visitBody_end(Body_endContext ctx) {
        System.out.println("Visit: Body_end");
        
        // Close main method
        indentLevel--;
        exportProg += indent() + "}\n";
        
        // Close class
        exportProg += "}\n";
        
        return null;
    }
}