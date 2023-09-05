package main;

public class Game {
    GamePanel gamePanel;
    GameFrame gameFrame;
    public Game() {
        gamePanel  = new GamePanel();
        gameFrame = new GameFrame(gamePanel);
    }
}
