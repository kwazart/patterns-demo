package visitor.sax;

// 3. Класс атрибута XML
public class XmlAttribute implements XmlElement {
    private final String name;
    private final String value;

    public XmlAttribute(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public void accept(XmlVisitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
