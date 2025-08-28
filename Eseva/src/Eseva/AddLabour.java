package Eseva;


import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
public  class AddLabour extends JFrame implements ActionListener{
    
    
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1,t2,t3,t4,t5,t6,t7,t8;
        JComboBox comboBox,comboBox2;
        JRadioButton r1,r2;
        Choice c1;
        JLabel labelusername,labelname;
        JButton add,back;
        String username;
        
      
    
        
	

	      AddLabour(String username){
                  this.username = username;
                 
                		System.out.println(username);
                setBounds(450, 200, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		setLayout(null);
                getContentPane().setBackground(Color.white);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/ld.jpg"));
                Image i3 = i1.getImage().getScaledInstance(400, 550,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(450,0,400,550);
                add(l1);
		
		JLabel lblName = new JLabel("NEW LABOUR FORM");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(50, 0, 300, 25);
		add(lblName);
                
                JLabel l3 = new JLabel("Username :");
		l3.setBounds(30, 50, 150, 25);
		add(l3);
                
                labelusername = new JLabel();
		labelusername.setBounds(220, 50, 150, 25);
		add(labelusername);
                
                
//                
//                t7 = new JTextField();
//		t7.setBounds(220, 50, 150, 25);
//		contentPane.add(t7);
//		t7.setColumns(10);
                
                JLabel lblId = new JLabel("ID :");
		lblId.setBounds(30, 90, 150, 25);
		add(lblId);
                
                comboBox = new JComboBox(new String[] { "Aadhar Card", "Voter Id", "Driving license"});
		comboBox.setBounds(220, 90, 150, 25);
                comboBox.setBackground(Color.white);
		add(comboBox);
                
                JLabel l2 = new JLabel("Number :");
		l2.setBounds(30, 130, 150,25);
		add(l2);
                
                t1 = new JTextField();
		t1.setBounds(220, 130, 150, 25);
		add(t1);
		t1.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(30, 170, 150, 25);
		contentPane.add(lblName_1);
                
                labelname = new JLabel();
		labelname.setBounds(220, 170, 150, 25);
		contentPane.add(labelname);
                
		
//		t2 = new JTextField();
//		t2.setBounds(220, 170, 150, 25);
//		contentPane.add(t2);
//		t2.setColumns(10);

                
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(30, 210, 150, 25);
		add(lblGender);
                
                r1 = new JRadioButton("Male");
                r1.setFont(new Font("Raleway", Font.BOLD, 14));
                r1.setBackground(Color.WHITE);
                r1.setBounds(220, 210, 70, 25);
                add(r1);
                
                r2 = new JRadioButton("Female");
                r2.setFont(new Font("Raleway", Font.BOLD, 14));
                r2.setBackground(Color.WHITE);
                r2.setBounds(300, 210, 90, 25);
		add(r2);
                
                ButtonGroup bg = new ButtonGroup();
                bg.add(r1);
                bg.add(r2);
                
		JLabel lblCountry = new JLabel(" Emergency No:");
		lblCountry.setBounds(30, 250, 150, 25);
		add(lblCountry);
                
                t3 = new JTextField();
		t3.setBounds(220, 250, 150, 25);
		add(t3);
		t3.setColumns(10);
		
		JLabel lblReserveRoomNumber = new JLabel("Permanent Address :");
		lblReserveRoomNumber.setBounds(30, 290, 150, 25);
		add(lblReserveRoomNumber);
                
                t5 = new JTextField();
		t5.setBounds(220, 290, 150, 25);
		add(t5);
		t5.setColumns(10);
           	
		JLabel lblCheckInStatus = new JLabel("Phone :");
		lblCheckInStatus.setBounds(30, 330, 150,25);
		contentPane.add(lblCheckInStatus);
                
                t6 = new JTextField();
		t6.setBounds(220, 330, 150, 25);
		contentPane.add(t6);
		t6.setColumns(10);
		
		JLabel lblDeposite = new JLabel("Email :");
		lblDeposite.setBounds(30, 370, 150, 25);
		contentPane.add(lblDeposite);
		
		t8 = new JTextField();
		t8.setBounds(220, 370, 150, 25);
		contentPane.add(t8);
		t8.setColumns(10);
                
                JLabel lblprofession = new JLabel("Profession:");
		lblprofession.setBounds(30, 410, 150, 25);
		add(lblprofession);
                
                comboBox2 = new JComboBox(new String[] { "Painter ", "Carpenter ", "Plumber","Electrecian","Others" });
		comboBox2.setBounds(220, 410, 150, 25);
                comboBox2.setBackground(Color.white);
		add(comboBox2);
                
                add = new JButton("Add");
                add.setForeground(Color.white);
                add.setBackground(Color.black);
                add.setBounds(70,450,100,25);
                add.addActionListener(this);
                add(add);
                
                 back = new JButton("Back");
                back.setBackground(Color.black);
                back.setForeground(Color.white);
                back.setBounds(220,450,100,25);
                back.addActionListener(this);
                add(back);
                
                
                
                
                
                
                
                
		
		
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from signup1 where username = '"+username+"'");
                    while(rs.next()){
                        labelusername.setText(rs.getString("username"));  
                        labelname.setText(rs.getString("name"));
                    }
                }catch(Exception e){ 
                  e.printStackTrace();
                
        }
}
//        public void ActionPerform(ActionEvent ae){
//            if 
//         
//            
//        }
//       
              public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == add) {
        String radio = r1.isSelected() ? "Male" : "Female";
        
        // The SQL query with placeholders
        String query = "INSERT INTO customer(username, id, number, name, gender, emergency_no, address, phone, email, Profession) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        if (t1.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(null, "ID Number cannot be empty!");
    return; // Stop the method here
}
if (t6.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Phone Number cannot be empty!");
    return; // Stop the method here
}
// ... add more checks for other important fields ...
        try {
            Conn c = new Conn();
            PreparedStatement pstmt = c.c.prepareStatement(query);

            // Set the values for each placeholder
            pstmt.setString(1, labelusername.getText());
            pstmt.setString(2, (String) comboBox.getSelectedItem());
            pstmt.setString(3, t1.getText());
            pstmt.setString(4, labelname.getText());
            pstmt.setString(5, radio);
            pstmt.setString(6, t3.getText());
            pstmt.setString(7, t5.getText());
            pstmt.setString(8, t6.getText());
            pstmt.setString(9, t8.getText());
            pstmt.setString(10, (String) comboBox2.getSelectedItem());

            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Labour Details Added Successfully");
            setVisible(false);

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    } else if (ae.getSource() == back) {
        setVisible(false);
    }
}
              
        
              
              public static void main(String[] args) {
                new AddLabour("").setVisible(true);
	}
}
                
		
		

