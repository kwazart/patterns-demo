package memento.textEditor;

// Создатель (Originator)
class TextEditor {
    private String text;

    public void write(String text) {
        this.text = this.text == null ? text : this.text + text;
    }

    public TextEditorMemento save() {
        return new TextEditorMemento(text);
    }

    public void restore(TextEditorMemento memento) {
        this.text = memento.getState();
    }

    public void print() {
        System.out.println("Current text: " + text);
    }
}