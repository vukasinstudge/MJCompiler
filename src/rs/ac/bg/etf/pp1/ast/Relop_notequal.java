// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class Relop_notequal extends Relop {

    public Relop_notequal () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Relop_notequal(\n");

        buffer.append(tab);
        buffer.append(") [Relop_notequal]");
        return buffer.toString();
    }
}
