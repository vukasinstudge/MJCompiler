// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class ConstDecl_singlenumber extends ConstDecl {

    private TypePart TypePart;
    private More_constdecl More_constdecl;

    public ConstDecl_singlenumber (TypePart TypePart, More_constdecl More_constdecl) {
        this.TypePart=TypePart;
        if(TypePart!=null) TypePart.setParent(this);
        this.More_constdecl=More_constdecl;
        if(More_constdecl!=null) More_constdecl.setParent(this);
    }

    public TypePart getTypePart() {
        return TypePart;
    }

    public void setTypePart(TypePart TypePart) {
        this.TypePart=TypePart;
    }

    public More_constdecl getMore_constdecl() {
        return More_constdecl;
    }

    public void setMore_constdecl(More_constdecl More_constdecl) {
        this.More_constdecl=More_constdecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TypePart!=null) TypePart.accept(visitor);
        if(More_constdecl!=null) More_constdecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypePart!=null) TypePart.traverseTopDown(visitor);
        if(More_constdecl!=null) More_constdecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypePart!=null) TypePart.traverseBottomUp(visitor);
        if(More_constdecl!=null) More_constdecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDecl_singlenumber(\n");

        if(TypePart!=null)
            buffer.append(TypePart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(More_constdecl!=null)
            buffer.append(More_constdecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDecl_singlenumber]");
        return buffer.toString();
    }
}
