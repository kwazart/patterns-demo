package interpreter.calc;

// Нетерминальное выражение (вычитание)
class Subtract implements Expression {
    private final Expression left;
    private final Expression right;

    public Subtract(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public int interpret(Context context) {
        return left.interpret(context) - right.interpret(context);
    }
}
