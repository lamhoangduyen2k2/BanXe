package vn.dao;

import java.util.List;

import vn.models.*;

public interface _OrderDAO {
	List<_Order> findAll_Order();
	_Order find_OrderByID(int _id);
	void insert(_Order order);
	void edit(_Order order);
	void delete(int id);
	int[] RevenueDay(int month, int year);
	int[] RevenueMonth(int year);
	int[] RevenueYear();
	int TotalRevenueDay(int month, int year);
	int TotalRevenueMonth(int year);
	int TotalRevenueYear();
	int getOrderId(int uid);
	int insertOrder(_Order order);
	List<_Order> getAllOrderByUserId(int uid);
	List<OrderItem> getAllOrderItemByOrderId(int oid);
}
