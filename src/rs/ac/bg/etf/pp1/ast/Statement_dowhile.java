// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class Statement_dowhile extends Statement {

    private DoOpen DoOpen;
    private Statement Statement;
    private WhileOpen WhileOpen;
    private Condition Condition;

    public Statement_dowhile (DoOpen DoOpen, Statement Statement, WhileOpen WhileOpen, Condition Condition) {
        this.DoOpen=DoOpen;
        if(DoOpen!=null) DoOpen.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.WhileOpen=WhileOpen;
        if(WhileOpen!=null) WhileOpen.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
    }

    public DoOpen getDoOpen() {
        return DoOpen;
    }

    public void setDoOpen(DoOpen DoOpen) {
        this.DoOpen=DoOpen;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public WhileOpen getWhileOpen() {
        return WhileOpen;
    }

    public void setWhileOpen(WhileOpen WhileOpen) {
        this.WhileOpen=WhileOpen;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DoOpen!=null) DoOpen.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(WhileOpen!=null) WhileOpen.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DoOpen!=null) DoOpen.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(WhileOpen!=null) WhileOpen.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DoOpen!=null) DoOpen.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(WhileOpen!=null) WhileOpen.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Statement_dowhile(\n");

        if(DoOpen!=null)
            buffer.append(DoOpen.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(WhileOpen!=null)
            buffer.append(WhileOpen.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Statement_dowhile]");
        return buffer.toString();
    }
}
