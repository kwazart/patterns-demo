package visitor.sax;

// 1. Интерфейс элемента XML
public interface XmlElement {
    void accept(XmlVisitor visitor);
}