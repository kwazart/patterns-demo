package interpreter.calc;

// Клиентский код
public class InterpreterExample {
    public static void main(String[] args) {
        Context context = new Context();
        context.setVariable("x", 5);
        context.setVariable("y", 10);

        // Строим AST для выражения: (x + 3) - (y - 2)
        Expression expression = new Subtract(
                new Add(new Variable("x"), new Number(3)),
                new Subtract(new Variable("y"), new Number(2))
        );

        int result = expression.interpret(context);
        System.out.println("Result: " + result); // (5 + 3) - (10 - 2) = 0
    }
}
