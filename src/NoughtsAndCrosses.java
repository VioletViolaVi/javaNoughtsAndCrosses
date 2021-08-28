import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class NoughtsAndCrosses implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    NoughtsAndCrosses(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Noughts & Crosses");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add((buttons[i]));
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if(e.getSource() == buttons[i]){
                if (player1_turn) {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textField.setText("O turn");
                        check();
                    }
                } else {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textField.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn(){
        // shows "Noughts & Crosses title first b4 "X-turn/O-turn
        try {
            // title changes after 3 seconds
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textField.setText("X turn");
        } else {
            player1_turn = false;
            textField.setText("O turn");
        }
    }

    public void check(){
        // check if X wins
        if ((Objects.equals(buttons[0].getText(), "X")) && (Objects.equals(buttons[1].getText(), "X")) && (Objects.equals(buttons[0].getText(), "X"))){
            xWins(0, 1, 2);
        }
        if ((Objects.equals(buttons[3].getText(), "X")) && (Objects.equals(buttons[4].getText(), "X")) && (Objects.equals(buttons[5].getText(), "X"))){
            xWins(3, 4, 5);
        }
        if ((Objects.equals(buttons[6].getText(), "X")) && (Objects.equals(buttons[7].getText(), "X")) && (Objects.equals(buttons[8].getText(), "X"))){
            xWins(6, 7, 8);
        }
        if ((Objects.equals(buttons[0].getText(), "X")) && (Objects.equals(buttons[3].getText(), "X")) && (Objects.equals(buttons[6].getText(), "X"))){
            xWins(0, 3, 6);
        }
        if ((Objects.equals(buttons[1].getText(), "X")) && (Objects.equals(buttons[4].getText(), "X")) && (Objects.equals(buttons[7].getText(), "X"))){
            xWins(1, 4, 7);
        }
        if ((Objects.equals(buttons[2].getText(), "X")) && (Objects.equals(buttons[5].getText(), "X")) && (Objects.equals(buttons[8].getText(), "X"))){
            xWins(2, 5, 8);
        }
        if ((Objects.equals(buttons[0].getText(), "X")) && (Objects.equals(buttons[4].getText(), "X")) && (Objects.equals(buttons[8].getText(), "X"))){
            xWins(0, 4, 8);
        }
        if ((Objects.equals(buttons[2].getText(), "X")) && (Objects.equals(buttons[4].getText(), "X")) && (Objects.equals(buttons[6].getText(), "X"))){
            xWins(2, 4, 6);
        }

        // check if O wins
        if ((Objects.equals(buttons[0].getText(), "O")) && (Objects.equals(buttons[1].getText(), "O")) && (Objects.equals(buttons[0].getText(), "O"))){
            oWins(0, 1, 2);
        }
        if ((Objects.equals(buttons[3].getText(), "O")) && (Objects.equals(buttons[4].getText(), "O")) && (Objects.equals(buttons[5].getText(), "O"))){
            oWins(3, 4, 5);
        }
        if ((Objects.equals(buttons[6].getText(), "O")) && (Objects.equals(buttons[7].getText(), "O")) && (Objects.equals(buttons[8].getText(), "O"))){
            oWins(6, 7, 8);
        }
        if ((Objects.equals(buttons[0].getText(), "O")) && (Objects.equals(buttons[3].getText(), "O")) && (Objects.equals(buttons[6].getText(), "O"))){
            oWins(0, 3, 6);
        }
        if ((Objects.equals(buttons[1].getText(), "O")) && (Objects.equals(buttons[4].getText(), "O")) && (Objects.equals(buttons[7].getText(), "O"))){
            oWins(1, 4, 7);
        }
        if ((Objects.equals(buttons[2].getText(), "O")) && (Objects.equals(buttons[5].getText(), "O")) && (Objects.equals(buttons[8].getText(), "O"))){
            oWins(2, 5, 8);
        }
        if ((Objects.equals(buttons[0].getText(), "O")) && (Objects.equals(buttons[4].getText(), "O")) && (Objects.equals(buttons[8].getText(), "O"))){
            oWins(0, 4, 8);
        }
        if ((Objects.equals(buttons[2].getText(), "O")) && (Objects.equals(buttons[4].getText(), "O")) && (Objects.equals(buttons[6].getText(), "O"))){
            oWins(2, 4, 6);
        }
    }

    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("X wins");
    }

    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("O wins");
    }
}
