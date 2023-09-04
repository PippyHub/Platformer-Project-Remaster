package player;

import swing.GamePanel;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class PlayerInput {
    final int PLAYER_SPEED = 5;
    final Player player;
    final GamePanel gamePanel;
    final Set<Integer> pressedKeys = new HashSet<>();
    boolean upKeyWasPressed = false;
    public PlayerInput(GamePanel gamePanel) {
        this.player = gamePanel.player;
        this.gamePanel = gamePanel;
    }
    public void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
        int speedX = 0;
        for (Integer key : pressedKeys) {
            switch (key) {
                case KeyEvent.VK_A, KeyEvent.VK_LEFT -> speedX -= PLAYER_SPEED;
                case KeyEvent.VK_D, KeyEvent.VK_RIGHT-> speedX += PLAYER_SPEED;
                case KeyEvent.VK_SPACE, KeyEvent.VK_UP -> {
                    if (!upKeyWasPressed) {
                        player.jump();
                        upKeyWasPressed = true;
                    }
                }
            }
        }
        player.setSpeedX(speedX);
    }
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
        int speedX = 0;
        for (Integer key : pressedKeys) {
            switch (key) {
                case KeyEvent.VK_A, KeyEvent.VK_LEFT -> speedX -= PLAYER_SPEED;
                case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> speedX += PLAYER_SPEED;
            }
        }
        player.setSpeedX(speedX);
        if (!pressedKeys.contains(KeyEvent.VK_SPACE) && !pressedKeys.contains(KeyEvent.VK_UP)) {
            upKeyWasPressed = false;
        }
    }
}