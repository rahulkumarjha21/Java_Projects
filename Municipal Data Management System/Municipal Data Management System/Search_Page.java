/*
 *Search_Page.java - To search user details using unique ID to update user details.
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
import javax.swing.JTextField;
public class Search_Page implements ActionListener
{
	JFrame f;
	JLabel l1,l2,l3,l4;
	JTextField t;
	JButton b1,b2;
	Search_Page()
	{
		f=new JFrame("Search User");
		f.setSize(500,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.getContentPane().setBackground(Color.DARK_GRAY);
		
		l1=new JLabel(" MUNICIPAL DATA MANAGEMENT SYSTEM  ");
		l1.setBounds(4,0,480,55);
		l1.setFont(new Font("Times New Roman",Font.BOLD,22));
		l1.setForeground(Color.YELLOW);
		f.add(l1);
		
		l2=new JLabel();
		l2.setBounds(25,60,435,177);
		l2.setFont(new Font("Times New Roman",Font.BOLD,20));
		l2.setForeground(Color.YELLOW);
		l2.setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
		f.add(l2);

		l3=new JLabel("SEARCH USER");
		l3.setBounds(0,0,435,30);
		l3.setFont(new Font("Times New Roman",Font.BOLD,20));
		l3.setForeground(Color.WHITE);
		l3.setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
		l2.add(l3);
		
		l4=new JLabel("ID NUMBER:");
		l4.setBounds(70,60,125,30);
		l4.setFont(new Font("Times New Roman",Font.BOLD,20));
		l4.setForeground(Color.WHITE);
		l2.add(l4);
		
		t=new JTextField();
		t.setBounds(200,60,175,30);
		t.setFont(new Font("Times New Roman",Font.BOLD,20));
		t.setForeground(Color.BLACK);
		l2.add(t);
		
		b1=new JButton("SUBMIT");
		b1.setBounds(200,105,85,25);
		b1.setFont(new Font("Times New Roman",Font.BOLD,13));
		b1.setForeground(Color.YELLOW);
		b1.setBackground(Color.GRAY);
		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(this);
		l2.add(b1);
		
		b2=new JButton("BACK");
		b2.setBounds(290,105,85,25);
		b2.setFont(new Font("Times New Roman",Font.BOLD,13));
		b2.setForeground(Color.YELLOW);
		b2.setBackground(Color.GRAY);
		b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.addActionListener(this);
		l2.add(b2);
		
		f.setVisible(true);
	}
	public static void main(String args[])
	{
		new Search_Page();
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			try
			{
				Main c1=new Main();
				String str="select * from municipal_data where id = '"+t.getText()+"'";
				ResultSet rs=c1.s.executeQuery(str);
				if(rs.next())
				{
					new Update_Page(t.getText());
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
		else
		{
			new Menu_Page();
		    f.dispose();
		}
	}
}