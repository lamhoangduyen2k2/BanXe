package vn.service.impl;

import java.util.List;

import vn.dao.*;
import vn.dao.impl.*;
import vn.models.*;
import vn.service.*;

public class _OrderServiceImpl implements _OrderService{
	_OrderDAO modelDao = new _OrderDaoImpl();

	@Override
	public List<_Order> findAll_Order() {
		return modelDao.findAll_Order();
	}
	
	@Override
	public _Order find_OrderByID(int _id) {
		return modelDao.find_OrderByID(_id);
	}

	@Override
	public void insert(_Order order) {
		modelDao.insert(order);
	}

	@Override
	public void edit(_Order order) {
		modelDao.edit(order);
	}

	@Override
	public void delete(int id) {
		modelDao.delete(id);
	}
	
	@Override
	public int[] RevenueDay(int month, int year) {
		return modelDao.RevenueDay(month, year);
	}

	@Override
	public int[] RevenueMonth(int year) {
		return modelDao.RevenueMonth(year);
	}

	@Override
	public int[] RevenueYear() {
		return modelDao.RevenueYear();
	}
	
	@Override
	public int TotalRevenueDay(int month, int year) {
		return modelDao.TotalRevenueDay(month, year);
	}
	
	@Override
	public int TotalRevenueMonth(int year) {
		return modelDao.TotalRevenueMonth(year);
	}
	
	@Override
	public int TotalRevenueYear() {
		return modelDao.TotalRevenueYear();
	}
}
