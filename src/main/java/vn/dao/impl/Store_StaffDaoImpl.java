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

public class Store_StaffDaoImpl extends ConnectJDBC implements Store_StaffDAO{
	_UserService userService = new _UserServiceImpl();
	StoreService storeService = new StoreServiceImpl();
	
	@Override
	public List<Store_Staff> findAllStaff(int id) {
		List<Store_Staff> staffList = new ArrayList<Store_Staff>();
		String sql = "Select * from Store_Staff where storeId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Store_Staff staff = new Store_Staff();
				staff.setStaffId(rs.getInt("staffId"));
				staff.setStoreId(rs.getInt("storeId"));
				if(rs.getInt("staffId") != 0)
				{
					_User user = userService.findUserByID(rs.getInt("staffId"));
					staff.set_user(user);
				}
				if(rs.getInt("storeId") != 0)
				{
					Store store = storeService.findStoreByID(rs.getInt("storeId"));
					staff.setStore(store);
				}
				staffList.add(staff);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffList;
	}
	
	@Override
	public void insert(Store_Staff ss)
	{
		String sql = "INSERT INTO dbo.Store_Staff\r\n"
				+ "(\r\n"
				+ "    storeId,\r\n"
				+ "    staffId\r\n"
				+ ")\r\n"
				+ "VALUES\r\n"
				+ "(   ?, -- storeId - int\r\n"
				+ "    ?  -- staffId - int\r\n"
				+ ")";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, ss.getStoreId());
		ps.setInt(2, ss.getStaffId());
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	@Override
	public void delete(int idStore, int idStaff)
	{
		String sql = "DELETE FROM dbo.Store_Staff WHERE storeId = ? and staffId = ?";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, idStore);
		ps.setInt(2, idStaff);
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
