package memento.player;

// Использование
public class GameExample {
    public static void main(String[] args) {
        Player player = new Player("Start Village");
        CheckpointSystem saves = new CheckpointSystem();

        player.printStatus();
        saves.saveCheckpoint(player); // Чекпоинт 1

        player.moveTo("Dark Forest");
        player.takeDamage(30);
        saves.saveCheckpoint(player); // Чекпоинт 2

        player.levelUp();
        player.moveTo("Dragon Cave");
        player.takeDamage(80);
        player.printStatus();
        saves.saveCheckpoint(player); // Чекпоинт 3

        // Умерли - восстанавливаем последний чекпоинт
        System.out.println("\nPlayer died! Restoring...");
        saves.restoreLastCheckpoint(player);
        player.printStatus();

        // Еще раз восстановим
        System.out.println("\nRestoring to initial state...");
        saves.restoreLastCheckpoint(player);
        player.printStatus();
    }
}
