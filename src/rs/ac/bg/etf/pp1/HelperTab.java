package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class HelperTab {
	
	static Struct boolType = new Struct(1005);
	
	public static void initialize() {
		Tab.init();
		String name = "bool";
		Tab.insert(Obj.Type, name, HelperTab.boolType);
	}
	
}
