package Eseva;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame implements ActionListener {

    public About() {
        setTitle("About E-Seva");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(700, 220, 500, 550);

        JLabel titleLabel = new JLabel("About Project");
        titleLabel.setBounds(170, 20, 180, 40);
        titleLabel.setForeground(Color.RED);
        titleLabel.setFont(new Font("RALEWAY", Font.BOLD, 20));
        add(titleLabel);

        String aboutText = "About Projects\n\n"
                + "E-SEWA is a revolutionary platform that connects construction contractors with skilled labours.\n"
                + "Our mission is to simplify the process of finding and hiring skilled workers for your construction projects.\n"
                + "As a team of experienced professionals in the construction industry, "
                + "we understand the challenges that contractors face when it comes "
                + "to finding reliable and qualified labour.\n\n"
                + "That's why we created E-SEWA – to bridge the gap between contractors and skilled workers. "
                + "With our user-friendly website, contractors can easily search for and contact skilled labours in their area, "
                + "while workers can showcase their skills and experience to potential employers.\n\n"
                + "Advantages of Project:\n"
                + "• Gives accurate information\n"
                + "• Simplifies the manual work\n"
                + "• It minimizes the documentation related work\n"
                + "• Provides up to date information\n"
                + "• Friendly Environment by providing warning messages.";

        // IMPROVEMENT: Use JTextArea for Swing consistency
        JTextArea textArea = new JTextArea(aboutText);
        textArea.setEditable(false);
        textArea.setLineWrap(true); // Makes text wrap to the next line
        textArea.setWrapStyleWord(true); // Wraps at word boundaries
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        // IMPROVEMENT: Place the JTextArea inside a JScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20, 100, 450, 300);
        add(scrollPane);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(180, 430, 120, 30);
        exitButton.addActionListener(this);
        add(exitButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // dispose() is the correct way to close the window
        dispose();
    }

    public static void main(String args[]) {
        new About();
    }
}