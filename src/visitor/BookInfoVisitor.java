package visitor;

// 5. Конкретный посетитель для обработки информации о книгах
public class BookInfoVisitor implements XmlVisitor {
    @Override
    public void visit(XmlTag tag) {
        if ("book".equals(tag.getName())) {
            System.out.println("\nBook found:");
        } else if ("name".equals(tag.getName())) {
            System.out.println("Title: " + tag.getTextContent());
        }
    }

    @Override
    public void visit(XmlAttribute attribute) {
        if ("id".equals(attribute.getName())) {
            System.out.println("ID: " + attribute.getValue());
        }
    }
}
