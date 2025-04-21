package extensionObjects.game;

import java.util.HashMap;
import java.util.Map;

// Базовый интерфейс
interface GameObject {
    Extension getExtension(String type);
}

// Расширения
interface Extension {
    void activate();
}

// Конкретный объект
class Spaceship implements GameObject {
    private final Map<String, Extension> extensions = new HashMap<>();

    public Spaceship() {
        extensions.put("Weapon", new WeaponExtension());
        extensions.put("Shield", new ShieldExtension());
    }

    @Override
    public Extension getExtension(String type) {
        return extensions.get(type);
    }
}

// Конкретные расширения
class WeaponExtension implements Extension {
    @Override
    public void activate() {
        System.out.println("Fire!");
    }
}

class ShieldExtension implements Extension {
    @Override
    public void activate() {
        System.out.println("Shield is activated");
    }
}

public class Game {
    public static void main(String[] args) {
        // Использование
        Spaceship ship = new Spaceship();
        ship.getExtension("Weapon").activate(); // Огонь!
        ship.getExtension("Shield").activate(); // Щит активирован!
        ship.getExtension("Shield").activate(); // Огонь!
    }
}

