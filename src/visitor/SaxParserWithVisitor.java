package visitor;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class SaxParserWithVisitor extends DefaultHandler {

    private final Stack<XmlTag> stack = new Stack<>();
    private final StringBuilder currentText = new StringBuilder();
    private final XmlVisitor visitor;

    public SaxParserWithVisitor(XmlVisitor visitor) {
        this.visitor = visitor;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        XmlTag tag = new XmlTag(qName);
        if (!stack.isEmpty()) {
            stack.peek().addChild(tag);
        }
        stack.push(tag);

        for (int i = 0; i < attributes.getLength(); i++) {
            XmlAttribute attr = new XmlAttribute(attributes.getQName(i), attributes.getValue(i));
            tag.addChild(attr);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        currentText.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (!stack.isEmpty()) {
            XmlTag element = stack.pop();
            element.setTextContent(currentText.toString().trim());
            currentText.setLength(0);

            if (stack.isEmpty()) {
                element.accept(visitor);
            }
        }
    }


}