//		JButton btnNewButton = new JButton("Add");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//                            Conn c = new Conn();
//                            String radio = null;
//                            
//                            if(r1.isSelected()){ 
//                                radio = "Male";
//                            }
//                            else if(r2.isSelected()){ 
//                                radio = "Female";
//                            }
//                           
//                          
//                            try{
//	    			String s9 = t7.getText(); //username
//                                String s1 = (String)comboBox.getSelectedItem(); //id
//	    			String s2 =  t1.getText();//num
//	    			String s3 =  t2.getText();//name
//                                String s4 =  radio;       //radio
//	    			String s5 =  t3.getText();//emergency no
//	    			String s7 =  t5.getText();  //address
//                                String s8 =  t6.getText();//phone
//                                String s10 = t8.getText(); //email
//                                
//                                String q1 = "insert into customer values('"+s9+"','"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s7+"','"+s8+"','"+s10+"')";
//                                c.s.executeUpdate(q1);
//                                
//	    			JOptionPane.showMessageDialog(null, "Customer Added Successfully");
//                                setVisible(false);
//	    		}catch(SQLException e1){
//	    			System.out.println(e1.getMessage());
//	    		}
//		    		catch(NumberFormatException s){
//		    			JOptionPane.showMessageDialog(null, "Please enter a valid Number");
//			}
//			}
//               }//		});
////		btnNewButton.setBounds(100, 430, 120, 30);
////                btnNewButton.setBackground(Color.BLACK);
////                btnNewButton.setForeground(Color.WHITE);
////		contentPane.add(btnNewButton);
//		
//		JButton btnExit = new JButton("Back");
//		btnExit.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//                            setVisible(false);
//			}
//		}); 
//		btnExit.setBounds(260, 430, 120, 30);
//                btnExit.setBackground(Color.BLACK);
//                btnExit.setForeground(Color.WHITE);
//		contentPane.add(btnExit);
//                
//                getContentPane().setBackground(Color.WHITE);
//	}
//        
//        public void ActionPerform(ActionEvent ae){
//            
//        }
//}