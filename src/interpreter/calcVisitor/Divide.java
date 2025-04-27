package interpreter.calcVisitor;

class Divide implements Expression {
    private final Expression left;
    private final Expression right;

    public Divide(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int interpret(Context context) {
        int divisor = right.interpret(context);
        if (divisor == 0) throw new ArithmeticException("Division by zero");
        return left.interpret(context) / divisor;
    }
}
