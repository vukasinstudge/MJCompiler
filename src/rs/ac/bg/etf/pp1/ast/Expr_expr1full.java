// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class Expr_expr1full extends Expr {

    private FullCond FullCond;
    private Expr2 Expr2;
    private Expr3 Expr3;

    public Expr_expr1full (FullCond FullCond, Expr2 Expr2, Expr3 Expr3) {
        this.FullCond=FullCond;
        if(FullCond!=null) FullCond.setParent(this);
        this.Expr2=Expr2;
        if(Expr2!=null) Expr2.setParent(this);
        this.Expr3=Expr3;
        if(Expr3!=null) Expr3.setParent(this);
    }

    public FullCond getFullCond() {
        return FullCond;
    }

    public void setFullCond(FullCond FullCond) {
        this.FullCond=FullCond;
    }

    public Expr2 getExpr2() {
        return Expr2;
    }

    public void setExpr2(Expr2 Expr2) {
        this.Expr2=Expr2;
    }

    public Expr3 getExpr3() {
        return Expr3;
    }

    public void setExpr3(Expr3 Expr3) {
        this.Expr3=Expr3;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FullCond!=null) FullCond.accept(visitor);
        if(Expr2!=null) Expr2.accept(visitor);
        if(Expr3!=null) Expr3.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FullCond!=null) FullCond.traverseTopDown(visitor);
        if(Expr2!=null) Expr2.traverseTopDown(visitor);
        if(Expr3!=null) Expr3.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FullCond!=null) FullCond.traverseBottomUp(visitor);
        if(Expr2!=null) Expr2.traverseBottomUp(visitor);
        if(Expr3!=null) Expr3.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Expr_expr1full(\n");

        if(FullCond!=null)
            buffer.append(FullCond.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr2!=null)
            buffer.append(Expr2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr3!=null)
            buffer.append(Expr3.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Expr_expr1full]");
        return buffer.toString();
    }
}
