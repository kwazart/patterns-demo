package decorator;


// Использование
public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.getDescription()); // "Простой кофе, + молоко, + сахар"
        System.out.println(coffee.getCost()); // 2.7
    }
}

