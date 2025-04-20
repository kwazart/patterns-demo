package visitor;

// 4. Интерфейс посетителя
public interface XmlVisitor {
    void visit(XmlTag tag);
    void visit(XmlAttribute attribute);
}
