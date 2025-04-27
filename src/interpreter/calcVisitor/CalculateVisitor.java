package interpreter.calcVisitor;

class CalculateVisitor implements Visitor {
    private final Context context;
    private int result;

    public CalculateVisitor(Context context) {
        this.context = context;
    }

    public int getResult() {
        return result;
    }

    @Override
    public void visit(Number number) {
        result = number.interpret(context);
    }

    @Override
    public void visit(Variable variable) {
        result = variable.interpret(context);
    }

    @Override
    public void visit(Add add) {
        CalculateVisitor leftVisitor = new CalculateVisitor(context);
        CalculateVisitor rightVisitor = new CalculateVisitor(context);

        add.getLeft().accept(leftVisitor);
        add.getRight().accept(rightVisitor);

        result = leftVisitor.getResult() + rightVisitor.getResult();
    }

    @Override
    public void visit(Subtract subtract) {
        CalculateVisitor leftVisitor = new CalculateVisitor(context);
        CalculateVisitor rightVisitor = new CalculateVisitor(context);

        subtract.getLeft().accept(leftVisitor);
        subtract.getRight().accept(rightVisitor);

        result = leftVisitor.getResult() - rightVisitor.getResult();
    }

    @Override
    public void visit(Multiply multiply) {
        CalculateVisitor leftVisitor = new CalculateVisitor(context);
        CalculateVisitor rightVisitor = new CalculateVisitor(context);

        multiply.getLeft().accept(leftVisitor);
        multiply.getRight().accept(rightVisitor);

        result = leftVisitor.getResult() * rightVisitor.getResult();
    }

    @Override
    public void visit(Divide divide) {
        CalculateVisitor leftVisitor = new CalculateVisitor(context);
        CalculateVisitor rightVisitor = new CalculateVisitor(context);

        divide.getLeft().accept(leftVisitor);
        divide.getRight().accept(rightVisitor);

        int divisor = rightVisitor.getResult();
        if (divisor == 0) throw new ArithmeticException("Division by zero");
        result = leftVisitor.getResult() / divisor;
    }
}