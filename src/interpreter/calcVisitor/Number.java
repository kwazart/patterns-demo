package interpreter.calcVisitor;

// Реализации выражений
class Number implements Expression {
    private final int value;

    public Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int interpret(Context context) {
        return value;
    }
}

