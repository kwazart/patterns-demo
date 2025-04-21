package extensionObjects.document;

import java.util.HashMap;
import java.util.Map;

interface SimpleDocument {
    Extension getExtension(String id);
}

interface Extension {
    void activate();
}

class PdfDocument implements SimpleDocument {
    private final Map<String, Extension> plugins = new HashMap<>();

    public void addPlugin(String id, Extension plugin) {
        plugins.put(id, plugin);
    }

    @Override
    public Extension getExtension(String id) {
        return plugins.get(id);
    }
}

// Плагин для подписи
class DigitalSignature implements Extension {
    @Override
    public void activate() {
        System.out.println("\nThe document is signed");
    }
}

public class Document {
    public static void main(String[] args) {
        // Использование
        PdfDocument doc = new PdfDocument();
        doc.addPlugin("Signature", new DigitalSignature());
        doc.getExtension("Signature").activate(); // Документ подписан
    }
}
