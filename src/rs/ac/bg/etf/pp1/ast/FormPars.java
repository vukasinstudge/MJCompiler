// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class FormPars implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private More_formpars More_formpars;

    public FormPars (More_formpars More_formpars) {
        this.More_formpars=More_formpars;
        if(More_formpars!=null) More_formpars.setParent(this);
    }

    public More_formpars getMore_formpars() {
        return More_formpars;
    }

    public void setMore_formpars(More_formpars More_formpars) {
        this.More_formpars=More_formpars;
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
        if(More_formpars!=null) More_formpars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(More_formpars!=null) More_formpars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(More_formpars!=null) More_formpars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormPars(\n");

        if(More_formpars!=null)
            buffer.append(More_formpars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormPars]");
        return buffer.toString();
    }
}
