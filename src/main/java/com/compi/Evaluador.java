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

public class Evaluador extends ProjBaseVisitor<Integer>{

    @Override
    public Integer visitBody_program(Body_programContext ctx) {
        // TODO Auto-generated method stub
        System.out.println("visited: Body_program");
        return super.visitBody_program(ctx);
        
    }

    @Override
    public Integer visitBodyfunct(BodyfunctContext ctx) {
        // TODO Auto-generated method stub
        return super.visitBodyfunct(ctx);
    }

    @Override
    public Integer visitBodysegE(BodysegEContext ctx) {
        // TODO Auto-generated method stub
        return super.visitBodysegE(ctx);
    }

    @Override
    public Integer visitBodysegE2(BodysegE2Context ctx) {
        // TODO Auto-generated method stub
        return super.visitBodysegE2(ctx);
    }

    @Override
    public Integer visitBodysegT(BodysegTContext ctx) {
        // TODO Auto-generated method stub
        return super.visitBodysegT(ctx);
    }

    @Override
    public Integer visitBodysegT2(BodysegT2Context ctx) {
        // TODO Auto-generated method stub
        return super.visitBodysegT2(ctx);
    }

    @Override
    public Integer visitCall_funct(Call_functContext ctx) {
        // TODO Auto-generated method stub
        return super.visitCall_funct(ctx);
    }

    @Override
    public Integer visitDef_cond(Def_condContext ctx) {
        // TODO Auto-generated method stub
        return super.visitDef_cond(ctx);
    }

    @Override
    public Integer visitDef_exp(Def_expContext ctx) {
        // TODO Auto-generated method stub
        return super.visitDef_exp(ctx);
    }

    @Override
    public Integer visitDef_w(Def_wContext ctx) {
        // TODO Auto-generated method stub
        return super.visitDef_w(ctx);
    }

    @Override
    public Integer visitDef_while(Def_whileContext ctx) {
        // TODO Auto-generated method stub
        return super.visitDef_while(ctx);
    }

    @Override
    public Integer visitDefarith(DefarithContext ctx) {
        // TODO Auto-generated method stub
        return super.visitDefarith(ctx);
    }

    @Override
    public Integer visitDeffunct(DeffunctContext ctx) {
        // TODO Auto-generated method stub
        return super.visitDeffunct(ctx);
    }

    @Override
    public Integer visitDefvar(DefvarContext ctx) {
        // TODO Auto-generated method stub
        return super.visitDefvar(ctx);
    }

    @Override
    public Integer visitElse_cond(Else_condContext ctx) {
        // TODO Auto-generated method stub
        return super.visitElse_cond(ctx);
    }

    @Override
    public Integer visitItemarith(ItemarithContext ctx) {
        // TODO Auto-generated method stub
        return super.visitItemarith(ctx);
    }

    @Override
    public Integer visitProg(ProgContext ctx) {
        // TODO Auto-generated method stub
        return super.visitProg(ctx);
    }

    @Override
    public Integer visitSegfunct(SegfunctContext ctx) {
        // TODO Auto-generated method stub
        return super.visitSegfunct(ctx);
    }

    @Override
    public Integer visitSegvar(SegvarContext ctx) {
        // TODO Auto-generated method stub
        return super.visitSegvar(ctx);
    }
    
}
