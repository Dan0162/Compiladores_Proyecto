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
        // TODO Auto-generated method stub
        System.out.println("Visit: Body_program");
        return super.visitBody_program(ctx);
        
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
        // TODO Auto-generated method stub
        System.out.println("Visit: Def_cond");
        return super.visitDef_cond(ctx);
    }

    @Override
    public String visitDef_exp(Def_expContext ctx) {
        // TODO Auto-generated method stub
        System.out.println("Visit: Def_exp");
        return super.visitDef_exp(ctx);
    }

    @Override
    public String visitDef_w(Def_wContext ctx) {
        // TODO Auto-generated method stub
        System.out.println("Visit: Def_w");
        return super.visitDef_w(ctx);
    }

    @Override
    public String visitDef_while(Def_whileContext ctx) {
        // TODO Auto-generated method stub
        System.out.println("Visit: Def_while");
        return super.visitDef_while(ctx);
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
        // TODO Auto-generated method stub
        System.out.println("Visit: Else_cond");
        return super.visitElse_cond(ctx);
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
