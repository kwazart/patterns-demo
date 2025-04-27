package interpreter.calc;

// Абстрактное выражение
interface Expression {
    int interpret(Context context);
}