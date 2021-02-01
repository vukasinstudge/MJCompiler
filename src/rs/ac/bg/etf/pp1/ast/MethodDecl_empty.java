// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl_empty extends MethodDecl {

    private MethodUnique MethodUnique;

    public MethodDecl_empty (MethodUnique MethodUnique) {
        this.MethodUnique=MethodUnique;
        if(MethodUnique!=null) MethodUnique.setParent(this);
    }

    public MethodUnique getMethodUnique() {
        return MethodUnique;
    }

    public void setMethodUnique(MethodUnique MethodUnique) {
        this.MethodUnique=MethodUnique;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodUnique!=null) MethodUnique.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodUnique!=null) MethodUnique.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodUnique!=null) MethodUnique.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecl_empty(\n");

        if(MethodUnique!=null)
            buffer.append(MethodUnique.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDecl_empty]");
        return buffer.toString();
    }
}
