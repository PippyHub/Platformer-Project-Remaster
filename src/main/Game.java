package main;

public class Game implements Runnable {
    final int FRAMES = 120;
    final int UPDATES = 200;
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
    public void update() {
        gamePanel.updateGame();
    }
    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FRAMES;
        double timePerUpdate = 1000000000.0 / UPDATES;
        long lastUpdate = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaUpdate = 0;
        double deltaFrame = 0;


        while(true) {
            long currentUpdate = System.nanoTime();

            deltaUpdate += (currentUpdate - lastUpdate) / timePerUpdate;
            deltaFrame += (currentUpdate - lastUpdate) / timePerFrame;
            lastUpdate = currentUpdate;

            if (deltaUpdate >= 1) {
                update();
                updates++;
                deltaUpdate--;
            }
            if (deltaFrame >= 1) {
                gamePanel.repaint();
                frames++;
                deltaFrame--;
            }

            if(System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS " + frames + " | UPS " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }
}