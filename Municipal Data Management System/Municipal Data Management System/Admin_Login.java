/*
 *Admin_Login.java - It is the login panel for the administrator where login credentials to be verified.
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Admin_Login implements ActionListener
{
	JFrame f;
	JLabel l1,l2,l3,l4,l5;
	JTextField t;
	JPasswordField p;
	JButton b1,b2;
	Admin_Login()
	{
		f=new JFrame("Admin Login");
		f.setSize(600,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.getContentPane().setBackground(Color.DARK_GRAY);
		
		l1=new JLabel(" MUNICIPAL DATA MANAGEMENT SYSTEM  ");
		l1.setBounds(20,0,600,100);
		l1.setFont(new Font("Times New Roman",Font.BOLD,26));
		l1.setForeground(Color.YELLOW);
		f.add(l1);
		
		l2=new JLabel();
		l2.setBounds(40,100,500,225);
		l2.setFont(new Font("Times New Roman",Font.BOLD,20));
		l2.setForeground(Color.YELLOW);
		l2.setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
		f.add(l2);
		
		l3=new JLabel(" ADMIN LOGIN ");
		l3.setBounds(0,0,500,50);
		l3.setFont(new Font("Times New Roman",Font.BOLD,25));
		l3.setForeground(Color.WHITE);
		l3.setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
		l2.add(l3);
		
		l4=new JLabel("USERNAME:");
		l4.setBounds(85,80,125,30);
		l4.setFont(new Font("Times New Roman",Font.BOLD,20));
		l4.setForeground(Color.WHITE);
		l2.add(l4);
		
		l5=new JLabel("PASSWORD:");
		l5.setBounds(85,120,125,30);
		l5.setFont(new Font("Times New Roman",Font.BOLD,20));
		l5.setForeground(Color.WHITE);
		l2.add(l5);
		
		t=new JTextField();
		t.setBounds(225,80,205,30);
		t.setFont(new Font("Times New Roman",Font.BOLD,15));
		t.setForeground(Color.BLACK);
		t.setBackground(Color.WHITE);
		l2.add(t);
		
		p=new JPasswordField();
		p.setBounds(225,120,205,30);
		p.setFont(new Font("Times New Roman",Font.BOLD,20));
		p.setForeground(Color.BLACK);
		p.setBackground(Color.WHITE);
		l2.add(p);
		
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
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==b1)
		{
			try
			{
				Main obj=new Main();
				String username=t.getText();
				String password=new String(p.getPassword());
				String str="select * from login_table where username='"+username+"' and password='"+password+"'";
				ResultSet rs=obj.s.executeQuery(str);
				if(rs.next())
				{
					new Menu_Page();
                    f.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Login");
					t.setText(null);
					p.setText(null);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			new Welcome_Page(1);
			f.dispose();
		}
		
	}
	public static void main(String[] args) 
	{
		new Admin_Login();
	}
}