// generated with ast extension for cup
// version 0.8
// 20/0/2021 17:5:21


package rs.ac.bg.etf.pp1.ast;

public class Program_declsempty extends Program {

    private ProgName ProgName;
    private GlobalDecl_list GlobalDecl_list;

    public Program_declsempty (ProgName ProgName, GlobalDecl_list GlobalDecl_list) {
        this.ProgName=ProgName;
        if(ProgName!=null) ProgName.setParent(this);
        this.GlobalDecl_list=GlobalDecl_list;
        if(GlobalDecl_list!=null) GlobalDecl_list.setParent(this);
    }

    public ProgName getProgName() {
        return ProgName;
    }

    public void setProgName(ProgName ProgName) {
        this.ProgName=ProgName;
    }

    public GlobalDecl_list getGlobalDecl_list() {
        return GlobalDecl_list;
    }

    public void setGlobalDecl_list(GlobalDecl_list GlobalDecl_list) {
        this.GlobalDecl_list=GlobalDecl_list;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgName!=null) ProgName.accept(visitor);
        if(GlobalDecl_list!=null) GlobalDecl_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgName!=null) ProgName.traverseTopDown(visitor);
        if(GlobalDecl_list!=null) GlobalDecl_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgName!=null) ProgName.traverseBottomUp(visitor);
        if(GlobalDecl_list!=null) GlobalDecl_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Program_declsempty(\n");

        if(ProgName!=null)
            buffer.append(ProgName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalDecl_list!=null)
            buffer.append(GlobalDecl_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Program_declsempty]");
        return buffer.toString();
    }
}
