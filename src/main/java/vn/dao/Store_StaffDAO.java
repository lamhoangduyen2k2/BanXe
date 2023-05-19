package vn.dao;

import java.util.List;

import vn.models.*;

public interface Store_StaffDAO {
	List<Store_Staff> findAllStaff(int id);
	void insert(Store_Staff ss);
	void delete(int idStore, int idStaff);
}
