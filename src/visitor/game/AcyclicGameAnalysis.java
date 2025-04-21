package visitor.game;

import java.util.ArrayList;
import java.util.List;


// Базовый интерфейс для всех Visitor'ов
interface VisitorBase {}  // Маркерный интерфейс


// Интерфейс для посещения Tank
interface AcyclicTankVisitor extends VisitorBase {
    void visit(AcyclicTank tank);
}

interface AcyclicPlaneVisitor extends VisitorBase {
    void visit(AcyclicPlane plane);
}

// Интерфейс для посещения Dot
interface AcyclicDotVisitor extends VisitorBase {
    void visit(AcyclicDot dot);
}

// Интерфейс игрового объекта
interface AcyclicGameElement {
    void accept(VisitorBase visitor);  // Принимает базовый интерфейс
}

class AcyclicTank implements AcyclicGameElement {
    private final int damage;
    private final int mileage;

    public AcyclicTank(int damage, int mileage) {
        this.damage = damage;
        this.mileage = mileage;
    }

    public int getDamage() {
        return damage;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public void accept(VisitorBase visitor) {
        if (visitor instanceof AcyclicTankVisitor newVisitor) {
            newVisitor.visit(this);
        }
    }
}

class AcyclicPlane implements AcyclicGameElement {
    private final int damage;
    private final int mileage;

    public AcyclicPlane(int damage, int mileage) {
        this.damage = damage;
        this.mileage = mileage;
    }

    public int getDamage() {
        return damage;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public void accept(VisitorBase visitor) {
        if (visitor instanceof AcyclicPlaneVisitor newVisitor) {
            newVisitor.visit(this);
        }
    }
}

class AcyclicDot implements AcyclicGameElement {
    private final int damage;

    public AcyclicDot(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void accept(VisitorBase visitor) {
        if (visitor instanceof AcyclicDotVisitor newVisitor) {
            newVisitor.visit(this);
        }
    }
}

// Посетитель для поиска максимального damage
class AcyclicDamageFinder implements AcyclicTankVisitor, AcyclicDotVisitor, AcyclicPlaneVisitor {
    private int maxDamage = 0;

    @Override
    public void visit(AcyclicTank tank) {
        maxDamage = Math.max(maxDamage, tank.getDamage());
    }

    @Override
    public void visit(AcyclicDot dot) {
        maxDamage = Math.max(maxDamage, dot.getDamage());
    }

    @Override
    public void visit(AcyclicPlane plane) {
        maxDamage = Math.max(maxDamage, plane.getDamage());
    }

    public int getMaxDamage() {
        return maxDamage;
    }
}

// Посетитель для поиска минимального mileage
class AcyclicMileageFinder implements AcyclicTankVisitor, AcyclicPlaneVisitor {
    private int minMileage = Integer.MAX_VALUE;

    @Override
    public void visit(AcyclicTank acyclicTank) {
        if (acyclicTank.getMileage() < minMileage) {
            minMileage = acyclicTank.getMileage();
        }
    }

    @Override
    public void visit(AcyclicPlane acyclicPlane) {
        if (acyclicPlane.getMileage() < minMileage) {
            minMileage = acyclicPlane.getMileage();
        }
    }

    public int getMinMileage() {
        return minMileage;
    }


}

public class AcyclicGameAnalysis {
    public static void main(String[] args) {
        // Создаем список игровых объектов
        List<AcyclicGameElement> acyclicGameElements = new ArrayList<>();
        acyclicGameElements.add(new AcyclicTank(10, 100));
        acyclicGameElements.add(new AcyclicTank(15, 90));
        acyclicGameElements.add(new AcyclicDot(0));
        acyclicGameElements.add(new AcyclicDot(80));
        acyclicGameElements.add(new AcyclicPlane(30, 180));
        acyclicGameElements.add(new AcyclicPlane(250, 150));


        // Посетитель для поиска максимального damage
        AcyclicDamageFinder acyclicDamageFinder = new AcyclicDamageFinder();

        // Посетитель для поиска минимального mileage
        AcyclicMileageFinder acyclicMileageFinder = new AcyclicMileageFinder();

        // Применяем посетителей ко всем объектам
        for (AcyclicGameElement element : acyclicGameElements) {
            element.accept(acyclicDamageFinder);
            element.accept(acyclicMileageFinder);
        }

        // Выводим результаты
        System.out.println("Maximum damage among all objects: " + acyclicDamageFinder.getMaxDamage());
        System.out.println("Minimum mileage among all tanks: " +
                (acyclicMileageFinder.getMinMileage() == Integer.MAX_VALUE ? "no data" : acyclicMileageFinder.getMinMileage()));
        System.out.println("Minimum mileage among all planes: " +
                (acyclicMileageFinder.getMinMileage() == Integer.MAX_VALUE ? "no data" : acyclicMileageFinder.getMinMileage()));

        // Воспроизведение игры (просто выводим все объекты)
        System.out.println("\nGame process:");
        for (AcyclicGameElement element : acyclicGameElements) {
            if (element instanceof AcyclicTank t) {
                System.out.printf("Tank(Damage=%d, Mileage=%d)\n", t.getDamage(), t.getMileage());
            } else if (element instanceof AcyclicDot d) {
                System.out.printf("Dot(Damage=%d)\n", d.getDamage());
            } else if (element instanceof AcyclicPlane p) {
                System.out.printf("Plane(Damage=%d, Mileage=%d)\n", p.getDamage(), p.getMileage());
            }

        }
    }
}