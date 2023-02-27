package Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Game extends JPanel implements ActionListener {
    static final int Width = 600;
    static final int Height = 600;
    static final int Unit = 40;
    static final int Total_Units = (Width * Height) / Unit;
    static final int Delay = 60;
    final int x[] = new int[Total_Units];
    final int y[] = new int[Total_Units];
    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    char Direction = 'd';
    boolean running = false;
    boolean palyAgine = false;

    Timer timer;
    Random random;

    public Game() {
        this.setPreferredSize(new Dimension(Width, Height));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MykeyAdapter());
        startGame();

    }

    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(Delay, this);
        timer.start();

    }

    @Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);

        draw(G);

    }

    public void draw(Graphics G) {
        if (running) {

            /*
             * for (int i = 0; i < Width / Unit; i++) {
             * G.drawLine(i * Unit, 0, i * Unit, Height);
             * G.drawLine(0, i * Unit, Width, i * Unit);
             * }
             * 
             */
            G.setColor(Color.red);
            G.fillOval(appleX, appleY, Unit, Unit);

            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    G.setColor(new Color(21, 71, 52));
                    G.fillRect(x[i], y[i], Unit, Unit);

                } else {
                    G.setColor(Color.GREEN);
                    G.fillRect(x[i], y[i], Unit, Unit);
                }

            }
            G.setColor(Color.red);
            G.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics Met = getFontMetrics(G.getFont());
            G.drawString("SCORE :" + applesEaten, (Width - Met.stringWidth("SCORE :" + applesEaten)) / 2, Unit);

        } else {
            gameOver(G);
        }

    }

    public void move() {

        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (Direction) {

            case 'w':
                y[0] = y[0] - Unit;
                break;
            case 's':
                y[0] = y[0] + Unit;
                break;
            case 'd':
                x[0] = x[0] + Unit;
                break;
            case 'a':
                x[0] = x[0] - Unit;
                break;

        }

    }

    public void newApple() {
        random = new Random();
        appleX = random.nextInt((int) Width / Unit) * Unit;
        appleY = random.nextInt((int) Height / Unit) * Unit;

    }

    public void checkApple() {

        if ((x[0] == appleX) && (y[0] == appleY)) {
            newApple();

            bodyParts++;
            applesEaten++;

        }

    }

    public void check() {
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }
        // right corner
        if ((x[0] > Width - Unit) || (y[0] > Height - Unit) || (x[0] < 0) || (y[0] < 0)) {

            running = false;
        }

    }

    public void gameOver(Graphics G) {
        G.setColor(Color.red);
        G.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics Met2 = getFontMetrics(G.getFont());
        G.drawString("SCORE :" + applesEaten, (Width - Met2.stringWidth("SCORE :" + applesEaten)) / 2, Unit);
        G.setColor(Color.red);
        G.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics Met = getFontMetrics(G.getFont());
        G.drawString("GAME OVER", (Width - Met.stringWidth("GAME OVER")) / 2, Height / 2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            check();
        }
        repaint();

    }

    public class MykeyAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent E) {
            switch (E.getKeyChar()) {
                case 'd':
                    if (Direction != 'a') {
                        Direction = 'd';
                    }

                    break;
                case 'w':
                    if (Direction != 's') {
                        Direction = 'w';
                    }

                    break;
                case 's':
                    if (Direction != 'w') {
                        Direction = 's';
                    }
                    break;
                case 'a':
                    if (Direction != 'd') {
                        Direction = 'a';
                    }

                    break;
            }

        }

    }

}
