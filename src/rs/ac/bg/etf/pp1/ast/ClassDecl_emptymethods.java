// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl_emptymethods extends ClassDecl {

    private String I1;
    private MethodDecl_list MethodDecl_list;

    public ClassDecl_emptymethods (String I1, MethodDecl_list MethodDecl_list) {
        this.I1=I1;
        this.MethodDecl_list=MethodDecl_list;
        if(MethodDecl_list!=null) MethodDecl_list.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
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
        if(MethodDecl_list!=null) MethodDecl_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDecl_list!=null) MethodDecl_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDecl_list!=null) MethodDecl_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl_emptymethods(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(MethodDecl_list!=null)
            buffer.append(MethodDecl_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecl_emptymethods]");
        return buffer.toString();
    }
}
