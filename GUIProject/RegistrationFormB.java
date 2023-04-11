package GUIProject;

import TicTacToe.TicTacToe;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import java.time.Year;
import java.util.Random;
import java.util.regex.Pattern;
import java.sql.*;

public class RegistrationFormB implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame("Register");
    JButton signUpBtn = new JButton("Sign up");
    JLabel register = new JLabel("Register");
    JPanel form = new JPanel();

    JTextField firstName = new JTextField("First name");
    JLabel firstNameLab = new JLabel("First name");

    JTextField lastName = new JTextField("Last name");
    JLabel lastNameLab = new JLabel("Last name");

    JTextField email = new JTextField("Email");
    JLabel emailLab = new JLabel("Email");

    JPasswordField password = new JPasswordField("Password");
    JLabel passwordLab = new JLabel("Password");

    public RegistrationFormB(){

        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("D:\\Users\\Emil\\GUI\\src\\GUIProject\\wallpaper.jpg")))));
        } catch (IOException e) {
            System.out.println(e);
        }
        frame.pack();


        //namePlaceholder
        {
            firstName.setForeground(Color.GRAY);
            firstName.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (firstName.getText().equals("First name")) {
                        firstName.setText("");
                        firstName.setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (firstName.getText().isEmpty()) {
                        firstName.setText("First name");
                        firstName.setForeground(Color.GRAY);
                    }
                }
            });
        }
        //lastNamePlaceholder
        {
            lastName.setForeground(Color.GRAY);
            lastName.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (lastName.getText().equals("Last name")) {
                        lastName.setText("");
                        lastName.setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (lastName.getText().isEmpty()) {
                        lastName.setText("Last name");
                        lastName.setForeground(Color.GRAY);
                    }
                }
            });
        }
        //emailPlaceholder
        {
            email.setForeground(Color.GRAY);
            email.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (email.getText().equals("Email")) {
                        email.setText("");
                        email.setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (email.getText().isEmpty()) {
                        email.setText("Email");
                        email.setForeground(Color.GRAY);
                    }
                }
            });
        }
        //passwordPlaceholder
        {
            password.setForeground(Color.GRAY);
            password.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (password.getText().equals("Password")) {
                        password.setText("");
                        password.setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (password.getText().isEmpty()) {
                        password.setText("Password");
                        password.setForeground(Color.GRAY);
                    }
                }
            });
        }

        register.setBounds(0, 20, 400, 50);
        register.setFont(new Font("MV Boli", Font.BOLD, 40));
        register.setOpaque(false);
        register.setForeground(Color.white);
        //register.setBackground(Color.YELLOW);
        register.setHorizontalAlignment(JLabel.CENTER);

        form.setLayout(null);
        form.setBounds(0, 60, 400, 350);
        //form.setBackground(Color.lightGray);


        //first name
        {
            firstNameLab.setBounds(40, 20, 320, 30);
            firstNameLab.setFont(new Font("MV Boli", Font.PLAIN, 15));
            firstNameLab.setForeground(Color.white);

            firstName.setBounds(40, 50, 300, 30);
        }
        //last name
        {
            lastNameLab.setBounds(40, 90, 300, 30);
            lastNameLab.setFont(new Font("MV Boli", Font.PLAIN, 15));
            lastNameLab.setForeground(Color.white);

            lastName.setBounds(40, 120, 300, 30);
        }
        //email
        {
            emailLab.setBounds(40, 160, 300, 30);
            emailLab.setFont(new Font("MV Boli", Font.PLAIN, 15));
            emailLab.setForeground(Color.white);

            email.setBounds(40, 190, 300, 30);
        }
        //password
        {
            passwordLab.setBounds(40, 230, 300, 30);
            passwordLab.setFont(new Font("MV Boli", Font.PLAIN, 15));
            passwordLab.setForeground(Color.white);

            password.setBounds(40, 260, 300, 30);
        }

        form.add(firstNameLab);
        form.add(firstName);
        form.add(lastNameLab);
        form.add(lastName);
        form.add(emailLab);
        form.add(email);
        form.add(passwordLab);
        form.add(password);
        form.setOpaque(false);
        createFrame();

        signUpBtn.addActionListener(this);
        signUpBtn.setFont(new Font("MV Boli", Font.BOLD, 25));
        signUpBtn.setBackground(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        signUpBtn.setBounds(100, 420, 200, 45);


        
        frame.add(signUpBtn);
        frame.setVisible(true);
    }

    private void createFrame(){
        frame.setSize(400, 520);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        frame.add(form);
        frame.add(register);
        frame.add(signUpBtn);
    }

    protected void endOfRegistration() {
        try {

            Connection connection = DriverManager.getConnection(/*link*/);
            Statement statement = connection.createStatement();

            String sql = "INSERT INTO OSOBAPROJEKT (FIST_NAME, LAST_NAME, EMAIL, PASSWORD)" + "VALUES (?, ?, ?, ?)";
            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setString(1, firstName.getText());
            prep.setString(2, lastName.getText());
            prep.setString(3, email.getText());
            prep.setString(4, password.getText());

            prep.executeUpdate();

            statement.close();
            connection.close();
            System.out.println("Successful registration of " + firstName.getText() + " " + lastName.getText());

        } catch (Exception e){
            e.printStackTrace();
        }



        frame.dispose();
        int answer = JOptionPane.showConfirmDialog(null,
                "Thank you for singing up. Do you want to play a game of TicTacToe?",
                "Registration", JOptionPane.YES_NO_OPTION);

        if (answer == 0)
            new TicTacToe();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == signUpBtn) {

            if (firstName.getText().equals("") || firstName.getText().equals("First name")) {
                JOptionPane.showMessageDialog(null, "First name is empty", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if ((lastName.getText().equals("") || lastName.getText().equals("Last name"))) {
                JOptionPane.showMessageDialog(null, "Last name is empty", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if (!(email.getText().contains("@")) || email.getText().equals("Email") || email.getText().equals("") || !(email.getText().contains("."))) {
                JOptionPane.showMessageDialog(null, "Wrong email", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if ((password.getText().equals("") || password.getText().equals("Password"))) {
                JOptionPane.showMessageDialog(null, "Password is empty", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if((firstName.getText().equals("") || firstName.getText().equals("First name")) ||
                    (lastName.getText().equals("") || lastName.getText().equals("Last name")) ||
                    (email.getText().equals("") || email.getText().equals("Email") || !email.getText().contains("@") || !(email.getText().contains("."))) ||
                    (password.getText().equals("") || password.getText().equals("Password"))){
            }else endOfRegistration();

        }

    }
}

