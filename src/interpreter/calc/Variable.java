package interpreter.calc;

class Variable implements Expression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    public int interpret(Context context) {
        return context.getVariable(name);
    }
}