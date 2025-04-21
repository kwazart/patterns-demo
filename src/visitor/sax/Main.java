package visitor.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<data>" +
                "<book id=\"1\">" +
                "<name>The Grapes of Wrath</name>" +
                "</book>" +
                "<book id=\"2\">" +
                "<name>Dunno's adventures</name>" +
                "</book>" +
                "</data>";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        XmlVisitor visitor = new BookInfoVisitor();
        SaxParserWithVisitor handler = new SaxParserWithVisitor(visitor);

        saxParser.parse(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)), handler);
    }
}
