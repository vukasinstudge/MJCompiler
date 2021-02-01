// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class DesignatorActPars implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private Designator Designator;
    private ActParsOpen ActParsOpen;
    private ActParsPart ActParsPart;

    public DesignatorActPars (Designator Designator, ActParsOpen ActParsOpen, ActParsPart ActParsPart) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ActParsOpen=ActParsOpen;
        if(ActParsOpen!=null) ActParsOpen.setParent(this);
        this.ActParsPart=ActParsPart;
        if(ActParsPart!=null) ActParsPart.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public ActParsOpen getActParsOpen() {
        return ActParsOpen;
    }

    public void setActParsOpen(ActParsOpen ActParsOpen) {
        this.ActParsOpen=ActParsOpen;
    }

    public ActParsPart getActParsPart() {
        return ActParsPart;
    }

    public void setActParsPart(ActParsPart ActParsPart) {
        this.ActParsPart=ActParsPart;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(ActParsOpen!=null) ActParsOpen.accept(visitor);
        if(ActParsPart!=null) ActParsPart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ActParsOpen!=null) ActParsOpen.traverseTopDown(visitor);
        if(ActParsPart!=null) ActParsPart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ActParsOpen!=null) ActParsOpen.traverseBottomUp(visitor);
        if(ActParsPart!=null) ActParsPart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorActPars(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsOpen!=null)
            buffer.append(ActParsOpen.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsPart!=null)
            buffer.append(ActParsPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorActPars]");
        return buffer.toString();
    }
}
