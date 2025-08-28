package Eseva;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Display extends JFrame {
    
    JTable table;
    
    Display() {
        setTitle("All Worker Details");
        getContentPane().setBackground(Color.WHITE);
        setBounds(300, 150, 1050, 600); // Made it a bit wider for all columns
        setLayout(null);
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // CHANGE: Create a JScrollPane that will contain our table.
        JScrollPane scrollPane = new JScrollPane(table);
        
        // CHANGE: Set the position and size of the scrollPane.
        // The headers will appear automatically inside this area.
        scrollPane.setBounds(10, 10, 1000, 500);
        
        // CHANGE: Add the scrollPane to the frame.
        add(scrollPane);
        
        // CHANGE: All 10 of your manual JLabel headers have been removed.
        // The JScrollPane handles them for you!
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Display().setVisible(true);
    }
}