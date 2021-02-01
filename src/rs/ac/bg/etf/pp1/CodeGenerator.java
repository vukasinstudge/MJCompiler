package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.Stack;

import rs.ac.bg.etf.pp1.ast.Addop_minus;
import rs.ac.bg.etf.pp1.ast.Addop_plus;
import rs.ac.bg.etf.pp1.ast.AndForVisit;
import rs.ac.bg.etf.pp1.ast.CondFact_expr;
import rs.ac.bg.etf.pp1.ast.DesignatorActPars;
import rs.ac.bg.etf.pp1.ast.DesignatorStatement_actpars;
import rs.ac.bg.etf.pp1.ast.DesignatorStatement_expr;
import rs.ac.bg.etf.pp1.ast.DesignatorStatement_minusminus;
import rs.ac.bg.etf.pp1.ast.DesignatorStatement_plusplus;
import rs.ac.bg.etf.pp1.ast.Designator_expr;
import rs.ac.bg.etf.pp1.ast.DoOpen;
import rs.ac.bg.etf.pp1.ast.ElseOpen;
import rs.ac.bg.etf.pp1.ast.Expr1_minus;
import rs.ac.bg.etf.pp1.ast.Expr1_more;
import rs.ac.bg.etf.pp1.ast.Expr2;
import rs.ac.bg.etf.pp1.ast.Expr3;
import rs.ac.bg.etf.pp1.ast.Expr_expr1full;
import rs.ac.bg.etf.pp1.ast.Factor_const;
import rs.ac.bg.etf.pp1.ast.Factor_designator;
import rs.ac.bg.etf.pp1.ast.Factor_newexpr;
import rs.ac.bg.etf.pp1.ast.FullCond;
import rs.ac.bg.etf.pp1.ast.IfClose;
import rs.ac.bg.etf.pp1.ast.IfClose_normal;
import rs.ac.bg.etf.pp1.ast.IfOpen;
import rs.ac.bg.etf.pp1.ast.MaybeElse_else;
import rs.ac.bg.etf.pp1.ast.MaybeElse_empty;
import rs.ac.bg.etf.pp1.ast.MethodDecl_empty;
import rs.ac.bg.etf.pp1.ast.MethodDecl_stats;
import rs.ac.bg.etf.pp1.ast.MethodDecl_varsempty;
import rs.ac.bg.etf.pp1.ast.MethodDecl_varsstats;
import rs.ac.bg.etf.pp1.ast.MethodUnique_empty;
import rs.ac.bg.etf.pp1.ast.MethodUnique_pars;
import rs.ac.bg.etf.pp1.ast.Mulop_percent;
import rs.ac.bg.etf.pp1.ast.Mulop_slash;
import rs.ac.bg.etf.pp1.ast.Mulop_times;
import rs.ac.bg.etf.pp1.ast.OpenExpr;
import rs.ac.bg.etf.pp1.ast.OrForVisit;
import rs.ac.bg.etf.pp1.ast.Relop_equalequal;
import rs.ac.bg.etf.pp1.ast.Relop_higher;
import rs.ac.bg.etf.pp1.ast.Relop_higherequal;
import rs.ac.bg.etf.pp1.ast.Relop_lower;
import rs.ac.bg.etf.pp1.ast.Relop_lowerequal;
import rs.ac.bg.etf.pp1.ast.Relop_notequal;
import rs.ac.bg.etf.pp1.ast.Statement_break;
import rs.ac.bg.etf.pp1.ast.Statement_continue;
import rs.ac.bg.etf.pp1.ast.Statement_dowhile;
import rs.ac.bg.etf.pp1.ast.Statement_if;
import rs.ac.bg.etf.pp1.ast.Statement_print;
import rs.ac.bg.etf.pp1.ast.Statement_printnumconst;
import rs.ac.bg.etf.pp1.ast.Statement_read;
import rs.ac.bg.etf.pp1.ast.Statement_return;
import rs.ac.bg.etf.pp1.ast.Term_more;
import rs.ac.bg.etf.pp1.ast.Val_constdecl_char;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.ac.bg.etf.pp1.ast.WhileOpen;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;

public class CodeGenerator extends VisitorAdaptor {
	
	private int mainPc;
	
	private ArrayList<Stack<ArrayList<Integer>>> stacksList;
	private ArrayList<Stack<Integer>> stacksInteger;
	private ArrayList<Integer> trueArray;
	
	private static final int FALSE = 0;
	private static final int BREAK = 1;
	private static final int CONT = 2;
	
	private static final int RELOP = 0;
	private static final int ADDOP = 1;
	private static final int MULOP = 2;
	private static final int SKIPELSE = 3;
	private static final int DOWHILE = 4;
	
	int ternaryHelper[];
	
