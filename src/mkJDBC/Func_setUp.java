package mkJDBC;
import java.sql.*;
import java.io.*;

import javax.swing.JOptionPane;
public class Func_setUp {
	public void establishConnection() throws SQLException {
		try {
			String url="jdbc:mysql://localhost:3306/";
			String username="root";
			String password="Mayank@1";
			Connection connect=DriverManager.getConnection(url,username,password);

			JOptionPane.showMessageDialog(null, "Successfully Established Connection !");
			System.out.println("Succesfully Connected !");
			connect.close();
		}
		catch(SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} 
	}
	public void createDatabase() throws SQLException {
		try {
			String url="jdbc:mysql://localhost:3306/";
			String username="root";
			String password="Mayank@1";
		
			String query="Create database Maharaj";
			Connection connect=DriverManager.getConnection(url,username,password);
			Statement stm=connect.createStatement();
			stm.execute(query);
			JOptionPane.showMessageDialog(null, "Successfully Created Database");
			System.out.println("Succesfully Created database");
			connect.close();
		}
		catch(SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} 
	}
	public void createTable() throws SQLException {
		try {
			String url="jdbc:mysql://localhost:3306/mk";
			String username="root";
			String password="Mayank@1";
			Connection connect=DriverManager.getConnection(url,username,password);
			// Write create table tableName command ;
//			String query="Create table studentAlter(stdid int(8),name varchar(12),mobile int(10),"
//					+ "branch varchar(5))";
			String query="Create table newSena(id int(4),mobile int(10),name varchar(10),branch varchar(5))";
			Statement s1=connect.createStatement();
			s1.execute(query);
			
			JOptionPane.showMessageDialog(null, "Successfully Table Created !");
			System.out.println("Succesfully Table created !");
			connect.close();
		}
		catch(SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} 
		
	}
	public void insertData() throws SQLException {
		try {
			String url="jdbc:mysql://localhost:3306/mk";
			String username="root";
			String password="Mayank@1";
			Connection connect=DriverManager.getConnection(url,username,password);
			// Write create table tableName command ;
		String query="Insert into newtests Values(12,'GK')";
		String q2="Insert into newtests Values(152,'kkkK')";

			Statement s1=connect.createStatement();
			s1.execute(query);
			s1.execute(q2);
			
			JOptionPane.showMessageDialog(null, "Values Inserted Successfully  !");
			System.out.println("Succesfull !");
			connect.close();
		}
		catch(SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} 
		
	}
	public void readData() throws SQLException {
		try {
			String url="jdbc:mysql://localhost:3306/mk";
			String username="root";
			String password="Mayank@1";
			Connection connect=DriverManager.getConnection(url,username,password);
			// Write create table tableName command ;
			String query="Select * from studentdb";

			Statement s1=connect.createStatement();
			ResultSet r=s1.executeQuery(query);
			
			JOptionPane.showMessageDialog(null, "Selected Dataset Successfully  !");
			System.out.println("Printing Table data ...");
			while(r.next()) {
				String result="";
				for(int i=1;i<=4;i++) {
					result+=r.getString(i)+" | ";	
				}
				System.out.println(result);
			}
			System.out.println("Succesfull !");
			connect.close();
		}
		catch(SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} 
	}
		public void insertDynamicData() throws SQLException, IOException {
			try {
				String url="jdbc:mysql://localhost:3306/mk";
				String username="root";
				String password="Mayank@1";
				Connection connect=DriverManager.getConnection(url,username,password);
				// Write create table tableName command ;
			String query="Insert into studentdb(stdid,name,city,branch) values(?,?,?,?)";
			JOptionPane.showMessageDialog(null, "Enter details via Console !");
				System.out.println("Important Info : Student ID is a primary Key !!");
				System.out.println("DataType warning : All String/varchar");
				PreparedStatement ps1=connect.prepareStatement(query);
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//				System.out.println("Press any Numeric value except '0' to Enter values into Table ");
			
			
				System.out.println("Enter sID");
				String stdid =br.readLine();
					
				System.out.println("Enter your Name");
				String name =br.readLine();
				
				System.out.println("Enter your city");
				String city=br.readLine();
				
				System.out.println("Enter Branch");
				String branch=br.readLine();
				
				ps1.setString(1,stdid);
				ps1.setString(2,name);
				ps1.setString(3,city);
				ps1.setString(4,branch);
				
				ps1.executeUpdate();
				System.out.println("Succesfull !");
//				System.out.println("Press '0' to exit");
				
				
				
				connect.close();
			}
			catch(SQLException e) {
				System.out.println(e);
				e.printStackTrace();
			} 
			catch(Exception e) {
				System.out.println(e);
			}
		
	}
}
