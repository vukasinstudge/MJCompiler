// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class Case_list_more extends Case_list {

    private Integer N1;
    private Case_list Case_list;

    public Case_list_more (Integer N1, Case_list Case_list) {
        this.N1=N1;
        this.Case_list=Case_list;
        if(Case_list!=null) Case_list.setParent(this);
    }

    public Integer getN1() {
        return N1;
    }

    public void setN1(Integer N1) {
        this.N1=N1;
    }

    public Case_list getCase_list() {
        return Case_list;
    }

    public void setCase_list(Case_list Case_list) {
        this.Case_list=Case_list;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Case_list!=null) Case_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Case_list!=null) Case_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Case_list!=null) Case_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Case_list_more(\n");

        buffer.append(" "+tab+N1);
        buffer.append("\n");

        if(Case_list!=null)
            buffer.append(Case_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Case_list_more]");
        return buffer.toString();
    }
}
