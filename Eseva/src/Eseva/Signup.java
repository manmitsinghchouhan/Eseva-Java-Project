/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eseva;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener {

    private JTextField textField;
    private JTextField textField_1;
    private JPasswordField passwordField;
    private JTextField textField_3;
    private JButton b1, b2;
    private JComboBox comboBox;


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Signup().setVisible(true));
    }

    public Signup() {
        setBounds(350, 200, 900, 360);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JPanel p1= new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setLayout(null);
        p1.setBounds(0,0,500,400);
        add(p1);
        

        JLabel lblUsername = new JLabel("Username :");
        lblUsername.setForeground(Color.DARK_GRAY);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsername.setBounds(50, 20, 125, 25);
        p1.add(lblUsername);

        textField = new JTextField();
        textField.setBounds(190, 20, 180, 25);
        textField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(textField);
        textField.setColumns(10);
        
        JLabel lblName = new JLabel("Name :");
        lblName.setForeground(Color.DARK_GRAY);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(50, 60, 180, 25);
        p1.add(lblName);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(190, 60, 180, 25);
        textField_1.setBorder(BorderFactory.createEmptyBorder());
        p1.add(textField_1);
        
        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setForeground(Color.DARK_GRAY);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(50, 100, 125, 25);
        p1.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(190, 100, 180, 25);
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(passwordField);
        
        JLabel lblSecurityQuestion = new JLabel("Security Question :");
        lblSecurityQuestion.setForeground(Color.DARK_GRAY);
        lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSecurityQuestion.setBounds(50, 140, 175,25);
        p1.add(lblSecurityQuestion);
        
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
                                "Your child SuperHero?", "Your childhood Name ?","Your Fav Anime ?" }));
        comboBox.setBounds(190, 140, 180, 25);
        comboBox.setBorder(BorderFactory.createEmptyBorder());
        p1.add(comboBox);
        
        JLabel lblAnswer = new JLabel("Answer :");
        lblAnswer.setForeground(Color.DARK_GRAY);
        lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAnswer.setBounds(50, 180, 125, 25);
        p1.add(lblAnswer);
 
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(190, 180, 180, 25);
        textField_3.setBorder(BorderFactory.createEmptyBorder());
        p1.add(textField_3);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i3 = i7.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i3);
        JLabel l6 = new JLabel(i9);
        l6.setBounds(600, 70, 200, 200);
        add(l6);

        b1 = new JButton("Create");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 14));
        b1.setBounds(80, 250, 100, 30);
        b1.setBackground(Color.WHITE);
        b1.setForeground(new Color(133,193,233));
        p1.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.BOLD, 13));
        b2.setBounds(250, 250, 100, 30);
        b2.setBackground(Color.WHITE);
        b2.setForeground(new Color(133,193,233));
        p1.add(b2);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            
            String username = textField.getText().trim();
            String name = textField_1.getText().trim();
            // String password = textField_2.getText().trim();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars); // Converts char[] to String
            String question = (String) comboBox.getSelectedItem();
            String answer = textField_3.getText().trim();

            if (username.isEmpty() || name.isEmpty() || password.isEmpty() || answer.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required.");
                return;
            }

            String sql = "INSERT INTO signup1 (username, name, password, question, answer) VALUES (?,?,?,?,?)";
            
            try {
                Conn db = new Conn();
                try (PreparedStatement pst = db.c.prepareStatement(sql)) {
                    pst.setString(1, username);
                    pst.setString(2, name);
                    pst.setString(3, password);
                    pst.setString(4, question);
                    pst.setString(5, answer);

                    int rows = pst.executeUpdate();
                    if (rows > 0) {
                        JOptionPane.showMessageDialog(this, "Account created successfully");
                        setVisible(false);
                        new Login().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Account creation failed");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }

        } else if (ae.getSource() == b2) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
}