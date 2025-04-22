package memento.player;

// Хранитель состояния игрока
class PlayerMemento {
    private final int level;
    private final int health;
    private final String location;

    public PlayerMemento(int level, int health, String location) {
        this.level = level;
        this.health = health;
        this.location = location;
    }

    public int getLevel() { return level; }
    public int getHealth() { return health; }
    public String getLocation() { return location; }
}