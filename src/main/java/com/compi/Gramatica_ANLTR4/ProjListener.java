// Generated from Proj.g4 by ANTLR 4.13.2

    package com.compi.Gramatica_ANLTR4;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ProjParser}.
 */
public interface ProjListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ProjParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ProjParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ProjParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(ProjParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(ProjParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#body_end}.
	 * @param ctx the parse tree
	 */
	void enterBody_end(ProjParser.Body_endContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#body_end}.
	 * @param ctx the parse tree
	 */
	void exitBody_end(ProjParser.Body_endContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#segvar}.
	 * @param ctx the parse tree
	 */
	void enterSegvar(ProjParser.SegvarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#segvar}.
	 * @param ctx the parse tree
	 */
	void exitSegvar(ProjParser.SegvarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#defvar}.
	 * @param ctx the parse tree
	 */
	void enterDefvar(ProjParser.DefvarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#defvar}.
	 * @param ctx the parse tree
	 */
	void exitDefvar(ProjParser.DefvarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#segfunct}.
	 * @param ctx the parse tree
	 */
	void enterSegfunct(ProjParser.SegfunctContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#segfunct}.
	 * @param ctx the parse tree
	 */
	void exitSegfunct(ProjParser.SegfunctContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#deffunct}.
	 * @param ctx the parse tree
	 */
	void enterDeffunct(ProjParser.DeffunctContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#deffunct}.
	 * @param ctx the parse tree
	 */
	void exitDeffunct(ProjParser.DeffunctContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#bodyfunct}.
	 * @param ctx the parse tree
	 */
	void enterBodyfunct(ProjParser.BodyfunctContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#bodyfunct}.
	 * @param ctx the parse tree
	 */
	void exitBodyfunct(ProjParser.BodyfunctContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#defarith}.
	 * @param ctx the parse tree
	 */
	void enterDefarith(ProjParser.DefarithContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#defarith}.
	 * @param ctx the parse tree
	 */
	void exitDefarith(ProjParser.DefarithContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#bodysegE}.
	 * @param ctx the parse tree
	 */
	void enterBodysegE(ProjParser.BodysegEContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#bodysegE}.
	 * @param ctx the parse tree
	 */
	void exitBodysegE(ProjParser.BodysegEContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#bodysegE2}.
	 * @param ctx the parse tree
	 */
	void enterBodysegE2(ProjParser.BodysegE2Context ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#bodysegE2}.
	 * @param ctx the parse tree
	 */
	void exitBodysegE2(ProjParser.BodysegE2Context ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#bodysegT}.
	 * @param ctx the parse tree
	 */
	void enterBodysegT(ProjParser.BodysegTContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#bodysegT}.
	 * @param ctx the parse tree
	 */
	void exitBodysegT(ProjParser.BodysegTContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#bodysegT2}.
	 * @param ctx the parse tree
	 */
	void enterBodysegT2(ProjParser.BodysegT2Context ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#bodysegT2}.
	 * @param ctx the parse tree
	 */
	void exitBodysegT2(ProjParser.BodysegT2Context ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#itemarith}.
	 * @param ctx the parse tree
	 */
	void enterItemarith(ProjParser.ItemarithContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#itemarith}.
	 * @param ctx the parse tree
	 */
	void exitItemarith(ProjParser.ItemarithContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#body_program}.
	 * @param ctx the parse tree
	 */
	void enterBody_program(ProjParser.Body_programContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#body_program}.
	 * @param ctx the parse tree
	 */
	void exitBody_program(ProjParser.Body_programContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(ProjParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(ProjParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#def_cond}.
	 * @param ctx the parse tree
	 */
	void enterDef_cond(ProjParser.Def_condContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#def_cond}.
	 * @param ctx the parse tree
	 */
	void exitDef_cond(ProjParser.Def_condContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#def_exp}.
	 * @param ctx the parse tree
	 */
	void enterDef_exp(ProjParser.Def_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#def_exp}.
	 * @param ctx the parse tree
	 */
	void exitDef_exp(ProjParser.Def_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#else_cond}.
	 * @param ctx the parse tree
	 */
	void enterElse_cond(ProjParser.Else_condContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#else_cond}.
	 * @param ctx the parse tree
	 */
	void exitElse_cond(ProjParser.Else_condContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#def_while}.
	 * @param ctx the parse tree
	 */
	void enterDef_while(ProjParser.Def_whileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#def_while}.
	 * @param ctx the parse tree
	 */
	void exitDef_while(ProjParser.Def_whileContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#increment_decrement}.
	 * @param ctx the parse tree
	 */
	void enterIncrement_decrement(ProjParser.Increment_decrementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#increment_decrement}.
	 * @param ctx the parse tree
	 */
	void exitIncrement_decrement(ProjParser.Increment_decrementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#def_w}.
	 * @param ctx the parse tree
	 */
	void enterDef_w(ProjParser.Def_wContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#def_w}.
	 * @param ctx the parse tree
	 */
	void exitDef_w(ProjParser.Def_wContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProjParser#call_funct}.
	 * @param ctx the parse tree
	 */
	void enterCall_funct(ProjParser.Call_functContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProjParser#call_funct}.
	 * @param ctx the parse tree
	 */
	void exitCall_funct(ProjParser.Call_functContext ctx);
}