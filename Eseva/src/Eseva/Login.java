/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eseva;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

public class Login extends JFrame implements ActionListener {

    private JTextField unametextfield;
    
    // Correctly declared JPasswordField. Removed the duplicate JTextField declaration.
    private JPasswordField passtf; 
    
    private JButton login, signup, password;

    public Login() {
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);
        
        getContentPane().setBackground(Color.white);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        // Your image logic here
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        JLabel username = new JLabel("Username");
        username.setBounds(60, 20, 100, 25);
        username.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(username);

        unametextfield = new JTextField();
        unametextfield.setBounds(60, 60, 300, 30);
        unametextfield.setBorder(BorderFactory.createEmptyBorder());
        p2.add(unametextfield);

        JLabel pass = new JLabel("Password");
        pass.setBounds(60, 110, 100, 25);
        pass.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(pass);

        // Correctly create JPasswordField and add it to the panel
        passtf = new JPasswordField();
        passtf.setBounds(60, 150, 300, 30);
        passtf.setBorder(BorderFactory.createEmptyBorder());
        p2.add(passtf);

        login = new JButton("Login");
        login.addActionListener(this);

        login.setForeground(Color.white);
        login.setBackground(new Color(133, 193, 233));
        login.setBounds(60, 200, 130, 30);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        p2.add(login);

        signup = new JButton("SignUp");
        signup.addActionListener(this);

        signup.setForeground(Color.white);
        signup.setBackground(new Color(133, 193, 233));
        signup.setBounds(230, 200, 130, 30);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        p2.add(signup);

        password = new JButton("Forget Password");
        password.addActionListener(this);

        password.setForeground(Color.white);
        password.setBackground(new Color(133, 193, 233));
        password.setBounds(130, 250, 130, 30);
        password.setBorder(new LineBorder(new Color(133, 193, 233)));
        p2.add(password);

        JLabel Text = new JLabel("Trouble in Login ?");
        Text.setBounds(300, 250, 150, 20);
        Text.setForeground(Color.red);
        p2.add(Text);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                String username = unametextfield.getText();
                // Correctly get the password from the JPasswordField
                String pass = new String(passtf.getPassword());

                String query = "SELECT * FROM signup1 WHERE username = ? AND password = ?";

                Conn c = new Conn();

                try (PreparedStatement pstmt = c.c.prepareStatement(query)) {
                    pstmt.setString(1, username);
                    pstmt.setString(2, pass);

                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {
                        this.setVisible(false);
                        new Loading(username).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password!");
                    }
                }

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (ae.getSource() == signup) {
            this.setVisible(false);
            new Signup().setVisible(true);
        } else if (ae.getSource() == password) {
            this.setVisible(false);
            new ForgotPassword().setVisible(true);
        }
    }

    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater() for better stability
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}