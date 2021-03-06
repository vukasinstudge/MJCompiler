// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl_emptyvarsmethods extends ClassDecl {

    private String I1;
    private FieldVarDecl_list FieldVarDecl_list;
    private MethodDecl_list MethodDecl_list;

    public ClassDecl_emptyvarsmethods (String I1, FieldVarDecl_list FieldVarDecl_list, MethodDecl_list MethodDecl_list) {
        this.I1=I1;
        this.FieldVarDecl_list=FieldVarDecl_list;
        if(FieldVarDecl_list!=null) FieldVarDecl_list.setParent(this);
        this.MethodDecl_list=MethodDecl_list;
        if(MethodDecl_list!=null) MethodDecl_list.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public FieldVarDecl_list getFieldVarDecl_list() {
        return FieldVarDecl_list;
    }

    public void setFieldVarDecl_list(FieldVarDecl_list FieldVarDecl_list) {
        this.FieldVarDecl_list=FieldVarDecl_list;
    }

    public MethodDecl_list getMethodDecl_list() {
        return MethodDecl_list;
    }

    public void setMethodDecl_list(MethodDecl_list MethodDecl_list) {
        this.MethodDecl_list=MethodDecl_list;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FieldVarDecl_list!=null) FieldVarDecl_list.accept(visitor);
        if(MethodDecl_list!=null) MethodDecl_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FieldVarDecl_list!=null) FieldVarDecl_list.traverseTopDown(visitor);
        if(MethodDecl_list!=null) MethodDecl_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FieldVarDecl_list!=null) FieldVarDecl_list.traverseBottomUp(visitor);
        if(MethodDecl_list!=null) MethodDecl_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl_emptyvarsmethods(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(FieldVarDecl_list!=null)
            buffer.append(FieldVarDecl_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDecl_list!=null)
            buffer.append(MethodDecl_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecl_emptyvarsmethods]");
        return buffer.toString();
    }
}
