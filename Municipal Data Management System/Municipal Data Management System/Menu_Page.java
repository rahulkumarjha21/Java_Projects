/*
 *Menu_Page.java - It is Administrator Menu Page where we get the following functionality such as, Add New User, Add To Death List, Update User Details, View DataBase, View Person Status and Add Admin User.
 *Author: Rahul Kumar Jha, 
 *Regd. No.-1941012186
 *Section- C.S.E.-'C'
 *Date Of Editing- 14 February, 2021
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Menu_Page implements ActionListener
{
	JFrame f;
	JLabel l1,l2,l3;
	JButton b,b1,b2,b3,b4,b5,b6;
	Menu_Page()
	{
		f=new JFrame(" Menu ");
		f.setResizable(false);
		f.setLayout(null);
		f.setSize(800,600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.getContentPane().setBackground(Color.DARK_GRAY);
		
		l1=new JLabel(" MUNICIPAL DATA MANAGEMENT SYSTEM");
		l1.setBounds(20,0,740,100);
		l1.setFont(new Font("Times New Roman",Font.BOLD,34));
		l1.setForeground(Color.YELLOW);
		f.add(l1);
		
		l2=new JLabel();
		l2.setBounds(40,100,700,400);
		l2.setFont(new Font("Times New Roman",Font.BOLD,20));
		l2.setForeground(Color.YELLOW);
		l2.setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
		f.add(l2);
		
		l3=new JLabel(" ADMIN MENU ");
		l3.setBounds(0,0,700,75);
		l3.setFont(new Font("Times New Roman",Font.BOLD,30));
		l3.setForeground(Color.WHITE);
		l3.setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
		l2.add(l3);
		
		b=new JButton("LOGOUT");
		b.setBounds(555,25,125,30);
		b.setFont(new Font("Times New Roman",Font.BOLD,20));
		b.setForeground(Color.YELLOW);
		b.setBackground(Color.GRAY);
		b.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b.addActionListener(this);
		l3.add(b);
		
		b1=new JButton("NEW REGISTRATION");
		b1.setBounds(80,130,240,50);
		b1.setFont(new Font("Times New Roman",Font.BOLD,20));
		b1.setForeground(Color.YELLOW);
		b1.setBackground(Color.GRAY);
		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(this);
		l2.add(b1);
		
		b2=new JButton("ADD TO DEATH LIST");
		b2.setBounds(375,130,240,50);
		b2.setFont(new Font("Times New Roman",Font.BOLD,20));
		b2.setForeground(Color.YELLOW);
		b2.setBackground(Color.GRAY);
		b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.addActionListener(this);
		l2.add(b2);
		
		b3=new JButton("UPDATE DETAILS");
		b3.setBounds(80,210,240,50);
		b3.setFont(new Font("Times New Roman",Font.BOLD,20));
		b3.setForeground(Color.YELLOW);
		b3.setBackground(Color.GRAY);
		b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b3.addActionListener(this);
		l2.add(b3);
		
		b4=new JButton("VIEW DATABASE");
		b4.setBounds(375,210,240,50);
		b4.setFont(new Font("Times New Roman",Font.BOLD,20));
		b4.setForeground(Color.YELLOW);
		b4.setBackground(Color.GRAY);
		b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b4.addActionListener(this);
		l2.add(b4);
		
		b5=new JButton("VIEW DETAILS");
		b5.setBounds(80,290,240,50);
		b5.setFont(new Font("Times New Roman",Font.BOLD,20));
		b5.setForeground(Color.YELLOW);
		b5.setBackground(Color.GRAY);
		b5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b5.addActionListener(this);
		l2.add(b5);
		
		b6=new JButton("ADMIN REGISTER");
		b6.setBounds(375,290,240,50);
		b6.setFont(new Font("Times New Roman",Font.BOLD,20));
		b6.setForeground(Color.YELLOW);
		b6.setBackground(Color.GRAY);
		b6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b6.addActionListener(this);
		l2.add(b6);
		
		f.setVisible(true);
	}
	public static void main(String[] args) 
	{
		new Menu_Page();
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b)
			new Admin_Login();
	    else if(e.getSource()==b1)
			new Add_User();
		else if(e.getSource()==b2)
			new Death_Page();
		else if(e.getSource()==b3)
			new Search_Page();
		else if(e.getSource()==b4)
			new View_DataBase();
		else if(e.getSource()==b6)
			new Add_Admin();
		else
			new User_Login(1);
		f.dispose();
	}
}