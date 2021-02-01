// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class More_fieldvardecl_single extends More_fieldvardecl {

    private Single_fieldvardecl Single_fieldvardecl;

    public More_fieldvardecl_single (Single_fieldvardecl Single_fieldvardecl) {
        this.Single_fieldvardecl=Single_fieldvardecl;
        if(Single_fieldvardecl!=null) Single_fieldvardecl.setParent(this);
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
        if(Single_fieldvardecl!=null) Single_fieldvardecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Single_fieldvardecl!=null) Single_fieldvardecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Single_fieldvardecl!=null) Single_fieldvardecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("More_fieldvardecl_single(\n");

        if(Single_fieldvardecl!=null)
            buffer.append(Single_fieldvardecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [More_fieldvardecl_single]");
        return buffer.toString();
    }
}
