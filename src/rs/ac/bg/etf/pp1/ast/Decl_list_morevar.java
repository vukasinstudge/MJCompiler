// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class Decl_list_morevar extends Decl_list {

    private Decl_list Decl_list;
    private VarDecl VarDecl;

    public Decl_list_morevar (Decl_list Decl_list, VarDecl VarDecl) {
        this.Decl_list=Decl_list;
        if(Decl_list!=null) Decl_list.setParent(this);
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
    }

    public Decl_list getDecl_list() {
        return Decl_list;
    }

    public void setDecl_list(Decl_list Decl_list) {
        this.Decl_list=Decl_list;
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Decl_list!=null) Decl_list.accept(visitor);
        if(VarDecl!=null) VarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Decl_list!=null) Decl_list.traverseTopDown(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Decl_list!=null) Decl_list.traverseBottomUp(visitor);
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Decl_list_morevar(\n");

        if(Decl_list!=null)
            buffer.append(Decl_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Decl_list_morevar]");
        return buffer.toString();
    }
}
