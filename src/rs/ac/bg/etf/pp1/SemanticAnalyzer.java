package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticAnalyzer extends VisitorAdaptor {
	
	private Obj currentTypeObj = Tab.noObj;
	private Obj currentMethod = Tab.noObj;
	
	Logger log = Logger.getLogger(getClass());
	
	public int nVars;
	
	private boolean mainFound = false;
	private boolean returnFound = false;
	private boolean errorDetected = false;
	
	private Stack<ArrayList<Struct>> stack;
	
	private ArrayList<Obj> formParsCurr = null;
	
	private int depth = 0;
	
	public SemanticAnalyzer() {
		super();
		stack = new Stack<>();
	}
	
	public boolean passed() {
		if (!mainFound) {
			report_info("\nNije pronadjen main!");
		}
		return mainFound && !errorDetected;
	}

	public void report_info(String message) {
		System.out.println(message);
	}
	
	public void report_error(String message) {
		errorDetected = true;
		System.out.println(message);
	}
	
	public void varInsert(String name, Struct type, int line) {
		if (Tab.currentScope.findSymbol(name) == null) {
			Obj newObj = Tab.insert(Obj.Var, name, type);
			if (newObj.getType().getKind() == Struct.Array) {
				if (newObj.getLevel() == 0) report_info("Deklarisan globalni niz '" + name + "' na liniji " + line);
				else report_info("Deklarisan lokalni niz '" + name + "' na liniji " + line + " za funkciju '" + currentMethod.getName() + "'");
			} else {
				if (newObj.getLevel() == 0) report_info("Deklarisana globalna promenljiva '" + name + "' na liniji " + line);
				else report_info("Deklarisana lokalna promenljiva '" + name + "' na liniji " + line + " za funkciju '" + currentMethod.getName() + "'");
			}
		} else {
			report_error("Linija: " + line + " [" + name + "] vec deklarisano!");
		}
	}
	
	public void visit(Program_empty program) {
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
	}
	
	public void visit(Program_declsempty program) {
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
	}
	
	public void visit(Program_methods program) {
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
	}
	
	public void visit(Program_declsmethods program) {
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
	}
	
	public void visit (ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getI1(), Tab.noType);
		Tab.openScope();
	}
	
	public void visit(ConstDecl constDecl) {
		currentTypeObj = Tab.noObj;
	}
	
	public void visit(Single_constdecl single_constdecl) {
		Obj valObj = single_constdecl.getVal_constdecl().obj;
		if (!valObj.getType().equals(currentTypeObj.getType()))
			report_error("Linija " + single_constdecl.getLine() + " -> neodgovarajuci tipovi");
		else {
			if (Tab.currentScope().findSymbol(single_constdecl.getI1()) == null) {
				Obj newObj = Tab.insert(valObj.getKind(), single_constdecl.getI1(), valObj.getType());
				report_info("Deklarisana konstanta '" + single_constdecl.getI1() + "' na liniji " + single_constdecl.getLine());
				newObj.setAdr(valObj.getAdr());
			} else {
				report_error("Linija " + single_constdecl.getLine() + "[" + single_constdecl.getI1() + "] vec deklarisano!");
			} 
		}
	}
	
	public void visit(Val_constdecl_char val_constdecl_char) {
		Struct type = Tab.charType;
		int adr = val_constdecl_char.getC1();
		val_constdecl_char.obj = new Obj(Obj.Con, "", type, adr, Obj.NO_VALUE);
	}
	
	public void visit(Val_constdecl_number val_constdecl_number) {
		Struct type = Tab.intType;
		int adr = val_constdecl_number.getN1();
		val_constdecl_number.obj = new Obj(Obj.Con, "", type, adr, Obj.NO_VALUE);
	}
	
	public void visit(Val_constdecl_bool val_constdecl_bool) {
		Struct type = HelperTab.boolType;
		int adr = Boolean.valueOf(val_constdecl_bool.getB1()) ? 1 : 0;
		val_constdecl_bool.obj = new Obj(Obj.Con, "", type, adr, Obj.NO_VALUE);
	}

	public void visit(TypePart typePart) {
		currentTypeObj = typePart.getType().obj;
	}
	
	public void visit(VarDecl varDecl) {
		currentTypeObj = Tab.noObj;
	}
	
	public void visit(GlobalVarDecl globalVarDecl) {
		currentTypeObj = Tab.noObj;
	}
	
	public void visit(Single_vardecl_single single_vardecl_single) {
		varInsert(single_vardecl_single.getI1(), currentTypeObj.getType(), single_vardecl_single.getLine());
	}
	
	public void visit(Single_vardecl_brackets single_vardecl_brackets) {
		varInsert(single_vardecl_brackets.getI1(), new Struct(Struct.Array, currentTypeObj.getType()), single_vardecl_brackets.getLine());
	}
	
	/* MethodDecl ::= (MethodDecl_empty) MethodType IDENT LPAREN RPAREN LBRACE RBRACE */
	public void visit(MethodDecl_empty methodDecl_empty) {
		if (!returnFound && !currentMethod.getType().equals(Tab.noType)
				&& "main".equalsIgnoreCase(currentMethod.getName()))
			report_error("Linija: " + methodDecl_empty.getLine() + "[" + currentMethod.getName() + "] nema return iskaz");
	
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		
		currentMethod = Tab.noObj;
		returnFound = false;
		formParsCurr = null;
	}
	
	public void visit(MethodDecl_varsempty methodDecl_varsempty) {
		if (!returnFound && !currentMethod.getType().equals(Tab.noType)
				&& "main".equalsIgnoreCase(currentMethod.getName()))
			report_error("Linija: " + methodDecl_varsempty.getLine() + "[" + currentMethod.getName() + "] nema return iskaz");
	
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		
		currentMethod = Tab.noObj;
		returnFound = false;
		formParsCurr = null;
	}
	
	public void visit(MethodDecl_stats methodDecl_stats) {
		if (!returnFound && !currentMethod.getType().equals(Tab.noType)
				&& "main".equalsIgnoreCase(currentMethod.getName()))
			report_error("Linija: " + methodDecl_stats.getLine() + "[" + currentMethod.getName() + "] nema return iskaz");
	
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		
		currentMethod = Tab.noObj;
		returnFound = false;
		formParsCurr = null;
	}
	
	public void visit(MethodDecl_varsstats methodDecl_varsstats) {
		if (!returnFound && !currentMethod.getType().equals(Tab.noType)
				&& "main".equalsIgnoreCase(currentMethod.getName()))
			report_error("Linija: " + methodDecl_varsstats.getLine() + "[" + currentMethod.getName() + "] nema return iskaz");
	
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		
		currentMethod = Tab.noObj;
		returnFound = false;
		formParsCurr = null;
	}
	
	public void visit(MethodUnique_empty methodUnique_empty) {
		currentMethod = Tab.noObj;
		
		Obj curr = Tab.currentScope().findSymbol(methodUnique_empty.getI2());
		if (curr != null) {
                report_error("Linija: " + methodUnique_empty.getLine() + "[" + methodUnique_empty.getI2() + "] vec deklarisano");
		} else {
			currentMethod = Tab.insert(Obj.Meth, methodUnique_empty.getI2(), methodUnique_empty.getMethodType().obj.getType());
			Tab.openScope();
			if ("main".equalsIgnoreCase(currentMethod.getName())) {
				mainFound = true;
				if (!currentMethod.getType().equals(Tab.noType)) report_error("Linija: " + methodUnique_empty.getLine() + " main nije tipa void");
                if (!formParsCurr.isEmpty()) report_error("Linija: " + methodUnique_empty.getLine() + " main ima parametre");
                
			}

            int numFormPars = 1;
            for (Obj singleFP : formParsCurr) {
            	Obj newObj = Tab.insert(singleFP.getKind(), singleFP.getName(), singleFP.getType());
            	newObj.setFpPos(numFormPars++);
            }
            
            currentMethod.setLevel(formParsCurr.size());
		}
		
		// error case
		String errorName = "errorName";
		int errorFPNUM = 1;
		
		boolean errorBool = true;
		
		if (currentMethod.equals(Tab.noObj)) {
			currentMethod = new Obj(Obj.Meth, errorName, methodUnique_empty.getMethodType().obj.getType());
			Tab.openScope();
			for (int i = 0; i < formParsCurr.size(); i++) {
				Obj newObj = Tab.insert(formParsCurr.get(i).getKind(), formParsCurr.get(i).getName(), formParsCurr.get(i).getType());
				newObj.setFpPos(errorFPNUM);
			}
			currentMethod.setLevel(formParsCurr.size());
		}
		methodUnique_empty.obj = currentMethod;
	}
	
	public void visit(MethodUnique_pars methodUnique_pars) {
		currentMethod = Tab.noObj;
		Obj curr = Tab.currentScope().findSymbol(methodUnique_pars.getI2());
		if (curr != null) {
                report_error("Linija: " + methodUnique_pars.getLine() + "[" + methodUnique_pars.getI2() + "] vec deklarisano");
		} else {
			currentMethod = Tab.insert(Obj.Meth, methodUnique_pars.getI2(), methodUnique_pars.getMethodType().obj.getType());
			Tab.openScope();
			if ("main".equalsIgnoreCase(currentMethod.getName())) {
				mainFound = true;
				if (!currentMethod.getType().equals(Tab.noType)) report_error("Linija: " + methodUnique_pars.getLine() + " main nije tipa void");
                if (!formParsCurr.isEmpty()) report_error("Linija: " + methodUnique_pars.getLine() + " main ima parametre");
                
			}

            int numFormPars = 1;
            for (Obj singleFP : formParsCurr) {
            	Obj newObj = Tab.insert(singleFP.getKind(), singleFP.getName(), singleFP.getType());
            	newObj.setFpPos(numFormPars++);
            }
            currentMethod.setLevel(formParsCurr.size());
		}
		
		// error case
		String errorName = "errorName";
		int errorFPNUM = 1;
		
		boolean errorBool = true;
		
		if (currentMethod.equals(Tab.noObj)) {
			currentMethod = new Obj(Obj.Meth, errorName, methodUnique_pars.getMethodType().obj.getType());
			Tab.openScope();
			for (int i = 0; i < formParsCurr.size(); i++) {
				Obj newObj = Tab.insert(formParsCurr.get(i).getKind(), formParsCurr.get(i).getName(), formParsCurr.get(i).getType());
				newObj.setFpPos(errorFPNUM);
			}
			currentMethod.setLevel(formParsCurr.size());
		}
		methodUnique_pars.obj = currentMethod;
	}
	
	public void visit(Type type) {
		int line = type.getLine();
		type.obj = Tab.find(type.getI1());
		if (Obj.Type != type.obj.getKind()) {
			type.obj = Tab.noObj;
            report_error("Linija: " + line + "[" + type.getI1() + "] nije tip!");
		} else if (type.obj == Tab.noObj) report_error("Linija: " + line + "[" + type.getI1() + "] tip ne postoji!");
	}
	
	public Obj findByName(String name, Collection<Obj> collection) {
		for (Obj x : collection) if (x.getName().equals(name)) return x;
		return Tab.noObj;
	}
	
	public void visit(FormPar_single formPar_single) {
		String name = formPar_single.getI2();
		Struct type = formPar_single.getType().obj.getType();
		int line = formPar_single.getLine();
		if (!findByName(name, formParsCurr).equals(Tab.noObj)) {
            report_error("Linija: " + line + "[" + name + "] vec deklarisano!");
		} else {
			Obj newObj = new Obj(Obj.Var, name, type);
			formParsCurr.add(newObj);
		}
	}
	
	public void visit(FormPar_singlebrackets formPar_singlebrackets) {
		String name = formPar_singlebrackets.getI2();
		Struct type = new Struct(Struct.Array, formPar_singlebrackets.getType().obj.getType());
		int line = formPar_singlebrackets.getLine();
		if (!findByName(name, formParsCurr).equals(Tab.noObj)) {
            report_error("Linija: " + line + "[" + name + "] vec deklarisano!");
		} else {
			Obj newObj = new Obj(Obj.Var, name, type);
			formParsCurr.add(newObj);
		}
	}
	
	public void visit(MethodType_void methodType_void) {
		formParsCurr = new ArrayList<>();
		methodType_void.obj = Tab.noObj;
	}
	
	public void visit(MethodType_type methodType_type) {
		formParsCurr = new ArrayList<>();
		methodType_type.obj = methodType_type.getType().obj;
	}
	
	public void visit(DesignatorStatement_expr designatorStatement_expr) {
		Obj designatorObject = designatorStatement_expr.getDesignator().obj;
		if (designatorObject.getKind() != Obj.Var && designatorObject.getKind() != Obj.Elem) {
			report_error("Linija: " + designatorStatement_expr.getLine() + " greska designator!");
		} else if (!designatorStatement_expr.getAssignment().struct.assignableTo(designatorObject.getType())) {
            report_error("Linija: " + designatorStatement_expr.getLine() + " greska assignableTo!");
		}
	}
	
	public void visit(Assignment_Error aerror) {
		aerror.struct = Tab.noType;
    }
	
	public void visit(Assignment_Expr aexpr) {
		aexpr.struct = aexpr.getExpr().struct;
	}
	
	public void visit(DesignatorActPars designatorActPars) {
		Obj designatorObject = designatorActPars.getDesignator().obj;
		ArrayList<Struct> actParsCurr = stack.pop();
		
		if (designatorObject.getKind() != Obj.Meth) {
			report_error("Linija: " + designatorActPars.getLine() + " nije funkcija!");
			designatorActPars.struct = Tab.noType;
		} else {
			int num = designatorObject.getLevel();
			if (num != actParsCurr.size()) {
                report_error("Linija: " + designatorActPars.getLine() + " netacan broj parametara!");
			} else {
				ArrayList<Obj> localPars = new ArrayList<>(designatorObject.getLocalSymbols());
				if (designatorObject.equals(currentMethod)) localPars = new ArrayList<>(Tab.currentScope().values());
			
				if ("len".equals(designatorObject.getName())) {
					Struct arr = actParsCurr.get(0);
					if (arr.getKind() != Struct.Array || (!arr.getElemType().equals(Tab.intType) && !arr.getElemType().equals(Tab.charType))) {
						report_error("Linija: " + designatorActPars.getLine() + "len nema tacne argumente!");
					}
				} else {
					int here = 0;
					for (int i = 0; i < num; i++) {
						Obj formPar = localPars.get(here + i);
						Struct actualType = actParsCurr.get(i);
						if (!actualType.assignableTo(formPar.getType())) {
							report_error("Linija: " + designatorActPars.getLine() + " netacni parametri poziva!");
                            break;
						}
					}
				}
			}
			report_info("Poziv funkcije '" + designatorObject.getName() + "' na liniji " + designatorActPars.getLine());
			designatorActPars.struct = designatorObject.getType();
		}
	}
	
	public void visit(ActParsOpen actParsOpen) {
		stack.push(new ArrayList<>());
	}
	
	public void visit(ActPar actPar) {
		stack.peek().add(actPar.getExpr().struct);
	}
	
	public void visit(DesignatorStatement_plusplus designatorStatement_plusplus) {
		Obj designatorObject = designatorStatement_plusplus.getDesignator().obj;
		if (designatorObject.getKind() != Obj.Var && designatorObject.getKind() != Obj.Elem) {
			report_error("Linija: " + designatorStatement_plusplus.getLine() + " mora biti promenljiva");
		} else if (!designatorObject.getType().equals(Tab.intType)) {
            report_error("Linija: " + designatorStatement_plusplus.getLine() + " mora biti int");
		}
	}
	
	public void visit(DesignatorStatement_minusminus designatorStatement_minusminus) {
		Obj designatorObject = designatorStatement_minusminus.getDesignator().obj;
		if (designatorObject.getKind() != Obj.Var && designatorObject.getKind() != Obj.Elem) {
			report_error("Linija: " + designatorStatement_minusminus.getLine() + " mora biti promenljiva");
		} else if (!designatorObject.getType().equals(Tab.intType)) {
            report_error("Linija: " + designatorStatement_minusminus.getLine() + " mora biti int");
		}
	}
	
	public void visit(Statement_break statement_break) {
		if (depth == 0) {
			report_error("Linija: " + statement_break.getLine() + " break van petlje!");
		}
	}
	
	public void visit(Statement_read statement_read) {
		if (statement_read.getDesignator().obj.getKind() != Obj.Var && statement_read.getDesignator().obj.getKind() != Obj.Elem)
			report_error("Linija: " + statement_read.getLine() + " read mora imati promenljivu!");
		else if (!statement_read.getDesignator().obj.getType().equals(Tab.intType) 
				&& !statement_read.getDesignator().obj.getType().equals(Tab.charType)
				&& !statement_read.getDesignator().obj.getType().equals(HelperTab.boolType))
			report_error("Linija: " + statement_read.getLine() + " netacan parametar za read!");
	}
	
	public void visit(Statement_print statement_print) {
		if (!statement_print.getExpr().struct.equals(Tab.intType)
				&& !statement_print.getExpr().struct.equals(Tab.charType)
				&& !statement_print.getExpr().struct.equals(HelperTab.boolType))
			report_error("Linija: " + statement_print.getLine() + " netacan parametar za print!");
	}
	
	public void visit(Statement_return statement_return) {
		if (!currentMethod.equals(Tab.noObj)) {
			if (!currentMethod.getType().equals(statement_return.getMaybeExpr().struct)) report_error("Linija: " + statement_return.getLine() + " pogresan tip return!");
			returnFound = true;	
		} else {
			report_error("Linija: " + statement_return.getLine() + " return van metode!");
		}
	}
	
	public void visit(MaybeExpr_empty maybeExpr_empty) {
		maybeExpr_empty.struct = Tab.noType;
	}
	
	public void visit(MaybeExpr_expr maybeExpr_expr) {
		maybeExpr_expr.struct = maybeExpr_expr.getExpr().struct;
	}

	public void visit(IfClose_normal ifClose_normal) {
		if (!ifClose_normal.getCondition().struct.equals(HelperTab.boolType))
			report_error("Linija: " + ifClose_normal.getLine() + " uslov mora biti boolean!");
	}
	
	public void visit(DoOpen doOpen) {
		depth++;
	}
	
	public void visit(Statement_dowhile statement_dowhile) {
		if (!statement_dowhile.getCondition().struct.equals(HelperTab.boolType))
			report_error("Linija: " + statement_dowhile.getLine() + " uslov mora biti boolean!");
		depth--;
	}
	
	public void visit(Condition_single condition_single) {
		condition_single.struct = condition_single.getCondTerm().struct;
	}
	
	public void visit(Condition_more condition_more) {
		condition_more.struct = condition_more.getCondition().struct;
	}
	
	public void visit(CondTerm_single condTerm_single) {
		condTerm_single.struct = condTerm_single.getCondFact().struct;
	}
	
	public void visit(CondTerm_more condTerm_more) {
		condTerm_more.struct = condTerm_more.getCondTerm().struct;
	}
	
	public void visit(CondFact_expr condFact_expr) {
		condFact_expr.struct = condFact_expr.getExpr().struct;
	}
	
	public void visit(CondFact_exprexpr condFact_exprexpr) {
		if (condFact_exprexpr.getExpr().struct.compatibleWith(condFact_exprexpr.getExpr1().struct)) {
			int kind1 = condFact_exprexpr.getExpr().struct.getKind();
			int kind2 = condFact_exprexpr.getExpr1().struct.getKind();
			if ((kind1 == Struct.Array || kind2 == Struct.Array) 
					&& !(condFact_exprexpr.getRelop() instanceof Relop_equalequal
							|| condFact_exprexpr.getRelop() instanceof Relop_notequal))
				report_error("Linija: " + condFact_exprexpr.getLine() + " niz se moze porediti samo sa == ili !=");
		} else {
			report_error("Linija: " + condFact_exprexpr.getLine() + " relop nisu kompatibilni!");
		}
		Struct bool = HelperTab.boolType;
		condFact_exprexpr.struct = bool;
	}
	
	public void visit(Expr1_more expr1_more) {
		if (!expr1_more.getTerm().struct.equals(Tab.intType) || !expr1_more.getExpr1().struct.equals(Tab.intType))
			report_error("Linija: " + expr1_more.getLine() + " delovi izraza moraju biti tipa int!");
		if (!expr1_more.getExpr1().struct.compatibleWith(expr1_more.getTerm().struct))
			report_error("Linija: " + expr1_more.getLine() + " delovi izraza nisu kompatibilni!");
		expr1_more.struct = expr1_more.getExpr1().struct;
	}
	
	public void visit(Expr1_minus expr1_minus) {
		if (!expr1_minus.getTerm().struct.equals(Tab.intType))
			report_error("Linija: " + expr1_minus.getLine() + " - se koristi samo za int!");
		expr1_minus.struct = expr1_minus.getTerm().struct;
	}
	
	public void visit(Expr1_single expr1_single) {
		expr1_single.struct = expr1_single.getTerm().struct;
	}
	
	public void visit(Term_more term_more) {
		if (!term_more.getTerm().struct.equals(Tab.intType))
			report_error("Linija: " + term_more.getLine() + " delovi izraza moraju biti tipa int!");
		if (!term_more.getFactor().struct.equals(Tab.intType))
			report_error("Linija: " + term_more.getLine() + " delovi izraza moraju biti tipa int!");
		term_more.struct = term_more.getTerm().struct;
	}
	
	public void visit(Term_single term_single) {
		term_single.struct = term_single.getFactor().struct;
	}
	
	public void visit(Factor_designator factor_designator) {
		if (factor_designator.getDesignator().obj.getKind() != Obj.Con
				&& factor_designator.getDesignator().obj.getKind() != Obj.Var
				&& factor_designator.getDesignator().obj.getKind() != Obj.Elem)
			report_error("Linija: " + factor_designator.getLine() + "  mora tipa promenljiva!");
		factor_designator.struct = factor_designator.getDesignator().obj.getType();
	}
	
	public void visit(Factor_designatoactpars factor_designatoactpars) {
		factor_designatoactpars.struct = factor_designatoactpars.getDesignatorActPars().struct;
	}
	
	public void visit(Factor_const factor_const) {
		factor_const.struct = factor_const.getVal_constdecl().obj.getType();
	}
	
	public void visit(Factor_newexpr factor_newexpr) {
		Struct exprStruct = factor_newexpr.getExpr().struct;
		if (!exprStruct.equals(Tab.intType))
			report_error("Linija: " + factor_newexpr.getLine() + "  izraz za new u slucaju niza mora biti tipa int!");
		factor_newexpr.struct = new Struct(Struct.Array, factor_newexpr.getType().obj.getType());
	}
	
	public void visit(Factor_exprparen factor_exprparen) {
		factor_exprparen.struct = factor_exprparen.getExpr().struct;
	}
	
	public void visit (Designator_expr designator_expr) {
		Obj designatorObject = designator_expr.getDesignator().obj;
		designator_expr.obj = Tab.noObj;
		
		if (designatorObject.getType().getKind() != Struct.Array) 
			report_error("Linija: " + designator_expr.getLine() + " designator nije niz!");
		else {
			designator_expr.obj = new Obj(Obj.Elem, designatorObject.getName() + "_elem", designatorObject.getType().getElemType());
			if (!designator_expr.getExpr().struct.equals(Tab.intType))
				report_error("Linija: " + designator_expr.getLine() + " indeks mora biti int!");
		}
		
		report_info("Pristup elementu niza '" + designatorObject.getName() + "' na liniji " + designator_expr.getLine());
		
		if (designator_expr.obj.equals(Tab.noObj))
			designator_expr.obj = new Obj(Tab.noObj.getKind(), designatorObject.getName() + "_elem", Tab.noType);
	}
	
	public void visit(Designator_single designator_single) {
		designator_single.obj = Tab.find(designator_single.getI1());
		if (designator_single.obj.equals(Tab.noObj)) {
			report_error("Linija: " + designator_single.getLine() + " designator ne postoji!");
			designator_single.obj = new Obj(Tab.noObj.getKind(), designator_single.getI1(), Tab.noType);
		}
		if (!currentMethod.equals(Tab.noObj)) {
				for (Obj formPar : formParsCurr) {
					if (designator_single.obj.getName() == formPar.getName()) 
						report_info("Koriscenje formalnog parametra '" + designator_single.obj.getName() + "' funkcije '" + currentMethod.getName() + " na liniji " + designator_single.getLine());
				}
		}
	}

	public void visit(Expr_expr1full expr_expr1full) {
		if (expr_expr1full.getExpr2().getExpr1().struct.getKind() != expr_expr1full.getExpr3().getExpr1().struct.getKind())
			report_error("Linija: " + expr_expr1full.getLine() + " drugi i treci izraz u ternarnom moraju biti istog tipa!");
		expr_expr1full.struct = expr_expr1full.getFullCond().getExpr1().struct;
	}
	
	public void visit(Expr_expr1single expr_expr1single) {
		expr_expr1single.struct = expr_expr1single.getExpr1().struct;
	}
	
}
