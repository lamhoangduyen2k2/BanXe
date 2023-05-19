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
import vn.dao.*;
import vn.models.*;
import vn.service.*;
import vn.service.impl.*;

public class _OrderDaoImpl extends ConnectJDBC implements _OrderDAO{
	StoreService storeService = new StoreServiceImpl();
	_UserService userService = new _UserServiceImpl();
	DeliveryService deliveryService = new DeliveryServiceImpl();
	ProductService productService = new ProductServiceImpl();
	@Override
	public List<_Order> findAll_Order() {
		List<_Order> orderList = new ArrayList<_Order>();
		String sql = "Select * from _Order";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				_Order order = new _Order();
				order.set_id(rs.getInt("_id"));
				order.setUserId(rs.getInt("userId"));
				order.setStoreId(rs.getInt("storeId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setCommissionId(rs.getInt("commissionId"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getInt("amountFromUser"));
				order.setAmountFromStore(rs.getInt("amountFromStore"));
				order.setAmountToStore(rs.getInt("amountToStore"));
				order.setAmountToGD(rs.getInt("amountToGD"));
				order.setCreatedAt(rs.getDate("createdAt"));
				order.setUpdatedAt(rs.getDate("updatedAt"));
				if(rs.getInt("userId") != 0)
				{
					_User user = userService.findUserByID(rs.getInt("userId"));
					order.set_user(user);;
				}
				if(rs.getInt("deliveryId") != 0)
				{
					Delivery delivery = deliveryService.findDeliveryByID(rs.getInt("deliveryId"));
					order.setDelivery(delivery);
				}
				if(rs.getInt("storeId") != 0)
				{
					Store store = storeService.findStoreByID(rs.getInt("storeId"));
					order.setStore(store);
				}
				orderList.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderList;
	}
	
	@Override
	public _Order find_OrderByID(int _id) {
		String sql = "Select * From _Order where _id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, _id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { // duyệt từng dòng trong ResultSet trả về danh sách đối tượng
				_Order order = new _Order();
				order.set_id(rs.getInt("_id"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getInt("amountFromUser"));
				order.setAmountFromStore(rs.getInt("amountFromStore"));
				order.setAmountToStore(rs.getInt("amountToStore"));
				order.setAmountToGD(rs.getInt("amountToGD"));
				order.setUserId(rs.getInt("userId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setStoreId(rs.getInt("storeId"));
				order.setCreatedAt(rs.getDate("createdAt"));
				order.setUpdatedAt(rs.getDate("updatedAt"));
				if(rs.getInt("userId") != 0)
				{
					_User user = userService.findUserByID(rs.getInt("userId"));
					order.set_user(user);
				}
				if(rs.getInt("deliveryId") != 0)
				{
					Delivery delivery = deliveryService.findDeliveryByID(rs.getInt("deliveryId"));
					order.setDelivery(delivery);
				}
				if(rs.getInt("storeId") != 0)
				{
					Store store = storeService.findStoreByID(rs.getInt("storeId"));
					order.setStore(store);
				}
				return order;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void insert(_Order order)
	{
		String sql = "INSERT INTO dbo._Order\r\n"
				+ "(\r\n"
				+ "    userId,\r\n"
				+ "    storeId,\r\n"
				+ "    deliveryId,\r\n"
				+ "    address,\r\n"
				+ "    phone,\r\n"
				+ "    amountFromUser,\r\n"
				+ "    amountToStore,\r\n"
				+ "    amountFromStore,\r\n"
				+ "    amountToGD\r\n"
				+ ")\r\n"
				+ "VALUES\r\n"
				+ "(   ?,     -- userId\r\n"
				+ "    ?,    -- storeId\r\n"
				+ "    ?, -- deliveryId\r\n"
				+ "    ?, -- address\r\n"
				+ "    ?,    -- phone\r\n"
				+ "    ?, -- amountFromUser\r\n"
				+ "    ?,    -- amountToStore\r\n"
				+ "    ?, -- amountFromStore\r\n"
				+ "    ? -- amountToGD\r\n"
				+ "    )";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, order.getUserId());
		ps.setInt(2, order.getStoreId());
		ps.setInt(3, order.getDeliveryId());
		ps.setString(4, order.getAddress());
		ps.setString(5, order.getPhone());
		ps.setInt(6, order.getAmountFromUser());
		ps.setInt(7, order.getAmountToStore());
		ps.setInt(8, order.getAmountFromStore());
		ps.setInt(9, order.getAmountToGD());
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	@Override
	public void edit(_Order order)
	{
		String sql = "UPDATE dbo._Order SET userId = ?, storeId = ?, deliveryId = ?, address = ?, phone = ?, status = ?, isPaidBefore = ?, amountFromUser = ?, amountFromStore = ?, amountToStore = ?, amountToGD = ? WHERE _id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, order.getUserId());
			ps.setInt(2, order.getStoreId());
			ps.setInt(3, order.getDeliveryId());
			ps.setString(4, order.getAddress());
			ps.setString(5, order.getPhone());
			ps.setString(6, order.getStatus());
			ps.setBoolean(7, order.getisPaidBefore());
			ps.setInt(8, order.getAmountFromUser());
			ps.setInt(9, order.getAmountFromStore());
			ps.setInt(10, order.getAmountToStore());
			ps.setInt(11, order.getAmountToGD());
			ps.setInt(12, order.get_id());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(int id)
	{
		String sql = "DELETE FROM dbo._Order WHERE _id = ?";
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
	public int[] RevenueDay(int month, int year)
	{
		int[] arr = new int[31];
		String sql = "Select * from _Order";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Date date = rs.getDate("createdAt");
				LocalDate localDate = date.toLocalDate();

				if(localDate.getYear() == year && localDate.getMonthValue() == month)
				{
					arr[localDate.getDayOfMonth() - 1] += rs.getInt("amountFromUser");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	@Override
	public int[] RevenueMonth(int year)
	{
		int[] arr = new int[12];
		String sql = "Select * from _Order";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Date date = rs.getDate("createdAt");
				LocalDate localDate = date.toLocalDate();

				if(localDate.getYear() == year)
				{
					arr[localDate.getMonthValue() - 1] += rs.getInt("amountFromUser");
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
	public int[] RevenueYear()
	{
		int[] arr = new int[5];
		String sql = "Select * from _Order";
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
					arr[localDate.getYear() - localNow.getYear() + 4] += rs.getInt("amountFromUser");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	@Override
	public int TotalRevenueDay(int month, int year)
	{
		long millis=System.currentTimeMillis();
		Date now = new Date(millis);
		LocalDate localNow = now.toLocalDate();
		int[] dayList = RevenueDay(localNow.getMonthValue(),localNow.getYear());
		return IntStream.of(dayList).sum();
	}
	
	@Override
	public int TotalRevenueMonth(int year)
	{
		long millis=System.currentTimeMillis();
		Date now = new Date(millis);
		LocalDate localNow = now.toLocalDate();
		int[] monthList = RevenueMonth(localNow.getYear());
		return IntStream.of(monthList).sum();
	}
	
	@Override
	public int TotalRevenueYear()
	{
		long millis=System.currentTimeMillis();
		Date now = new Date(millis);
		LocalDate localNow = now.toLocalDate();
		int[] yearList = RevenueYear();
		return IntStream.of(yearList).sum();
	}
	
	@Override
	public int getOrderId(int uid) {
		
		String sql = "select top 1 _id from _Order where userId = ? order by _id desc";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return 0;
	}
	
	@Override
	public int insertOrder(_Order order) {
		String sql = "insert into _Order(userId, deliveryId, address, phone, amountFromUser, amountFromStore, amountToStore, amountToGD)\r\n"
				+ "values (?, ?, ?, ?, ?, 1, 1, 1)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, order.getUserId());
			ps.setInt(2, order.getDeliveryId());
			ps.setString(3, order.getAddress());
			ps.setString(4, order.getPhone());
			ps.setInt(5, order.getAmountFromUser());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return getOrderId(order.getUserId());
	}
	
	@Override
	public List<_Order> getAllOrderByUserId(int uid) {
		String sql = "select * from _Order where userId = ?";
		List<_Order> list = new ArrayList<_Order>();
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				_Order order = new _Order();
				order.set_id(rs.getInt("_id"));
				order.setUserId(rs.getInt("userId"));
				order.setStoreId(rs.getInt("storeId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setCommissionId(rs.getInt("commissionId"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getInt("amountFromUser"));
				order.setAmountFromStore(rs.getInt("amountFromStore"));
				order.setAmountToStore(rs.getInt("amountToStore"));
				order.setAmountToGD(rs.getInt("amountToGD"));
				order.setCreatedAt(rs.getDate("createdAt"));
				order.setUpdatedAt(rs.getDate("updatedAt"));
				if(rs.getInt("userId") != 0) {
					_User user = userService.findUserByID(rs.getInt("userId"));
					order.set_user(user);
				}
				if(rs.getInt("deliveryId") != 0) {
					Delivery delivery = deliveryService.findDeliveryByID(rs.getInt("deliveryId"));
					order.setDelivery(delivery);
				}
				list.add(order);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<OrderItem> getAllOrderItemByOrderId(int oid) {
		String sql = "select * from OrderItem where orderId = ?";
		List<OrderItem> list = new ArrayList<OrderItem>();
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, oid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderItem orderItem = new OrderItem();
				orderItem.set_id(rs.getInt("_id"));
				orderItem.setOrderId(rs.getInt("orderId"));
				orderItem.setProductId(rs.getInt("productId"));
				orderItem.setCount_SP(rs.getInt("count_SP"));
				orderItem.setCreatedAt(rs.getDate("createdAt"));
				orderItem.setUpdatedAt(rs.getDate("updatedAt"));
				if(rs.getInt("orderId") != 0) {
					_Order order = find_OrderByID(rs.getInt("orderId"));
					orderItem.setOrder(order);
				}
				if(rs.getInt("productId") != 0) {
					Product product = productService.findProductByID(rs.getInt("productId"));
					orderItem.setProduct(product);
				}
				list.add(orderItem);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
