// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl_extendsbraces extends ClassDecl {

    private String I1;
    private Type Type;

    public ClassDecl_extendsbraces (String I1, Type Type) {
        this.I1=I1;
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl_extendsbraces(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecl_extendsbraces]");
        return buffer.toString();
    }
}
