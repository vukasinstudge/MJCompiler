package rs.ac.bg.etf.pp1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;

public class Compiler {
	
	public static void main(String args[]) throws Exception {
		
		if (args.length < 2) {
	         System.out.println("Enter arguments: <source> <obj>");
	         return;
	     }

	     File sourceFile = new File(args[0]);
	     if (!sourceFile.exists()) {
	         System.out.println("Source file not found");
	         return;
	     }

	     System.out.println("Compiling source file: " + sourceFile.getAbsolutePath());

	     FileReader r = new FileReader(sourceFile);
	     Yylex scanner = new Yylex(r);
	     MJParser p = new MJParser(scanner);
	     Symbol sym = p.parse();
	     
	     if (!p.fatalErrorDetected) {
	    	 
	    	 Program prog = (Program)(sym.value);
	    	 
	    	 HelperTab.initialize();
	    	 
	    	 SemanticAnalyzer s = new SemanticAnalyzer();
	    	 prog.traverseBottomUp(s);
	    	 
	    	 if (!p.errorDetected && s.passed()) {
	    		 
	    		 Tab.dump();
	    		 
	    		 Code.dataSize = s.nVars;
	    		 CodeGenerator c = new CodeGenerator();
	    		 prog.traverseBottomUp(c);
	    		 Code.mainPc = c.getMainPc();
	    		 
	    		 if (!Code.greska) {
	    			 File objFile = new File(args[1]);
	    			 if (objFile.exists())
	    				 objFile.delete();
	    			 
	    			 System.out.println("Generating bytecode file: " + objFile.getAbsolutePath());
	    			 Code.write(new FileOutputStream(objFile));
	    			 System.out.println("Compilation successful!");
	    		 } else {
	    			 System.out.println("Problems in code generation!");
	    		 }
	    		 
	    	 } else {
	    		 System.out.println("Problems in parsing");
	    	 }
	    	 
	     }
	}

}