	int oneValue = 1;
	
	CodeGenerator() {
		super();
		
		ternaryHelper = new int[2];
		
		stacksList = new ArrayList<>();
		//FALSE
		//BREAK
		//CONT
		stacksList.add(new Stack<>());
		stacksList.add(new Stack<>());
		stacksList.add(new Stack<>());
		
		stacksInteger = new ArrayList<>();
		//RELOP
		//ADDOP
		//MULOP
		//SKIPELSE
		//DOWHILE
		stacksInteger.add(new Stack<>());
		stacksInteger.add(new Stack<>());
		stacksInteger.add(new Stack<>());
		stacksInteger.add(new Stack<>());
		stacksInteger.add(new Stack<>());
		
		trueArray = new ArrayList<>();
		
		if (initOrdAndChr() == 1) initLen();
		
	}
	
	private int initOrdAndChr() {
		int ret = 1;
		Obj ordObj = Tab.find("ord");
		ordObj.setAdr(Code.pc);
		Obj chrObj = Tab.find("chr");
		chrObj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(1);
		Code.put(1);
		Code.put(Code.load_n);
		Code.put(Code.exit);
		Code.put(Code.return_);
		return ret;
	}
	
	private int initLen() {
		int ret = 1;
		Obj lenObj = Tab.find("len");
		lenObj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(1);
		Code.put(1);
		Code.put(Code.load_n);
		Code.put(Code.arraylength);
		Code.put(Code.exit);
		Code.put(Code.return_);
		return ret;
	}
	
	public int getMainPc() {
		return mainPc;
	}
	
	public void visit(MethodDecl_empty methodDecl_empty) {
		int one = 1;
		int codeTrap = Code.trap;
		int codeReturn = Code.return_;
		int codeExit = Code.exit;
		if (!methodDecl_empty.getMethodUnique().obj.getType().equals(Tab.noType)) {
			Code.put(codeTrap);
			Code.put(one);
		} else {
			Code.put(codeExit);
			Code.put(codeReturn);
		}
	}
	
	public void visit(MethodDecl_varsempty methodDecl_varsempty) {
		int one = 1;
		int codeTrap = Code.trap;
		int codeReturn = Code.return_;
		int codeExit = Code.exit;
		if (!methodDecl_varsempty.getMethodUnique().obj.getType().equals(Tab.noType)) {
			Code.put(codeTrap);
			Code.put(one);
		} else {
			Code.put(codeExit);
			Code.put(codeReturn);
		}
	}
	
	public void visit(MethodDecl_stats methodDecl_stats) {
		int one = 1;
		int codeTrap = Code.trap;
		int codeReturn = Code.return_;
		int codeExit = Code.exit;
		if (!methodDecl_stats.getMethodUnique().obj.getType().equals(Tab.noType)) {
			Code.put(codeTrap);
			Code.put(one);
		} else {
			Code.put(codeExit);
			Code.put(codeReturn);
		}
	}
	
	public void visit(MethodDecl_varsstats methodDecl_varsstats) {
		int one = 1;
		int codeTrap = Code.trap;
		int codeReturn = Code.return_;
		int codeExit = Code.exit;
		if (!methodDecl_varsstats.getMethodUnique().obj.getType().equals(Tab.noType)) {
			Code.put(codeTrap);
			Code.put(one);
		} else {
			Code.put(codeExit);
			Code.put(codeReturn);
		}
	}
	
	public void visit(MethodUnique_empty methodUnique_empty) {
		int codeEnter = Code.enter;
		methodUnique_empty.obj.setAdr(Code.pc);
		String mainString = "main";
		if (mainString.equalsIgnoreCase(methodUnique_empty.obj.getName())) mainPc = Code.pc;
		Code.put(codeEnter);
		Code.put(methodUnique_empty.obj.getLevel());
		Code.put(methodUnique_empty.obj.getLocalSymbols().size());;
	}
	
	public void visit(MethodUnique_pars methodUnique_pars) {
		int codePc = Code.pc;
		int codeEnter = Code.enter;
		methodUnique_pars.obj.setAdr(codePc);
		String mainString = "main";
		if (mainString.equalsIgnoreCase(methodUnique_pars.obj.getName())) mainPc = codePc;
		Code.put(codeEnter);
		Code.put(methodUnique_pars.obj.getLevel());
		Code.put(methodUnique_pars.obj.getLocalSymbols().size());;
	}
	
	public void visit(OpenExpr openExpr) {
		Code.load(((Designator_expr) openExpr.getParent()).getDesignator().obj);
	}
	
