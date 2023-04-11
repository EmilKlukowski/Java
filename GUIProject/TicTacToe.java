package GUIProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {
    JFrame frame;
    JPanel titlePanel = new JPanel();
    JPanel buttonsPanel = new JPanel();
    JLabel notifications = new JLabel();
    JButton[] buttons = new JButton[9];
    Random random = new Random();
    boolean player1turn;
    boolean draw = true;
    int counter = 0;


    public TicTacToe() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setSize(800, 800);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        notifications.setBackground(new Color(50, 150, 120));
        notifications.setForeground(Color.BLUE);
        notifications.setFont(new Font("Ink Free", Font.BOLD, 75));
        notifications.setText("Tic - Tac - Toe");
        notifications.setHorizontalAlignment(0);   //center = 0 , top = 1
        notifications.setOpaque(true);

        titlePanel.setBounds(0, 0, 800, 100);
        titlePanel.setLayout(new BorderLayout());  //pozwala jLabelowi rozprzestrzenic się po calej szerokosci panela


        buttonsPanel.setLayout(new GridLayout(3, 3));
        buttonsPanel.setBackground(new Color(150, 150, 150));


        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttonsPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        //===========================================

        titlePanel.add(notifications);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonsPanel);
        frame.setVisible(true);
        //===========================================


        firstTurn();

    }


    public void firstTurn() {
        //multithreading
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if ((random.nextInt(2)) == 1) {
            player1turn = true;
            notifications.setText("X turn");
        } else {
            player1turn = false;
            notifications.setText("O turn");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < buttons.length; i++) {

            if (e.getSource() == buttons[i]) {  //e.getSource zwraca obiekt na ktorym została wykonana akcja
                if (player1turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setText("X");
                        buttons[i].setForeground(Color.RED);
                        notifications.setText("O turn");
                        player1turn = false;
                        check();

                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setText("O");
                        buttons[i].setForeground(Color.BLUE);
                        notifications.setText("X turn");
                        player1turn = true;
                        check();

                    }
                }
            }
            draw();
        }

        counter++;
    }

    public void check() {

        //rows and cols wins
        if (buttons[0].getText() == "X" && buttons[1].getText() == "X" && buttons[2].getText() == "X") {
            xWins(0, 1, 2);
        }
        if (buttons[3].getText() == "X" && buttons[4].getText() == "X" && buttons[5].getText() == "X") {
            xWins(3, 4, 5);
        }
        if (buttons[6].getText() == "X" && buttons[7].getText() == "X" && buttons[8].getText() == "X") {
            xWins(6, 7, 8);
        }
        if (buttons[0].getText() == "X" && buttons[3].getText() == "X" && buttons[6].getText() == "X") {
            xWins(0, 3, 6);
        }
        if (buttons[1].getText() == "X" && buttons[4].getText() == "X" && buttons[7].getText() == "X") {
            xWins(1, 4, 7);
        }
        if (buttons[2].getText() == "X" && buttons[5].getText() == "X" && buttons[8].getText() == "X") {
            xWins(2, 5, 8);
        }
        //slope wins
        if (buttons[0].getText() == "X" && buttons[4].getText() == "X" && buttons[8].getText() == "X") {
            xWins(0, 4, 8);
        }
        if (buttons[2].getText() == "X" && buttons[4].getText() == "X" && buttons[6].getText() == "X") {
            xWins(2, 4, 6);
        }

        // O wins =======================================================================
        //rows and cols wins
        if (buttons[0].getText() == "O" && buttons[1].getText() == "O" && buttons[2].getText() == "O") {
            oWins(0, 1, 2);
        }
        if (buttons[3].getText() == "O" && buttons[4].getText() == "O" && buttons[5].getText() == "O") {
            oWins(3, 4, 5);
        }
        if (buttons[6].getText() == "O" && buttons[7].getText() == "O" && buttons[8].getText() == "O") {
            oWins(6, 7, 8);
        }
        if (buttons[0].getText() == "O" && buttons[3].getText() == "O" && buttons[6].getText() == "O") {
            oWins(0, 3, 6);
        }
        if (buttons[1].getText() == "O" && buttons[4].getText() == "O" && buttons[7].getText() == "O") {
            oWins(1, 4, 7);
        }
        if (buttons[2].getText() == "O" && buttons[5].getText() == "O" && buttons[8].getText() == "O") {
            oWins(2, 5, 8);
        }

        //slope wins
        if (buttons[0].getText() == "O" && buttons[4].getText() == "O" && buttons[8].getText() == "O") {
            oWins(0, 4, 8);
        }
        if (buttons[2].getText() == "O" && buttons[4].getText() == "O" && buttons[6].getText() == "O") {
            oWins(2, 4, 6);
        }

    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        draw = false;

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setEnabled(false);
        }

        notifications.setText("X wins!");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        draw = false;

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setEnabled(false);
        }

        notifications.setText("O wins!");

    }

    public void draw() {
        if (draw && counter == 9) {
            notifications.setText("Draw!");
        }
    }

}
