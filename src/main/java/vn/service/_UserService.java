package vn.service;

import java.util.List;

import vn.models._User;

public interface _UserService {
	List<_User> findAllUser();
	_User findUserByID(int _id);
	void insert(_User user);
	void edit(_User user);
	void delete(int id);
	int[] SignUpInDay(int month, int year);
	int[] SignUpInMonth(int year);
	int[] SignUpInYear();
	int TotalSignUpInDay(int month, int year);
	int TotalSignUpInMonth(int year);
	int TotalSignUpInYear();
}
