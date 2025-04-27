package interpreter.calcVisitor;

// Реализации посетителей
class PrintVisitor implements Visitor {
    @Override
    public void visit(Number number) {
        System.out.print(number.getValue());
    }

    @Override
    public void visit(Variable variable) {
        System.out.print(variable.getName());
    }

    @Override
    public void visit(Add add) {
        System.out.print("(");
        add.getLeft().accept(this);
        System.out.print(" + ");
        add.getRight().accept(this);
        System.out.print(")");
    }

    @Override
    public void visit(Subtract subtract) {
        System.out.print("(");
        subtract.getLeft().accept(this);
        System.out.print(" - ");
        subtract.getRight().accept(this);
        System.out.print(")");
    }

    @Override
    public void visit(Multiply multiply) {
        System.out.print("(");
        multiply.getLeft().accept(this);
        System.out.print(" * ");
        multiply.getRight().accept(this);
        System.out.print(")");
    }

    @Override
    public void visit(Divide divide) {
        System.out.print("(");
        divide.getLeft().accept(this);
        System.out.print(" / ");
        divide.getRight().accept(this);
        System.out.print(")");
    }
}