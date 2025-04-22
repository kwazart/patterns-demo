package memento.textEditor;

import java.util.ArrayList;
import java.util.List;

// Опекун (Caretaker)
class History {
    private final List<TextEditorMemento> mementos = new ArrayList<>();
    private final TextEditor editor;

    public History(TextEditor editor) {
        this.editor = editor;
    }

    public void backup() {
        mementos.add(editor.save());
    }

    public void undo() {
        if (mementos.isEmpty()) return;

        TextEditorMemento memento = mementos.remove(mementos.size() - 1);
        editor.restore(memento);
    }
}
