package visitor;

import java.util.ArrayList;
import java.util.List;

// Интерфейс игрового объекта
interface GameElement {
    void accept(GameVisitor visitor);
}

// Класс Tank
class Tank implements GameElement {
    private final int damage;
    private final int mileage;

    public Tank(int damage, int mileage) {
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
    public void accept(GameVisitor visitor) {
        visitor.visit(this);
    }
}

// Класс Dot
class Dot implements GameElement {
    private final int damage;

    public Dot(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void accept(GameVisitor visitor) {
        visitor.visit(this);
    }
}

// Интерфейс посетителя
interface GameVisitor {
    void visit(Tank tank);
    void visit(Dot dot);
}

// Посетитель для поиска максимального damageа
class DamageFinder implements GameVisitor {
    private int maxDamage = 0;

    @Override
    public void visit(Tank tank) {
        maxDamage = Math.max(maxDamage, tank.getDamage());
    }

    @Override
    public void visit(Dot dot) {
        maxDamage = Math.max(maxDamage, dot.getDamage());
    }

    public int getMaxDamage() {
        return maxDamage;
    }
}

// Посетитель для поиска минимального mileageа
class MileageFinder implements GameVisitor {
    private int minMileage = Integer.MAX_VALUE;

    @Override
    public void visit(Tank tank) {
        minMileage = Math.min(minMileage, tank.getMileage());
    }

    @Override
    public void visit(Dot dot) {
        // У Dotов нет mileageа, поэтому ничего не делаем
    }

    public int getMinMileage() {
        return minMileage;
    }
}

public class GameAnalysis {
    public static void main(String[] args) {
        // Создаем список игровых объектов
        List<GameElement> gameElements = new ArrayList<>();
        gameElements.add(new Tank(10, 100));
        gameElements.add(new Tank(15, 90));
        gameElements.add(new Dot(0));
        gameElements.add(new Dot(80));

        // Посетитель для поиска максимального damageа
        DamageFinder damageFinder = new DamageFinder();

        // Посетитель для поиска минимального mileageа
        MileageFinder mileageFinder = new MileageFinder();

        // Применяем посетителей ко всем объектам
        for (GameElement element : gameElements) {
            element.accept(damageFinder);
            element.accept(mileageFinder);
        }

        // Выводим результаты
        System.out.println("Maximum damage among all objects: " + damageFinder.getMaxDamage());
        System.out.println("Minimum mileage among all tanks: " +
                (mileageFinder.getMinMileage() == Integer.MAX_VALUE ? "no data" : mileageFinder.getMinMileage()));

        // Воспроизведение игры (просто выводим все объекты)
        System.out.println("\nGame process:");
        for (GameElement element : gameElements) {
            if (element instanceof Tank tank) {
                System.out.println("Tank(damage=" + tank.getDamage() + ", mileage=" + tank.getMileage() + ")");
            } else if (element instanceof Dot dot) {
                System.out.println("Dot(damage=" + dot.getDamage() + ")");
            }
        }
    }
}