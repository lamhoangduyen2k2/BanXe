package vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.connection.ConnectJDBC;
import vn.dao.*;
import vn.models.*;
import vn.service.*;
import vn.service.impl.*;

public class StoreDaoImpl extends ConnectJDBC implements StoreDAO{
	_UserService userService = new _UserServiceImpl();
	
	@Override
	public List<Store> findAllStore() {
		List<Store> storeList = new ArrayList<Store>();
		String sql = "Select * from Store";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Store store = new Store();
				store.set_id(rs.getInt("_id"));
				store.set_name(rs.getString("_name"));
				store.setBio(rs.getString("bio"));
				store.setSlug(rs.getString("slug"));
				store.setOwnerId(rs.getInt("ownerId"));
				store.setActive(rs.getBoolean("isActive"));
				store.setOpen(rs.getBoolean("isOpen"));
				store.setAvatar(rs.getString("avatar"));
				store.setPoint(rs.getInt("point"));
				store.setRating(rs.getInt("rating"));
				store.setE_wallet(rs.getDouble("e_wallet"));
				store.setCreatedAt(rs.getDate("createdAt"));
				store.setUpdatedAt(rs.getDate("updatedAt"));
				if(rs.getInt("ownerId") != 0)
				{
					_User user = userService.findUserByID(rs.getInt("ownerId"));
					store.set_user(user);
				}
				storeList.add(store);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return storeList;
	}
	
	@Override
	public Store findStoreByID(int _id) {
		String sql = "Select * From Store where _id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, _id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { // duyệt từng dòng trong ResultSet trả về danh sách đối tượng
				Store store = new Store();
				store.set_id(rs.getInt("_id"));
				store.set_name(rs.getString("_name"));
				store.setBio(rs.getString("bio"));
				store.setSlug(rs.getString("slug"));
				store.setOwnerId(rs.getInt("ownerId"));
				store.setActive(rs.getBoolean("isActive"));
				store.setOpen(rs.getBoolean("isOpen"));
				store.setAvatar(rs.getString("avatar"));
				store.setPoint(rs.getInt("point"));
				store.setRating(rs.getInt("rating"));
				store.setE_wallet(rs.getDouble("e_wallet"));
				store.setCreatedAt(rs.getDate("createdAt"));
				store.setUpdatedAt(rs.getDate("updatedAt"));
				if(rs.getInt("ownerId") != 0)
				{
					_User user = userService.findUserByID(rs.getInt("ownerId"));
					store.set_user(user);
				}
				return store;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void insert(Store store)
	{
		String sql = "INSERT INTO dbo.Store\r\n"
				+ "(\r\n"
				+ "    _name,\r\n"
				+ "    bio,\r\n"
				+ "    slug,\r\n"
				+ "    ownerId,\r\n"
				+ "    isActive,\r\n"
				+ "    isOpen,\r\n"
				+ "    avatar,\r\n"
				+ "    point,\r\n"
				+ "    rating,\r\n"
				+ "    e_wallet,\r\n"
				+ "    createdAt,\r\n"
				+ "    updatedAt\r\n"
				+ ")\r\n"
				+ "VALUES\r\n"
				+ "(   ?,     -- _name - nvarchar(100)\r\n"
				+ "    ?,     -- bio - nvarchar(1000)\r\n"
				+ "    NULL,    -- slug - nvarchar(100)\r\n"
				+ "    ?,    -- ownerId - int\r\n"
				+ "    DEFAULT, -- isActive - bit\r\n"
				+ "    DEFAULT, -- isOpen - bit\r\n"
				+ "    ?,    -- avatar - nvarchar(500)\r\n"
				+ "    DEFAULT, -- point - int\r\n"
				+ "    DEFAULT, -- rating - int\r\n"
				+ "    DEFAULT, -- e_wallet - decimal(10, 4)\r\n"
				+ "    DEFAULT, -- createdAt - datetime\r\n"
				+ "    DEFAULT  -- updatedAt - datetime\r\n"
				+ "    )";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, store.get_name());
		ps.setString(2, store.getBio());
		ps.setInt(3, store.getOwnerId());
		ps.setString(4, store.getAvatar());
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	@Override
	public void edit(Store store)
	{
		String sql = "UPDATE dbo.Store SET _name = ?, bio = ?, ownerId = ?, isActive = ?, isOpen = ?, avatar = ?, point = ?, e_wallet = ? WHERE _id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, store.get_name());
			ps.setString(2, store.getBio());
			ps.setInt(3, store.getOwnerId());
			ps.setBoolean(4, store.getisActive());
			ps.setBoolean(5, store.getisOpen());
			ps.setString(6, store.getAvatar());
			ps.setInt(7, store.getPoint());
			ps.setDouble(8, store.getE_wallet());
			ps.setInt(9, store.get_id());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(int id)
	{
		String sql = "DELETE FROM dbo.Store WHERE _id = ?";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
