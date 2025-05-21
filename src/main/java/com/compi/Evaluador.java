package com.compi;

import com.compi.Gramatica_ANLTR4.ProjBaseVisitor;
import com.compi.Gramatica_ANLTR4.ProjParser.Body_programContext;
import com.compi.Gramatica_ANLTR4.ProjParser.BodyfunctContext;
import com.compi.Gramatica_ANLTR4.ProjParser.BodysegE2Context;
import com.compi.Gramatica_ANLTR4.ProjParser.BodysegEContext;
import com.compi.Gramatica_ANLTR4.ProjParser.BodysegT2Context;
import com.compi.Gramatica_ANLTR4.ProjParser.BodysegTContext;
import com.compi.Gramatica_ANLTR4.ProjParser.Call_functContext;
import com.compi.Gramatica_ANLTR4.ProjParser.Def_condContext;
import com.compi.Gramatica_ANLTR4.ProjParser.Def_expContext;
import com.compi.Gramatica_ANLTR4.ProjParser.Def_wContext;
import com.compi.Gramatica_ANLTR4.ProjParser.Def_whileContext;
import com.compi.Gramatica_ANLTR4.ProjParser.DefarithContext;
import com.compi.Gramatica_ANLTR4.ProjParser.DeffunctContext;
import com.compi.Gramatica_ANLTR4.ProjParser.DefvarContext;
import com.compi.Gramatica_ANLTR4.ProjParser.Else_condContext;
import com.compi.Gramatica_ANLTR4.ProjParser.ItemarithContext;
import com.compi.Gramatica_ANLTR4.ProjParser.ProgContext;
import com.compi.Gramatica_ANLTR4.ProjParser.SegfunctContext;
import com.compi.Gramatica_ANLTR4.ProjParser.SegvarContext;

public class Evaluador extends ProjBaseVisitor<String>{

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
    public String visitDefvar(DefvarContext ctx) {
        // TODO Auto-generated method stub
        System.out.println("Visit: Def_var");
        if (ctx.ID().equals("int")){

        }
        return super.visitDefvar(ctx);
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
    public String visitItemarith(ItemarithContext ctx) {
        // TODO Auto-generated method stub
        System.out.println("Visit: Item_arith");
        return super.visitItemarith(ctx);
    }

    @Override
    public String visitProg(ProgContext ctx) {
        // TODO Auto-generated method stub
        System.out.println("Visit: Prog");
        return super.visitProg(ctx);
    }

    @Override
    public String visitSegfunct(SegfunctContext ctx) {
        // TODO Auto-generated method stub
        System.out.println("Visit: Segfunct"); //inicia evaluacion
        return super.visitSegfunct(ctx);
    }

    @Override
    public String visitSegvar(SegvarContext ctx) {
        System.out.println("Visit: Segvar");       
        return super.visitSegvar(ctx);
    }
 private String determineVariableType(String varName) {
        if (exportProg.contains("int " + varName + " =")) {
            return "int";
        } else if (exportProg.contains("float " + varName + " =")) {
            return "float";
        } else if (exportProg.contains("String " + varName + " =")) {
            return "String";
        } else if (exportProg.contains("boolean " + varName + " =")) {
            return "boolean";
        }
        
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

 // Desde acá - JL20250521
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
}
