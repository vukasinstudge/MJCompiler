// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class VarDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private TypePart TypePart;
    private More_vardecl More_vardecl;

    public VarDecl (TypePart TypePart, More_vardecl More_vardecl) {
        this.TypePart=TypePart;
        if(TypePart!=null) TypePart.setParent(this);
        this.More_vardecl=More_vardecl;
        if(More_vardecl!=null) More_vardecl.setParent(this);
    }

    public TypePart getTypePart() {
        return TypePart;
    }

    public void setTypePart(TypePart TypePart) {
        this.TypePart=TypePart;
    }

    public More_vardecl getMore_vardecl() {
        return More_vardecl;
    }

    public void setMore_vardecl(More_vardecl More_vardecl) {
        this.More_vardecl=More_vardecl;
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
        if(TypePart!=null) TypePart.accept(visitor);
        if(More_vardecl!=null) More_vardecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypePart!=null) TypePart.traverseTopDown(visitor);
        if(More_vardecl!=null) More_vardecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypePart!=null) TypePart.traverseBottomUp(visitor);
        if(More_vardecl!=null) More_vardecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDecl(\n");

        if(TypePart!=null)
            buffer.append(TypePart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(More_vardecl!=null)
            buffer.append(More_vardecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDecl]");
        return buffer.toString();
    }
}
