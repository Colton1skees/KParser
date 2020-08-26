// Generated from KG.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KGParser}.
 */
public interface KGListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KGParser#lit_rh}.
	 * @param ctx the parse tree
	 */
	void enterLit_rh(KGParser.Lit_rhContext ctx);
	/**
	 * Exit a parse tree produced by {@link KGParser#lit_rh}.
	 * @param ctx the parse tree
	 */
	void exitLit_rh(KGParser.Lit_rhContext ctx);
	/**
	 * Enter a parse tree produced by {@link KGParser#lit_r8}.
	 * @param ctx the parse tree
	 */
	void enterLit_r8(KGParser.Lit_r8Context ctx);
	/**
	 * Exit a parse tree produced by {@link KGParser#lit_r8}.
	 * @param ctx the parse tree
	 */
	void exitLit_r8(KGParser.Lit_r8Context ctx);
	/**
	 * Enter a parse tree produced by {@link KGParser#lit_r16}.
	 * @param ctx the parse tree
	 */
	void enterLit_r16(KGParser.Lit_r16Context ctx);
	/**
	 * Exit a parse tree produced by {@link KGParser#lit_r16}.
	 * @param ctx the parse tree
	 */
	void exitLit_r16(KGParser.Lit_r16Context ctx);
	/**
	 * Enter a parse tree produced by {@link KGParser#lit_r32}.
	 * @param ctx the parse tree
	 */
	void enterLit_r32(KGParser.Lit_r32Context ctx);
	/**
	 * Exit a parse tree produced by {@link KGParser#lit_r32}.
	 * @param ctx the parse tree
	 */
	void exitLit_r32(KGParser.Lit_r32Context ctx);
	/**
	 * Enter a parse tree produced by {@link KGParser#lit_r64}.
	 * @param ctx the parse tree
	 */
	void enterLit_r64(KGParser.Lit_r64Context ctx);
	/**
	 * Exit a parse tree produced by {@link KGParser#lit_r64}.
	 * @param ctx the parse tree
	 */
	void exitLit_r64(KGParser.Lit_r64Context ctx);
	/**
	 * Enter a parse tree produced by {@link KGParser#lit_sreg}.
	 * @param ctx the parse tree
	 */
	void enterLit_sreg(KGParser.Lit_sregContext ctx);
	/**
	 * Exit a parse tree produced by {@link KGParser#lit_sreg}.
	 * @param ctx the parse tree
	 */
	void exitLit_sreg(KGParser.Lit_sregContext ctx);
	/**
	 * Enter a parse tree produced by {@link KGParser#lit_st}.
	 * @param ctx the parse tree
	 */
	void enterLit_st(KGParser.Lit_stContext ctx);
	/**
	 * Exit a parse tree produced by {@link KGParser#lit_st}.
	 * @param ctx the parse tree
	 */
	void exitLit_st(KGParser.Lit_stContext ctx);
	/**
	 * Enter a parse tree produced by {@link KGParser#lit_xmm}.
	 * @param ctx the parse tree
	 */
	void enterLit_xmm(KGParser.Lit_xmmContext ctx);
	/**
	 * Exit a parse tree produced by {@link KGParser#lit_xmm}.
	 * @param ctx the parse tree
	 */
	void exitLit_xmm(KGParser.Lit_xmmContext ctx);
	/**
	 * Enter a parse tree produced by {@link KGParser#lit_mm}.
	 * @param ctx the parse tree
	 */
	void enterLit_mm(KGParser.Lit_mmContext ctx);
	/**
	 * Exit a parse tree produced by {@link KGParser#lit_mm}.
	 * @param ctx the parse tree
	 */
	void exitLit_mm(KGParser.Lit_mmContext ctx);
	/**
	 * Enter a parse tree produced by {@link KGParser#lit_ymm}.
	 * @param ctx the parse tree
	 */
	void enterLit_ymm(KGParser.Lit_ymmContext ctx);
	/**
	 * Exit a parse tree produced by {@link KGParser#lit_ymm}.
	 * @param ctx the parse tree
	 */
	void exitLit_ymm(KGParser.Lit_ymmContext ctx);
	/**
	 * Enter a parse tree produced by {@link KGParser#lit_reg}.
	 * @param ctx the parse tree
	 */
	void enterLit_reg(KGParser.Lit_regContext ctx);
	/**
	 * Exit a parse tree produced by {@link KGParser#lit_reg}.
	 * @param ctx the parse tree
	 */
	void exitLit_reg(KGParser.Lit_regContext ctx);
	/**
	 * Enter a parse tree produced by {@link KGParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(KGParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link KGParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(KGParser.OperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link KGParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(KGParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KGParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(KGParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KGParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(KGParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link KGParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(KGParser.FunctionCallContext ctx);
}