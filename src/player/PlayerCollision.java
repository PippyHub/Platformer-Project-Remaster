package player;

import static player.Player.PLAYER_HEIGHT;
import static player.Player.PLAYER_WIDTH;
import static swing.GamePanel.GAME_PANEL_HEIGHT;
import static swing.GamePanel.GAME_PANEL_WIDTH;

public class PlayerCollision {
    final Player player;
    public PlayerCollision(Player player) {
        this.player = player;
    }
    public boolean xCollision(float newX) {
        return !(newX < 0) && !(newX + PLAYER_WIDTH > GAME_PANEL_WIDTH);
    }
    public boolean yCollision(float newY) {
        return newY < 0 || newY + PLAYER_HEIGHT > GAME_PANEL_HEIGHT;
    }
}