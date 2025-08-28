package Eseva;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class DashBoard extends JFrame implements ActionListener {
    
    String username ;
   JButton ALabourd,LView,update,about,delete,use;
    DashBoard(String username){ 
        this.username = username;
//       setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
//	setVisible(true);
//        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground (new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home7.jpg"));
        Image i2 = i1.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel icon = new JLabel(i3);
	icon.setBounds(5, 0, 70, 70); 
        add(icon);

        JLabel heading = new JLabel("DashBoard");
        heading.setBounds(100,5,300,40);
        heading.setFont(new Font("Tahoma", Font.BOLD,30));
        heading.setForeground(Color.white);
        p1.add(heading);
        
        JLabel image = new JLabel("E-seva");
        image.setBounds(0,5,300,40);
        image.setForeground(new Color(0,0,200));
        image.setFont(new Font("Railway", Font.ROMAN_BASELINE,30));
        p1.add(image);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground (new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);
        
         ALabourd = new JButton ("Add Worker Details");
        ALabourd.setBounds(0,0,300,60);
        ALabourd.setBackground (new Color (0,0,102));
        ALabourd.setForeground(Color.WHITE);
        ALabourd.setFont((new Font("Tahoma",Font.PLAIN,20)));
        ALabourd.setMargin(new Insets(0,0,0,65) );
        ALabourd.addActionListener(this);
        p2.add(ALabourd);
        
         update = new JButton ("Update Worker Details");
        update.setBounds(0,100,300,60);
        update.setBackground (new Color (0,0,102));
        update.setForeground(Color.WHITE);
        update.setFont((new Font("Tahoma",Font.PLAIN,20)));
        update.setMargin(new Insets(0,0,0,40) );
        update.addActionListener(this);
        p2.add(update);
        
         LView  = new JButton ("View Worker Details");
        LView.setBounds(0,200,305,60);
        LView.setBackground (new Color (0,0,102));
        LView.setForeground(Color.WHITE);
        LView.setFont((new Font("Tahoma",Font.PLAIN,20)));
        LView.setMargin(new Insets(0,0,0,65) );
        LView.addActionListener(this);
        p2.add(LView);
             
         delete  = new JButton ("Delete Account");
        delete.setBounds(0,400,300,50);
        delete.setBackground (new Color (0,0,102));
        delete.setForeground(Color.WHITE);
        delete.setFont((new Font("Tahoma",Font.PLAIN,20)));
        delete.setMargin(new Insets(0,0,0,40) );
        delete.addActionListener(this);
        p2.add(delete);
//        
//        JButton contracter  = new JButton ("Add Contracter Details");
//        contracter.setBounds(0,205,325,55);
//        contracter.setBackground (new Color (0,0,102));
//        contracter.setForeground(Color.WHITE);
//        contracter.setFont((new Font("Tahoma",Font.PLAIN,20)));
//        contracter.setMargin(new Insets(0,0,0,60) );
//        p2.add(contracter);
        
//         JButton Cupdate   = new JButton ("Update Contracter Details");
//        Cupdate.setBounds(0,255,325,55);
//        Cupdate.setBackground (new Color (0,0,102));
//        Cupdate.setForeground(Color.WHITE);
//        Cupdate.setFont((new Font("Tahoma",Font.PLAIN,20)));
//        Cupdate.setMargin(new Insets(0,0,0,35) );
////        Cupdate.addActionListener(this);
//        p2.add(Cupdate);
        
//        JButton cview   = new JButton ("View Contracter Details");
//        cview.setBounds(0,305,325,55);
//        cview.setBackground (new Color (0,0,102));
//        cview.setForeground(Color.WHITE);
//        cview.setFont((new Font("Tahoma",Font.PLAIN,20)));
//        cview.setMargin(new Insets(0,0,0,50) );
//        p2.add(cview);
        
//        JButton cdelete   = new JButton ("Delete Contracter Details");
//        cdelete.setBounds(0,355,325,55);
//        cdelete.setBackground (new Color (0,0,102));
//        cdelete.setForeground(Color.WHITE);
//        cdelete.setFont((new Font("Tahoma",Font.PLAIN,20)));
//        cdelete.setMargin(new Insets(0,0,0,40) );
//        p2.add(cdelete);
        
           about   = new JButton ("About");
        about.setBounds(45,600,200,50);
        about.setBackground (new Color (0,0,102));
        about.setForeground(Color.WHITE);
        about.setFont((new Font("Tahoma",Font.PLAIN,20)));
        about.setMargin(new Insets(0,0,0,0) );
        about.addActionListener(this);
        p2.add(about);
        
          use   = new JButton ("Display Worker Details");
        use.setBounds(0,300,300,60);
        use.setBackground (new Color (0,0,102));
        use.setForeground(Color.WHITE);
        use.setFont((new Font("Tahoma",Font.PLAIN,20)));
        use.setMargin(new Insets(0,0,0,40) );
        use.addActionListener(this);
        p2.add(use);
        
         JLabel Text = new JLabel("Thanks For Visiting");
        Text.setBounds(0,670,350,70);
        Text.setForeground(Color.white);
        p2.add(Text);
        
//        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/homew.jpg"));
//        Image i5 = i4.getImage().getScaledInstance(1200, 600,Image.SCALE_DEFAULT);
//        ImageIcon i6 = new ImageIcon(i5); 
//	JLabel NewLabel = new JLabel(i6);
//	NewLabel.setBounds(0, 0, 1650, 1000); 
//        add(NewLabel);
        
        ImageIcon i9 = new ImageIcon(ClassLoader.getSystemResource("icons/12.jpg"));
        Image i7 = i9.getImage().getScaledInstance(1650, 1000,Image.SCALE_DEFAULT);
        ImageIcon i8 = new ImageIcon(i7); 
	JLabel NewLabel = new JLabel(i8);
	NewLabel.setBounds(0, 0, 1650, 1000); 
        add(NewLabel);
        
        JLabel Text1 = new JLabel("E-seva kendra");
        Text1.setBounds(400,70,700,80);
        Text1.setForeground(Color.white);
        Text1.setFont(new Font("Rilway", Font.BOLD,100));
        NewLabel.add(Text1);
            
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== ALabourd){
        new AddLabour(username).setVisible(true);
        }
    else if (ae.getSource()== LView ){
      new ViewLabour(username).setVisible(true);
    }
    else if (ae.getSource() == update ){
        new UpdateLabour(username).setVisible(true);
    }else if (ae.getSource() == about ){
        new About().setVisible(true);
    } 
    else if (ae.getSource() == delete){
        new Delete(username).setVisible(true);
        
    }  else if (ae.getSource() == use){
        new Display().setVisible(true);
    } 
}

    public static void main(String[] args) {
        new DashBoard("username").setVisible(true);
    }
}