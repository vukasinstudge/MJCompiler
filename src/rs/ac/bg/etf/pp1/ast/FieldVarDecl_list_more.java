// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class FieldVarDecl_list_more extends FieldVarDecl_list {

    private FieldVarDecl FieldVarDecl;
    private FieldVarDecl_list FieldVarDecl_list;

    public FieldVarDecl_list_more (FieldVarDecl FieldVarDecl, FieldVarDecl_list FieldVarDecl_list) {
        this.FieldVarDecl=FieldVarDecl;
        if(FieldVarDecl!=null) FieldVarDecl.setParent(this);
        this.FieldVarDecl_list=FieldVarDecl_list;
        if(FieldVarDecl_list!=null) FieldVarDecl_list.setParent(this);
    }

    public FieldVarDecl getFieldVarDecl() {
        return FieldVarDecl;
    }

    public void setFieldVarDecl(FieldVarDecl FieldVarDecl) {
        this.FieldVarDecl=FieldVarDecl;
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
        if(FieldVarDecl!=null) FieldVarDecl.accept(visitor);
        if(FieldVarDecl_list!=null) FieldVarDecl_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FieldVarDecl!=null) FieldVarDecl.traverseTopDown(visitor);
        if(FieldVarDecl_list!=null) FieldVarDecl_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FieldVarDecl!=null) FieldVarDecl.traverseBottomUp(visitor);
        if(FieldVarDecl_list!=null) FieldVarDecl_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FieldVarDecl_list_more(\n");

        if(FieldVarDecl!=null)
            buffer.append(FieldVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FieldVarDecl_list!=null)
            buffer.append(FieldVarDecl_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FieldVarDecl_list_more]");
        return buffer.toString();
    }
}
