// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl_extendsvarsbraces extends ClassDecl {

    private String I1;
    private Type Type;
    private FieldVarDecl_list FieldVarDecl_list;

    public ClassDecl_extendsvarsbraces (String I1, Type Type, FieldVarDecl_list FieldVarDecl_list) {
        this.I1=I1;
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FieldVarDecl_list=FieldVarDecl_list;
        if(FieldVarDecl_list!=null) FieldVarDecl_list.setParent(this);
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

    public FieldVarDecl_list getFieldVarDecl_list() {
        return FieldVarDecl_list;
    }

    public void setFieldVarDecl_list(FieldVarDecl_list FieldVarDecl_list) {
        this.FieldVarDecl_list=FieldVarDecl_list;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(FieldVarDecl_list!=null) FieldVarDecl_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FieldVarDecl_list!=null) FieldVarDecl_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FieldVarDecl_list!=null) FieldVarDecl_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl_extendsvarsbraces(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FieldVarDecl_list!=null)
            buffer.append(FieldVarDecl_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecl_extendsvarsbraces]");
        return buffer.toString();
    }
}
