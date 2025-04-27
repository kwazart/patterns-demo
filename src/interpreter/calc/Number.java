package interpreter.calc;

// Терминальное выражение (число или переменная)
class Number implements Expression {
    private final int value;

    public Number(int value) {
        this.value = value;
    }

    public int interpret(Context context) {
        return value;
    }
}
