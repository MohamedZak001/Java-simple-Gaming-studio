package Pong;

import Pong.GamePanel;

import javax.swing.*;
import java.awt.*;

public class PongGameFrame extends JFrame{
    GamePanel panel;
    public PongGameFrame() {
        panel = new GamePanel();
        add(panel);
        setTitle("Pong Game");
        setResizable(false);
        setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setLocationRelativeTo(null); // in order to open the window in the middle of the frame
    }
}
