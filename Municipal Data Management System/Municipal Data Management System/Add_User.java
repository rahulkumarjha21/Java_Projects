/*
 *Add_User.java - To add new person details and generate Unique ID by the system from the background using which all the task for using to be executed and details to displayed and implemented.
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
public class Add_User implements ActionListener
{
	JFrame f;
	JLabel l1,l2,l3,l4,l,l5,l6,l7,l8;
	JTextField t1,t2,t3;
	JRadioButton r1,r2,r3,r4,r5;
	JComboBox day,month,year;
	JButton b1,b2;
	Add_User()
	{
		f=new JFrame(" Add User ");
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
		
		l3=new JLabel(" USER REGISTRATION ");
		l3.setBounds(0,0,700,75);
		l3.setFont(new Font("Times New Roman",Font.BOLD,30));
		l3.setForeground(Color.WHITE);
		l3.setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
		l2.add(l3);
		
		l4=new JLabel("Name:");
		l4.setBounds(100,100,80,25);
		l4.setFont(new Font("Times New Roman",Font.BOLD,20));
		l4.setForeground(Color.WHITE);
		l2.add(l4);
		
		t1=new JTextField();
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
		r1.setSelected(true);
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
		
		l6=new JLabel("Occupation:");
		l6.setBounds(100,205,140,25);
		l6.setFont(new Font("Times New Roman",Font.BOLD,20));
		l6.setForeground(Color.WHITE);
		l2.add(l6);
		
		t2=new JTextField();
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
		g2.add(r4);
		g2.add(r5);
		r4.setSelected(true);
		l2.add(r4);
		l2.add(r5);
		
		l8=new JLabel("Address:");
		l8.setBounds(100,275,105,25);
		l8.setFont(new Font("Times New Roman",Font.BOLD,20));
		l8.setForeground(Color.WHITE);
		l2.add(l8);
		
		t3=new JTextField();
		t3.setBounds(275,275,300,25);
		t3.setFont(new Font("Times New Roman",Font.PLAIN,20));
		t3.setForeground(Color.WHITE);
		t3.setForeground(Color.BLACK);
		l2.add(t3);
		
		b1=new JButton("SUBMIT");
		b1.setBounds(290,320,120,25);
		b1.setFont(new Font("Times New Roman",Font.BOLD,20));
		b1.setForeground(Color.YELLOW);
		b1.setBackground(Color.GRAY);
		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(this);
		l2.add(b1);
		
		b2=new JButton("BACK");
		b2.setBounds(440,320,120,25);
		b2.setFont(new Font("Times New Roman",Font.BOLD,20));
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
						JOptionPane.showMessageDialog(null,"Address Is Empty");
					else
					{
						int id=10001;
						String str="";
						try
						{
							name=name.trim();
							occupation=occupation.trim();
							address=address.trim();
							Main cc=new Main();
							String str1="select count(*) from municipal_data";
							ResultSet rs1=cc.s.executeQuery(str1);
							if(rs1.next())
								str=id+Integer.parseInt(rs1.getString("count(*)"))+"";
							String str2="insert into municipal_data values('"+str+"','"+name+"','"+gender+"','"+dob+"','"+occupation+"','"+family+"','"+address+"','','Alive','')";
							cc.s.executeUpdate(str2);
							JOptionPane.showMessageDialog(null,"Insertation Sucessful, ID No.: "+str);
							new Menu_Page();
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
			new Menu_Page();
			f.dispose();
		}
	}
	public static void main(String[] args) 
	{
		new Add_User();
	}
}