	public void visit(DesignatorStatement_plusplus designatorStatement_plusplus) {
		Obj currObj = designatorStatement_plusplus.getDesignator().obj;
		if (designatorStatement_plusplus.getDesignator() instanceof Designator_expr) {
			Code.put(Code.dup2);
		}
		Code.load(currObj);
		Code.loadConst(oneValue);
		Code.put(Code.add);
		Code.store(currObj);
	}
	
	public void visit(DesignatorStatement_minusminus designatorStatement_minusminus) {
		Obj currObj = designatorStatement_minusminus.getDesignator().obj;
		if (designatorStatement_minusminus.getDesignator() instanceof Designator_expr) {
			Code.put(Code.dup2);
		}
		Code.load(currObj);
		Code.loadConst(oneValue);
		Code.put(Code.sub);
		Code.store(currObj);
	}
	
	public void visit(DesignatorStatement_expr designatorStatement_expr) {
		Code.store(designatorStatement_expr.getDesignator().obj);
	}
	
	public void visit(DesignatorStatement_actpars designatorStatement_actpars) {
		boolean voidBool = designatorStatement_actpars.getDesignatorActPars().struct.equals(Tab.noType);
		if (!voidBool) Code.put(Code.pop);
	}
	
	public void visit(Statement_return statement_return) {
		int codeExit = Code.exit;
		int codeReturn = Code.return_;
		Code.put(codeExit); Code.put(codeReturn);
	}
	
	public void visit(Statement_printnumconst statement_printnumconst) {
		int codePrint = Code.print;
		int codeBytePrint = Code.bprint;
		Code.loadConst(statement_printnumconst.getN2());
		if (!statement_printnumconst.getExpr().struct.equals(Tab.charType)) Code.put(codePrint);
		else Code.put(codeBytePrint);
	}
	
	public void visit(Statement_print statement_print) {
		int codePrint = Code.print;
		int codeBytePrint = Code.bprint;
		boolean isChar = false;
		if (statement_print.getExpr() instanceof Expr_expr1full) {
			isChar = ((Expr_expr1full) statement_print.getExpr()).getExpr2().getExpr1().struct.equals(Tab.charType);
		}
		if (!statement_print.getExpr().struct.equals(Tab.charType) && !isChar) {
			int code5 = Code.const_5;
			Code.put(code5);
			Code.put(codePrint);
		} else {
			int code1 = Code.const_1;
			Code.put(code1);
			Code.put(codeBytePrint);
		}
	}
	
	public void visit(Statement_read statement_read) {
		int codeByteRead = Code.bread;
		int codeRead = Code.read;
		if (!statement_read.getDesignator().obj.getType().equals(Tab.charType)) Code.put(codeRead);
		else Code.put(codeByteRead);
		Code.store(statement_read.getDesignator().obj);
	}
	
	public void visit(Statement_break statement_break) {
		Code.putJump(0);
		stacksList.get(BREAK).peek().add(Code.pc - 2);
	}
	
	public void visit(Statement_continue statement_continue) {
		Code.putJump(0);
		stacksList.get(CONT).peek().add(Code.pc - 2);
	}
	
	public void visit(DoOpen doOpen) {
		stacksList.get(CONT).push(new ArrayList<>());
		stacksList.get(BREAK).push(new ArrayList<>());
		stacksInteger.get(DOWHILE).push(Code.pc);
	}
	
	public void visit(WhileOpen whileOpen) {
		stacksList.get(FALSE).push(new ArrayList<>());
		for (int i = 0; i < stacksList.get(CONT).peek().size(); i++) Code.fixup(stacksList.get(CONT).peek().get(i));
	}

	public void visit(Statement_dowhile statement_dowhile) {
		int top = stacksInteger.get(DOWHILE).pop();
		Code.put(Code.jcc + stacksInteger.get(RELOP).pop());
        Code.put2(top - Code.pc + 1);
		
		for (int i = 0; i < stacksList.get(FALSE).peek().size(); i++) Code.fixup(stacksList.get(FALSE).peek().get(i));
		for (int i = 0; i < trueArray.size(); i++) Code.put2(trueArray.get(i), (top - trueArray.get(i) + 1));
		trueArray.clear();
		for (int i = 0; i < stacksList.get(BREAK).peek().size(); i++) Code.fixup( stacksList.get(BREAK).peek().get(i));
		stacksList.get(BREAK).pop();
		stacksList.get(CONT).pop();
		stacksList.get(FALSE).pop();
	}
	
	public void visit(Statement_if statement_if) {
		stacksList.get(FALSE).pop();
	}
	
	public void visit(IfOpen ifOpen) {
		stacksList.get(FALSE).add(new ArrayList<>());
	}
	
	public void visit(IfClose_normal ifClose_normal) {
		Code.putFalseJump(stacksInteger.get(RELOP).pop(), 0);
		stacksList.get(FALSE).peek().add(Code.pc - 2);
		for (int i = 0; i < trueArray.size(); i++) Code.fixup(trueArray.get(i));
		trueArray.clear();
	}
	
