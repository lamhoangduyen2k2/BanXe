package vn.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import vn.connection.ConnectJDBC;
import vn.dao._UserDAO;
import vn.models._User;

public class _UserDaoImpl extends ConnectJDBC implements _UserDAO{
	@Override
	public List<_User> findAllUser() {
		List<_User> userList = new ArrayList<_User>();
		String sql = "Select * from _User";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				_User user = new _User();
				user.set_id(rs.getInt("_id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setSlug(rs.getString("slug"));
				user.setId_card(rs.getString("id_card"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setEmalActive(rs.getBoolean("isEmalActive"));
				if(rs.getInt("isPhoneActive") == 1)
					user.setPhoneActive(true);
				else
					user.setPhoneActive(false);
				user.setSalt(rs.getString("salt"));
				user.setHashed_password(rs.getString("hashed_password"));
				user.set_role(rs.getString("_role"));
				user.setAddresses(rs.getString("addresses"));
				user.setAvatar(rs.getString("avatar"));
				user.setCover(rs.getString("cover"));
				user.setPoint(rs.getInt("point"));
				user.setE_wallet(rs.getDouble("e_wallet"));
				user.setCreatedAt(rs.getDate("createdAt"));
				user.setUpdatedAt(rs.getDate("updatedAt"));
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	@Override
	public _User findUserByID(int _id) {
		String sql = "Select * From _User where _id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, _id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { // duyệt từng dòng trong ResultSet trả về danh sách đối tượng
				_User user = new _User();
				user.set_id(rs.getInt("_id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setSlug(rs.getString("slug"));
				user.setId_card(rs.getString("id_card"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				if(rs.getInt("isEmalActive") == 1)
					user.setEmalActive(true);
				else
					user.setEmalActive(false);
				if(rs.getInt("isPhoneActive") == 1)
					user.setPhoneActive(true);
				else
					user.setPhoneActive(false);
				user.setSalt(rs.getString("salt"));
				user.setHashed_password(rs.getString("hashed_password"));
				user.set_role(rs.getString("_role"));
				user.setAddresses(rs.getString("addresses"));
				user.setAvatar(rs.getString("avatar"));
				user.setCover(rs.getString("cover"));
				user.setPoint(rs.getInt("point"));
				user.setE_wallet(rs.getDouble("e_wallet"));
				user.setCreatedAt(rs.getDate("createdAt"));
				user.setUpdatedAt(rs.getDate("updatedAt"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void insert(_User user)
	{
		String sql = "INSERT INTO dbo._User\r\n"
				+ "	(\r\n"
				+ "	    firstname,\r\n"
				+ "	    lastname,\r\n"
				+ "	    id_card,\r\n"
				+ "	    email,\r\n"
				+ "	    phone,\r\n"
				+ "	    salt,\r\n"
				+ "	    hashed_password,\r\n"
				+ "	    addresses,\r\n"
				+ "	    _role,\r\n"
				+ "	    avatar\r\n"
				+ "	)\r\n"
				+ "	VALUES\r\n"
				+ "	(   ?,     -- firstname - nvarchar(32)\r\n"
				+ "	    ?,     -- lastname - nvarchar(32)\r\n"
				+ "	    ?,    -- id_card - varchar(50)\r\n"
				+ "	    ?,    -- email - varchar(100)\r\n"
				+ "	    ?,    -- phone - varchar(20)\r\n"
				+ "	    ?,    -- salt - varchar(max)\r\n"
				+ "	    ?,      -- hashed_password - varchar(max)\r\n"
				+ "	    ?,    -- addresses - nvarchar(200)\r\n"
				+ "	    ?,    -- role\r\n"
				+ "	    ?    -- avatar - nvarchar(500)\r\n"
				+ "	    )";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getFirstname());
		ps.setString(2, user.getLastname());
		ps.setString(3, user.getId_card());
		ps.setString(4, user.getEmail());
		ps.setString(5, user.getPhone());
		ps.setString(6, user.getSalt());
		ps.setString(7, user.getHashed_password());
		ps.setString(8, user.getAddresses());
		ps.setString(9, user.get_role());
		ps.setString(10, user.getAvatar());
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	@Override
	public void edit(_User user)
	{
		String sql = "UPDATE dbo._User SET firstname = ?, lastname = ?, salt = ?, hashed_password = ?, _role = ?, addresses = ?, avatar = ?, point = ?, e_wallet = ? WHERE _id = ?";
				try {
				Connection con = super.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, user.getFirstname());
				ps.setString(2, user.getLastname());
				ps.setString(3, user.getSalt());
				ps.setString(4, user.getHashed_password());
				ps.setString(5, user.get_role());
				ps.setString(6, user.getAddresses());
				ps.setString(7, user.getAvatar());
				ps.setInt(8, user.getPoint());
				ps.setDouble(9, user.getE_wallet());
				ps.setInt(10, user.get_id());
				ps.executeUpdate();
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
	}
	
	@Override
	public void delete(int id)
	{
		String sql = "DELETE FROM dbo._User WHERE _id = ?";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	@Override
	public int[] SignUpInDay(int month, int year)
	{
		int[] arr = new int[31];
		String sql = "Select * from _User";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Date date = rs.getDate("createdAt");
				LocalDate localDate = date.toLocalDate();

				if(localDate.getYear() == year && localDate.getMonthValue() == month)
				{
					arr[localDate.getDayOfMonth() - 1] += 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	@Override
	public int[] SignUpInMonth(int year)
	{
		int[] arr = new int[12];
		String sql = "Select * from _User";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Date date = rs.getDate("createdAt");
				LocalDate localDate = date.toLocalDate();

				if(localDate.getYear() == year)
				{
					arr[localDate.getMonthValue() - 1] += 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	public boolean CheckYear(int year)
	{
		long millis=System.currentTimeMillis();
		Date now = new Date(millis);
		LocalDate localNow = now.toLocalDate();
		
		for(int i=localNow.getYear(); i< localNow.getYear() + 5; i++)
		{
			if(i == year)
				return true;
		}
		return false;
	}
	
	@Override
	public int[] SignUpInYear()
	{
		int[] arr = new int[5];
		String sql = "Select * from _User";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Date date = rs.getDate("createdAt");
				LocalDate localDate = date.toLocalDate();
				long millis=System.currentTimeMillis();
				Date now = new Date(millis);
				LocalDate localNow = now.toLocalDate();
				if(CheckYear(localDate.getYear()))
				{
					arr[localDate.getYear() - localNow.getYear() + 4] += 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	@Override
	public int TotalSignUpInDay(int month, int year)
	{
		long millis=System.currentTimeMillis();
		Date now = new Date(millis);
		LocalDate localNow = now.toLocalDate();
		int[] dayList = SignUpInDay(localNow.getMonthValue(),localNow.getYear());
		return IntStream.of(dayList).sum();
	}
	
	@Override
	public int TotalSignUpInMonth(int year)
	{
		long millis=System.currentTimeMillis();
		Date now = new Date(millis);
		LocalDate localNow = now.toLocalDate();
		int[] monthList = SignUpInMonth(localNow.getYear());
		return IntStream.of(monthList).sum();
	}
	
	@Override
	public int TotalSignUpInYear()
	{
		long millis=System.currentTimeMillis();
		Date now = new Date(millis);
		LocalDate localNow = now.toLocalDate();
		int[] yearList = SignUpInYear();
		return IntStream.of(yearList).sum();
	}
}
