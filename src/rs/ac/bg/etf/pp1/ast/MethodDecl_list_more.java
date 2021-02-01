// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl_list_more extends MethodDecl_list {

    private MethodDecl MethodDecl;
    private MethodDecl_list MethodDecl_list;

    public MethodDecl_list_more (MethodDecl MethodDecl, MethodDecl_list MethodDecl_list) {
        this.MethodDecl=MethodDecl;
        if(MethodDecl!=null) MethodDecl.setParent(this);
        this.MethodDecl_list=MethodDecl_list;
        if(MethodDecl_list!=null) MethodDecl_list.setParent(this);
    }

    public MethodDecl getMethodDecl() {
        return MethodDecl;
    }

    public void setMethodDecl(MethodDecl MethodDecl) {
        this.MethodDecl=MethodDecl;
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
        if(MethodDecl!=null) MethodDecl.accept(visitor);
        if(MethodDecl_list!=null) MethodDecl_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDecl!=null) MethodDecl.traverseTopDown(visitor);
        if(MethodDecl_list!=null) MethodDecl_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDecl!=null) MethodDecl.traverseBottomUp(visitor);
        if(MethodDecl_list!=null) MethodDecl_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecl_list_more(\n");

        if(MethodDecl!=null)
            buffer.append(MethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDecl_list!=null)
            buffer.append(MethodDecl_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDecl_list_more]");
        return buffer.toString();
    }
}
