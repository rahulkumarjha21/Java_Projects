/*
 *User_Login.java - It is a login page for user where login credentials to be verified with (Unique ID and Date of Birth).
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class User_Login implements ActionListener
{
	JFrame f;
	JLabel l1,l2,l3,l4,l5;
	JTextField t;
	JComboBox day,month,year;
	JButton b1,b2;
	int c=0;
	User_Login(int c)
	{
		this.c=c;
		
		f=new JFrame("User Login");
		f.setSize(600,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.getContentPane().setBackground(Color.DARK_GRAY);
		
		l1=new JLabel(" MUNICIPAL DATA MANAGEMENT SYSTEM  ");
		l1.setBounds(10,0,600,100);
		l1.setFont(new Font("Times New Roman",Font.BOLD,26));
		l1.setForeground(Color.YELLOW);
		f.add(l1);
		
		l2=new JLabel();
		l2.setBounds(40,100,500,225);
		l2.setFont(new Font("Times New Roman",Font.BOLD,20));
		l2.setForeground(Color.YELLOW);
		l2.setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
		f.add(l2);
		
		l3=new JLabel(" USER LOGIN ");
		l3.setBounds(0,0,500,50);
		l3.setFont(new Font("Times New Roman",Font.BOLD,25));
		l3.setForeground(Color.WHITE);
		l3.setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
		l2.add(l3);
		
		l4=new JLabel("ID NUMBER:");
		l4.setBounds(50,80,125,30);
		l4.setFont(new Font("Times New Roman",Font.BOLD,20));
		l4.setForeground(Color.WHITE);
		l2.add(l4);
		
		l5=new JLabel("DATE OF BIRTH:");
		l5.setBounds(50,120,160,30);
		l5.setFont(new Font("Times New Roman",Font.BOLD,20));
		l5.setForeground(Color.WHITE);
		l2.add(l5);
		
		t=new JTextField();
		t.setBounds(225,80,205,30);
		t.setFont(new Font("Times New Roman",Font.BOLD,15));
		t.setForeground(Color.BLACK);
		t.setBackground(Color.WHITE);
		l2.add(t);
		
		String d[]=new  String[31];
		for(int i=0,j=1;i<31;i++,j++)
			d[i]=j+"";
		String m[]= {"January","February","March","April","May","June","July","August","September","October","November","December"};
		String y[]=new String[121];
		for(int i=0,j=1901;i<121;i++,j++)
			y[i]=j+"";
		day=new JComboBox(d);
		month=new JComboBox(m);
		year=new JComboBox(y);
		day.setBounds(225,120,40,30);
		month.setBounds(270,120,90,30);
		year.setBounds(365,120,65,30);
		l2.add(day);
		l2.add(month);
		l2.add(year);
		
		b1=new JButton("SUBMIT");
		b1.setBounds(225,170,100,25);
		b1.setFont(new Font("Times New Roman",Font.BOLD,15));
		b1.setForeground(Color.YELLOW);
		b1.setBackground(Color.GRAY);
		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(this);
		l2.add(b1);
		
		b2=new JButton("BACK");
		b2.setBounds(330,170,100,25);
		b2.setFont(new Font("Times New Roman",Font.BOLD,15));
		b2.setForeground(Color.YELLOW);
		b2.setBackground(Color.GRAY);
		b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.addActionListener(this);
		l2.add(b2);
		
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			String username=t.getText().trim();
			if(username.equals(""))
				JOptionPane.showMessageDialog(null,"ID NUMBER is Empty");
			else
			{
				try
				{
					Main c1=new Main();
					String str="select * from municipal_data where id ='"+t.getText()+"' and dob='"+day.getSelectedItem()+" "+month.getSelectedItem()+" "+year.getSelectedItem()+"'";
					ResultSet rs=c1.s.executeQuery(str);
					if(rs.next())
					{
						new User_Details(t.getText(),c);
						f.dispose();
					}
					else
					{
						JOptionPane .showMessageDialog(null,"Invalid Login");
						t.setText("");
					}
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		}
		else
		{
			if(c==0)
			{
				new Welcome_Page(1);
				f.dispose();
			}
			else
			{
				new Menu_Page();
				f.dispose();
			}
		}
	}
	public static void main(String[] args) 
	{
		new User_Login(0);
	}
}