// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class FieldVarDecl_list_single extends FieldVarDecl_list {

    private FieldVarDecl FieldVarDecl;

    public FieldVarDecl_list_single (FieldVarDecl FieldVarDecl) {
        this.FieldVarDecl=FieldVarDecl;
        if(FieldVarDecl!=null) FieldVarDecl.setParent(this);
    }

    public FieldVarDecl getFieldVarDecl() {
        return FieldVarDecl;
    }

    public void setFieldVarDecl(FieldVarDecl FieldVarDecl) {
        this.FieldVarDecl=FieldVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FieldVarDecl!=null) FieldVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FieldVarDecl!=null) FieldVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FieldVarDecl!=null) FieldVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FieldVarDecl_list_single(\n");

        if(FieldVarDecl!=null)
            buffer.append(FieldVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FieldVarDecl_list_single]");
        return buffer.toString();
    }
}
