/*
 *View_DataBase.java - To view all the database details including table both the table details and download a nicely formed text file of details.
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class View_DataBase implements ActionListener
{
	JFrame f;
	JLabel l1;
	JButton b1,b2,b3,b4;
	JScrollPane sp;
	JTable t;
	View_DataBase()
	{
		f=new JFrame("View DataBase");
		f.setSize(900,600);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.getContentPane().setBackground(Color.DARK_GRAY);
		f.setResizable(false);
		
		l1=new JLabel("  MUNICIPAL DATA MANAGEMENT SYSTEM ");
		l1.setBounds(20,0,840,100);
		l1.setFont(new Font("Times New Roman",Font.BOLD,38));
		l1.setForeground(Color.YELLOW);
		f.add(l1);
		
		b1=new JButton("ADMIN DATABASE");
		b1.setBounds(150,125,275,35);
		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.setFont(new Font("Times New Roman",Font.BOLD,20));
		b1.setForeground(Color.YELLOW);
		b1.setBackground(Color.GRAY);
		b1.addActionListener(this);
		f.add(b1);
		
		b2=new JButton("MUNICIPAL DATABASE");
		b2.setBounds(450,125,275,35);
		b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.setFont(new Font("Times New Roman",Font.BOLD,20));
		b2.setForeground(Color.YELLOW);
		b2.setBackground(Color.GRAY);
		b2.addActionListener(this);
		f.add(b2);
		
		b3=new JButton("PRINT");
		b3.setBounds(150,505,275,35);
		b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b3.setFont(new Font("Times New Roman",Font.BOLD,20));
		b3.setForeground(Color.YELLOW);
		b3.setBackground(Color.GRAY);
		b3.addActionListener(this);
		f.add(b3);
		
		b4=new JButton("BACK");
		b4.setBounds(450,505,275,35);
		b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b4.setFont(new Font("Times New Roman",Font.BOLD,20));
		b4.setForeground(Color.YELLOW);
		b4.setBackground(Color.GRAY);
		b4.addActionListener(this);
		f.add(b4);
		
		sp=new JScrollPane();
		sp.getViewport().setBackground(Color.BLACK);
		sp.setBounds(20,185,840,300);
		f.add(sp);
		
		f.setVisible(true);
	}
	public static void main(String[] args) 
	{
		new View_DataBase();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b2)
		{
			try
			{
				Main c1=new Main();
				String str1="select count(*) from municipal_data";
				ResultSet rs1=c1.s.executeQuery(str1);
				int row=0;
				if(rs1.next())
					row=Integer.parseInt(rs1.getString("count(*)"));
				String columnName[]={"ID","Name","Gender","D.O,B.","Occupation","Family","Address","D.O.D.","Status","Place"};
				String data[][]=new String[row][10];
				String str2="select * from municipal_data";
				ResultSet rs2=c1.s.executeQuery(str2);
				int i=0;
				while(rs2.next())
				{
					data[i][0]=rs2.getString("id");
					data[i][1]=rs2.getString("username");
					data[i][2]=rs2.getString("gender");
					data[i][3]=rs2.getString("dob");
					data[i][4]=rs2.getString("occupation");
					data[i][5]=rs2.getString("family");
					data[i][6]=rs2.getString("address");
					data[i][7]=rs2.getString("dod");
					data[i][8]=rs2.getString("status");
					data[i][9]=rs2.getString("place");
					i=i+1;
				}
				t=new JTable(data,columnName)
				{
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row,int column)
					{
						return(false);
					}
				};
				t.setBackground(Color.WHITE);
				sp.setVisible(false);
				sp=new JScrollPane(t);
				sp.setBounds(20,185,840,300);
				f.add(sp);
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==b1)
		{
			try
			{
				Main c1=new Main();
				String str1="select count(*) from login_table";
				ResultSet rs1=c1.s.executeQuery(str1);
				int row=0;
				if(rs1.next())
					row=Integer.parseInt(rs1.getString("count(*)"));
				String columnName[]={"Username","Password"};
				String data[][]=new String[row][2];
				String str2="select * from login_table";
				ResultSet rs2=c1.s.executeQuery(str2);
				int i=0;
				while(rs2.next())
				{
					data[i][0]=rs2.getString("username");
					data[i][1]=rs2.getString("password");
					i=i+1;
				}
				t=new JTable(data,columnName)
				{
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row,int column)
					{
						return(false);
					}
				};
				t.setBackground(Color.WHITE);
				sp.setVisible(false);
				sp=new JScrollPane(t);
				sp.setBounds(20,185,840,300);
				f.add(sp);
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==b3)
		{
			if(t==null)
				JOptionPane.showMessageDialog(null,"Cannot Export");
			else
			{
				if(t.getColumnCount()==2)
				{
					File f1=new File("C:\\Users\\Rahul Jha\\Desktop\\Admin_DataBase.txt");
					try
					{
					FileWriter fw=new FileWriter(f1.getAbsoluteFile());
					BufferedWriter bw=new BufferedWriter(fw);
					
					for(int i=0;i<t.getRowCount();i++)
					{
						for(int j=0;j<t.getColumnCount();j++)
						{
							bw.write((String)(t.getModel().getValueAt(i,j)+" "));
						}
						bw.write("\n_____________________\n");
					}
					bw.close();
					fw.close();
					JOptionPane.showMessageDialog(null,"Data Exported To Desktop");
					}
					catch(Exception e2)
					{
						e2.printStackTrace();
					}
				}
				else
				{
					File f2=new File("C:\\Users\\Rahul Jha\\Desktop\\Municipal_DataBase.txt");
					try
					{
					FileWriter fw=new FileWriter(f2.getAbsoluteFile());
					BufferedWriter bw=new BufferedWriter(fw);
					
					for(int i=0;i<t.getRowCount();i++)
					{
						for(int j=0;j<t.getColumnCount();j++)
						{
							bw.write((String)(t.getModel().getValueAt(i,j)+" "));
						}
						bw.write("\n_____________________\n");
					}
					bw.close();
					fw.close();
					JOptionPane.showMessageDialog(null,"Data Exported To Desktop");
					}
					catch(Exception e2)
					{
						e2.printStackTrace();
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
}