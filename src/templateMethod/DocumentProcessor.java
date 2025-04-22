package templateMethod;

import java.util.Date;

abstract class DocumentProcessor {
    // Шаблонный метод
    public final void processDocument() {
        openDocument();
        parseContent();
        if (isValid()) {
            saveData();
            logProcessing();
        } else {
            handleInvalidDocument();
        }
        closeDocument();
    }

    protected abstract void openDocument();
    protected abstract void parseContent();
    protected abstract void saveData();

    protected boolean isValid() {
        return true; // Базовая реализация
    }

    protected void logProcessing() {
        System.out.println("Document processed at " + new Date());
    }

    protected void handleInvalidDocument() {
        System.out.println("Document is invalid");
    }

    protected void closeDocument() {
        System.out.println("Closing document");
    }
}
