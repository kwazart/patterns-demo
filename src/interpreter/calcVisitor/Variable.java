package interpreter.calcVisitor;

class Variable implements Expression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int interpret(Context context) {
        return context.getVariable(name);
    }
}