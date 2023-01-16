import Pong.PongGameFrame;
import Tic.TicTacToe;
import Snake.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

public class Gaming_Studio implements ActionListener {


    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[3];


    Gaming_Studio() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 420);
        frame.setTitle("Gaming-Studio");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setResizable(false);




        textfield.setBackground(Color.BLACK);
        textfield.setForeground(Color.orange);
        textfield.setFont(new Font("MV Boli",Font.PLAIN, 70));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("MMG's Gaming Studio");

        textfield.setOpaque(true);

        frame.setLocationRelativeTo(null);
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 700, 250);

       // button_panel.setLayout(new GridLayout(1, 3));



        for (int i = 0; i < 3; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFocusable(false);

            buttons[i].setPreferredSize(new Dimension(250,100));
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 35));
            buttons[i].addActionListener(this);
        }
        button_panel.setBackground(Color.BLACK);
        buttons[0].setText("Ping-Pong");
        buttons[1].setText("Snake");
        buttons[2].setText("Tic-Tac-Toe");
        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<3;i++) {
            if (e.getSource() == buttons[i]) {
                if(i==0){
                    PongGameFrame PF = new PongGameFrame();
                }
                else if(i ==1){
                    GameFrame game = new GameFrame();
                }
                else if(i==2){
                    TicTacToe ticTacToe = new TicTacToe();
                }
            }
        }
    }

}