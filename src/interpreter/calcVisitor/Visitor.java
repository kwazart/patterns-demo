package interpreter.calcVisitor;

// Интерфейс посетителя
interface Visitor {
    void visit(Number number);
    void visit(Variable variable);
    void visit(Add add);
    void visit(Subtract subtract);
    void visit(Multiply multiply);
    void visit(Divide divide);
}
