package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utility.ConnectionManager;

public class UserDAO implements UserDaoInterface
{
String signup="insert into blog values(?,?,?)";
String login="select * from blog where email=? and password=?";
	@Override
	public int signUp(User user) throws SQLException, ClassNotFoundException {
		Connection con=null;
		con=ConnectionManager.getConnection();
		PreparedStatement ps=con.prepareStatement(signup);
		ps.setString(1, user.getEmail());
		ps.setString(2, user.getPassword());
	//	ps.setDate(3, user.getDate());
		ps.setDate(3,java.sql.Date.valueOf(user.getDate()));
		int execution = ps.executeUpdate();
		return execution;
		
	}

	@Override
	public boolean loginUser(User user) throws ClassNotFoundException, SQLException {
		Connection con=null;
		con=ConnectionManager.getConnection();
		PreparedStatement ps=con.prepareStatement(login);
		ps.setString(1,user.getEmail());
		ps.setString(2,user.getPassword());

		ResultSet rs = ps.executeQuery();

		return false;
	}
	
}