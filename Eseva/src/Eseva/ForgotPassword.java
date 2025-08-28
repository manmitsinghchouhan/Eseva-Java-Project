package Eseva;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class ForgotPassword extends JFrame implements ActionListener {

    private JTextField tfUsername, tfName, tfSecurityQuestion, tfAnswer, tfPassword;
    private JButton btnSearch, btnRetrieve, btnBack;

    public ForgotPassword() {
        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70, 200, 200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setBounds(30, 30, 500, 280);
        p1.setLayout(null);
        add(p1);

        // --- UI Components ---
        addLabelToPanel(p1, "Username", 40, 20);
        tfUsername = new JTextField();
        tfUsername.setBounds(220, 20, 150, 25);
        p1.add(tfUsername);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(380, 20, 100, 25);
        btnSearch.addActionListener(this);
        p1.add(btnSearch);

        addLabelToPanel(p1, "Name", 40, 60);
        tfName = new JTextField();
        tfName.setBounds(220, 60, 150, 25);
        tfName.setEditable(false); // IMPROVEMENT: Make non-editable
        p1.add(tfName);

        addLabelToPanel(p1, "Your Security Question", 40, 100);
        tfSecurityQuestion = new JTextField();
        tfSecurityQuestion.setBounds(220, 100, 260, 25); // Made wider for long questions
        tfSecurityQuestion.setEditable(false); // IMPROVEMENT: Make non-editable
        p1.add(tfSecurityQuestion);

        addLabelToPanel(p1, "Answer", 40, 140);
        tfAnswer = new JTextField();
        tfAnswer.setBounds(220, 140, 150, 25);
        p1.add(tfAnswer);

        btnRetrieve = new JButton("Retrieve");
        btnRetrieve.setBounds(380, 140, 100, 25);
        btnRetrieve.addActionListener(this);
        p1.add(btnRetrieve);

        addLabelToPanel(p1, "Password", 40, 180);
        tfPassword = new JTextField();
        tfPassword.setBounds(220, 180, 150, 25);
        tfPassword.setEditable(false); // IMPROVEMENT: Make non-editable
        p1.add(tfPassword);

        btnBack = new JButton("Back");
        btnBack.setBounds(150, 230, 100, 25);
        btnBack.addActionListener(this);
        p1.add(btnBack);
    }
    
    // Helper method to reduce repeated code
    private void addLabelToPanel(JPanel panel, String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Tahoma", Font.BOLD, 13));
        label.setBounds(x, y, 150, 25);
        panel.add(label);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnSearch) {
            // FIX: Use PreparedStatement for security
            String query = "SELECT * FROM signup1 WHERE username = ?";
            try {
                Conn c = new Conn();
                PreparedStatement pstmt = c.c.prepareStatement(query);
                pstmt.setString(1, tfUsername.getText());
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    tfName.setText(rs.getString("name"));
                    tfSecurityQuestion.setText(rs.getString("security"));
                } else {
                    JOptionPane.showMessageDialog(null, "Username not found!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == btnRetrieve) {
            // FIX: Use PreparedStatement for security
            String query = "SELECT * FROM signup1 WHERE answer = ? AND username = ?";
            try {
                Conn c = new Conn();
                PreparedStatement pstmt = c.c.prepareStatement(query);
                pstmt.setString(1, tfAnswer.getText());
                pstmt.setString(2, tfUsername.getText());
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    tfPassword.setText(rs.getString("password"));
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect answer!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == btnBack) {
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new ForgotPassword().setVisible(true);
    }
}