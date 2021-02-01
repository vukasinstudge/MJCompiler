// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class Statement_list_more extends Statement_list {

    private Statement Statement;
    private Statement_list Statement_list;

    public Statement_list_more (Statement Statement, Statement_list Statement_list) {
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.Statement_list=Statement_list;
        if(Statement_list!=null) Statement_list.setParent(this);
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
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
        if(Statement!=null) Statement.accept(visitor);
        if(Statement_list!=null) Statement_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(Statement_list!=null) Statement_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(Statement_list!=null) Statement_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Statement_list_more(\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement_list!=null)
            buffer.append(Statement_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Statement_list_more]");
        return buffer.toString();
    }
}
