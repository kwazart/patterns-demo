package memento.player;

import java.util.Stack;

// Система чекпоинтов (Caretaker)
class CheckpointSystem {
    private final Stack<PlayerMemento> checkpoints = new Stack<>();

    public void saveCheckpoint(Player player) {
        checkpoints.push(player.save());
    }

    public void restoreLastCheckpoint(Player player) {
        if (!checkpoints.isEmpty()) {
            player.restore(checkpoints.pop());
        }
    }
}