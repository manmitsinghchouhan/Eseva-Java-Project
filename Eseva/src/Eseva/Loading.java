package Eseva;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Loading extends JFrame {

    private JProgressBar progressBar;
    private String username;
    private Timer timer;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Loading("").setVisible(true));
    }

    public Loading(String username) {
        this.username = username;

        setBounds(500, 200, 600, 400);
        setUndecorated(true);
        
        // The main container with the dark blue background, which will act as a border
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 105));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // The white panel that will contain all our components
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(10, 10, 580, 380);
        panel.setLayout(null); // Set layout for the inner panel as well
        contentPane.add(panel); // Add the white panel to the blue frame FIRST

        JLabel lbllibraryManagement = new JLabel("E-Seva");
        // CHANGE: Set a dark color to be visible on the white panel
        lbllibraryManagement.setForeground(new Color(0, 0, 105));
        lbllibraryManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        lbllibraryManagement.setBounds(240, 50, 200, 40);
        panel.add(lbllibraryManagement); // CHANGE: Add to the white panel

        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130, 135, 300, 25);
        panel.add(progressBar); // CHANGE: Add to the white panel

        JLabel lblNewLabel_2 = new JLabel("Please Wait...");
        lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        // CHANGE: Set a dark color to be visible on the white panel
        lblNewLabel_2.setForeground(Color.BLACK);
        lblNewLabel_2.setBounds(225, 165, 200, 20);
        panel.add(lblNewLabel_2); // CHANGE: Add to the white panel
        
        JLabel lblusername = new JLabel("Welcome To E-Seva " + username);
        lblusername.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        // CHANGE: Set a dark color to be visible on the white panel
        lblusername.setForeground(new Color(0, 0, 105));
        // This line will move the text to the bottom left
        lblusername.setBounds(20, 310, 440, 40);
        panel.add(lblusername); // CHANGE: Add to the white panel

        // Start the progress bar animation
        startLoading();
    }

    private void startLoading() {
        timer = new Timer(50, e -> {
            int progress = progressBar.getValue();
            progress++;
            if (progress <= 100) {
                progressBar.setValue(progress);
            } else {
                timer.stop();
                dispose(); // Closes the frame
                new DashBoard(username).setVisible(true);
            }
        });
        timer.start();
    }
}