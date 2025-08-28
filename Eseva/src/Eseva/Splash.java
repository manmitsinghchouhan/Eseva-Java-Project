package Eseva;

import java.awt.*;
import javax.swing.*;

// The public class name now matches your filename "Splash.java"
public class Splash extends JFrame implements Runnable {

    // The main entry point for the application.
    public static void main(String[] args) {
        // Best practice: Create and show the GUI on the Event Dispatch Thread (EDT).
        SwingUtilities.invokeLater(() -> {
            // We create an instance of the Splash class here.
            new Splash().setVisible(true);
        });
    }

    // The constructor name must also match the class name.
    public Splash() {
        // --- Setting up the image and window ---
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash4.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imageLabel = new JLabel(i3);
        add(imageLabel);

        // Remove window borders
        setUndecorated(true);

        // This makes the window size exactly fit the image label inside it.
        pack();

        // Best practice: Center the frame dynamically on any screen.
        setLocationRelativeTo(null);

        // Start the thread that will run the animation and transition.
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            // --- Animation Part ---
            // Animate for a short duration (e.g., 1.5 seconds)
            for (int i = 0; i <= 100; i++) {
                // Calculate size based on a percentage (0 to 100%)
                int width = (int) (1100 * (i / 100.0));
                int height = (int) (600 * (i / 100.0));
                
                setSize(width, height);
                setLocationRelativeTo(null); // Keep it centered while growing
                Thread.sleep(15); // Pause for animation
            }

            // --- Delay Part ---
            // After animation, wait for a few more seconds.
            Thread.sleep(2000);

            // --- Transition Part ---
            setVisible(false); // Hide this splash screen
            new Login().setVisible(true); // Show the login screen
            dispose(); // Free up memory used by this window

        } catch (Exception e) {
            // Best practice: Always handle exceptions!
            e.printStackTrace();
        }
    }
}