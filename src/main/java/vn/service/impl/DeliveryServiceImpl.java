package vn.service.impl;

import java.util.List;

import vn.dao.*;
import vn.dao.impl.*;
import vn.models.*;
import vn.service.*;

public class DeliveryServiceImpl implements DeliveryService{
	DeliveryDAO modelDao = new DeliveryDaoImpl();

	@Override
	public List<Delivery> findAllDelivery() {
		return modelDao.findAllDelivery();
	}
	
	@Override
	public Delivery findDeliveryByID(int _id) {
		return modelDao.findDeliveryByID(_id);
	}

	@Override
	public void insert(Delivery delivery) {
		modelDao.insert(delivery);
	}

	@Override
	public void edit(Delivery delivery) {
		modelDao.edit(delivery);
	}

	@Override
	public void delete(int id) {
		modelDao.delete(id);
	}
}
