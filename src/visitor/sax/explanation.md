# Объяснение паттерна "Visitor"

**Представьте, что у вас есть музей (XML-документ) с разными экспонатами (теги и атрибуты).**

1. **Экспонаты (XmlTag и XmlAttribute)**:
    - Каждый экспонат умеет "принимать посетителей" (метод `accept()`)
    - Когда приходит посетитель, экспонат говорит: "Вот кто я такой, посмотри на меня!" (вызывает `visitor.visit(this)`)

2. **Посетитель (BookInfoVisitor)**:
    - Это как экскурсовод, который знает:
        - Как смотреть на картины (`visit(XmlTag tag)`)
        - Как читать таблички (`visit(XmlAttribute attr)`)
    - Для каждого типа экспоната у него своя реакция

3. **Как это работает**:
    - Парсер (SAX) ходит по музею и собирает все экспонаты
    - В конце он говорит корневому экспонату: "Прими посетителя!"
    - Корневой экспонат показывает себя посетителю, затем говорит своим детям: "Вы тоже покажитесь!"
    - Посетитель смотрит на каждый экспонат и решает, что с ним делать

**Пример с книгой**:
1. Тег `<book>` говорит посетителю: "Я книга!"
    - Посетитель печатает "Найдена книга:"
2. Атрибут `id="1"` говорит: "Я атрибут!"
    - Посетитель проверяет имя и печатает "ID: 1"
3. Тег `<name>` говорит: "Я название!"
    - Посетитель печатает текст внутри

**Почему это удобно**:
- Можно добавить нового "посетителя" (например, для экспорта в JSON), не меняя сами экспонаты
- Логика обработки отделена от структуры данных
- Легко добавлять новые операции над XML

Это как если бы вместо того, чтобы каждый экспонат умел сам себя показывать, мы наняли отдельного экскурсовода (посетителя), который знает, как работать с каждым типом экспонатов.