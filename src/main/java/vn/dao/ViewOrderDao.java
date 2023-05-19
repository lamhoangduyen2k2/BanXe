package vn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.connection.ConnectJDBC;
import vn.models.*;

public class ViewOrderDao {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	//Hiển thị toàn bộ đơn hàng chưa được xử lí
	public List<ViewOrderModel> getAllViewOrder() {
		List<ViewOrderModel> list = new ArrayList<ViewOrderModel>();
		String sql = "select * from DonHang\r\n"
				+ "where status not like 'delivered'";
		try {
			//Mở kết nối Database
			conn = new ConnectJDBC().getConnection();
			//Ném câu query vào sql
			ps = conn.prepareStatement(sql);
			//Thực thi câu query và nhận kết quả
			rs = ps.executeQuery();
			//Lấy Resultset đổ vào list
			while (rs.next()) {
				list.add(new ViewOrderModel(rs.getInt(1),
						rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<OrderDetailModel> getAllOrderById(String oid) {
		List<OrderDetailModel> list = new ArrayList<OrderDetailModel>();
		String sql = "select * from OrderDetail \r\n"
				+ "where orderId = ?";
		try {
			//Mở kết nối Database
			conn = new ConnectJDBC().getConnection();
			//Ném câu query vào sql
			ps = conn.prepareStatement(sql);
			ps.setString(1, oid);
			//Thực thi câu query và nhận kết quả
			rs = ps.executeQuery();
			//Lấy Resultset đổ vào list
			while (rs.next()) {
				list.add(new OrderDetailModel(rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<OrderInformation> getOrderInfoById(String oid) {
		List<OrderInformation> list = new ArrayList<OrderInformation>();
		String sql = "select * from ThongtinOrder\r\n"
				+ "where _id = ?";
		try {
			//Mở kết nối Database
			conn = new ConnectJDBC().getConnection();
			//Ném câu query vào sql
			ps = conn.prepareStatement(sql);
			ps.setString(1, oid);
			//Thực thi câu query và nhận kết quả
			rs = ps.executeQuery();
			//Lấy Resultset đổ vào list
			while (rs.next()) {
				list.add(new OrderInformation(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getDouble(7),
						rs.getInt(8), rs.getBoolean(9), rs.getDate(10), rs.getString(11)));	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public void update_quantity(_Order order) {
		String sql = "update Product set quantity = quantity - OrderItem.count_SP, sold = sold + OrderItem.count_SP\r\n"
				+ "from Product join OrderItem on Product._id = OrderItem.productId\r\n"
				+ "where OrderItem.orderId = ?";
		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, order.get_id());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void edit(_Order order) {
		String sql = "update _Order set status = ?\r\n"
				+ "where _id = ?";
		try {
			conn = new ConnectJDBC().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, order.getStatus());
			ps.setInt(2, order.get_id());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
