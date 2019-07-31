package webtest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import webtest.model.GuestBookEntry;
import webtest.util.MySQLDemo;

public class GuestBookDao {
	
	public int add(GuestBookEntry guestBookEntry)
	{
		Connection con=MySQLDemo.Conn();
		int i=0;
		try {
			
			 String sql="insert into GuestBook(name,specialties,presentation) values(?,?,?)";
			 PreparedStatement  psm=con.prepareStatement(sql);
			 psm.setString(1, guestBookEntry.getName());
			 psm.setString(2, guestBookEntry.getSpecialties());
			 psm.setString(3, guestBookEntry.getPresentation());
			 i=psm.executeUpdate();
			  MySQLDemo.close(null, psm, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return i;	
	}

	public int update(GuestBookEntry guestBookEntry)
	{
		Connection con=MySQLDemo.Conn();
		int i=0;
		try {

			String sql="update GuestBook set name=?,specialties=?,presentation=? where id=? ";
			PreparedStatement  psm=con.prepareStatement(sql);
			psm.setString(1, guestBookEntry.getName());
			psm.setString(2, guestBookEntry.getSpecialties());
			psm.setString(3, guestBookEntry.getPresentation());
			psm.setLong(4,guestBookEntry.getId());
			i=psm.executeUpdate();
			MySQLDemo.close(null, psm, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}
	
	public List<GuestBookEntry> select()
	{   Connection con=MySQLDemo.Conn();
	    String sql="select * from GuestBook";
	    List<GuestBookEntry> list=new ArrayList<>();
	 try {
		PreparedStatement  psm=con.prepareStatement(sql);
   ResultSet  resultSet=psm.executeQuery();
   while(resultSet.next())
   {
	   GuestBookEntry guestBookEntry=new GuestBookEntry();
	   guestBookEntry.setName(resultSet.getString("name"));
	   guestBookEntry.setId(resultSet.getLong("id"));
	   guestBookEntry.setPresentation(resultSet.getString("presentation"));
	   guestBookEntry.setSpecialties(resultSet.getString("specialties"));
	   list.add(guestBookEntry);
   }
	  MySQLDemo.close(resultSet, psm, con);  
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		return list;
		
	}
	
	public GuestBookEntry selectbyid(Long id)
	{   Connection con=MySQLDemo.Conn();
	    String sql="select * from GuestBook where id=?";
		GuestBookEntry guestBookEntry=new GuestBookEntry();
	 try {
		PreparedStatement  psm=con.prepareStatement(sql);
		psm.setLong(1,id);
        ResultSet  resultSet=psm.executeQuery();
   while(resultSet.next())
   {
	   guestBookEntry.setName(resultSet.getString("name"));
	   guestBookEntry.setId(resultSet.getLong("id"));
	   guestBookEntry.setPresentation(resultSet.getString("presentation"));
	   guestBookEntry.setSpecialties(resultSet.getString("specialties"));
	  ;
   }
	  MySQLDemo.close(resultSet, psm, con);  
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		return guestBookEntry;
		
	}
	
	public static void main(String[] args)
	{
		GuestBookDao guestBookDao=new GuestBookDao();
		GuestBookEntry guestBookEntry=new GuestBookEntry();
		guestBookEntry.setName("456");
		guestBookEntry.setPresentation("4796");
		guestBookEntry.setSpecialties("5+65");
		guestBookDao.add(guestBookEntry);
		System.out.println(guestBookDao.selectbyid(2L));
	}

}
