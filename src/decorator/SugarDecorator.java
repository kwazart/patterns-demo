package decorator;

// 4. Конкретные декораторы (Sugar)
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) { super(coffee); }

    public double getCost() { return super.getCost() + 0.2; }
    public String getDescription() { return super.getDescription() + ", + sugar"; }
}

