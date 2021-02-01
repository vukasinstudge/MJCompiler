// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class More_formpars_more extends More_formpars {

    private More_formpars More_formpars;
    private FormPar FormPar;

    public More_formpars_more (More_formpars More_formpars, FormPar FormPar) {
        this.More_formpars=More_formpars;
        if(More_formpars!=null) More_formpars.setParent(this);
        this.FormPar=FormPar;
        if(FormPar!=null) FormPar.setParent(this);
    }

    public More_formpars getMore_formpars() {
        return More_formpars;
    }

    public void setMore_formpars(More_formpars More_formpars) {
        this.More_formpars=More_formpars;
    }

    public FormPar getFormPar() {
        return FormPar;
    }

    public void setFormPar(FormPar FormPar) {
        this.FormPar=FormPar;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(More_formpars!=null) More_formpars.accept(visitor);
        if(FormPar!=null) FormPar.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(More_formpars!=null) More_formpars.traverseTopDown(visitor);
        if(FormPar!=null) FormPar.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(More_formpars!=null) More_formpars.traverseBottomUp(visitor);
        if(FormPar!=null) FormPar.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("More_formpars_more(\n");

        if(More_formpars!=null)
            buffer.append(More_formpars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormPar!=null)
            buffer.append(FormPar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [More_formpars_more]");
        return buffer.toString();
    }
}
