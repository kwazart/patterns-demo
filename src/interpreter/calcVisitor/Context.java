package interpreter.calcVisitor;

import java.util.HashMap;
import java.util.Map;

// Контекст для хранения переменных
class Context {
    private final Map<String, Integer> variables = new HashMap<>();

    public void setVariable(String name, int value) {
        variables.put(name, value);
    }

    public int getVariable(String name) {
        Integer value = variables.get(name);
        if (value == null) throw new RuntimeException("Unknown variable: " + name);
        return value;
    }
}