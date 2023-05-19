package vn.dao;

import java.util.List;

import vn.models.*;

public interface OrderItemDAO {
	List<OrderItem> findAllOrderItem(int ido);
	OrderItem findOrderItemByID(int _id);
	void insert(OrderItem oi);
	void edit(OrderItem oi);
	void delete(int id);
}
