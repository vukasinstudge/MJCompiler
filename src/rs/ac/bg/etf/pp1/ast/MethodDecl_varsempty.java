// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl_varsempty extends MethodDecl {

    private MethodUnique MethodUnique;
    private VarDecl_list VarDecl_list;

    public MethodDecl_varsempty (MethodUnique MethodUnique, VarDecl_list VarDecl_list) {
        this.MethodUnique=MethodUnique;
        if(MethodUnique!=null) MethodUnique.setParent(this);
        this.VarDecl_list=VarDecl_list;
        if(VarDecl_list!=null) VarDecl_list.setParent(this);
    }

    public MethodUnique getMethodUnique() {
        return MethodUnique;
    }

    public void setMethodUnique(MethodUnique MethodUnique) {
        this.MethodUnique=MethodUnique;
    }

    public VarDecl_list getVarDecl_list() {
        return VarDecl_list;
    }

    public void setVarDecl_list(VarDecl_list VarDecl_list) {
        this.VarDecl_list=VarDecl_list;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodUnique!=null) MethodUnique.accept(visitor);
        if(VarDecl_list!=null) VarDecl_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodUnique!=null) MethodUnique.traverseTopDown(visitor);
        if(VarDecl_list!=null) VarDecl_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodUnique!=null) MethodUnique.traverseBottomUp(visitor);
        if(VarDecl_list!=null) VarDecl_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecl_varsempty(\n");

        if(MethodUnique!=null)
            buffer.append(MethodUnique.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecl_list!=null)
            buffer.append(VarDecl_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDecl_varsempty]");
        return buffer.toString();
    }
}
