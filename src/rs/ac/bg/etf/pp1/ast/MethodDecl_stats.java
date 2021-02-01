// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl_stats extends MethodDecl {

    private MethodUnique MethodUnique;
    private Statement_list Statement_list;

    public MethodDecl_stats (MethodUnique MethodUnique, Statement_list Statement_list) {
        this.MethodUnique=MethodUnique;
        if(MethodUnique!=null) MethodUnique.setParent(this);
        this.Statement_list=Statement_list;
        if(Statement_list!=null) Statement_list.setParent(this);
    }

    public MethodUnique getMethodUnique() {
        return MethodUnique;
    }

    public void setMethodUnique(MethodUnique MethodUnique) {
        this.MethodUnique=MethodUnique;
    }

    public Statement_list getStatement_list() {
        return Statement_list;
    }

    public void setStatement_list(Statement_list Statement_list) {
        this.Statement_list=Statement_list;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodUnique!=null) MethodUnique.accept(visitor);
        if(Statement_list!=null) Statement_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodUnique!=null) MethodUnique.traverseTopDown(visitor);
        if(Statement_list!=null) Statement_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodUnique!=null) MethodUnique.traverseBottomUp(visitor);
        if(Statement_list!=null) Statement_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecl_stats(\n");

        if(MethodUnique!=null)
            buffer.append(MethodUnique.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement_list!=null)
            buffer.append(Statement_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDecl_stats]");
        return buffer.toString();
    }
}
