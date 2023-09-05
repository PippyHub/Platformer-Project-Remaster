package main;

import javax.swing.*;
import java.awt.*;

import static main.GamePanel.GAME_PANEL_HEIGHT;
import static main.GamePanel.GAME_PANEL_WIDTH;
public class GameFrame extends JFrame {
    public GameFrame(GamePanel gamePanel) {
        setTitle("Game");
        this.getContentPane().setPreferredSize(new Dimension(GAME_PANEL_WIDTH, GAME_PANEL_HEIGHT));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.add(gamePanel);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}