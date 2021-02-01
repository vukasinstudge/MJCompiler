// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class GlobalDecl_list_moreconst extends GlobalDecl_list {

    private GlobalDecl_list GlobalDecl_list;
    private ConstDecl ConstDecl;

    public GlobalDecl_list_moreconst (GlobalDecl_list GlobalDecl_list, ConstDecl ConstDecl) {
        this.GlobalDecl_list=GlobalDecl_list;
        if(GlobalDecl_list!=null) GlobalDecl_list.setParent(this);
        this.ConstDecl=ConstDecl;
        if(ConstDecl!=null) ConstDecl.setParent(this);
    }

    public GlobalDecl_list getGlobalDecl_list() {
        return GlobalDecl_list;
    }

    public void setGlobalDecl_list(GlobalDecl_list GlobalDecl_list) {
        this.GlobalDecl_list=GlobalDecl_list;
    }

    public ConstDecl getConstDecl() {
        return ConstDecl;
    }

    public void setConstDecl(ConstDecl ConstDecl) {
        this.ConstDecl=ConstDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GlobalDecl_list!=null) GlobalDecl_list.accept(visitor);
        if(ConstDecl!=null) ConstDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalDecl_list!=null) GlobalDecl_list.traverseTopDown(visitor);
        if(ConstDecl!=null) ConstDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalDecl_list!=null) GlobalDecl_list.traverseBottomUp(visitor);
        if(ConstDecl!=null) ConstDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalDecl_list_moreconst(\n");

        if(GlobalDecl_list!=null)
            buffer.append(GlobalDecl_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDecl!=null)
            buffer.append(ConstDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalDecl_list_moreconst]");
        return buffer.toString();
    }
}
