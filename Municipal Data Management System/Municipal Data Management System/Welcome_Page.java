/*
 *Welcome_Page.java - It is the welcome screen of the project where option for both the login panels are provided and to be selected.
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
public class Welcome_Page implements ActionListener
{
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6;
	JButton b1,b2;
	Welcome_Page(int i)
	{
		f=new JFrame("Home");
		f.setResizable(false);
		f.setLayout(null);
		f.setSize(800,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.getContentPane().setBackground(Color.DARK_GRAY);
		
		l1=new JLabel(" MUNICIPAL DATA MANAGEMENT SYSTEM");
		l1.setBounds(20,0,740,100);
		l1.setFont(new Font("Times New Roman",Font.BOLD,34));
		l1.setForeground(Color.YELLOW);
		f.add(l1);
		
		l2=new JLabel();
		l2.setLayout(null);
		l2.setBounds(115,125,250,225);
		l2.setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
		f.add(l2);
		
		l3=new JLabel();
		l3.setLayout(null);
		l3.setBounds(420,125,250,225);
		l3.setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
		f.add(l3);
		
		l4=new JLabel(" ADMIN LOGIN ");
		l4.setBounds(0,0,250,50);
		l4.setFont(new Font("Times New Roman",Font.BOLD,32));
		l4.setForeground(Color.WHITE);
		l4.setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
		l2.add(l4);
		
		l5=new JLabel("   USER LOGIN");
		l5.setBounds(0,0,250,50);
		l5.setFont(new Font("Times New Roman",Font.BOLD,32));
		l5.setForeground(Color.WHITE);
		l5.setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
		l3.add(l5);
		
		b1=new JButton("CLICK HERE");
		b1.setBounds(25,150,200,50);
		b1.setBackground(Color.GRAY);
		b1.setForeground(Color.YELLOW);
		b1.setFont(new Font("Times New Roman",Font.BOLD,25));
		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(this);
		b1.setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
		l2.add(b1);
		
		b2=new JButton("CLICK HERE");
		b2.setBounds(25,150,200,50);
		b2.setBackground(Color.GRAY);
		b2.setForeground(Color.YELLOW);
		b2.setFont(new Font("Times New Roman",Font.BOLD,25));
		b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.addActionListener(this);
		b2.setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
		l3.add(b2);
		
		l6=new JLabel("BY:- RAHUL KUMAR JHA");
		l6.setLayout(null);
		l6.setBounds(275,400,400,40);
		l6.setForeground(Color.YELLOW);
		l6.setFont(new Font("Times New Roman",Font.BOLD,20));
		f.add(l6);
		
		f.setVisible(true);
		
		if(i==0)
		{
			while(true)
			{
				l1.setVisible(false);
				try
				{
					Thread.sleep(500);
				}
				catch(Exception e)
				{
					
				}
				l1.setVisible(true);
				try
				{
					Thread.sleep(500);
				}
				catch(Exception e)
				{
					
				}
			}
		}	
	}
	public void actionPerformed(ActionEvent e) 
	{
		f.dispose();
		if(e.getSource()==b1)
			 new Admin_Login();
		else
			new User_Login(0);
	}
	public static void main(String[] args) 
	{
		new Welcome_Page(0);
	}
}