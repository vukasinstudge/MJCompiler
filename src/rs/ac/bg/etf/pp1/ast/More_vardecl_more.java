// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class More_vardecl_more extends More_vardecl {

    private More_vardecl More_vardecl;
    private Single_vardecl Single_vardecl;

    public More_vardecl_more (More_vardecl More_vardecl, Single_vardecl Single_vardecl) {
        this.More_vardecl=More_vardecl;
        if(More_vardecl!=null) More_vardecl.setParent(this);
        this.Single_vardecl=Single_vardecl;
        if(Single_vardecl!=null) Single_vardecl.setParent(this);
    }

    public More_vardecl getMore_vardecl() {
        return More_vardecl;
    }

    public void setMore_vardecl(More_vardecl More_vardecl) {
        this.More_vardecl=More_vardecl;
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
        if(More_vardecl!=null) More_vardecl.accept(visitor);
        if(Single_vardecl!=null) Single_vardecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(More_vardecl!=null) More_vardecl.traverseTopDown(visitor);
        if(Single_vardecl!=null) Single_vardecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(More_vardecl!=null) More_vardecl.traverseBottomUp(visitor);
        if(Single_vardecl!=null) Single_vardecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("More_vardecl_more(\n");

        if(More_vardecl!=null)
            buffer.append(More_vardecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Single_vardecl!=null)
            buffer.append(Single_vardecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [More_vardecl_more]");
        return buffer.toString();
    }
}
