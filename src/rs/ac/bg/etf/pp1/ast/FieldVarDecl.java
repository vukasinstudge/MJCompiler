// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class FieldVarDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private TypePart TypePart;
    private More_fieldvardecl More_fieldvardecl;

    public FieldVarDecl (TypePart TypePart, More_fieldvardecl More_fieldvardecl) {
        this.TypePart=TypePart;
        if(TypePart!=null) TypePart.setParent(this);
        this.More_fieldvardecl=More_fieldvardecl;
        if(More_fieldvardecl!=null) More_fieldvardecl.setParent(this);
    }

    public TypePart getTypePart() {
        return TypePart;
    }

    public void setTypePart(TypePart TypePart) {
        this.TypePart=TypePart;
    }

    public More_fieldvardecl getMore_fieldvardecl() {
        return More_fieldvardecl;
    }

    public void setMore_fieldvardecl(More_fieldvardecl More_fieldvardecl) {
        this.More_fieldvardecl=More_fieldvardecl;
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
        if(More_fieldvardecl!=null) More_fieldvardecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypePart!=null) TypePart.traverseTopDown(visitor);
        if(More_fieldvardecl!=null) More_fieldvardecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypePart!=null) TypePart.traverseBottomUp(visitor);
        if(More_fieldvardecl!=null) More_fieldvardecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FieldVarDecl(\n");

        if(TypePart!=null)
            buffer.append(TypePart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(More_fieldvardecl!=null)
            buffer.append(More_fieldvardecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FieldVarDecl]");
        return buffer.toString();
    }
}
