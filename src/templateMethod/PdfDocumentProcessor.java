package templateMethod;

class PdfDocumentProcessor extends DocumentProcessor {
    protected void openDocument() {
        System.out.println("Opening PDF document");
    }

    protected void parseContent() {
        System.out.println("Parsing PDF content");
    }

    protected void saveData() {
        System.out.println("Saving PDF data to database");
    }
}
