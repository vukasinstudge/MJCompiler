// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class More_fieldvardecl_more extends More_fieldvardecl {

    private More_fieldvardecl More_fieldvardecl;
    private Single_fieldvardecl Single_fieldvardecl;

    public More_fieldvardecl_more (More_fieldvardecl More_fieldvardecl, Single_fieldvardecl Single_fieldvardecl) {
        this.More_fieldvardecl=More_fieldvardecl;
        if(More_fieldvardecl!=null) More_fieldvardecl.setParent(this);
        this.Single_fieldvardecl=Single_fieldvardecl;
        if(Single_fieldvardecl!=null) Single_fieldvardecl.setParent(this);
    }

    public More_fieldvardecl getMore_fieldvardecl() {
        return More_fieldvardecl;
    }

    public void setMore_fieldvardecl(More_fieldvardecl More_fieldvardecl) {
        this.More_fieldvardecl=More_fieldvardecl;
    }

    public Single_fieldvardecl getSingle_fieldvardecl() {
        return Single_fieldvardecl;
    }

    public void setSingle_fieldvardecl(Single_fieldvardecl Single_fieldvardecl) {
        this.Single_fieldvardecl=Single_fieldvardecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(More_fieldvardecl!=null) More_fieldvardecl.accept(visitor);
        if(Single_fieldvardecl!=null) Single_fieldvardecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(More_fieldvardecl!=null) More_fieldvardecl.traverseTopDown(visitor);
        if(Single_fieldvardecl!=null) Single_fieldvardecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(More_fieldvardecl!=null) More_fieldvardecl.traverseBottomUp(visitor);
        if(Single_fieldvardecl!=null) Single_fieldvardecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("More_fieldvardecl_more(\n");

        if(More_fieldvardecl!=null)
            buffer.append(More_fieldvardecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Single_fieldvardecl!=null)
            buffer.append(Single_fieldvardecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [More_fieldvardecl_more]");
        return buffer.toString();
    }
}
