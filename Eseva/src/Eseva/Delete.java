package Eseva;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Delete extends JFrame implements ActionListener {

    JButton deleteButton, backButton; 
    JLabel labelUsername, labelId, labelNum, labelName, labelGender, labelEn, labelAddress, labelPhone, labelEmail, labelProfession;
    String username;

    public Delete(String username) {
        this.username = username;
        setTitle("Delete Account");
        setBounds(480, 180, 870, 625);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // --- UI Setup (using helper methods for cleaner code) ---
        addLabel("Username:", 30, 50);
        labelUsername = addDataLabel(220, 50);
        addLabel("ID:", 30, 110);
        labelId = addDataLabel(220, 110);
        addLabel("Number:", 30, 170);
        labelNum = addDataLabel(220, 170);
        addLabel("Name:", 30, 230);
        labelName = addDataLabel(220, 230);
        addLabel("Gender:", 30, 290);
        labelGender = addDataLabel(220, 290);
        addLabel("Emergency No:", 500, 50);
        labelEn = addDataLabel(690, 50);
        addLabel("Address:", 500, 110);
        labelAddress = addDataLabel(690, 110);
        addLabel("Phone:", 500, 170);
        labelPhone = addDataLabel(690, 170);
        addLabel("Email:", 500, 230);
        labelEmail = addDataLabel(690, 230);
        addLabel("Profession:", 500, 290);
        labelProfession = addDataLabel(690, 290);

        // --- Buttons ---
        deleteButton = new JButton("Delete Account");
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBounds(250, 350, 150, 30); // Made button wider for new text
        deleteButton.addActionListener(this);
        add(deleteButton);

        backButton = new JButton("Back");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(450, 350, 100, 30);
        backButton.addActionListener(this);
        add(backButton);

        // --- Decorative Images ---
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i3 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(20, 400, 600, 200);
        add(l1);

        // --- Load Data Safely ---
        loadCustomerData();
        
        setVisible(true);
    }
    
    // Helper method to load data safely
    private void loadCustomerData() {
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM customer WHERE username = ?";
            PreparedStatement pstmt = conn.c.prepareStatement(query);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                labelUsername.setText(rs.getString("username"));
                labelId.setText(rs.getString("id"));
                labelNum.setText(rs.getString("number"));
                labelName.setText(rs.getString("name"));
                labelGender.setText(rs.getString("gender"));
                labelEn.setText(rs.getString("emergency_no"));
                labelAddress.setText(rs.getString("address"));
                labelPhone.setText(rs.getString("phone"));
                labelEmail.setText(rs.getString("Email"));
                labelProfession.setText(rs.getString("Profession"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Helper methods to reduce repeated UI code
    private void addLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 150, 25);
        add(label);
    }
    private JLabel addDataLabel(int x, int y) {
        JLabel label = new JLabel();
        label.setBounds(x, y, 150, 25);
        add(label);
        return label;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deleteButton) {
            // Updated confirmation message to be very clear
            int choice = JOptionPane.showConfirmDialog(null, 
                "This will permanently delete the user's login and all details.\nThe application will close after deletion. Are you sure?", 
                "Confirm Account Deletion", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE); // Added a warning icon
            
            if (choice == JOptionPane.YES_OPTION) {
                try {
                    Conn c = new Conn();
                    // Use PreparedStatement for both delete queries for security
                    String q1 = "DELETE FROM customer WHERE username = ?";
                    String q2 = "DELETE FROM signup1 WHERE username = ?";

                    PreparedStatement pstmt1 = c.c.prepareStatement(q1);
                    pstmt1.setString(1, username);
                    pstmt1.executeUpdate();

                    PreparedStatement pstmt2 = c.c.prepareStatement(q2);
                    pstmt2.setString(1, username);
                    pstmt2.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Account deleted successfully.");
                    
                    // Exit the entire application
                    System.exit(0);

                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error deleting account: " + e.getMessage());
                }
            }
        } else if (ae.getSource() == backButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        // For testing purposes
        SwingUtilities.invokeLater(() -> new Delete("").setVisible(true));
    }
}
