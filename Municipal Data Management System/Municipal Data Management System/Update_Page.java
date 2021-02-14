/*
 *Update_Page.java  - To update user details present in the database.
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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class Update_Page implements ActionListener
{
	JFrame f;
	JLabel l1,l2,l3,l4,l,l5,l6,l7,l8,l9,l10,l11;
	JTextField t1,t2,t3,t4;
	JRadioButton r1,r2,r3,r4,r5;
	JComboBox day,month,year,day2,month2,year2;
	JButton b1,b2;
	String s1,s2,s3="",s4,s5,s6="",s7,s8,s9;
	Update_Page(String id)
	{
		f=new JFrame(" Update Details ");
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
		
		l3=new JLabel(" UPDATE DETAILS ");
		l3.setBounds(0,0,700,75);
		l3.setFont(new Font("Times New Roman",Font.BOLD,30));
		l3.setForeground(Color.WHITE);
		l3.setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
		l2.add(l3);
		
		l11=new JLabel(" I.D. No. : "+id);
		l11.setBounds(450,0,700,75);
		l11.setFont(new Font("Times New Roman",Font.BOLD,30));
		l11.setForeground(Color.WHITE);
		l2.add(l11);
		
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
				
				l4=new JLabel("Name:");
				l4.setBounds(100,100,80,25);
				l4.setFont(new Font("Times New Roman",Font.BOLD,20));
				l4.setForeground(Color.WHITE);
				l2.add(l4);
						
				t1=new JTextField(s2);
				t1.setBounds(275,100,300,25);
				t1.setFont(new Font("Times New Roman",Font.PLAIN,20));
				t1.setForeground(Color.WHITE);
				t1.setForeground(Color.BLACK);
				l2.add(t1);
						
				l=new JLabel("Gender:");
				l.setBounds(100,135,95,25);
				l.setFont(new Font("Times New Roman",Font.BOLD,20));
				l.setForeground(Color.WHITE);
				l2.add(l);
						
				ButtonGroup g1=new ButtonGroup();
				r1=new JRadioButton("Male");
			    r2=new JRadioButton("Female");
				r3=new JRadioButton("Others");
				r1.setBounds(275,135,75,25);
				r2.setBounds(360,135,75,25);
				r3.setBounds(445,135,75,25);
				if(s3.equals("Male"))
					r1.setSelected(true);
				else if(s3.equals("Female"))
					r2.setSelected(true);
				else if(s3.equals("Others"))
					r3.setSelected(true);
				g1.add(r1);;
				g1.add(r2);
				g1.add(r3);
				l2.add(r1);
				l2.add(r2);
				l2.add(r3);
				
				l5=new JLabel("Date Of Birth:");
				l5.setBounds(100,170,160,25);
				l5.setFont(new Font("Times New Roman",Font.BOLD,20));
				l5.setForeground(Color.WHITE);
				l2.add(l5);
				
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
				day.setBounds(275,170,50,25);
				month.setBounds(335,170,100,25);
				year.setBounds(445,170,65,25);
				l2.add(day);
				l2.add(month);
				l2.add(year);
				String str1[]=s4.split(" ");
				day.setSelectedItem(str1[0]);
				month.setSelectedItem(str1[1]);
				year.setSelectedItem(str1[2]);
				
				l6=new JLabel("Occupation:");
				l6.setBounds(100,205,140,25);
				l6.setFont(new Font("Times New Roman",Font.BOLD,20));
				l6.setForeground(Color.WHITE);
				l2.add(l6);
				
				t2=new JTextField(s5);
				t2.setBounds(275,205,300,25);
				t2.setFont(new Font("Times New Roman",Font.PLAIN,20));
				t2.setForeground(Color.WHITE);
				t2.setForeground(Color.BLACK);
				l2.add(t2);
				
				l7=new JLabel("Family Type:");
				l7.setBounds(100,240,150,25);
				l7.setFont(new Font("Times New Roman",Font.BOLD,20));
				l7.setForeground(Color.WHITE);
				l2.add(l7);
				
				ButtonGroup g2=new ButtonGroup();
				r4=new JRadioButton("Single");
				r5=new JRadioButton("Joint");
				r4.setBounds(275,240,75,25);
				r5.setBounds(360,240,75,25);
				if(s6.equals("Single"))
					r4.setSelected(true);
				else if(s6.equals("Joint"))
					r5.setSelected(true);
				g2.add(r4);
				g2.add(r5);
				l2.add(r4);
				l2.add(r5);
				
				l8=new JLabel("Address:");
				l8.setBounds(100,275,105,25);
				l8.setFont(new Font("Times New Roman",Font.BOLD,20));
				l8.setForeground(Color.WHITE);
				l2.add(l8);
				
				t3=new JTextField(s7);
				t3.setBounds(275,275,300,25);
				t3.setFont(new Font("Times New Roman",Font.PLAIN,20));
				t3.setForeground(Color.WHITE);
				t3.setForeground(Color.BLACK);
				l2.add(t3);
				
				if(s9.equals("Dead"))
				{
					l9=new JLabel("Date Of Death:");
					l9.setBounds(100,305,160,25);
					l9.setFont(new Font("Times New Roman",Font.BOLD,20));
					l9.setForeground(Color.WHITE);
					l2.add(l9);
					
					day2=new JComboBox(d);
					month2=new JComboBox(m);
					year2=new JComboBox(y);
					day2.setBounds(275,305,50,25);
					month2.setBounds(335,305,100,25);
					year2.setBounds(445,305,65,25);
					l2.add(day2);
					l2.add(month2);
					l2.add(year2);
					String str2[]=s8.split(" ");
					day2.setSelectedItem(str2[0]);
					month2.setSelectedItem(str2[1]);
					year2.setSelectedItem(str2[2]);
					
					l10=new JLabel("Place Of Death:");
					l10.setBounds(100,335,160,25);
					l10.setFont(new Font("Times New Roman",Font.BOLD,20));
					l10.setForeground(Color.WHITE);
					l2.add(l10);
					
					t4=new JTextField(s7);
					t4.setBounds(275,335,300,25);
					t4.setFont(new Font("Times New Roman",Font.PLAIN,20));
					t4.setForeground(Color.WHITE);
					t4.setForeground(Color.BLACK);
					l2.add(t4);
				}
				
				b1=new JButton("SUBMIT");
				b1.setBounds(290,375,120,25);
				b1.setFont(new Font("Times New Roman",Font.BOLD,20));
				b1.setForeground(Color.YELLOW);
				b1.setBackground(Color.GRAY);
				b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
				b1.addActionListener(this);
				l2.add(b1);
				
				b2=new JButton("BACK");
				b2.setBounds(440,375,120,25);
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
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			String name=t1.getText();
			if((name.trim()).equals(""))
				JOptionPane.showMessageDialog(null,"Name Is Empty");
			else
			{
				String gender="";
				if(r1.isSelected())
					gender="Male";
				else if(r2.isSelected())
					gender="Female";
				else if(r3.isSelected())
					gender="Others";
				String dob=day.getSelectedItem()+" "+month.getSelectedItem()+" "+year.getSelectedItem();
				String occupation=t2.getText();
				if((occupation.trim()).equals(""))
					JOptionPane.showMessageDialog(null,"Occupation Is Empty");
				else
				{
					String family="";
					if(r4.isSelected())
						family="Single";
					else if(r5.isSelected())
						family="Joint";
					String address=t3.getText();
					if((address.trim()).equals(""))
						JOptionPane.showMessageDialog(null,"Occupation Is Empty");
					else
					{
						try
						{
							Main c2=new Main();
							String str2;
							if(s9.equals("Dead"))
								str2="update municipal_data set username='"+name+"',gender='"+gender+"',dob='"+dob+"',occupation='"+occupation+"',family='"+family+"',address='"+address+"',dod='"+day2.getSelectedItem()+" "+month2.getSelectedItem()+" "+year2.getSelectedItem()+"' where id='"+s1+"'";
							else
								str2="update municipal_data set username='"+name+"',gender='"+gender+"',dob='"+dob+"',occupation='"+occupation+"',family='"+family+"',address='"+address+"' where id='"+s1+"'";
							c2.s.executeUpdate(str2);
							c2.s.executeUpdate(str2);
							JOptionPane.showMessageDialog(null,"Updation Sucessful, ID No.: "+s1);
							new Search_Page();
							f.dispose();
						}
						catch(Exception e1)
						{
							e1.printStackTrace();
						}
					}
						
				}
			}
		}
		else
		{
			new Search_Page();
			f.dispose();
		}
	}
	public static void main(String[] args) 
	{
		new Update_Page(null);
	}
}