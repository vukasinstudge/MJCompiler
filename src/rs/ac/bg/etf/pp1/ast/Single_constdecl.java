// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class Single_constdecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private Val_constdecl Val_constdecl;

    public Single_constdecl (String I1, Val_constdecl Val_constdecl) {
        this.I1=I1;
        this.Val_constdecl=Val_constdecl;
        if(Val_constdecl!=null) Val_constdecl.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public Val_constdecl getVal_constdecl() {
        return Val_constdecl;
    }

    public void setVal_constdecl(Val_constdecl Val_constdecl) {
        this.Val_constdecl=Val_constdecl;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Val_constdecl!=null) Val_constdecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Val_constdecl!=null) Val_constdecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Val_constdecl!=null) Val_constdecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Single_constdecl(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(Val_constdecl!=null)
            buffer.append(Val_constdecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Single_constdecl]");
        return buffer.toString();
    }
}
