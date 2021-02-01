// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class GlobalDecl_list_moreclass extends GlobalDecl_list {

    private GlobalDecl_list GlobalDecl_list;
    private ClassDecl ClassDecl;

    public GlobalDecl_list_moreclass (GlobalDecl_list GlobalDecl_list, ClassDecl ClassDecl) {
        this.GlobalDecl_list=GlobalDecl_list;
        if(GlobalDecl_list!=null) GlobalDecl_list.setParent(this);
        this.ClassDecl=ClassDecl;
        if(ClassDecl!=null) ClassDecl.setParent(this);
    }

    public GlobalDecl_list getGlobalDecl_list() {
        return GlobalDecl_list;
    }

    public void setGlobalDecl_list(GlobalDecl_list GlobalDecl_list) {
        this.GlobalDecl_list=GlobalDecl_list;
    }

    public ClassDecl getClassDecl() {
        return ClassDecl;
    }

    public void setClassDecl(ClassDecl ClassDecl) {
        this.ClassDecl=ClassDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GlobalDecl_list!=null) GlobalDecl_list.accept(visitor);
        if(ClassDecl!=null) ClassDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalDecl_list!=null) GlobalDecl_list.traverseTopDown(visitor);
        if(ClassDecl!=null) ClassDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalDecl_list!=null) GlobalDecl_list.traverseBottomUp(visitor);
        if(ClassDecl!=null) ClassDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalDecl_list_moreclass(\n");

        if(GlobalDecl_list!=null)
            buffer.append(GlobalDecl_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassDecl!=null)
            buffer.append(ClassDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalDecl_list_moreclass]");
        return buffer.toString();
    }
}
