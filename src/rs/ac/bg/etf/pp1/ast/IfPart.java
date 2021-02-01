// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class IfPart implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private IfOpen IfOpen;
    private IfClose IfClose;

    public IfPart (IfOpen IfOpen, IfClose IfClose) {
        this.IfOpen=IfOpen;
        if(IfOpen!=null) IfOpen.setParent(this);
        this.IfClose=IfClose;
        if(IfClose!=null) IfClose.setParent(this);
    }

    public IfOpen getIfOpen() {
        return IfOpen;
    }

    public void setIfOpen(IfOpen IfOpen) {
        this.IfOpen=IfOpen;
    }

    public IfClose getIfClose() {
        return IfClose;
    }

    public void setIfClose(IfClose IfClose) {
        this.IfClose=IfClose;
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
        if(IfOpen!=null) IfOpen.accept(visitor);
        if(IfClose!=null) IfClose.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfOpen!=null) IfOpen.traverseTopDown(visitor);
        if(IfClose!=null) IfClose.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfOpen!=null) IfOpen.traverseBottomUp(visitor);
        if(IfClose!=null) IfClose.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfPart(\n");

        if(IfOpen!=null)
            buffer.append(IfOpen.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IfClose!=null)
            buffer.append(IfClose.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfPart]");
        return buffer.toString();
    }
}
