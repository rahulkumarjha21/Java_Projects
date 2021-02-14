/*
 *Municipal Data Management System
 This project is a simple Municipal Data Management System. In this project you will be learning how 
 to add new person record to the database, how to generate a 5 digit unique ID for each person, how to 
 remove a person from active list to the dead person list if you are issuing death certificate, person 
 location in the given ward. Also, you will be implementing the following operations add, view, show 
 status, etc. The status will show all the details of the person including name, id, date of birth, 
 occupation, family type (single or joint).
 *First_Page.java - It is first page of the project which needed to be executed.
 *Author: Rahul Kumar Jha, 
 *Regd. No.-1941012186
 *Section- C.S.E.-'C'
 *Date Of Editing- 14 February, 2021
 */
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
public class First_Page 
{
	JFrame f;
	JLabel l1,l2,l3;
	JProgressBar p;
	First_Page()
	{
		f=new JFrame("Municipal Data Management System");
		f.setUndecorated(true);
		f.setSize(600,400);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.getContentPane().setBackground(Color.DARK_GRAY);
		
		l1=new JLabel(" MUNICIPAL DATA MANAGEMENT SYSTEM  ");
		l1.setBounds(20,0,600,100);
		l1.setFont(new Font("Times New Roman",Font.BOLD,26));
		l1.setForeground(Color.YELLOW);
		f.add(l1);
		
		l2=new JLabel("BY: RAHUL KUMAR JHA");
		l2.setBounds(185,125,250,100);
		l2.setFont(new Font("Times New Roman",Font.BOLD,20));
		l2.setForeground(Color.YELLOW);
		f.add(l2);
		
		l3=new JLabel("Loading 0 %");
		l3.setBounds(220,235,175,100);
		l3.setFont(new Font("Times New Roman",Font.BOLD,20));
		l3.setForeground(Color.YELLOW);
		f.add(l3);
		
		p=new JProgressBar();
		p.setBounds(18,310,550,25);
		p.setBackground(Color.GRAY);
		p.setForeground(Color.YELLOW);
		f.add(p);
		
		f.setVisible(true);
		
		try
		{
			for(int i=0;i<=100;i++)
			{
				p.setValue(i);
				Thread.sleep(50);
				l3.setText("Loading "+i+" %");
			}
			f.dispose();
			new Welcome_Page(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		new First_Page();
	}
}