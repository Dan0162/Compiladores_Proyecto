// Generated from Proj.g4 by ANTLR 4.13.2

    package com.compi.Gramatica_ANLTR4;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ProjParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ProjVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ProjParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ProjParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(ProjParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#body_end}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody_end(ProjParser.Body_endContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#segvar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSegvar(ProjParser.SegvarContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#defvar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefvar(ProjParser.DefvarContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#segfunct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSegfunct(ProjParser.SegfunctContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#deffunct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeffunct(ProjParser.DeffunctContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#bodyfunct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyfunct(ProjParser.BodyfunctContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#defarith}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefarith(ProjParser.DefarithContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#bodysegE}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodysegE(ProjParser.BodysegEContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#bodysegE2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodysegE2(ProjParser.BodysegE2Context ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#bodysegT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodysegT(ProjParser.BodysegTContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#bodysegT2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodysegT2(ProjParser.BodysegT2Context ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#itemarith}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItemarith(ProjParser.ItemarithContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#body_program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody_program(ProjParser.Body_programContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(ProjParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#def_cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef_cond(ProjParser.Def_condContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#def_exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef_exp(ProjParser.Def_expContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#else_cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_cond(ProjParser.Else_condContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#def_while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef_while(ProjParser.Def_whileContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#increment_decrement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrement_decrement(ProjParser.Increment_decrementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#def_w}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef_w(ProjParser.Def_wContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProjParser#call_funct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall_funct(ProjParser.Call_functContext ctx);
}