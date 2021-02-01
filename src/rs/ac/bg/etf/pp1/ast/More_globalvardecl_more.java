// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class More_globalvardecl_more extends More_globalvardecl {

    private More_globalvardecl More_globalvardecl;
    private Single_globalvardecl Single_globalvardecl;

    public More_globalvardecl_more (More_globalvardecl More_globalvardecl, Single_globalvardecl Single_globalvardecl) {
        this.More_globalvardecl=More_globalvardecl;
        if(More_globalvardecl!=null) More_globalvardecl.setParent(this);
        this.Single_globalvardecl=Single_globalvardecl;
        if(Single_globalvardecl!=null) Single_globalvardecl.setParent(this);
    }

    public More_globalvardecl getMore_globalvardecl() {
        return More_globalvardecl;
    }

    public void setMore_globalvardecl(More_globalvardecl More_globalvardecl) {
        this.More_globalvardecl=More_globalvardecl;
    }

    public Single_globalvardecl getSingle_globalvardecl() {
        return Single_globalvardecl;
    }

    public void setSingle_globalvardecl(Single_globalvardecl Single_globalvardecl) {
        this.Single_globalvardecl=Single_globalvardecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(More_globalvardecl!=null) More_globalvardecl.accept(visitor);
        if(Single_globalvardecl!=null) Single_globalvardecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(More_globalvardecl!=null) More_globalvardecl.traverseTopDown(visitor);
        if(Single_globalvardecl!=null) Single_globalvardecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(More_globalvardecl!=null) More_globalvardecl.traverseBottomUp(visitor);
        if(Single_globalvardecl!=null) Single_globalvardecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("More_globalvardecl_more(\n");

        if(More_globalvardecl!=null)
            buffer.append(More_globalvardecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Single_globalvardecl!=null)
            buffer.append(Single_globalvardecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [More_globalvardecl_more]");
        return buffer.toString();
    }
}
