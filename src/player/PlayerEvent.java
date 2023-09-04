package player;

import swing.GamePanel;

public class PlayerEvent {
    final Player player;
    final GamePanel gamePanel;
    public PlayerEvent(GamePanel gamePanel) {
        this.player = gamePanel.player;
        this.gamePanel = gamePanel;
    }
    public void actionPerformed() {
        player.gravity();
        player.move();
        gamePanel.repaint();
    }
}
