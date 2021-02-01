// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class Factor_designatoactpars extends Factor {

    private DesignatorActPars DesignatorActPars;

    public Factor_designatoactpars (DesignatorActPars DesignatorActPars) {
        this.DesignatorActPars=DesignatorActPars;
        if(DesignatorActPars!=null) DesignatorActPars.setParent(this);
    }

    public DesignatorActPars getDesignatorActPars() {
        return DesignatorActPars;
    }

    public void setDesignatorActPars(DesignatorActPars DesignatorActPars) {
        this.DesignatorActPars=DesignatorActPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorActPars!=null) DesignatorActPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorActPars!=null) DesignatorActPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorActPars!=null) DesignatorActPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Factor_designatoactpars(\n");

        if(DesignatorActPars!=null)
            buffer.append(DesignatorActPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Factor_designatoactpars]");
        return buffer.toString();
    }
}
