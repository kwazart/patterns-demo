package extensionObjects.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

// 1. Базовый интерфейс для расширений
interface XmlParserExtension {
    String convert(Object data);
}

// 2. Основной класс парсера с поддержкой расширений
class SaxParserWithExtensions extends DefaultHandler {
    private final Map<String, XmlParserExtension> extensions = new HashMap<>();
    private final StringBuilder currentData = new StringBuilder();
    private final Map<String, String> parsedData = new HashMap<>();

    // Регистрация расширений
    public void addExtension(String name, XmlParserExtension extension) {
        extensions.put(name, extension);
    }

    // Получение расширения
    public XmlParserExtension getExtension(String name) {
        return extensions.get(name);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentData.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        currentData.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        parsedData.put(qName, currentData.toString().trim());
    }

    // Основной метод парсинга
    public void parse(String xml) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        saxParser.parse(new ByteArrayInputStream(xml.getBytes()), this);
    }

    public Map<String, String> getParsedData() {
        return parsedData;
    }
}

// 3. Реализации расширений
class XmlConverterExtension implements XmlParserExtension {
    @Override
    public String convert(Object data) {
        Map<String, String> parsedData = (Map<String, String>) data;
        StringBuilder xml = new StringBuilder("<root>\n");
        parsedData.forEach((k, v) -> xml.append("  <").append(k).append(">")
                .append(v).append("</").append(k).append(">\n"));
        xml.append("</root>");
        return xml.toString();
    }
}

class CsvConverterExtension implements XmlParserExtension {
    @Override
    public String convert(Object data) {
        Map<String, String> parsedData = (Map<String, String>) data;
        StringBuilder csv = new StringBuilder();
        parsedData.forEach((k, v) -> csv.append(k).append(",").append(v).append("\n"));
        return csv.toString();
    }
}

// 4. Пример использования
public class ExtensionObjectExample {
    public static void main(String[] args) throws Exception {
        String xmlData = "<data><name>John</name><age>30</age><city>New York</city></data>";

        // Создаем и настраиваем парсер
        SaxParserWithExtensions parser = new SaxParserWithExtensions();
        parser.addExtension("XML", new XmlConverterExtension());
        parser.addExtension("CSV", new CsvConverterExtension());

        // Парсим XML
        parser.parse(xmlData);

        // Конвертируем в разные форматы
        System.out.println("XML Format:");
        System.out.println(parser.getExtension("XML").convert(parser.getParsedData()));

        System.out.println("\nCSV Format:");
        System.out.println(parser.getExtension("CSV").convert(parser.getParsedData()));
    }
}