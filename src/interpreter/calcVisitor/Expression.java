package interpreter.calcVisitor;

// Интерфейс выражения
interface Expression {
    void accept(Visitor visitor);
    int interpret(Context context);
}