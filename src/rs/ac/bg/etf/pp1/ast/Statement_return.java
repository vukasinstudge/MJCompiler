// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class Statement_return extends Statement {

    private MaybeExpr MaybeExpr;

    public Statement_return (MaybeExpr MaybeExpr) {
        this.MaybeExpr=MaybeExpr;
        if(MaybeExpr!=null) MaybeExpr.setParent(this);
    }

    public MaybeExpr getMaybeExpr() {
        return MaybeExpr;
    }

    public void setMaybeExpr(MaybeExpr MaybeExpr) {
        this.MaybeExpr=MaybeExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MaybeExpr!=null) MaybeExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MaybeExpr!=null) MaybeExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MaybeExpr!=null) MaybeExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Statement_return(\n");

        if(MaybeExpr!=null)
            buffer.append(MaybeExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Statement_return]");
        return buffer.toString();
    }
}
