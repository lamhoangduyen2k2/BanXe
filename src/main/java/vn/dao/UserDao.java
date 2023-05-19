package vn.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.connection.ConnectJDBC;
import vn.models.*;

public class UserDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;


	public _User login(String user, String pass) {
	       
			String sql = "select * from _User where email= ? and hashed_password = ? ";
			try {
				// mo ket noi DB
				conn = new ConnectJDBC().getConnection();
				// nem cau querry qua SQL
				ps = conn.prepareStatement(sql);
				// gan gia tri cho dau hoi
				ps.setString(1, user);
				ps.setString(2, pass);

				// chay querry va nhan ket qua
				rs = ps.executeQuery();
				// lay tu resultset do vao list
				while (rs.next()) {
			
					return new _User (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)
							,rs.getBoolean(8),rs.getBoolean(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),
							rs.getString(14),rs.getString(15),rs.getInt(16),rs.getFloat(17),rs.getDate(18),rs.getDate(19));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
	}
	public _User checkuser(String user) {
	       
		String sql = "select * from _User where email= ? ";
		try {
			// mo ket noi DB
			conn = new ConnectJDBC().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			// gan gia tri cho dau hoi
			ps.setString(1, user);

			// chay querry va nhan ket qua
			rs = ps.executeQuery();
			// lay tu resultset do vao list
			while (rs.next()) {
		
				return new _User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)
						,rs.getBoolean(8),rs.getBoolean(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),
						rs.getString(14),rs.getString(15),rs.getInt(16),rs.getFloat(17),rs.getDate(18),rs.getDate(19));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
}
	public _User checkuserbyId(int id) {
	       
		String sql = "select * from _User where _id= ? ";
		try {
			// mo ket noi DB
			conn = new ConnectJDBC().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			// gan gia tri cho dau hoi
			ps.setInt(1, id);

			// chay querry va nhan ket qua
			rs = ps.executeQuery();
			// lay tu resultset do vao list
			while (rs.next()) {
		
				return new _User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)
						,rs.getBoolean(8),rs.getBoolean(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),
						rs.getString(14),rs.getString(15),rs.getInt(16),rs.getFloat(17),rs.getDate(18),rs.getDate(19));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
}
	public _User signup(String firstname, String lastname, String id_card, String email,String phone, String hashed_password, float e_wallet ) {
	       
		String sql = "insert into _User (firstname, lastname, id_card, email, phone, hashed_password, e_wallet  ) values (?,?,?,?,?,?,?) ";
		try {
			// mo ket noi DB
			conn = new ConnectJDBC().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			// gan gia tri cho dau hoi
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, id_card);
			ps.setString(4, email);
			ps.setString(5, phone);
			ps.setString(6, hashed_password);
			ps.setFloat(7, e_wallet);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
}
	public void change(_User user)
	{
		String sql = "Update _User set [hashed_password]=?  where email = ?\r\n";
		try {
			// mo ket noi DB
			conn = new ConnectJDBC().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			// gan gia tri cho dau hoi
			ps.setString(1, user.getHashed_password());
			ps.setString(2, user.getEmail());
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void editUser(_User user) {
	       
		String sql = "Update _User set [firstname] = ?\r\n"
				+ "      ,[lastname] =?\r\n"
				+ "      ,[id_card] = ?\r\n"
				+ "      ,[email] =?\r\n"
				+ "      ,[phone]=?\r\n"
				+ "      ,[hashed_password]=?\r\n"
				+ "      ,[addresses]=?\r\n"
				+ "      ,[avatar]=?\r\n"
				+ "      ,[cover]=?\r\n"
				+ "      ,[point]=?\r\n"
				+ "      ,[e_wallet]=?\r\n"
				+ "	  where _id = ?\r\n"
				+ "";
		try {
			// mo ket noi DB
			conn = new ConnectJDBC().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			// gan gia tri cho dau hoi
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getId_card());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getHashed_password());
			ps.setString(7, user.getAddresses());
			ps.setString(8, user.getAvatar());
			ps.setString(9, user.getCover());
			ps.setInt(10, user.getPoint());
			ps.setDouble(11, user.getE_wallet());
			ps.setInt(12, user.get_id());
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//return null;
}

}
