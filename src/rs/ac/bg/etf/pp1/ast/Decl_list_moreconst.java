// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class Decl_list_moreconst extends Decl_list {

    private Decl_list Decl_list;
    private ConstDecl ConstDecl;

    public Decl_list_moreconst (Decl_list Decl_list, ConstDecl ConstDecl) {
        this.Decl_list=Decl_list;
        if(Decl_list!=null) Decl_list.setParent(this);
        this.ConstDecl=ConstDecl;
        if(ConstDecl!=null) ConstDecl.setParent(this);
    }

    public Decl_list getDecl_list() {
        return Decl_list;
    }

    public void setDecl_list(Decl_list Decl_list) {
        this.Decl_list=Decl_list;
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
        if(Decl_list!=null) Decl_list.accept(visitor);
        if(ConstDecl!=null) ConstDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Decl_list!=null) Decl_list.traverseTopDown(visitor);
        if(ConstDecl!=null) ConstDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Decl_list!=null) Decl_list.traverseBottomUp(visitor);
        if(ConstDecl!=null) ConstDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Decl_list_moreconst(\n");

        if(Decl_list!=null)
            buffer.append(Decl_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDecl!=null)
            buffer.append(ConstDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Decl_list_moreconst]");
        return buffer.toString();
    }
}
