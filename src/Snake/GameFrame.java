package Snake;

import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame(){
        Game panel = new Game();
        this.add(panel);
        this.setTitle("Snack Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);

    }
















}
