package templateMethod;

class WordDocumentProcessor extends DocumentProcessor {
    protected void openDocument() {
        System.out.println("Opening Word document");
    }

    protected void parseContent() {
        System.out.println("Parsing Word content");
    }

    protected void saveData() {
        System.out.println("Saving Word data to database");
    }

    protected boolean isValid() {
        // Специфичная проверка для Word документов
        System.out.println("Performing Word-specific validation");
        return true;
    }
}
