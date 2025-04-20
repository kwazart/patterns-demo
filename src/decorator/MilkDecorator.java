package decorator;

// 4. Конкретные декораторы (Milk)
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) { super(coffee); }

    public double getCost() { return super.getCost() + 0.5; }
    public String getDescription() { return super.getDescription() + ", + milk"; }
}

