package vn.service;

import java.util.List;

import vn.models.*;

public interface DeliveryService {
	List<Delivery> findAllDelivery();
	Delivery findDeliveryByID(int _id);
	void insert(Delivery delivery);
	void edit(Delivery delivery);
	void delete(int id);
}
