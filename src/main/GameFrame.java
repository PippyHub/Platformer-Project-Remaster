package main;

import javax.swing.*;
import java.awt.*;

import static main.GamePanel.GAME_PANEL_HEIGHT;
import static main.GamePanel.GAME_PANEL_WIDTH;
public class GameFrame extends JFrame {
    public static final GamePanel gamePanel = new GamePanel();
    public GameFrame() {
        setTitle("Game");
        this.getContentPane().setPreferredSize(new Dimension(GAME_PANEL_WIDTH, GAME_PANEL_HEIGHT));

        this.add(gamePanel);
        gamePanel.setFocusable(true);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}