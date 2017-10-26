package edu.colostate.cs.cs414.project.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseWriteTask implements AutoCloseable{

	private final String dbURL = "jdbc:mysql://localhost:3306/";
	
	ArrayList<PreparedStatement> preparedStatements;
	Connection conn;
	
	public DatabaseWriteTask(String dbName) throws SQLException{
		
		conn = DriverManager.getConnection(dbURL+dbName,"root","root");
		
	}
	
	public PreparedStatement prepareStatement(String sql) throws SQLException{
		
		PreparedStatement ps=null;
		try {
			ps = conn.prepareStatement(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		preparedStatements.add(ps);
		
		return ps;
		
	}
	
	public void executeUpdate(){
		
		
		
	}
	
	public void close() throws SQLException{
		
		if(preparedStatements != null){
			for(PreparedStatement ps : preparedStatements){
				ps.close();
			}
		}
		
		if(conn != null){
			conn.close();
		}
		
	}
	
}
