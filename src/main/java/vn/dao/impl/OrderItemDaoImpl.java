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

public class OrderItemDaoImpl extends ConnectJDBC implements OrderItemDAO{
	ProductService productService = new ProductServiceImpl();
	_OrderService orderService = new _OrderServiceImpl();
	
	@Override
	public List<OrderItem> findAllOrderItem(int ido) {
		List<OrderItem> oiList = new ArrayList<OrderItem>();
		String sql = "Select * from OrderItem where orderId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ido);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderItem oi = new OrderItem();
				oi.set_id(rs.getInt("_id"));
				oi.setOrderId(rs.getInt("orderId"));
				oi.setProductId(rs.getInt("productId"));
				oi.setCount_SP(rs.getInt("count_SP"));
				oi.setCreatedAt(rs.getDate("createdAt"));
				oi.setUpdatedAt(rs.getDate("updatedAt"));
				if(rs.getInt("orderId") != 0)
				{
					_Order order = orderService.find_OrderByID(rs.getInt("orderId"));
					oi.setOrder(order);;
				}
				if(rs.getInt("productId") != 0)
				{
					Product product = productService.findProductByID(rs.getInt("productId"));
					oi.setProduct(product);
				}
				oiList.add(oi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oiList;
	}
	
	@Override
	public 	OrderItem findOrderItemByID(int _id) {
		String sql = "Select * From OrderItem where _id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, _id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { // duyệt từng dòng trong ResultSet trả về danh sách đối tượng
				OrderItem oi = new OrderItem();
				oi.set_id(rs.getInt("_id"));
				oi.setOrderId(rs.getInt("orderId"));
				oi.setProductId(rs.getInt("productId"));
				oi.setCount_SP(rs.getInt("count_SP"));
				oi.setCreatedAt(rs.getDate("createdAt"));
				oi.setUpdatedAt(rs.getDate("updatedAt"));
				if(rs.getInt("orderId") != 0)
				{
					_Order order = orderService.find_OrderByID(rs.getInt("orderId"));
					oi.setOrder(order);;
				}
				if(rs.getInt("productId") != 0)
				{
					Product product = productService.findProductByID(rs.getInt("productId"));
					oi.setProduct(product);
				}
				return oi;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void insert(OrderItem oi)
	{
		String sql = "INSERT INTO dbo.OrderItem\r\n"
				+ "(\r\n"
				+ "    orderId,\r\n"
				+ "    productId,\r\n"
				+ "    count_SP\r\n"
				+ ")\r\n"
				+ "VALUES\r\n"
				+ "(   ?,     -- orderId\r\n"
				+ "    ?,    -- productId\r\n"
				+ "    ? -- count_SP\r\n"
				+ "    )";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, oi.getOrderId());
		ps.setInt(2, oi.getProductId());
		ps.setInt(3, oi.getCount_SP());
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	@Override
	public void edit(OrderItem oi)
	{
		String sql = "UPDATE dbo.OrderItem SET count_SP = ? WHERE orderId = ? and productId = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);		
			ps.setInt(1, oi.getCount_SP());
			ps.setInt(2, oi.getOrderId());
			ps.setInt(3, oi.getProductId());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(int id)
	{
		String sql = "DELETE FROM dbo.OrderItem WHERE _id = ?";
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
