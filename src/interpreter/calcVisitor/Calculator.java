package interpreter.calcVisitor;

// Клиентский код
public class Calculator {
    public static void main(String[] args) {
        // Создаем контекст с переменными
        Context context = new Context();
        context.setVariable("x", 10);
        context.setVariable("y", 5);

        // Строим AST для выражения: (x + 2) * (y - 3)
        Expression expression = new Multiply(
                new Add(new Variable("x"), new Number(2)),
                new Subtract(new Variable("y"), new Number(3))
        );

        // Используем PrintVisitor для вывода выражения
        PrintVisitor printVisitor = new PrintVisitor();
        System.out.print("Expression: ");
        expression.accept(printVisitor);
        System.out.println();

        // Вычисляем выражение с помощью CalculateVisitor
        CalculateVisitor calculateVisitor = new CalculateVisitor(context);
        expression.accept(calculateVisitor);
        System.out.println("Result: " + calculateVisitor.getResult());

        // Альтернативно: используем прямой interpret()
        System.out.println("Direct interpret result: " + expression.interpret(context));
    }
}