	public void visit(ElseOpen elseOpen) {
		Code.putJump(0);
		stacksInteger.get(SKIPELSE).add(Code.pc - 2);
		for (int i = 0; i < stacksList.get(FALSE).peek().size(); i++) Code.fixup(stacksList.get(FALSE).peek().get(i));
	}
	
	public void visit(MaybeElse_empty maybeElse_empty) {
		for (int i = 0; i < stacksList.get(FALSE).peek().size(); i++) Code.fixup(stacksList.get(FALSE).peek().get(i));
	}
	
	public void visit(MaybeElse_else maybeElse_else) {
		Code.fixup(stacksInteger.get(SKIPELSE).pop());
	}
	
	public void visit(DesignatorActPars designatorActPars) {
		Code.put(Code.call);
		Code.put2(designatorActPars.getDesignator().obj.getAdr() - Code.pc + 1);
	}
	
	public void visit(AndForVisit andForVisit) {
		int zeroValue = 0;
		Code.putFalseJump(stacksInteger.get(RELOP).pop(), zeroValue);
		stacksList.get(FALSE).peek().add(Code.pc - 2);
	}
	
	public void visit(OrForVisit orForVisit) {
		int value = stacksInteger.get(RELOP).pop() + Code.jcc;
		Code.put(value); Code.put2(0);
		trueArray.add(Code.pc - 2);
		for (int i = 0; i < stacksList.get(FALSE).peek().size(); i++) Code.fixup(stacksList.get(FALSE).peek().get(i));
	}

	public void visit(Expr1_more expr1_more) {
		Code.put(stacksInteger.get(ADDOP).pop());
	}
	
	public void visit(Expr1_minus expr1_minus) {
		Code.put(Code.neg);
	}
	
	public void visit(Term_more term_more) {
		Code.put(stacksInteger.get(MULOP).pop());
	}
	
	public void visit(Factor_designator factor_designator) {
		Obj designatorObject = factor_designator.getDesignator().obj;
		Code.load(designatorObject);
	}
	
	public void visit(Factor_const factor_const) {
		Obj valObject = factor_const.getVal_constdecl().obj;
		Code.load(valObject);
	}
	
	public void visit(CondFact_expr condFact_expr) {
		int zeroValue = 0;
		Code.loadConst(zeroValue);
		stacksInteger.get(RELOP).push(Code.ne);
	}
	
	public void visit(Factor_newexpr factor_newexpr) {
		Code.put(Code.newarray);
		int num;
		if (factor_newexpr.struct.getElemType().equals(Tab.charType)) num = 0;
		else num = 1;
		Code.put(num);
	}
	
	public void visit(Expr3 expr3) {
		Code.fixup(ternaryHelper[1]);
	}
	 
	public void visit(Expr2 expr2) {
		int emptyJump = 0;
		Code.putJump(emptyJump);
		ternaryHelper[1] = Code.pc - 2;
		Code.fixup(ternaryHelper[0]);
	}
	
	public void visit(FullCond fullCond) {
		int equalJump = Code.eq;
		Code.loadConst(1);
		Code.putFalseJump(equalJump, 0);
		ternaryHelper[0] = Code.pc - 2;
	}
	
	public void visit(Addop_plus addop_plus) {
		stacksInteger.get(ADDOP).push(Code.add);
	}
	
	public void visit(Addop_minus addop_minus) {
		stacksInteger.get(ADDOP).push(Code.sub);
	}
	
	public void visit(Relop_higher relop_higher) {
		stacksInteger.get(RELOP).push(Code.gt);
	}
	
	public void visit(Relop_higherequal relop_higherequal) {
		stacksInteger.get(RELOP).push(Code.ge);
	}
	
	public void visit(Relop_lower relop_lower) {
		stacksInteger.get(RELOP).push(Code.lt);
	}
	
	public void visit(Relop_lowerequal relop_lowerequal) {
		stacksInteger.get(RELOP).push(Code.le);
	}
	
	public void visit(Relop_equalequal relop_equalequal) {
		stacksInteger.get(RELOP).push(Code.eq);
	}
	
	public void visit(Relop_notequal relop_notequal) {
		stacksInteger.get(RELOP).push(Code.ne);
	}
	
	public void visit(Mulop_times mulop_times) {
		stacksInteger.get(MULOP).push(Code.mul);
	}
	
	public void visit(Mulop_slash mulop_slash) {
		stacksInteger.get(MULOP).push(Code.div);
	}
	
	public void visit(Mulop_percent mulop_percent) {
		stacksInteger.get(MULOP).push(Code.rem);
	}
}
