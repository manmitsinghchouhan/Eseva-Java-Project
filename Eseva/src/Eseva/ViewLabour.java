package Eseva;


import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import net.proteanit.sql.*;

//import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
public class ViewLabour extends JFrame implements ActionListener {
//	Connection conn = null;
//	private JPanel contentPane;
//	private JTable table;
//	private JLabel lblAvailability;
//	private JLabel lblCleanStatus;
//	private JLabel lblNewLabel;
//	private JLabel lblNewLabel_1;
//	private JLabel lblRoomNumber;
//	private JLabel lblId;
    JButton back;
    String username;
    

	
	public static void main(String[] args)  {
            
          new ViewLabour("n");
        }
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewCustomers frame = new ViewCustomers();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

        
	public ViewLabour(String username ) {
            this.username = username;
//                throws SQLException {
		//conn = Javaconnect.getDBConnection();
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(480, 180, 870, 625);
                getContentPane().setBackground(Color.WHITE);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
		setLayout(null);
                
                JLabel lblusername = new JLabel("Username:");
		lblusername.setBounds(30, 50, 150, 25);
		add(lblusername);
                
                JLabel labelusername = new JLabel();
		labelusername.setBounds(220, 50, 150, 25);
		add(labelusername);
              
                JLabel lblid = new JLabel("ID:");
		lblid.setBounds(30, 110, 150, 25);
		add(lblid);
                
                JLabel labelid = new JLabel();
		labelid.setBounds(220, 110, 150, 25);
		add(labelid);
                
                JLabel lblnum = new JLabel("Number:");
		lblnum.setBounds(30, 170, 150, 25);
		add(lblnum);
                
                JLabel labelnum = new JLabel();
		labelnum.setBounds(220, 170, 150, 25);
		add(labelnum);
                
                JLabel lblname = new JLabel("Name:");
		lblname.setBounds(30, 230, 150, 25);
		add(lblname);
                
                JLabel labelname = new JLabel();
		labelname.setBounds(220, 230, 150, 25);
		add(labelname);
                
                 JLabel lblgender = new JLabel("Gender:");
		lblgender.setBounds(30, 290, 150, 25);
		add(lblgender);
                
                JLabel labelgender = new JLabel();
		labelgender.setBounds(220, 290, 150, 25);
		add(labelgender);
                
                JLabel lblen = new JLabel("Emergency No:");
		lblen.setBounds(500, 50, 150, 25);
		add(lblen);
                
                JLabel labelen = new JLabel();
		labelen.setBounds(690, 50, 150, 25);
		add(labelen);
                
                JLabel lbladdress = new JLabel("Address:");
		lbladdress.setBounds(500, 110, 150, 25);
		add(lbladdress);
                
                JLabel labeladdress = new JLabel();
		labeladdress.setBounds(690, 110, 150, 25);
		add(labeladdress);
                
                 JLabel lblphone = new JLabel("Phone:");
		lblphone.setBounds(500, 170, 150, 25);
		add(lblphone);
                
                JLabel labelphone = new JLabel();
		labelphone.setBounds(690, 170, 150, 25);
		add(labelphone);
                
                JLabel lblemail = new JLabel("Email:");
		lblemail.setBounds(500, 230, 150, 25);
		add(lblemail);
                
                JLabel labelemail = new JLabel();
		labelemail.setBounds(690, 230, 150, 25);
		add(labelemail);
                
                  JLabel lblprofession = new JLabel("Profession:");
		lblprofession.setBounds(500, 290, 150, 25);
		add(lblprofession);
                
                JLabel labelprofession = new JLabel();
		labelprofession.setBounds(690, 290, 150, 25);
		add(labelprofession);
                
                back = new JButton("Back:");
                back.setBackground(Color.black);
                back.setForeground(Color.white);
                back.setBounds(350,350,100,25);
                back.addActionListener(this);
                add(back);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
                Image i3 = i1.getImage().getScaledInstance(600, 200,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(20,400,600,200);
                add(l1);
                
                
                ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
                Image i5 = i4.getImage().getScaledInstance(600, 200,Image.SCALE_DEFAULT);
                ImageIcon i6 = new ImageIcon(i5);
                JLabel l2 = new JLabel(i2);
                l2.setBounds(600,400,600,200);
                add(l2);
                
                // Replace the old try-catch block with this one
try {
    Conn conn = new Conn();
    // Use a '?' placeholder for the username
    String query = "select * from customer where username = ?";
    
    PreparedStatement pstmt = conn.c.prepareStatement(query);
    pstmt.setString(1, username); // Safely set the username value
    
    ResultSet rs = pstmt.executeQuery();
    
    if (rs.next()) { // Use 'if' instead of 'while' since you expect only one result
        labelusername.setText(rs.getString("username"));
        labelid.setText(rs.getString("id"));
        labelnum.setText(rs.getString("number"));
        labelname.setText(rs.getString("name"));
        labelgender.setText(rs.getString("gender"));
        labelen.setText(rs.getString("emergency_no"));
        labeladdress.setText(rs.getString("address"));
        labelphone.setText(rs.getString("phone"));
        labelemail.setText(rs.getString("Email"));
        labelprofession.setText(rs.getString("Profession"));
    } else {
        // Optional: Show a message if no customer details were found for that user
        JOptionPane.showMessageDialog(null, "No customer details found for username: " + username);
    }
} catch (Exception e) {
    e.printStackTrace();
}
                   
                
                
                
            setVisible(true);    
        }
        
         public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== back){
        setVisible(false);
        }
    }
}
                