// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class MaybeElse_else extends MaybeElse {

    private ElseOpen ElseOpen;
    private Statement Statement;

    public MaybeElse_else (ElseOpen ElseOpen, Statement Statement) {
        this.ElseOpen=ElseOpen;
        if(ElseOpen!=null) ElseOpen.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public ElseOpen getElseOpen() {
        return ElseOpen;
    }

    public void setElseOpen(ElseOpen ElseOpen) {
        this.ElseOpen=ElseOpen;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ElseOpen!=null) ElseOpen.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ElseOpen!=null) ElseOpen.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ElseOpen!=null) ElseOpen.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MaybeElse_else(\n");

        if(ElseOpen!=null)
            buffer.append(ElseOpen.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MaybeElse_else]");
        return buffer.toString();
    }
}
