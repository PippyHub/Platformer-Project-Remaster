package player;

import image.PlayerImage;
import swing.GamePanel;

import java.awt.*;

import static player.Player.PLAYER_HEIGHT;
import static player.Player.PLAYER_WIDTH;
public class PlayerRender {
    Player player;
    GamePanel gamePanel;
    private static final Image[] playerImg;
    static {
        PlayerImage playerImage = new PlayerImage();
        playerImg = playerImage.loadImages();
    }
    public PlayerRender(GamePanel gamePanel, Player player) {
        this.gamePanel = gamePanel;
        this.player = player;
    }
    public void render(Graphics g) {
        g.drawImage(playerImg[0], (int) player.x, (int) player.y, gamePanel);
        hitBox(g);
    }
    public void hitBox(Graphics g) {
        int hitBoxSize = 4;
        g.setColor(Color.red);
        g.fillRect((int) player.x, (int) player.y, PLAYER_WIDTH, hitBoxSize);
        g.fillRect((int) player.x, (int) player.y + PLAYER_HEIGHT - hitBoxSize, PLAYER_WIDTH, hitBoxSize);
        g.fillRect((int) player.x, (int) player.y, hitBoxSize, PLAYER_HEIGHT);
        g.fillRect((int) player.x + PLAYER_WIDTH - hitBoxSize, (int) player.y, hitBoxSize, PLAYER_HEIGHT);
    }
}