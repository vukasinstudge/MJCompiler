// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class Val_constdecl_bool extends Val_constdecl {

    private String B1;

    public Val_constdecl_bool (String B1) {
        this.B1=B1;
    }

    public String getB1() {
        return B1;
    }

    public void setB1(String B1) {
        this.B1=B1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Val_constdecl_bool(\n");

        buffer.append(" "+tab+B1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Val_constdecl_bool]");
        return buffer.toString();
    }
}
