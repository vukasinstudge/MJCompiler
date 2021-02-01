// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class More_vardecl_single extends More_vardecl {

    private Single_vardecl Single_vardecl;

    public More_vardecl_single (Single_vardecl Single_vardecl) {
        this.Single_vardecl=Single_vardecl;
        if(Single_vardecl!=null) Single_vardecl.setParent(this);
    }

    public Single_vardecl getSingle_vardecl() {
        return Single_vardecl;
    }

    public void setSingle_vardecl(Single_vardecl Single_vardecl) {
        this.Single_vardecl=Single_vardecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Single_vardecl!=null) Single_vardecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Single_vardecl!=null) Single_vardecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Single_vardecl!=null) Single_vardecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("More_vardecl_single(\n");

        if(Single_vardecl!=null)
            buffer.append(Single_vardecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [More_vardecl_single]");
        return buffer.toString();
    }
}
