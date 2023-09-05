package main;

import input.KeyInputs;
import input.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener {
    public static final int GAME_PANEL_WIDTH = 1280;
    public static final int GAME_PANEL_HEIGHT = 768;
    KeyInputs keyInputs;
    MouseInputs mouseInputs;
    public GamePanel() {
        keyInputs = new KeyInputs(this);
        mouseInputs = new MouseInputs(this);
        addKeyListener(keyInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }
    public void updateGame() {

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    @Override
    public void actionPerformed(ActionEvent e) {}
}