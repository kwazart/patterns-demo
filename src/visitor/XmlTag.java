package visitor;

import java.util.ArrayList;
import java.util.List;

// 2. Класс тега XML
public class XmlTag implements XmlElement {
    private final String name;
    private String textContent = "";
    private final List<XmlElement> children = new ArrayList<>();

    public XmlTag(String name) {
        this.name = name;
    }

    public void addChild(XmlElement child) {
        children.add(child);
    }

    public void setTextContent(String text) {
        this.textContent = text;
    }

    @Override
    public void accept(XmlVisitor visitor) {
        visitor.visit(this);
        for (XmlElement child : children) {
            child.accept(visitor);
        }
    }

    public String getName() {
        return name;
    }

    public String getTextContent() {
        return textContent;
    }
}
