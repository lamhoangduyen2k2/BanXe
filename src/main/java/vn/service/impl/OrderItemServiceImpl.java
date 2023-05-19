package vn.service.impl;

import java.util.List;

import vn.dao.*;
import vn.dao.impl.*;
import vn.models.*;
import vn.service.*;

public class OrderItemServiceImpl implements OrderItemService{
	OrderItemDAO modelDao = new OrderItemDaoImpl();

	@Override
	public List<OrderItem> findAllOrderItem(int ido) {
		return modelDao.findAllOrderItem(ido);
	}
	
	@Override
	public OrderItem findOrderItemByID(int _id) {
		return modelDao.findOrderItemByID(_id);
	}

	@Override
	public void insert(OrderItem order) {
		modelDao.insert(order);
	}

	@Override
	public void edit(OrderItem order) {
		modelDao.edit(order);
	}

	@Override
	public void delete(int id) {
		modelDao.delete(id);
	}
}
