package Core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import Design.Table;

public class SQLB {
	
	public static void SQL(String text){
		Member.res="Error";
		try {
			Class.forName(Member.DRIVER);
			Connection connection=DriverManager.getConnection(Member.JDBC_URL);
			
			String comand[] = text.split("\\r?\\n");
			
			for(int i=0;i<comand.length;i++)					{
				connection.createStatement().execute(comand[i]);
			}
			Member.res="OK";
			
			if(connection !=null) connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void Conn(){
		Member.JDBC_URL="jdbc:derby:database\\"+Member.name+";create=true";
		
		try {
			Class.forName(Member.DRIVER);
			Connection connection=DriverManager.getConnection(Member.JDBC_URL);
			if(connection !=null) connection.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void func_F(){
		try {
			Class.forName(Member.DRIVER);
			Connection connection=DriverManager.getConnection(Member.JDBC_URL);
			Member.comand=Member.comand+")";
			connection.createStatement().execute(Member.comand);
			@SuppressWarnings("unused")
			Table TableF=new Table();
			Member.comand="create table ";
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public static String Colonku(String str) {
	    String res="";
	    try {
			Class.forName(Member.DRIVER);
			Connection connection=DriverManager.getConnection(Member.JDBC_URL);	
			Statement statement=connection.createStatement();
	        ResultSet resultSet=statement.executeQuery("Select * FROM "+(String) Table.comboBox.getSelectedItem());
	        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
	        Member.n_colum=resultSetMetaData.getColumnCount();
	        
	        if(str=="View"){
	        	for(int x=1; x<=Member.n_colum; x++){
		        	res=res+resultSetMetaData.getColumnName(x)+"\t"+"_|"+"\t";
		        }
		    }
	        
	        else{
	        	for(int x=1; x<=Member.n_colum; x++){
		        	res=res+resultSetMetaData.getColumnName(x)+"\n";
		        }
		    }
	         
	        if(statement !=null) statement.close();
	        if(connection !=null) connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return res;
	}
	
	public static String Search(String comand) {
	    String res="";
	    
	    	try {
				Class.forName(Member.DRIVER);
				Connection connection=DriverManager.getConnection(Member.JDBC_URL);	
		    	Statement statement=connection.createStatement();
		        ResultSet resultSet=statement.executeQuery(comand);
		        
		        while(resultSet.next()){
		        	res=res+"\n";
		            for(int x=1; x<=Member.n_colum; x++){
		            	res=res+resultSet.getString(x)+"\t"+"\t";
		            }
		        }
		         
		        if(statement !=null) statement.close();
		        if(connection !=null) connection.close();
		        
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    
	    
	    return res;
	}
	
}
