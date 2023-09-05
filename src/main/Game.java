package main;

public class Game implements Runnable {
    final int FRAMES = 120;
    GamePanel gamePanel;
    GameFrame gameFrame;
    Thread gameThread;
    public Game() {
        gamePanel  = new GamePanel();
        gameFrame = new GameFrame(gamePanel);
        gamePanel.requestFocus();
        gameLoop();
    }
    private void gameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FRAMES;
        long lastFrame = System.nanoTime();
        long now;
        while(true) {
            now = System.nanoTime();
            if (System.nanoTime() - lastFrame >= timePerFrame) {
                gamePanel.repaint();
                lastFrame = now;
            }
        }
    }
}
