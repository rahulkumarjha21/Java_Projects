/*
 *Main.java - Firstly, establish a secure connection with MySQL database using MySQL JDBC connector using DriverManager and check if database is already present or not. If not, then i have created a new Database with MunicipalData. Now, similarly i checked tables(login_table and municipal_data) also, if not, i have created them in the same database. And added default system generated username: admin and password: admin, for the admin user in the login_table. And all the function which are needed to be implemented listed above through the database can be only possible by creating a secure condition through this class by call its constructor.
 *Author: Rahul Kumar Jha, 
 *Regd. No.-1941012186
 *Section- C.S.E.-'C'
 *Date Of Editing- 14 February, 2021
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Main 
{
	public Connection c;
	public Statement s;
	String JDBC_DRIVER="com.mysql.jdbc.Driver";
	String DB_URL="jdbc:mysql://localhost/";
	String username="root";
	String password="root";
	String project="MunicipalData";
	Main()
	{
		try
		{
			Class.forName(JDBC_DRIVER);
			c=DriverManager.getConnection(DB_URL,username,password);
			s=c.createStatement();
			String name="create database if not exists "+project;
			s.executeUpdate(name);
			String db="use "+project;
			s.executeQuery(db);
			String login="create table if not exists login_table(username varchar(50),password varchar(50))";
			s.executeUpdate(login);
			String active="create table if not exists municipal_data(id varchar(5),username varchar(50),gender varchar(6),dob varchar(20),occupation varchar(50),family varchar(6),address varchar(100),dod varchar(20),status varchar(5),place varchar(100))";
			s.executeUpdate(active);
			String c="select count(*) from login_table";
			ResultSet rs=s.executeQuery(c);
			
			if(rs.next())
			{
				int n=Integer.parseInt(rs.getString("count(*)"));
				if(n==0)
				{
					String insert="insert into login_table values('admin','admin')";
					s.executeUpdate(insert);
				}	
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		new Main();
	}
}