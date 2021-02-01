// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class Factor_const extends Factor {

    private Val_constdecl Val_constdecl;

    public Factor_const (Val_constdecl Val_constdecl) {
        this.Val_constdecl=Val_constdecl;
        if(Val_constdecl!=null) Val_constdecl.setParent(this);
    }

    public Val_constdecl getVal_constdecl() {
        return Val_constdecl;
    }

    public void setVal_constdecl(Val_constdecl Val_constdecl) {
        this.Val_constdecl=Val_constdecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Val_constdecl!=null) Val_constdecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Val_constdecl!=null) Val_constdecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Val_constdecl!=null) Val_constdecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Factor_const(\n");

        if(Val_constdecl!=null)
            buffer.append(Val_constdecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Factor_const]");
        return buffer.toString();
    }
}
