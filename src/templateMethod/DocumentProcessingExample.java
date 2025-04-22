package templateMethod;

public class DocumentProcessingExample {
    public static void main(String[] args) {
        DocumentProcessor pdfProcessor = new PdfDocumentProcessor();
        pdfProcessor.processDocument();

        System.out.println("\n---\n");

        DocumentProcessor wordProcessor = new WordDocumentProcessor();
        wordProcessor.processDocument();
    }
}