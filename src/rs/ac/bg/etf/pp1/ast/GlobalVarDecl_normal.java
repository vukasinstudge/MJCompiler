// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class GlobalVarDecl_normal extends GlobalVarDecl {

    private TypePart TypePart;
    private More_globalvardecl More_globalvardecl;

    public GlobalVarDecl_normal (TypePart TypePart, More_globalvardecl More_globalvardecl) {
        this.TypePart=TypePart;
        if(TypePart!=null) TypePart.setParent(this);
        this.More_globalvardecl=More_globalvardecl;
        if(More_globalvardecl!=null) More_globalvardecl.setParent(this);
    }

    public TypePart getTypePart() {
        return TypePart;
    }

    public void setTypePart(TypePart TypePart) {
        this.TypePart=TypePart;
    }

    public More_globalvardecl getMore_globalvardecl() {
        return More_globalvardecl;
    }

    public void setMore_globalvardecl(More_globalvardecl More_globalvardecl) {
        this.More_globalvardecl=More_globalvardecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TypePart!=null) TypePart.accept(visitor);
        if(More_globalvardecl!=null) More_globalvardecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypePart!=null) TypePart.traverseTopDown(visitor);
        if(More_globalvardecl!=null) More_globalvardecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypePart!=null) TypePart.traverseBottomUp(visitor);
        if(More_globalvardecl!=null) More_globalvardecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVarDecl_normal(\n");

        if(TypePart!=null)
            buffer.append(TypePart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(More_globalvardecl!=null)
            buffer.append(More_globalvardecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalVarDecl_normal]");
        return buffer.toString();
    }
}
