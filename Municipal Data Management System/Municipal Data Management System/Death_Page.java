/*
 *Death_Page.java - To delete a person details from active list and add person to death list to generate death certificate.
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
public class Death_Page implements ActionListener
{
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2;
	JButton b1,b2,b3,b4;
	JComboBox day,month,year;
	Death_Page()
	{
		f=new JFrame("Death List Registration");
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
		
		l3=new JLabel(" DEATH LIST REGISTRATION ");
		l3.setBounds(0,0,700,75);
		l3.setFont(new Font("Times New Roman",Font.BOLD,30));
		l3.setForeground(Color.WHITE);
		l3.setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
		l2.add(l3);
		
		l4=new JLabel("U.I.D. No.-");
		l4.setBounds(180,100,100,25);
		l4.setFont(new Font("Times New Roman",Font.BOLD,20));
		l4.setForeground(Color.WHITE);
		l2.add(l4);
		
		t1=new JTextField();
		t1.setBounds(300,100,205,25);
		t1.setFont(new Font("Times New Roman",Font.BOLD,20));
		t1.setForeground(Color.WHITE);
		t1.setForeground(Color.BLACK);
		l2.add(t1);
		
		b1=new JButton("SUBMIT");
		b1.setBounds(300,145,100,25);
		b1.setFont(new Font("Times New Roman",Font.BOLD,15));
		b1.setForeground(Color.YELLOW);
		b1.setBackground(Color.GRAY);
		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(this);
		l2.add(b1);
		
		b2=new JButton("CANCEL");
		b2.setBounds(405,145,100,25);
		b2.setFont(new Font("Times New Roman",Font.BOLD,15));
		b2.setForeground(Color.YELLOW);
		b2.setBackground(Color.GRAY);
		b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.addActionListener(this);
		l2.add(b2);
		
		f.setVisible(true);
	}
	public static void main(String[] args) 
	{
		new Death_Page();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			try
			{
				Main c1=new Main();
				String str="select * from municipal_data where id = '"+t1.getText()+"'";
				ResultSet rs=c1.s.executeQuery(str);
				if(rs.next())
				{
					if(rs.getString("status").equals("Alive"))
					{
					l5=new JLabel("Name:");
					l5.setBounds(150,200,160,25);
					l5.setFont(new Font("Times New Roman",Font.BOLD,20));
					l5.setForeground(Color.WHITE);
					l2.add(l5);
					
					l6=new JLabel(rs.getString("username"));
					l6.setBounds(300,200,205,25);
					l6.setFont(new Font("Times New Roman",Font.BOLD,20));
					l6.setForeground(Color.WHITE);
					l2.add(l6);
					
					l7=new JLabel("Date Of Death:");
					l7.setBounds(150,230,160,25);
					l7.setFont(new Font("Times New Roman",Font.BOLD,20));
					l7.setForeground(Color.WHITE);
					l2.add(l7);
					
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
					day.setBounds(300,230,50,25);
					month.setBounds(355,230,100,25);
					year.setBounds(460,230,65,25);
					l2.add(day);
					l2.add(month);
					l2.add(year);
					
					l8=new JLabel("Place:");
					l8.setBounds(150,260,160,25);
					l8.setFont(new Font("Times New Roman",Font.BOLD,20));
					l8.setForeground(Color.WHITE);
					l2.add(l8);
					
					t2=new JTextField();
					t2.setBounds(300,260,225,25);
					t2.setFont(new Font("Times New Roman",Font.BOLD,15));
					t2.setForeground(Color.BLACK);
					l2.add(t2);
					
					b3=new JButton("SUBMIT");
					b3.setBounds(310,310,100,25);
					b3.setFont(new Font("Times New Roman",Font.BOLD,15));
					b3.setForeground(Color.YELLOW);
					b3.setBackground(Color.GRAY);
					b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
					b3.addActionListener(this);
					l2.add(b3);
					
					b4=new JButton("BACK");
					b4.setBounds(415,310,100,25);
					b4.setFont(new Font("Times New Roman",Font.BOLD,15));
					b4.setForeground(Color.YELLOW);
					b4.setBackground(Color.GRAY);
					b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
					b4.addActionListener(this);
					l2.add(b4);
					
					b1.setVisible(false);
					b2.setVisible(false);
					f.setVisible(false);
					f.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Already Registered");
						t1.setText("");
					}
						
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Login");
					t1.setText("");
				}
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==b3)
		{
			if((t2.getText().trim()).equals(""))
			{
				JOptionPane.showMessageDialog(null,"Place Of Death Is Empty");
			}
			else
			{
				try
				{
					Main c2=new Main();
					String str2="update municipal_data set dod='"+day.getSelectedItem()+" "+month.getSelectedItem()+" "+year.getSelectedItem()+"',status='Dead',place='"+t2.getText()+"' where id='"+t1.getText()+"'";
					c2.s.executeUpdate(str2);
					JOptionPane.showMessageDialog(null,"Insertation Sucessful In Death List");
					new Menu_Page();
					f.dispose();
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
			
		}
		else
		{
			new Menu_Page();
			f.dispose();
		}
	}
}
