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

    @Override
    public String visitBody_program(Body_programContext ctx) {
        System.out.println("Visit: Body_program");
        
        exportProg += "\n" + indent() + "public static void main(String[] args) {\n";
        indentLevel++;
        
        return visitChildren(ctx);
    }

    @Override
    public String visitBodyfunct(BodyfunctContext ctx) {
        // TODO Auto-generated method stub
        System.out.println("Visit: Bodyfunct");
        return super.visitBodyfunct(ctx);
    }

    @Override
    public String visitBodysegE(BodysegEContext ctx) {
        // TODO Auto-generated method stub
        System.out.println("Visit: BodysegE");
        return super.visitBodysegE(ctx);
    }

    @Override
    public String visitBodysegE2(BodysegE2Context ctx) {
        System.out.println("Visit: BodysegE2");
        // TODO Auto-generated method stub
        return super.visitBodysegE2(ctx);
    }

    @Override
    public String visitBodysegT(BodysegTContext ctx) {
        // TODO Auto-generated method stub
        System.out.println("Visit: BodysegT");
        return super.visitBodysegT(ctx);
    }

    @Override
    public String visitBodysegT2(BodysegT2Context ctx) {
        // TODO Auto-generated method stub
        System.out.println("Visit: BodysegT2");
        return super.visitBodysegT2(ctx);
    }

    @Override
    public String visitCall_funct(Call_functContext ctx) {
        // TODO Auto-generated method stub
        System.out.println("Visit: Call_funct");
        return super.visitCall_funct(ctx);
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
        return op; // Default fallback
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
                content = "\"\""; // Empty string as fallback
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
    public String visitDefarith(DefarithContext ctx) {
        // TODO Auto-generated method stub
        System.out.println("Visit: Def_arith");
        return super.visitDefarith(ctx);
    }

    @Override
    public String visitDeffunct(DeffunctContext ctx) {
        // TODO Auto-generated method stub
        System.out.println("Visit: Def_funct");
        return super.visitDeffunct(ctx);
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
    
}
