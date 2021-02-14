/*
 *Certificate.java - To display death certificate a person and can be accessible to only those whose name are registered in death list.
 *Author: Rahul Kumar Jha, 
 *Regd. No.-1941012186
 *Section- C.S.E.-'C'
 *Date Of Editing- 14 February, 2021
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class Certificate implements ActionListener
{
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JPanel p;
	JButton b1,b2;
	JTextArea t1;
	int c;
	String s1;
	Certificate(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9,String s10,int c)
	{
		this.c=c;
		this.s1=s1;
		
		f=new JFrame(" Certificate ");
		f.setResizable(false);
		f.setLayout(null);
		f.setSize(1000,600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.getContentPane().setBackground(Color.DARK_GRAY);
		
		p=new JPanel();
		p.setLayout(null);
		p.setBounds(0,0,1000,500);
		p.setBorder(BorderFactory.createLineBorder(Color.WHITE));;
		p.setBackground(Color.BLACK);
		p.setLayout(null);
		f.add(p);

		l1=new JLabel("MUNICIPAL DATA MANAGEMENT SYSTEM");
		l1.setBounds(20,0,940,100);
		l1.setFont(new Font("Times New Roman",Font.BOLD,44));
		l1.setForeground(Color.YELLOW);
		p.add(l1);
		
		l2=new JLabel("DEATH CERTIFICATE");
		l2.setBounds(300,100,380,50);
		l2.setFont(new Font("Times New Roman",Font.BOLD,35));
		l2.setForeground(Color.YELLOW);
		p.add(l2);
		
		if((s1.trim()).equals(""))
		{
			JOptionPane.showMessageDialog(null,"Unable To Print");
		}
		else
		{
			l3=new JLabel(" * This is to acknowledge the death of "+s2+".");
			l3.setBounds(50,175,940,50);
			l3.setFont(new Font("Times New Roman",Font.BOLD,20));
			l3.setForeground(Color.WHITE);
			p.add(l3);
			
			String str1[]=s8.split(" ");
			String str2[]=s4.split(" ");
			
			l4=new JLabel(" * On the "+str1[0]+" Day of "+str1[1]+" in the Year "+str1[2]+".");
			l4.setBounds(50,225,940,50);
			l4.setFont(new Font("Times New Roman",Font.BOLD,20));
			l4.setForeground(Color.WHITE);
			p.add(l4);
			
			l5=new JLabel(" * At: "+s10);
			l5.setBounds(50,275,940,50);
			l5.setFont(new Font("Times New Roman",Font.BOLD,20));
			l5.setForeground(Color.WHITE);
			p.add(l5);
			
			l6=new JLabel(" * Born On the "+str2[0]+" Day of "+str2[1]+" in the Year "+str2[2]+".");
			l6.setBounds(50,325,940,50);
			l6.setFont(new Font("Times New Roman",Font.BOLD,20));
			l6.setForeground(Color.WHITE);
			p.add(l6);
			
			l7=new JLabel(" SIGNED: RAHUL KUMAR JHA");
			l7.setBounds(600,380,300,50);
			l7.setFont(new Font("Times New Roman",Font.BOLD,20));
			l7.setForeground(Color.WHITE);
			p.add(l7);
			
			b1=new JButton("PRINT");
			b1.setBounds(225,510,200,30);
			b1.setFont(new Font("Times New Roman",Font.BOLD,20));
			b1.setForeground(Color.YELLOW);
			b1.setBackground(Color.GRAY);
			b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			b1.addActionListener(this);
			f.add(b1);
			
			b2=new JButton("BACK");
			b2.setBounds(550,510,200,30);
			b2.setFont(new Font("Times New Roman",Font.BOLD,20));
			b2.setForeground(Color.YELLOW);
			b2.setBackground(Color.GRAY);
			b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			b2.addActionListener(this);
			f.add(b2);
			
			f.setVisible(true);
		}
	}
	public static void main(String[] args) 
	{
		new Certificate("","","","","","","","","","",0);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			PrinterJob pj=PrinterJob.getPrinterJob();
			pj.setJobName("Print Data");
			pj.setPrintable(new Printable() {
				public int print(Graphics graphics,PageFormat pageFormat,int pageIndex)throws PrinterException
				{
					if(pageIndex>0)
						return(Printable.NO_SUCH_PAGE);
					Graphics2D g2D=(Graphics2D)graphics;
					g2D.scale(0.62,1);
					p.print(g2D);
					return(Printable.PAGE_EXISTS);
				}
			});
			if(pj.printDialog())
			{
				try
				{
					pj.print();
				}
				catch(Exception e1)
				{
					e1.getMessage();
				}
			}
		}
		else
		{
			new User_Details(s1,c);
			f.dispose();
		}
	}
}