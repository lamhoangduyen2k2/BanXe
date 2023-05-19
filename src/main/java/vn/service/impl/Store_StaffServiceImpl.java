package vn.service.impl;

import java.util.List;

import vn.dao.*;
import vn.dao.impl.*;
import vn.models.*;
import vn.service.*;

public class Store_StaffServiceImpl implements Store_StaffService{
	Store_StaffDAO modelDao = new Store_StaffDaoImpl();

	@Override
	public List<Store_Staff> findAllStaff(int id) {
		return modelDao.findAllStaff(id);
	}

	@Override
	public void insert(Store_Staff ss) {
		modelDao.insert(ss);
	}
	
	@Override
	public void delete(int idStore, int idStaff) {
		modelDao.delete(idStore, idStaff);
	}
}
