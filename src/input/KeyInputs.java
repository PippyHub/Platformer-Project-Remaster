package input;

import main.GamePanel;

import java.awt.event.KeyEvent;

public class KeyInputs implements java.awt.event.KeyListener {
    private GamePanel gamePanel;
    public KeyInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("true");
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}