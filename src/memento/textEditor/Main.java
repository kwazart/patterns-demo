package memento.textEditor;

// Использование
public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History(editor);

        editor.write("Hello ");
        history.backup(); // Сохраняем состояние 1

        editor.write("World!");
        history.backup(); // Сохраняем состояние 2

        editor.write(" How are you?");
        editor.print(); // Current text: Hello World! How are you?

        // Отменяем последнее изменение
        history.undo();
        editor.print(); // Current text: Hello World!

        // Отменяем еще раз
        history.undo();
        editor.print(); // Current text: Hello
    }
}
