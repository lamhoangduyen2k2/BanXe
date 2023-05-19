package vn.dao;

import java.util.List;

import vn.models.*;

public interface DeliveryDAO {
	List<Delivery> findAllDelivery();
	Delivery findDeliveryByID(int _id);
	void insert(Delivery delivery);
	void edit(Delivery delivery);
	void delete(int id);
}
