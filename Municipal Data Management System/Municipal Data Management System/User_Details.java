/*
 *User_Details.java - To fetch and display all the details of the database of the particular person from the database.
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
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class User_Details implements ActionListener
{
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l;
	JButton b1,b2;
	JRadioButton r1,r2,r3,r4,r5;
	String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
	JTextField t1,t2,t3;
	int c;
	User_Details(String id,int c)
	{
		this.c=c;
		
		f=new JFrame(" View Details ");
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
		l2.setBounds(40,100,700,425);
		l2.setFont(new Font("Times New Roman",Font.BOLD,20));
		l2.setForeground(Color.YELLOW);
		l2.setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
		f.add(l2);
		
		l3=new JLabel(" VIEW DETAILS ");
		l3.setBounds(0,0,700,75);
		l3.setFont(new Font("Times New Roman",Font.BOLD,30));
		l3.setForeground(Color.WHITE);
		l3.setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
		l2.add(l3);
		
		try
		{
			Main c1=new Main();
			String str="select * from municipal_data where id = '"+id+"'";
			ResultSet rs=c1.s.executeQuery(str);
			if(rs.next())
			{
				s1=rs.getString("id");
				s2=rs.getString("username");
				s3=rs.getString("gender");
				s4=rs.getString("dob");
				s5=rs.getString("occupation");
				s6=rs.getString("family");
				s7=rs.getString("address");
				s8=rs.getString("dod");
				s9=rs.getString("status");
				s10=rs.getString("place");
				
				l3=new JLabel(" I.D. No. : "+s1);
				l3.setBounds(450,0,700,75);
				l3.setFont(new Font("Times New Roman",Font.BOLD,30));
				l3.setForeground(Color.WHITE);
				l2.add(l3);
				
				l4=new JLabel("Name:");
				l4.setBounds(185,100,80,25);
				l4.setFont(new Font("Times New Roman",Font.BOLD,20));
				l4.setForeground(Color.WHITE);
				l2.add(l4);
						
				l5=new JLabel(s2);
				l5.setBounds(360,100,300,25);
				l5.setFont(new Font("Times New Roman",Font.BOLD,20));
				l5.setForeground(Color.WHITE);
				l2.add(l5);
						
				l6=new JLabel("Gender:");
				l6.setBounds(185,135,95,25);
				l6.setFont(new Font("Times New Roman",Font.BOLD,20));
				l6.setForeground(Color.WHITE);
				l2.add(l6);
						
				l7=new JLabel(s3);
				l7.setBounds(360,135,300,25);
				l7.setFont(new Font("Times New Roman",Font.BOLD,20));
				l7.setForeground(Color.WHITE);
				l2.add(l7);

				
				l8=new JLabel("Date Of Birth:");
				l8.setBounds(185,170,160,25);
				l8.setFont(new Font("Times New Roman",Font.BOLD,20));
				l8.setForeground(Color.WHITE);
				l2.add(l8);
				
				l9=new JLabel(s4);
				l9.setBounds(360,170,300,25);
				l9.setFont(new Font("Times New Roman",Font.BOLD,20));
				l9.setForeground(Color.WHITE);
				l2.add(l9);
				
				l10=new JLabel("Occupation:");
				l10.setBounds(185,205,140,25);
				l10.setFont(new Font("Times New Roman",Font.BOLD,20));
				l10.setForeground(Color.WHITE);
				l2.add(l10);
				
				l11=new JLabel(s5);
				l11.setBounds(360,205,300,25);
				l11.setFont(new Font("Times New Roman",Font.BOLD,20));
				l11.setForeground(Color.WHITE);
				l2.add(l11);
				
				l12=new JLabel("Family Type:");
				l12.setBounds(185,240,150,25);
				l12.setFont(new Font("Times New Roman",Font.BOLD,20));
				l12.setForeground(Color.WHITE);
				l2.add(l12);
				
				l13=new JLabel(s6);
				l13.setBounds(360,240,300,25);
				l13.setFont(new Font("Times New Roman",Font.BOLD,20));
				l13.setForeground(Color.WHITE);
				l2.add(l13);
				
				l14=new JLabel("Address:");
				l14.setBounds(185,275,105,25);
				l14.setFont(new Font("Times New Roman",Font.BOLD,20));
				l14.setForeground(Color.WHITE);
				l2.add(l14);
				
				l15=new JLabel(s7);
				l15.setBounds(360,275,300,25);
				l15.setFont(new Font("Times New Roman",Font.BOLD,20));
				l15.setForeground(Color.WHITE);
				l2.add(l15);
				
				if(s9.equals("Dead"))
				{
					l16=new JLabel("Date Of Death:");
					l16.setBounds(185,310,160,25);
					l16.setFont(new Font("Times New Roman",Font.BOLD,20));
					l16.setForeground(Color.WHITE);
					l2.add(l16);
					
					l17=new JLabel(s8);
					l17.setBounds(360,310,300,25);
					l17.setFont(new Font("Times New Roman",Font.BOLD,20));
					l17.setForeground(Color.WHITE);
					l2.add(l17);
					
					l18=new JLabel("Place Of Death:");
					l18.setBounds(185,340,160,25);
					l18.setFont(new Font("Times New Roman",Font.BOLD,20));
					l18.setForeground(Color.WHITE);
					l2.add(l18);
					
					l19=new JLabel(s10);
					l19.setBounds(360,340,300,25);
					l19.setFont(new Font("Times New Roman",Font.BOLD,20));
					l19.setForeground(Color.WHITE);
					l2.add(l19);
				}
				
				
				b1=new JButton("DOWNLOAD");
				b1.setBounds(150,375,175,25);
				b1.setFont(new Font("Times New Roman",Font.BOLD,20));
				b1.setForeground(Color.YELLOW);
				b1.setBackground(Color.GRAY);
				b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
				b1.addActionListener(this);
				l2.add(b1);
				
				if(s9.equals("Alive"))
					b1.setVisible(false);
				
				b2=new JButton("BACK");
				b2.setBounds(360,375,175,25);
				b2.setFont(new Font("Times New Roman",Font.BOLD,20));
				b2.setForeground(Color.YELLOW);
				b2.setBackground(Color.GRAY);
				b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
				b2.addActionListener(this);
				l2.add(b2);
				
				f.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Invalid Response");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String args[])
	{
		new User_Details("",0);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b2)
		{
			new User_Login(c);
			f.dispose();
		}
		else
		{
			new Certificate(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,c);
			f.dispose();
		}
	}
}