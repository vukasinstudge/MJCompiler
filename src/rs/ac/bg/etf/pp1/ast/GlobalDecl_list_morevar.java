// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class GlobalDecl_list_morevar extends GlobalDecl_list {

    private GlobalDecl_list GlobalDecl_list;
    private GlobalVarDecl GlobalVarDecl;

    public GlobalDecl_list_morevar (GlobalDecl_list GlobalDecl_list, GlobalVarDecl GlobalVarDecl) {
        this.GlobalDecl_list=GlobalDecl_list;
        if(GlobalDecl_list!=null) GlobalDecl_list.setParent(this);
        this.GlobalVarDecl=GlobalVarDecl;
        if(GlobalVarDecl!=null) GlobalVarDecl.setParent(this);
    }

    public GlobalDecl_list getGlobalDecl_list() {
        return GlobalDecl_list;
    }

    public void setGlobalDecl_list(GlobalDecl_list GlobalDecl_list) {
        this.GlobalDecl_list=GlobalDecl_list;
    }

    public GlobalVarDecl getGlobalVarDecl() {
        return GlobalVarDecl;
    }

    public void setGlobalVarDecl(GlobalVarDecl GlobalVarDecl) {
        this.GlobalVarDecl=GlobalVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GlobalDecl_list!=null) GlobalDecl_list.accept(visitor);
        if(GlobalVarDecl!=null) GlobalVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalDecl_list!=null) GlobalDecl_list.traverseTopDown(visitor);
        if(GlobalVarDecl!=null) GlobalVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalDecl_list!=null) GlobalDecl_list.traverseBottomUp(visitor);
        if(GlobalVarDecl!=null) GlobalVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalDecl_list_morevar(\n");

        if(GlobalDecl_list!=null)
            buffer.append(GlobalDecl_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalVarDecl!=null)
            buffer.append(GlobalVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalDecl_list_morevar]");
        return buffer.toString();
    }
}
