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

public class DeliveryDaoImpl extends ConnectJDBC implements DeliveryDAO{
	
	@Override
	public List<Delivery> findAllDelivery() {
		List<Delivery> deliveryList = new ArrayList<Delivery>();
		String sql = "Select * from Delivery";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Delivery delivery = new Delivery();
				delivery.set_id(rs.getInt("_id"));
				delivery.setName(rs.getString("name"));
				delivery.setDescription(rs.getString("description"));
				delivery.setPrice(rs.getDouble("price"));
				delivery.setDeleted(rs.getBoolean("isDeleted"));
				delivery.setCreatedAt(rs.getDate("createdAt"));
				delivery.setUpdatedAt(rs.getDate("updatedAt"));
				deliveryList.add(delivery);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deliveryList;
	}
	
	@Override
	public Delivery findDeliveryByID(int _id) {
		String sql = "Select * From Delivery where _id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, _id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { // duyệt từng dòng trong ResultSet trả về danh sách đối tượng
				Delivery delivery = new Delivery();
				delivery.set_id(rs.getInt("_id"));
				delivery.setName(rs.getString("name"));
				delivery.setDescription(rs.getString("description"));
				delivery.setPrice(rs.getDouble("price"));
				delivery.setDeleted(rs.getBoolean("isDeleted"));
				delivery.setCreatedAt(rs.getDate("createdAt"));
				delivery.setUpdatedAt(rs.getDate("updatedAt"));
				return delivery;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void insert(Delivery delivery)
	{
		String sql = "INSERT INTO dbo.Delivery\r\n"
				+ "(\r\n"
				+ "    name,\r\n"
				+ "    description,\r\n"
				+ "    price\r\n"
				+ ")\r\n"
				+ "VALUES\r\n"
				+ "(   ?,     -- name\r\n"
				+ "    ?,    -- description\r\n"
				+ "    ? -- price\r\n"
				+ "    )";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, delivery.getName());
		ps.setString(2, delivery.getDescription());
		ps.setDouble(3, delivery.getPrice());
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	@Override
	public void edit(Delivery delivery)
	{
		String sql = "UPDATE dbo.Delivery SET name = ?, description = ?, price = ?, isDeleted = ? WHERE _id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, delivery.getName());
			ps.setString(2, delivery.getDescription());
			ps.setDouble(3, delivery.getPrice());
			ps.setBoolean(4, delivery.getisDeleted());
			ps.setInt(5, delivery.get_id());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(int id)
	{
		String sql = "DELETE FROM dbo.Delivery WHERE _id = ?";
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
