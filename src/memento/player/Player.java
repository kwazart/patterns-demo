package memento.player;

// Игрок (Originator)
class Player {
    private int level;
    private int health;
    private String location;

    public Player(String location) {
        this.level = 1;
        this.health = 100;
        this.location = location;
    }

    public void levelUp() {
        level++;
        health = 100;
        System.out.println("Level up! Now level " + level);
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println("Took " + damage + " damage. Health: " + health);
    }

    public void moveTo(String location) {
        this.location = location;
        System.out.println("Moved to " + location);
    }

    public PlayerMemento save() {
        return new PlayerMemento(level, health, location);
    }

    public void restore(PlayerMemento memento) {
        this.level = memento.getLevel();
        this.health = memento.getHealth();
        this.location = memento.getLocation();
        System.out.println("Game state restored to level " + level +
                ", health " + health + ", location " + location);
    }

    public void printStatus() {
        System.out.println("Level: " + level +
                ", Health: " + health +
                ", Location: " + location);
    }
}
