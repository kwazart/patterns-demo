package extensionObjects.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

class NewSaxParserWithExtensions {
    private final Map<String, String> parsedData = new HashMap<>();
    private final ParserHandler handler = new ParserHandler();

    // Внутренний класс-обработчик
    private class ParserHandler extends DefaultHandler {
        private final StringBuilder currentData = new StringBuilder();

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
    }

    // Extension Class для XML
    public static class XmlConverter {
        public static String convert(Map<String, String> data) {
            StringBuilder xml = new StringBuilder("<root>\n");
            data.forEach((k, v) -> xml.append("  <").append(k).append(">")
                    .append(v).append("</").append(k).append(">\n"));
            xml.append("</root>");
            return xml.toString();
        }
    }

    // Extension Class для CSV
    public static class CsvConverter {
        public static String convert(Map<String, String> data) {
            StringBuilder csv = new StringBuilder();
            data.forEach((k, v) -> csv.append(k).append(",").append(v).append("\n"));
            return csv.toString();
        }
    }

    // Основной метод парсинга
    public void parse(String xml) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        saxParser.parse(new ByteArrayInputStream(xml.getBytes()), handler);
    }

    public Map<String, String> getParsedData() {
        return parsedData;
    }
}

// Использование
public class ExtensionClassExample {
    public static void main(String[] args) throws Exception {
        String xmlData = "<data><name>John</name><age>30</age><city>New York</city></data>";

        SaxParserWithExtensions parser = new SaxParserWithExtensions();
        parser.parse(xmlData);

        System.out.println("XML Format:");
        System.out.println(NewSaxParserWithExtensions.XmlConverter.convert(parser.getParsedData()));

        System.out.println("\nCSV Format:");
        System.out.println(NewSaxParserWithExtensions.CsvConverter.convert(parser.getParsedData()));
    }
}
