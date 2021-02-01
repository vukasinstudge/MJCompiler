// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class More_constdecl_single extends More_constdecl {

    private Single_constdecl Single_constdecl;

    public More_constdecl_single (Single_constdecl Single_constdecl) {
        this.Single_constdecl=Single_constdecl;
        if(Single_constdecl!=null) Single_constdecl.setParent(this);
    }

    public Single_constdecl getSingle_constdecl() {
        return Single_constdecl;
    }

    public void setSingle_constdecl(Single_constdecl Single_constdecl) {
        this.Single_constdecl=Single_constdecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Single_constdecl!=null) Single_constdecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Single_constdecl!=null) Single_constdecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Single_constdecl!=null) Single_constdecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("More_constdecl_single(\n");

        if(Single_constdecl!=null)
            buffer.append(Single_constdecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [More_constdecl_single]");
        return buffer.toString();
    }
}
