package Eseva;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateLabour extends JFrame implements ActionListener {

    private JTextField tfNumber, tfEmergency, tfAddress, tfPhone, tfEmail, tfProfession, tfId, tfGender;
    private JLabel labelUsername, labelName;
    private JButton updateButton, backButton;
    String username;

    UpdateLabour(String username) {
        this.username = username;

        setBounds(500, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ub5.jpg"));
        Image i3 = i1.getImage().getScaledInstance(350, 550, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel imageLabel = new JLabel(i2);
        imageLabel.setBounds(500, 0, 350, 550);
        add(imageLabel);

        JLabel lblTitle = new JLabel("UPDATE LABOUR DETAILS");
        lblTitle.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblTitle.setBounds(50, 10, 300, 25);
        add(lblTitle);

        // --- Form Fields ---
        addFormField("Username:", 30, 50);
        labelUsername = new JLabel();
        labelUsername.setBounds(220, 50, 150, 25);
        add(labelUsername);

        addFormField("ID:", 30, 90);
        tfId = new JTextField();
        tfId.setBounds(220, 90, 150, 25);
        add(tfId);
        
        addFormField("Number:", 30, 130);
        tfNumber = new JTextField();
        tfNumber.setBounds(220, 130, 150, 25);
        add(tfNumber);

        addFormField("Name:", 30, 170);
        labelName = new JLabel();
        labelName.setBounds(220, 170, 150, 25);
        add(labelName);

        addFormField("Gender:", 30, 210);
        tfGender = new JTextField();
        tfGender.setBounds(220, 210, 150, 25);
        add(tfGender);

        addFormField("Emergency No:", 30, 250);
        tfEmergency = new JTextField();
        tfEmergency.setBounds(220, 250, 150, 25);
        add(tfEmergency);

        addFormField("Address:", 30, 290);
        tfAddress = new JTextField();
        tfAddress.setBounds(220, 290, 150, 25);
        add(tfAddress);

        addFormField("Phone:", 30, 330);
        tfPhone = new JTextField();
        tfPhone.setBounds(220, 330, 150, 25);
        add(tfPhone);

        addFormField("Email:", 30, 370);
        tfEmail = new JTextField();
        tfEmail.setBounds(220, 370, 150, 25);
        add(tfEmail);

        addFormField("Profession:", 30, 410);
        tfProfession = new JTextField();
        tfProfession.setBounds(220, 410, 150, 25);
        add(tfProfession);

        // --- Buttons ---
        updateButton = new JButton("Update");
        updateButton.setBackground(Color.BLACK);
        updateButton.setForeground(Color.WHITE);
        updateButton.setBounds(70, 460, 100, 25);
        updateButton.addActionListener(this);
        add(updateButton);

        backButton = new JButton("Back");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(220, 460, 100, 25);
        backButton.addActionListener(this);
        add(backButton);
        
        // --- Load existing data safely ---
        try {
            Conn c = new Conn();
            // FIX: Use PreparedStatement for safe data fetching
            String query = "SELECT * FROM customer WHERE username = ?";
            PreparedStatement pstmt = c.c.prepareStatement(query);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                labelUsername.setText(rs.getString("username"));
                labelName.setText(rs.getString("name"));
                tfId.setText(rs.getString("id"));
                tfNumber.setText(rs.getString("number"));
                tfGender.setText(rs.getString("gender"));
                tfEmergency.setText(rs.getString("emergency_no"));
                tfAddress.setText(rs.getString("address"));
                tfPhone.setText(rs.getString("phone"));
                tfEmail.setText(rs.getString("email"));
                tfProfession.setText(rs.getString("Profession"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Helper method to reduce code repetition for labels
    private void addFormField(String labelText, int x, int y) {
        JLabel label = new JLabel(labelText);
        label.setBounds(x, y, 150, 25);
        add(label);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == updateButton) {
            // FIX: Use PreparedStatement for safe updates and add the WHERE clause
            String query = "UPDATE customer SET id = ?, number = ?, name = ?, gender = ?, emergency_no = ?, address = ?, phone = ?, email = ?, Profession = ? WHERE username = ?";
            
            try {
                Conn c = new Conn();
                PreparedStatement pstmt = c.c.prepareStatement(query);
                
                // Set values for the update
                pstmt.setString(1, tfId.getText());
                pstmt.setString(2, tfNumber.getText());
                pstmt.setString(3, labelName.getText());
                pstmt.setString(4, tfGender.getText());
                pstmt.setString(5, tfEmergency.getText());
                pstmt.setString(6, tfAddress.getText());
                pstmt.setString(7, tfPhone.getText());
                pstmt.setString(8, tfEmail.getText());
                pstmt.setString(9, tfProfession.getText());
                // Set value for the WHERE clause
                pstmt.setString(10, labelUsername.getText());

                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Labour Details Updated Successfully");
                setVisible(false);

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } else if (ae.getSource() == backButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateLabour("").setVisible(true);
    }
}